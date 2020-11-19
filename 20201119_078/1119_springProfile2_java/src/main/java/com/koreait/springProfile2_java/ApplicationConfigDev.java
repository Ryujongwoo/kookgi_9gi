package com.koreait.springProfile2_java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

//	profile 어노테이션으로 profile을 지정한다.
@Profile("dev")
@Configuration
public class ApplicationConfigDev {

	@Bean
	public ServerInfo serverInfo() {
		ServerInfo serverInfo = new ServerInfo();
		serverInfo.setIpNumber("localhost");
		serverInfo.setPortNumber("9090");
		return serverInfo;
	}
	
}
