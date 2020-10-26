package com.koreait.dbcptest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

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
	
//	oracle에 연결하는 Connection을 리턴하는 메소드
	public static Connection getOracleConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "koreait", "0000");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 클래스가 없거나 읽어올 수 없습니다.");
		} catch (SQLException e) {
			System.out.println("데이터베이스 접속 정보가 올바르지 않습니다.");
		}
		return conn;
	}
	
//	commonsDBCP를 사용해서 oracle에 연결하는 Connection을 리턴하는 메소드
	public static Connection getCommonsDBCPConnection() {
		Connection conn = null;
		try {
//			Class.forName("com.mysql.jdbc.Driver");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("org.apache.commons.dbcp.PoolingDriver");
			String url = "jdbc:apache:commons:dbcp:/pool";
			conn = DriverManager.getConnection(url);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 클래스가 없거나 읽어올 수 없습니다.");
		} catch (SQLException e) {
			System.out.println("데이터베이스 접속 정보가 올바르지 않습니다.");
		}
		return conn;
	}
	
//	tomcatDBCP를 사용해서 oracle에 연결하는 Connection을 리턴하는 메소드
	public static Connection getTomcatDBCPConnection() {
		Connection conn = null;
		try {
			Context initContext = new InitialContext();
			DataSource dataSource = (DataSource) initContext.lookup("java:/comp/env/jdbc/TestDB");
			conn = dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
}










