/**
 * Copyright (c) 2016 NumberFour AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package eu.numberfour.n4js.n4JS;

import eu.numberfour.n4js.ts.types.IdentifiableElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Identifier Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.numberfour.n4js.n4JS.IdentifierRef#getId <em>Id</em>}</li>
 *   <li>{@link eu.numberfour.n4js.n4JS.IdentifierRef#getIdAsText <em>Id As Text</em>}</li>
 * </ul>
 *
 * @see eu.numberfour.n4js.n4JS.N4JSPackage#getIdentifierRef()
 * @model
 * @generated
 */
public interface IdentifierRef extends PrimaryExpression, StrictModeRelevant {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' reference.
	 * @see #setId(IdentifiableElement)
	 * @see eu.numberfour.n4js.n4JS.N4JSPackage#getIdentifierRef_Id()
	 * @model
	 * @generated
	 */
	IdentifiableElement getId();

	/**
	 * Sets the value of the '{@link eu.numberfour.n4js.n4JS.IdentifierRef#getId <em>Id</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' reference.
	 * @see #getId()
	 * @generated
	 */
	void setId(IdentifiableElement value);

	/**
	 * Returns the value of the '<em><b>Id As Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id As Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id As Text</em>' attribute.
	 * @see #setIdAsText(String)
	 * @see eu.numberfour.n4js.n4JS.N4JSPackage#getIdentifierRef_IdAsText()
	 * @model unique="false" transient="true"
	 * @generated
	 */
	String getIdAsText();

	/**
	 * Sets the value of the '{@link eu.numberfour.n4js.n4JS.IdentifierRef#getIdAsText <em>Id As Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id As Text</em>' attribute.
	 * @see #getIdAsText()
	 * @generated
	 */
	void setIdAsText(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * IdentifierReference : Identifier
	 * 1. If this IdentifierReference is contained in strict mode code and StringValue of Identifier is "eval" or "arguments", return false.
	 * 2. Return true.
	 * IdentifierReference : yield
	 * 1. Return true.
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _isStrictMode = this.isStrictMode();\nif (_isStrictMode)\n{\n\tboolean _and = false;\n\tboolean _and_1 = false;\n\t<%java.lang.String%> _idAsText = this.getIdAsText();\n\tboolean _tripleNotEquals = (_idAsText != null);\n\tif (!_tripleNotEquals)\n\t{\n\t\t_and_1 = false;\n\t} else\n\t{\n\t\t<%java.lang.String%> _idAsText_1 = this.getIdAsText();\n\t\tboolean _notEquals = (!<%com.google.common.base.Objects%>.equal(\"arguments\", _idAsText_1));\n\t\t_and_1 = _notEquals;\n\t}\n\tif (!_and_1)\n\t{\n\t\t_and = false;\n\t} else\n\t{\n\t\t<%java.lang.String%> _idAsText_2 = this.getIdAsText();\n\t\tboolean _notEquals_1 = (!<%com.google.common.base.Objects%>.equal(\"eval\", _idAsText_2));\n\t\t_and = _notEquals_1;\n\t}\n\treturn _and;\n}\nreturn true;'"
	 * @generated
	 */
	boolean isValidSimpleAssignmentTarget();

} // IdentifierRef
