package kr.koreait.windowTest;

import java.text.SimpleDateFormat;

import javax.swing.JFrame;

public class WindowTest5 extends JFrame implements Runnable {

	public WindowTest5() {
		this("제목 없는 생성자");
	}
	public WindowTest5(String title) {
		setTitle(title);
		setBounds(800, 100, 400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		WindowTest5 window = new WindowTest5();
		Thread thread = new Thread(window);
		thread.start();
		
	}
	
	@Override
	public void run() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
		while (true) {
			setTitle(sdf.format(System.currentTimeMillis()));
			try { Thread.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
		}
		
	}
	
}







