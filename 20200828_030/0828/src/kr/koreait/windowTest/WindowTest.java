package kr.koreait.windowTest;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

//	Frame 클래스 객체를 생성해 윈도우 띄우기
public class WindowTest {

	public static void main(String[] args) {
		
//		Frame window = new Frame();						// 제목 없는 윈도우를 만든다.
		Frame window = new Frame("제목 있는 윈도우");	// 제목 있는 윈도우를 만든다.
		window.setTitle("제목이 변경된 윈도우");		// 윈도우 제목을 변경한다.
//		window.setSize(400, 300);						// 윈도우 크기를 변경한다.
//		window.setLocation(800, 100);					// 윈도우가 모니터에 표시되는 위치를 변경한다.
		window.setBounds(800, 100, 400, 300);			// 윈도우의 위치와 크기를 한꺼번에 변경한다.
//		window.setBackground(Color.ORANGE);				// 윈도우 배경색을 변경한다.
		
//		Color 클래스를 이용해 색상 만들기
//		new Color(r, g, b) : r(빨강), g(녹색), b(파랑)의 값을 0 ~ 255 사이의 정수를 입력한다.
//		숫자를 크게 할 수록 생상이 밝아지고(가법혼합) 작게 할 수록 어두워진다.
//		숫자를 모두 같은 크기로 지정하면 무조건 회색이 나오며 숫자의 크기에 따라 명도면 변경된다.
//		Color color = new Color(39, 212, 175);
//		new Color(rgb) : 3개의 색상이 6자리로 표현된 16진수를 10진수로 변경해서 넣어준다.
//		Color color = new Color(9469143);
//		window.setBackground(color);

		window.setBackground(new Color(new Random().nextInt(16777216)));
		
//		Frame 클래스를 이용해 윈도우를 띄우면 닫히지 않기 때문에 윈도우를 닫아주는 코드를 넣어줘야 한다.
		window.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
//				System.exit(0);			// 프로그램을 강제로 종료한다. => 모든 윈도우를 닫는다.
				window.dispose();		// 윈도우가 사용하던 자원을 컴퓨터에게 반납한다. => 현재 윈도우만 닫는다.
			}
		});
		
		window.setVisible(true);
		
	}
	
}




















