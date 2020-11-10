package com.koreait.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//	브라우저의 url 창에 @WebServlet() 어노테이션에서 지정된 요청이 들어오면 @WebServlet() 어노테이션이 붙어있는 클래스(컨트롤러)에서 get 방식의
//	요청이 들어오면 doGet() 메소드가 자동으로 실행되고 post 방식의 요청이 들어오면 doPost() 메소드가 자동으로 실행된다.
//	@WebServlet() 어노테이션에 특정 페이지(요청) 이름을 써주면 그 페이지 요청이 들어왔을 때 컨트롤러의 메소드가 실행되므로 페이지 마다 각각
//	컨트롤러를 만들어야 하는 화문제점이 생긴다. => @WebServlet() 어노테이션에 와일드 카드 문자(*)를 사용하는 확장명 패턴 방식의 요청을 받는다.
//	=> 확장명 패턴 방식으로 요청을 받으면 파일명은 상관없이 동일한 확장명으로 요청되면 컨트롤러의 메소드가 실행된다. => 확장명 패턴 방식으로
//	요청을 받을 때 맨 앞에 "/"를 붙이지 않는다. => 확장명을 jsp가 아닌 다른 이름으로 사용하면 어떤 페이지가 호출되나 숨길 수 있다. => 보안성 향상
@WebServlet("*.nhn")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HomeController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get 방식으로 요청이 들어오면 자동으로 실행되는 메소드");
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post 방식으로 요청이 들어오면 자동으로 실행되는 메소드");
		actionDo(request, response);
	}
	
//	get 방식으로 요청이 들어오던 post 방식으로 요청이 들어오던 무조건 actionDo() 메소드가 실행된다.
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		한글 깨짐 방지
		request.setCharacterEncoding("UTF-8");
		
//		url 창에 입력된 요청을 받아온다.
//		getRequestURI() : url 창에 요청된 페이지의 경로와 페이지 이름을 얻어온다.
		String url = request.getRequestURI();
		System.out.println("url : " + url);
		
//		getContextPath() : url 창에 요청된 페이지의 경로만 얻어온다.
		String contextPath = request.getContextPath();
		System.out.println("contextPath : " + contextPath);
		
//		url 창에 요청된 페이지 이름만 얻어온다.
		String context = url.substring(contextPath.length());
		System.out.println("context : " + context);
		
//		요청된 context에 따라 분기할 페이지를 결정한다.
		String viewPage = "/WEB-INF/";
		switch (context) {
			case "/hello.nhn":
				viewPage += "hello";
				break;
		}
		viewPage += ".jsp";
		System.out.println(viewPage);
		
//		요청에 따른 페이지를 호출한다.
//		RequestDispatcher 인터페이스 객체를 이용해서 요청된 context의 실제 페이지를 호출해서 브라우저에 표시한다.
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);		// 브라우저에 표시할 페이지 이름을 넣어준다.
		dispatcher.forward(request, response);		// 브라우저에 표시할 페이지를 호출한다.
		
	}

}






