package kr.koreait.listenerTest;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ListBoxTest extends JFrame implements ActionListener {

	JLabel topLabel;			// 윈도우 상단의 제목 레이블
	
	JPanel listPanel;			// 리스트 박스가 올라갈 패널
	List singleList;			// 단일 선택 리스트 박스
	List multiList;				// 다중 선택 리스트 박스
	
	JPanel buttonPanel;			// 보기, 삭제 버튼이 올라갈 패널
	JButton showButton;			// 보기 버튼
	JButton deleteButton;		// 삭제 버튼
	
	JLabel bottomLabel;			// 윈도우 하단에 작업 메시지를 표시할 레이블
	
	public ListBoxTest() {
		setTitle("ListBox");
		setBounds(1000, 100, 400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(4, 1));
		
//		윈도우 상단의 제목 레이블 세팅
		topLabel = new JLabel("리스트 박스 테스트");
		topLabel.setFont(new Font("궁서체", Font.BOLD, 35));
		topLabel.setHorizontalAlignment(JLabel.CENTER);
		add(topLabel);
		
//		윈도우 중단의 리스트 박스 세팅
		listPanel = new JPanel();
//		단일 선택 리스트 박스
//		new List() : 리스트 박스에 표시되는 아이템의 개수가 기본값(4개)으로 보여지는 리스트 박스를 만든다.
//		new List(아이템 개수) : 생성자의 인수로 넘겨준 아이템 개수 만큼 목록이 보여지는 리스트 박스를 만든다.
		singleList = new List();
//		리스트 박스에 아이템을 추가한다.
		singleList.add("고구마");
		singleList.add("감자");
		singleList.add("옥수수");
		singleList.add("오이");
		singleList.add("호박");
		listPanel.add(singleList);
//		다중 선택 리스트 박스
//		new List(아이템 개수, 목록 선택 방법) : 생성자의 인수로 넘겨준 아이템 개수 만큼 목록이 보여지는 리스트 박스를 만들고 목록 선택 방법을
//		생략하면 false가 기본값으로 사용되며 단일 목록 선택 박스가 되고 true를 써주면 다중 목록 선택 박스가 된다.
		multiList = new List(4, true);
		multiList.add("괌");
		multiList.add("코타키나발루");
		multiList.add("다낭");
		multiList.add("나트랑");
		multiList.add("대만");
		multiList.add("푸꾸옥");
		multiList.add("호치민");
		multiList.add("달랏");
		listPanel.add(multiList);
		add(listPanel);
		
//		윈도우 중단의 보기, 삭제 버튼 세팅
		buttonPanel = new JPanel();
		showButton = new JButton("보기");
		deleteButton = new JButton("삭제");
		buttonPanel.add(showButton);
		buttonPanel.add(deleteButton);
		add(buttonPanel);
		
//		윈도우 하단의 레이블 세팅
		bottomLabel = new JLabel("이곳에 작업 결곽가 표시됩니다.");
		bottomLabel.setHorizontalAlignment(JLabel.CENTER);
		add(bottomLabel);
		
//		보기, 삭제 버튼에 ActionListener를 걸어준다.
		showButton.addActionListener(this);
		deleteButton.addActionListener(this);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		ListBoxTest window = new ListBoxTest();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

//		어떤 버튼에서 ActionListener가 실행되었나 판단해서 적당한 작업을 한다.
		switch (e.getActionCommand()) {
			case "보기":
//				bottomLabel.setText("왼쪽 목록 : " + singleList.getSelectedItem());
				String str = "왼쪽 목록 : ";
				if (singleList.getSelectedItem() == null) {
					str += "없음";
				} else {
					str += singleList.getSelectedItem();
				}
				str += ", 오른쪽 목록 : ";
//				다중 선택 리스트 박스는 2개 이상을 선택할 수 있으므로 선택된 아이템 값을 배열로 받아와야 한다.
//				getSelectedIndexes() : 다중 선택 리스트 박스에서 선택된 아이템의 index를 배열 형태로 얻어온다.
//				getSelectedItems() : 다중 선택 리스트 박스에서 선택된 아이템 값들을 배열 형태로 얻어온다.
				String[] items = multiList.getSelectedItems();
//				System.out.println(items.length);
				if (items.length == 0) {
					str += "없음";
				} else {
					for (int i = 0; i < items.length; i++) {
						if (i > 0) {
							str += ", ";
						}
						str += items[i];
					}
				}
				bottomLabel.setText(str);
				break;
			case "삭제":
				
//				getSelectedIndex() 메소드는 콤보 박스나 리스트 박스에서 아무것도 선택하지 않으면 -1을 리턴한다.
//				System.out.println(singleList.getSelectedIndex());
				if (singleList.getSelectedIndex() >= 0) {
					JOptionPane.showMessageDialog(singleList, singleList.getSelectedItem() + " 삭제 완료!!!");
					singleList.remove(singleList.getSelectedIndex());
				} else {
					JOptionPane.showMessageDialog(singleList, "왼쪽 리스트 박스에서 아무것도 선택하지 않았습니다.");
				}
				
//				다중 선택 리스트 박스에서 삭제할 아이템의 index를 배열로 받아와야 한다.
				int[] deleteIndex = multiList.getSelectedIndexes();
				String[] deleteItems = multiList.getSelectedItems();
				if (deleteIndex.length > 0) {
					
					String deleteList = "";
					for (int i = 0; i < deleteItems.length; i++) {
						if (i > 0) {
							deleteList += ", ";
						}
						deleteList += deleteItems[i];
					}
					JOptionPane.showMessageDialog(multiList, deleteList + " 삭제 완료!!!");
					
//					리스트 박스 앞쪽 부터 삭제
//					int delIndex = 0;
//					for (int i = 0; i < deleteIndex.length; i++) {
//						multiList.remove(deleteIndex[i] - delIndex++);
//					}
//					for (int position : deleteIndex) {
//						multiList.remove(position - delIndex++);
//					}
					
//					리스트 박스 뒤쪽 부터 삭제
					for (int i = deleteIndex.length - 1; i >= 0 ; i--) {
						multiList.remove(deleteIndex[i]);
					}
					
				} else {
					JOptionPane.showMessageDialog(multiList, "오른쪽 리스트 박스에서 아무것도 선택하지 않았습니다.");
				}
				
				break;
		}
		
	}

}

















