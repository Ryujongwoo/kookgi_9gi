package com.koreait.springDI6_java;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
//		xml 파일에서 설정한 bean 정보를 읽어오려면 아래의 방법을 사용한다.
//		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
//		getBean("id", bean을 생성한 클래스.class)
		
//		java 파일에서 설정한 bean 정보를 읽어오려면 아래의 방법을 사용한다.
//		new AnnotationConfigApplicationContext(bean을 설정한 클래스 이름.class)
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
//		getBean("메소드 이름", 리턴타입.class)
		Student student = ctx.getBean("student", Student.class);
		
		System.out.println("이름 : " + student.getName());		
		System.out.println("나이 : " + student.getAge());		
		System.out.println("취미 : " + student.getHobbies());		
		System.out.println("신장 : " + student.getHeight());		
		System.out.println("체중 : " + student.getWeight());		
		
	}
	
}
