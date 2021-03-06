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
package eu.numberfour.n4js.validation

import com.google.inject.Singleton
import eu.numberfour.n4js.n4JS.CatchVariable
import eu.numberfour.n4js.n4JS.ExportedVariableStatement
import eu.numberfour.n4js.n4JS.FormalParameter
import eu.numberfour.n4js.n4JS.FunctionDeclaration
import eu.numberfour.n4js.n4JS.FunctionExpression
import eu.numberfour.n4js.n4JS.N4ClassDefinition
import eu.numberfour.n4js.n4JS.N4ClassifierDefinition
import eu.numberfour.n4js.n4JS.N4EnumDeclaration
import eu.numberfour.n4js.n4JS.N4FieldDeclaration
import eu.numberfour.n4js.n4JS.N4GetterDeclaration
import eu.numberfour.n4js.n4JS.N4InterfaceDeclaration
import eu.numberfour.n4js.n4JS.N4MemberDeclaration
import eu.numberfour.n4js.n4JS.N4MethodDeclaration
import eu.numberfour.n4js.n4JS.N4SetterDeclaration
import eu.numberfour.n4js.n4JS.NamedImportSpecifier
import eu.numberfour.n4js.n4JS.PropertyAssignment
import eu.numberfour.n4js.n4JS.PropertyGetterDeclaration
import eu.numberfour.n4js.n4JS.PropertyNameValuePair
import eu.numberfour.n4js.n4JS.PropertySetterDeclaration
import eu.numberfour.n4js.n4JS.ThisLiteral
import eu.numberfour.n4js.n4JS.VariableDeclaration
import eu.numberfour.n4js.n4JS.VariableStatement
import eu.numberfour.n4js.ts.validation.TypesKeywordProvider

/**
 * Helper returning the keyword of a given AST or type element, e.g., "class" for a class declaration.
 */
@Singleton
class N4JSElementKeywordProvider extends TypesKeywordProvider {

	def dispatch String keyword(N4ClassDefinition n4ClassDefinition) {
		"class"
	}

	def dispatch String keyword(N4InterfaceDeclaration n4RoleDeclaration) {
		"interface"
	}

	def dispatch String keyword(N4EnumDeclaration n4EnumDeclaration) {
		"enum"
	}

	def dispatch String keyword(FunctionDeclaration functionDeclaration) {
		"function"
	}

	def dispatch String keyword(N4ClassifierDefinition n4ClassifierDefinition) {
		"classifier"
	}

	def dispatch String keyword(N4MemberDeclaration n4MemberDeclaration) {
		"member"
	}

	def dispatch String keyword(N4FieldDeclaration n4FieldDeclaration) {
		"field"
	}

	def dispatch String keyword(N4MethodDeclaration n4MethodDeclaration) {
		"method"
	}

	def dispatch String keyword(N4GetterDeclaration n4GetterDeclaration) {
		"getter"
	}

	def dispatch String keyword(N4SetterDeclaration n4SetterDeclaration) {
		"setter"
	}

	def dispatch String keyword(ExportedVariableStatement exportedVariableStmt) {
		"variable"
	}

	def dispatch String keyword(VariableStatement VariableStmt) {
		"variable"
	}

	def dispatch String keyword(VariableDeclaration VariableDecl) {
		"variable"
	}

	def dispatch String keyword(CatchVariable catchVar) {
		"catch variable"
	}

	def dispatch String keyword(FunctionExpression fnExp) {
		"function expression"
	}

	def dispatch String keyword(FormalParameter fparam) {
		"parameter"
	}

	def dispatch String keyword(NamedImportSpecifier namedImportSpecifier) {
		"named import"
	}

	def dispatch String keyword(PropertyAssignment propertyAssignment) {
		"property"
	}

	def dispatch String keyword(PropertyGetterDeclaration propertyGetterDeclaration) {
		"property getter"
	}

	def dispatch String keyword(PropertySetterDeclaration propertySetterDeclaration) {
		"property setter"
	}

	def dispatch String keyword(PropertyNameValuePair propertyNameValuePair) {
		"property"
	}

	def dispatch String keyword(ThisLiteral thisLiteral) {
		"this keyword"
	}

	def dispatch String keyword(Void nullValue) {
		""
	}

}
