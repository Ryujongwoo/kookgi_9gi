package com.koreait.springLifeCycle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		/*
//		xml 파일에서 설정한 bean을 생성하고 초기화 시킨다. => bean(객체)를 만들어야 하므로 생성자가 실행된다.
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		
		System.out.println("====================================================================");
		Person person = ctx.getBean("person", Person.class);
		System.out.println(person.getName() + "님은 " + person.getAge() + "살 입니다.");
		System.out.println("====================================================================");
		Person person2 = ctx.getBean("person2", Person.class);
		System.out.println(person2.getName() + "님은 " + person2.getAge() + "살 입니다.");
		System.out.println("====================================================================");
		*/
		
//		DI 컨테이너를 만든다. => 빈 컨테이너 => 필요할 때 bean 정보를 채워서 사용한다.
//		GenericXmlApplicationContext 클래스를 사용해서 만든 DI 컨테이너는 빈 컨테이너만 생성되고 bean 정보는 들어있지 않다.
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		
//		load() 메소드로 xml 파일에서 정의한 bean 설정 정보를 넣어준다.
		ctx.load("classpath:applicationCTX.xml");
		
//		load() 메소드를 사용해서 bean 설정 정보를 넣어줄 경우 정상적으로 처리되게 하기 위해서 refresh() 메소드를 실행한다.
//		refresh() 메소드가 실행되는 순간 bean이 생성되고 refresh() 메소드를 실행하지 않으면 getBean() 메소드에 의해서 bean을
//		얻어낼 때 bean이 생성된다.
//		DI 컨테이너에서 close() 메소드를 실행하더라도 refresh() 메소드를 실행하지 않았으면 destroy() 메소드가 실행되지 않는다.
		ctx.refresh();
		
		System.out.println("====================================================================");
		Person person = ctx.getBean("person", Person.class);
		System.out.println(person.getName() + "님은 " + person.getAge() + "살 입니다.");
		System.out.println("====================================================================");
		Person person2 = ctx.getBean("person2", Person.class);
		System.out.println(person2.getName() + "님은 " + person2.getAge() + "살 입니다.");
		System.out.println("====================================================================");
		
//		refresh() 메소드를 실행했더라도 close() 메소드를 실행하지 않으면 bean이 소멸될 때 destroy() 메소드가 실행되지 않는다.
		ctx.close();
		
	}
	
}


















