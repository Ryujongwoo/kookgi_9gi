package com.koreait.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.ui.Model;

import com.koreait.dao.MvcboardDAO;
import com.koreait.vo.MvcboardVO;

public class SelectService implements MvcboardService {

	@Override
	public void execute(Model model) {
		System.out.println("SelectService 클래스의 execute() 메소드 실행");
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
//		MvcboardDAO 클래스의 bean을 얻어온다.
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		MvcboardDAO mvcboardDAO = ctx.getBean("mvcboardDAO", MvcboardDAO.class);	

//		브라우저 화면에 출력할 글의 개수를 정한다.
		int pageSize = 10;
//		HttpServletRequest 인터페이스 객체에 저장되서 넘어오는 화면에 표시할 페이지 번호를 받는다.
		int currentPage = 1;
		try {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		} catch (Exception e) { }
//		테이블에 저정된 전체 글의 개수를 얻어온다.
		int totalCount = mvcboardDAO.selectCount();
		System.out.println(totalCount);
		
	}

}







