package com.koreait.springProfile2_java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

//	profile 어노테이션으로 profile을 지정한다.
@Profile("run")
@Configuration
public class ApplicationConfigRun {

	@Bean
	public ServerInfo serverInfo() {
		ServerInfo serverInfo = new ServerInfo();
		serverInfo.setIpNumber("192.168.100.101");
		serverInfo.setPortNumber("8080");
		return serverInfo;
	}
	
}
