package com.koreait.service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.koreait.dao.MvcboardDAO;
import com.koreait.mybatis.MySession;
import com.koreait.vo.MvcboardList;
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

//	컨트롤러에 list.nhn으로 요청이 들어오면 컨트롤러에셔 실행되는 메소드로 mapper를 얻어온 후 DAO 클래스의 브라우저에 출력할 1페이지 분량의 글 
//	목록과 페이지 작업에 사용할 8개의 변수가 저장된 클래스 객체를 만들어서 request 영역에 저장하는 메소드
	public void selectList(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("MvcboardService 클래스의 selectList() 메소드");
		SqlSession mapper = MySession.getSession();
		
//		list.nhn이 요청될 때 넘어오는 브라우저에 표시할 페이지 번호를 받는다.
//		브라우저에 표시할 페이지 번호가 정상적으로 넘어왔으면 넘어온 페이지 번호로, 정상적으로 넘어오지 않았다면 1로 브라우저에 표시할 페이지
//		번호를 설정한다.
		int currentPage = 1;
		try {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		} catch (Exception e) { }
		
//		1페이지에 표시할 글의 개수를 정한다.
		int pageSize = 10;
//		테이블에 저장된 전체 글의 개수를 얻어온다.
		int totalCount = dao.selectCount(mapper);
//		System.out.println(totalCount);
		
//		1페이지 분량의 글과 페이지 작업에 사용되는 8개의 변수를 초기화시키는 클래스(MvcboardList)의 객체를 만든다.
		MvcboardList mvcboardList = new MvcboardList(pageSize, totalCount, currentPage);
		
//		1페이지 분량의 시작, 끝 인덱스를 기억하는 HashMap 객체를 만들고 초기화시킨다.
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		hmap.put("startNo", mvcboardList.getStartNo());
		hmap.put("endNo", mvcboardList.getEndNo());
		
//		1페이지 분량의 글 목록을 얻어와서 mvcboardList의 ArrayList에 넣어준다.
		mvcboardList.setList(dao.selectList(mapper, hmap));
//		for (MvcboardVO vo : mvcboardList.getList()) {
//			System.out.println(vo);
//		}
		
//		MvcboardList 클래스 객체를 request 영역에 저장한다.
		request.setAttribute("mvcboardList", mvcboardList);
		
		mapper.close();
	}
	
//	increment.nhn으로 요청이 들어오면 컨트롤러에셔 실행되는 메소드로 조회수를 증가시킬 글번호를 넘겨받고 mapper를 얻어온 후 DAO 클래스의 조회수를
//	증가시는 메소드를 실행하는 메소드
	public void increment(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("MvcboardService 클래스의 increment() 메소드");
		SqlSession mapper = MySession.getSession();
		
//		request 객체로 넘어오는 조회수를 증가시킬 글번호를 받는다.
		int idx = Integer.parseInt(request.getParameter("idx"));
//		System.out.println(idx);
//		조회수를 증가시키는 메소드를 호출한다.
		dao.increment(mapper, idx);
		
		mapper.commit();
		mapper.close();
	}
	
//	contentView.nhn으로 요청이 들어오면 컨트롤러에셔 실행되는 메소드로 조회수를 증가시킨 글번호를 넘겨받고 mapper를 얻어온 후 request 영역에
//	저장하는 메소드
	public void selectByIdx(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("MvcboardService 클래스의 selectByIdx() 메소드");
		SqlSession mapper = MySession.getSession();
		
//		request 객체로 넘어오는 얻어올 글번호와 작업후 돌아갈 페이지 번호를 받는다.
		int idx = Integer.parseInt(request.getParameter("idx"));
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
//		조회수를 증가시킨 글 1건을 얻어와 MvcboardVO 클래스 객체에 저장한다.
		MvcboardVO vo = dao.selectByIdx(mapper, idx);
//		System.out.println(vo);
		
//		브라우저에 표시할 글이 저장된 객체, 작업 후 돌아갈 페이지 번호, 줄바꿈에 사용할 이스케이프 시퀀스를 request 영역에 저장한다.
		request.setAttribute("vo", vo);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("enter", "\r\n");
		
		mapper.close();
	}
	
//	delete.nhn으로 요청이 들어오면 컨트롤러에셔 실행되는 메소드로 삭제할 글번호를 넘겨받고 mapper를 얻어온 후 DAO 클래스의 글 1건을 삭제하는
//	sql 명령을 실행하는 메소드를 실행하는 메소드
	public void delete(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("MvcboardService 클래스의 delete() 메소드");
		SqlSession mapper = MySession.getSession();
		
//		request 객체로 넘어오는 삭제할 글번호를 받는다.
		int idx = Integer.parseInt(request.getParameter("idx"));
//		글 1건을 삭제하는 메소드를 실행한다.
		dao.delete(mapper, idx);
		
		mapper.commit();
		mapper.close();
	}
	
//	update.nhn으로 요청이 들어오면 컨트롤러에서 실행되는 메소드로 수정할 정보를 넘겨받고 mapper를 얻어온 후 DAO 클래스의 글 1건을 수정하는
//	sql 명령을 실행하는 메소드를 실행하는 메소드
	public void update(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("MvcboardService 클래스의 update() 메소드");
		SqlSession mapper = MySession.getSession();
		
//		request 객체로 넘어오는 수정할 글번호, 수정할 데이터를 받아서 MvcboardVO 클래스 객체에 저장한 후 글을 수정하는 메소드를 실행한다.
		int idx = Integer.parseInt(request.getParameter("idx"));
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		MvcboardVO vo = new MvcboardVO();
		vo.setIdx(idx);
		vo.setSubject(subject);
		vo.setContent(content);
//		글 1건을 수정하는 메소드를 실행한다.
		dao.update(mapper, vo);
		
		mapper.commit();
		mapper.close();
	}
	
//	replyInsert.nhn으로 요청이 들어오면 컨트롤러에서 실행되는 메소드로 답글 정보를 넘겨받고 mapper를 얻어온 후 조건에 만족하는 seq를 1씩 증가하는
//	sql 명령을 실행하는 메소드를 실행하는 메소드를 호출하고 답글을 저장하는 sql 명령을 실행하는 메소드를 실행하는 메소드
	public void replyInsert(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("MvcboardService 클래스의 update() 메소드");
		SqlSession mapper = MySession.getSession();
		
//		request 객체로 넘어온 답글 정보를 받는다.
		int idx = Integer.parseInt(request.getParameter("idx"));
		int ref = Integer.parseInt(request.getParameter("ref"));
		int lev = Integer.parseInt(request.getParameter("lev"));
		int seq = Integer.parseInt(request.getParameter("seq"));
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
//		MvcboardVO 클래스 객체에 저장한다. => 답글 정보이므로 request 객체로 넘겨받은 lev와 seq는 1씩 증가시켜 저장한다.
		MvcboardVO vo = new MvcboardVO(name, subject, content);
		vo.setIdx(idx);
		vo.setRef(ref);
		vo.setLev(lev + 1);
		vo.setSeq(seq + 1);
		
//		같은 글 그룹(ref)에서 답글이 삽입될 위치(seq) 이후의 모든 글이 출력될 위치를 1씩 증가시키는 메소드를 실행한다.
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		hmap.put("ref", vo.getRef());
		hmap.put("seq", vo.getSeq());
		dao.incrementSeq(mapper, hmap);
		
//		답글을 저장하는 메소드를 실행한다.
		dao.insertReply(mapper, vo);
		
		mapper.commit();
		mapper.close();
	}
	
}







