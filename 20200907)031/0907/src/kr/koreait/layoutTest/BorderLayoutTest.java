package kr.koreait.layoutTest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

//	BorderLayout은 컨테이너를 5개의 영역으로 나누고 각각의 영역에 컴포넌트를 배치하는 레이아웃 매니저이다.
public class BorderLayoutTest extends Frame {

	Label label = new Label("TEXT1");
	Label label2 = new Label("TEXT2");
	Label label3 = new Label("TEXT3");
	Label label4 = new Label("TEXT4");
	Label label5 = new Label("TEXT5");
	Label label6 = new Label("TEXT6");
	
	public BorderLayoutTest() {
		setTitle("BorderLayout");
		setBounds(800, 100, 400, 500);
		
//		BorderLayout을 만들고 적용시킨다. => BorderLayout은 Frame, JFrame의 기본 레이아웃이므로 적용하지 않아도 된다.
//		BorderLayout border = new BorderLayout();
//		setLayout(border);
		
		label.setBackground(Color.YELLOW);
		label.setAlignment(Label.CENTER);
//		add(컴포넌트, 방향), 방향을 생략하면 CENTER가 기본값으로 사용된다.
		add(label, BorderLayout.NORTH);
		
		label2.setBackground(Color.ORANGE);
		label2.setAlignment(Label.CENTER);
//		add(label2, BorderLayout.SOUTH);
		
		label3.setBackground(Color.GREEN);
		label3.setAlignment(Label.CENTER);
//		add(label3, BorderLayout.WEST);
//		add("방향", 컴포넌트) => 방향은 반드시 첫 문자만 대문자로 코딩해야 한다.
		add("West", label3);
		
		label4.setBackground(Color.MAGENTA);
		label4.setAlignment(Label.CENTER);
		add(label4, BorderLayout.EAST);
		
		label5.setBackground(Color.CYAN);
		label5.setAlignment(Label.CENTER);
//		add(label5, BorderLayout.CENTER);
//		add(label5);		// 방향을 생략했으므로 기본값인 CENTER에 배치된다.
		
		label6.setBackground(Color.PINK);
		label6.setAlignment(Label.CENTER);
//		add(label6, BorderLayout.SOUTH);

//		한 구역에 여러개의 컴포넌트를 넣고 싶으면 Panel 이나 JPanel에 컴포넌트를 배치하고 컨테이너에 넣어주면 된다.
//		Panel, JPanel의 기본 레이아웃은 FlowLayout 이다.
//		Panel panel = new Panel();
		Panel panel = new Panel(new GridLayout(1, 2));
		panel.add(label2);
		panel.add(label6);
		add(panel, BorderLayout.SOUTH);
		
		/*
//		BorderLayout의 CENTER에 전화기 숫자 키패드를 넣는다.
		JButton[] buttons = new JButton[12];
		String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "*", "0", "#"};
		JPanel panel2 = new JPanel(new GridLayout(4, 3));
		for (int i = 0; i < numbers.length; i++) {
			buttons[i] = new JButton(numbers[i]);
			panel2.add(buttons[i]);
			buttons[i].setFont(new Font("Dialog", Font.BOLD, 30));
		}
		add(panel2, BorderLayout.CENTER);
		*/
		
		Phone phone = new Phone();
		add(phone, BorderLayout.CENTER);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		BorderLayoutTest window = new BorderLayoutTest();
		
	}
	
}




