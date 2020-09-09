package kr.koreait.animationTest;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.JPanel;

public class AnimationTest3 extends JPanel implements Runnable {
	
	Image bg, ship;
	int w = 488 / 4, h = 65;		// 우주선 1장의 크기
	int xpos = 100;
	int index = 0;					// 우주선 이미지 출력 순서 조정에 사용하는 변수
	
	public AnimationTest3() {
		bg = Toolkit.getDefaultToolkit().getImage("./src/images/bg.png");
		ship = Toolkit.getDefaultToolkit().getImage("./src/images/Ship.png");
	}
	
	public static void main(String[] args) {
		
		Frame window = new Frame("Animation");
		window.setBounds(800, 100, 720, 320);
		window.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		AnimationTest3 animation = new AnimationTest3();
		window.add(animation);
		
		window.setVisible(true);
		
		Thread thread = new Thread(animation);
		thread.start();
		
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(bg, 0, 0, this);
//		g.drawImage(ship, 0, 0, this);
		g.drawImage(ship, xpos, 100, xpos + w, 100 + h, index * w, 0, (index + 1) * w, h, this);
	}

	@Override
	public void run() {
		
		while (true) {
			if ((xpos += 2) > 720) {
				xpos = -w;
			}
			try { Thread.sleep(10); } catch (InterruptedException e) { e.printStackTrace(); }
//			if (++index == 4) {
//				index = 0;
//			}
//			index = ++index == 4 ? 0 : index;
			index = ++index % 4;
			repaint();
		}
		
	}

}














