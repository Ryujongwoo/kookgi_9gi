package com.koreaait.springProperties_Environment;

import java.io.IOException;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public class MainClass {

	public static void main(String[] args) {
		
//		ConfigurableApplicationContext 인터페이스 타입으로 환경 설정 정보를 읽어올 객체(컨테이너)를 만든다.
		ConfigurableApplicationContext ctx = new GenericXmlApplicationContext();
//		ConfigurableEnvironment 인터페이스 타입의 객체에 스프링 컨테이너의 환경 설정 정보만 getEnvironment() 메소드로 얻어와 저장한다.
		ConfigurableEnvironment env = ctx.getEnvironment();
//		환경 설정 정보 중에서 properties 정보만 기억하는 MutablePropertySources 클래스 객체에 스프링 컨테이너의 환경 설정 정보를 기억하고 있는
//		ConfigurableEnvironment 인터페이스 타입의 객체에서 getPropertySources() 메소드로 properties 정보만 얻어와 저장한다.
		MutablePropertySources mutablePropertySources = env.getPropertySources();
		
		try {
//			스프링 컨테이너에서 얻어온 properties 정보가 저장된 MutablePropertySources 클래스 객체 mutablePropertySources에 addLast() 메소드로
//			맨 마지막 위치에 admin.properties 파일의 내용을 읽어 추가한다.
//			MutablePropertySources 클래스 객체 mutablePropertySources에는 properties가 저장될 때 key에 따라 value 값이 저장되는 Map 형태로
//			저장된다.
			mutablePropertySources.addLast(new ResourcePropertySource("classpath:admin.properties"));
//			스프링 컨테이너에 추가된 properties 파일의 내용은 ConfigurableEnvironment 인터페이스 객체에서 getProperty() 메소드로 읽는다.
			System.out.println("admin.id : " + env.getProperty("admin.id"));
			System.out.println("admin.pw : " + env.getProperty("admin.pw"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("properties 파일의 내용을 읽어온다.");
		System.out.println("=============================================================");
		
//		스프링 컨테이너를 다시 만들어 환경 설정 정보를 얻어오면 위의 작업에서 addLast() 메소드를 사용해 추가한 properties 정보가 없기 때문에
//		ConfigurableApplicationContext 인터페이스 타입 객체의 환경 설정 정보를 그대로 사용하기 위해서 xml 파일에서 bean 설정 정보를 읽어내는
//		GenericXmlApplicationContext 클래스 타입으로 형변환 시켜서 사용한다.
		GenericXmlApplicationContext gCtx = (GenericXmlApplicationContext) ctx;
		gCtx.load("classpath:applicationCTX.xml");
		gCtx.refresh();
		System.out.println("=============================================================");
		
		AdminConnection adminConnection = gCtx.getBean("adminConnection", AdminConnection.class);
		System.out.println("admin.id : " + adminConnection.getAdminId());
		System.out.println("admin.pw : " + adminConnection.getAdminPw());
		
//		AdminConnection 클래스의 bean이 생성된 후 환경 설정 정보에 저장된 admin.properties 파일의 정보를 넘겨준다.
		adminConnection.setAdminId(env.getProperty("admin.id"));
		adminConnection.setAdminPw(env.getProperty("admin.pw"));
		
		System.out.println("admin.id : " + adminConnection.getAdminId());
		System.out.println("admin.pw : " + adminConnection.getAdminPw());
		
		
		
		gCtx.close();
		
	}
	
}








