package com.koreaait.springProperties_Environment;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

//	AdminConnection 클래스의 bean이 생성되는 순간 admin.properties 파일의 내용을 읽어서 멤버 변수에 저장한다.
public class AdminConnection implements EnvironmentAware, InitializingBean {

	private Environment env;		// 스프링 컨테이너의 환경 설절 정보를 저장한다.
	private String adminId;			// admin.properties 파일의 admin.id에 할당된 데이터를 저장한다.
	private String adminPw;			// admin.properties 파일의 admin.pw에 할당된 데이터를 저장한다.
	
	public AdminConnection() {
		System.out.println("AdminConnection 클래스의 bean이 생성되었습니다.");
	}

	public Environment getEnv() {
		return env;
	}
	public void setEnv(Environment env) {
		this.env = env;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getAdminPw() {
		return adminPw;
	}
	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}

	@Override
	public String toString() {
		return "AdminConnection [env=" + env + ", adminId=" + adminId + ", adminPw=" + adminPw + "]";
	}

//	EnvironmentAware 인터페이스를 구현하면 setEnvironment() 메소드를 Override 해서 사용할 수 있다.
//	setEnvironment() 메소드는 EnvironmentAware 인터페이스가 구현된 클래스의 bean이 생성(refresh() 메소드가 실행)되는 순간 자동으로 실행된다.
//	setEnvironment() 메소드의 인수인 스프링 컨테이너의 환경 설정 정보를 기억하는 Environment 인터페이스 타입의 객체 environment에는 스프링이
//	알아서 AdminConnection 클래스의 bean이 생성되는 순간 컨테이너(gCtx)의 환경 설정 정보를 넘겨준다. => properties 정보가 넘어온다.
	@Override
	public void setEnvironment(Environment environment) {
		System.out.println("자동으로 setEnvironment() 메소드 실행");
//		environment로 넘어온 환경 설정 정보를 AdminConnection 클래스에서 사용하기 위해 멤버로 선언한 Environment 인터페이스 객체에 넣어준다.
//		setEnv(environment);
		env = environment;
	}

//	InitializingBean 인터페이스를 구현하고 bean이 생성될 때 생성자가 실행되고 난 후 자동으로 실행되는 afterPropertiesSet() 메소드를 Override한
//	다음에 Environment 인터페이스 객체 env에 저장된 properties 정보를 멤버 변수에 저장시킨다.
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("자동으로 afterPropertiesSet() 메소드 실행");
		adminId = env.getProperty("admin.id");
		adminPw = env.getProperty("admin.pw");
	}
	
}











