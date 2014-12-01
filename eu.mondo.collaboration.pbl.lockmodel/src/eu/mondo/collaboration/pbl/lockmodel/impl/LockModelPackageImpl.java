/**
 */
package eu.mondo.collaboration.pbl.lockmodel.impl;

import WTSpec.WTSpecPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import eu.mondo.collaboration.pbl.lockmodel.LockModelFactory;
import eu.mondo.collaboration.pbl.lockmodel.LockModelPackage;
import eu.mondo.collaboration.pbl.lockmodel.LockSubSystem;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LockModelPackageImpl extends EPackageImpl implements LockModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lockSubSystemEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see eu.mondo.collaboration.pbl.lockmodel.LockModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private LockModelPackageImpl() {
		super(eNS_URI, LockModelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link LockModelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static LockModelPackage init() {
		if (isInited) return (LockModelPackage)EPackage.Registry.INSTANCE.getEPackage(LockModelPackage.eNS_URI);

		// Obtain or create and register package
		LockModelPackageImpl theLockModelPackage = (LockModelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof LockModelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new LockModelPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		WTSpecPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theLockModelPackage.createPackageContents();

		// Initialize created meta-data
		theLockModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theLockModelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(LockModelPackage.eNS_URI, theLockModelPackage);
		return theLockModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLockSubSystem() {
		return lockSubSystemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLockSubSystem_Subsystems() {
		return (EReference)lockSubSystemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LockModelFactory getLockModelFactory() {
		return (LockModelFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		lockSubSystemEClass = createEClass(LOCK_SUB_SYSTEM);
		createEReference(lockSubSystemEClass, LOCK_SUB_SYSTEM__SUBSYSTEMS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		WTSpecPackage theWTSpecPackage = (WTSpecPackage)EPackage.Registry.INSTANCE.getEPackage(WTSpecPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(lockSubSystemEClass, LockSubSystem.class, "LockSubSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLockSubSystem_Subsystems(), theWTSpecPackage.getSubsystem(), null, "subsystems", null, 0, -1, LockSubSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //LockModelPackageImpl
