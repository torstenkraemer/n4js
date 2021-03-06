/**
 * Copyright (c) 2016 NumberFour AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package eu.numberfour.n4js.transpiler.im.util;

import eu.numberfour.n4js.n4JS.AnnotableElement;
import eu.numberfour.n4js.n4JS.AnnotableN4MemberDeclaration;
import eu.numberfour.n4js.n4JS.Expression;
import eu.numberfour.n4js.n4JS.FieldAccessor;
import eu.numberfour.n4js.n4JS.FunctionDefinition;
import eu.numberfour.n4js.n4JS.FunctionOrFieldAccessor;
import eu.numberfour.n4js.n4JS.GenericDeclaration;
import eu.numberfour.n4js.n4JS.GetterDeclaration;
import eu.numberfour.n4js.n4JS.IdentifierRef;
import eu.numberfour.n4js.n4JS.Literal;
import eu.numberfour.n4js.n4JS.MethodDeclaration;
import eu.numberfour.n4js.n4JS.ModifiableElement;
import eu.numberfour.n4js.n4JS.N4FieldAccessor;
import eu.numberfour.n4js.n4JS.N4GetterDeclaration;
import eu.numberfour.n4js.n4JS.N4MemberDeclaration;
import eu.numberfour.n4js.n4JS.N4MethodDeclaration;
import eu.numberfour.n4js.n4JS.N4SetterDeclaration;
import eu.numberfour.n4js.n4JS.NamedElement;
import eu.numberfour.n4js.n4JS.ParameterizedAccess;
import eu.numberfour.n4js.n4JS.ParameterizedPropertyAccessExpression;
import eu.numberfour.n4js.n4JS.PrimaryExpression;
import eu.numberfour.n4js.n4JS.PropertyNameOwner;
import eu.numberfour.n4js.n4JS.Script;
import eu.numberfour.n4js.n4JS.SetterDeclaration;
import eu.numberfour.n4js.n4JS.StrictModeRelevant;
import eu.numberfour.n4js.n4JS.StringLiteral;
import eu.numberfour.n4js.n4JS.ThisArgProvider;
import eu.numberfour.n4js.n4JS.TypeDefiningElement;
import eu.numberfour.n4js.n4JS.TypeProvidingElement;
import eu.numberfour.n4js.n4JS.TypedElement;
import eu.numberfour.n4js.n4JS.VariableEnvironmentElement;

import eu.numberfour.n4js.transpiler.im.*;

import eu.numberfour.n4js.ts.typeRefs.BaseTypeRef;
import eu.numberfour.n4js.ts.typeRefs.ParameterizedTypeRef;
import eu.numberfour.n4js.ts.typeRefs.ParameterizedTypeRefStructural;
import eu.numberfour.n4js.ts.typeRefs.StaticBaseTypeRef;
import eu.numberfour.n4js.ts.typeRefs.StructuralTypeRef;
import eu.numberfour.n4js.ts.typeRefs.TypeArgument;
import eu.numberfour.n4js.ts.typeRefs.TypeRef;

import eu.numberfour.n4js.ts.types.TypableElement;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see eu.numberfour.n4js.transpiler.im.ImPackage
 * @generated
 */
public class ImAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ImPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ImPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImSwitch<Adapter> modelSwitch =
		new ImSwitch<Adapter>() {
			@Override
			public Adapter caseScript_IM(Script_IM object) {
				return createScript_IMAdapter();
			}
			@Override
			public Adapter caseSymbolTable(SymbolTable object) {
				return createSymbolTableAdapter();
			}
			@Override
			public Adapter caseSymbolTableEntry(SymbolTableEntry object) {
				return createSymbolTableEntryAdapter();
			}
			@Override
			public Adapter caseSymbolTableEntryOriginal(SymbolTableEntryOriginal object) {
				return createSymbolTableEntryOriginalAdapter();
			}
			@Override
			public Adapter caseSymbolTableEntryIMOnly(SymbolTableEntryIMOnly object) {
				return createSymbolTableEntryIMOnlyAdapter();
			}
			@Override
			public Adapter caseSymbolTableEntryInternal(SymbolTableEntryInternal object) {
				return createSymbolTableEntryInternalAdapter();
			}
			@Override
			public Adapter caseReferencingElement_IM(ReferencingElement_IM object) {
				return createReferencingElement_IMAdapter();
			}
			@Override
			public Adapter caseReferencingElementExpression_IM(ReferencingElementExpression_IM object) {
				return createReferencingElementExpression_IMAdapter();
			}
			@Override
			public Adapter caseIdentifierRef_IM(IdentifierRef_IM object) {
				return createIdentifierRef_IMAdapter();
			}
			@Override
			public Adapter caseParameterizedPropertyAccessExpression_IM(ParameterizedPropertyAccessExpression_IM object) {
				return createParameterizedPropertyAccessExpression_IMAdapter();
			}
			@Override
			public Adapter caseParameterizedTypeRef_IM(ParameterizedTypeRef_IM object) {
				return createParameterizedTypeRef_IMAdapter();
			}
			@Override
			public Adapter caseParameterizedTypeRefStructural_IM(ParameterizedTypeRefStructural_IM object) {
				return createParameterizedTypeRefStructural_IMAdapter();
			}
			@Override
			public Adapter caseSnippet(Snippet object) {
				return createSnippetAdapter();
			}
			@Override
			public Adapter caseDelegatingMember(DelegatingMember object) {
				return createDelegatingMemberAdapter();
			}
			@Override
			public Adapter caseDelegatingGetterDeclaration(DelegatingGetterDeclaration object) {
				return createDelegatingGetterDeclarationAdapter();
			}
			@Override
			public Adapter caseDelegatingSetterDeclaration(DelegatingSetterDeclaration object) {
				return createDelegatingSetterDeclarationAdapter();
			}
			@Override
			public Adapter caseDelegatingMethodDeclaration(DelegatingMethodDeclaration object) {
				return createDelegatingMethodDeclarationAdapter();
			}
			@Override
			public Adapter caseStringLiteralForSTE(StringLiteralForSTE object) {
				return createStringLiteralForSTEAdapter();
			}
			@Override
			public Adapter caseVariableEnvironmentElement(VariableEnvironmentElement object) {
				return createVariableEnvironmentElementAdapter();
			}
			@Override
			public Adapter caseAnnotableElement(AnnotableElement object) {
				return createAnnotableElementAdapter();
			}
			@Override
			public Adapter caseScript(Script object) {
				return createScriptAdapter();
			}
			@Override
			public Adapter caseTypableElement(TypableElement object) {
				return createTypableElementAdapter();
			}
			@Override
			public Adapter caseExpression(Expression object) {
				return createExpressionAdapter();
			}
			@Override
			public Adapter casePrimaryExpression(PrimaryExpression object) {
				return createPrimaryExpressionAdapter();
			}
			@Override
			public Adapter caseStrictModeRelevant(StrictModeRelevant object) {
				return createStrictModeRelevantAdapter();
			}
			@Override
			public Adapter caseIdentifierRef(IdentifierRef object) {
				return createIdentifierRefAdapter();
			}
			@Override
			public Adapter caseParameterizedAccess(ParameterizedAccess object) {
				return createParameterizedAccessAdapter();
			}
			@Override
			public Adapter caseParameterizedPropertyAccessExpression(ParameterizedPropertyAccessExpression object) {
				return createParameterizedPropertyAccessExpressionAdapter();
			}
			@Override
			public Adapter caseTypeArgument(TypeArgument object) {
				return createTypeArgumentAdapter();
			}
			@Override
			public Adapter caseTypeRef(TypeRef object) {
				return createTypeRefAdapter();
			}
			@Override
			public Adapter caseStaticBaseTypeRef(StaticBaseTypeRef object) {
				return createStaticBaseTypeRefAdapter();
			}
			@Override
			public Adapter caseBaseTypeRef(BaseTypeRef object) {
				return createBaseTypeRefAdapter();
			}
			@Override
			public Adapter caseParameterizedTypeRef(ParameterizedTypeRef object) {
				return createParameterizedTypeRefAdapter();
			}
			@Override
			public Adapter caseStructuralTypeRef(StructuralTypeRef object) {
				return createStructuralTypeRefAdapter();
			}
			@Override
			public Adapter caseParameterizedTypeRefStructural(ParameterizedTypeRefStructural object) {
				return createParameterizedTypeRefStructuralAdapter();
			}
			@Override
			public Adapter caseModifiableElement(ModifiableElement object) {
				return createModifiableElementAdapter();
			}
			@Override
			public Adapter caseTypeProvidingElement(TypeProvidingElement object) {
				return createTypeProvidingElementAdapter();
			}
			@Override
			public Adapter caseNamedElement(NamedElement object) {
				return createNamedElementAdapter();
			}
			@Override
			public Adapter caseN4MemberDeclaration(N4MemberDeclaration object) {
				return createN4MemberDeclarationAdapter();
			}
			@Override
			public Adapter caseThisArgProvider(ThisArgProvider object) {
				return createThisArgProviderAdapter();
			}
			@Override
			public Adapter caseFunctionOrFieldAccessor(FunctionOrFieldAccessor object) {
				return createFunctionOrFieldAccessorAdapter();
			}
			@Override
			public Adapter casePropertyNameOwner(PropertyNameOwner object) {
				return createPropertyNameOwnerAdapter();
			}
			@Override
			public Adapter caseFieldAccessor(FieldAccessor object) {
				return createFieldAccessorAdapter();
			}
			@Override
			public Adapter caseTypedElement(TypedElement object) {
				return createTypedElementAdapter();
			}
			@Override
			public Adapter caseGetterDeclaration(GetterDeclaration object) {
				return createGetterDeclarationAdapter();
			}
			@Override
			public Adapter caseAnnotableN4MemberDeclaration(AnnotableN4MemberDeclaration object) {
				return createAnnotableN4MemberDeclarationAdapter();
			}
			@Override
			public Adapter caseN4FieldAccessor(N4FieldAccessor object) {
				return createN4FieldAccessorAdapter();
			}
			@Override
			public Adapter caseN4GetterDeclaration(N4GetterDeclaration object) {
				return createN4GetterDeclarationAdapter();
			}
			@Override
			public Adapter caseSetterDeclaration(SetterDeclaration object) {
				return createSetterDeclarationAdapter();
			}
			@Override
			public Adapter caseN4SetterDeclaration(N4SetterDeclaration object) {
				return createN4SetterDeclarationAdapter();
			}
			@Override
			public Adapter caseTypeDefiningElement(TypeDefiningElement object) {
				return createTypeDefiningElementAdapter();
			}
			@Override
			public Adapter caseFunctionDefinition(FunctionDefinition object) {
				return createFunctionDefinitionAdapter();
			}
			@Override
			public Adapter caseGenericDeclaration(GenericDeclaration object) {
				return createGenericDeclarationAdapter();
			}
			@Override
			public Adapter caseMethodDeclaration(MethodDeclaration object) {
				return createMethodDeclarationAdapter();
			}
			@Override
			public Adapter caseN4MethodDeclaration(N4MethodDeclaration object) {
				return createN4MethodDeclarationAdapter();
			}
			@Override
			public Adapter caseLiteral(Literal object) {
				return createLiteralAdapter();
			}
			@Override
			public Adapter caseStringLiteral(StringLiteral object) {
				return createStringLiteralAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link eu.numberfour.n4js.transpiler.im.Script_IM <em>Script IM</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.numberfour.n4js.transpiler.im.Script_IM
	 * @generated
	 */
	public Adapter createScript_IMAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.numberfour.n4js.transpiler.im.SymbolTable <em>Symbol Table</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.numberfour.n4js.transpiler.im.SymbolTable
	 * @generated
	 */
	public Adapter createSymbolTableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.numberfour.n4js.transpiler.im.SymbolTableEntry <em>Symbol Table Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.numberfour.n4js.transpiler.im.SymbolTableEntry
	 * @generated
	 */
	public Adapter createSymbolTableEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.numberfour.n4js.transpiler.im.SymbolTableEntryOriginal <em>Symbol Table Entry Original</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.numberfour.n4js.transpiler.im.SymbolTableEntryOriginal
	 * @generated
	 */
	public Adapter createSymbolTableEntryOriginalAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.numberfour.n4js.transpiler.im.SymbolTableEntryIMOnly <em>Symbol Table Entry IM Only</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.numberfour.n4js.transpiler.im.SymbolTableEntryIMOnly
	 * @generated
	 */
	public Adapter createSymbolTableEntryIMOnlyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.numberfour.n4js.transpiler.im.SymbolTableEntryInternal <em>Symbol Table Entry Internal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.numberfour.n4js.transpiler.im.SymbolTableEntryInternal
	 * @generated
	 */
	public Adapter createSymbolTableEntryInternalAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.numberfour.n4js.transpiler.im.ReferencingElement_IM <em>Referencing Element IM</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.numberfour.n4js.transpiler.im.ReferencingElement_IM
	 * @generated
	 */
	public Adapter createReferencingElement_IMAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.numberfour.n4js.transpiler.im.ReferencingElementExpression_IM <em>Referencing Element Expression IM</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.numberfour.n4js.transpiler.im.ReferencingElementExpression_IM
	 * @generated
	 */
	public Adapter createReferencingElementExpression_IMAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.numberfour.n4js.transpiler.im.IdentifierRef_IM <em>Identifier Ref IM</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.numberfour.n4js.transpiler.im.IdentifierRef_IM
	 * @generated
	 */
	public Adapter createIdentifierRef_IMAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.numberfour.n4js.transpiler.im.ParameterizedPropertyAccessExpression_IM <em>Parameterized Property Access Expression IM</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.numberfour.n4js.transpiler.im.ParameterizedPropertyAccessExpression_IM
	 * @generated
	 */
	public Adapter createParameterizedPropertyAccessExpression_IMAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.numberfour.n4js.transpiler.im.ParameterizedTypeRef_IM <em>Parameterized Type Ref IM</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.numberfour.n4js.transpiler.im.ParameterizedTypeRef_IM
	 * @generated
	 */
	public Adapter createParameterizedTypeRef_IMAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.numberfour.n4js.transpiler.im.ParameterizedTypeRefStructural_IM <em>Parameterized Type Ref Structural IM</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.numberfour.n4js.transpiler.im.ParameterizedTypeRefStructural_IM
	 * @generated
	 */
	public Adapter createParameterizedTypeRefStructural_IMAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.numberfour.n4js.transpiler.im.Snippet <em>Snippet</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.numberfour.n4js.transpiler.im.Snippet
	 * @generated
	 */
	public Adapter createSnippetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.numberfour.n4js.transpiler.im.DelegatingMember <em>Delegating Member</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.numberfour.n4js.transpiler.im.DelegatingMember
	 * @generated
	 */
	public Adapter createDelegatingMemberAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.numberfour.n4js.transpiler.im.DelegatingGetterDeclaration <em>Delegating Getter Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.numberfour.n4js.transpiler.im.DelegatingGetterDeclaration
	 * @generated
	 */
	public Adapter createDelegatingGetterDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.numberfour.n4js.transpiler.im.DelegatingSetterDeclaration <em>Delegating Setter Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.numberfour.n4js.transpiler.im.DelegatingSetterDeclaration
	 * @generated
	 */
	public Adapter createDelegatingSetterDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.numberfour.n4js.transpiler.im.DelegatingMethodDeclaration <em>Delegating Method Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.numberfour.n4js.transpiler.im.DelegatingMethodDeclaration
	 * @generated
	 */
	public Adapter createDelegatingMethodDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.numberfour.n4js.transpiler.im.StringLiteralForSTE <em>String Literal For STE</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.numberfour.n4js.transpiler.im.StringLiteralForSTE
	 * @generated
	 */
	public Adapter createStringLiteralForSTEAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.numberfour.n4js.n4JS.VariableEnvironmentElement <em>Variable Environment Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.numberfour.n4js.n4JS.VariableEnvironmentElement
	 * @generated
	 */
	public Adapter createVariableEnvironmentElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.numberfour.n4js.n4JS.AnnotableElement <em>Annotable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.numberfour.n4js.n4JS.AnnotableElement
	 * @generated
	 */
	public Adapter createAnnotableElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.numberfour.n4js.n4JS.Script <em>Script</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.numberfour.n4js.n4JS.Script
	 * @generated
	 */
	public Adapter createScriptAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.numberfour.n4js.ts.types.TypableElement <em>Typable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.numberfour.n4js.ts.types.TypableElement
	 * @generated
	 */
	public Adapter createTypableElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.numberfour.n4js.n4JS.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.numberfour.n4js.n4JS.Expression
	 * @generated
	 */
	public Adapter createExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.numberfour.n4js.n4JS.PrimaryExpression <em>Primary Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.numberfour.n4js.n4JS.PrimaryExpression
	 * @generated
	 */
	public Adapter createPrimaryExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.numberfour.n4js.n4JS.StrictModeRelevant <em>Strict Mode Relevant</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.numberfour.n4js.n4JS.StrictModeRelevant
	 * @generated
	 */
	public Adapter createStrictModeRelevantAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.numberfour.n4js.n4JS.IdentifierRef <em>Identifier Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.numberfour.n4js.n4JS.IdentifierRef
	 * @generated
	 */
	public Adapter createIdentifierRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.numberfour.n4js.n4JS.ParameterizedAccess <em>Parameterized Access</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.numberfour.n4js.n4JS.ParameterizedAccess
	 * @generated
	 */
	public Adapter createParameterizedAccessAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.numberfour.n4js.n4JS.ParameterizedPropertyAccessExpression <em>Parameterized Property Access Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.numberfour.n4js.n4JS.ParameterizedPropertyAccessExpression
	 * @generated
	 */
	public Adapter createParameterizedPropertyAccessExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.numberfour.n4js.ts.typeRefs.TypeArgument <em>Type Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.numberfour.n4js.ts.typeRefs.TypeArgument
	 * @generated
	 */
	public Adapter createTypeArgumentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.numberfour.n4js.ts.typeRefs.TypeRef <em>Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.numberfour.n4js.ts.typeRefs.TypeRef
	 * @generated
	 */
	public Adapter createTypeRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.numberfour.n4js.ts.typeRefs.StaticBaseTypeRef <em>Static Base Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.numberfour.n4js.ts.typeRefs.StaticBaseTypeRef
	 * @generated
	 */
	public Adapter createStaticBaseTypeRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.numberfour.n4js.ts.typeRefs.BaseTypeRef <em>Base Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.numberfour.n4js.ts.typeRefs.BaseTypeRef
	 * @generated
	 */
	public Adapter createBaseTypeRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.numberfour.n4js.ts.typeRefs.ParameterizedTypeRef <em>Parameterized Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.numberfour.n4js.ts.typeRefs.ParameterizedTypeRef
	 * @generated
	 */
	public Adapter createParameterizedTypeRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.numberfour.n4js.ts.typeRefs.StructuralTypeRef <em>Structural Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.numberfour.n4js.ts.typeRefs.StructuralTypeRef
	 * @generated
	 */
	public Adapter createStructuralTypeRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.numberfour.n4js.ts.typeRefs.ParameterizedTypeRefStructural <em>Parameterized Type Ref Structural</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.numberfour.n4js.ts.typeRefs.ParameterizedTypeRefStructural
	 * @generated
	 */
	public Adapter createParameterizedTypeRefStructuralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.numberfour.n4js.n4JS.ModifiableElement <em>Modifiable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.numberfour.n4js.n4JS.ModifiableElement
	 * @generated
	 */
	public Adapter createModifiableElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.numberfour.n4js.n4JS.TypeProvidingElement <em>Type Providing Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.numberfour.n4js.n4JS.TypeProvidingElement
	 * @generated
	 */
	public Adapter createTypeProvidingElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.numberfour.n4js.n4JS.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.numberfour.n4js.n4JS.NamedElement
	 * @generated
	 */
	public Adapter createNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.numberfour.n4js.n4JS.N4MemberDeclaration <em>N4 Member Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.numberfour.n4js.n4JS.N4MemberDeclaration
	 * @generated
	 */
	public Adapter createN4MemberDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.numberfour.n4js.n4JS.ThisArgProvider <em>This Arg Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.numberfour.n4js.n4JS.ThisArgProvider
	 * @generated
	 */
	public Adapter createThisArgProviderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.numberfour.n4js.n4JS.FunctionOrFieldAccessor <em>Function Or Field Accessor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.numberfour.n4js.n4JS.FunctionOrFieldAccessor
	 * @generated
	 */
	public Adapter createFunctionOrFieldAccessorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.numberfour.n4js.n4JS.PropertyNameOwner <em>Property Name Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.numberfour.n4js.n4JS.PropertyNameOwner
	 * @generated
	 */
	public Adapter createPropertyNameOwnerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.numberfour.n4js.n4JS.FieldAccessor <em>Field Accessor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.numberfour.n4js.n4JS.FieldAccessor
	 * @generated
	 */
	public Adapter createFieldAccessorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.numberfour.n4js.n4JS.TypedElement <em>Typed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.numberfour.n4js.n4JS.TypedElement
	 * @generated
	 */
	public Adapter createTypedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.numberfour.n4js.n4JS.GetterDeclaration <em>Getter Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.numberfour.n4js.n4JS.GetterDeclaration
	 * @generated
	 */
	public Adapter createGetterDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.numberfour.n4js.n4JS.AnnotableN4MemberDeclaration <em>Annotable N4 Member Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.numberfour.n4js.n4JS.AnnotableN4MemberDeclaration
	 * @generated
	 */
	public Adapter createAnnotableN4MemberDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.numberfour.n4js.n4JS.N4FieldAccessor <em>N4 Field Accessor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.numberfour.n4js.n4JS.N4FieldAccessor
	 * @generated
	 */
	public Adapter createN4FieldAccessorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.numberfour.n4js.n4JS.N4GetterDeclaration <em>N4 Getter Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.numberfour.n4js.n4JS.N4GetterDeclaration
	 * @generated
	 */
	public Adapter createN4GetterDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.numberfour.n4js.n4JS.SetterDeclaration <em>Setter Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.numberfour.n4js.n4JS.SetterDeclaration
	 * @generated
	 */
	public Adapter createSetterDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.numberfour.n4js.n4JS.N4SetterDeclaration <em>N4 Setter Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.numberfour.n4js.n4JS.N4SetterDeclaration
	 * @generated
	 */
	public Adapter createN4SetterDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.numberfour.n4js.n4JS.TypeDefiningElement <em>Type Defining Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.numberfour.n4js.n4JS.TypeDefiningElement
	 * @generated
	 */
	public Adapter createTypeDefiningElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.numberfour.n4js.n4JS.FunctionDefinition <em>Function Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.numberfour.n4js.n4JS.FunctionDefinition
	 * @generated
	 */
	public Adapter createFunctionDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.numberfour.n4js.n4JS.GenericDeclaration <em>Generic Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.numberfour.n4js.n4JS.GenericDeclaration
	 * @generated
	 */
	public Adapter createGenericDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.numberfour.n4js.n4JS.MethodDeclaration <em>Method Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.numberfour.n4js.n4JS.MethodDeclaration
	 * @generated
	 */
	public Adapter createMethodDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.numberfour.n4js.n4JS.N4MethodDeclaration <em>N4 Method Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.numberfour.n4js.n4JS.N4MethodDeclaration
	 * @generated
	 */
	public Adapter createN4MethodDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.numberfour.n4js.n4JS.Literal <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.numberfour.n4js.n4JS.Literal
	 * @generated
	 */
	public Adapter createLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.numberfour.n4js.n4JS.StringLiteral <em>String Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.numberfour.n4js.n4JS.StringLiteral
	 * @generated
	 */
	public Adapter createStringLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ImAdapterFactory
