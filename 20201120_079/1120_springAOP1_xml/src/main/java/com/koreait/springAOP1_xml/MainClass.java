package com.koreait.springAOP1_xml;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import test.Test;

public class MainClass {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		Student student = ctx.getBean("student", Student.class);
		Worker worker = ctx.getBean("worker", Worker.class);
		Test test = ctx.getBean("test", Test.class);
		
		System.out.println("=============================================");
		student.getStudentInfo();
		System.out.println("=============================================");
		worker.getWorkerInfo();
		System.out.println("=============================================");
		test.test();
		System.out.println("=============================================");
		student.afternoon();
		System.out.println("=============================================");
		
	}
	
}
