package kr.koreait.graphicTest;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.JPanel;

public class GraphicTest3 extends JPanel implements Runnable {

	int xpos = 50, ypos = 50;
	Color color = new Color(255, 0, 0);
	
	public static void main(String[] args) {
		
		Frame window = new Frame("Graphic");
		window.setBounds(1100, 100, 500, 600);
		window.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		GraphicTest3 graphic = new GraphicTest3();
		window.add(graphic);
		
		window.setVisible(true);
		
		Thread thread = new Thread(graphic);
		thread.start();
		
	}

	@Override
	public void paint(Graphics g) {
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 500, 600);
		g.setColor(color);
		g.fillOval(xpos, ypos, 50, 50);
		
	}

	@Override
	public void run() {
		
		int xsw = 1, ysw = 1;
		while (true) {
			xpos += xsw;
			if (xpos > 435 || xpos < 0) {
				xsw *= -1;
				color = new Color(new Random().nextInt(16777216));
			}
			ypos += ysw;
			if (ypos > 515 || ypos < 0) {
				ysw *= -1;
				color = new Color(new Random().nextInt(16777216));
			}
			try { Thread.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
			repaint();
		}
		
	}
	
}














