/**
 */
package eu.mondo.collaboration.pbl.lockmodel;

import WTSpec.Subsystem;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Lock Sub System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.mondo.collaboration.pbl.lockmodel.LockSubSystem#getSubsystems <em>Subsystems</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.mondo.collaboration.pbl.lockmodel.LockModelPackage#getLockSubSystem()
 * @model
 * @generated
 */
public interface LockSubSystem extends EObject {
	/**
	 * Returns the value of the '<em><b>Subsystems</b></em>' reference list.
	 * The list contents are of type {@link WTSpec.Subsystem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subsystems</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subsystems</em>' reference list.
	 * @see eu.mondo.collaboration.pbl.lockmodel.LockModelPackage#getLockSubSystem_Subsystems()
	 * @model
	 * @generated
	 */
	EList<Subsystem> getSubsystems();

} // LockSubSystem
