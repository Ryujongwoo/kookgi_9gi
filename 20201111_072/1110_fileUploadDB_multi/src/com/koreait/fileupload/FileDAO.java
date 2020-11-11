package com.koreait.fileupload;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FileDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public FileDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "koreait", "0000");
//			System.out.println("연결 성공 : " + conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	파일이 업로드 될 때 마다 업로드하는 파일 이름과 실제로 업로드되는 파일의 이름을 테이블에 저장하는 메소드
	public int upload(String fileName, String fileRealName) {
		System.out.println("FileDAO 클래스의 upload() 메소드");
		try {
			String sql = "insert into fileupload (idx, filename, filerealname) values (fileupload_idx_seq.nextval, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fileName);
			pstmt.setString(2, fileRealName);
//			executeUpdate() 메소드는 sql 명령을 실행하고 성공적으로 실행한 sql 명령의 개수를 리턴한다.
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
//		오류가 발생되면 -1을 리턴하게 한다.
		return -1;
	}

//	파일을 다운로드 하면 다운로드 횟수를 1증가 시키는 메소드
	public int hit(String fileRealName) {
		System.out.println("FileDAO 클래스의 upload() 메소드");
		try {
			String sql = "update fileupload set downloadCount = downloadCount + 1 where fileRealName = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fileRealName);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
//	테이블에 저장된 업로드된 전체 파일 목록을 얻어오는 메소드
	public ArrayList<FileVO> getList() {
		System.out.println("FileDAO 클래스의 getList() 메소드");
		ArrayList<FileVO> list = new ArrayList<FileVO>();
		try {
			String sql = "select * from fileupload";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				FileVO vo = new FileVO(rs.getString("fileName"), rs.getString("fileRealName"), rs.getInt("downloadCount"));
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
//		System.out.println(list);
		return list;
	}
	
}







