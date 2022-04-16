/*
 * pragmatickm-contact-servlet - Contacts nested within SemanticCMS pages and elements in a Servlet environment.
 * Copyright (C) 2013, 2014, 2015, 2016, 2017, 2020, 2021, 2022  AO Industries, Inc.
 *     support@aoindustries.com
 *     7262 Bull Pen Cir
 *     Mobile, AL 36695
 *
 * This file is part of pragmatickm-contact-servlet.
 *
 * pragmatickm-contact-servlet is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * pragmatickm-contact-servlet is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with pragmatickm-contact-servlet.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.pragmatickm.contact.servlet;

import com.aoapps.html.servlet.DocumentEE;
import com.aoapps.net.Email;
import com.pragmatickm.contact.model.Address;
import com.pragmatickm.contact.model.Im;
import com.pragmatickm.contact.model.PhoneNumber;
import com.pragmatickm.contact.servlet.impl.ContactImpl;
import com.semanticcms.core.model.ElementContext;
import com.semanticcms.core.servlet.CaptureLevel;
import com.semanticcms.core.servlet.Element;
import com.semanticcms.core.servlet.PageContext;
import com.semanticcms.core.servlet.PageIndex;
import java.io.IOException;
import java.io.Writer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.SkipPageException;

public class Contact extends Element<com.pragmatickm.contact.model.Contact> {

	public Contact(
		ServletContext servletContext,
		HttpServletRequest request,
		HttpServletResponse response,
		com.pragmatickm.contact.model.Contact element
	) {
		super(
			servletContext,
			request,
			response,
			element
		);
	}

	public Contact(
		ServletContext servletContext,
		HttpServletRequest request,
		HttpServletResponse response
	) {
		this(
			servletContext,
			request,
			response,
			new com.pragmatickm.contact.model.Contact()
		);
	}

	/**
	 * Creates a new contact in the current page context.
	 *
	 * @see  PageContext
	 */
	public Contact(com.pragmatickm.contact.model.Contact element) {
		this(
			PageContext.getServletContext(),
			PageContext.getRequest(),
			PageContext.getResponse(),
			element
		);
	}

	/**
	 * Creates a new contact in the current page context.
	 *
	 * @see  PageContext
	 */
	public Contact() {
		this(
			PageContext.getServletContext(),
			PageContext.getRequest(),
			PageContext.getResponse()
		);
	}

	@Override
	public Contact id(String id) {
		super.id(id);
		return this;
	}

	private Object style;
	public Contact style(Object style) {
		this.style = style;
		return this;
	}

	public Contact title(String title) {
		element.setTitle(title);
		return this;
	}

	public Contact first(String first) {
		element.setFirst(first);
		return this;
	}

	public Contact middle(String middle) {
		element.setMiddle(middle);
		return this;
	}

	public Contact nick(String nick) {
		element.setNick(nick);
		return this;
	}

	public Contact last(String last) {
		element.setLast(last);
		return this;
	}

	public Contact maiden(String maiden) {
		element.setMaiden(maiden);
		return this;
	}

	public Contact suffix(String suffix) {
		element.setSuffix(suffix);
		return this;
	}

	public Contact company(String company) {
		element.setCompany(company);
		return this;
	}

	public Contact department(String department) {
		element.setDepartment(department);
		return this;
	}

	public Contact jobTitle(String jobTitle) {
		element.setJobTitle(jobTitle);
		return this;
	}

	public Contact email(Email email) {
		element.addEmail(email);
		return this;
	}

	public Contact phoneNumber(PhoneNumber phoneNumber) {
		element.addPhoneNumber(phoneNumber);
		return this;
	}

	public Contact im(Im im) {
		element.addIm(im);
		return this;
	}

	public Contact webPage(String webPage) {
		element.addWebPage(webPage);
		return this;
	}

	public Contact address(Address address) {
		element.addAddress(address);
		return this;
	}

	private PageIndex pageIndex;
	@Override
	protected void doBody(CaptureLevel captureLevel, Body<? super com.pragmatickm.contact.model.Contact> body) throws ServletException, IOException, SkipPageException {
		pageIndex = PageIndex.getCurrentPageIndex(request);
		super.doBody(captureLevel, body);
	}

	@Override
	public void writeTo(Writer out, ElementContext context) throws IOException, ServletException, SkipPageException {
		ContactImpl.writeContactTable(
			pageIndex,
			new DocumentEE(servletContext, request, response, out),
			context,
			style,
			element
		);
	}
}
