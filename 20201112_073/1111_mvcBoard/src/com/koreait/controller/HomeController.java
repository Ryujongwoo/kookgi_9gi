package com.koreait.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.service.MvcboardService;

//	@WebServlet("*.nhn")
@WebServlet({"/", "*.nhn"})
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
//	컨트롤러에서 사용할 service 클래스 객체를 선언한다.
	private MvcboardService service = MvcboardService.getInstance();
	
    public HomeController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HomeController 클래스의 doGet() 메소드");
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HomeController 클래스의 doPost() 메소드");
		actionDo(request, response);
	}
	
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HomeController 클래스의 actionDo() 메소드");
		
		request.setCharacterEncoding("UTF-8");
//		System.out.println(request.getParameter("name"));
		
		String url = request.getRequestURI();
//		System.out.println(url);
		String contextPath = request.getContextPath();
//		System.out.println(contextPath);
		String context = url.substring(contextPath.length());
//		System.out.println(context);
//		System.out.println(context.length());
		
		String viewPage = "/WEB-INF/";
		switch (context) {
			case "/":
				viewPage += "main";
				break;
				
			case "/insert.nhn":
				viewPage += "insert";
				break;
				
			case "/insertOK.nhn":
//				insert.jsp에서 테이블에 저장할 데이터를 입력하고 submit 버튼을 클릭하면 폼에 입력된 정보가 컨트롤러의 doPost() 메소드의 
//				HttpServletRequest 인터페이스 타입의 객체인 request로 전달된다. => doPost() 메소드에서는 request 객체에 저장된 데이터를 가지고
//				actionDo() 메소드를 실행하므로 insert.jsp에서 폼에 입력한 데이터는 actionDo() 메소드의 request 객체로 전달된다.
//				insert.jsp에서 폼에 입력한 데이터를 테이블에 저장하는 메소드를 호출한다.
				service.insert(request, response);
				viewPage += "insertOK";
				break;
				
			case "/list.nhn":
//				브라우저에 출력할 1페이지 분량의 글과 페이지 작업에 사용할 8개의 변수가 저장된 클래스 객체를 얻어오는 메소드를 호출한다.
				service.selectList(request, response);
				viewPage += "list";
				break;
				
			case "/increment.nhn":
//				조회수를 증가시키는 메소드를 호출한다.
				service.increment(request, response);
				viewPage += "increment";
				break;
				
			case "/contentView.nhn":
//				조회수를 증가시킨 글 1건을 얻어오는 메소드를 호출한다.
				service.selectByIdx(request, response);
				viewPage += "contentView";
				break;
				
			case "/delete.nhn":
//				글 1건을 삭제하는 메소드를 호출한다.
				service.delete(request, response);
				viewPage += "goList";
				break;
				
			case "/update.nhn":
//				글 1건을 수정하는 메소드를 호출한다.
				service.update(request, response);
				viewPage += "goList";
				break;
				
			case "/reply.nhn":
//				답글을 입력하는 페이지에 질문글을 출력하기 위해 질문글 1건을 얻어서 답글을 입력하는 페이지로 넘겨준다.
				service.selectByIdx(request, response);
				viewPage += "reply";
				break;
		}
		viewPage += ".jsp";
//		System.out.println(viewPage);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}

}





















