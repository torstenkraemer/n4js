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
package eu.numberfour.n4js.validation.validators.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import eu.numberfour.n4js.utils.ContainerTypesHelper.MemberCollector;
import eu.numberfour.n4js.validation.validators.N4JSMemberRedefinitionValidator;
import eu.numberfour.n4js.ts.types.TClass;
import eu.numberfour.n4js.ts.types.TClassifier;
import eu.numberfour.n4js.ts.types.TMember;
import eu.numberfour.n4js.ts.types.util.NameStaticPair;
import eu.numberfour.n4js.utils.UtilN4;

/**
 * Helper class for the {@link N4JSMemberRedefinitionValidator} storing a {@link MemberMatrix} for each member of the
 * classifier.
 */
public class MemberCube {

	Map<NameStaticPair, MemberMatrix> memberMatrixesByName;

	/**
	 * Creates the cube for the given classifier, using the passed member collector. The latter is passed as argument as
	 * it needed DI.
	 */
	public MemberCube(TClassifier tClassifier, MemberCollector memberCollector) {
		memberMatrixesByName = new HashMap<>();
		addMembers(MemberMatrix.OWNED, tClassifier.getOwnedMembers(), tClassifier.isPolyfill());
		if (tClassifier instanceof TClass) {
			addMembers(MemberMatrix.INHERITED, memberCollector
					.inheritedMembers((TClass) tClassifier), tClassifier.isPolyfill());
		}
		// interfaces must not contain constructors anyway
		addMembers(MemberMatrix.IMPLEMENTED, memberCollector.membersOfImplementedInterfaces(tClassifier), false);
	}

	/**
	 * constructors (in case of non-polyfills) are filtered out
	 */
	private void addMembers(int source, List<TMember> members, boolean isPolyfill) {
		for (TMember member : members) {
			if (isPolyfill || !"constructor".equals(member.getName())) {
				NameStaticPair nsp = NameStaticPair.of(member);
				MemberMatrix memberMatrix = memberMatrixesByName.get(nsp);
				if (memberMatrix == null) {
					memberMatrix = new MemberMatrix();
					memberMatrixesByName.put(nsp, memberMatrix);
				}
				memberMatrix.add(source, member);
			}
		}
	}

	/**
	 * @see java.util.Map#entrySet()
	 */
	public Set<Entry<NameStaticPair, MemberMatrix>> entrySet() {
		return memberMatrixesByName.entrySet();
	}

	/** Only for debugging */
	@Override
	public String toString() {
		StringBuilder strb = new StringBuilder();
		StringBuilder row = new StringBuilder();
		for (Entry<NameStaticPair, MemberMatrix> entry : entrySet()) {
			row.setLength(0);
			row.append(entry.getKey().toString()).append(": ");
			UtilN4.fill(row, 36);
			strb.append(row);
			strb.append(entry.getValue().toShortString()).append('\n');
		}
		return strb.toString();
	}

}