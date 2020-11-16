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
		System.out.println("AjaxDAO 클래스의 search()");
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

//	입력 양식에 입력한 데이터를 테이블에 저장하는 메소드
	public int insert(AjaxVO vo) {
		System.out.println("AjaxDAO 클래스의 insert()");
		try {
			String sql = "insert into ajax (idx, name, age, gender, email) values (ajax_idx_seq.nextval, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getAge());
			pstmt.setString(3, vo.getGender());
			pstmt.setString(4, vo.getEmail());
//			sql 명령이 정상적으로 실행된 seq 명령의 개수를 리턴시킨다. => sql 명령이 정상적으로 실행되면 데이터 1건을 저장하는 sql 명령이므로
//			1이 리턴된다.
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
//		sql 명령문에 오류가 있으면 -1을 리턴시킨다.
		return -1;
	}	
	
}








