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
 * A representation of the model object '<em><b>N4 Field Accessor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.numberfour.n4js.n4JS.N4FieldAccessor#getComputeNameFrom <em>Compute Name From</em>}</li>
 * </ul>
 *
 * @see eu.numberfour.n4js.n4JS.N4JSPackage#getN4FieldAccessor()
 * @model abstract="true"
 * @generated
 */
public interface N4FieldAccessor extends FieldAccessor, AnnotableN4MemberDeclaration {
	/**
	 * Returns the value of the '<em><b>Compute Name From</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compute Name From</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compute Name From</em>' containment reference.
	 * @see #setComputeNameFrom(Expression)
	 * @see eu.numberfour.n4js.n4JS.N4JSPackage#getN4FieldAccessor_ComputeNameFrom()
	 * @model containment="true"
	 * @generated
	 */
	Expression getComputeNameFrom();

	/**
	 * Sets the value of the '{@link eu.numberfour.n4js.n4JS.N4FieldAccessor#getComputeNameFrom <em>Compute Name From</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Compute Name From</em>' containment reference.
	 * @see #getComputeNameFrom()
	 * @generated
	 */
	void setComputeNameFrom(Expression value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _or = false;\nboolean _and = false;\nboolean _and_1 = false;\n<%org.eclipse.emf.ecore.EObject%> _eContainer = this.eContainer();\nif (!(_eContainer instanceof <%eu.numberfour.n4js.n4JS.N4InterfaceDeclaration%>))\n{\n\t_and_1 = false;\n} else\n{\n\t<%eu.numberfour.n4js.n4JS.Block%> _body = this.getBody();\n\tboolean _tripleEquals = (_body == null);\n\t_and_1 = _tripleEquals;\n}\nif (!_and_1)\n{\n\t_and = false;\n} else\n{\n\t<%org.eclipse.emf.common.util.EList%><<%eu.numberfour.n4js.n4JS.Annotation%>> _annotations = this.getAnnotations();\n\tfinal <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%eu.numberfour.n4js.n4JS.Annotation%>, <%java.lang.Boolean%>> _function = new <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%eu.numberfour.n4js.n4JS.Annotation%>, <%java.lang.Boolean%>>()\n\t{\n\t\tpublic <%java.lang.Boolean%> apply(final <%eu.numberfour.n4js.n4JS.Annotation%> it)\n\t\t{\n\t\t\t<%java.lang.String%> _name = it.getName();\n\t\t\treturn <%java.lang.Boolean%>.valueOf(<%com.google.common.base.Objects%>.equal(_name, \"ProvidesDefaultImplementation\"));\n\t\t}\n\t};\n\tboolean _exists = <%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%eu.numberfour.n4js.n4JS.Annotation%>>exists(_annotations, _function);\n\tboolean _not = (!_exists);\n\t_and = _not;\n}\nif (_and)\n{\n\t_or = true;\n} else\n{\n\t<%org.eclipse.emf.common.util.EList%><<%eu.numberfour.n4js.n4JS.N4Modifier%>> _declaredModifiers = this.getDeclaredModifiers();\n\tboolean _contains = _declaredModifiers.contains(<%eu.numberfour.n4js.n4JS.N4Modifier%>.ABSTRACT);\n\t_or = _contains;\n}\nreturn _or;'"
	 * @generated
	 */
	boolean isAbstract();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Field accessors in classes may not be called 'prototype' or 'constructor' (except for computed names).
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%java.lang.String%> _name = this.getName();\nboolean _equals = <%com.google.common.base.Objects%>.equal(\"prototype\", _name);\nif (_equals)\n{\n\treturn false;\n}\nboolean _and = false;\n<%java.lang.String%> _name_1 = this.getName();\nboolean _equals_1 = <%com.google.common.base.Objects%>.equal(\"constructor\", _name_1);\nif (!_equals_1)\n{\n\t_and = false;\n} else\n{\n\t<%eu.numberfour.n4js.n4JS.PropertyNameKind%> _kind = this.getKind();\n\tboolean _tripleNotEquals = (_kind != <%eu.numberfour.n4js.n4JS.PropertyNameKind%>.COMPUTED_FROM_STRING_LITERAL);\n\t_and = _tripleNotEquals;\n}\nif (_and)\n{\n\treturn false;\n}\nreturn true;'"
	 * @generated
	 */
	boolean isValidName();

} // N4FieldAccessor
