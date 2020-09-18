package kr.koreait.memoProjectWIN;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class MemoProjectDAO {

//	MemoProjectWIN 클래스에서 테이블에 저장할 데이터가 저장된 MemoVO 클래스 객체를 넘겨받고 모든 데이터가 입력되었다면
//	테이블에 저장하는 메소드
	public static void insert(MemoVO vo) {

//		이름, 비밀번호, 메모가 모두 입력되었나 검사한다.
		if (vo.getName().length() == 0) {
			JOptionPane.showMessageDialog(null, "이름이 입력되지 않았습니다.");
			return;
		} else if (vo.getPassword().length() == 0) {
			JOptionPane.showMessageDialog(null, "비밀번호가 입력되지 않았습니다.");
			return;
		} else if (vo.getMemo().length() == 0) {
			JOptionPane.showMessageDialog(null, "메모가 입력되지 않았습니다.");
			return;
		}
		
//		이름, 비밀번호, 메모가 모두 입력되면 테이블에 저장한다.
		try {
			Connection conn = DBUtil.getMySQLConnection();
			String sql = "insert into memo (name, password, memo) values (?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getMemo());
			pstmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "메모가 입력되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

//	테이블에 저장된 전체 글 목록을 최신글 순서로 얻어와서 ArrayList에 저장해서 리턴하는 메소드
	public static ArrayList<MemoVO> select() {
		
		ArrayList<MemoVO> list = null;
		
		try {
			Connection conn = DBUtil.getMySQLConnection();
			String sql = "select * from memo order by idx desc";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
//			ResultSet로 얻어온 테이블의 글 목록을 ArrayList에 저장한다.
			list = new ArrayList<MemoVO>();
			while (rs.next()) {
				MemoVO vo = new MemoVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setPassword(rs.getString("password"));
				vo.setMemo(rs.getString("memo"));
				vo.setWriteDate(rs.getTimestamp("writeDate"));
				list.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

}









