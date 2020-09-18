package kr.koreait.memoProjectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

//	테이블에 저장된 전체 글 목록을 idx의 내림차순으로 얻어오는 select sql 명령을 실행하고 결과를 ArrayList에 저장해서
//	리턴하는 메소드
	public static ArrayList<MemoVO> select() {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<MemoVO> list = null;			// 결과를 저장해서 리턴시킬 ArrayList

		try {
			conn = DBUtil.getMySQLConnection();
			String sql = "select * from memo order by idx desc";
			pstmt = conn.prepareStatement(sql);
//			실행된 select sql 명령의 실행 결과를 ResultSet 객체에 저장한다.
			rs = pstmt.executeQuery();
//			select sql 명령이 정상적으로 실행되었으므로 결과를 저장해서 리턴시킬 ArrayList 객체를 만든다.
			list = new ArrayList<MemoVO>();

//			ResultSet 객체에 다음 글이 없을 때 까지 반복하며 글 목록을 ArrayList에 저장시킨다.
//			next() : ResultSet 객체에 저장된 다음 데이터로 접근한다.
//			next() 메소드가 실행되었을 때 ResultSet 객체에 다음에 처리할 데이터가 있으면 true를 리턴하고 없으면 false를 리턴한다.			
			while (rs.next()) {
				
//				MemoVO 클래스 객체를 생성하고 ResultSet 객체의 데이터를 읽어서 각각의 멤버 변수에 저장한 후 ArrayList에 넣어준다.
				MemoVO vo = new MemoVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setPassword(rs.getString("password"));
				vo.setMemo(rs.getString("memo"));
				vo.setWriteDate(rs.getTimestamp("writeDate"));
//				System.out.println(vo);
				list.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
			DBUtil.close(pstmt);
			DBUtil.close(rs);
		}
		
		return list;
	}

}









