/**
 */
package eu.numberfour.n4js.regex.regularExpression;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Word Boundary</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.numberfour.n4js.regex.regularExpression.WordBoundary#isNot <em>Not</em>}</li>
 * </ul>
 *
 * @see eu.numberfour.n4js.regex.regularExpression.RegularExpressionPackage#getWordBoundary()
 * @model
 * @generated
 */
public interface WordBoundary extends Assertion
{
  /**
   * Returns the value of the '<em><b>Not</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Not</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Not</em>' attribute.
   * @see #setNot(boolean)
   * @see eu.numberfour.n4js.regex.regularExpression.RegularExpressionPackage#getWordBoundary_Not()
   * @model
   * @generated
   */
  boolean isNot();

  /**
   * Sets the value of the '{@link eu.numberfour.n4js.regex.regularExpression.WordBoundary#isNot <em>Not</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Not</em>' attribute.
   * @see #isNot()
   * @generated
   */
  void setNot(boolean value);

} // WordBoundary
