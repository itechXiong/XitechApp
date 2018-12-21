package com.xitech.web.filter;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xitech.web.common.XitechConstants;

public class XitechSessionFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		System.out.println(">>>>>>>>>>>>>>>>>>sessionFilter before");
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse)response;
		HttpSession session = httpRequest.getSession(true);
		System.out.println("*****************session id:"+session.getId());
		/*Cookie[] cookies = httpRequest.getCookies();
		boolean isExist = false;
		for(Cookie cookie : cookies) {
			if(XitechConstants.SESSION_NAME.equals(cookie.getName())) {
				isExist = true;
			}
		}
		
		if(!isExist) {
			httpRequest.setAttribute(XitechConstants.SESSION_NAME, UUID.randomUUID().toString());
		}*/
		
		System.out.println(">>>>>>>>>>>>>>>>>>sessionFilter after");
		filterChain.doFilter(httpRequest, httpResponse);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
