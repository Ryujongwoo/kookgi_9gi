package kr.koreait.listenerTest;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ActionListenerTest3 extends JFrame implements ActionListener, Runnable {

	static ActionListenerTest3 window = null;
	
	JLabel label = new JLabel("00:00:00.000");
	JPanel panel = new JPanel();					// 버튼 3개가 올라갈 패널
	JButton button1 = new JButton("시작");
	JButton button2 = new JButton("일시정지");
	JButton button3 = new JButton("초기화");
	
	long start, stop;
	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
	boolean flag = true;
	
	public ActionListenerTest3() {
		setTitle("ActionListener");
		setBounds(1000, 100, 600, 400);
		
//		여기 부터
		setLayout(new GridLayout(2, 1));
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setFont(new Font("나눔고딕코딩", Font.BOLD, 70));
		add(label);
		
		panel.setLayout(new GridLayout(1, 3));
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		add(panel);
//		여기 까지 레이아웃 구성
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		
//		스톱워치가 처음 실행되면 시작 버튼만 활성화 시키고 나머지 버튼은 비활성화 시킨다.
		button2.setEnabled(false);
		button3.setEnabled(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		window = new ActionListenerTest3();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch (e.getActionCommand()) {
			case "시작": case "재시작":
				Thread thread = new Thread(window);
				thread.start();
				flag = true;
				button1.setEnabled(false);
				button2.setEnabled(true);
				button3.setEnabled(false);
				break;
			case "일시정지":
				flag = false;
				button1.setEnabled(true);
				button2.setEnabled(false);
				button3.setEnabled(true);
				button1.setText("재시작");
				break;
			case "초기화":
//				label.setText("00:00:00.000");
				label.setText(sdf.format(-32400000));
				start = 0;
				button1.setEnabled(true);
				button2.setEnabled(false);
				button3.setEnabled(false);
				button1.setText("시작");
				break;
		}
		
	}

	@Override
	public void run() {
		
//		스톱워치의 시작 시간을 00:00:00.000으로 만들기 위해서 시작 시간과 종료 시간을 같은 시간으로 설정한다.
		if (start == 0) {
			start = System.currentTimeMillis();
			stop = start;
		}
		
		while (true) {
			long time = stop++ - start - 32400000;
			label.setText(sdf.format(time));
			try { Thread.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
			if (!flag) {
				break;
			}
		}
		
	}
	
}

















