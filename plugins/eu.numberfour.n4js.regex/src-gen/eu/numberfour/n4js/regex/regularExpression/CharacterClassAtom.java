/**
 */
package eu.numberfour.n4js.regex.regularExpression;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Character Class Atom</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.numberfour.n4js.regex.regularExpression.CharacterClassAtom#getCharacter <em>Character</em>}</li>
 * </ul>
 *
 * @see eu.numberfour.n4js.regex.regularExpression.RegularExpressionPackage#getCharacterClassAtom()
 * @model
 * @generated
 */
public interface CharacterClassAtom extends CharacterClassElement
{
  /**
   * Returns the value of the '<em><b>Character</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Character</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Character</em>' attribute.
   * @see #setCharacter(String)
   * @see eu.numberfour.n4js.regex.regularExpression.RegularExpressionPackage#getCharacterClassAtom_Character()
   * @model
   * @generated
   */
  String getCharacter();

  /**
   * Sets the value of the '{@link eu.numberfour.n4js.regex.regularExpression.CharacterClassAtom#getCharacter <em>Character</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Character</em>' attribute.
   * @see #getCharacter()
   * @generated
   */
  void setCharacter(String value);

} // CharacterClassAtom
