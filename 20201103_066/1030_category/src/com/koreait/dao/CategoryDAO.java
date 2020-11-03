package com.koreait.dao;

import java.util.ArrayList;
import java.util.HashMap;

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
	
//	CategoryService 클래스에서 mapper를 넘겨받고 테이블에 저장된 전체 카테고리 목록을 얻어오는 category.xml 파일의 select sql 명령을 실행하는
//	메소드
	public ArrayList<CategoryVO> selectList(SqlSession mapper) {
		System.out.println("CategoryDAO 클래스의 selectList() 메소드");
//		selectOne() : ibatis의 queryForObject() 메소드와 같은 기능이 실행된다. => 결과가 1개인 select sql => Object 타입이 리턴된다.
//		selectList() : ibatis의 queryForList() 메소드와 같은 기능이 실행된다. => 결과가 여러개인 select sql => List 타입이 리턴된다.
		return (ArrayList<CategoryVO>) mapper.selectList("selectList");
	}
	
//	CategoryService 클래스에서 mapper와 ref, seq가 저장된 HashMap 객체를 넘겨받고 같은 카테고리 그룹에서 조건에 만족하는 카테고리의 출력 순서를
//	조정하기 위해 seq를 1증가 시키는 category.xml 파일의 update sql 명령을 실행하는 메소드
	public void increment(SqlSession mapper, HashMap<String, Integer> hmap) {
		System.out.println("CategoryDAO 클래스의 increment() 메소드");
		mapper.update("increment", hmap);
	}
	
//	CategoryService 클래스에서 mapper와 테이블에 저장할 서브 카테고리 정보가 자정된 객체를 넘겨받고 테이블에 서브 카테고리를 저장하는 category.xml
//	파일의 insert sql 명령을 실행하는 메소드
	public void reply(SqlSession mapper, CategoryVO vo) {
		System.out.println("CategoryDAO 클래스의 reply() 메소드");
		mapper.insert("reply", vo);
	}
	
//	CategoryService 클래스에서 mapper와 카테고리 번호를 넘겨받고 테이블에서 카테고리 번호에 해당되는 카테고리 한 건을 얻어오는 category.xml
//	파일의 select sql 명령을 실행하는 메소드
	public CategoryVO selectByIdx(SqlSession mapper, int idx) {
		System.out.println("CategoryDAO 클래스의 selectByIdx() 메소드");
		return (CategoryVO) mapper.selectOne("selectByIdx", idx);
	}
	
//	CategoryService 클래스에서 mapper와 삭제할 카테고리 번호를 넘겨받고 테이블에서 카테고리 번호에 해당되는 카테고리 한 건을 삭제하는 category.xml
//	파일의 delete sql 명령을 실행하는 메소드
	public void delete(SqlSession mapper, int idx) {
		System.out.println("CategoryDAO 클래스의 delete() 메소드");
		mapper.delete("delete", idx);
	}
	
//	CategoryService 클래스에서 mapper와 수정할 카테고리 정보가 저장된 객체를 넘겨받고 테이블에서 카테고리 번호에 해당되는 카테고리 한 건을 
//	수정하는 category.xml 파일의 update sql 명령을 실행하는 메소드
	public void update(SqlSession mapper, CategoryVO vo) {
		System.out.println("CategoryDAO 클래스의 update() 메소드");
		mapper.update("update", vo);
	}

//	CategoryService 클래스에서 mapper와 삭제할 카테고리 번호를 넘겨받고 테이블에서 카테고리 번호에 해당되는 카테고리 한 건을 "삭제된 카테고리
//	입니다."로 수정하는 category.xml 파일의 update sql 명령을 실행하는 메소드
	public void deleteCategory(SqlSession mapper, int idx) {
		System.out.println("CategoryDAO 클래스의 deleteCategory() 메소드");
		mapper.update("deleteCategory", idx);
	}
	
//	CategoryService 클래스에서 mapper와 삭제할 카테고리 번호를 넘겨받고 테이블에서 카테고리 번호에 해당되는 카테고리 한 건의 deleteCheck 필드를
//	"yes"로 수정하는 category.xml 파일의 update sql 명령을 실행하는 메소드
	public void deleteCheck(SqlSession mapper, int idx) {
		System.out.println("CategoryDAO 클래스의 deleteCheck() 메소드");
		mapper.update("deleteCheck", idx);
	}
	
//	CategoryService 클래스에서 mapper와 복구할 카테고리 번호를 넘겨받고 테이블에서 카테고리 번호에 해당되는 카테고리 한 건의 deleteCheck 필드를
//	"no"로 수정하는 category.xml 파일의 update sql 명령을 실행하는 메소드
	public void deleteRestore(SqlSession mapper, int idx) {
		System.out.println("CategoryDAO 클래스의 deleteRestore() 메소드");
		mapper.update("deleteRestore", idx);
	}
	
//	CategoryService 클래스에서 mapper와 신고할 카테고리 번호를 넘겨받고 테이블에서 카테고리 번호에 해당되는 카테고리 한 건의 deleteReport 필드를
//	1증가 시키는 category.xml 파일의 update sql 명령을 실행하는 메소드
	public void deleteReport(SqlSession mapper, int idx) {
		System.out.println("CategoryDAO 클래스의 deleteReport() 메소드");
		mapper.update("deleteReport", idx);
	}
	
//	CategoryService 클래스에서 mapper와 삭제할 카테고리 정보가 저장된 객체를 넘겨받고 테이블에서 삭제할 카테고리 목록을 얻어오는 category.xml
//	파일의 select sql 명령을 실행하는 메소드
	public ArrayList<CategoryVO> deleteList(SqlSession mapper, CategoryVO vo) {
		System.out.println("CategoryDAO 클래스의 deleteList() 메소드");
		return (ArrayList<CategoryVO>) mapper.selectList("deleteList", vo);
	}
	
}
