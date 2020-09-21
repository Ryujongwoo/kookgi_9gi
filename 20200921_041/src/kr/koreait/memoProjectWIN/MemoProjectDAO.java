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

//	MemoProjectWIN 클래스에서 테이블에서 얻어올 글 1건의 인덱스를 넘겨받고 인덱스에 해당되는 글 1건을 얻어와 MemoVO 클래스 객체에 저장해서
//	리턴하는 메소드
	public static MemoVO selectByIdx(int position) {
		
		MemoVO vo = null;
		
		try {
			Connection conn = DBUtil.getMySQLConnection();
			String sql = "select * from memo order by idx desc limit ?, 1";
//			String sql = "select * from memo where idx = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, position);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
//				얻어온 글 을 MemoVO 클래스 객체에 저장한다.
				vo = new MemoVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setPassword(rs.getString("password"));
				vo.setMemo(rs.getString("memo"));
				vo.setWriteDate(rs.getTimestamp("writeDate"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
		
	}

//	MemoProjectWIN 클래스에서 JTable에서 선택한 삭제할 데이터의 인덱스와 삭제하기 위해 입력한 비밀번호를 넘겨받고 테이블에
//	저장된 데이터를 삭제하는 메소드
	public static void delete(int selectedRow, String password) {

//		데이터를 삭제하기 위한 비밀번호가 입력되었나 검사한다.
		if (password.length() == 0) {
			JOptionPane.showMessageDialog(null, "비밀번호가 입력되지 않았습니다.");
			return;
		}

//		비밀번호가 입력되었으므로 글을 삭제한다.
//		삭제할 글의 비밀번호와 삭제하기 위해 입력한 비밀번호를 비교하기 위해 삭제할 글을 얻어온다.
		MemoVO vo = selectByIdx(selectedRow);
		
//		삭제할 글의 비밀번호와 삭제하기 위해 입력한 비밀번호를 비교해서 같으면 삭제한다.
		if (vo.getPassword().equals(password)) {
			
			try {
				Connection conn = DBUtil.getMySQLConnection();
				String sql = "delete from memo where idx = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, vo.getIdx());
				pstmt.executeUpdate();
				JOptionPane.showMessageDialog(null, vo.getIdx() + "번 글 삭제완료!!!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} else {
			JOptionPane.showMessageDialog(null, "비밀번호가 올바르지 않습니다.");
		}
		
	}

//	MemoProjectWIN 클래스에서 JTable에서 선택한 수정할 데이터의 인덱스와 수정하기 위해 입력한 비밀번호, 메모를 넘겨받고 테이블에
//	저장된 데이터를 수정하는 메소드
	public static void update(int selectedRow, String password, String memo) {

//		데이터를 수정하기 위한 비밀번호와 메모가 입력되었나 검사한다.
		if (password.length() == 0) {
			JOptionPane.showMessageDialog(null, "비밀번호가 입력되지 않았습니다.");
			return;
		} else if (memo.length() == 0) {
			JOptionPane.showMessageDialog(null, "메모가 입력되지 않았습니다.");
			return;
		}

//		비밀번호와 메모가 입력되었으므로 글을 수정한다.
//		수정할 글의 비밀번호와 수정하기 위해 입력한 비밀번호를 비교하기 위해 수정할 글을 얻어온다.
		MemoVO vo = selectByIdx(selectedRow);
		
//		수정할 글의 비밀번호와 수정하기 위해 입력한 비밀번호를 비교해서 같으면 수정한다.
		if (vo.getPassword().equals(password)) {
			
			try {
				Connection conn = DBUtil.getMySQLConnection();
				String sql = "update memo set memo = ? where idx = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, memo);
				pstmt.setInt(2, vo.getIdx());
				pstmt.executeUpdate();
				JOptionPane.showMessageDialog(null, vo.getIdx() + "번 글 수정완료!!!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} else {
			JOptionPane.showMessageDialog(null, "비밀번호가 올바르지 않습니다.");
		}
		
	}

}









