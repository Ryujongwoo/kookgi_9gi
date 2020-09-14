package kr.koreait.listenerTest;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MouseMotionListenerTest4 extends JPanel implements Runnable {

	int xpos = 50, ypos = 50;
	static int xbar = 175;
	
	public static void main(String[] args) {
		
		JFrame window = new JFrame("MouseMotionListener");
		window.setBounds(1000, 100, 500, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MouseMotionListenerTest4 graphic = new MouseMotionListenerTest4();
		window.add(graphic);
		
		graphic.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				
				xbar = e.getX() - 75;
				xbar = xbar < 0 ? 0 : xbar;
				xbar = xbar > 335 ? 335 : xbar;
				
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
			try { Thread.sleep(10); } catch (InterruptedException e) { e.printStackTrace(); }
			repaint();
		}
		
		JOptionPane.showMessageDialog(null, "Game Over!!!");
		System.exit(0);
		
	}

}

















