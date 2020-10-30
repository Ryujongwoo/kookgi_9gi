package com.koreait.service;

import org.apache.ibatis.session.SqlSession;

import com.koreait.category.CategoryVO;
import com.koreait.dao.CategoryDAO;
import com.koreait.mybatis.MySession;

public class CategoryService {

	private static CategoryService instance = new CategoryService();
	private CategoryService() { }
	public static CategoryService getInstance() {
		return instance;
	}
	
//	insert.jsp에서 호출되는 테이블에 저장할 메인 카테고리 정보가 저장된 객체를 넘겨받고 mapper를 얻어온 후 DAO 클래스의 메인 카테고리를 저장하는
//	insert sql 명령을 실행하는 메소드를 호출하는 메소드
	public void insert(CategoryVO vo) {
		System.out.println("CategoryService 클래스의 insert() 메소드");
//		mybatis mapper를 얻어온다. => mapper가 open되서 넘어온다.
		SqlSession mapper = MySession.getSession();
		
		CategoryDAO.getInstance().insert(mapper, vo);
		
//		실행한 sql 명령이 테이블을 변경하는 insert, delete, update는 작업 결과를 테이블에 반영시키기 위해서 반드시 commit() 메소드를 실행해야
//		하고 테이블을 변경하지 않는 select는 commit() 메소드를 실행하지 않아도 된다.
		mapper.commit();
//		mapper를 사용해서 데이터베이스 작업이 완료되면 반드시 mapper를 닫아야 한다.
		mapper.close();
	}
	
}



