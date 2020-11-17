package com.koreait.register;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserRegister")
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("UserRegister 서블릿 연결");
		System.out.println("UserRegister 서블릿의 actionDo()");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String userID = request.getParameter("userID");
		String userPassword1= request.getParameter("userPassword1");
		String userPassword2= request.getParameter("userPassword2");
		String userName = request.getParameter("userName");
		String userAge = request.getParameter("userAge");
		String userGender = request.getParameter("userGender");
		String userEmail = request.getParameter("userEmail");
		
//		입력 체크
		if (userID == null || userID.trim().equals("") || 
				userPassword1 == null || userPassword1.trim().equals("") ||
				userPassword2 == null || userPassword2.trim().equals("") || 
				userName == null || userName.trim().equals("") ||
				userAge == null || userAge.trim().equals("") ||
				userGender == null || userGender.trim().equals("") ||
				userEmail == null || userEmail.trim().equals("")) {
//			작업의 성공 여부에 따른 메시지를 session에 저장한다.
//			getSession() : 서블릿에서 세션을 얻어온다.
			request.getSession().setAttribute("messageType", "오류 메시지");
			request.getSession().setAttribute("messageContent", "모든 내용을 입력하세요.");
			response.sendRedirect("index.jsp");
			return;
		}
		
//		비번 체크
		if (!userPassword1.trim().equals(userPassword2.trim())) {
			request.getSession().setAttribute("messageType", "오류 메시지");
			request.getSession().setAttribute("messageContent", "비밀번호가 일치하지 않습니다.");
			response.sendRedirect("index.jsp");
			return;
		}
		
		RegisterVO vo = new RegisterVO(userID, userPassword1, userName, Integer.parseInt(userAge), userGender, userEmail);
//		System.out.println(vo);
//		System.out.println(userPassword2);
		
//		테이블에 회원 정보를 저장하는 메소드를 실행한다.
		int result = new RegisterDAO().register(vo);
//		System.out.println(result);
		
		if (result == 1) {
			request.getSession().setAttribute("messageType", "성공 메시지");
			request.getSession().setAttribute("messageContent", "회원 가입에 성공했습니다.");
			response.sendRedirect("index.jsp");
			return;
		} else {
			request.getSession().setAttribute("messageType", "오류 메시지");
			request.getSession().setAttribute("messageContent", "이미 존재하는 회원입니다.");
			response.sendRedirect("index.jsp");
			return;
		}
		
	}

}







