package com.ikubinfo.internship.project.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginFilter implements Filter {
	private ServletContext context;

	@Override
		public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
				throws IOException, ServletException {

		try {
			HttpServletRequest req = (HttpServletRequest) request;
			HttpServletResponse res = (HttpServletResponse) response;
			String contextPath = req.getContextPath();
			HttpSession session = req.getSession(false);

					

			
			if (session == null) {
				
				res.sendRedirect(contextPath + "/Login.xhtml");
				
			} else {
				chain.doFilter(request, response);
			}

		} catch (Throwable t) {
			System.out.println(t.getMessage());
		}
			
			
		}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		this.context = fConfig.getServletContext();
		this.context.log("Initializing");

	}

	@Override
	public void destroy() {

	}

}
