package kr.koreait.listenerTest;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class KeyListenerTest2 extends JPanel implements Runnable {

	int xpos = 50, ypos = 50;
	static int xbar = 175;
	
	public static void main(String[] args) {
		
		JFrame window = new JFrame("MouseMotionListener");
		window.setBounds(1000, 100, 500, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		KeyListenerTest2 graphic = new KeyListenerTest2();
		window.add(graphic);
		
		graphic.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				
				xbar = e.getX() - 75;
				xbar = xbar < 0 ? 0 : xbar;
				xbar = xbar > 335 ? 335 : xbar;
				
			}
		});
		
		window.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				switch (e.getKeyCode()) {
					case KeyEvent.VK_LEFT: case KeyEvent.VK_A:
//						3항 연산자 보다 대입 연산자의 우선 순위가 낮기 때문에 반드시 ()로 묶어줘야 정상적으로 처리된다.
						xbar = (xbar -= 10) < 0 ? 0 : xbar;
						break;
					case KeyEvent.VK_RIGHT: case KeyEvent.VK_D:
						xbar = (xbar += 10) > 335 ? 335 : xbar;
						break;
				}
				
			}
		});
		
		window.setVisible(true);
		
		Thread thread = new Thread(graphic);
		thread.start();
		
	}

	@Override
	public void paint(Graphics g) {
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 500, 600);
		g.setColor(Color.RED);
		g.fillOval(xpos, ypos, 50, 50);
//		수평 망대를 만든다.
		g.setColor(Color.GREEN);
		g.fillRect(xbar, 520, 150, 20);
		
	}

	@Override
	public void run() {

		int xsw = 1, ysw = 1;
		while (true) {
			xpos += xsw;
			if (xpos > 435 || xpos < 0) {
				xsw *= -1;
			}
			ypos += ysw;
			if ((ypos > 470 && xpos >= xbar && xpos <= xbar + 150) || ypos < 0) {
				ysw *= -1;
			}
			if (ypos >= 500) {
				break;
			}
			try { Thread.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
			repaint();
		}
		
		JOptionPane.showMessageDialog(null, "Game Over!!!");
		System.exit(0);
		
	}

}

















