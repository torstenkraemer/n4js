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
package eu.numberfour.n4js.ui.wizard.classes;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbench;

import com.google.inject.Inject;

import eu.numberfour.n4js.ui.ImageDescriptorCache.ImageRef;
import eu.numberfour.n4js.ui.wizard.classifiers.N4JSNewClassifierWizard;

/**
 * A wizard to allow the user to create a new N4JS class.
 *
 * The wizard supports the creation of new files as well as the insertion of classes into existing modules.
 */
public class N4JSNewClassWizard extends N4JSNewClassifierWizard<N4JSClassWizardModel> {

	@Inject
	private N4JSClassWizardModel model;

	@Inject
	private N4JSNewClassWizardGenerator generator;

	@Inject
	private N4JSNewClassWizardPage wizardPage;

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection, boolean nested) {
		setDefaultPageImageDescriptor(ImageRef.NEW_CLASS_WIZBAN.asImageDescriptor().orNull());
		super.init(workbench, selection, nested);
	}

	@Override
	protected N4JSClassWizardModel getModel() {
		return model;
	}

	@Override
	protected void doGenerateClassifier() {
		generator.performManifestChanges(model);
		generator.writeToFile(model);
	}

	@Override
	protected N4JSNewClassWizardPage getPage() {
		return wizardPage;
	}

}
