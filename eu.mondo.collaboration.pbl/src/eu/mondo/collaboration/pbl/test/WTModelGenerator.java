package eu.mondo.collaboration.pbl.test;

import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

import WTSpec.CtrlUnit45;
import WTSpec.Subsystem;
import WTSpec.SystemInput;
import WTSpec.WT;
import WTSpec.WTSpecFactory;

import com.google.common.collect.Lists;

public class WTModelGenerator {

	public static List<Subsystem> subsystems = null;
	
	public static WT generateWTModel(int breadth, int deep, int unit) {
		subsystems = Lists.newArrayList();
		WT root = createWTObject();
		
		if(deep > 0)
			for(int i = 0; i < breadth; i++) {
				Subsystem subsystem = createSubsystem(root, breadth, unit, deep, 1);
				root.getItsSubsystems().add(subsystem);
			}
		
		return root;
	}

	private static Subsystem createSubsystem(WT root, int breadth, int unit, int deep, int level) {
		Subsystem subsystem = createSubsystemObject();	
		
		for(int i = 0; i < unit; i++) {
			CtrlUnit45 ctrl = createCtrlUnit45Object();
			SystemInput input = createSystemInputObject();
			
			//Add CtrlUnit45 to Subsystem
			subsystem.getItsWTCs().add(ctrl);
			
			//Add SystemInput to WT
			root.getItsInputs().add(input);
			
			//Set to CtrlUnit45.input
			ctrl.setInput__iInput(input);
		}
		
		if(deep > level) {
			for(int i = 0; i < breadth; i++) {
				Subsystem child = createSubsystem(root, breadth, unit, deep, level+1);
				subsystem.getItsSubsystems().add(child);
			}
		}
		
		return subsystem;
	}
	
	private static WT createWTObject() {
		return WTSpecFactory.eINSTANCE.createWT();
	}
	
	private static CtrlUnit45 createCtrlUnit45Object() {
		return WTSpecFactory.eINSTANCE.createCtrlUnit45();
	}	
	
	private static SystemInput createSystemInputObject() {
		return WTSpecFactory.eINSTANCE.createSystemInput();
	}
	
	private static Subsystem createSubsystemObject() {		
		Subsystem subsystem = WTSpecFactory.eINSTANCE.createSubsystem();
		subsystems.add(subsystem);
		return subsystem;
	}
	
	public static List<Subsystem> eAllOfSubsystem(WT model) {
		List<Subsystem> result = Lists.newArrayList();
		TreeIterator<EObject> allContents = model.eAllContents();
		while (allContents.hasNext()) {
			EObject object = allContents.next();
			if (object instanceof Subsystem) {
				result.add((Subsystem) object);
			}
		}
		return result;
	}
}
