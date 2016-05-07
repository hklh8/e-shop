package com.hklh8.higou.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hklh8.higou.entity.User;

public class AdminFilter implements Filter {
	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		HttpSession session = req.getSession();
		
		if(session.getAttribute("user")!=null){
			User user = (User) session.getAttribute("user");
			if(user.getRole().equals("a")){
				chain.doFilter(req, res);
				return;
			}
			res.sendRedirect(req.getContextPath());
			return;
		}	
		res.sendRedirect(req.getContextPath()+"/admin/login.jsp");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}
}
