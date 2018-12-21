package com.xitech.service.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xitech.service.StringResultService;

public class ConsumerBootstrap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"classpath:config/xitechapp-consumer.xml"});
        context.start();
        StringResultService demoService = (StringResultService)context.getBean("stringResultService"); // 获取远程服务代理
        String hello = demoService.stringResult("world"); // 执行远程方法
        System.out.println( hello ); // 显示调用结果
	}

}
