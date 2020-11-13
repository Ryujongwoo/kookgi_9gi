package com.koreait.ajax;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AjaxSearch")
public class AjaxSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AjaxSearch 서블릿이 get 방식으로 요청됨");
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AjaxSearch 서블릿이 post 방식으로 요청됨");
		actionDo(request, response);
	}
	
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AjaxSearch 서블릿의 actionDo()");
		request.setCharacterEncoding("UTF-8");
//		처리된 데이터가 전송되는 컨텐츠 타입을 설정한다.
		response.setContentType("text/html; charset=UTF-8");
		String name = request.getParameter("name");
//		System.out.println(name);
//		new AjaxDAO();
//		ajax 방식으로 요청한 곳으로 처리한 데이터를 리턴시킨다. => ajax로 서블릿을 호출한 쪽에서 responseText를 사용해서 받는다.
		response.getWriter().write(getJSON(name));
	}

	private String getJSON(String name) {
		System.out.println("AjaxSearch 서블릿의 getJSON()");
		
//		검색할 이름을 입력하지 않고 검색 버튼을 클릭했을 때 null을 공백으로 처리한다.
		if (name == null) {
			name = "";
		}
		
//		테이블에서 입력한 문자열이 이름에 포함된 데이터를 얻어온다.
//		System.out.println(name);
		ArrayList<AjaxVO> list = new AjaxDAO().search(name);
//		System.out.println(list);
		
//		얻어온 입력된 문자열이 포함된 데이터들을 하나의 문자열로 연결한다.
		StringBuffer result = new StringBuffer();
		result.append("{\"result\":[");
		for (int i = 0; i < list.size(); i++) {
			result.append("[{\"value\":\"" + list.get(i).getIdx() + "\"},");
			result.append("{\"value\":\"" + list.get(i).getName() + "\"},");
			result.append("{\"value\":\"" + list.get(i).getAge() + "\"},");
			result.append("{\"value\":\"" + list.get(i).getGender() + "\"},");
			result.append("{\"value\":\"" + list.get(i).getEmail() + "\"}],");
		}
		result.append("]}");
		
//		StringBuffer 타입의 객체를 String 타입으로 리턴시키기 위해서 toString() 메소드를 실행해서 리턴시킨다.
		return result.toString();
	}
	
}

















