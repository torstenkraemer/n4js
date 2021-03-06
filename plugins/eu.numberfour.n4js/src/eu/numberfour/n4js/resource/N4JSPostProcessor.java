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
package eu.numberfour.n4js.resource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.util.CancelIndicator;

import com.google.inject.Inject;

import eu.numberfour.n4js.postprocessing.ASTProcessor;
import eu.numberfour.n4js.resource.PostProcessingAwareResource.PostProcessor;
import eu.numberfour.n4js.ts.types.TModule;
import eu.numberfour.n4js.ts.types.Type;
import eu.numberfour.n4js.ts.types.TypesPackage;
import eu.numberfour.n4js.typesbuilder.N4JSTypesBuilder;
import eu.numberfour.n4js.utils.EcoreUtilN4;

/**
 * Performs post-processing of N4JS resources. Main responsibilities are proxy resolution, types model creation, and
 * ASTNodeInfo computation. When post-processing has completed, the following is guaranteed:
 * <ol>
 * <li>ensure all proxies are resolved,
 * <li>complete {@link TModule} has been created (including all type information; not a stripped-down TModule as created
 * by the {@link N4JSTypesBuilder} during pre-indexing phase),
 * <li>each AST node has a valid ASTNodeInfo,
 * <li>referenced internal types have been exposed.
 * </ol>
 */
public class N4JSPostProcessor implements PostProcessor {

	@Inject
	private ASTProcessor astProcessor;

	@Override
	public boolean expectsLazyLinkResolution() {
		// we do our lazy link resolution while walking the AST together with scoping, typing, etc.
		// -> suppress the automatic up-front resolution by returning false here
		return false;
	}

	@Override
	public void performPostProcessing(PostProcessingAwareResource resource, CancelIndicator cancelIndicator) {
		final N4JSResource resCasted = (N4JSResource) resource;
		astProcessor.processAST(resCasted, cancelIndicator);
		try {
			exposeReferencedInternalTypes(resCasted); // FIXME move this somewhere else?
		} catch (Throwable ex) {
			if (resource.getErrors().isEmpty()) {
				throw ex;
			}
			// swallow exception, AST is broken due to parse error anyway
		}

	}

	/**
	 * Moves all types contained in 'internalTypes' to 'exposedInternalTypes' that are referenced from any top level
	 * type or a variable.
	 */
	private static void exposeReferencedInternalTypes(N4JSResource res) {
		final TModule module = res.getModule();
		if (module == null)
			return;

		// reset, i.e. make all exposed types internal again
		module.getInternalTypes().addAll(module.getExposedInternalTypes());

		// move internal types to exposedInternalTypes if referenced from topLevelTypes or variables
		final List<EObject> stuffToScan = new ArrayList<>();
		stuffToScan.addAll(module.getTopLevelTypes());
		stuffToScan.addAll(module.getVariables());
		for (EObject currRoot : stuffToScan) {
			exposeTypesReferencedBy(currRoot);
			final TreeIterator<EObject> i = currRoot.eAllContents();
			while (i.hasNext())
				exposeTypesReferencedBy(i.next());
		}
	}

	private static void exposeTypesReferencedBy(EObject object) {
		for (EReference currRef : object.eClass().getEAllReferences()) {
			if (!currRef.isContainment()) {
				final Object currTarget = object.eGet(currRef);
				if (currTarget instanceof Collection<?>) {
					for (Object currObj : (Collection<?>) currTarget)
						exposeType(currObj);
				} else
					exposeType(currTarget);
			}
		}
	}

	/**
	 * If 'object' is a type or a constituent of a type (e.g. field of a class) in 'internalTypes', then move the type
	 * to 'exposedInternalTypes'.
	 */
	private static void exposeType(Object object) {
		if (!(object instanceof EObject) || ((EObject) object).eIsProxy())
			return;
		// object might not be a type but reside inside a type, e.g. field of a class
		// --> so search for the root, i.e. the ancestor directly below the TModule
		EObject root = (EObject) object;
		while (root != null && !(root.eContainer() instanceof TModule))
			root = root.eContainer();
		if (root instanceof Type
				&& root.eContainingFeature() == TypesPackage.eINSTANCE.getTModule_InternalTypes()) {
			final TModule module = (TModule) root.eContainer();
			final EObject rootFinal = root;
			EcoreUtilN4.doWithDeliver(false, () -> {
				module.getExposedInternalTypes().add((Type) rootFinal);
			} , module, root); // note: root already contained in resource, so suppress notifications also in root!
		}
	}
}
