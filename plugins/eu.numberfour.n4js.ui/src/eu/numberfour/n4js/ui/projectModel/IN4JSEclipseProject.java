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
package eu.numberfour.n4js.ui.projectModel;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;

import com.google.common.collect.ImmutableList;

import eu.numberfour.n4js.projectModel.IN4JSProject;

/**
 * A N4JS project represents a view of a project resource in terms of n4js elements such as manifest, libraries and
 * contained JS files.
 * <p>
 * An instance of one of these handles can be created via
 * {@link IN4JSEclipseCore#create(org.eclipse.core.resources.IProject)}.
 * </p>
 *
 * @see IN4JSEclipseCore#create(org.eclipse.core.resources.IProject)
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface IN4JSEclipseProject extends IN4JSProject {

	/**
	 * Returns the <code>IProject</code> on which this <code>IN4JSEclipseProject</code> was created.
	 *
	 * @return the <code>IProject</code> on which this <code>IN4JSEclipseProject</code> was created
	 */
	IProject getProject();

	/**
	 * Returns a platform resource URI of the form {@code platform:/resource/projectName}.
	 */
	@Override
	URI getLocation();

	@Override
	ImmutableList<? extends IN4JSEclipseSourceContainer> getSourceContainers();

	@Override
	ImmutableList<? extends IN4JSEclipseProject> getDependencies();

	@Override
	ImmutableList<? extends IN4JSEclipseProject> getDependenciesAndImplementedApis();
}
