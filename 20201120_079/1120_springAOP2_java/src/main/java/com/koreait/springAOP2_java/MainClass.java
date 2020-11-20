package com.koreait.springAOP2_java;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		Student student = ctx.getBean("student", Student.class);
		Worker worker = ctx.getBean("worker", Worker.class);
		
		System.out.println("=============================================");
		student.getStudentInfo();
		System.out.println("=============================================");
		worker.getWorkerInfo();
		System.out.println("=============================================");
		student.afternoon();
		System.out.println("=============================================");
		
	}
	
}
