package com.xitech.web.shiro.listener;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListenerAdapter;

public class XitechSessionListener extends SessionListenerAdapter {

	@Override
	public void onStart(Session session) {
		// TODO Auto-generated method stub
		/*super.onStart(session);*/
		System.out.println("==================== session onstart:"+ session.getStartTimestamp()+"---->"+session.getLastAccessTime());
		
	}

	@Override
	public void onStop(Session session) {
		// TODO Auto-generated method stub
		/*super.onStop(session);*/
		System.out.println("==================== session onstop:"+ session.getId());
	}

	@Override
	public void onExpiration(Session session) {
		// TODO Auto-generated method stub
		/*super.onExpiration(session);*/
		System.out.println("==================== session onexpiration:"+ session.getId());
	}

}
