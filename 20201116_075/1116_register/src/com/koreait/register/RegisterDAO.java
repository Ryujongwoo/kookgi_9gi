package com.koreait.register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RegisterDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public RegisterDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "koreait", "0000");
//			System.out.println("연결 성공 : " + conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	회원 정보를 테이블에 저장하는 메소드
	public int register(RegisterVO vo) {
		System.out.println("RegisterDAO 클래스의 register()");
		try {
			String sql = "insert into register (userID, userPassword, userName, userAge, userGender, userEmail) values (?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserID());
			pstmt.setString(2, vo.getUserPassword());
			pstmt.setString(3, vo.getUserName());
			pstmt.setInt(4, vo.getUserAge());
			pstmt.setString(5, vo.getUserGender());
			pstmt.setString(6, vo.getUserEmail());
//			정상적으로 실행되면 1이 리턴된다.
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	
}




