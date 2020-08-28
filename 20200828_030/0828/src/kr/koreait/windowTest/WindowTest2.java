package kr.koreait.windowTest;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

//	Frame 클래스를 상속받아 윈도우 만들기
//	Frame 클래스를 상속받으면 현재 클래스 WindowTest2는 Frame 클래스의 모든 기능을 가지게 되므로 현재 클래스가 생성될 때 생성자에서 윈도우에
//	대한 설정을 하고 main() 메소드에서 자신의 객체를 생성하면 윈도우가 만들어진다.
public class WindowTest2 extends Frame {

	public WindowTest2() {
		this("제목 없는 윈도우");
	}
	public WindowTest2(String title) {
		setTitle(title);
		setBounds(800, 100, 400, 300);
		setBackground(new Color(new Random().nextInt(16777216)));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
//				dispose();
			}
		});
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		WindowTest2 window = new WindowTest2();
		new WindowTest2("제목 있는 윈도우");
		
	}
	
}




