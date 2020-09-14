package kr.koreait.listenerTest;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class MouseMotionListenerTest2 extends Panel {

	static int xpos = 50, ypos = 50;
	
	public static void main(String[] args) {
		
		JFrame window = new JFrame("MouseMotionListener");
		window.setBounds(1000, 100, 500, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MouseMotionListenerTest2 graphic = new MouseMotionListenerTest2();
		window.add(graphic);
		
		graphic.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				xpos = e.getX() - 15;
				ypos = e.getY() - 15;
				graphic.repaint();
			}
		});
		
		window.setVisible(true);
		
	}

	@Override
	public void paint(Graphics g) {
		
		g.setColor(Color.RED);
		g.fillOval(xpos, ypos, 30, 30);
		
	}

}

















