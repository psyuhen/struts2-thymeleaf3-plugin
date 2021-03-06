/*
 * Copyright 2013 Steven Benitez.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package serendip.struts.plugins.thymeleaf;

import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.thymeleaf.context.AbstractContext;
import org.thymeleaf.context.IWebContext;

/**
 * Extends the {@link org.thymeleaf.context.WebContext} to provide access to the
 * Struts action.
 *
 * For actions that implement the {@link com.opensymphony.xwork2.LocaleProvider}
 * interface (i.e., actions that extend ActionSupport), the action's locale will
 * be used in this context. Otherwise, the context will default to the
 * {@link javax.servlet.http.HttpServletRequest request's} locale.
 *
 * @author A-pZ
 * @version 1.0.0
 */
public class StrutsContext extends AbstractContext implements IWebContext {

	private final HttpServletRequest request;
	private final HttpServletResponse response;
	private final ServletContext servletContext;

	/**
	 * Name of the variable that contains the action.
	 */
	public static final String ACTION_VARIABLE_NAME = "action";

	public StrutsContext(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext,
			Locale locale,Map<String, Object> variables) {

		super(locale,variables);
		this.request = request;
		this.response = response;
		this.servletContext = servletContext;

	}

	public HttpServletRequest getRequest() {
		return this.request;
	}

	public HttpSession getSession() {
		return this.request.getSession(false);
	}

	public HttpServletResponse getResponse() {
		return this.response;
	}

	public ServletContext getServletContext() {
		return this.servletContext;
	}
}
