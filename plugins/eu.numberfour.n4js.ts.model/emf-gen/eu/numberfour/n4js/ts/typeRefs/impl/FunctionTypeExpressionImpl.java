/**
 * Copyright (c) 2016 NumberFour AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package eu.numberfour.n4js.ts.typeRefs.impl;

import eu.numberfour.n4js.ts.typeRefs.FunctionTypeExpression;
import eu.numberfour.n4js.ts.typeRefs.ParameterizedTypeRef;
import eu.numberfour.n4js.ts.typeRefs.TypeRef;
import eu.numberfour.n4js.ts.typeRefs.TypeRefsPackage;

import eu.numberfour.n4js.ts.types.TFormalParameter;
import eu.numberfour.n4js.ts.types.TFunction;
import eu.numberfour.n4js.ts.types.TypeVariable;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.ecore.xcore.lib.XcoreCollectionLiterals;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function Type Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.numberfour.n4js.ts.typeRefs.impl.FunctionTypeExpressionImpl#isBinding <em>Binding</em>}</li>
 *   <li>{@link eu.numberfour.n4js.ts.typeRefs.impl.FunctionTypeExpressionImpl#getDeclaredType <em>Declared Type</em>}</li>
 *   <li>{@link eu.numberfour.n4js.ts.typeRefs.impl.FunctionTypeExpressionImpl#getDeclaredThisType <em>Declared This Type</em>}</li>
 *   <li>{@link eu.numberfour.n4js.ts.typeRefs.impl.FunctionTypeExpressionImpl#getOwnedTypeVars <em>Owned Type Vars</em>}</li>
 *   <li>{@link eu.numberfour.n4js.ts.typeRefs.impl.FunctionTypeExpressionImpl#getUnboundTypeVars <em>Unbound Type Vars</em>}</li>
 *   <li>{@link eu.numberfour.n4js.ts.typeRefs.impl.FunctionTypeExpressionImpl#getUnboundTypeVarsUpperBounds <em>Unbound Type Vars Upper Bounds</em>}</li>
 *   <li>{@link eu.numberfour.n4js.ts.typeRefs.impl.FunctionTypeExpressionImpl#getFpars <em>Fpars</em>}</li>
 *   <li>{@link eu.numberfour.n4js.ts.typeRefs.impl.FunctionTypeExpressionImpl#getReturnTypeRef <em>Return Type Ref</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FunctionTypeExpressionImpl extends FunctionTypeExprOrRefImpl implements FunctionTypeExpression {
	/**
	 * The default value of the '{@link #isBinding() <em>Binding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBinding()
	 * @generated
	 * @ordered
	 */
	protected static final boolean BINDING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isBinding() <em>Binding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBinding()
	 * @generated
	 * @ordered
	 */
	protected boolean binding = BINDING_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDeclaredType() <em>Declared Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeclaredType()
	 * @generated
	 * @ordered
	 */
	protected TFunction declaredType;

	/**
	 * The cached value of the '{@link #getDeclaredThisType() <em>Declared This Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeclaredThisType()
	 * @generated
	 * @ordered
	 */
	protected TypeRef declaredThisType;

	/**
	 * The cached value of the '{@link #getOwnedTypeVars() <em>Owned Type Vars</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedTypeVars()
	 * @generated
	 * @ordered
	 */
	protected EList<TypeVariable> ownedTypeVars;

	/**
	 * The cached value of the '{@link #getUnboundTypeVars() <em>Unbound Type Vars</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnboundTypeVars()
	 * @generated
	 * @ordered
	 */
	protected EList<TypeVariable> unboundTypeVars;

	/**
	 * The cached value of the '{@link #getUnboundTypeVarsUpperBounds() <em>Unbound Type Vars Upper Bounds</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnboundTypeVarsUpperBounds()
	 * @generated
	 * @ordered
	 */
	protected EList<TypeRef> unboundTypeVarsUpperBounds;

	/**
	 * The cached value of the '{@link #getFpars() <em>Fpars</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFpars()
	 * @generated
	 * @ordered
	 */
	protected EList<TFormalParameter> fpars;

	/**
	 * The cached value of the '{@link #getReturnTypeRef() <em>Return Type Ref</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReturnTypeRef()
	 * @generated
	 * @ordered
	 */
	protected TypeRef returnTypeRef;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionTypeExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TypeRefsPackage.Literals.FUNCTION_TYPE_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isBinding() {
		return binding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBinding(boolean newBinding) {
		boolean oldBinding = binding;
		binding = newBinding;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypeRefsPackage.FUNCTION_TYPE_EXPRESSION__BINDING, oldBinding, binding));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TFunction getDeclaredType() {
		if (declaredType != null && declaredType.eIsProxy()) {
			InternalEObject oldDeclaredType = (InternalEObject)declaredType;
			declaredType = (TFunction)eResolveProxy(oldDeclaredType);
			if (declaredType != oldDeclaredType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TypeRefsPackage.FUNCTION_TYPE_EXPRESSION__DECLARED_TYPE, oldDeclaredType, declaredType));
			}
		}
		return declaredType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TFunction basicGetDeclaredType() {
		return declaredType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeclaredType(TFunction newDeclaredType) {
		TFunction oldDeclaredType = declaredType;
		declaredType = newDeclaredType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypeRefsPackage.FUNCTION_TYPE_EXPRESSION__DECLARED_TYPE, oldDeclaredType, declaredType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeRef getDeclaredThisType() {
		return declaredThisType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDeclaredThisType(TypeRef newDeclaredThisType, NotificationChain msgs) {
		TypeRef oldDeclaredThisType = declaredThisType;
		declaredThisType = newDeclaredThisType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TypeRefsPackage.FUNCTION_TYPE_EXPRESSION__DECLARED_THIS_TYPE, oldDeclaredThisType, newDeclaredThisType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeclaredThisType(TypeRef newDeclaredThisType) {
		if (newDeclaredThisType != declaredThisType) {
			NotificationChain msgs = null;
			if (declaredThisType != null)
				msgs = ((InternalEObject)declaredThisType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TypeRefsPackage.FUNCTION_TYPE_EXPRESSION__DECLARED_THIS_TYPE, null, msgs);
			if (newDeclaredThisType != null)
				msgs = ((InternalEObject)newDeclaredThisType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TypeRefsPackage.FUNCTION_TYPE_EXPRESSION__DECLARED_THIS_TYPE, null, msgs);
			msgs = basicSetDeclaredThisType(newDeclaredThisType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypeRefsPackage.FUNCTION_TYPE_EXPRESSION__DECLARED_THIS_TYPE, newDeclaredThisType, newDeclaredThisType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypeVariable> getOwnedTypeVars() {
		if (ownedTypeVars == null) {
			ownedTypeVars = new EObjectContainmentEList<TypeVariable>(TypeVariable.class, this, TypeRefsPackage.FUNCTION_TYPE_EXPRESSION__OWNED_TYPE_VARS);
		}
		return ownedTypeVars;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypeVariable> getUnboundTypeVars() {
		if (unboundTypeVars == null) {
			unboundTypeVars = new EObjectResolvingEList<TypeVariable>(TypeVariable.class, this, TypeRefsPackage.FUNCTION_TYPE_EXPRESSION__UNBOUND_TYPE_VARS);
		}
		return unboundTypeVars;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypeRef> getUnboundTypeVarsUpperBounds() {
		if (unboundTypeVarsUpperBounds == null) {
			unboundTypeVarsUpperBounds = new EObjectContainmentEList<TypeRef>(TypeRef.class, this, TypeRefsPackage.FUNCTION_TYPE_EXPRESSION__UNBOUND_TYPE_VARS_UPPER_BOUNDS);
		}
		return unboundTypeVarsUpperBounds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TFormalParameter> getFpars() {
		if (fpars == null) {
			fpars = new EObjectContainmentEList<TFormalParameter>(TFormalParameter.class, this, TypeRefsPackage.FUNCTION_TYPE_EXPRESSION__FPARS);
		}
		return fpars;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeRef getReturnTypeRef() {
		return returnTypeRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReturnTypeRef(TypeRef newReturnTypeRef, NotificationChain msgs) {
		TypeRef oldReturnTypeRef = returnTypeRef;
		returnTypeRef = newReturnTypeRef;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TypeRefsPackage.FUNCTION_TYPE_EXPRESSION__RETURN_TYPE_REF, oldReturnTypeRef, newReturnTypeRef);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReturnTypeRef(TypeRef newReturnTypeRef) {
		if (newReturnTypeRef != returnTypeRef) {
			NotificationChain msgs = null;
			if (returnTypeRef != null)
				msgs = ((InternalEObject)returnTypeRef).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TypeRefsPackage.FUNCTION_TYPE_EXPRESSION__RETURN_TYPE_REF, null, msgs);
			if (newReturnTypeRef != null)
				msgs = ((InternalEObject)newReturnTypeRef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TypeRefsPackage.FUNCTION_TYPE_EXPRESSION__RETURN_TYPE_REF, null, msgs);
			msgs = basicSetReturnTypeRef(newReturnTypeRef, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypeRefsPackage.FUNCTION_TYPE_EXPRESSION__RETURN_TYPE_REF, newReturnTypeRef, newReturnTypeRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypeVariable> getTypeVars() {
		EList<TypeVariable> _xifexpression = null;
		boolean _isBinding = this.isBinding();
		if (_isBinding) {
			_xifexpression = this.getUnboundTypeVars();
		}
		else {
			EList<TypeVariable> _xifexpression_1 = null;
			TFunction _declaredType = this.getDeclaredType();
			boolean _tripleNotEquals = (_declaredType != null);
			if (_tripleNotEquals) {
				TFunction _declaredType_1 = this.getDeclaredType();
				_xifexpression_1 = _declaredType_1.getTypeVars();
			}
			else {
				_xifexpression_1 = this.getOwnedTypeVars();
			}
			_xifexpression = _xifexpression_1;
		}
		return _xifexpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypeRef> getTypeVarUpperBounds(final TypeVariable typeVar) {
		if ((typeVar == null)) {
			throw new IllegalArgumentException("given type variable may not be null");
		}
		EList<TypeVariable> _unboundTypeVars = this.getUnboundTypeVars();
		final int idx = _unboundTypeVars.indexOf(typeVar);
		boolean _and = false;
		if (!(idx >= 0)) {
			_and = false;
		} else {
			EList<TypeRef> _unboundTypeVarsUpperBounds = this.getUnboundTypeVarsUpperBounds();
			int _size = _unboundTypeVarsUpperBounds.size();
			boolean _lessThan = (idx < _size);
			_and = _lessThan;
		}
		if (_and) {
			EList<TypeRef> _unboundTypeVarsUpperBounds_1 = this.getUnboundTypeVarsUpperBounds();
			final TypeRef modifiedUpperBound = _unboundTypeVarsUpperBounds_1.get(idx);
			if ((modifiedUpperBound != null)) {
				return XcoreCollectionLiterals.<TypeRef>newImmutableEList(modifiedUpperBound);
			}
		}
		EList<ParameterizedTypeRef> _declaredUpperBounds = typeVar.getDeclaredUpperBounds();
		return XcoreCollectionLiterals.<TypeRef>newImmutableEList(((TypeRef[])org.eclipse.xtext.xbase.lib.Conversions.unwrapArray(_declaredUpperBounds, TypeRef.class)));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TypeRefsPackage.FUNCTION_TYPE_EXPRESSION__DECLARED_THIS_TYPE:
				return basicSetDeclaredThisType(null, msgs);
			case TypeRefsPackage.FUNCTION_TYPE_EXPRESSION__OWNED_TYPE_VARS:
				return ((InternalEList<?>)getOwnedTypeVars()).basicRemove(otherEnd, msgs);
			case TypeRefsPackage.FUNCTION_TYPE_EXPRESSION__UNBOUND_TYPE_VARS_UPPER_BOUNDS:
				return ((InternalEList<?>)getUnboundTypeVarsUpperBounds()).basicRemove(otherEnd, msgs);
			case TypeRefsPackage.FUNCTION_TYPE_EXPRESSION__FPARS:
				return ((InternalEList<?>)getFpars()).basicRemove(otherEnd, msgs);
			case TypeRefsPackage.FUNCTION_TYPE_EXPRESSION__RETURN_TYPE_REF:
				return basicSetReturnTypeRef(null, msgs);
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
			case TypeRefsPackage.FUNCTION_TYPE_EXPRESSION__BINDING:
				return isBinding();
			case TypeRefsPackage.FUNCTION_TYPE_EXPRESSION__DECLARED_TYPE:
				if (resolve) return getDeclaredType();
				return basicGetDeclaredType();
			case TypeRefsPackage.FUNCTION_TYPE_EXPRESSION__DECLARED_THIS_TYPE:
				return getDeclaredThisType();
			case TypeRefsPackage.FUNCTION_TYPE_EXPRESSION__OWNED_TYPE_VARS:
				return getOwnedTypeVars();
			case TypeRefsPackage.FUNCTION_TYPE_EXPRESSION__UNBOUND_TYPE_VARS:
				return getUnboundTypeVars();
			case TypeRefsPackage.FUNCTION_TYPE_EXPRESSION__UNBOUND_TYPE_VARS_UPPER_BOUNDS:
				return getUnboundTypeVarsUpperBounds();
			case TypeRefsPackage.FUNCTION_TYPE_EXPRESSION__FPARS:
				return getFpars();
			case TypeRefsPackage.FUNCTION_TYPE_EXPRESSION__RETURN_TYPE_REF:
				return getReturnTypeRef();
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
			case TypeRefsPackage.FUNCTION_TYPE_EXPRESSION__BINDING:
				setBinding((Boolean)newValue);
				return;
			case TypeRefsPackage.FUNCTION_TYPE_EXPRESSION__DECLARED_TYPE:
				setDeclaredType((TFunction)newValue);
				return;
			case TypeRefsPackage.FUNCTION_TYPE_EXPRESSION__DECLARED_THIS_TYPE:
				setDeclaredThisType((TypeRef)newValue);
				return;
			case TypeRefsPackage.FUNCTION_TYPE_EXPRESSION__OWNED_TYPE_VARS:
				getOwnedTypeVars().clear();
				getOwnedTypeVars().addAll((Collection<? extends TypeVariable>)newValue);
				return;
			case TypeRefsPackage.FUNCTION_TYPE_EXPRESSION__UNBOUND_TYPE_VARS:
				getUnboundTypeVars().clear();
				getUnboundTypeVars().addAll((Collection<? extends TypeVariable>)newValue);
				return;
			case TypeRefsPackage.FUNCTION_TYPE_EXPRESSION__UNBOUND_TYPE_VARS_UPPER_BOUNDS:
				getUnboundTypeVarsUpperBounds().clear();
				getUnboundTypeVarsUpperBounds().addAll((Collection<? extends TypeRef>)newValue);
				return;
			case TypeRefsPackage.FUNCTION_TYPE_EXPRESSION__FPARS:
				getFpars().clear();
				getFpars().addAll((Collection<? extends TFormalParameter>)newValue);
				return;
			case TypeRefsPackage.FUNCTION_TYPE_EXPRESSION__RETURN_TYPE_REF:
				setReturnTypeRef((TypeRef)newValue);
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
			case TypeRefsPackage.FUNCTION_TYPE_EXPRESSION__BINDING:
				setBinding(BINDING_EDEFAULT);
				return;
			case TypeRefsPackage.FUNCTION_TYPE_EXPRESSION__DECLARED_TYPE:
				setDeclaredType((TFunction)null);
				return;
			case TypeRefsPackage.FUNCTION_TYPE_EXPRESSION__DECLARED_THIS_TYPE:
				setDeclaredThisType((TypeRef)null);
				return;
			case TypeRefsPackage.FUNCTION_TYPE_EXPRESSION__OWNED_TYPE_VARS:
				getOwnedTypeVars().clear();
				return;
			case TypeRefsPackage.FUNCTION_TYPE_EXPRESSION__UNBOUND_TYPE_VARS:
				getUnboundTypeVars().clear();
				return;
			case TypeRefsPackage.FUNCTION_TYPE_EXPRESSION__UNBOUND_TYPE_VARS_UPPER_BOUNDS:
				getUnboundTypeVarsUpperBounds().clear();
				return;
			case TypeRefsPackage.FUNCTION_TYPE_EXPRESSION__FPARS:
				getFpars().clear();
				return;
			case TypeRefsPackage.FUNCTION_TYPE_EXPRESSION__RETURN_TYPE_REF:
				setReturnTypeRef((TypeRef)null);
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
			case TypeRefsPackage.FUNCTION_TYPE_EXPRESSION__BINDING:
				return binding != BINDING_EDEFAULT;
			case TypeRefsPackage.FUNCTION_TYPE_EXPRESSION__DECLARED_TYPE:
				return declaredType != null;
			case TypeRefsPackage.FUNCTION_TYPE_EXPRESSION__DECLARED_THIS_TYPE:
				return declaredThisType != null;
			case TypeRefsPackage.FUNCTION_TYPE_EXPRESSION__OWNED_TYPE_VARS:
				return ownedTypeVars != null && !ownedTypeVars.isEmpty();
			case TypeRefsPackage.FUNCTION_TYPE_EXPRESSION__UNBOUND_TYPE_VARS:
				return unboundTypeVars != null && !unboundTypeVars.isEmpty();
			case TypeRefsPackage.FUNCTION_TYPE_EXPRESSION__UNBOUND_TYPE_VARS_UPPER_BOUNDS:
				return unboundTypeVarsUpperBounds != null && !unboundTypeVarsUpperBounds.isEmpty();
			case TypeRefsPackage.FUNCTION_TYPE_EXPRESSION__FPARS:
				return fpars != null && !fpars.isEmpty();
			case TypeRefsPackage.FUNCTION_TYPE_EXPRESSION__RETURN_TYPE_REF:
				return returnTypeRef != null;
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
			case TypeRefsPackage.FUNCTION_TYPE_EXPRESSION___GET_TYPE_VARS:
				return getTypeVars();
			case TypeRefsPackage.FUNCTION_TYPE_EXPRESSION___GET_TYPE_VAR_UPPER_BOUNDS__TYPEVARIABLE:
				return getTypeVarUpperBounds((TypeVariable)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (binding: ");
		result.append(binding);
		result.append(')');
		return result.toString();
	}

} //FunctionTypeExpressionImpl
