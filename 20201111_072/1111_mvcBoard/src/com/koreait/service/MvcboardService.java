package com.koreait.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.koreait.dao.MvcboardDAO;
import com.koreait.mybatis.MySession;
import com.koreait.vo.MvcboardVO;

public class MvcboardService {

	private static MvcboardService instance = new MvcboardService();
	private MvcboardService() { }
	public static MvcboardService getInstance() { return instance; }
	
	private MvcboardDAO dao = MvcboardDAO.getInstance();
	
//	컨트롤러에 insertOK.nhn으로 요청이 들어오면 컨트롤러에서 실행되는 메소드로 테이블에 저장할 메인글이 저장된 request 객체를 넘겨받고 mapper를
//	얻어온 후 DAO 클래스의 insert sql 명령을 실행하는 메소드를 실행하는 메소드
	public void insert(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("MvcboardService 클래스의 insert() 메소드");
//		System.out.println(request.getParameter("name"));
		SqlSession mapper = MySession.getSession();
		
//		request 객체로 넘어온 insert.jsp에서 폼에 입력한 데이터를 받아서 MvcboardVO 클래스 객체에 저장한다.
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		MvcboardVO vo = new MvcboardVO(name, subject, content);
		
//		DAO 클래스의 insert.jsp에서 입력한 데이터를 저장하는 insert sql 명령을 실행하는 메소드를 호출한다.
		dao.insert(mapper, vo);
		
		mapper.commit();
		mapper.close();
	}
	
}







