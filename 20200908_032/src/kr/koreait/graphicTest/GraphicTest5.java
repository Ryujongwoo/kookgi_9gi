package kr.koreait.graphicTest;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.JPanel;

public class GraphicTest5 extends JPanel implements Runnable {

	int xpos = 50, ypos = 50, xpos2 = 180, ypos2 = 350;
	Dimension dimension = new Dimension(500, 600);
	static Frame window = new Frame("Graphic");
	
	public static void main(String[] args) {
		
		window.setBounds(1100, 100, 500, 600);
		window.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		GraphicTest5 graphic = new GraphicTest5();
		window.add(graphic);
		
		window.setVisible(true);
		
		Thread thread = new Thread(graphic);
		thread.start();
		
	}

	@Override
	public void paint(Graphics g) {
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, dimension.width, dimension.height);
		g.setColor(Color.RED);
		g.fillOval(xpos, ypos, 50, 50);
		g.setColor(Color.BLUE);
		g.fillOval(xpos2, ypos2, 50, 50);
		
	}

	@Override
	public void run() {
		
		int xsw = 1, ysw = 1, xsw2 = -2, ysw2 = -1;
		while (true) {
			
			dimension = window.getSize();
			
//			빨강공
			xpos += xsw;
			if (xpos > dimension.width - 65 || xpos < 0) {
				xsw *= -1;
			}
			ypos += ysw;
			if (ypos > dimension.height - 85 || ypos < 0) {
				ysw *= -1;
			}
			
//			파랑공
			xpos2 += xsw2;
			if (xpos2 > dimension.width - 65 || xpos2 < 0) {
				xsw2 *= -1;
			}
			ypos2 += ysw2;
			if (ypos2 > dimension.height - 85 || ypos2 < 0) {
				ysw2 *= -1;
			}
			
//			충돌감지
			if (Math.abs(xpos - xpos2) <= 40 && Math.abs(ypos - ypos2) <= 40) {
				System.out.println("꽝~~~~~~~~~~~~~~");
				xsw *= -1;
				ysw *= -1;
				xsw2 *= -1;
				ysw2 *= -1;
			}
			
			try { Thread.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }
			repaint();
		}
		
	}

}














