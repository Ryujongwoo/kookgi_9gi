package com.koreait.service;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.koreait.dao.GuestbookDAO;
import com.koreait.ibatis.MyAppSqlConfig;
import com.koreait.vo.GuestbookVO;

public class InsertService {

//	singleton 패턴은 프로그램에서 한 순간에 단 한 개의 객체만 필요할 경우 사용하는 클래스 디자인 패턴이다.
//	singleton 패턴 코딩 방법
//	1. 자기 자신의 객체를 기본 생성자를 사용해서 정적 멤버로 만든다.
	private static InsertService instance = new InsertService();
//	2. 클래스 외부에서 객체를 생성할 수 없도록 기본 생성자의 접근 권한을 private으로 변경한다.
	private InsertService() { }
//	3. 자기 자신의 객체를 리턴하는 정적 메소드를 만든다.
	public static InsertService getInstance() { return instance; }
	
//	insertOK.jsp에서 넘어오는 테이블에 저장할 데이터가 저장된 객체를 넘겨받고 mapper를 얻어오는 메소드
	public void insert(GuestbookVO vo) {
		System.out.println("InsertService 클래스 insert() 메소드");
//		System.out.println(vo);
		
//		mapper를 얻어온다.
//		mapper에는 데이터베이스에 연결하는 connection과 연결된 후 실행할 sql 명령(guestbook.xml)이 저장되어 있다.
		SqlMapClient mapper = MyAppSqlConfig.getSqlMapInstance();
		
//		DAO 클래스의 sql 명령을 실행하는 메소드를 실행하기 전에 필요한 작업(전처리)이 있으면 실행한다.
		
//		DAO 클래스의 insert sql 명령을 실행하는 메소드를 실행한다.		
		try {
			GuestbookDAO.getInstance().insert(mapper, vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}






