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
 * A representation of the model object '<em><b>N4 Class Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see eu.numberfour.n4js.n4JS.N4JSPackage#getN4ClassDeclaration()
 * @model
 * @generated
 */
public interface N4ClassDeclaration extends N4ClassDefinition, N4ClassifierDeclaration {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Returns true if the class is declared as abstract.
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.emf.common.util.EList%><<%eu.numberfour.n4js.n4JS.N4Modifier%>> _declaredModifiers = this.getDeclaredModifiers();\nreturn _declaredModifiers.contains(<%eu.numberfour.n4js.n4JS.N4Modifier%>.ABSTRACT);'"
	 * @generated
	 */
	boolean isAbstract();

} // N4ClassDeclaration
