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
package eu.numberfour.n4js.scoping.members;

import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;

import eu.numberfour.n4js.scoping.accessModifiers.VisibilityAwareMemberScope;
import eu.numberfour.n4js.ts.typeRefs.TypeRef;
import eu.numberfour.n4js.ts.types.TypingStrategy;
import eu.numberfour.n4js.xtext.scoping.FilterWithErrorMarkerScope;
import eu.numberfour.n4js.xtext.scoping.IEObjectDescriptionWithError;

/**
 * Scope aware of structural typing, i.e., filtering out (with error markers) some members based on the typing strategy.
 */
public class TypingStrategyAwareMemberScope extends FilterWithErrorMarkerScope {

	final TypingStrategyFilter strategyFilter;
	final boolean useSite;
	final String receiverTypeName;

	/**
	 * @param parent
	 *            the nested parent scope, usually a {@link VisibilityAwareMemberScope}
	 * @param receiverType
	 *            in case of use site structural typing, the strategy is set in the reference
	 */
	public TypingStrategyAwareMemberScope(IScope parent, TypeRef receiverType) {
		super(parent);
		strategyFilter = new TypingStrategyFilter(receiverType);
		useSite = receiverType != null && receiverType.isUseSiteStructuralTyping();
		receiverTypeName = (receiverType == null || receiverType.eIsProxy()) ? "unknown type" : receiverType
				.getTypeRefAsString();
	}

	@Override
	protected IEObjectDescriptionWithError wrapFilteredDescription(IEObjectDescription originalDescr) {
		return new WrongTypingStrategyDescription(originalDescr,
				strategyFilter.getTypingStrategy() == TypingStrategy.STRUCTURAL_FIELDS, useSite, receiverTypeName);
	}

	@Override
	protected boolean isAccepted(IEObjectDescription originalDescr) {
		if (originalDescr == null || IEObjectDescriptionWithError.isErrorDescription(originalDescr)) {
			return true; // do not change error containing descriptions
		}
		return strategyFilter.apply(originalDescr);
	}

}
