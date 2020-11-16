package com.koreait.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AjaxInsert")
public class AjaxInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AjaxInsert 서블릿이 get 방식으로 요청됨");
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AjaxInsert 서블릿이 post 방식으로 요청됨");
		actionDo(request, response);
	}
	
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AjaxInsert 서블릿의 actionDo()");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
//		입력 양식에서 넘어오는 데이터를 받는다.
		String name = request.getParameter("name");
//		System.out.println(name);
		int age = Integer.parseInt(request.getParameter("age"));
//		System.out.println(age);
		String gender = request.getParameter("gender");
//		System.out.println(gender);
		String email = request.getParameter("email");
//		System.out.println(email);
//		넘겨받은 데이터를 테이블에 저장하고 처리 결과(숫자)를 리턴시킨다. => write() 메소드는 인수로 문자열만 가질 수 있으므로 공백을 붙여서
//		문자열로 만들어 리턴시킨다.
		response.getWriter().write(insert(name, age, gender, email) + "");
	}

	private int insert(String name, int age, String gender, String email) {
		AjaxVO vo = new AjaxVO();
		try {
			vo.setName(name);
			vo.setAge(age);
			vo.setGender(gender);
			vo.setEmail(email);
//			System.out.println(vo);
		} catch (Exception e) {
//			넘겨받은 데이터가 올바르지 않으면 AjaxDAO 클래스의 테이블에 저장하는 sql 명령을 실행할 수 없으므로 0을 리턴시킨다.
			return 0;
		}
		return new AjaxDAO().insert(vo);
	}

}













