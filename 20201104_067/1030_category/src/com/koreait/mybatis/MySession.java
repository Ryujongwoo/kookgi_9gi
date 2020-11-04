package com.koreait.mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MySession {
	
//	SqlSession을 얻기 위한 SqlSessionFactory 객체를 정적으로 선언
	static SqlSessionFactory factory; 
	
//	정적 초기화 블록에서 설정 파일을 읽어 객체(매퍼)를 생성한다.
	static {
		Reader r = null;
		try {
			r = Resources.getResourceAsReader("com/koreait/mybatis/SqlConfig.xml");
			SqlSessionFactoryBuilder build = new SqlSessionFactoryBuilder();
			factory = build.build(r);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
//	SqlSession 객체 얻기
	public static SqlSession getSession() {
		return factory.openSession();
	}
	
}










