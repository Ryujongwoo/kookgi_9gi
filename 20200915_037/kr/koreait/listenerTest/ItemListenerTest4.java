package kr.koreait.listenerTest;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ItemListenerTest4 extends JFrame implements ItemListener {

//	java.awt 패키지를 사용할 때는 Checkbox 클래스로 체크 박스와 라디오 버튼을 모두 만들었지만 javax.swing 패키지는 체크 박스를 JCheckBox
//	클래스로 만들고 라디오 버튼은 JRadioButton 클래스를 사용해서 만든다.
	JRadioButton football, baseball, handball;
	JPanel panel = new JPanel();
	JLabel label = new JLabel("이곳에 선택한 목록이 나와요");
	
//	ButtonGroup 클래스로 같은 그룹의 라디오 버튼릉 묶어준다. => ButtonGroup 클래스 객체에 JRadioButton 클래스 객체를 추가한다.
	ButtonGroup group = new ButtonGroup();
	
	public ItemListenerTest4() {
		setTitle("ItemListener");
		setBounds(1000, 100, 500, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//		체크 박스 만들기
//		new JRadioButton(text) : 레이블이 표시되는 라디오 버튼을 만든다.
//		new JRadioButton(text, selected) : 레이블이 표시되는 라디오 버튼을 만들고 선택 여부를 지정한다.
//		new JRadioButton(text, icon) : 레이블이 표시되는 라디오 버튼을 만들고 라디오 버튼 대신 이미지를 표시한다.
//		new JRadioButton(text, icon, selected)
		football = new JRadioButton("축구", true);
		baseball = new JRadioButton("야구");
		handball = new JRadioButton("핸드볼");
		panel.add(football);
		panel.add(baseball);
		panel.add(handball);
		add(panel);
		
//		같은 그룹의 JRadioButton 클래스를 ButtonGroup 클래스 객체에 추가해서 같은 그룹으로 묶어준다.
		group.add(football);
		group.add(baseball);
		group.add(handball);
		
		label.setPreferredSize(new Dimension(500, 50));
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label, BorderLayout.SOUTH);
		
		football.addItemListener(this);
		baseball.addItemListener(this);
		handball.addItemListener(this);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		ItemListenerTest4 window = new ItemListenerTest4();
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		
//		getItem() 메소드를 실행하면 Checkbox 클래스 객체를 사용할 때는 레이블을 얻어왔지만 JCheckBox나 JRadioButton 클래스 객체를 사용하면
//		레이블을 얻어오는 것이 아니고 전체 객체 정보를 얻어오기 때문에 getSource() 메소드로 ItemListener가 실행된 객체 정보를 얻어와서
//		사용해야 한다.
//		System.out.println(e.getItem());
		
		Object object = e.getSource();
		JRadioButton radioButton = (JRadioButton) object;
		
//		getText() : 선택되거나 해제되는 체크 박스의 레이블을 얻어온다. => 형변환 하거나 toString(), valueOf(), format() 메소드를 사용하지
//		않아도 된다.
//		System.out.println(checkBox.getText());
//		isSelected() : ItemListener가 실행된 체크 박스가 선택되면 true, 해제되면 false를 리턴한다.
//		System.out.println(checkBox.isSelected());
		if (radioButton == football) {
			label.setText("축구 " + (football.isSelected() ? "선택" : "해제"));
		} else if (radioButton == baseball) {
			label.setText("야구 " + (baseball.isSelected() ? "선택" : "해제"));
		} else if (radioButton == handball) {
			label.setText("핸드볼 " + (handball.isSelected() ? "선택" : "해제"));
		}
		
	}

}

















