package kr.koreait.layoutTest;

import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.JButton;

//	GridLayout은 컨테이터를 격자(grid, 바둑판) 모양으로 나누고 컴포넌트를 나눠진 구역에 순서대로 배치한는 레이아웃 매니저이다.
public class GridLayoutTest extends Frame {

//	버튼 배열만 선언된 상태로 실제 프로그램에서 사용할 버튼 객체는 아직 생성되지 않은 상태이다.
//	버튼 배열을 생성한 수 각각의 버튼 배열 요소에 객체를 생성하지 않은 상태로 사용하면 NullPointerException이 발생된다.
	JButton[] buttons = new JButton[16];		// 클래스로 버튼 배열만 선언했기 때문에 null로 자동 초기화된다.
	String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16"};
	
	public GridLayoutTest() {
		setTitle("GridLayout");
		setBounds(800, 100, 400, 400);
		
//		GridLayout을 만들어서 적용시킨다.
//		new GridLayout(행 개수, 열 개수[, 세로 여백, 가로 여백])
		GridLayout grid = new GridLayout(4, 4, 3, 3);
		setLayout(grid);
		
//		GridLayout 객체를 생성할 때 생성자에서 grid 사이의 여백을 지정할 수 있다.
//		new GridLayout(4, 4) => 여백 없는 4행 4열 GridLayout
//		new GridLayout(4, 4, 3, 0) => 세로 여백이 3인 4행 4열인 GridLayout
//		new GridLayout(4, 4, 0, 3) => 세로 여백이 3인 4행 4열인 GridLayout
//		new GridLayout(4, 4, 3, 3) => 모든 여백이 3인 4행 4열인 GridLayout
		
//		numbers 배열에 저장된 데이터를 섞는다.
		Random random = new Random();
		for (int i = 0; i < 1000000; i++) {
			int r = random.nextInt(15) + 1;
			String temp = numbers[0];
			numbers[0] = numbers[r];
			numbers[r] = temp;
		}
		
		for (int i = 0; i < buttons.length; i++) {
//			컨테이너에 추가할 컴포넌트를 배열로 선언한 경우 반드시 모든 배열 요소마다 객체를 생성한 후 작업해야 한다.
//			buttons[i] = new JButton(i + 1 + "");
//			buttons[i] = new JButton(String.valueOf(i + 1));
//			buttons[i] = new JButton(String.format("%d", i + 1));
			buttons[i] = new JButton(numbers[i]);
			buttons[i].setFont(new Font("Dialog", Font.BOLD, 30));
			add(buttons[i]);
			
			/*
//			버튼 위에 글씨가 있을 때
//			getActionCommand()
			if (buttons[i].getActionCommand().equals("16")) {
//				setEnabled(false) : 컴포넌트를 비 활성화 시킨다.
//				buttons[i].setEnabled(false);
//				setVisible(false) : 컴포넌트를 컨테이너에 표시하지 않는다.
				buttons[i].setVisible(false);
			}
			*/
			
//			버튼 위에 글씨가 없을 때
//			setName() : 컴포넌트에 이름을 지정한다.
//			getName() : 컴포넌트의 이름을 얻어온다.
			buttons[i].setName(numbers[i]);
			if (buttons[i].getName().equals("16")) {
				buttons[i].setVisible(false);
			}
			
		}
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		GridLayoutTest window = new GridLayoutTest();
		
	}
	
}




