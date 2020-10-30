package com.koreait.service;

import java.sql.SQLException;
import java.util.HashMap;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.koreait.dao.GuestbookDAO;
import com.koreait.ibatis.MyAppSqlConfig;
import com.koreait.vo.GuestbookList;
import com.koreait.vo.GuestbookVO;
import com.koreait.vo.Param;

public class SelectService {

	private static SelectService instance = new SelectService();
	private SelectService() { }
	public static SelectService getInstance() { return instance; }

//	list.jsp에서 호출되는 화면에 표시할 페이지 번호를 넘겨받고 mapper를 얻어온 후 DAO 클래스의 1페이지 분량의 글 목록을 얻어오는 메소드를
//	호출하는 메소드
	public GuestbookList selectList(int currentPage) {
		System.out.println("SelectService 클래스 selectList() 메소드");
		SqlMapClient mapper = MyAppSqlConfig.getSqlMapInstance();
		
//		1페이지 분량의 글과 페이지 작업에 사용할 8개의 변수를 저장해서 리턴시킬 객체를 선언한다.
		GuestbookList guestbookList = null;
//		DAO 클래스에 2번 접근해서 sql 명령을 실행해야 하므로 DAO 클래스의 객체를 미리 얻어둔다.
		GuestbookDAO dao = GuestbookDAO.getInstance();
		
		try {
//			1페이지에 표시할 글의 개수를 정한다.
			int pageSize = 10;
//			테이블에 저장된 전체 글의 개수를 얻어온다.
			int totalCount = dao.selectCount(mapper);
//			System.out.println(totalCount);
			
//			pageSize, totalCount, currentPage를 GuestbookList 클래스의 생성자로 넘겨서 1페이지 분량의 글을 저장하고 페이지 작업에 사용할
//			변수를 초기화 시키는 GuestbookList 클래스 객체를 생성한다.
			guestbookList = new GuestbookList(pageSize, totalCount, currentPage);
			
//			parameterClass와 resultClass에는 데이터 타입을 반드시 1개만 적어야 한다.
			HashMap<String, Integer> hmap = new HashMap<String, Integer>();
			hmap.put("startNo", guestbookList.getStartNo());
			hmap.put("endNo", guestbookList.getEndNo());
//			mysql을 아래와 같이 "endNo" 대신 "pageSize"를 저장해서 넘겨주면 된다.
//			hmap.put("pageSize", guestbookList.getPageSize());
			
//			1페이지 분량의 글을 테이블에서 얻어와서 GuestbookList 클래스의 1페이지 분량의 글을 기억하는 ArrayList에 저장한다.
			guestbookList.setList(dao.selectList(mapper, hmap));
//			System.out.println(guestbookList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
//		1페이지 분량의 글과 페이지 작업에 사용할 8개의 변수를 저장한 객체를 리턴시킨다.
		return guestbookList;
	}
	
//	list.jsp에서 호출되는 화면에 표시할 페이지 번호와 검색어(내용)를 넘겨받고 mapper를 얻어온 후 DAO 클래스의 검색어를 포함하는 1페이지 분량의 
//	글 목록을 얻어오는 메소드를 호출하는 메소드
	public GuestbookList selectListMemo(int currentPage, String item) {
		System.out.println("SelectService 클래스 selectListMemo() 메소드");
		SqlMapClient mapper = MyAppSqlConfig.getSqlMapInstance();
		GuestbookList guestbookList = null;
		GuestbookDAO dao = GuestbookDAO.getInstance();
		try {
			int pageSize = 10;
//			테이블에 저장된 전체 글 중에서 내용(memo)에 검색어를 포함하고 있는 글의 개수를 얻어온다.
			int totalCount = dao.selectCountMemo(mapper, item);
//			System.out.println(totalCount);
			guestbookList = new GuestbookList(pageSize, totalCount, currentPage);
//			startNo, endNo와 item은 자료형이 다르기 때문에 HashMap 객체를 사용할 수 없고 별도의 클래스(Param)를 만들어 처리한다.
			Param param = new Param();
			param.setStartNo(guestbookList.getStartNo());
			param.setEndNo(guestbookList.getEndNo());
			param.setItem(item);
//			내용에 검색어를 포함하는 글 1페이지 분량의 테이블에서 얻어와서 GuestbookList 클래스의 1페이지 분량의 글을 기억하는 ArrayList에 
//			저장한다.
			guestbookList.setList(dao.selectListMemo(mapper, param));
//			System.out.println(guestbookList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return guestbookList;
	}
	
//	list.jsp에서 호출되는 화면에 표시할 페이지 번호와 검색어(이름)를 넘겨받고 mapper를 얻어온 후 DAO 클래스의 검색어를 포함하는 1페이지 분량의 
//	글 목록을 얻어오는 메소드를 호출하는 메소드
	public GuestbookList selectListName(int currentPage, String item) {
		System.out.println("SelectService 클래스 selectListName() 메소드");
		SqlMapClient mapper = MyAppSqlConfig.getSqlMapInstance();
		GuestbookList guestbookList = null;
		GuestbookDAO dao = GuestbookDAO.getInstance();
		try {
			int pageSize = 10;
//			테이블에 저장된 전체 글 중에서 이름(name)에 검색어를 포함하고 있는 글의 개수를 얻어온다.
			int totalCount = dao.selectCountName(mapper, item);
//			System.out.println(totalCount);
			guestbookList = new GuestbookList(pageSize, totalCount, currentPage);
			Param param = new Param();
			param.setStartNo(guestbookList.getStartNo());
			param.setEndNo(guestbookList.getEndNo());
			param.setItem(item);
			guestbookList.setList(dao.selectListName(mapper, param));
//			System.out.println(guestbookList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return guestbookList;
	}
	
//	list.jsp에서 호출되는 화면에 표시할 페이지 번호와 검색어(이름+내용)를 넘겨받고 mapper를 얻어온 후 DAO 클래스의 검색어를 포함하는 1페이지 
//	분량의 글 목록을 얻어오는 메소드를 호출하는 메소드
	public GuestbookList selectListNameMemo(int currentPage, String item) {
		System.out.println("SelectService 클래스 selectListNameMemo() 메소드");
		SqlMapClient mapper = MyAppSqlConfig.getSqlMapInstance();
		GuestbookList guestbookList = null;
		GuestbookDAO dao = GuestbookDAO.getInstance();
		try {
			int pageSize = 10;
//			테이블에 저장된 전체 글 중에서 이름(name)과 내용(memo)에 검색어를 포함하고 있는 글의 개수를 얻어온다.
			int totalCount = dao.selectCountNameMemo(mapper, item);
//			System.out.println(totalCount);
			guestbookList = new GuestbookList(pageSize, totalCount, currentPage);
			Param param = new Param();
			param.setStartNo(guestbookList.getStartNo());
			param.setEndNo(guestbookList.getEndNo());
			param.setItem(item);
			guestbookList.setList(dao.selectListNameMemo(mapper, param));
//			System.out.println(guestbookList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return guestbookList;
	}
	
//	list.jsp에서 호출되는 화면에 표시할 페이지 번호와 카테고리 및 검색어를 넘겨받고 mapper를 얻어온 후 DAO 클래스의 검색어를 포함하는 1페이지 
//	분량의 글 목록을 얻어오는 메소드를 호출하는 메소드
	public GuestbookList selectListMulti(int currentPage, String category, String item) {
		System.out.println("SelectService 클래스 selectListMulti() 메소드");
		SqlMapClient mapper = MyAppSqlConfig.getSqlMapInstance();
		GuestbookList guestbookList = null;
		GuestbookDAO dao = GuestbookDAO.getInstance();
		try {
			int pageSize = 10;
			
			Param param = new Param();
			param.setCategory(category);
			param.setItem(item);
//			테이블에 저장된 전체 글 중에서 카테고리에 따른 검색어를 포함하고 있는 글의 개수를 얻어온다.
			int totalCount = dao.selectCountMulti(mapper, param);
//			System.out.println(totalCount);
			
			guestbookList = new GuestbookList(pageSize, totalCount, currentPage);
			param.setStartNo(guestbookList.getStartNo());
			param.setEndNo(guestbookList.getEndNo());
			guestbookList.setList(dao.selectListMulti(mapper, param));
//			System.out.println(guestbookList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return guestbookList;
	}
	
//	selectByIdx.jsp에서 호출되는 수정 또는 삭제할 글번호를 넘겨받고 mapper를 얻어온 후 DAO 클래스의 글 1건을 얻어오는 메소드를 호출하는 메소드
	public GuestbookVO selectByIdx(int idx) {
		System.out.println("SelectService 클래스 selectByIdx() 메소드");
		SqlMapClient mapper = MyAppSqlConfig.getSqlMapInstance();
		GuestbookVO vo = null;
		try {
			vo = GuestbookDAO.getInstance().selectByidx(mapper, idx);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}
	
}






