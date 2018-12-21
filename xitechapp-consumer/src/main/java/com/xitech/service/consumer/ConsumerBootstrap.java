package com.xitech.service.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xitech.service.StringResultService;

public class ConsumerBootstrap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"classpath:config/xitechapp-consumer.xml"});
        context.start();
        StringResultService demoService = (StringResultService)context.getBean("stringResultService"); // ��ȡԶ�̷������
        String hello = demoService.stringResult("world"); // ִ��Զ�̷���
        System.out.println( hello ); // ��ʾ���ý��
	}

}
