package kr.koreait.listenerTest;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MouseListenerTest2 extends JFrame {

	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	
	public MouseListenerTest2() {
		setTitle("MouseListener");
		setBounds(1000, 100, 400, 600);
		
		setLayout(new GridLayout(2, 1));
		add(panel1);
		panel2.setBackground(Color.ORANGE);
		add(panel2);
		
//		MouseListener 인터페이스를 사용하면 코딩하기는 편리하지만 MouseListener에 정의된 5개의 추상 메소드 Override 되고 사용하지 않는
//		메소드라도 삭제하면 안되고 빈 메소드로 남겨놔야 하는 문제가 있다.
//		Mouse 이벤트 중에서 필요한 이벤트만 사용하려면 필요한 메소드만 Override 시켜서 사용할 수 있다. => MouseAdapter 클래스 객체를
//		익명으로 선언하고 필요한 메소드를 Override 시키면 된다.
		
		panel2.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
//				getButton() : 마우스의 어떤 버튼에서 MouseListener가 실행되었나 얻어온다. => 어떤 버튼이 클릭되었나 얻어온다. => 2bit 방식
//				왼쪽 버튼 : 1 => 01, 가운데 버튼(휠) : 2 => 10, 오른쪽 버튼 : 3 => 11
//				System.out.println(e.getButton());
				/*
				switch (e.getButton()) {
					case 1: // case MouseEvent.BUTTON1:
						System.out.println("왼쪽 버튼");
						break;
					case 2: // case MouseEvent.BUTTON2:
						System.out.println("휠");
						break;
					case 3: // case MouseEvent.BUTTON3:
						System.out.println("오른쪽 버튼");
						break;
				}
				*/
				
//				getModifiers() : 마우스의 어떤 버튼에서 MouseListener가 실행되었나 얻어온다. => 1bit 방식
//				왼쪽 버튼 : 16 => 10000, 가운데 버튼(휠) : 8 => 01000, 오른쪽 버튼 : 4 => 00100
//				System.out.println(e.getModifiers());
				/*
				switch (e.getModifiers()) {
					case 16: // case MouseEvent.BUTTON1_MASK:
						System.out.println("왼쪽 버튼");
						break;
					case 8: // case MouseEvent.BUTTON2_MASK:
						System.out.println("휠");
						break;
					case 4: // case MouseEvent.BUTTON3_MASK:
						System.out.println("오른쪽 버튼");
						break;
				}
				*/
				
//				getModifiersEx() : 마우스 버튼이 어떤 기능키(shift, ctrl, alt)와 같이 클릭되었나 얻어온다.
				/*
				System.out.println(e.getModifiersEx());
				switch (e.getModifiersEx()) {
					case 64: // case MouseEvent.SHIFT_DOWN_MASK:
						System.out.println("shift + 클릭");
						break;
					case 128: // case MouseEvent.CTRL_DOWN_MASK:
						System.out.println("ctrl + 클릭");
						break;
					case 512: // case MouseEvent.ALT_DOWN_MASK:
						System.out.println("alt + 클릭");
						break;
					case 192:
						System.out.println("ctrl + shift + 클릭");
						break;
					case 576:
						System.out.println("alt + shift + 클릭");
						break;
					case 640:
						System.out.println("alt + ctrl + 클릭");
						break;
					case 704:
						System.out.println("alt + ctrl + shift + 클릭");
						break;
					case 1024:
						System.out.println("왼쪽 버튼을 누른 상태로 나머지 버튼 클릭");
						break;
					case 2048:
						System.out.println("휠을 누른 상태로 나머지 버튼 클릭");
						break;
					case 4096:
						System.out.println("오른쪽 버튼을 누른 상태로 나머지 버튼 클릭");
						break;
				}
				*/
				
//				ctrl + 우클릭
//				System.out.println(e.getModifiers());
				if (e.getModifiers() == 6) {
					System.out.println("ctrl + 우클릭");
				}
//				마우스의 왼쪽 버튼과 오른쪽 버튼을 동시에 클릭
				if (e.getModifiers() == 16 && e.getModifiersEx() == 4096 || e.getModifiers() == 4 && e.getModifiersEx() == 1024) {
					System.out.println("왼쪽 버튼과 오른쪽 버튼이 동시에 클릭됨");
				}
				
//				getClickCount() : 마우스 버튼이 연속적으로 클릭된 횟수를 얻어온다.
//				System.out.println(e.getClickCount());
//				왼쪽 버튼 더블 클릭
				if (e.getModifiers() == 16 && e.getClickCount() == 2) {
					System.out.println("왼쪽 버튼 더블 클릭");
				}
				
			}
			
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		MouseListenerTest2 window = new MouseListenerTest2();
		
	}

}

















