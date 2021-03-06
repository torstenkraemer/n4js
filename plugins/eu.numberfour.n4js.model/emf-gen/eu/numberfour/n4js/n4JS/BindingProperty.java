/**
 * Copyright (c) 2016 NumberFour AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package eu.numberfour.n4js.n4JS;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binding Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.numberfour.n4js.n4JS.BindingProperty#getDeclaredName <em>Declared Name</em>}</li>
 *   <li>{@link eu.numberfour.n4js.n4JS.BindingProperty#getValue <em>Value</em>}</li>
 *   <li>{@link eu.numberfour.n4js.n4JS.BindingProperty#getVarDecl <em>Var Decl</em>}</li>
 * </ul>
 *
 * @see eu.numberfour.n4js.n4JS.N4JSPackage#getBindingProperty()
 * @model
 * @generated
 */
public interface BindingProperty extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Declared Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Declared Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declared Name</em>' attribute.
	 * @see #setDeclaredName(String)
	 * @see eu.numberfour.n4js.n4JS.N4JSPackage#getBindingProperty_DeclaredName()
	 * @model unique="false"
	 * @generated
	 */
	String getDeclaredName();

	/**
	 * Sets the value of the '{@link eu.numberfour.n4js.n4JS.BindingProperty#getDeclaredName <em>Declared Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Declared Name</em>' attribute.
	 * @see #getDeclaredName()
	 * @generated
	 */
	void setDeclaredName(String value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(BindingElement)
	 * @see eu.numberfour.n4js.n4JS.N4JSPackage#getBindingProperty_Value()
	 * @model containment="true"
	 * @generated
	 */
	BindingElement getValue();

	/**
	 * Sets the value of the '{@link eu.numberfour.n4js.n4JS.BindingProperty#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(BindingElement value);

	/**
	 * Returns the value of the '<em><b>Var Decl</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Var Decl</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Var Decl</em>' containment reference.
	 * @see #setVarDecl(VariableDeclaration)
	 * @see eu.numberfour.n4js.n4JS.N4JSPackage#getBindingProperty_VarDecl()
	 * @model containment="true"
	 * @generated
	 */
	VariableDeclaration getVarDecl();

	/**
	 * Sets the value of the '{@link eu.numberfour.n4js.n4JS.BindingProperty#getVarDecl <em>Var Decl</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Var Decl</em>' containment reference.
	 * @see #getVarDecl()
	 * @generated
	 */
	void setVarDecl(VariableDeclaration value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%java.lang.String%> _elvis = null;\n<%java.lang.String%> _declaredName = this.getDeclaredName();\nif (_declaredName != null)\n{\n\t_elvis = _declaredName;\n} else\n{\n\t<%eu.numberfour.n4js.n4JS.BindingElement%> _value = this.getValue();\n\t<%eu.numberfour.n4js.n4JS.VariableDeclaration%> _varDecl = null;\n\tif (_value!=null)\n\t{\n\t\t_varDecl=_value.getVarDecl();\n\t}\n\t<%java.lang.String%> _name = null;\n\tif (_varDecl!=null)\n\t{\n\t\t_name=_varDecl.getName();\n\t}\n\t_elvis = _name;\n}\nreturn _elvis;'"
	 * @generated
	 */
	String getName();

} // BindingProperty
