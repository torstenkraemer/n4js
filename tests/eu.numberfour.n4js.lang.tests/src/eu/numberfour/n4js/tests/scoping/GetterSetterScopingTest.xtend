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
import eu.numberfour.n4js.n4JS.AssignmentExpression
import eu.numberfour.n4js.n4JS.ExpressionStatement
import eu.numberfour.n4js.n4JS.ObjectLiteral
import eu.numberfour.n4js.n4JS.ParameterizedPropertyAccessExpression
import eu.numberfour.n4js.n4JS.Script
import eu.numberfour.n4js.scoping.members.MemberScope
import eu.numberfour.n4js.ts.types.TStructuralType
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

/**
 * Tests for this scoping, combined with type system test.
 *
 * <p>Note: In this test, the this literal needs to be followed by a property access in order
 * to force the scoping to actually create the type. That is, we use "this.s" instead of "this".</p>
 *
 * @see AT_185_ThisScopingTest
 * @see ThisScopingTest
 * @see MemberScope
 * @see <a href="https://numberfour.jira.com/browse/IDE-343">IDE-343</a>
 */
@InjectWith(N4JSInjectorProvider)
@RunWith(XtextRunner)
class GetterSetterScopingTest {

	@Inject extension ParseHelper<Script>
	@Inject extension ValidationTestHelper

	/**
	 * Referenced property (or getter/setter) must be called "target"
	 */
	def void assertPropertyBinding(CharSequence scriptSrc, boolean readable, boolean expectError) {
		val script = (scriptSrc + '''
			«IF (readable)»ol.target«ELSE»ol.target=null«ENDIF»;
		''').parse
		script.validate;

		//		val G = newRuleEnvironment(script);
		val expr = (script.scriptElements.last as ExpressionStatement).expression;

		val objectLiteral = EcoreUtil2.eAllOfType(script, ObjectLiteral).head;
		val objectLiteralStructuralType = objectLiteral.definedType as TStructuralType
		val staticAccess = false
		var member = objectLiteralStructuralType.findOwnedMember("target", ! readable, staticAccess);
		if (member === null) {
			member = objectLiteralStructuralType.findOwnedMember("target", readable, staticAccess);
		}

		val operand = if (readable) {
				expr as ParameterizedPropertyAccessExpression
			} else {
				(expr as AssignmentExpression).lhs as ParameterizedPropertyAccessExpression
			};

		assertSame(member, operand.property);
		if (! expectError) {
			script.assertNoErrors;
		}

	}

	@Test
	def void testReadProperty() {
		assertPropertyBinding(
			'''
				var ol = {
					target: "hello"
				}
			''', true, false)
	}

	@Test
	def void testReferToGetter() {
		assertPropertyBinding(
			'''
				var ol = {
					get target() {return null}
				}
			''', true, false)
	}

	@Test
	def void testReferToSetter() {
		assertPropertyBinding(
			'''
				var ol = {
					set target(x) {}
				}
			''', false, false)
	}

	@Test
	def void testWriteProperty() {
		assertPropertyBinding(
			'''
				var ol = {
					target: "hello"
				}
			''', true, false)
	}

	@Test
	def void testWronglyReferToGetter() {
		assertPropertyBinding(
			'''
				var ol = {
					get target() {return null}
				}
			''', false, true)
	}

	@Test
	def void testWronglyReferToSetter() {
		assertPropertyBinding(
			'''
				var ol = {
					set target(x) {}
				}
			''', true, true)
	}
}
