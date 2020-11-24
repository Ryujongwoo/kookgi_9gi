package com.koreait.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.ui.Model;

import com.koreait.dao.MvcboardDAO;
import com.koreait.vo.MvcboardVO;

public class InsertService implements MvcboardService {

	/*
	@Override
	public void execute(MvcboardVO mvcboardVO) {
		System.out.println("InsertService 클래스의 execute() 메소드 실행 - VO 사용");
//		System.out.println(mvcboardVO);
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		MvcboardDAO mvcboardDAO = ctx.getBean("mvcboardDAO", MvcboardDAO.class);
//		메인글을 테이블에 저장하는 메소드를 실행한다.
		mvcboardDAO.insert(mvcboardVO);
	}
	*/
	
	@Override
	public void execute(Model model) {
		System.out.println("InsertService 클래스의 execute() 메소드 실행 - Model 사용");
		
//		컨트롤러에서 Model 인터페이스 객체에 저장해서 넘겨준 HttpServletRequest 인터페이스 객체에서 insert.jsp에서 입력한 데이터를 읽어낸다.
//		Model 인터페이스 객체는 key와 value로 구성된 데이터 구조를 가지므로 asMap() 메소드로 Map<String, Object> 타입으로 변환시켜 저장한다.
		Map<String, Object> map = model.asMap();
		
//		Model 인터페이스 객체가 Map<String, Object> 타입으로 변환되서 저장된 객체에서 key가 "requeat"인 value(insert.jsp에서 넘어온 데이터)를
//		얻어온다.
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
//		Model 인터페이스 객체에 저장되서 넘어온 HttpServletRequest 인터페이스 객체에서 insert.jsp에서 넘어온 데이터를 받는다.
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String content = request.getParameter("subject");

//		MvcboardVO 클래스의 bean을 얻어온다.
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		MvcboardVO mvcboardVO = ctx.getBean("mvcboardVO", MvcboardVO.class);	
		
//		MvcboardVO 클래스의 bean에 insert.jsp에서 request 객체로 넘어온 데이터를 저장한다.
		mvcboardVO.setName(name);
		mvcboardVO.setSubject(subject);
		mvcboardVO.setContent(content);
//		System.out.println(mvcboardVO);

//		테이블에 메인글을 저장하는 메소드를 호출한다.
		MvcboardDAO mvcboardDAO = ctx.getBean("mvcboardDAO", MvcboardDAO.class);
		mvcboardDAO.insert(mvcboardVO);
		
	}
	
}








