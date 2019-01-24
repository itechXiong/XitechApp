package com.xitech.web.dwr.entity;

import org.directwebremoting.annotations.DataTransferObject;

@DataTransferObject
public class DwrUser {
	
	private String userName;
	
	private String userPwd;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

}
