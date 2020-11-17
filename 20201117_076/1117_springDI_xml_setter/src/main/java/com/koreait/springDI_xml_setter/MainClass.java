package com.koreait.springDI_xml_setter;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		/*
		MyCalculator myCalculator = new MyCalculator();
		myCalculator.setFirstNum(8);
		myCalculator.setSecondNum(5);
		
//		Calculator calculator = new Calculator();
//		myCalculator.setCalculator(calculator);
		myCalculator.setCalculator(new Calculator());
		*/
		
//		xml 파일에서 설정한 bean 설정 정보를 읽어들인다.
//		class의 bean을 설정하는 xml 파일 만들기 : src/main/resources에서 우클릭 => New => Spring Bean Configuration File
//		classpath는 xml 파일이 위치하는 경로 "src/main/resources"를 의미한다.
		String configLocation = "classpath:applicationCTX.xml";
		
//		GenericXmlApplicationContext 클래스 생성자의 인수로 bean을 설정하는 xml 파일의 경로와 이름을 넘겨주먼 xml 파일의 내용일 읽어서(파싱)
//		java 객체로 변환시킨 후 부모 클래스인 AbstractApplicationContext 클래스의 객체에 저장한다.
//		xml 파일의 bean 설정 정보를 읽어서 ctx에 저장한다. 
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
//		getBean() 메소드로 AbstractApplicationContext 클래스 태입의 객체 ctx에 저장된 bean을 얻어온다.
//		getBean("얻어올 bean의 id", bean을 생성한 클래스 이름.class)
		MyCalculator myCalculator = ctx.getBean("myCalculator", MyCalculator.class);
		System.out.println(myCalculator);
		
		myCalculator.add();
		myCalculator.sub();
		myCalculator.mul();
		myCalculator.div();
		
	}
	
}








