package com.koreait.springProperties2_xml;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		AdminConnection adminConnection = ctx.getBean("adminConnection", AdminConnection.class);
		
		System.out.println("admin.id : " + adminConnection.getAdminId());
		System.out.println("admin.pw : " + adminConnection.getAdminPw());
		System.out.println("sub_admin.id : " + adminConnection.getSub_adminId());
		System.out.println("sub_admin.pw : " + adminConnection.getSub_adminPw());
		
	}
	
}
