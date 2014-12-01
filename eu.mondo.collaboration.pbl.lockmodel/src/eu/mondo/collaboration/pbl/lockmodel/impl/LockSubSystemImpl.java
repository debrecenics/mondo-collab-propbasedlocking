/**
 */
package eu.mondo.collaboration.pbl.lockmodel.impl;

import WTSpec.Subsystem;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import eu.mondo.collaboration.pbl.lockmodel.LockModelPackage;
import eu.mondo.collaboration.pbl.lockmodel.LockSubSystem;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Lock Sub System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.mondo.collaboration.pbl.lockmodel.impl.LockSubSystemImpl#getSubsystems <em>Subsystems</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LockSubSystemImpl extends MinimalEObjectImpl.Container implements LockSubSystem {
	/**
	 * The cached value of the '{@link #getSubsystems() <em>Subsystems</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubsystems()
	 * @generated
	 * @ordered
	 */
	protected EList<Subsystem> subsystems;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LockSubSystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LockModelPackage.Literals.LOCK_SUB_SYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Subsystem> getSubsystems() {
		if (subsystems == null) {
			subsystems = new EObjectResolvingEList<Subsystem>(Subsystem.class, this, LockModelPackage.LOCK_SUB_SYSTEM__SUBSYSTEMS);
		}
		return subsystems;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LockModelPackage.LOCK_SUB_SYSTEM__SUBSYSTEMS:
				return getSubsystems();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case LockModelPackage.LOCK_SUB_SYSTEM__SUBSYSTEMS:
				getSubsystems().clear();
				getSubsystems().addAll((Collection<? extends Subsystem>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case LockModelPackage.LOCK_SUB_SYSTEM__SUBSYSTEMS:
				getSubsystems().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case LockModelPackage.LOCK_SUB_SYSTEM__SUBSYSTEMS:
				return subsystems != null && !subsystems.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //LockSubSystemImpl
