package com.xitech.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class XitechFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		Cookie[] cookies = httpServletRequest.getCookies();
		HttpSession session = httpServletRequest.getSession();
		System.out.println("session timeout :"+ session.getMaxInactiveInterval());
		System.out.println("session id:"+session.getId());
		for(int i =0;i < cookies.length; i++) {
			Cookie cookie = cookies[i];
			
			String name = cookie.getName();
			String value = cookie.getValue();
			String domain = cookie.getDomain();
			String path = cookie.getPath();
			int maxAge = cookie.getMaxAge();
			boolean secure = cookie.getSecure();
			String comment = cookie.getComment();
			int version = cookie.getVersion();
			
			StringBuilder cookieStr = new StringBuilder("");
			cookieStr.append("Cookie[").append(i).append("] name : ").append(name);
			cookieStr.append("  ,value : ").append(value);
			cookieStr.append("  ,domain : ").append(domain);
			cookieStr.append("  ,path : ").append(path);
			cookieStr.append("  ,maxAge : ").append(maxAge);
			cookieStr.append("  ,secure : ").append(secure);
			cookieStr.append("  ,comment : ").append(comment);
			cookieStr.append("  ,version : ").append(version);
			System.out.println(cookieStr.toString());
		}
		
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
