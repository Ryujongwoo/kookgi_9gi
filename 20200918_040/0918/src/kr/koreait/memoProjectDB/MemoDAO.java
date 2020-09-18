package kr.koreait.memoProjectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

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

	
//	MemoProject 클래스에서 삭제할 글번호를 넘겨받고 글이 정상적으로 삭제되면 true, 실패하면 false를 리턴하는 메소드
	public static boolean delete(int idx) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getMySQLConnection();
//			삭제할 글을 화면에 보여주기 위해서 삭제할 글을 테이블에서 얻어온다.
			String sql = "select * from memo where idx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			
//			삭제할 글번호에 해당되는 글이 있으면 콘솔에 출력하고 없으면 false를 리턴시킨다.
			if (rs.next()) {
				
//				삭제할 글번호에 해당되는 글이 있으면 콘솔에 출력하고 비밀번호를 입력받는다.
				MemoVO vo = new MemoVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setPassword(rs.getString("password"));
				vo.setMemo(rs.getString("memo"));
				vo.setWriteDate(rs.getTimestamp("writeDate"));
				System.out.println("삭제할 글 확인하기");
				System.out.println(vo);
				
				Scanner scanner = new Scanner(System.in);
				System.out.print("비밀번호를 입력하세요 : ");
				String password = scanner.nextLine().trim();
				
//				삭제할 글의 비밀번호와 삭제하기 위해 입력한 비밀번호를 비교해서 같으면 글을 삭제하고 다르면 false를 리턴시킨다.
				if (vo.getPassword().equals(password)) {
					
//					삭제할 글의 비밀번호와 삭제하기 위해 입력한 비밀번호가 같으면 글을 삭제한다.
					sql = "delete from memo where idx = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, idx);
					pstmt.executeUpdate();
					
				} else {
//					삭제할 글의 비밀번호를 틀리게 입력했기 때문에 false를 리턴시킨다.
					return false;
				}
				
			} else {
//				삭제할 글이 테이블에 존재하지 않기 때문에 false를 리턴시킨다.
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
			DBUtil.close(pstmt);
			DBUtil.close(rs);
		}
		
//		삭제 작업이 정상적으로 완료되면 true를 리턴시킨다.
		return true;
	}

	
//	MemoProject 클래스에서 수정할 글번호를 넘겨받고 글이 정상적으로 수정되면 true, 실패하면 false를 리턴하는 메소드
	public static boolean update(int idx) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.getMySQLConnection();
//			수정할 글을 화면에 보여주기 위해서 수정할 글을 테이블에서 얻어온다.
			String sql = "select * from memo where idx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			
//			수정할 글번호에 해당되는 글이 있으면 콘솔에 출력하고 없으면 false를 리턴시킨다.
			if (rs.next()) {

//				수정할 글번호에 해당되는 글이 있으면 콘솔에 출력하고 비밀번호를 입력받는다.
				MemoVO vo = new MemoVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setPassword(rs.getString("password"));
				vo.setMemo(rs.getString("memo"));
				vo.setWriteDate(rs.getTimestamp("writeDate"));
				System.out.println("수정할 글 확인하기");
				System.out.println(vo);

				Scanner scanner = new Scanner(System.in);
				System.out.print("비밀번호를 입력하세요 : ");
				String password = scanner.nextLine().trim();

//				수정할 글의 비밀번호와 수정하기 위해 입력한 비밀번호를 비교해서 같으면 글을 수정하고 다르면 false를 리턴시킨다.
				if (vo.getPassword().equals(password)) {
					
//					수정할 내용을 입력받는다.
					System.out.print("수정할 메모를 입력하세요 : ");
					String memo = scanner.nextLine().trim();
					
//					수정할 글의 비밀번호와 수정하기 위해 입력한 비밀번호가 같으면 글을 수정한다.
					sql = "update memo set memo = ? where idx = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, memo);
					pstmt.setInt(2, idx);
					pstmt.executeUpdate();
					
				} else {
//					수정할 글의 비밀번호를 틀리게 입력했기 때문에 false를 리턴시킨다.
					return false;
				}

			} else {
//				수정할 글이 테이블에 존재하지 않기 때문에 false를 리턴시킨다.
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
			DBUtil.close(pstmt);
			DBUtil.close(rs);
		}
		
//		수정 작업이 정상적으로 완료되면 true를 리턴시킨다.
		return true;
		
	}

}





















