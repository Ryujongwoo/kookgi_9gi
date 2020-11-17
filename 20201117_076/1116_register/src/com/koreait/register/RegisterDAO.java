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
//		오류가 발생되면 -1을 리턴시킨다.
		return -1;
	}

//	가입하려는 아이디가 테이블에 존재하는가 판단하는 메소드
	public int registerCheck(String userID) {
		System.out.println("RegisterDAO 클래스의 registerCheck()");
		try {
			String sql = "select * from register where userID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			if (userID.trim().equals("")) {
//				아이디를 입력하지 않고 중복체크 버튼을 눌렀다면 0을 리턴시킨다.
				return 2;
			} else if (rs.next()) {
//				select sql 명령의 실행 결과가 존재하면 이미 존재하는 회원이므로 0을 리턴시킨다.
				return 0;
			} else {
//				select sql 명령의 실행 결과가 존재하지 않으면 존재하지 않는 회원이므로 1을 리턴시킨다.
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
}









