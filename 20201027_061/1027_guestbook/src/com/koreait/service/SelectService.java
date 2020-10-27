package com.koreait.service;

import java.sql.SQLException;
import java.util.HashMap;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.koreait.dao.GuestbookDAO;
import com.koreait.ibatis.MyAppSqlConfig;
import com.koreait.vo.GuestbookList;

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
	
}






