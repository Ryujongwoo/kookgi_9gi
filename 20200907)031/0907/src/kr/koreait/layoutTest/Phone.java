package kr.koreait.layoutTest;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Phone extends JPanel {

	JButton[] buttons = new JButton[12];
	String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "*", "0", "#"};

	public Phone() {
		
		setLayout(new GridLayout(4, 3));
		
		for (int i = 0; i < numbers.length; i++) {
			buttons[i] = new JButton(numbers[i]);
			add(buttons[i]);
			buttons[i].setFont(new Font("Dialog", Font.BOLD, 30));
		}
		
	}
	
}
