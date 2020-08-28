package kr.koreait.windowTest;

import javax.swing.JFrame;

//	JFrame 클래스를 상속받아 윈도우 만들기
public class WindowTest4 extends JFrame {

	public WindowTest4() {
		this("제목 없는 생성자");
	}
	public WindowTest4(String title) {
		setTitle(title);
		setBounds(800, 100, 400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		WindowTest4 window = new WindowTest4();
		new WindowTest4("제목 있는 윈도우");
		
	}
	
}
