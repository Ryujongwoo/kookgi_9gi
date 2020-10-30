package com.koreait.service;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.koreait.dao.GuestbookDAO;
import com.koreait.ibatis.MyAppSqlConfig;
import com.koreait.vo.GuestbookVO;

public class UpdateService {

	private static UpdateService instance = new UpdateService();
	private UpdateService() { }
	public static UpdateService getInstance() { return instance; }

//	updateOK.jsp에서 수정할 정보가 저장된 객체를 넘겨받고 mapper를 얻어온 후 테이블에서 글 1건을 수정하는 DAO 클래스의 update sql 명령을 실행하는 
//	메소드를 실행하는 메소드
	public void update(GuestbookVO vo) {
		System.out.println("UpdateService 클래스 update() 메소드");
		SqlMapClient mapper = MyAppSqlConfig.getSqlMapInstance();
		try {
			GuestbookDAO.getInstance().update(mapper, vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
