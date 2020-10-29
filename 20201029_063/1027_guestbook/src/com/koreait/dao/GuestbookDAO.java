package com.koreait.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.koreait.vo.GuestbookVO;
import com.koreait.vo.Param;

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
	
//	SelectService 클래스에서 mapper와 검색어(내용)를 넘겨받고 테이블에 저장된 전체 글 중에서 검색어를 포함하는 글의 개수를 얻어오는 guestbook.xml 
//	파일의 select sql 명령을 실행하는 메소드
	public int selectCountMemo(SqlMapClient mapper, String item) throws SQLException {
		System.out.println("GuestbookDAO 클래스 selectCountMemo() 메소드");
		return (int) mapper.queryForObject("selectCountMemo", item);
	}
	
//	SelectService 클래스에서 mapper와 1페이지 분량의 글의 시작 인덱스와 끝 인덱스, 검색어(내용)가 저장된 Param 클래스 객체를 넘겨받고 테이블에
//	저장된 전체 글 중에서 검색어를 포함하는 1페이지 분량의 글을 얻어오는 guestbook.xml 파일의 select sql 명령을 실행하는 메소드
	public ArrayList<GuestbookVO> selectListMemo(SqlMapClient mapper, Param param) throws SQLException {
		System.out.println("GuestbookDAO 클래스 selectListMemo() 메소드");
		return (ArrayList<GuestbookVO>) mapper.queryForList("selectListMemo", param);
	}
	
//	SelectService 클래스에서 mapper와 검색어(이름)를 넘겨받고 테이블에 저장된 전체 글 중에서 검색어를 포함하는 글의 개수를 얻어오는 guestbook.xml 
//	파일의 select sql 명령을 실행하는 메소드
	public int selectCountName(SqlMapClient mapper, String item) throws SQLException {
		System.out.println("GuestbookDAO 클래스 selectCountName() 메소드");
		return (int) mapper.queryForObject("selectCountName", item);
	}

//	SelectService 클래스에서 mapper와 1페이지 분량의 글의 시작 인덱스와 끝 인덱스, 검색어(이름)가 저장된 Param 클래스 객체를 넘겨받고 테이블에
//	저장된 전체 글 중에서 검색어를 포함하는 1페이지 분량의 글을 얻어오는 guestbook.xml 파일의 select sql 명령을 실행하는 메소드
	public ArrayList<GuestbookVO> selectListName(SqlMapClient mapper, Param param) throws SQLException {
		System.out.println("GuestbookDAO 클래스 selectListName() 메소드");
		return (ArrayList<GuestbookVO>) mapper.queryForList("selectListName", param);
	}
	
//	SelectService 클래스에서 mapper와 검색어(이름+메모)를 넘겨받고 테이블에 저장된 전체 글 중에서 검색어를 포함하는 글의 개수를 얻어오는 guestbook.xml
//	파일의 select sql 명령을 실행하는 메소드
	public int selectCountNameMemo(SqlMapClient mapper, String item) throws SQLException {
		System.out.println("GuestbookDAO 클래스 selectCountNameMemo() 메소드");
		return (int) mapper.queryForObject("selectCountNameMemo", item);
	}
	
//	SelectService 클래스에서 mapper와 1페이지 분량의 글의 시작 인덱스와 끝 인덱스, 검색어(이름)가 저장된 Param 클래스 객체를 넘겨받고 테이블에
//	저장된 전체 글 중에서 검색어를 포함하는 1페이지 분량의 글을 얻어오는 guestbook.xml 파일의 select sql 명령을 실행하는 메소드
	public ArrayList<GuestbookVO> selectListNameMemo(SqlMapClient mapper, Param param) throws SQLException {
		System.out.println("GuestbookDAO 클래스 selectListNameMemo() 메소드");
		return (ArrayList<GuestbookVO>) mapper.queryForList("selectListNameMemo", param);
	}

//	SelectService 클래스에서 mapper와 카테고리, 검색어가 저장된 Param 클래스 객체를 넘겨받고 테이블에 저장된 전체 글 중에서 검색어를 포함하는 
//	글의 개수를 얻어오는 guestbook.xml 파일의 select sql 명령을 실행하는 메소드
	public int selectCountMulti(SqlMapClient mapper, Param param) throws SQLException {
		System.out.println("GuestbookDAO 클래스 selectCountMulti() 메소드");
		return (int) mapper.queryForObject("selectCountMulti", param);
	}

//	SelectService 클래스에서 mapper와 1페이지 분량의 글의 시작 인덱스와 끝 인덱스, 카테고리, 검색어가 저장된 Param 클래스 객체를 넘겨받고 
//	테이블에 저장된 전체 글 중에서 검색어를 포함하는 1페이지 분량의 글을 얻어오는 guestbook.xml 파일의 select sql 명령을 실행하는 메소드
	public ArrayList<GuestbookVO> selectListMulti(SqlMapClient mapper, Param param) throws SQLException {
		System.out.println("GuestbookDAO 클래스 selectListMulti() 메소드");
		return (ArrayList<GuestbookVO>) mapper.queryForList("selectListMulti", param);
	}
	
//	SelectService 클래스에서 mapper와 수정 또는 삭제할 글번호를 넘겨받고 테이블에 저장된 글 1건을 얻어오는 guestbook.xml 파일의 select sql 명령을
//	실행하는 메소드
	public GuestbookVO selectByidx(SqlMapClient mapper, int idx) throws SQLException {
		System.out.println("GuestbookDAO 클래스 selectByidx() 메소드");
		return (GuestbookVO) mapper.queryForObject("selectByidx", idx);
	}
	
}




