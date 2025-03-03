/**
 * generated by Xtext 2.19.0
 */
package pretty.wh.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import pretty.wh.Nop;
import pretty.wh.WhPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Nop</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pretty.wh.impl.NopImpl#getNop <em>Nop</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NopImpl extends MinimalEObjectImpl.Container implements Nop
{
  /**
   * The default value of the '{@link #getNop() <em>Nop</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNop()
   * @generated
   * @ordered
   */
  protected static final String NOP_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getNop() <em>Nop</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNop()
   * @generated
   * @ordered
   */
  protected String nop = NOP_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NopImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return WhPackage.Literals.NOP;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getNop()
  {
    return nop;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setNop(String newNop)
  {
    String oldNop = nop;
    nop = newNop;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, WhPackage.NOP__NOP, oldNop, nop));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case WhPackage.NOP__NOP:
        return getNop();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case WhPackage.NOP__NOP:
        setNop((String)newValue);
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
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case WhPackage.NOP__NOP:
        setNop(NOP_EDEFAULT);
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
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case WhPackage.NOP__NOP:
        return NOP_EDEFAULT == null ? nop != null : !NOP_EDEFAULT.equals(nop);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (nop: ");
    result.append(nop);
    result.append(')');
    return result.toString();
  }

} //NopImpl
