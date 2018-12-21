package com.xitech.web.controller;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("xitech")
public class XitechLoginController {

	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String xitechLogin() {
		return "pages/login";
	}
	
	@RequestMapping(value="/index", method=RequestMethod.POST)
	public String xitechIndex(@RequestParam("username") String userName,@RequestParam("password") String password) {
		
		UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
		Subject subject = SecurityUtils.getSubject();
		String result = "";
		try {
			subject.login(token);
			result =  "redirect:test";
		} catch ( UnknownAccountException uae ) { 
			result =  "redirect:test";
		} catch ( IncorrectCredentialsException ice ) { 
			result =  "redirect:test";
		} catch ( LockedAccountException lae ) { 
			result =  "redirect:test";
		} catch ( ExcessiveAttemptsException eae ) {
			result =  "redirect:test";
		} catch ( AuthenticationException ae ) {
			result =  "redirect:test";
		}		
		return result;
	}
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public String xitecht() {
		
		return "pages/index";
		
	}
}
