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
package eu.numberfour.n4js.validation.validators

import com.google.inject.Inject
import eu.numberfour.n4js.n4JS.Block
import eu.numberfour.n4js.n4JS.ExpressionStatement
import eu.numberfour.n4js.n4JS.FunctionOrFieldAccessor
import eu.numberfour.n4js.n4JS.IndexedAccessExpression
import eu.numberfour.n4js.n4JS.N4GetterDeclaration
import eu.numberfour.n4js.n4JS.N4InterfaceDeclaration
import eu.numberfour.n4js.n4JS.N4JSPackage
import eu.numberfour.n4js.n4JS.N4MemberDeclaration
import eu.numberfour.n4js.n4JS.N4MethodDeclaration
import eu.numberfour.n4js.n4JS.N4SetterDeclaration
import eu.numberfour.n4js.n4JS.NewExpression
import eu.numberfour.n4js.n4JS.ParameterizedCallExpression
import eu.numberfour.n4js.n4JS.ParameterizedPropertyAccessExpression
import eu.numberfour.n4js.n4JS.ReturnStatement
import eu.numberfour.n4js.n4JS.SuperLiteral
import eu.numberfour.n4js.n4JS.ThisLiteral
import eu.numberfour.n4js.typeinference.N4JSTypeInferencer
import eu.numberfour.n4js.validation.AbstractN4JSDeclarativeValidator
import eu.numberfour.n4js.ts.types.TField
import eu.numberfour.n4js.utils.EcoreUtilN4
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.validation.EValidatorRegistrar

import static eu.numberfour.n4js.validation.IssueCodes.*

/**
 * Validate use of super keyword.
 *
 * N4JS spec  6.2.1 and 4.18.2
 */
class N4JSSuperValidator extends AbstractN4JSDeclarativeValidator {

	@Inject
	protected N4JSTypeInferencer typeInferencer;

	/**
	 * NEEEDED
	 *
	 * when removed check methods will be called twice once by N4JSValidator, and once by
	 * AbstractDeclarativeN4JSValidator
	 */
	override register(EValidatorRegistrar registrar) {
		// nop
	}

	@Check
	def checkSuper(SuperLiteral superLiteral) {
		val container = superLiteral.eContainer;
		val containingMemberDecl = EcoreUtil2.getContainerOfType(container, N4MemberDeclaration);

		if (superLiteral.superMemberAccess) {
			superLiteral.internalCheckSuperMemberAccess(containingMemberDecl)
		} else if (superLiteral.isSuperConstructorAccess) {
			superLiteral.internalCheckSuperConstructorAccess(containingMemberDecl,
				container as ParameterizedCallExpression)
		} else if (container instanceof NewExpression) {

			// new super
			// error: not supported yet
			val message = messageForKEY_SUP_NEW_NOT_SUPPORTED
			addIssue(message, superLiteral.eContainer, superLiteral.eContainmentFeature, KEY_SUP_NEW_NOT_SUPPORTED);
		} else {

			// Constraint 99:
			// error: invalid usage
			val message = messageForKEY_SUP_INVALID_USAGE
			addIssue(message, superLiteral.eContainer, superLiteral.eContainmentFeature, KEY_SUP_INVALID_USAGE);
		}
	}

	/**
	 * N4JS spec 4.18.2 and 6.2.1
	 * Constraints 97
	 */
	private def internalCheckSuperConstructorAccess(SuperLiteral superLiteral,
		N4MemberDeclaration containingMemberDecl, ParameterizedCallExpression cexpr) {

		// 97.1 is implicitly valid (otherwise we wouldn't be in this function)
		if (holdsExpressionOfExpressionStmt(superLiteral, cexpr)) {
			val exprStmt = cexpr.eContainer as ExpressionStatement;
			holdsDirectlyContainedInConstructor(superLiteral, exprStmt, containingMemberDecl) &&
				holdsNoThisOrReturnBefore(superLiteral, exprStmt, containingMemberDecl)
		}
	}

	/**
	 * Constraint 97.2
	 */
	private def boolean holdsExpressionOfExpressionStmt(SuperLiteral superLiteral, ParameterizedCallExpression cexpr) {
		if (cexpr.eContainer instanceof ExpressionStatement) {
			return true;
		}
		addIssue(messageForKEY_SUP_CTOR_EXPRSTMT, cexpr, superLiteral.eContainmentFeature, KEY_SUP_CTOR_EXPRSTMT);
		return false;
	}

	/**
	 * N4JS constraints 97.3
	 */
	private def holdsDirectlyContainedInConstructor(SuperLiteral superLiteral, ExpressionStatement exprStmt,
		N4MemberDeclaration containingMemberDecl) {
		val block = exprStmt.eContainer;

		if (! (containingMemberDecl instanceof N4MethodDeclaration && containingMemberDecl.name == 'constructor')) {
			return false;
		}

		if (!(block instanceof Block && block.eContainer === containingMemberDecl)) {
			val msg = getMessageForKEY_SUP_CTOR_NESTED(
				descriptionWithLine(
					if (block instanceof Block) {
						block.eContainer
					} else {
						block
					}));
			addIssue(msg, superLiteral.eContainer, superLiteral.eContainmentFeature, KEY_SUP_CTOR_NESTED);
			return false;
		}

		return true;
	}

	/**
	 * N4JS constraints 97.4
	 * @see IDEBUG-147
	 */
	private def boolean holdsNoThisOrReturnBefore(SuperLiteral superLiteral, ExpressionStatement exprStmt,
		N4MemberDeclaration containingMemberDecl) {
		for (stmt : containingMemberDecl.body.statements) {
			if (stmt === exprStmt) return true;

			if (stmt instanceof ReturnStatement) {
				val msg = getMessageForKEY_SUP_CTOR_INVALID_EXPR_BEFORE(descriptionWithLine(stmt));
				addIssue(msg, superLiteral.eContainer, superLiteral.eContainmentFeature,
					KEY_SUP_CTOR_INVALID_EXPR_BEFORE);
				return false;
			}

			val thisKeyword = EcoreUtilN4.getAllContentsFiltered(stmt, [! (it instanceof FunctionOrFieldAccessor)]).
				findFirst[it instanceof ThisLiteral || it instanceof ReturnStatement];
			if (thisKeyword !== null) {
				val msg = getMessageForKEY_SUP_CTOR_INVALID_EXPR_BEFORE(descriptionWithLine(thisKeyword));
				addIssue(msg, superLiteral.eContainer, superLiteral.eContainmentFeature,
					KEY_SUP_CTOR_INVALID_EXPR_BEFORE);
				return false;
			}
		}

		// must not happen
		val msg = getMessageForKEY_SUP_CTOR_NESTED(descriptionWithLine(exprStmt.eContainer));
		addIssue(msg, superLiteral.eContainer, superLiteral.eContainmentFeature, KEY_SUP_CTOR_NESTED);
		return false;
	}

	/**
	 * N4JS spec 6.2.1
	 * Constraints 98
	 */
	private def internalCheckSuperMemberAccess(SuperLiteral superLiteral, N4MemberDeclaration containingMemberDecl) {
		holdsSuperCallInMethodOrFieldAccessor(superLiteral, containingMemberDecl) //
		&& holdsSuperCallNotNested(superLiteral, containingMemberDecl) //
		&& holdsSuperIsReceiverOfCall(superLiteral);
	}

	/**
	 * Constraint 98.1, special cases
	 */
	private def boolean holdsSuperIsReceiverOfCall(SuperLiteral superLiteral) {
		if (superLiteral.eContainer instanceof ParameterizedPropertyAccessExpression &&
			(superLiteral.eContainer as ParameterizedPropertyAccessExpression).property instanceof TField) {
			addIssue(messageForKEY_SUP_ACCESS_FIELD, superLiteral.eContainer as ParameterizedPropertyAccessExpression,
				N4JSPackage.Literals.PARAMETERIZED_PROPERTY_ACCESS_EXPRESSION__PROPERTY, KEY_SUP_ACCESS_FIELD);
			return false;
		}
		if (superLiteral.eContainer instanceof IndexedAccessExpression) {
			addIssue(messageForKEY_SUP_CALL_NO_INDEXACCESS, superLiteral.eContainer as IndexedAccessExpression,
				N4JSPackage.eINSTANCE.indexedAccessExpression_Target, KEY_SUP_CALL_NO_INDEXACCESS);
			return false;
		}
		return true;
	}

	/**
	 * Constraint 98.3
	 */
	private def boolean holdsSuperCallNotNested(SuperLiteral superLiteral, N4MemberDeclaration containingMemberDecl) {
		if (EcoreUtil2.getContainerOfType(superLiteral.eContainer, FunctionOrFieldAccessor) !== containingMemberDecl) {
			addIssue(messageForKEY_SUP_NESTED, superLiteral.eContainer, superLiteral.eContainmentFeature, KEY_SUP_NESTED);
			return false;
		}
		return true;
	}

	/**
	 * Constraint 98.2
	 */
	def boolean holdsSuperCallInMethodOrFieldAccessor(SuperLiteral superLiteral,
		N4MemberDeclaration containingMemberDecl) {
		if (!(containingMemberDecl instanceof N4MethodDeclaration ||
			containingMemberDecl instanceof N4GetterDeclaration || containingMemberDecl instanceof N4SetterDeclaration)) {
			return false;
		}
		if (containingMemberDecl?.eContainer instanceof N4InterfaceDeclaration) {
			addIssue(messageForKEY_SUP_ACCESS_INVALID_LOC_INTERFACE, superLiteral.eContainer, superLiteral.eContainmentFeature,
				KEY_SUP_ACCESS_INVALID_LOC_INTERFACE);
			return false;
		}
		return true;
	}
}
