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
package eu.numberfour.n4js.scoping.builtin;

import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.IAcceptor;

import com.google.common.annotations.VisibleForTesting;

import eu.numberfour.n4js.ts.scoping.builtin.EnumerableScope;
import eu.numberfour.n4js.ts.scoping.builtin.ExecutionEnvironmentDescriptor;
import eu.numberfour.n4js.ts.types.TClass;

/**
 * This scope provides access to the built in JS global object.
 *
 * The scope basically decorates the resource set and provides a strongly typed accessor for the global object.
 *
 * Retrieve via {@link GlobalObjectScope#get(ResourceSet)}.
 */
public final class GlobalObjectScope extends EnumerableScope {

	/**
	 * Visible for testing purpose.
	 */
	@VisibleForTesting
	public static final String[] FILE_NAMES = { "global.n4ts" };

	/**
	 * The qualified name of the global object.
	 */
	protected static final QualifiedName GLOBAL_OBJECT = QualifiedName.create("GlobalObject");

	/**
	 * Obtains an instance in the context of the given resourceSet.
	 */
	public static GlobalObjectScope get(ResourceSet resourceSet) {
		GlobalObjectScopeAccess result = (GlobalObjectScopeAccess) EcoreUtil.getAdapter(resourceSet.eAdapters(),
				GlobalObjectScope.class);
		if (result == null) {
			throw new IllegalStateException("Missing adapter for GlobalObjectScope");
		}
		return result.getScope();
	}

	/**
	 * @return the single globally available object in the resource set.
	 */
	public TClass getGlobalObject() {
		return getEObjectOrProxy(GLOBAL_OBJECT);
	}

	/**
	 * Create a new global object scope where the object is provided by means of the given descriptor.
	 */
	public GlobalObjectScope(ExecutionEnvironmentDescriptor descriptor) {
		super(descriptor);
	}

	@Override
	protected String[] getFileNames() {
		return FILE_NAMES;
	}

	@Override
	protected void buildMap(Resource resource, Map<QualifiedName, IEObjectDescription> elements) {
		IDefaultResourceDescriptionStrategy strategy = ((XtextResource) resource).getResourceServiceProvider()
				.get(IDefaultResourceDescriptionStrategy.class);
		TreeIterator<EObject> allProperContents = EcoreUtil.getAllProperContents(resource, false);
		IAcceptor<IEObjectDescription> acceptor = new IAcceptor<IEObjectDescription>() {
			@Override
			public void accept(IEObjectDescription description) {
				elements.put(description.getQualifiedName(), description);
			}
		};
		while (allProperContents.hasNext()) {
			EObject content = allProperContents.next();
			if (!strategy.createEObjectDescriptions(content, acceptor)) {
				allProperContents.prune();
			}
		}
	}

}
