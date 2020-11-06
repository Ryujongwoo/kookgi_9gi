package com.koreait.mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MySession {
	
	static SqlSessionFactory factory; 
	
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
	
	public static SqlSession getSession() {
		return factory.openSession();
	}
	
}










