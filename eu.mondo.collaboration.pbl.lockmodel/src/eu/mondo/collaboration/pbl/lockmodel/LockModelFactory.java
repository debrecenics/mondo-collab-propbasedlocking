/**
 */
package eu.mondo.collaboration.pbl.lockmodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see eu.mondo.collaboration.pbl.lockmodel.LockModelPackage
 * @generated
 */
public interface LockModelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LockModelFactory eINSTANCE = eu.mondo.collaboration.pbl.lockmodel.impl.LockModelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Lock Sub System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Lock Sub System</em>'.
	 * @generated
	 */
	LockSubSystem createLockSubSystem();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	LockModelPackage getLockModelPackage();

} //LockModelFactory
