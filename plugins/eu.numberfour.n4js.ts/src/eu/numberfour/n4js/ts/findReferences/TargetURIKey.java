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
package eu.numberfour.n4js.ts.findReferences;

import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.findReferences.IReferenceFinder;
import org.eclipse.xtext.findReferences.IReferenceFinder.IResourceAccess;
import org.eclipse.xtext.findReferences.TargetURIs;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.util.SimpleAttributeResolver;

import com.google.common.collect.Sets;
import com.google.inject.Inject;

import eu.numberfour.n4js.ts.types.TEnumLiteral;
import eu.numberfour.n4js.ts.types.TMember;
import eu.numberfour.n4js.ts.types.TModule;
import eu.numberfour.n4js.ts.types.Type;

/**
 * Access to the n4 specific cached data during a find references operation.
 */
public class TargetURIKey {

	/**
	 * The key that is used to obtain the cache.
	 */
	static final TargetURIs.Key<Data> KEY = TargetURIs.Key.from("eu.numberfour.n4js.ts.findReferences.TargetURIKey",
			Data.class);

	@Inject
	private IQualifiedNameProvider qualifiedNameProvider;

	/**
	 * Cache that is stored as user data on an instance of the {@link TargetURIs}.
	 */
	public static class Data {
		private final Set<String> valueStrings;
		private final Set<EClass> applicableTypes;
		private final Set<QualifiedName> typesOrModulesToFind;
		private final IQualifiedNameProvider qualifiedNameProvider;

		/**
		 * Create an empty instance that will accept EObjects to keep information that is reusable.
		 */
		public Data(IQualifiedNameProvider qualifiedNameProvider) {
			this.qualifiedNameProvider = qualifiedNameProvider;
			this.valueStrings = Sets.newHashSet();
			this.applicableTypes = Sets.newHashSet();
			this.typesOrModulesToFind = Sets.newHashSet();
		}

		/**
		 * Add information about the given object to this cache.
		 *
		 * @param object
		 *            the object to handle
		 */
		public void add(EObject object) {
			this.applicableTypes.add(object.eClass());
			this.valueStrings.add(SimpleAttributeResolver.NAME_RESOLVER.apply(object));

			if (object instanceof TMember || object instanceof TEnumLiteral) {
				Type t = EcoreUtil2.getContainerOfType(object.eContainer(), Type.class);
				typesOrModulesToFind.add(qualifiedNameProvider.getFullyQualifiedName(t));
			} else if (object instanceof Type) {
				typesOrModulesToFind.add(qualifiedNameProvider.getFullyQualifiedName(object));
			} else if (object instanceof TModule) {
				typesOrModulesToFind.add(qualifiedNameProvider.getFullyQualifiedName(object));
			}
		}

		/**
		 * @param eReferenceType
		 *            the type of the reference that is inspected.
		 * @return <code>true</code> if this set contains a subtype of the given eReferenceType.
		 */
		public boolean isEReferenceTypeApplicable(EClass eReferenceType) {
			if (applicableTypes.isEmpty())
				return true;
			for (EClass applicableType : applicableTypes) {
				if (EcoreUtil2.isAssignableFrom(eReferenceType, applicableType)) {
					return true;
				}
			}
			return false;
		}

		/**
		 * Returns the names that would be used globally if one of the included elements was referenced.
		 *
		 * @return the names to find.
		 */
		public Set<QualifiedName> getTypesOrModulesToFind() {
			return typesOrModulesToFind;
		}

		/**
		 * Shortcut to decide whether a given concrete syntax is potentially matching the contained objects.
		 */
		public boolean isMatchingConcreteSyntax(String valueString) {
			if (valueStrings.isEmpty() || valueStrings.contains(valueString)) {
				return true;
			}
			// HERE we need to make sure that we use a proper NS delimiter
			int idx = valueString.lastIndexOf('.');
			if (idx > 0) {
				if (valueStrings.contains(valueString.substring(idx + 1))) {
					return true;
				}
			}
			return false;
		}
	}

	/**
	 * Get or create a data cache in the user data space of the given target URIs.
	 *
	 * @return a new or existing data cache.
	 */
	public Data getData(TargetURIs targetURIs, IReferenceFinder.IResourceAccess resourceAccess) {
		Data result = targetURIs.getUserData(KEY);
		if (result != null) {
			return result;
		}
		return initData(targetURIs, resourceAccess);
	}

	private Data initData(TargetURIs targetURIs, IReferenceFinder.IResourceAccess resourceAccess) {
		Data result = new Data(qualifiedNameProvider);
		init(result, resourceAccess, targetURIs);
		targetURIs.putUserData(KEY, result);
		return result;
	}

	private void init(Data result, IResourceAccess resourceAccess, TargetURIs targetURIs) {
		targetURIs.getTargetResourceURIs().forEach((resourceURI) -> {
			resourceAccess.readOnly(resourceURI, (resourceSet) -> {
				targetURIs.getEObjectURIs(resourceURI).forEach((objectURI) -> {
					try {
						EObject object = resourceSet.getEObject(objectURI, true);
						if (object != null) {
							result.add(object);
						}
					} catch (RuntimeException e) {
						// ignore
					}
				});
				return null;
			});
		});
	}

	/**
	 * Public for testing purpose
	 */
	public void setQualifiedNameProvider(IQualifiedNameProvider qualifiedNameProvider) {
		this.qualifiedNameProvider = qualifiedNameProvider;
	}
}
