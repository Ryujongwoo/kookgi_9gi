package com.koreait.springDI8_java_in_xml;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

//	java 파일에서 xml 파일의 bean 설정 정보를 읽어오려면 @ImportResource 어노테이션으로 읽어들일 xml 파일을 java 파일에 포함시킨다.
@ImportResource("classpath:applicationCTX.xml")

@Configuration
public class ApplicationConfig {

	@Bean
	public Student student() {
		
		ArrayList<String> hobbies = new ArrayList<String>();
		hobbies.add("java 공부");
		hobbies.add("jsp 공부");
		hobbies.add("spring 공부");
		Student student = new Student("임꺽정", 35, hobbies);
		
		student.setHeight(165);
		student.setWeight(110);
		return student;
	}
	
}










