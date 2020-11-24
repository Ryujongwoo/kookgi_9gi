package com.koreait.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.koreait.vo.MvcboardVO;

public class MvcboardDAO {

	DataSource dataSource;

	public MvcboardDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:/comp/env/jdbc/oracle");
//			System.out.println("아싸~~~~~ 연결성공!!!");
		} catch (NamingException e) {
			e.printStackTrace();
			System.out.println("연결실패!!!");
		}
	}
	
//	InsertService 클래스에서 호출되는 테이블에 저장할 메인글 데이터가 저장된 객체를 넘겨받고 insert sql 명령을 실행하는 메소드
	public void insert(MvcboardVO mvcboardVO) {
		System.out.println("MvcboardDAO 클래스의 insert() 메소드 실행");
//		System.out.println(mvcboardVO);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			
			conn = dataSource.getConnection();
			String sql = "insert into mvcboard (idx, name, subject, content, ref, lev, seq) " + 
						 "values (mvcboard_idx_seq.nextval, ?, ?, ?, mvcboard_idx_seq.currval, 0, 0)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mvcboardVO.getName());
			pstmt.setString(2, mvcboardVO.getSubject());
			pstmt.setString(3, mvcboardVO.getContent());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
	}

//	SelectService 클래스에서 호출되는 테이블에 저장된 전체 글의 개수를 얻어오는 select sql 명령을 실행하는 메소드
	public int selectCount() {
		System.out.println("MvcboardDAO 클래스의 selectCount() 메소드 실행");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;			// 테이블에 저장된 전체 글의 개수를 저장시켜 리턴할 변수를 선언한다.
		try {

			conn = dataSource.getConnection();
			String sql = "select count(*) from mvcboard";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
//			테이블에 저장된 전체 글의 개수는 null이 나올리 없으므로 조건 비교를 할 필요는 없다.
			rs.next();
			result = rs.getInt(1);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		
		return result;
	}

}















