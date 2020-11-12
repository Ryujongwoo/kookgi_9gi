package com.koreait.dao;

import java.util.ArrayList;
import java.util.HashMap;

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
	
//	MvcboardService 클래스에서 호출되는 mapper를 넘겨받고 테이블에 저장된 전체 글의 개수를 얻어오는 mvcboard.xml 파일의 select sql 명령을
//	실행하는 메소드
	public int selectCount(SqlSession mapper) {
		System.out.println("MvcboardDAO 클래스의 selectCount() 메소드");
		return (int) mapper.selectOne("selectCount");
	}
	
//	MvcboardService 클래스에서 호출되는 mapper와 1페이지의 시작, 끝 인덱스가 저장된 HashMap 객체를 넘겨받고 테이블 저장된 글 중에서 1페이지
//	분량의 글 목록을 얻어오는 mvcboard.xml 파일의 select sql 명령을 실행하는 메소드
	public ArrayList<MvcboardVO> selectList(SqlSession mapper, HashMap<String, Integer> hmap) {
		System.out.println("MvcboardDAO 클래스의 selectList() 메소드");
		return (ArrayList<MvcboardVO>) mapper.selectList("selectList", hmap);
	}
	
//	MvcboardService 클래스에서 호출되는 mapper와 조회수를 증가시킬 글번호를 넘겨받고 조회수를 증가시키는 mvcboard.xml 파일의 update sql 명령을
//	실행하는 메소드
	public void increment(SqlSession mapper, int idx) {
		System.out.println("MvcboardDAO 클래스의 increment() 메소드");
		mapper.update("increment", idx);
	}
	
//	MvcboardService 클래스에서 호출되는 mapper와 조회수를 증가시킨 글번호를 넘겨받고 글 1건을 얻어오는 mvcboard.xml 파일의 select sql 명령을
//	실행하는 메소드
	public MvcboardVO selectByIdx(SqlSession mapper, int idx) {
		System.out.println("MvcboardDAO 클래스의 selectByIdx() 메소드");
		return (MvcboardVO) mapper.selectOne("selectByIdx", idx);
	}
	
//	MvcboardService 클래스에서 호출되는 mapper와 삭제 할 글번호를 넘겨받고 글 1건을 삭제하는 mvcboard.xml 파일의 delete sql 명령을 실행하는
//	메소드
	public void delete(SqlSession mapper, int idx) {
		System.out.println("MvcboardDAO 클래스의 delete() 메소드");
		mapper.delete("delete", idx);
	}
	
//	MvcboardService 클래스에서 호출되는 mapper와 수정 할 정보가 저장된 객체를 넘겨받고 글 1건을 수정하는 mvcboard.xml 파일의 update sql 명령을 
//	실행하는 메소드	
	public void update(SqlSession mapper, MvcboardVO vo) {
		System.out.println("MvcboardDAO 클래스의 update() 메소드");
		mapper.update("update", vo);
	}

}
