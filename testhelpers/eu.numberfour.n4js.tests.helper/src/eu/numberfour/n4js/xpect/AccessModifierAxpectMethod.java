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
package eu.numberfour.n4js.xpect;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.xpect.XpectImport;
import org.xpect.expectation.IStringExpectation;
import org.xpect.expectation.StringExpectation;
import org.xpect.parameter.ParameterParser;
import org.xpect.runner.Xpect;
import org.xpect.xtext.lib.setup.ThisOffset;

import eu.numberfour.n4js.n4JS.ExportDeclaration;
import eu.numberfour.n4js.n4JS.ExportedVariableDeclaration;
import eu.numberfour.n4js.n4JS.FunctionDeclaration;
import eu.numberfour.n4js.n4JS.N4MemberDeclaration;
import eu.numberfour.n4js.n4JS.N4TypeDeclaration;
import eu.numberfour.n4js.n4JS.VariableDeclaration;
import eu.numberfour.n4js.n4JS.VariableStatement;
import eu.numberfour.n4js.xpect.N4JSOffsetAdapter.IEObjectCoveringRegion;

/**
 */
@XpectImport(N4JSOffsetAdapter.class)
public class AccessModifierAxpectMethod {

	/***/
	@ParameterParser(syntax = "('at' offset=OFFSET)?")
	@Xpect
	public void calculatedAccessModifier(
			@StringExpectation IStringExpectation expectation,
			@ThisOffset IEObjectCoveringRegion offset) {

		EObject context = offset.getEObject();
		String actual = calculateActual(context);
		expectation.assertEquals(actual);
	}

	private String calculateActual(EObject context) {
		String actual = null;
		FunctionDeclaration functionDeclaration = EcoreUtil2.getContainerOfType(context, FunctionDeclaration.class);
		if (functionDeclaration != null) {
			actual = functionDeclaration.getDefinedType().getTypeAccessModifier().getName();
		} else {
			VariableStatement variableStatement = EcoreUtil2.getContainerOfType(context, VariableStatement.class);
			if (variableStatement != null) {
				context = variableStatement.getVarDecl().get(0);
				if (context instanceof ExportedVariableDeclaration) {
					actual = ((ExportedVariableDeclaration) context).getDefinedVariable().getTypeAccessModifier()
							.getName();
				} else if (context instanceof VariableDeclaration) {
					actual = "private";
				}
			} else if (context instanceof ExportDeclaration) {
				context = ((ExportDeclaration) context).getExportedElement();
				actual = calculateActual(context);
			} else {
				N4MemberDeclaration member = EcoreUtil2.getContainerOfType(context, N4MemberDeclaration.class);
				N4TypeDeclaration type = EcoreUtil2.getContainerOfType(context, N4TypeDeclaration.class);
				if (type == null && member == null) {
					actual = "no element with access modifier found";
				} else if (type != null && (member == null || EcoreUtil.isAncestor(member, type))) {
					actual = type.getDefinedType().getTypeAccessModifier().getName();
				} else {
					actual = member.getDefinedTypeElement().getMemberAccessModifier().getName();
				}
			}
		}
		return actual;
	}
}
