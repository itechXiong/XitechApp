package com.xitech.web.dwr.service;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;

import com.xitech.web.dwr.entity.DwrUser;

@RemoteProxy(name="dwrService")
public class DwrService {

	public DwrService() { }
	
	@RemoteMethod
	public DwrUser getDwrUser() throws Exception {
		DwrUser user = new DwrUser();		
		user.setUserName("dwrUser");
		user.setUserPwd("pwd");
		return user;
	}
}
