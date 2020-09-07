package kr.koreait.windowTest;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class WindowTest7 extends JFrame implements Runnable {

	int xpos = 0;
	Dimension dimension, dimension2;
	
	public WindowTest7() {
		this("제목 없는 생성자");
	}
	public WindowTest7(String title) {
		setTitle(title);
		setBounds(xpos, 0, 400, 300);
		
		dimension = Toolkit.getDefaultToolkit().getScreenSize();
		dimension2 = getSize();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		WindowTest7 window = new WindowTest7();
		Thread thread = new Thread(window);
		thread.start();
		
	}
	
	@Override
	public void run() {
		
		while (true) {
			
			if (++xpos > dimension.width - dimension2.width) {
//				break;
				xpos = 0;
			}
			
			setLocation(xpos, 0);
			try { Thread.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
		}
		
	}
	
}







