package com.koreait.springDI7_xml_in_java;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ApplicationConfig {

	@Bean
	public Student student2() {
		
		/*
		Student student = new Student();
		student.setName("홍길동");
		student.setAge(20);
		ArrayList<String> hobbies = new ArrayList<String>();
		hobbies.add("등산");
		hobbies.add("바둑");
		hobbies.add("낚시");
		student.setHobbies(hobbies);
		*/
		
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










