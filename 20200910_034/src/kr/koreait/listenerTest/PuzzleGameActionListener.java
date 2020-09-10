package kr.koreait.listenerTest;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PuzzleGameActionListener extends JFrame implements ActionListener {

	JPanel puzzlePanel = new JPanel(new GridLayout(4, 4));		// 퍼즐 버튼을 올려서 윈도우의 가운데에 배치할 패널
	JButton[] puzzleButton = new JButton[16];					// 퍼즐 버튼
	String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16"};		// 퍼즐에 올릴 숫자
	JButton startButton = new JButton("시작");					// 시작(섞기) 버튼
	Random random = new Random();	
	
	public PuzzleGameActionListener() {
		setTitle("ActionListener");
		setBounds(1000, 100, 400, 500);
		
//		Frame과 JFrame의 기본 레이아웃은 BorderLayout 이므로 별도로 레이아웃을 지정하지 않아도 상관없다.
		setLayout(new BorderLayout());
		
//		퍼즐 버튼을 BorderLayout의 CENTER에 올리는 메소드를 실행한다.
		viewPuzzle();
		
//		시작 버튼을 BorderLayout SOUTH에 올린다.
		startButton.setFont(new Font("궁서체", Font.BOLD, 50));
		startButton.setPreferredSize(new Dimension(400, 100));
		startButton.addActionListener(this);
		add(startButton, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

//	패널에 퍼즐 버튼을 올려서 윈도우의 CENTER에 올려주는 메소드
	private void viewPuzzle() {
		for (int i = 0; i < puzzleButton.length; i++) {
			puzzleButton[i] = new JButton(numbers[i]);
			puzzleButton[i].setFont(new Font("Dialog", Font.BOLD, 40));
			puzzleButton[i].addActionListener(this);
			puzzlePanel.add(puzzleButton[i]);
			if (puzzleButton[i].getActionCommand().equals("16")) {
				puzzleButton[i].setVisible(false);
			}
		}
		add(puzzlePanel, BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		
		PuzzleGameActionListener window = new PuzzleGameActionListener();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
//		어떤 버튼에서 ActionListener가 실행되었나 판단해서 적절한 코딩을 한다.
		if (e.getActionCommand().equals("시작")) {
//			시작 버튼에서 ActionListener가 실행되면 퍼즐(numbers 배열)을 섞어준다.
			for (int i = 0; i < 1000000; i++) {
				int r = random.nextInt(15) + 1;
				String temp = numbers[0];
				numbers[0] = numbers[r];
				numbers[r] = temp;
			}
		} else {
//			퍼즐 버튼에서 ActionListener가 실행되면 ActionListener가 실행된 버튼이 몇번째 버튼인가 판단한다.
			int i;
			for (i = 0; i < puzzleButton.length; i++) {
//				퍼즐의 i번째 버튼의 ActionCommend와 ActionListener가 실행된 버튼의 ActionCommend를 비교한다.
				if (puzzleButton[i].getActionCommand().equals(e.getActionCommand())) {
					break;
				}
			}
//			System.out.println(i + "번째 버튼에서 ActionListener가 실행됨");
			
//			ActionListener가 실행된 버튼의 왼쪽이 비어있다면(ActionCommend가 "16"이면) 자리를 바꾼다.
//			퍼즐의 첫 번째 열에 위치한 버튼(0, 4, 8, 12 번째 버튼)에서는 왼쪽과 자리를 바꾸는 동작이 실행되면 안된다.
			if (i % 4 != 0) {
				if (puzzleButton[i - 1].getActionCommand().equals("16")) {
					String temp = numbers[i - 1];
					numbers[i - 1] = numbers[i];
					numbers[i] = temp;
					JButton tempBtn = puzzleButton[i - 1];
					puzzleButton[i - 1] = puzzleButton[i];
					puzzleButton[i] = tempBtn;
				}
			}
			
//			ActionListener가 실행된 버튼의 오른쪽이 비어있다면(ActionCommend가 "16"이면) 자리를 바꾼다.
//			퍼즐의 마지막 번째 열에 위치한 버튼(3, 7, 11, 15 번째 버튼)에서는 오른쪽과 자리를 바꾸는 동작이 실행되면 안된다.
			if (i % 4 != 3) {
				if (puzzleButton[i + 1].getActionCommand().equals("16")) {
					String temp = numbers[i + 1];
					numbers[i + 1] = numbers[i];
					numbers[i] = temp;
					JButton tempBtn = puzzleButton[i + 1];
					puzzleButton[i + 1] = puzzleButton[i];
					puzzleButton[i] = tempBtn;
				}
			}
			
//			ActionListener가 실행된 버튼의 위쪽이 비어있다면(ActionCommend가 "16"이면) 자리를 바꾼다.
//			퍼즐의 첫 번째 행에 위치한 버튼(0, 1, 2, 3 번째 버튼)에서는 위쪽과 자리를 바꾸는 동작이 실행되면 안된다.
			if (i / 4 != 0) {
				if (puzzleButton[i - 4].getActionCommand().equals("16")) {
					String temp = numbers[i - 4];
					numbers[i - 4] = numbers[i];
					numbers[i] = temp;
					JButton tempBtn = puzzleButton[i - 4];
					puzzleButton[i - 4] = puzzleButton[i];
					puzzleButton[i] = tempBtn;
				}
			}
			
//			ActionListener가 실행된 버튼의 아래쪽이 비어있다면(ActionCommend가 "16"이면) 자리를 바꾼다.
//			퍼즐의 마지막 행에 위치한 버튼(12, 13, 14, 15 번째 버튼)에서는 아래쪽과 자리를 바꾸는 동작이 실행되면 안된다.
			if (i / 4 != 3) {
				if (puzzleButton[i + 4].getActionCommand().equals("16")) {
					String temp = numbers[i + 4];
					numbers[i + 4] = numbers[i];
					numbers[i] = temp;
					JButton tempBtn = puzzleButton[i + 4];
					puzzleButton[i + 4] = puzzleButton[i];
					puzzleButton[i] = tempBtn;
				}
			}
			
		}
		
//		컨테이너에 배치한 컴포넌트가 재배치 또는 변경되면 기존의 컴포넌트를 모두 제거하고 다시 넣어준다.
//		컴포넌트가 setVisible(false)가 실행되서 보이지 않는 상태일 경우 remove() 메소드로 제거할 수 없으므로 반드시 setVisible(true)를
//		실행해서 보이는 상태로 변경한 다음 제거해야 한다.
		for (int i = 0; i < puzzleButton.length; i++) {
			puzzleButton[i].setVisible(true);
			puzzlePanel.remove(puzzleButton[i]);
		}
		
		viewPuzzle();
		revalidate();

//		퍼즐을 맞췄나 검사한다.
		/*
		int count = 0;
		for (int i = 0; i < puzzleButton.length - 1; i++) {
			if (i + 1 == Integer.parseInt(puzzleButton[i].getActionCommand())) {
				count++;
			}
		}
		if (count == 15) {
			JOptionPane.showMessageDialog(null, "맞췄다~~~~~ 축하해~~~~~");
//			System.exit(0);
		}
		*/
		
		good:	// 레이블
		while (true) {
			for (int i = 0; i < puzzleButton.length - 1; i++) {
				if (i + 1 != Integer.parseInt(puzzleButton[i].getActionCommand())) {
//					break만 사용하면 break가 사용된 반복문이나 switch 명령을 탈출하지만 break 명령에 레이블을 지정하면 지정된
//					레이블에 해당되는 반복을 탈출한다.
					break good;		// good이라는 레이블이 지정된 반복(while)을 탈출한다.
				}
			}
			
			JOptionPane.showMessageDialog(null, "맞췄다~~~~~ 축하해~~~~~");
			break;
			
		}
		
	}

}

















