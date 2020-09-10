package kr.koreait.listenerTest;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ActionListenerTest4 extends JFrame implements ActionListener, Runnable {

	static ActionListenerTest4 window = null;
	
	JLabel label = new JLabel("00:00:05.000");
	JPanel panel = new JPanel();
	JButton button1 = new JButton("시작");
	JButton button2 = new JButton("일시정지");
	JButton button3 = new JButton("초기화");
	
	long start, stop;
	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
	boolean flag = true;
	
	public ActionListenerTest4() {
		setTitle("ActionListener");
		setBounds(1000, 100, 600, 400);
		
		setLayout(new GridLayout(2, 1));
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setFont(new Font("나눔고딕코딩", Font.BOLD, 70));
		add(label);
		
		panel.setLayout(new GridLayout(1, 3));
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		add(panel);
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		
		button2.setEnabled(false);
		button3.setEnabled(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		window = new ActionListenerTest4();
		
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
//				label.setText("00:00:05.000");
				label.setText(sdf.format(-32395000));
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
		
		if (start == 0) {
			start = System.currentTimeMillis();
			stop = start;
		}
		
		while (true) {
			long time = 5000 - (stop++ - start) - 32400000;
			label.setText(sdf.format(time));
			
			if (time == -32400000) {
//				JOptionPane.showMessageDialog(label, "Game Over!!!");
//				JOptionPane.showConfirmDialog(label, "Continue?", "이어서 하기", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				
//				OptionDialog : 메시지와 메시지에 대한 응답을 하는 버튼을 표시한다.
//				showOptionDialog(parentComponent, message, title, optionType, messageType, icon, options, initialValue)
//				options : 메시지로 표시할 내용을 기억하는 배열
//				initialValue : 메시지 버튼 중에서 기본적으로 선택될 값을 적어준다.
				String[] money = {"100", "200", "300", "400"};
				JOptionPane.showOptionDialog(label, "얼마를 투입하시겠습니까??", "동전 넣기", JOptionPane.YES_NO_OPTION, 
						JOptionPane.QUESTION_MESSAGE, new ImageIcon("./src/images/Duke01.gif"), money, "300");
			}
			
			try { Thread.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
			if (!flag) {
				break;
			}
		}
		
	}
	
}

















