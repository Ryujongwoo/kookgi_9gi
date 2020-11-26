package com.koreait.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.ui.Model;

import com.koreait.dao.MvcboardDAO;

public class IncrementService implements MvcboardService {

	@Override
	public void execute(Model model) {
		System.out.println("IncrementService 클래스의 execute() 메소드 실행");
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
//		request 객체로 넘어온 조회수를 증가시킬 글번호를 받는다.
		int idx = Integer.parseInt(request.getParameter("idx"));
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		MvcboardDAO mvcboardDAO = ctx.getBean("mvcboardDAO", MvcboardDAO.class);
		mvcboardDAO.increment(idx);
	}

}







