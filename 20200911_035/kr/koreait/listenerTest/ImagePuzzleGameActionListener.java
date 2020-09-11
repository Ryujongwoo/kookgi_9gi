package kr.koreait.listenerTest;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ImagePuzzleGameActionListener extends JFrame implements ActionListener {

	JPanel puzzlePanel = new JPanel(new GridLayout(4, 4));
	JButton[] puzzleButton = new JButton[16];
	String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16"};
	JButton startButton = new JButton("시작");
	Random random = new Random();	
	
//	이미지 퍼즐에 사용할 이미지를 기억할 Image 배열을 만든다.
	Image[] images = new Image[16];
	
	public ImagePuzzleGameActionListener() {
		setTitle("ImagePuzzleGame");
		setBounds(1000, 100, 400, 500);
		
//		생성자에서 퍼즐에 사용할 이미지를 읽어서 Image 배열에 저장한다.
		for (int i = 0; i < images.length; i++) {
			String filename = String.format("./src/number/%02d.jpg", i + 1);
//			System.out.println(filename);
			images[i] = Toolkit.getDefaultToolkit().getImage(filename);
		}
		
		setLayout(new BorderLayout());
		viewPuzzle();
		startButton.setFont(new Font("궁서체", Font.BOLD, 50));
		startButton.setPreferredSize(new Dimension(400, 100));
		startButton.addActionListener(this);
		add(startButton, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void viewPuzzle() {
		for (int i = 0; i < puzzleButton.length; i++) {
//			puzzleButton[i] = new JButton(numbers[i]);
//			버튼에 이미지가 표시되는 퍼즐을 만들기 위해서 images 배열에 저장된 이미지를 ImageIcon 클래스 객체를 생성해서 올려준다.
			int index = Integer.parseInt(numbers[i]) - 1;
			puzzleButton[i] = new JButton(new ImageIcon(images[index]));
//			puzzleButton[i].setFont(new Font("Dialog", Font.BOLD, 40));
			puzzleButton[i].addActionListener(this);
			puzzlePanel.add(puzzleButton[i]);
//			if (puzzleButton[i].getActionCommand().equals("16")) {
//				puzzleButton[i].setVisible(false);
//			}
//			버튼에 이미지를 올리면 getActionCommand() 메소드를 사용할 수 없으므로 setName() 메소드로 버튼으 이름을 붙여서 처리한다.
			puzzleButton[i].setName(numbers[i]);
			if (puzzleButton[i].getName().equals("16")) {
				puzzleButton[i].setVisible(false);
			}
		}
		add(puzzlePanel, BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		
		ImagePuzzleGameActionListener window = new ImagePuzzleGameActionListener();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("시작")) {
			for (int i = 0; i < 1000000; i++) {
				int r = random.nextInt(15) + 1;
				String temp = numbers[0];
				numbers[0] = numbers[r];
				numbers[r] = temp;
			}
		} else {
//			ActionEvent 클래스 타입의 변수 e에는 ActionListener가 실행된 ActionCommand는 넘어오지만 버튼에 할당된 이름은 넘어오지 않기
//			때문에 Object 타입의 객체로 ActionListener가 실행된 버튼 정보를 받아서 형변환 시킨 후 이름을 얻어내서 사용해야 한다.
			Object object = e.getSource();
			JButton button = (JButton) object;
			
			int i;
			for (i = 0; i < puzzleButton.length; i++) {
//				if (puzzleButton[i].getActionCommand().equals(e.getActionCommand())) {
				if (puzzleButton[i].getName().equals(button.getName())) {
					break;
				}
			}
			
			if (i % 4 != 0) {
//				if (puzzleButton[i - 1].getActionCommand().equals("16")) {
				if (puzzleButton[i - 1].getName().equals("16")) {
					String temp = numbers[i - 1];
					numbers[i - 1] = numbers[i];
					numbers[i] = temp;
					JButton tempBtn = puzzleButton[i - 1];
					puzzleButton[i - 1] = puzzleButton[i];
					puzzleButton[i] = tempBtn;
				}
			}
			
			if (i % 4 != 3) {
//				if (puzzleButton[i + 1].getActionCommand().equals("16")) {
				if (puzzleButton[i + 1].getName().equals("16")) {
					String temp = numbers[i + 1];
					numbers[i + 1] = numbers[i];
					numbers[i] = temp;
					JButton tempBtn = puzzleButton[i + 1];
					puzzleButton[i + 1] = puzzleButton[i];
					puzzleButton[i] = tempBtn;
				}
			}
			
			if (i / 4 != 0) {
//				if (puzzleButton[i - 4].getActionCommand().equals("16")) {
				if (puzzleButton[i - 4].getName().equals("16")) {
					String temp = numbers[i - 4];
					numbers[i - 4] = numbers[i];
					numbers[i] = temp;
					JButton tempBtn = puzzleButton[i - 4];
					puzzleButton[i - 4] = puzzleButton[i];
					puzzleButton[i] = tempBtn;
				}
			}
			
			if (i / 4 != 3) {
//				if (puzzleButton[i + 4].getActionCommand().equals("16")) {
				if (puzzleButton[i + 4].getName().equals("16")) {
					String temp = numbers[i + 4];
					numbers[i + 4] = numbers[i];
					numbers[i] = temp;
					JButton tempBtn = puzzleButton[i + 4];
					puzzleButton[i + 4] = puzzleButton[i];
					puzzleButton[i] = tempBtn;
				}
			}
			
		}
		
		for (int i = 0; i < puzzleButton.length; i++) {
			puzzleButton[i].setVisible(true);
			puzzlePanel.remove(puzzleButton[i]);
		}
		viewPuzzle();
		revalidate();

		good:
		while (true) {
			for (int i = 0; i < puzzleButton.length - 1; i++) {
//				if (i + 1 != Integer.parseInt(puzzleButton[i].getActionCommand())) {
				if (i + 1 != Integer.parseInt(puzzleButton[i].getName())) {
					break good;
				}
			}
			
			JOptionPane.showMessageDialog(null, "맞췄다~~~~~ 축하해~~~~~");
			break;
			
		}
		
	}

}

















