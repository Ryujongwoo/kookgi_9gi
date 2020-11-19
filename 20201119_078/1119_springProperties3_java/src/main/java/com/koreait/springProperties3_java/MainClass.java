package com.koreait.springProperties3_java;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		AdminConnection adminConnection = ctx.getBean("adminConnection", AdminConnection.class);
		
		System.out.println("admin.id : " + adminConnection.getAdminId());
		System.out.println("admin.pw : " + adminConnection.getAdminPw());
		System.out.println("sub_admin.id : " + adminConnection.getSub_adminId());
		System.out.println("sub_admin.pw : " + adminConnection.getSub_adminPw());
		
	}
	
}
