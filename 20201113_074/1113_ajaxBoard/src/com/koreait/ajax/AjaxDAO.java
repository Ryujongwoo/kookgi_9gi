package com.koreait.ajax;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AjaxDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public AjaxDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "koreait", "0000");
//			System.out.println("연결 성공 : " + conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	검색어로 입력한 문자열이 이름에 포함된 데이터만 얻어오는 메소드
	public ArrayList<AjaxVO> search(String name) {
		System.out.println("AjaxDAO 서블릿의 search()");
		ArrayList<AjaxVO> list = new ArrayList<AjaxVO>();
		try {
			String sql = "select * from ajax where name like ? order by idx desc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, '%' + name + '%');
			rs = pstmt.executeQuery();
			while (rs.next()) {
				AjaxVO vo = new AjaxVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setGender(rs.getString("gender"));
				vo.setEmail(rs.getString("email"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}	
	
	
	
}








