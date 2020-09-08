package kr.koreait.layoutTest;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.JLabel;

public class CardLayoutTest2 extends Frame implements Runnable {

	JLabel[] labels = new JLabel[10];
	CardLayout card = new CardLayout();
	
	public CardLayoutTest2() {
		setTitle("CardLayout");
		setBounds(800, 100, 400, 500);
		
		setLayout(card);
		
		for (int i = 0; i < labels.length; i++) {
			labels[i] = new JLabel(9 - i + "");
			labels[i].setOpaque(true);
			labels[i].setHorizontalAlignment(JLabel.CENTER);
			labels[i].setFont(new Font("Dialog", Font.BOLD, 300));
			add(9 - i + "", labels[i]);
		}
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		CardLayoutTest2 window = new CardLayoutTest2();
		Thread thread = new Thread(window);
		thread.start();
		
	}

	@Override
	public void run() {
		
		Random random = new Random();
		while (true) {
			for (int i = 0; i < labels.length; i++) {
				
				try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
				
				int r = random.nextInt(256);
				int g = random.nextInt(256);
				int b = random.nextInt(256);
				labels[i].setBackground(new Color(r, g, b));
				
				labels[i].setForeground(new Color(random.nextInt(16777216)));
				
				card.show(this, 9 - i + "");
				
			}
		}
		
	}
	
}













