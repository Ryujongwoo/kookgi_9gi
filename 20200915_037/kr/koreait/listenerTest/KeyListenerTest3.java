package kr.koreait.listenerTest;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class KeyListenerTest3 extends Panel implements Runnable {

	static final int SPEED = 10;
	static int xpos = 0, ypos = 0, position = 0;
	int angle = 0;
	
	public static void main(String[] args) {
		
		Frame window = new Frame("Graphic");
		window.setBounds(1100, 100, 500, 600);
		window.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		KeyListenerTest3 graphic = new KeyListenerTest3();
		window.add(graphic);
		window.setVisible(true);
		
		window.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
					case KeyEvent.VK_LEFT: case KeyEvent.VK_A:
						xpos = (xpos -= SPEED) < 0 ? 0 : xpos;
						position = 180;
						break;
					case KeyEvent.VK_UP: case KeyEvent.VK_W:
						ypos = (ypos -= SPEED) < 10 ? 10 : ypos;
						position = 90;
						break;
					case KeyEvent.VK_RIGHT: case KeyEvent.VK_D:
						xpos = (xpos += SPEED) > 380 ? 380 : xpos;
						position = 0;
						break;
					case KeyEvent.VK_DOWN: case KeyEvent.VK_S:
						ypos = (ypos += SPEED) > 465 ? 465 : ypos;
						position = 270;
						break;
				}
			}
		});
		
		Thread thread = new Thread(graphic);
		thread.start();
		
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.ORANGE);
		g.fillArc(xpos, ypos, 100, 100, position + angle, 360 - angle * 2);
	}

	@Override
	public void run() {
		
		int asw = 1;
		while (true) {
			angle += asw;
			if (angle > 45 || angle < 0) {
				asw *= -1;
			}
			try { Thread.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }
			repaint();
		}
		
	}
	
}














