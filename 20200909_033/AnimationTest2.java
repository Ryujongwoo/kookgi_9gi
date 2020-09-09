package kr.koreait.animationTest;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.JPanel;

public class AnimationTest2 extends JPanel {
	
	Image cards;
	int w = 1027 / 13, h = 615 / 5;		// 카드 1장의 크기
	Random random = new Random();
	int[] numbers = new int[52];
	
	public AnimationTest2() {
//		생성자에서 카드 전체 이미지를 읽어서 Image 객체에 저장하고 numbers 배열에 0 ~ 51을 채운다.
		cards = Toolkit.getDefaultToolkit().getImage("./src/images/cards.png");
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = i;
		}
	}
	
	public static void main(String[] args) {
		
		Frame window = new Frame("Animation");
		window.setBounds(800, 100, 1027, 615);
		window.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		window.setVisible(true);
		
	}

	@Override
	public void paint(Graphics arg0) {
		// TODO Auto-generated method stub
		super.paint(arg0);
	}

}














