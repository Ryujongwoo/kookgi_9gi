package kr.koreait.listenerTest;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MouseMotionListenerTest extends JFrame {

	JPanel panel = new JPanel();
	
	public MouseMotionListenerTest() {
		setTitle("MouseMotionListener");
		setBounds(1000, 100, 400, 600);
		
//		MouseMotionListener를 JFrame에 걸어준다. => 윈도우 전체(창틀 포함)에 걸어준다.
//		addMouseMotionListener(new MouseMotionListener() {
//			@Override
//			public void mouseMoved(MouseEvent e) {
//				System.out.println("마우스 이동 : " + e.getPoint());
//			}
//			
//			@Override
//			public void mouseDragged(MouseEvent e) {
//				System.out.println("마우스 드래그 : " + e.getX() + ", " + e.getY());
//			}
//		});
		
		add(panel);
		
		panel.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseMoved(MouseEvent e) {
				System.out.println("마우스 이동 : " + e.getPoint());
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				System.out.println("마우스 드래그 : " + e.getX() + ", " + e.getY());
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		MouseMotionListenerTest window = new MouseMotionListenerTest();
		
	}

}

















