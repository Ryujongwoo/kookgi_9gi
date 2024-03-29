package com.koreait.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.koreait.vo.GuestbookVO;

public class GuestbookDAO {

	private static GuestbookDAO instance = new GuestbookDAO();
	private GuestbookDAO() { }
	public static GuestbookDAO getInstance() { return instance; }
	
//	InsertService 클래스에서 mapper와 테이블에 저장할 데이터가 저장된 객체를 넘겨받고 guestbook.xml 파일의 insert.sql 명령을 실행하는 메소드
	public void insert(SqlMapClient mapper, GuestbookVO vo) throws SQLException {
		System.out.println("GuestbookDAO 클래스 insert() 메소드");
//		System.out.println(vo);
//		insert("실행할 sql 명령의 id"[, sql 명령으로 전달할 데이터]) 
		mapper.insert("insert", vo);
	}
	
//	SelectService 클래스에서 mapper를 넘겨받고 테이블에 저장된 전체 글의 개수를 얻어오는 guestbook.xml 파일의 select sql 명령을 실행하는 메소드
	public int selectCount(SqlMapClient mapper) throws SQLException {
		System.out.println("GuestbookDAO 클래스 selectCount() 메소드");
//		queryForObject() : select sql 명령의 실행 결과가 1건일 경우 사용한다. => Object 타입의 데이터를 얻어온다.
//		queryForList() : select sql 명령의 실행 결과가 여러 건일 경우 사용한다. => List 타입의 데이터를 얻어온다.
//		queryForObject(), queryForList() 메소드가 실행되서 얻어온 데이터의 타입과 현재 메소드의 리턴 타입이 달라서 에러가 발생되므로 반드시
//		메소드의 리턴 타입으로 형변환 시켜야 한다.
		return (int) mapper.queryForObject("selectCount");
	}
	
//	SelectService 클래스에서 mapper와 1페이지 분량의 글의 시작 인덱스와 끝 인덱스가 저장된 HashMap 객체를 넘겨받고 테이블에 저장된 전체 글
//	중에서 1페이지 분량의 글을 얻어오는 guestbook.xml 파일의 select sql 명령을 실행하는 메소드
	public ArrayList<GuestbookVO> selectList(SqlMapClient mapper, HashMap<String, Integer> hmap) throws SQLException {
		System.out.println("GuestbookDAO 클래스 selectList() 메소드");
		return (ArrayList<GuestbookVO>) mapper.queryForList("selectList", hmap);
	}
	
}




