package kr.koreait.dbTest;

import java.sql.Connection;

public class MySQLConnectionTest2 {

	public static void main(String[] args) {
		
		Connection conn = DBUtil.getMySQLConnection();
		System.out.println("연결성공 : " + conn);
		DBUtil.close(conn);
		
	}
	
}











