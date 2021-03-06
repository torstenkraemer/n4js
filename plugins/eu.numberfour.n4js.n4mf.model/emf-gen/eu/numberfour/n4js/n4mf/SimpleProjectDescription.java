/**
 * Copyright (c) 2016 NumberFour AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package eu.numberfour.n4js.n4mf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Project Description</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Properties that makes a project unique among other projects (without considering the version).
 * The vendor id identifies the vendor of this project, a more meaningful name is provided in
 * Project.vendorName. The artifact id identifies the project, a more meaningful name is provided
 * in Project.projectName.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.numberfour.n4js.n4mf.SimpleProjectDescription#getDeclaredVendorId <em>Declared Vendor Id</em>}</li>
 *   <li>{@link eu.numberfour.n4js.n4mf.SimpleProjectDescription#getArtifactId <em>Artifact Id</em>}</li>
 * </ul>
 *
 * @see eu.numberfour.n4js.n4mf.N4mfPackage#getSimpleProjectDescription()
 * @model
 * @generated
 */
public interface SimpleProjectDescription extends EObject {
	/**
	 * Returns the value of the '<em><b>Declared Vendor Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * will later be mapped to groupId in Maven pom
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Declared Vendor Id</em>' attribute.
	 * @see #setDeclaredVendorId(String)
	 * @see eu.numberfour.n4js.n4mf.N4mfPackage#getSimpleProjectDescription_DeclaredVendorId()
	 * @model unique="false"
	 * @generated
	 */
	String getDeclaredVendorId();

	/**
	 * Sets the value of the '{@link eu.numberfour.n4js.n4mf.SimpleProjectDescription#getDeclaredVendorId <em>Declared Vendor Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Declared Vendor Id</em>' attribute.
	 * @see #getDeclaredVendorId()
	 * @generated
	 */
	void setDeclaredVendorId(String value);

	/**
	 * Returns the value of the '<em><b>Artifact Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * will be mapped to Maven pom's artifactId, cf. Eclipse's manifest symbolic name
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Artifact Id</em>' attribute.
	 * @see #setArtifactId(String)
	 * @see eu.numberfour.n4js.n4mf.N4mfPackage#getSimpleProjectDescription_ArtifactId()
	 * @model unique="false"
	 * @generated
	 */
	String getArtifactId();

	/**
	 * Sets the value of the '{@link eu.numberfour.n4js.n4mf.SimpleProjectDescription#getArtifactId <em>Artifact Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Artifact Id</em>' attribute.
	 * @see #getArtifactId()
	 * @generated
	 */
	void setArtifactId(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%java.lang.String%> _xifexpression = null;\n<%java.lang.String%> _declaredVendorId = this.getDeclaredVendorId();\nboolean _notEquals = (!<%com.google.common.base.Objects%>.equal(_declaredVendorId, null));\nif (_notEquals)\n{\n\t_xifexpression = this.getDeclaredVendorId();\n}\nelse\n{\n\t<%org.eclipse.emf.ecore.EObject%> _eContainer = this.eContainer();\n\t<%org.eclipse.emf.ecore.EObject%> _eContainer_1 = null;\n\tif (_eContainer!=null)\n\t{\n\t\t_eContainer_1=_eContainer.eContainer();\n\t}\n\t<%org.eclipse.emf.ecore.EObject%> _eContainer_2 = null;\n\tif (_eContainer_1!=null)\n\t{\n\t\t_eContainer_2=_eContainer_1.eContainer();\n\t}\n\t<%java.lang.String%> _declaredVendorId_1 = null;\n\tif (((<%eu.numberfour.n4js.n4mf.ProjectDescription%>) _eContainer_2)!=null)\n\t{\n\t\t_declaredVendorId_1=((<%eu.numberfour.n4js.n4mf.ProjectDescription%>) _eContainer_2).getDeclaredVendorId();\n\t}\n\t_xifexpression = _declaredVendorId_1;\n}\nreturn _xifexpression;'"
	 * @generated
	 */
	String getVendorId();

} // SimpleProjectDescription
