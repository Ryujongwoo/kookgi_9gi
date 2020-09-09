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

public class AnimationTest6 extends JPanel implements Runnable {
	
	Image[] images = new Image[10];
	int w = 55, h = 68, xpos = 50, index = 0;
	
	public AnimationTest6() {
		for (int i = 0; i < images.length; i++) {
			String filename = String.format("./src/images/Duke%02d.gif", i + 1);
//			System.out.println(filename);
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
		
		AnimationTest6 animation = new AnimationTest6();
		window.add(animation);
		
		window.setVisible(true);
		
		Thread thread = new Thread(animation);
		thread.start();
		
	}

	@Override
	public void paint(Graphics g) {

		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 720, 320);
		g.drawImage(images[index], xpos, 100, this);
		
	}

	@Override
	public void run() {
		
		while (true) {
			try { Thread.sleep(20); } catch (InterruptedException e) { e.printStackTrace(); }
			if (++xpos >= 720) {
				xpos = -w;
			}
			index = ++index % images.length;
			repaint();
		}
		
	}

}














