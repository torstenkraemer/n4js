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
package eu.numberfour.n4js;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.xtext.ISetup;

import com.google.inject.Guice;
import com.google.inject.Injector;

import eu.numberfour.n4js.n4JS.N4JSPackage;
import eu.numberfour.n4js.n4mf.N4MFStandaloneSetup;
import eu.numberfour.n4js.n4mf.N4mfPackage;
import eu.numberfour.n4js.regex.RegularExpressionStandaloneSetup;
import eu.numberfour.n4js.ts.TypesStandaloneSetup;
import eu.numberfour.n4js.ts.typeRefs.TypeRefsPackage;
import eu.numberfour.n4js.ts.types.TypesPackage;

/**
 * Initialization support for running Xtext languages without equinox extension registry. The content here is completely
 * copied from N4JSStandaloneSetup and its super classes.
 */
public class N4JSStandaloneSetup implements ISetup {

	/**
	 * @return injector configured with N4JS runtime module
	 */
	public Injector createInjector() {
		return Guice.createInjector(new eu.numberfour.n4js.N4JSRuntimeModule());
	}

	/**
	 * Performs the setup and populates the EMF registers in the standalone environment.
	 *
	 * @see #createInjectorAndDoEMFRegistration()
	 */
	public static void doSetup() {
		new N4JSStandaloneSetup().createInjectorAndDoEMFRegistration();
	}

	@Override
	public Injector createInjectorAndDoEMFRegistration() {
		// trigger class loading
		TypeRefsPackage.eINSTANCE.getNsURI();
		TypesPackage.eINSTANCE.getNsURI();
		N4JSPackage.eINSTANCE.getNsURI();
		N4mfPackage.eINSTANCE.getNsURI();
		XMLTypePackage.eINSTANCE.getNsURI();

		RegularExpressionStandaloneSetup.doSetup();

		TypesStandaloneSetup.doSetup();
		N4MFStandaloneSetup.doSetup();

		eu.numberfour.n4js.ts.TypeExpressionsStandaloneSetup.doSetup();

		Injector injector = createInjector();
		register(injector);
		return injector;
	}

	/**
	 * Registers all dependent packages (N4JS, Types, N4MF, XML) and file extensions (n4js, js)
	 *
	 * @param injector
	 *            the injector to get the resource service provider from
	 */
	public void register(Injector injector) {
		EPackage.Registry.INSTANCE.put(N4JSPackage.eINSTANCE.getNsURI(), N4JSPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(TypeRefsPackage.eINSTANCE.getNsURI(), TypeRefsPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(TypesPackage.eINSTANCE.getNsURI(), TypesPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(N4mfPackage.eINSTANCE.getNsURI(), N4mfPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(XMLTypePackage.eINSTANCE.getNsURI(), XMLTypePackage.eINSTANCE);

		org.eclipse.xtext.resource.IResourceFactory resourceFactory = injector
				.getInstance(org.eclipse.xtext.resource.IResourceFactory.class);
		org.eclipse.xtext.resource.IResourceServiceProvider serviceProvider = injector
				.getInstance(org.eclipse.xtext.resource.IResourceServiceProvider.class);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("n4js", resourceFactory);
		org.eclipse.xtext.resource.IResourceServiceProvider.Registry.INSTANCE.getExtensionToFactoryMap().put("n4js",
				serviceProvider);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("js", resourceFactory);
		org.eclipse.xtext.resource.IResourceServiceProvider.Registry.INSTANCE.getExtensionToFactoryMap().put("js",
				serviceProvider);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("n4jsd", resourceFactory);
		org.eclipse.xtext.resource.IResourceServiceProvider.Registry.INSTANCE.getExtensionToFactoryMap().put("n4jsd",
				serviceProvider);
	}
}
