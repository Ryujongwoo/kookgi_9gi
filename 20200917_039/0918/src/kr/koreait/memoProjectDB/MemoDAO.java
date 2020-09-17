package kr.koreait.memoProjectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//	DAO(Data Access Object) : 데이터베이스에 접속해서 sql 명령을 실행하는 메소드를 모아놓은 클래스
//	실행할 sql 명령 1개당 1개의 메소드를 만든다.
public class MemoDAO {

//	MemoProject 클래스에서 테이블에 저장할 데이터 1건이 저장된 MemoVO 클래스 객체를 넘겨받고 넘겨받은 데이터를 테이블에 저장하는
//	insert sql 명령을 실행하는 메소드
	public static void insert(MemoVO vo) {
		
//		데이터베이스 작업에 사용할 객체를 선언한다.
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
//			데이터베이스에 연결한다.
			conn = DBUtil.getMySQLConnection();
//			sql 명령을 만든다.
			String sql = "insert into memo (name, password, memo) values (?, ?, ?)";
//			sql 명령을 임시로 실행한다.
			pstmt = conn.prepareStatement(sql);
//			"?"를 채운다.
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getMemo());
//			sql 명령을 실행한다.
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
			DBUtil.close(pstmt);
		}
		
	}

	
	
}









