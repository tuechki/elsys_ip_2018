package org.elsys.ip.servlet.filter;

import org.elsys.ip.servlet.models.User;
import org.elsys.ip.servlet.service.UserService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public LoginFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {


		PrintWriter out = response.getWriter();

		String username = request.getParameter("name");
		String password = request.getParameter("password");


		UserService userService = new UserService();
		User loggingUser = userService.getByName(username);

		boolean authorized;

		if(loggingUser != null) {
			authorized = loggingUser.getPassword().equals(password);
		}
		else{
			authorized = false;
		}

		// check username and password (can be hardcoded, can use the userService)
		// add if the person is logged in to a cookie (Google it), so that we do not check at every page
		if (authorized) {

			Cookie loginCookie = new Cookie(username,password);
			HttpServletResponse httpResp =(HttpServletResponse)response;
			loginCookie.setMaxAge(30*60);
			httpResp.addCookie(loginCookie);
			chain.doFilter(request, httpResp);

		} else {
			request.setAttribute("error", "Wrong username or password!");
			String rank;
			if("ädmin".equals(username)){
				rank = username;
			}else {
				rank = null;
			}
			request.setAttribute("rank", rank);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
