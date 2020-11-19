package com.koreait.springProfile2_java;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("실행할 작업 환경을 선택하세요(1 => dev, 2 => run) : ");
		int info = scanner.nextInt();
		String config = "";
		switch (info) {
			case 1:
				config = "dev";
				break;
			case 2:
				config = "run";
				break;
		}
		
//		profile이 지정된 java 파일의 bean을 읽기 위해서는 스프링 컨테이너를 먼저 만든 후 읽어올 bean의 profile을 지정한 다음 스프링 컨테이너에
//		해당 profile이 지정된 bean을 load 시켜야 한다.
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		
//		getEnvironment() 메소드로 스프링 컨테이너의 환경 설정 정보를 읽어와서 setActiveProfiles() 메소드로 읽어올 profile 속성으로 지정한
//		값을 넣어준다.
		ctx.getEnvironment().setActiveProfiles(config);
		
//		GenericXmlApplicationContext 클래스로 xml 파일에서 bean 설정 정보를 컨테이너에 넣어주기 위해서 load() 메소드를 사용했었지만
//		AnnotationConfigApplicationContext 클래스로 java 파일에서 설정한 bean 설정 정보를 넣어주려면 register() 메소드를 사용해야 한다.
		ctx.register(ApplicationConfigDev.class, ApplicationConfigRun.class);
		ctx.refresh();
		
		ServerInfo serverInfo = ctx.getBean("serverInfo", ServerInfo.class);
		System.out.println("ipNumber : " + serverInfo.getIpNumber());
		System.out.println("postNumber : " + serverInfo.getPortNumber());
		
		ctx.close();
		
	}
	
}













