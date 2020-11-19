package com.koreait.springProperties3_java;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
public class ApplicationConfig {

//	properties 파일에서 읽어온 데이터를 저장할 멤버 변수를 만든다.
//	properties 파일의 내용이 저장되서 리턴되는 리턴 타입이 PropertySourcesPlaceholderConfigurer인 메소드가 리턴하는 내용 중에서 멤버 변수에
//	저장할 데이터의 key를 Value 어노테이션에 EL을 사용해서 Value 어노테이션이 설정된 멤버 변수에 저장시킨다.
//	=> Value 어노테이션 바로 아래의 멤버 변수에 저장된다.
	@Value("${admin.id}")
	private String adminId;
	@Value("${admin.pw}")
	private String adminPw;
	@Value("${sub_admin.id}")
	private String sub_adminId;
	@Value("${sub_admin.pw}")
	private String sub_adminPw;

//	AdminConnection 클래스의 bean을 만든다.
	@Bean
	public AdminConnection adminConnection() {
		AdminConnection adminConnection = new AdminConnection();
		adminConnection.setAdminId(adminId);
		adminConnection.setAdminPw(adminPw);
		adminConnection.setSub_adminId(sub_adminId);
		adminConnection.setSub_adminPw(sub_adminPw);
		return adminConnection;
	}
	
//	properties 파일의 데이터를 읽어서 멤버 변수를 초기화 시키는 메소드 => 반드시 정적 메소드로 만들어야 한다.
//	@Configuration 어노테이션을 붙여준 클래스에서 정의한 bean이 생성될 때 자동으로 실행되는 메소드로 반드시 PropertySourcesPlaceholderConfigurer
//	클래스 타입을 리턴 타입으로 가져야 한다. => 메소드 이름은 뭐를 적어도 상관없다.
	@Bean
	public static PropertySourcesPlaceholderConfigurer configurer() {
		System.out.println("리턴 타입이 PropertySourcesPlaceholderConfigurer인 메소드 자동 실행");
		PropertySourcesPlaceholderConfigurer placeholderConfigurer = new PropertySourcesPlaceholderConfigurer();
		
		/*
//		읽어야 할 properties 파일이 1개일 경우 => 변수
//		Resource 인터페이스 타입의 변수에 ClassPathResource 클래스의 생성자로 읽어들일 properties 파일의 이름을 인수로 넘겨 properties 파일의
//		내용을 읽어서 저장한다.
		Resource resource = new ClassPathResource("admin.properties");
//		Resource 인터페이스 타입의 객체에 읽어들인 properties 파일의 내용을 setLocation() 메소드로 PropertySourcesPlaceholderConfigurer 클래스
//		타입의 객체에 저장시켜 리턴한다.
		placeholderConfigurer.setLocation(resource);
		*/
		
//		읽어야 할 properties 파일이 2개 이상일 경우 => 배열
//		Resource 인터페이스 타입의 배열에 ClassPathResource 클래스의 생성자로 읽어들일 properties 파일의 이름을 인수로 넘겨 properties 파일의
//		내용을 읽어서 저장한다.
		Resource[] resources = new Resource[2];		// properties 파일을 읽어들일 배열을 선언한다.
		resources[0] = new ClassPathResource("admin.properties");
		resources[1] = new ClassPathResource("sub_admin.properties");
//		Resource 인터페이스 타입의  배열에 읽어들인 properties 파일의 내용을 setLocations() 메소드로 PropertySourcesPlaceholderConfigurer 클래스
//		타입의 객체에 저장시켜 리턴한다.
		placeholderConfigurer.setLocations(resources);
		
		return placeholderConfigurer;
	}
	
}














