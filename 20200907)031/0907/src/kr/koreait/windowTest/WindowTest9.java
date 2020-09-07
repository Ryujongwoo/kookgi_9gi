package kr.koreait.windowTest;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class WindowTest9 extends JFrame implements Runnable {

	int xpos = 0, ypos = 0;
	Dimension dimension, dimension2;
	
	public WindowTest9() {
		this("제목 없는 생성자");
	}
	public WindowTest9(String title) {
		setTitle(title);
		setBounds(xpos, ypos, 400, 300);
		
		dimension = Toolkit.getDefaultToolkit().getScreenSize();
		dimension2 = getSize();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		WindowTest9 window = new WindowTest9();
		Thread thread = new Thread(window);
		thread.start();
		
	}
	
	@Override
	public void run() {
		
		int xsw = 1, ysw = 1;
		boolean flag = true;
		while (true) {
			
			dimension2 = getSize();
			if (flag) {
				xpos += xsw;
				if (xpos > dimension.width - dimension2.width || xpos <= 0) {
					xsw *= -1;
					flag = false;
				}
			} else {
				ypos += ysw;
				if (ypos > dimension.height - dimension2.height || ypos <= 0) { 
					ysw *= -1;
					flag = true;
				}
			}
			
			setLocation(xpos, ypos);
			try { Thread.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
		}
		
	}
	
}







