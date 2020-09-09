package kr.koreait.animationTest;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.JPanel;

public class AnimationTest5 extends JPanel implements Runnable {
	
	Image[] images = new Image[15];
	int w = 88, h = 146, xpos = 600, index = 0;
	
	public AnimationTest5() {
		for (int i = 0; i < images.length; i++) {
			String filename = String.format("./src/images/princess_walk_%02d.png", i);
			images[i] = Toolkit.getDefaultToolkit().getImage(filename);
		}
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
		
		AnimationTest5 animation = new AnimationTest5();
		window.add(animation);
		
		window.setVisible(true);
		
		Thread thread = new Thread(animation);
		thread.start();
		
	}

	@Override
	public void paint(Graphics g) {

		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 720, 320);
		g.drawImage(images[(images.length - 1) - index % images.length], xpos, 100, this);
		
	}

	@Override
	public void run() {
		
		while (true) {
			try { Thread.sleep(66); } catch (InterruptedException e) { e.printStackTrace(); }
			if (--xpos <= -w) {
				xpos = 720;
			}
			index++;
			repaint();
		}
		
	}

}














