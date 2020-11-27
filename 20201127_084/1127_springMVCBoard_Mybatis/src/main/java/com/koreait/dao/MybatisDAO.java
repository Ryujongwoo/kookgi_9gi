package com.koreait.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.koreait.vo.MvcboardVO;

public interface MybatisDAO {

//	mapper 인터페이스의 추상 메소드 형식은 resultType id(parameterType)과 같은 형식으로 만들어 사용한다.
//	MybatisDAO 인터페이스의 추상 메소드 이름이 xml 파일의 sql 명령을 식별하는 id로 사용되고 추상 메소드의 인수로 지정된 데이터가 xml 파일의
//	sql 명령으로 전달된다.
	
	int selectCount();
	ArrayList<MvcboardVO> selectList(HashMap<String, Integer> hmap);
	
//	sql 명령을 실행하는 xml 파일의 parameterType 속성에는 한 개의 자료형만 쓸 수 있는데 아래와 같이 여러개의 데이터를 넘겨야 할 경우
//	인수로 넘어가는 데이터를 모두 멤버 변수로 가지고 있는 클래스 이름을 사용하면 된다.
//	void insert(String name, String subject, String content);
	
	void insert(MvcboardVO mvcboardVO);
	void increment(int idx);
	MvcboardVO selectByIdx(int idx);
	void delete(int idx);
	void update(MvcboardVO mvcboardVO);
	void replyIncrement(HashMap<String, Integer> hmap);
	void replyInsert(MvcboardVO mvcboardVO);

}









