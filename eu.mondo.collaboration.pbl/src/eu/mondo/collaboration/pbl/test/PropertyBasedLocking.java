package eu.mondo.collaboration.pbl.test;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.evm.api.ExecutionSchema;
import org.eclipse.incquery.runtime.evm.api.Job;
import org.eclipse.incquery.runtime.evm.specific.ExecutionSchemas;
import org.eclipse.incquery.runtime.evm.specific.Jobs;
import org.eclipse.incquery.runtime.evm.specific.Rules;
import org.eclipse.incquery.runtime.evm.specific.Schedulers;
import org.eclipse.incquery.runtime.evm.specific.event.IncQueryActivationStateEnum;
import org.junit.Test;

import pbl.test.patterns.LockInputsForSubsystemMatch;
import pbl.test.patterns.LockInputsForSubsystemMatcher;
import pbl.test.patterns.util.LockInputsForSubsystemQuerySpecification;
import WTSpec.Subsystem;
import WTSpec.WT;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import eu.mondo.collaboration.pbl.lockmodel.LockModelFactory;
import eu.mondo.collaboration.pbl.lockmodel.LockSubSystem;

public class PropertyBasedLocking {

	@Test
	public void test() throws Exception {
		
		int[] parameters = new int[] {5,10,50,100,500,1000};
		
		System.out.println("Collab; IQ init; Matcher init; Post");
		for (int param : parameters) {
			for(int i = 0; i < 10; i++) {
				
				System.gc();
				System.gc();
				System.gc();
				System.gc();
				System.gc();
				
				String ret = parameterizedTest(10, 5, 3, param);
				System.out.println(param + "; " + ret);
			}
		}
	}
		
	/**
	 * Output: full measurement time (ms), IncQueryEngine initialization time (ms), Matcher indexing time (ms), post-filtering time (ms)
	 */	
	public String parameterizedTest(int breadth, int deep, int unit, int requiredLocks) throws Exception {
		
		String path = String.format("src/pbl/test/instance/instance_%s_%s_%s.xmi", breadth, deep, unit);
		ResourceSet set = new ResourceSetImpl();
		Resource resource = set.getResource(URI.createURI(path), true);
		WT model = (WT) resource.getContents().get(0);
		//WT model = WTModelGenerator.generateWTModel(breadth, deep, unit);
		List<Subsystem> allSubsystems = WTModelGenerator.eAllOfSubsystem(model);
		resource.getContents().add(model);		
		
		System.out.println("Resource loaded");
		
		if(allSubsystems.size() < requiredLocks)
			throw new Exception();
		
		Collection<LockInputsForSubsystemMatch> locks = createLocks(requiredLocks, allSubsystems);
		Collection<LockInputsForSubsystemMatch> locked = Sets.newHashSet();	
		
		LockSubSystem lockModel = createLockModel(locks);
		resource.getContents().add(lockModel);
		
		System.out.println("Locks created");
		
		//---start IQEngine init
		long iqStart = System.currentTimeMillis();
		IncQueryEngine engine = IncQueryEngine.on(resource);	
		ExecutionSchema executionSchema = ExecutionSchemas.createIncQueryExecutionSchema(engine, Schedulers.getIQEngineSchedulerFactory(engine));
//		executionSchema.getLogger().setLevel(Level.ALL);
		
		Builder<Job<LockInputsForSubsystemMatch>> builder = ImmutableSet.builder();
		builder.add(Jobs.newNopJob(IncQueryActivationStateEnum.APPEARED));
		builder.add(Jobs.newNopJob(IncQueryActivationStateEnum.UPDATED));
		builder.add(Jobs.newStatelessJob(IncQueryActivationStateEnum.DISAPPEARED, new IMatchProcessor<LockInputsForSubsystemMatch>() {

			@Override
			public void process(LockInputsForSubsystemMatch match) {
				locked.contains(match);
			}
			
		}));
		
		executionSchema.addRule(Rules.newMatcherRuleSpecification(LockInputsForSubsystemQuerySpecification.instance(), builder.build()));
		executionSchema.startUnscheduledExecution();
		
		IMatchProcessor<LockInputsForSubsystemMatch> storeProcess = new  IMatchProcessor<LockInputsForSubsystemMatch>() {

			@Override
			public void process(LockInputsForSubsystemMatch match) {
				locked.add(match);
			}
		};		
		
		long iqEnd = System.currentTimeMillis();
		//---end IQEngine init
		
		//---start Matcher indexing
		long matchStart = System.currentTimeMillis();
		LockInputsForSubsystemMatcher matcher = LockInputsForSubsystemMatcher.on(engine);
		long matchEnd = System.currentTimeMillis();
		//---end Matcher indexing
		
		//---start Post filtering
		long lockStart = System.currentTimeMillis();
		for(LockInputsForSubsystemMatch lock : locks) {
			
			matcher.forEachMatch(lock, storeProcess);
		}
		long lockEnd = System.currentTimeMillis();
		//---end Post filtering
		
		//---start Modifying
		long modifyStart = System.currentTimeMillis();
		model.getItsInputs().remove(locked.iterator().next().getInput());
		long modifyEnd = System.currentTimeMillis();
		//---end Modifying
				
		executionSchema.dispose();		
		return String.format("%s; %s; %s; %s", iqEnd-iqStart, matchEnd-matchStart, lockEnd-lockStart, modifyEnd-modifyStart);
	}

	private LockSubSystem createLockModel(Collection<LockInputsForSubsystemMatch> locks) {
		LockSubSystem model = LockModelFactory.eINSTANCE.createLockSubSystem();
		for (LockInputsForSubsystemMatch lock : locks) {
			model.getSubsystems().add(lock.getSs());
		}
		
		return model;
	}

	private Collection<LockInputsForSubsystemMatch> createLocks(int requiredLocks, List<Subsystem> allSubsystems) {
		
		Function<Subsystem, LockInputsForSubsystemMatch> rawToLocks = new Function<Subsystem,LockInputsForSubsystemMatch>() { 
			public LockInputsForSubsystemMatch apply(Subsystem ss) { 
				return LockInputsForSubsystemMatch.newMatch(ss, null);
			}
		};
		
		List<Subsystem> rawLocks = allSubsystems.subList(0, requiredLocks);
		return Lists.transform(rawLocks, rawToLocks);
	}	
	
}
