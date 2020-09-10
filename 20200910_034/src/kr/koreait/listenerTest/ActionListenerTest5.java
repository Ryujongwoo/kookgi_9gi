package kr.koreait.listenerTest;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ActionListenerTest5 extends JFrame {

	JButton button = new JButton("시작");
	JPanel panel = new JPanel();
	boolean flag = true;
	
	public ActionListenerTest5() {
		setTitle("ActionListener");
		setBounds(1000, 100, 600, 400);
		
		setLayout(new GridLayout(2, 1));
		add(button);
		panel.setBackground(Color.BLUE);
		add(panel);
		
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
//				컨테이너에 올려준 기존의 컴포넌트를 모두 제거하고 다시 추가한다.
				remove(button);
				remove(panel);
				
				if (flag) {
					add(panel);
					add(button);
				} else {
					add(button);
					add(panel);
				}
				flag = !flag;
			
//				컨테이너에 배치된 컴포넌트의 위치가 변경되거나 교체되면 반드시 revalidate() 메소드를 실행해서 변경된 컴포넌트의
//				좌표를 다시 계산해야 한다.
				revalidate();
				
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		ActionListenerTest5 window = new ActionListenerTest5();
		
	}

}

















