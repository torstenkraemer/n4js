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
package eu.numberfour.n4js.tester.server.resources.sessions;

import static com.google.common.collect.Maps.newHashMap;
import static eu.numberfour.n4js.tester.server.HttpConstants.SC_UNPROCESSABLE_ENTITY;
import static eu.numberfour.n4js.tester.server.resources.ContentType.PING_SESSION;
import static eu.numberfour.n4js.tester.server.resources.HttpMethod.POST;
import static java.lang.Long.parseLong;
import static java.lang.String.valueOf;
import static javax.servlet.http.HttpServletResponse.SC_BAD_REQUEST;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.google.inject.Inject;

import eu.numberfour.n4js.tester.events.SessionPingedEvent;
import eu.numberfour.n4js.tester.events.TestEvent;
import eu.numberfour.n4js.tester.server.resources.ClientResourceException;
import eu.numberfour.n4js.tester.server.resources.Resource;

/**
 * Implementation of the {@code  ping session} RESTful resource.
 * <p>
 * <tt>HTTP POST/n4.ide/testing/sessions/{sessionId}/ping</tt>
 */
@Resource(path = "/{sessionId}/ping/", method = POST, requestContentType = PING_SESSION)
public class PingSessionResource extends SessionResource {

	private static final String TIMEOUT_KEY = "timeout";
	private static final String COMMENT_KEY = "comment";

	@Inject
	private ObjectMapper mapper;

	@Override
	@SuppressWarnings("unchecked")
	protected TestEvent createEvent(final String sessionId, final String body) throws ClientResourceException {
		final Map<?, ?> values = newHashMap();
		try {
			values.putAll(mapper.readValue(body, Map.class));
		} catch (JsonMappingException | JsonParseException e) {
			throw new ClientResourceException(SC_UNPROCESSABLE_ENTITY);
		} catch (final IOException e) {
			throw new ClientResourceException(SC_BAD_REQUEST);
		}

		final Object value = values.get(TIMEOUT_KEY);
		// incorrect schema
		if (null == value) {
			throw new ClientResourceException(SC_UNPROCESSABLE_ENTITY);
		}
		final Object comment = values.get(COMMENT_KEY);
		try {
			final long timeout = parseLong(Objects.toString(value));
			return new SessionPingedEvent(sessionId, timeout, null == comment ? null : valueOf(comment));
		} catch (final NumberFormatException e) {
			// although schema was valid the data was indeed invalid
			throw new ClientResourceException(SC_BAD_REQUEST);
		}
	}

}
