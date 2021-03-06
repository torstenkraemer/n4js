/**
 */
package eu.numberfour.n4js.regex.regularExpression.impl;

import eu.numberfour.n4js.regex.regularExpression.RegularExpressionFlags;
import eu.numberfour.n4js.regex.regularExpression.RegularExpressionPackage;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Flags</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.numberfour.n4js.regex.regularExpression.impl.RegularExpressionFlagsImpl#getFlags <em>Flags</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RegularExpressionFlagsImpl extends MinimalEObjectImpl.Container implements RegularExpressionFlags
{
  /**
   * The cached value of the '{@link #getFlags() <em>Flags</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFlags()
   * @generated
   * @ordered
   */
  protected EList<String> flags;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RegularExpressionFlagsImpl()
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
    return RegularExpressionPackage.Literals.REGULAR_EXPRESSION_FLAGS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getFlags()
  {
    if (flags == null)
    {
      flags = new EDataTypeEList<String>(String.class, this, RegularExpressionPackage.REGULAR_EXPRESSION_FLAGS__FLAGS);
    }
    return flags;
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
      case RegularExpressionPackage.REGULAR_EXPRESSION_FLAGS__FLAGS:
        return getFlags();
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
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case RegularExpressionPackage.REGULAR_EXPRESSION_FLAGS__FLAGS:
        getFlags().clear();
        getFlags().addAll((Collection<? extends String>)newValue);
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
      case RegularExpressionPackage.REGULAR_EXPRESSION_FLAGS__FLAGS:
        getFlags().clear();
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
      case RegularExpressionPackage.REGULAR_EXPRESSION_FLAGS__FLAGS:
        return flags != null && !flags.isEmpty();
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

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (flags: ");
    result.append(flags);
    result.append(')');
    return result.toString();
  }

} //RegularExpressionFlagsImpl
