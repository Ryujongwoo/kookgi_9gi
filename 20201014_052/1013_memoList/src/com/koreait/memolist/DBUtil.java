package com.koreait.memolist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;

public class DBUtil {

//	mysql에 연결하는 Connection을 리턴하는 메소드
	public static Connection getMysqlConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/kookgijsp?useUnicode=true&characterEncoding=UTF-8";
			conn = DriverManager.getConnection(url, "root", "0000");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 클래스가 없거나 로드할 수 없습니다.<br/>");
		} catch (MySQLSyntaxErrorException e) {
			System.out.println("데이터베이스가 없거나 이름이 올바르지 않습니다.<br/>");
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결 정보가 올바르지 않습니다.<br/>");
		}
		return conn;
	}
	
//	Connection을 닫아주는 코드
	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}










