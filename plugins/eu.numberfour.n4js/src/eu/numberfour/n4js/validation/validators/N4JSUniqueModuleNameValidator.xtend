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
package eu.numberfour.n4js.validation.validators

import com.google.inject.Inject
import com.google.inject.Provider
import eu.numberfour.n4js.N4JSGlobals
import eu.numberfour.n4js.n4JS.AnnotableElement
import eu.numberfour.n4js.n4JS.Script
import eu.numberfour.n4js.projectModel.IN4JSCore
import eu.numberfour.n4js.validation.AbstractN4JSDeclarativeValidator
import eu.numberfour.n4js.validation.IssueCodes
import eu.numberfour.n4js.ts.types.TAnnotableElement
import eu.numberfour.n4js.ts.types.TModule
import eu.numberfour.n4js.ts.types.TypesPackage
import java.util.List
import java.util.regex.Pattern
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.resource.IContainer
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.validation.EValidatorRegistrar

import static eu.numberfour.n4js.AnnotationDefinition.*
import org.eclipse.emf.common.util.URI
import java.util.Set

/**
 * Validates unique module names
 */
class N4JSUniqueModuleNameValidator extends AbstractN4JSDeclarativeValidator {

	@Inject ResourceDescriptionsProvider resourceDescriptionsProvider

	@Inject IResourceDescription.Manager resourceDescriptionManager

	@Inject IContainer.Manager containerManager

	@Inject IQualifiedNameConverter qualifiedNameConverter

	@Inject IN4JSCore n4jscore;

	/**
	 * NEEDED
	 *
	 * when removed check methods will be called twice once by N4JSValidator, and once by
	 * AbstractDeclarativeN4JSValidator
	 */
	override register(EValidatorRegistrar registrar) {
		// nop
	}

	/**
	 * Validates the module name that is derived from the given script.
	 *
	 * This validation is defined for the script itself since we need it for the error marker anyway
	 */
	@Check
	def void checkUniqueName(Script script) {
		if (script.eResource.URI.fileExtension != N4JSGlobals.JS_FILE_EXTENSION) {
			script.checkUniqueName(script.module)
		}
	}

	/**
	 * If the module exists, obtain its name and validate it for uniqueness.
	 */
	protected def void checkUniqueName(Script script, TModule module) {
		if (module === null) {
			return
		}
		val name = qualifiedNameConverter.toQualifiedName(module.qualifiedName)
		if (name !== null) {
			script.doCheckUniqueName(module, name )
		}
	}

	/**
	 * Find all other modules in the index with the same name and check all the obtained
	 * candidates for reachable duplicates.
	 */
	protected def doCheckUniqueName(Script script, TModule module, QualifiedName name) {
		val resource = module.eResource as XtextResource
		val index = resourceDescriptionsProvider.getResourceDescriptions(resource)
		val others = index.getExportedObjects(TypesPackage.Literals.TMODULE, name, false)
		script.checkUniqueInIndex(module, others) [
			val description = index.getResourceDescription(resource.URI) ?: resourceDescriptionManager.getResourceDescription(resource)
			if (description === null) {
				return emptyList
			}
			return containerManager.getVisibleContainers(description, index)
		]
	}

	/**
	 * Check the found candidates for reach	ability via the visible containers.
	 */
	protected def void checkUniqueInIndex(Script script, TModule module, Iterable<IEObjectDescription> descriptions, Provider<List<IContainer>> lazyContainersList) {
		val resourceURIs = descriptions.map[
			EObjectURI.trimFragment
		].filter[
			it != EcoreUtil2.getPlatformResourceOrNormalizedURI(module.eResource) && fileExtension != N4JSGlobals.JS_FILE_EXTENSION
		].toSet

		if (resourceURIs.size > 0) {
			val visibleResourceURIs = newHashSet
			lazyContainersList.get.forEach[ container |
				visibleResourceURIs += resourceURIs.filter[ uri | container.hasResourceDescription(uri) ]
			]

			if (visibleResourceURIs.size > 0) {
				// there can only be one static_polyfill_aware resource
				if( module.isStaticPolyfillAware ) {
					// we are the Aware. --> err, if others are as well
					// IDE-1735
					// for now: allow one other modules with same name.
					if( visibleResourceURIs.size == 1) return
				} else {
					if ( module.isStaticPolyfillModule ) {
						// maybe one of the others is the Aware --> all OK, if none, then Error
						// IDE-1735 unless checking other files of @PolyfillAware, for now just don't issue
						if( visibleResourceURIs.size == 1) return
					}
				}

				// Normal Polfyfill
				if( script.hasPolyfill && ! module.isStaticPolyfillModule ) {
					// IDE-1735 in case of normal Polyfill this can't be mixed with static polyfills.
					return
				}

				var Set<URI>filteredMutVisibleResourceURIs = visibleResourceURIs

				// non MainModules are follow normal visibility check
				// but MainModules have checks relaxed:
				if(module.isMainModule){
					val pr = n4jscore.findProject(module.eResource.URI).get
					filteredMutVisibleResourceURIs = filteredMutVisibleResourceURIs.filter[u| {
							 if(pr == n4jscore.findProject(u).get){
								// the same project, MainModule is hidden within the project
								//if other file with the same source container relative path
								//(also across different containers)
								val baseModuleSrcCon = n4jscore.findN4JSSourceContainer(module.eResource.URI).get.location.toString
								val otherModuleSrcCon = n4jscore.findN4JSSourceContainer(u).get.location.toString;

								val baseModuleSrcContainerRelativePath = module.eResource.URI.toString.substring(baseModuleSrcCon.length)
								val otherModuleSrcContainerRelativePath = u.toString.substring(otherModuleSrcCon.length)
								return baseModuleSrcContainerRelativePath == otherModuleSrcContainerRelativePath
							}else{
								//main modules are not hidden by main module in other projects
								//(resolved by project import)
								//and are not hidden by non main modules, as module import
								//will always resolve to local module (MainModule)
								false
							}
						}].toSet
				}

				if(filteredMutVisibleResourceURIs.isEmpty) return;

				// list all locations - give the user the possibility to check by himself.
				val msg = filteredMutVisibleResourceURIs.map[segmentsList.drop(1).join('/')].join("; ")

				script.addIssue(module, msg )
			}
		}
	}


	/** @returns true if the script contains a toplevel-type annotated with a {@code @Polyfill}. */
	private def boolean hasPolyfill(Script script) {
		for (se:script.scriptElements){
			switch (se) {
			 AnnotableElement : { if( POLYFILL.hasAnnotation(se) ) return true;}
			 TAnnotableElement : {	if( POLYFILL.hasAnnotation(se) ) return true;}
			}
		}
		return false;
	}

	static val nonEmpty = Pattern.compile('^.+$', Pattern.MULTILINE)

	/**
	 * Annotated the script with a an error marker on first the AST element or the first none-empty line.
	 */
	protected def void addIssue(Script script, TModule module, String filePath) {
		val message = IssueCodes.getMessageForCLF_DUP_MODULE(module.qualifiedName, filePath)

		val first = script.scriptElements.head
		if(first !== null){
			addIssue(message, first, IssueCodes.CLF_DUP_MODULE)
			return
		}
		val resource = script.eResource as XtextResource
		val parseResult = resource.parseResult
		val rootNode = parseResult.rootNode
		val text = rootNode.text
		val matcher = nonEmpty.matcher(text)
		var start = 0
		var end = text.length
		if (matcher.find) {
			start = matcher.start
			end = matcher.end
		}
		addIssue(message, script, start, end - start, IssueCodes.CLF_DUP_MODULE)
	}

}
