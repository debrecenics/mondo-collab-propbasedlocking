/**
 */
package eu.mondo.collaboration.pbl.lockmodel;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see eu.mondo.collaboration.pbl.lockmodel.LockModelFactory
 * @model kind="package"
 * @generated
 */
public interface LockModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "eu.mondo.collaboration.pbl.lockmodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/eu.mondo.collaboration.pbl.lockmodel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "eu.mondo.collaboration.pbl.lockmodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LockModelPackage eINSTANCE = eu.mondo.collaboration.pbl.lockmodel.impl.LockModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link eu.mondo.collaboration.pbl.lockmodel.impl.LockSubSystemImpl <em>Lock Sub System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.mondo.collaboration.pbl.lockmodel.impl.LockSubSystemImpl
	 * @see eu.mondo.collaboration.pbl.lockmodel.impl.LockModelPackageImpl#getLockSubSystem()
	 * @generated
	 */
	int LOCK_SUB_SYSTEM = 0;

	/**
	 * The feature id for the '<em><b>Subsystems</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCK_SUB_SYSTEM__SUBSYSTEMS = 0;

	/**
	 * The number of structural features of the '<em>Lock Sub System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCK_SUB_SYSTEM_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Lock Sub System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCK_SUB_SYSTEM_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link eu.mondo.collaboration.pbl.lockmodel.LockSubSystem <em>Lock Sub System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lock Sub System</em>'.
	 * @see eu.mondo.collaboration.pbl.lockmodel.LockSubSystem
	 * @generated
	 */
	EClass getLockSubSystem();

	/**
	 * Returns the meta object for the reference list '{@link eu.mondo.collaboration.pbl.lockmodel.LockSubSystem#getSubsystems <em>Subsystems</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Subsystems</em>'.
	 * @see eu.mondo.collaboration.pbl.lockmodel.LockSubSystem#getSubsystems()
	 * @see #getLockSubSystem()
	 * @generated
	 */
	EReference getLockSubSystem_Subsystems();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	LockModelFactory getLockModelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link eu.mondo.collaboration.pbl.lockmodel.impl.LockSubSystemImpl <em>Lock Sub System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.mondo.collaboration.pbl.lockmodel.impl.LockSubSystemImpl
		 * @see eu.mondo.collaboration.pbl.lockmodel.impl.LockModelPackageImpl#getLockSubSystem()
		 * @generated
		 */
		EClass LOCK_SUB_SYSTEM = eINSTANCE.getLockSubSystem();

		/**
		 * The meta object literal for the '<em><b>Subsystems</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOCK_SUB_SYSTEM__SUBSYSTEMS = eINSTANCE.getLockSubSystem_Subsystems();

	}

} //LockModelPackage
