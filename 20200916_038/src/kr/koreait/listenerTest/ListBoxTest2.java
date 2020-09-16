package kr.koreait.listenerTest;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class ListBoxTest2 extends JFrame implements ActionListener {

	JLabel topLabel;					// 윈도우 상단의 제목 레이블
	
	JPanel listPanel;					// 리스트 박스가 올라갈 패널
//	List singleList;					// 단일 선택 리스트 박스(java.awt)
	JList<String> singleList;			// 단일 선택 리스트 박스(javax.swing)
	DefaultListModel<String> single;	// singleList에 표시할 아이템 목록을 저장하는 객체
//	List multiList;						// 다중 선택 리스트 박스(java.awt)
	JList<String> multiList;			// 다중 선택 리스트 박스(javax.swing)
	DefaultListModel<String> multi;		// multi에 표시할 아이템 목록을 저장하는 객체
	
	JPanel buttonPanel;					// 보기, 삭제 버튼이 올라갈 패널
	JButton showButton;					// 보기 버튼
	JButton deleteButton;				// 삭제 버튼
	
	JLabel bottomLabel;					// 윈도우 하단에 작업 메시지를 표시할 레이블
	
	public ListBoxTest2() {
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
		/*
//		new List() : 리스트 박스에 표시되는 아이템의 개수가 기본값(4개)으로 보여지는 리스트 박스를 만든다.
//		new List(아이템 개수) : 생성자의 인수로 넘겨준 아이템 개수 만큼 목록이 보여지는 리스트 박스를 만든다.
		singleList = new List();
//		리스트 박스에 아이템을 추가한다.
		singleList.add("고구마");
		singleList.add("감자");
		singleList.add("옥수수");
		singleList.add("오이");
		singleList.add("호박");
		*/
		
//		DefaultListModel 클래스 객체를 만들고 addElement() 메소드로 아이템을 추가한 후 DefaultListModel 클래스 객체를
//		JList 클래스의 생성자의 인수로 넘겨준다.
		single = new DefaultListModel<String>();
		single.addElement("고구마");
		single.addElement("감자");
		single.addElement("옥수수");
		single.addElement("오이");
		single.addElement("호박");
		single.addElement("가지");
		single.addElement("양파");
		singleList = new JList<String>(single);
		
//		setSelectionMode() 메소드로 JList 클래스로 생성한 리스트 박스의 선택 모드를 지정한다. => 선택 모드는 ListSelectionModel
//		인터페이스에 상수로 준비되어 있다.
//		ListSelectionModel.SINGLE_SELECTION => 단일 선택 모드
//		ListSelectionModel.SINGLE_INTERVAL_SELECTION => shift 키를 사용하는 다중 선택 모드
//		ListSelectionModel.MULTIPLE_INTERVAL_SELECTION => ctrl, shift 키를 사용하는 다중 선택 모드 => 기본값
		singleList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
//		JList 클래스는 스크롤 바를 표시할 수 없으므로 JScrollPane 클래스 객체를 사용해야 한다. => JScrollPane 클래스 객체를 생성할
//		때 생성자의 인수로 JList 클래스 객체를 넘겨 스크롤 바를 만든다.
		JScrollPane jsSingle = new JScrollPane(singleList);
//		JScrollPane 객체의 크기를 setPreferredSize() 메소드를 사용해서 크기를 조금 더 크게 지정해야 스크롤 바가 표시된다.
		jsSingle.setPreferredSize(new Dimension(120, 75));
		
//		JList 클래스 객체를 넣어준 JScrollPane 클래스 객체를 윈도우에 추가한다.
		listPanel.add(jsSingle);
		
//		다중 선택 리스트 박스
		/*
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
		*/
		
		multi = new DefaultListModel<String>();
		multi.addElement("괌");
		multi.addElement("코타키나발루");
		multi.addElement("다낭");
		multi.addElement("나트랑");
		multi.addElement("대만");
		multi.addElement("푸꾸옥");
		multi.addElement("호치민");
		multi.addElement("달랏");
		multiList = new JList<String>(multi);
		multiList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		JScrollPane jsMulti = new JScrollPane(multiList);
		jsMulti.setPreferredSize(new Dimension(120, 75));
		listPanel.add(jsMulti);
		
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
		
		ListBoxTest2 window = new ListBoxTest2();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

//		어떤 버튼에서 ActionListener가 실행되었나 판단해서 적당한 작업을 한다.
		switch (e.getActionCommand()) {
			case "보기":
//				getSelectedValue() : JList 클래스로 만든 단일 목록 선택 리스트 박스에서 선택한 항목의 아이템을 얻어온다.
//				bottomLabel.setText("왼쪽 목록 : " + singleList.getSelectedValue());
				String str = "단일 목록 : ";
				if (singleList.getSelectedValue() == null) {
					str += "없음";
				} else {
					str += singleList.getSelectedValue();
				}
				str += ", 다중 목록 : ";
//				JList 클래스로 만든 다중 선택 리스트 박스는 2개 이상을 선택할 수 있으므로 선택된 아이템 값을 ArrayList로 받아와야 한다.
//				getSelectedValuesList() : JList 클래스로 만든 다중 목록 리스트 박스에서 선택한 항목의 아이템들을 List 인터페이스 타입으로
//				얻어온다. => ArrayList로 형변환 시켜서 ArrayList에 저장시켜 사용한다.
				try {
					ArrayList<String> items = (ArrayList<String>) multiList.getSelectedValuesList();
					for (int i = 0; i < items.size(); i++) {
						if (i > 0) {
							str += ", ";
						}
						str += items.get(i);
					}
				} catch (Exception e1) {
					str += "없음";
				}
				bottomLabel.setText(str);
				break;
			case "삭제":
//				getSelectedIndex() 메소드는 콤보 박스나 리스트 박스에서 아무것도 선택하지 않으면 -1을 리턴한다.
//				System.out.println(singleList.getSelectedIndex());
				if (singleList.getSelectedIndex() >= 0) {
					JOptionPane.showMessageDialog(singleList, singleList.getSelectedValue() + " 삭제 완료!!!");
//					JList에 데이터를 추가할 때 DefaultListModel 클래스 객체에 addElement() 메소드를 사용해 아이템을 추가했던 것 처럼
//					아이템을 제거할 때도 DefaultListModel 클래스 객체에서 해야하며 removeElementAt() 메소드를 사용한다.
					single.removeElementAt(singleList.getSelectedIndex());
				} else {
					JOptionPane.showMessageDialog(singleList, "왼쪽 리스트 박스에서 아무것도 선택하지 않았습니다.");
				}
				
//				다중 선택 리스트 박스에서 삭제할 아이템의 index를 배열로 받아와야 한다.
				int[] deleteIndex = multiList.getSelectedIndices();
				try {
					ArrayList<String> deleteItems = (ArrayList<String>) multiList.getSelectedValuesList();
					if (deleteIndex.length > 0) {
						String deleteList = "";
						for (int i = 0; i < deleteItems.size(); i++) {
							if (i > 0) {
								deleteList += ", ";
							}
							deleteList += deleteItems.get(i);
						}
						JOptionPane.showMessageDialog(multiList, deleteList + " 삭제 완료!!!");
						
//						리스트 박스 앞쪽 부터 삭제
						int delIndex = 0;
//						for (int i = 0; i < deleteIndex.length; i++) {
//							multi.removeElementAt(deleteIndex[i] - delIndex++);
//						}
						for (int position : deleteIndex) {
							multi.removeElementAt(position - delIndex++);
						}
						
//						리스트 박스 뒤쪽 부터 삭제
//						for (int i = deleteIndex.length - 1; i >= 0 ; i--) {
//							multi.removeElementAt(deleteIndex[i]);
//						}
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(multiList, "오른쪽 리스트 박스에서 아무것도 선택하지 않았습니다.");
				}
				break;
		}
		
	}

}

















