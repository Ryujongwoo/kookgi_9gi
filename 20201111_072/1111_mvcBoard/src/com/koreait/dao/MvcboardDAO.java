package com.koreait.dao;

import org.apache.ibatis.session.SqlSession;

import com.koreait.vo.MvcboardVO;

public class MvcboardDAO {

	private static MvcboardDAO instance = new MvcboardDAO();
	private MvcboardDAO() { }
	public static MvcboardDAO getInstance() { return instance; }
	
//	MvcboardService 클래스에서 호출되는 mapper와 테이블에 저장될 메인글 정보가 저장된 객체를 넘겨받고 메인글을 테이블에 저장하는 mvcboard.xml
//	파일의 insert sql 명령을 실행하는 메소드
	public void insert(SqlSession mapper, MvcboardVO vo) {
		System.out.println("MvcboardDAO 클래스의 insert() 메소드");
		mapper.insert("insert", vo);
	}

}
