package kr.koreait.memoProjectWIN;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MemoProjectWIM extends JFrame implements ActionListener {

//	JTable의 열 이름으로 사용할 데이터를 저장한 배열을 선언한다.
	String[] columnNames = {"번호", "이름", "비밀번호", "메모", "작성일"};
//	DefaultTableModel 클래스 객체를 사용해 JTable을 디자인한다.
//	new new DefaultTableModel(columnNames, rowCount)
//	columnNames : JTable의 열 이름으로 사용할 데이터를 저장한 배열 이름
//	rowCount : JTable이 윈도우에 표시될 때 기본적으로 보여지는 행의 개수 => 데이터가 없는 빈 행을 보여줄 이유가 없으므로 0을 쓴다.
	DefaultTableModel model = new DefaultTableModel(columnNames, 0);
//	JTable 클래스 객체를 생성할 때 생성자의 인수로 JTable을 디자인한 DefaultTableModel 클래스 객체를 넘겨서 만든다.
	JTable table = new JTable(model);

	JPanel dataPanel = new JPanel(new BorderLayout());			// labelPanel(서), fieldPanel(가), buttonPanel(남)을 올려줄 패널
	
	JPanel labelPanel = new JPanel(new GridLayout(3, 1));		// 레이블을 올려줄 패널
	JLabel nameLabel = new JLabel("이름");						// 이름 레이블
	JLabel passwordLabel = new JLabel("비밀번호");				// 비밀번호 레이블
	JLabel memoLabel = new JLabel("메모");						// 메모 레이블
	
	JPanel fieldPanel = new JPanel(new GridLayout(3, 1));		// 텍스트 필드를 올려줄 패널
	JTextField nameField = new JTextField();					// 이름을 입력하는 텍스트 패널
	JPasswordField passwordField = new JPasswordField();		// 비밀번호를 입력하는 텍스트 패널
	JTextField memoField = new JTextField();					// 메모를 입력하는 텍스트 패널
	
	JPanel buttonPanel = new JPanel(new GridLayout(1, 4));		// 버튼을 올려줄 패널
	JButton insertButton = new JButton("입력");					// 입력 버튼
	JButton selectButton = new JButton("보기");					// 보기 버튼
	JButton updateButton = new JButton("수정");					// 수정 버튼
	JButton deleteButton = new JButton("삭제");					// 삭제 버튼
	
	public MemoProjectWIM() {
		setTitle("MemoProjectWIM");
		setBounds(1200, 100, 500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		JTable 객체를 BorderLayout의 CENTER에 배치한다.
//		JTable 객체를 윈도우에 표시할 할 경우 윈도우에 JTable 객체를 그냥 추가하면 윈도우에 표시되지 않는다.
//		JTable 객체를 윈도우에 표시하려면 JScrollPane 클래스 객체를 생성할 때 생성자의 인수로 윈도우에 표시할 JTable 객체를 넘겨 생성하고
//		JScrollPane 객체를 윈도우에 추가시켜야 한다.
//		이런 방법을 사용하는 이유는 JTable 객체를 윈도우에 넣어줄 때 열 이름과 스크롤 바를 표시해야 하기 때문이다.
		JScrollPane jsp = new JScrollPane(table);
		add(jsp, BorderLayout.CENTER);
		
//		labelPanel에 레이블을 추가하고 dataPanel의 서쪽에 넣어준다.
		labelPanel.setPreferredSize(new Dimension(80, 100));
		labelPanel.add(nameLabel);
		labelPanel.add(passwordLabel);
		labelPanel.add(memoLabel);
		dataPanel.add(labelPanel, BorderLayout.WEST);
		
//		fieldPaneld에 텍스트 필드를 추가하고 dataPanel의 가운데에 넣어준다.
		fieldPanel.add(nameField);
		fieldPanel.add(passwordField);
		fieldPanel.add(memoField);
		dataPanel.add(fieldPanel, BorderLayout.CENTER);
		
//		buttonPanel에 버튼을 추가하고 dataPanel의 남쪽에 넣어준다.
		buttonPanel.setPreferredSize(new Dimension(500, 35));
		buttonPanel.add(insertButton);
		buttonPanel.add(selectButton);
		buttonPanel.add(updateButton);
		buttonPanel.add(deleteButton);
		dataPanel.add(buttonPanel, BorderLayout.SOUTH);
		
//		labelPanel(서), fieldPanel(가), buttonPanel(남)을 올려준 패널을 윈도우의 남쪽에 넣어준다.
		add(dataPanel, BorderLayout.SOUTH);
		
//		입력, 보기, 수정, 삭제 버튼에 ActionListener를 걸어준다.
		insertButton.addActionListener(this);
		selectButton.addActionListener(this);
		updateButton.addActionListener(this);
		deleteButton.addActionListener(this);
		
//		JTable의 데이터를 마우스로 클릭하면 클릭된 데이터를 텍스트 필드에 표시하기 위해 JTable에 MouseListener를 걸어준다.
		table.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
//				getSelectedRow() : JTable에서 몇 번째 행이 선택되었나 얻어온다.
//				System.out.println("선택된 행 : " + table.getSelectedRow());
				int position = table.getSelectedRow();
				
				/*
				int row = table.getSelectedRow();
//				getSelectedColumn() : JTable에서 몇 번째 열이 선택되었나 얻어온다.
				int column = table.getSelectedColumn();
//				getValueAt(row, column) : JTable에서 row행 column열의 데이터를 얻어온다.
				Object object = table.getValueAt(row, column);
				int position = Integer.parseInt((String) object);
				System.out.println(position);
				*/
				
//				테이블에 저장된 전체 글 목록에서 JTable에서 선택한 행에 해당되는 글 1건을 얻어오는 select sql 명령을 실행하는
//				MemoProjectDAO 클래스의 메소드를 호출하고 리턴되는 결과를 MemoVO 클래스 객체로 받는다.
				MemoVO vo = MemoProjectDAO.selectByIdx(position);
//				System.out.println(vo);
				
//				리턴받은 MemoVO 클래스 객체에 저장된 데이터를 텍스트 필드에 넣어주고 포커스를 패스워드 필드로 옮겨준다.
				nameField.setText(vo.getName());
				passwordField.setText("");
				memoField.setText(vo.getMemo());
				passwordField.requestFocus();
				
//				이름은 수정할 수 없도록 비활성화 시킨다.
//				nameField.setEnabled(false);
				nameField.setEditable(false);
				
			}
			
		});
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		MemoProjectWIM window = new MemoProjectWIM();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String name = "", password = "", memo = "";
		MemoVO vo = new MemoVO();
		
		switch (e.getActionCommand()) {
			case "입력":
				
//				텍스트 필드와 패스워드 필드에 입력된 데이터를 받아서 MemoVO 클래스 객체에 저장한다.
				name = nameField.getText().trim();
				password = passwordField.getText().trim();
				memo = memoField.getText().trim();
				vo.setName(name);
				vo.setPassword(password);
				vo.setMemo(memo);
				
//				입력된 데이터를 테이블에 저장하는 insert sql 명령을 실행하는 MemoProjectDAO 클래스의 메소드를 호출한다.
				MemoProjectDAO.insert(vo);
				view();
				clear();
				
				break;
			case "보기":
				
				view();
				
				break;
			case "수정":
				
//				패스워드 필드에 입력한 비밀번호와 텍스트 필드에 입력한 수정할 데이터를 받는다.
				password = passwordField.getText().trim();
				memo = memoField.getText().trim();
//				JTable에서 선택한 데이터를 테이블에 수정하는 update sql 명령을 실행하는 MemoProjectDAO 클래스의 메소드를 호출한다.
				MemoProjectDAO.update(table.getSelectedRow(), password, memo);
				view();
				clear();
				nameField.setEditable(true);
				
				break;
			case "삭제":
				
//				패스워드 필드에 입력한 비밀번호를 받는다.
				password = passwordField.getText().trim();
//				JTable에서 선택한 데이터를 테이블에 삭제하는 delete sql 명령을 실행하는 MemoProjectDAO 클래스의 메소드를 호출한다.
				MemoProjectDAO.delete(table.getSelectedRow(), password);
				view();
				clear();
				nameField.setEditable(true);
				
				break;
		}
		
	}

	private void clear() {
//		다음 데이터를 입력받기 위해 텍스트 필드와 패스워드 필드의 내용을 지우고 이름 텍스트 필드로 포커스를 이동시킨다.
		nameField.setText("");
		passwordField.setText("");
		memoField.setText("");
		nameField.requestFocus();
	}

	private void view() {
//		테이블에 저장된 전체 글 목록을 글번호의 내림차순으로 얻어오는 select sql 명령을 실행하는 MemoProjectDAO
//		클래스의 호출하고 리턴된 결과를 ArrayList에 저장한다.
		ArrayList<MemoVO> list = MemoProjectDAO.select();
//		System.out.println(list);
				
//		JTable에 데이터를 넣어줄 때 기존에 넣어논 데이터를 제거하지 않으면 기존 데이터 뒤에 새로 넣어주는 데이터가
//		추가되 보여지므로 기존 데이터를 모두 제거하고 넣어줘야 한다. => 마지막 데이터 부터 제거하는 것이 편리하다.
//		getRowCount() : JTable 디자인에 사용한 DefaultTableModel 클래스 객체(model)의 데이터 개수를 얻어온다.
		for (int i = model.getRowCount() - 1; i >= 0; i--) {
//			removeRow(row) : DefaultTableModel 클래스 객체에 저장된 row 번째 데이터를 제거한다. 
			model.removeRow(i);
		}
				
//		테이블에 저장된 글이 없다면 없다는 메시지를 출력하고 있으면 테이블에서 얻어온 글을 JTable에 출력한다.
		if (list.size() == 0) {
			JOptionPane.showMessageDialog(null, "테이블에 저장된 메모가 없습니다.");
		} else {
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd(E)");
//			테이블에 저장된 데이터가 5개의 필드를 가지고 있으므로 5개의 데이터를 저장할 수 있는 문자열 배열을 만들고
//			ArrayList에 저장된 데이터를 JTable 디자인으로 사용한 DefaultTableModel 객체에 넣어준다.
			String[] rowData = new String[5];
//			JTable에 ArrayList에 저장된 데이터의 개수 만큼 반복하며 데이터를 넣어준다.
			for (MemoVO data : list) {
				rowData[0] = data.getIdx() + "";
				rowData[1] = data.getName();
				rowData[2] = data.getPassword();
				rowData[3] = data.getMemo();
				rowData[4] = sdf.format(data.getWriteDate());
//				DefaultTableModel 클래스 객체에 addRow() 메소드로 문자열 배열을 넣어준다.
				model.addRow(rowData);
			}
					
		}
	}
	
}














