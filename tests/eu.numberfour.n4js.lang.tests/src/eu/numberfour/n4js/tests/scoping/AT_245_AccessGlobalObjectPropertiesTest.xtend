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
package eu.numberfour.n4js.tests.scoping

import com.google.inject.Inject
import eu.numberfour.n4js.N4JSInjectorProvider
import eu.numberfour.n4js.n4JS.ExpressionStatement
import eu.numberfour.n4js.n4JS.IdentifierRef
import eu.numberfour.n4js.n4JS.ParameterizedPropertyAccessExpression
import eu.numberfour.n4js.validation.JavaScriptVariant
import eu.numberfour.n4js.ts.typeRefs.ParameterizedTypeRef
import eu.numberfour.n4js.ts.types.TClass
import eu.numberfour.n4js.ts.types.TField
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import eu.numberfour.n4js.N4JSParseHelper

/**
 */
@InjectWith(N4JSInjectorProvider)
@RunWith(XtextRunner)
class AT_245_AccessGlobalObjectPropertiesTest {

	@Inject extension N4JSParseHelper
	@Inject extension ValidationTestHelper

	@Test
	def void test_01() {
		val script = '''
			this.undefined
		'''.parse(JavaScriptVariant.unrestricted)
		script.assertNoErrors
		val expression = (script.scriptElements.head as ExpressionStatement).expression as ParameterizedPropertyAccessExpression
		val property = expression.property as TField
		Assert.assertEquals("GlobalObject", (property.eContainer as TClass).name)
		Assert.assertEquals("undefined", (property.typeRef as ParameterizedTypeRef).declaredType.name)
	}

	@Test
	def void test_02() {
		val script = '''
			undefined
		'''.parse(JavaScriptVariant.unrestricted)
		script.assertNoErrors
		val expression = (script.scriptElements.head as ExpressionStatement).expression as IdentifierRef
		val property = expression.id as TField
		Assert.assertEquals("GlobalObject", (property.eContainer as TClass).name)
		Assert.assertEquals("undefined", (property.typeRef as ParameterizedTypeRef).declaredType.name)
	}

}
