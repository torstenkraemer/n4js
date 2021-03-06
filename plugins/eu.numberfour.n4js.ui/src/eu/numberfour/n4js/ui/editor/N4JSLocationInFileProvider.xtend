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
package eu.numberfour.n4js.ui.editor

import eu.numberfour.n4js.n4JS.GenericDeclaration
import eu.numberfour.n4js.ts.typeRefs.ComposedTypeRef
import eu.numberfour.n4js.ts.types.SyntaxRelatedTElement
import eu.numberfour.n4js.ts.types.TFormalParameter
import eu.numberfour.n4js.ts.types.TMember
import eu.numberfour.n4js.ts.types.TStructMember
import eu.numberfour.n4js.ts.types.TStructMethod
import eu.numberfour.n4js.ts.types.TypeVariable
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.xtext.resource.DefaultLocationInFileProvider
import org.eclipse.xtext.resource.ILocationInFileProviderExtension
import eu.numberfour.n4js.ts.typeRefs.FunctionTypeExpression

/**
 */
class N4JSLocationInFileProvider extends DefaultLocationInFileProvider {

	override getFullTextRegion(EObject element) {
		return super.getFullTextRegion(convertToSource(element));
	}

	override getFullTextRegion(EObject owner, EStructuralFeature feature, int indexInList) {
		return super.getFullTextRegion(convertToSource(owner), feature, indexInList);
	}

	override getSignificantTextRegion(EObject element) {
		return super.getSignificantTextRegion(convertToSource(element));
	}

	override getSignificantTextRegion(EObject owner, EStructuralFeature feature, int indexInList) {
		return super.getSignificantTextRegion(convertToSource(owner), feature, indexInList);
	}

	override getTextRegion(EObject object, EStructuralFeature feature, int indexInList,
		ILocationInFileProviderExtension.RegionDescription query) {
		return super.getTextRegion(convertToSource(object), feature, indexInList, query);
	}

	override getTextRegion(EObject object, ILocationInFileProviderExtension.RegionDescription query) {
		return super.getTextRegion(convertToSource(object), query);
	}

	def protected EObject convertToSource(EObject element) {
		if (element === null)
			return null;
		switch (element) {
			TypeVariable: {
				val parentAST = convertToSource(element.eContainer);
				if(parentAST instanceof GenericDeclaration || parentAST instanceof TStructMethod || parentAST instanceof FunctionTypeExpression) {
					val typeVarName = element.name;
					if(typeVarName!==null && typeVarName.trim.length>0) {
						val typeVars = switch parentAST {
							GenericDeclaration: 	parentAST.typeVars
							TStructMethod:			parentAST.typeVars
							FunctionTypeExpression:	parentAST.ownedTypeVars
						};
						val correspondingTypeVarInAST = typeVars.findFirst[name==typeVarName];
						if(correspondingTypeVarInAST!==null)
							return correspondingTypeVarInAST;
					}
				}
				return element;
			}
			TFormalParameter case element.astElement === null:
				element
			TStructMember case element.astElement === null:
				element
			TMember case element.eContainer instanceof ComposedTypeRef:
				element
			SyntaxRelatedTElement: {
				if (element.astElement === null)
					throw new IllegalStateException()
				element.astElement
			}
			default:
				element
		}
	}

}
