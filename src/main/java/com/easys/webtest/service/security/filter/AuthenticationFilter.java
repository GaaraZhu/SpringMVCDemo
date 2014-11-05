package com.easys.webtest.service.security.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.easys.webtest.domain.entity.security.User;
import com.easys.webtest.service.UserService;
import com.easys.webtest.util.Util;

public class AuthenticationFilter extends
		UsernamePasswordAuthenticationFilter {
	public static final String VALIDATE_CODE = "validateCode";

	private UserService userServiceImpl;

	public UserService getUserServiceImpl() {
		return userServiceImpl;
	}

	public void setUserServiceImpl(UserService userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}

	public AuthenticationFilter() {

	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request,
			HttpServletResponse response) throws AuthenticationException {
		if (!request.getMethod().equals("POST")) {
			throw new AuthenticationServiceException(
					"Authentication method not supported: "
							+ request.getMethod());
		}

		String username = obtainUsername(request).trim();
		String password = obtainPassword(request).trim();
		password = Util.encodePassword(password);

		User user = getUserServiceImpl().login(username, password);

		if (user == null) {
			/*
			 * 
			 * if (forwardToDestination) {
			 * request.setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION,
			 * exception); } else { HttpSession session =
			 * request.getSession(false);
			 * 
			 * if (session != null || allowSessionCreation) {
			 * request.getSession(
			 * ).setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION,
			 * exception); } }
			 */
			throw new AuthenticationServiceException(
					"Invalid username or password !!!");
		}

		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
				username, password);
		setDetails(request, authRequest);

		Authentication authentication = this.getAuthenticationManager()
				.authenticate(authRequest);

		return authentication;
	}

	protected void checkValidateCode(HttpServletRequest request) {
		HttpSession session = request.getSession();

		String sessionValidateCode = obtainSessionValidateCode(session);
		session.setAttribute(VALIDATE_CODE, null);
		String validateCodeParameter = obtainValidateCodeParameter(request);
		if (StringUtils.isEmpty(validateCodeParameter)
				|| !sessionValidateCode.equalsIgnoreCase(validateCodeParameter)) {
			throw new AuthenticationServiceException("validateCode.notEquals");
		}
	}

	private String obtainValidateCodeParameter(HttpServletRequest request) {
		Object obj = request.getParameter(VALIDATE_CODE);
		return null == obj ? "" : obj.toString();
	}

	protected String obtainSessionValidateCode(HttpSession session) {
		Object obj = session.getAttribute(VALIDATE_CODE);
		return null == obj ? "" : obj.toString();
	}

	@Override
	protected String obtainUsername(HttpServletRequest request) {
		Object obj = request.getParameter(SPRING_SECURITY_FORM_USERNAME_KEY);
		return null == obj ? "" : obj.toString();
	}

	@Override
	protected String obtainPassword(HttpServletRequest request) {
		Object obj = request.getParameter(SPRING_SECURITY_FORM_PASSWORD_KEY);
		return null == obj ? "" : obj.toString();
	}

}
