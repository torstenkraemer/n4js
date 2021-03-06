/**
 * Copyright (c) 2016 NumberFour AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   NumberFour AG - Initial API and implementation
 */
package eu.numberfour.n4js.tests.typesbuilder

import com.google.inject.Inject
import eu.numberfour.n4js.N4JSInjectorProvider
import eu.numberfour.n4js.n4JS.N4Modifier
import eu.numberfour.n4js.tests.typesbuilder.extensions.ASTStructureAssertionExtension
import eu.numberfour.n4js.tests.typesbuilder.extensions.TypesStructureAssertionExtension
import eu.numberfour.n4js.tests.typesbuilder.utils.AbstractTypesBuilderTest
import eu.numberfour.n4js.ts.types.TClass
import eu.numberfour.n4js.ts.types.TEnum
import eu.numberfour.n4js.ts.types.TInterface
import eu.numberfour.n4js.ts.types.TModule
import eu.numberfour.n4js.ts.types.TypeAccessModifier
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

@RunWith(XtextRunner)
@InjectWith(N4JSInjectorProvider)
class RoleWithRoleAndInterfaceTypesBuilderTest extends AbstractTypesBuilderTest {

	@Inject
	private extension ASTStructureAssertionExtension

	@Inject
	private extension TypesStructureAssertionExtension

	override protected enableUserDataCompare() {

		// to check the complete AST just change false to true
		false

	//true
	}

	@Test
	def test() {
		val textFileName = "RoleWithRoleAndInterface.n4js"
		val expectedTypesNamePairs = #[
			typeof(TInterface) -> "Loadable",
			typeof(TInterface) -> "MyInterface",
			typeof(TEnum) -> "StorageType",
			typeof(TClass) -> "Storage",
			typeof(TInterface) -> "Persistable"
		]

		// currently everything is exported to user data and Xtext index, e.g. to be able to
		// use in IDE "Open Type", the visibility issue (public, exported) is tracked in
		// https://numberfour.jira.com/browse/IDE-84
		val expectedExportedTypeToNamePairsOnIndex = #[
			typeof(TModule) -> qualifiedNamePrefix + "RoleWithRoleAndInterface",
			typeof(TInterface) -> "Loadable",
			typeof(TInterface) -> "MyInterface",
			typeof(TEnum) -> "StorageType",
			typeof(TClass) -> "Storage",
			typeof(TInterface) -> "Persistable"
		]
		val expectedTypesCount = expectedTypesNamePairs.size
		val expectedExportedElementsCount = expectedExportedTypeToNamePairsOnIndex.size
		executeTest(textFileName, expectedExportedTypeToNamePairsOnIndex, expectedTypesCount,
			expectedExportedElementsCount)
	}

	override getExpectedTypesSerialization() '''
	TModule {

	}'''

	override assertExampleTypeStructure(String phase, Resource newN4jsResource) {
		assertEquals("AST and TModule as root", 2, newN4jsResource.contents.size)
		val role = assertTRole(phase, newN4jsResource, "Persistable", 2)
		assertAccessModifier(phase, role, newN4jsResource, TypeAccessModifier.PUBLIC)
		assertImplementedInterfaces(phase, role, newN4jsResource, "Loadable", "MyInterface")
	}

	override assertExampleJSStructure(String phase, Resource resource) {
		assertEquals("AST and TModule as root", 2, resource.contents.size)
		val script = assertScript(phase, resource, 5)
		val exportableElement = assertExportDeclaration(phase, script, 4)
		val role = assertN4RoleDeclaration(phase, exportableElement, "Persistable", 2)
		assertDeclaredAccessModifier(phase, role, resource, N4Modifier.PUBLIC)
		assertImplementedInterfaces(phase, role, resource, "Loadable", "MyInterface")
	}

}
