package com.koreait.dao;

import org.apache.ibatis.session.SqlSession;

import com.koreait.category.CategoryVO;

public class CategoryDAO {

	private static CategoryDAO instance = new CategoryDAO();
	private CategoryDAO() { }
	public static CategoryDAO getInstance() {
		return instance;
	}
	
//	CategoryService 클래스에서 mapper와 테이블에 저장할 메인 카테고리 정보가 자정된 객체를 넘겨받고 테이블에 메인 카테고리를 저장하는 category.xml
//	파일의 insert sql 명령을 실행하는 메소드
	public void insert(SqlSession mapper, CategoryVO vo) {
		System.out.println("CategoryDAO 클래스의 insert() 메소드");
		mapper.insert("insert", vo);
	}
	
}
