/**
 * generated by Xtext 2.19.0
 */
package prettyCompilation.wh.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import prettyCompilation.wh.Commands;
import prettyCompilation.wh.Expr;
import prettyCompilation.wh.Foreach;
import prettyCompilation.wh.WhPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Foreach</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link prettyCompilation.wh.impl.ForeachImpl#getVariable <em>Variable</em>}</li>
 *   <li>{@link prettyCompilation.wh.impl.ForeachImpl#getExpr <em>Expr</em>}</li>
 *   <li>{@link prettyCompilation.wh.impl.ForeachImpl#getCommands <em>Commands</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ForeachImpl extends MinimalEObjectImpl.Container implements Foreach
{
  /**
   * The default value of the '{@link #getVariable() <em>Variable</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVariable()
   * @generated
   * @ordered
   */
  protected static final String VARIABLE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getVariable() <em>Variable</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVariable()
   * @generated
   * @ordered
   */
  protected String variable = VARIABLE_EDEFAULT;

  /**
   * The cached value of the '{@link #getExpr() <em>Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpr()
   * @generated
   * @ordered
   */
  protected Expr expr;

  /**
   * The cached value of the '{@link #getCommands() <em>Commands</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCommands()
   * @generated
   * @ordered
   */
  protected Commands commands;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ForeachImpl()
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
    return WhPackage.Literals.FOREACH;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getVariable()
  {
    return variable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setVariable(String newVariable)
  {
    String oldVariable = variable;
    variable = newVariable;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, WhPackage.FOREACH__VARIABLE, oldVariable, variable));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Expr getExpr()
  {
    return expr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExpr(Expr newExpr, NotificationChain msgs)
  {
    Expr oldExpr = expr;
    expr = newExpr;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WhPackage.FOREACH__EXPR, oldExpr, newExpr);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setExpr(Expr newExpr)
  {
    if (newExpr != expr)
    {
      NotificationChain msgs = null;
      if (expr != null)
        msgs = ((InternalEObject)expr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WhPackage.FOREACH__EXPR, null, msgs);
      if (newExpr != null)
        msgs = ((InternalEObject)newExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WhPackage.FOREACH__EXPR, null, msgs);
      msgs = basicSetExpr(newExpr, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, WhPackage.FOREACH__EXPR, newExpr, newExpr));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Commands getCommands()
  {
    return commands;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCommands(Commands newCommands, NotificationChain msgs)
  {
    Commands oldCommands = commands;
    commands = newCommands;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WhPackage.FOREACH__COMMANDS, oldCommands, newCommands);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setCommands(Commands newCommands)
  {
    if (newCommands != commands)
    {
      NotificationChain msgs = null;
      if (commands != null)
        msgs = ((InternalEObject)commands).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WhPackage.FOREACH__COMMANDS, null, msgs);
      if (newCommands != null)
        msgs = ((InternalEObject)newCommands).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WhPackage.FOREACH__COMMANDS, null, msgs);
      msgs = basicSetCommands(newCommands, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, WhPackage.FOREACH__COMMANDS, newCommands, newCommands));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case WhPackage.FOREACH__EXPR:
        return basicSetExpr(null, msgs);
      case WhPackage.FOREACH__COMMANDS:
        return basicSetCommands(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case WhPackage.FOREACH__VARIABLE:
        return getVariable();
      case WhPackage.FOREACH__EXPR:
        return getExpr();
      case WhPackage.FOREACH__COMMANDS:
        return getCommands();
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
      case WhPackage.FOREACH__VARIABLE:
        setVariable((String)newValue);
        return;
      case WhPackage.FOREACH__EXPR:
        setExpr((Expr)newValue);
        return;
      case WhPackage.FOREACH__COMMANDS:
        setCommands((Commands)newValue);
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
      case WhPackage.FOREACH__VARIABLE:
        setVariable(VARIABLE_EDEFAULT);
        return;
      case WhPackage.FOREACH__EXPR:
        setExpr((Expr)null);
        return;
      case WhPackage.FOREACH__COMMANDS:
        setCommands((Commands)null);
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
      case WhPackage.FOREACH__VARIABLE:
        return VARIABLE_EDEFAULT == null ? variable != null : !VARIABLE_EDEFAULT.equals(variable);
      case WhPackage.FOREACH__EXPR:
        return expr != null;
      case WhPackage.FOREACH__COMMANDS:
        return commands != null;
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
    result.append(" (variable: ");
    result.append(variable);
    result.append(')');
    return result.toString();
  }

} //ForeachImpl
