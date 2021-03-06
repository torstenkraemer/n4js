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
package eu.numberfour.n4js.transpiler;

import java.util.HashMap;

import eu.numberfour.n4js.n4JS.NamedElement;
import eu.numberfour.n4js.resource.N4JSResource;
import eu.numberfour.n4js.transpiler.im.Script_IM;
import eu.numberfour.n4js.transpiler.im.SymbolTableEntry;
import eu.numberfour.n4js.transpiler.im.SymbolTableEntryInternal;
import eu.numberfour.n4js.transpiler.im.SymbolTableEntryOriginal;
import eu.numberfour.n4js.transpiler.operations.SymbolTableManagement;
import eu.numberfour.n4js.ts.types.IdentifiableElement;
import eu.numberfour.n4js.typesystem.RuleEnvironmentExtensions;
import eu.numberfour.n4js.utils.ContainerTypesHelper.MemberCollector;
import eu.numberfour.n4js.utils.di.scopes.ScopeManager;
import eu.numberfour.n4js.utils.di.scopes.TransformationScoped;
import it.xsemantics.runtime.RuleEnvironment;

/**
 * Data class for all information that is required during transpilation of a resource. This will be passed to all
 * transformations and the pretty-printer.
 */
@TransformationScoped
public class TranspilerState {

	/**
	 * The original resource to transpile. Should <b>never</b> be modified in any way from within the transpiler.
	 */
	public final N4JSResource resource;

	/**
	 * An empty rule environment for the {@link #resource original resource to compile}. Client-code should not change
	 * this rule environment; if you want to change it, you should first wrap it using
	 * {@link RuleEnvironmentExtensions#wrap(RuleEnvironment)}.
	 */
	public final RuleEnvironment G;

	/**
	 * A {@link MemberCollector member collector} created with the {@link #resource resource to transpile} as context.
	 */
	public final MemberCollector memberCollector;

	/**
	 * The intermediate model. This starts out as a copy of the AST of the original resource to compile (but with some
	 * re-wiring and some other minor changes to make it self-contained) and will be gradually transformed by the
	 * transpiler's transformations before being pretty-printed into the final output.
	 */
	public final Script_IM im;

	/**
	 * The tracer keeping track of associations from nodes in the intermediate model to nodes in the original resource
	 * to transpile or other, referenced resources.
	 */
	public final Tracer tracer;

	/**
	 * Data storage that holds information that will be passed from one transformation to another. This means some
	 * transformations will put information into this registry and others will read from it.
	 */
	public final InformationRegistry info;

	/**
	 * Managing instance for the symbol tables.
	 */
	public final STECache steCache;

	/**
	 * Creates a new transpiler state.
	 */
	public TranspilerState(N4JSResource resource, MemberCollector memberCollector, Script_IM im, STECache steCache,
			Tracer tracer,
			InformationRegistry info) {
		this.resource = resource;
		this.G = RuleEnvironmentExtensions.newRuleEnvironment(resource);
		this.memberCollector = memberCollector;
		this.im = im;
		this.tracer = tracer;
		this.info = info;
		this.steCache = steCache;
		// check
		if (this.steCache.im != this.im)
			throw new IllegalStateException(
					"The symbol table cache must be configured for the same intermediate model.");
	}

	/**
	 * Provided only because Guice validates this class (and checks for a no-argument constructor). But we do not
	 * actually need it, because {@link AbstractTranspiler#transform(TranspilerState)} will register an instance via
	 * {@link ScopeManager#bind(Class, Class, Object)} that was created with the other constructor (so Guice will never
	 * have to create an instance itself).
	 */
	public TranspilerState() {
		throw new IllegalStateException("don't use empty constructor of TranspilerState");
	}

	/** The internal cache of STEs managed by {@link SymbolTableManagement} */
	public static class STECache {

		/** Map identifeable to original STE */
		public final HashMap<IdentifiableElement, SymbolTableEntryOriginal> mapOriginal = new HashMap<>();

		/** Map name to internal STE */
		public final HashMap<String, SymbolTableEntryInternal> mapInternal = new HashMap<>();

		// inverse maps:
		/** Map named element back to STE, inverse of ste.elementsOfThisName */
		public final HashMap<NamedElement, SymbolTableEntry> mapNamedElement_2_STE = new HashMap<>();

		/** ref to our Script_IM */
		public final Script_IM im;

		/** */
		public STECache(Script_IM im) {
			this.im = im;
		}

	}

}
