package com.xitech.web.scheduler;

import org.springframework.stereotype.Component;

@Component
public class XitechAppScheduler {
	
	
	public void printScheduler() {
		System.out.println("*******scheduler ****************");
	}
	
	public static void printScheduler1() {
		System.out.println("*******public static scheduler1 ****************");
	}

	/**
	 * protected方法不能进行定时任务
	 */
	protected void printScheduler2() {
		System.out.println("*******protected scheduler2 ****************");
	}

	
	private void printScheduler3() {
		System.out.println("*******private  scheduler3 ****************");
	}

	
	protected static void printScheduler4() {
		System.out.println("*******protected static scheduler4 ****************");
	}
	
	private static void printSchedule5() {
		System.out.println("*******private static scheduler5 ****************");
	}


}
