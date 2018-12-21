package com.xitech.service.bootstrap;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProviderBootstrap {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"classpath:config/xitech-spring-provider.xml"});
        context.start();
        System.in.read(); // 按任意键退出
	}

}
