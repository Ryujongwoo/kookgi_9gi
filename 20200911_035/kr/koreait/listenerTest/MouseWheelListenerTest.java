package kr.koreait.listenerTest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MouseWheelListenerTest extends JFrame {

	JLabel label = new JLabel("테스트");
	JPanel panel1 = new JPanel(new BorderLayout());
	JPanel panel2 = new JPanel();
	int size = 35;
	
	public MouseWheelListenerTest() {
		setTitle("MouseWheelListener");
		setBounds(1000, 100, 400, 600);
		
		setLayout(new GridLayout(2, 1));
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
		label.setFont(new Font("Dialog", Font.BOLD, size));
		panel1.add(label);
		add(panel1);
		panel2.setBackground(Color.pink);
		add(panel2);
		
		panel2.addMouseWheelListener(new MouseWheelListener() {
			
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				
//				getWheelRotation() : 마우스 휠을 굴린 방향을 얻어온다. 앞으로 밀면 -1(음수)를 리턴하고 뒤로 당기면 1(양수)를 리턴한다.
//				System.out.println(e.getWheelRotation());
				
//				휠을 앞으로 밀면 글씨가 커지게 하고 뒤로 당기면 글씨가 작아지게 한다.
				if (e.getPreciseWheelRotation() < 0) {
					size = ++size > 120 ? 120 : size;
				} else {
					size = --size < 10 ? 10 : size;
				}
				label.setFont(new Font("Dialog", Font.BOLD, size));
				
			}
			
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		MouseWheelListenerTest window = new MouseWheelListenerTest();
		
	}

}

















