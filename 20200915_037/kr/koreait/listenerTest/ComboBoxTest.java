package kr.koreait.listenerTest;

import java.awt.Choice;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ComboBoxTest extends JFrame implements ActionListener {

	JLabel topLabel;				// 윈도우 상단의 제목 레이블
	
	JPanel comboPanel;				// 콤보 박스와 보기, 삭제 버튼이 올라갈 패널
	Choice comboBox;				// 콤보 상자
	JButton showButton;				// 보기 버튼
	JButton deleteButton;			// 삭제 버튼
	
	JPanel addPanel;				// 텍스트 필드와 추가 버튼이 올라갈 패널
	TextField addField;				// 콤보 박스에 추가할 데치터를 입력받는 텍스트 필드
	JButton addButton;				// 추가 버튼
	
	JLabel bottomLabel;				// 윈도우 하단에 작업 결과 메시지를 표시할 레이블
	
	public ComboBoxTest() {
		setTitle("KeyListener");
		setBounds(1000, 100, 400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(4, 1));
		
//		윈도우 상단의 제목 레이블 세팅
		topLabel = new JLabel("콤보 박스 테스트");
		topLabel.setFont(new Font("D2Coding", Font.BOLD, 35));
		topLabel.setHorizontalAlignment(JLabel.CENTER);
		add(topLabel);
		
//		윈도우 중단의 콤보 박스와 보기, 삭제 버튼 세팅
		comboPanel = new JPanel();
		
		comboBox = new Choice();			// 콤보 박스를 만든다.
//		Choice 클래스로 만든 콤보 박스에 add() 메소드로 아이템을 추가한다.
		comboBox.add("바나나");
		comboBox.add("파인애플");
		comboBox.add("망고");
		comboBox.add("두리안");
		comboBox.add("베리베리스트로베리");
		
		showButton = new JButton("보기");
		deleteButton = new JButton("삭제");
		comboPanel.add(comboBox);
		comboPanel.add(showButton);
		comboPanel.add(deleteButton);
		add(comboPanel);
		
//		윈도우 중단의 텍스트 필드와 추가 버튼 세팅
		addPanel = new JPanel();
		addField = new TextField(20);
		
//		setEchoChar() : 텍스트 필드에 입력하는 문자 대신 표시할 문자를 지정한다. => 비밀번호 입력할 때 사용한다.
//		addField.setEchoChar('*');
		
		addButton = new JButton("추가");
		addPanel.add(addField);
		addPanel.add(addButton);
		add(addPanel);
		
//		윈도우 하단의 레이블 세팅
		bottomLabel = new JLabel("이곳에 작업 결과가 표시됩니다.");
		bottomLabel.setHorizontalAlignment(JLabel.CENTER);
		add(bottomLabel);
		
//		보기, 삭제, 추가 버튼에 ActionListener를 걸어준다.
		showButton.addActionListener(this);
		deleteButton.addActionListener(this);
		addButton.addActionListener(this);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		ComboBoxTest window = new ComboBoxTest();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

//		어떤 버튼에서 ActionListener가 실행되었나 판단해서 적당한 작업을 한다.
		String item = "";
		switch (e.getActionCommand()) {
			case "보기":
//				getSelectedIndex() : 콤보 박스에서 몇 번째 index가 선택되었나 리턴한다. => index는 0부터 시작된다.
//				getItem() : 콤보 박스이 index 번째 항목에 해당되는 아이템을 얻어온다.
//				bottomLabel.setText("선택된 아이템 : " + comboBox.getItem(comboBox.getSelectedIndex()));
//				getSelectedItem() : 콤보 박스에서 선택한 아이템을 리턴한다.
//				comboBox.getItem(comboBox.getSelectedIndex())를 실행한 결과와 같은 기능이 실행된다.
				bottomLabel.setText("선택된 아이템 : " + comboBox.getSelectedItem());
				break;
			case "삭제":
				item = comboBox.getSelectedItem() + "를(을) 삭제하시겠습니까?";
				int result = JOptionPane.showConfirmDialog(comboBox, item, "삭제 확인", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (result == 0) {
//					remove(position) : 콤보 박스에서 position 번째 아이템을 제거한다.
					bottomLabel.setText(comboBox.getSelectedItem() + " 삭제 완료!!!");
					comboBox.remove(comboBox.getSelectedIndex());
				} else {
					bottomLabel.setText(comboBox.getSelectedItem() + " 삭제 취소!!!");
				}
				break;
			case "추가":
				
				item = addField.getText().trim();
				if (item.length() > 0) {
					
					comboBox.add(item);
					bottomLabel.setText(item + " 추가 완료!!!");
					
//					select(pos) : 콤보 박스의 pos 번째 위치의 아이템을 콤보 박스에 표시한다.
//					getItemCount() : 콤보 박스에 저장된 아이템의 개수를 얻어온다.
					comboBox.select(comboBox.getItemCount() - 1);
					
				} else {
					JOptionPane.showMessageDialog(addField, "콤보 박스에 추가할 아이템을 입력하세요", "입력 확인", JOptionPane.ERROR_MESSAGE);
				}
				addField.setText("");
				addField.requestFocus();
				
				break;
		}
		
	}

}

















