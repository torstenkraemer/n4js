/**
 * Copyright (c) 2016 NumberFour AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package eu.numberfour.n4js.jsdoc.dom.impl;

import com.google.common.base.Objects;

import eu.numberfour.n4js.jsdoc.JSDocSerializer;

import eu.numberfour.n4js.jsdoc.dom.DomFactory;
import eu.numberfour.n4js.jsdoc.dom.DomPackage;
import eu.numberfour.n4js.jsdoc.dom.JSDocNode;
import eu.numberfour.n4js.jsdoc.dom.Marker;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.xbase.lib.Functions.Function1;

import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>JS Doc Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.numberfour.n4js.jsdoc.dom.impl.JSDocNodeImpl#getMarkers <em>Markers</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class JSDocNodeImpl extends DocletElementImpl implements JSDocNode {
	/**
	 * The cached value of the '{@link #getMarkers() <em>Markers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMarkers()
	 * @generated
	 * @ordered
	 */
	protected EList<Marker> markers;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JSDocNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DomPackage.Literals.JS_DOC_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Marker> getMarkers() {
		if (markers == null) {
			markers = new EObjectContainmentEList<Marker>(Marker.class, this, DomPackage.JS_DOC_NODE__MARKERS);
		}
		return markers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMarkerValue(final String theKey) {
		EList<Marker> _markers = this.getMarkers();
		final Function1<Marker, Boolean> _function = new Function1<Marker, Boolean>() {
			public Boolean apply(final Marker it) {
				String _key = it.getKey();
				return Boolean.valueOf(Objects.equal(_key, theKey));
			}
		};
		Marker _findFirst = IterableExtensions.<Marker>findFirst(_markers, _function);
		String _value = null;
		if (_findFirst!=null) {
			_value=_findFirst.getValue();
		}
		return _value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMarker(final String theKey, final String value) {
		EList<Marker> _markers = this.getMarkers();
		final Function1<Marker, Boolean> _function = new Function1<Marker, Boolean>() {
			public Boolean apply(final Marker it) {
				String _key = it.getKey();
				String _key_1 = it.getKey();
				return Boolean.valueOf(Objects.equal(_key, _key_1));
			}
		};
		Marker marker = IterableExtensions.<Marker>findFirst(_markers, _function);
		boolean _equals = Objects.equal(marker, null);
		if (_equals) {
			Marker _createMarker = DomFactory.eINSTANCE.createMarker();
			marker = _createMarker;
			marker.setKey(theKey);
			EList<Marker> _markers_1 = this.getMarkers();
			_markers_1.add(marker);
		}
		marker.setValue(value);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMarkedAs(final String theKey, final String theValue) {
		EList<Marker> _markers = this.getMarkers();
		final Function1<Marker, Boolean> _function = new Function1<Marker, Boolean>() {
			public Boolean apply(final Marker it) {
				boolean _and = false;
				String _key = it.getKey();
				boolean _equals = Objects.equal(_key, theKey);
				if (!_equals) {
					_and = false;
				} else {
					String _value = it.getValue();
					boolean _equals_1 = Objects.equal(_value, theValue);
					_and = _equals_1;
				}
				return Boolean.valueOf(_and);
			}
		};
		Marker _findFirst = IterableExtensions.<Marker>findFirst(_markers, _function);
		return (_findFirst != null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		return JSDocSerializer.toJSDocString(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DomPackage.JS_DOC_NODE__MARKERS:
				return ((InternalEList<?>)getMarkers()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DomPackage.JS_DOC_NODE__MARKERS:
				return getMarkers();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DomPackage.JS_DOC_NODE__MARKERS:
				getMarkers().clear();
				getMarkers().addAll((Collection<? extends Marker>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case DomPackage.JS_DOC_NODE__MARKERS:
				getMarkers().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DomPackage.JS_DOC_NODE__MARKERS:
				return markers != null && !markers.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case DomPackage.JS_DOC_NODE___GET_MARKER_VALUE__STRING:
				return getMarkerValue((String)arguments.get(0));
			case DomPackage.JS_DOC_NODE___SET_MARKER__STRING_STRING:
				setMarker((String)arguments.get(0), (String)arguments.get(1));
				return null;
			case DomPackage.JS_DOC_NODE___IS_MARKED_AS__STRING_STRING:
				return isMarkedAs((String)arguments.get(0), (String)arguments.get(1));
			case DomPackage.JS_DOC_NODE___TO_STRING:
				return toString();
		}
		return super.eInvoke(operationID, arguments);
	}

} //JSDocNodeImpl
