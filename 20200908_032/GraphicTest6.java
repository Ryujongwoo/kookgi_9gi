package kr.koreait.graphicTest;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.JPanel;

public class GraphicTest6 extends JPanel implements Runnable {
	int ballNumber = 100;
	int ballsize = 30;
	int xpos[] = new int[ballNumber];
	int ypos[] = new int[ballNumber];
	Random random = new Random();
	Color color[] = new Color[ballNumber];

	public GraphicTest6() {
		for(int i=0; i < xpos.length; i++) {
			xpos[i] = i * ballsize+5;
			ypos[i] = i * ballsize+5;
			color[i] = new Color(random.nextInt(16777216));
		}
	}
	static Frame window = new Frame("GraphicTest");

	Dimension dimen = new Dimension();
	
	public static void main(String[] args) {
		
		window.setBounds(700, 50, 1000, 1000);
		window.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		GraphicTest6 graphic = new GraphicTest6();
		window.add(graphic);
		window.setVisible(true);
		
		Thread thread = new Thread(graphic);
		thread.start();
		
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, dimen.width, dimen.height);

		for(int i=0; i <xpos.length; i++) {
			g.setColor(color[i]);
			g.fillOval(xpos[i], ypos[i], ballsize, ballsize);
		}
	}
	public void paint1(Graphics g1) {
		
		
	}

	@Override
	public void run() {
			
		int xsw[] = new int[ballNumber]; 
		int ysw[] = new int[ballNumber];
		for(int i=0; i<xpos.length; i++) {
			xsw[i] = new Random().nextInt(3)+1;
			ysw[i] = new Random().nextInt(3)+1;
		}
	
		while(true) {
			dimen = window.getSize();
			for(int i=0; i<xpos.length; i++) {
				xpos[i] += xsw[i];
				if(xpos[i] > dimen.width-ballsize-15 && xsw[i] > 0) {
					xsw[i] *= -1;
					RandomColor(i);
				}
				if(xpos[i] < 0 && xsw[i] < 0) {
					xsw[i] *= -1;
					RandomColor(i);
				}
				ypos[i] += ysw[i];
				if(ypos[i] > dimen.height-ballsize-35 && ysw[i] > 0){
					ysw[i] *= -1;
					RandomColor(i);
				}
				if(ypos[i] < 0 && ysw[i] < 0) {
					ysw[i] *= -1;
					RandomColor(i);
				}
				for(int j=0; j<xpos.length; j++) {
					if(i == j) {
						break;
					}
					if(Math.abs(xpos[i] - xpos[j]) < 30 && Math.abs(ypos[i] - ypos[j]) < 30) {
						if(xpos[i] < xpos[j]) {
							if(xsw[i] > 0) {
								xsw[i] *= -1;
							}
							if(xsw[j] < 0) {
								xsw[j] *= -1;
							}
						}else {
							if(xsw[i] < 0) {
								xsw[i] *= -1;
							}
							if(xsw[j] > 0) {
								xsw[j] *= -1;
							}
						}
						if(ypos[i] < ypos[j]) {
							if(ysw[i] > 0) {
								ysw[i] *= -1;
							}
							if(ysw[j] < 0) {
								ysw[j] *= -1;
							}
						}else {
							if(ysw[i] < 0) {
								ysw[i] *= -1;
							}
							if(ysw[j] > 0) {
								ysw[j] *= -1;
							}
						}
						
					}
				}
				
			}
			try { Thread.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }
			repaint();
		}
		
	}

	private void RandomColor(int i) {
//		color[i] = new Color(random.nextInt(16777216));
	}

	
	
}










