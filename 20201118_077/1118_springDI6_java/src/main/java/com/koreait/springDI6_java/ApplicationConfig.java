package com.koreait.springDI6_java;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//	1118_springDI5_xml_namespace 프로젝트의 applicationCTX.xml 파일에서 Student 클래스의 bean student 설정을 java 파일로 구현한다.
//	java 파일을 이용해 bean을 설정하려면 적당한 이름으로 클래스를 만들고 @Configuration 어노테이션을 붙여서 이 클래스가 bean을
//	설정하는 xml 파일의 beans 태그 역할을 한다는 것을 알려줘야 한다.
@Configuration			// 이 클래스는 DI 설정에 사용되는 클래스임을 알려준다.
public class ApplicationConfig {

//	적당한 이름으로 메소드를 만들고 @Bean 어노테이션을 붙여 bean을 설정하는 xml 파일의 bean 태그 역할을 한다는 것을 알려줘야 한다.
//	<bean id="student" class="com.koreait.springDI6_java.Student">
//	@Bean
//	public 리턴타입[class 속성값 => 클래스 이름만] 메소드이름[id 속성값]() {
//		생성자나 setter를 사용해서 bean을 초기화 하는 작업을 한다.
//		...
//		return bean객체;
//	}
	
	@Bean
	public Student student() {
		Student student = new Student();
		student.setName("홍길동");
		student.setAge(20);
		ArrayList<String> hobbies = new ArrayList<String>();
		hobbies.add("등산");
		hobbies.add("바둑");
		hobbies.add("낚시");
		student.setHobbies(hobbies);
		student.setHeight(173);
		student.setWeight(70);
		return student;
	}
	
}










