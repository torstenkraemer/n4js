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
package eu.numberfour.n4js.ui.contentassist;

import java.util.Collection;
import java.util.concurrent.ExecutorService;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.Token;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.ParserBasedContentAssistContextFactory;
import org.eclipse.xtext.ui.editor.contentassist.antlr.ParserBasedContentAssistContextFactory.StatefulFactory;
import org.eclipse.xtext.util.Strings;

/**
 * Overrides the default {@link StatefulFactory} to use the API that is introduced by the {@link CustomN4JSParser}.
 *
 * All overridden methods basically override the inherited behavior to use the production parser's node model rather
 * than a bogus own lexer.
 *
 * @see CustomN4JSParser#getFollowElements(INode, int, int, boolean)
 */
public class ContentAssistContextFactory extends ParserBasedContentAssistContextFactory.StatefulFactory {

	@Override
	public void setPool(ExecutorService pool) {
		super.setPool(pool);
	}

	@Override
	public CustomN4JSParser getParser() {
		return (CustomN4JSParser) super.getParser();
	}

	@Override
	protected void createContextsForLastCompleteNode(EObject previousModel, boolean strict) throws BadLocationException {
		String currentNodePrefix = getPrefix(currentNode);
		if (!Strings.isEmpty(currentNodePrefix) && !currentNode.getText().equals(currentNodePrefix)) {
			lexer.setCharStream(new ANTLRStringStream(currentNodePrefix));
			Token token = lexer.nextToken();
			if (token == Token.EOF_TOKEN) { // error case - nothing could be parsed
				return;
			}
			while (token != Token.EOF_TOKEN) {
				if (isErrorToken(token))
					return;
				token = lexer.nextToken();
			}
		}
		String prefix = "";
		Collection<FollowElement> followElements = getParser().getFollowElements(rootNode, 0, completionOffset, strict);
		doCreateContexts(lastCompleteNode, currentNode, prefix, previousModel, followElements);
	}

	@Override
	protected void handleLastCompleteNodeAsPartOfDatatypeNode() throws BadLocationException {
		String prefix = getPrefix(datatypeNode);
		Collection<FollowElement> followElements = getParser().getFollowElements(rootNode, 0, datatypeNode.getOffset(),
				false);
		INode lastCompleteNodeBeforeDatatype = getLastCompleteNodeByOffset(rootNode, datatypeNode.getTotalOffset());
		doCreateContexts(lastCompleteNodeBeforeDatatype, datatypeNode, prefix, currentModel, followElements);
	}

	@Override
	protected void handleLastCompleteNodeIsAtEndOfDatatypeNode() throws BadLocationException {
		String prefix = getPrefix(lastCompleteNode);
		INode previousNode = getLastCompleteNodeByOffset(rootNode, lastCompleteNode.getOffset());
		EObject previousModel = previousNode.getSemanticElement();
		INode currentDatatypeNode = getContainingDatatypeRuleNode(currentNode);
		Collection<FollowElement> followElements = getParser().getFollowElements(rootNode, 0,
				lastCompleteNode.getOffset(), false);
		int prevSize = contextBuilders.size();
		doCreateContexts(previousNode, currentDatatypeNode, prefix, previousModel, followElements);

		if (lastCompleteNode instanceof ILeafNode && lastCompleteNode.getGrammarElement() == null
				&& contextBuilders.size() != prevSize) {
			handleLastCompleteNodeHasNoGrammarElement(contextBuilders.subList(prevSize, contextBuilders.size()),
					previousModel);
		}
	}
}
