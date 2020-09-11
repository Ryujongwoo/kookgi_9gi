package kr.koreait.listenerTest;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MouseListenerTest extends JFrame {

	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	
	public MouseListenerTest() {
		setTitle("MouseListener");
		setBounds(1000, 100, 400, 600);
		
		setLayout(new GridLayout(2, 1));
		add(panel1);
		panel2.setBackground(Color.ORANGE);
		add(panel2);
		
		panel2.addMouseListener(new MouseListener() {
//			mouseReleased() 메소드가 mouseClicked() 메소드 보다 먼저 실행된다.
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("MouseListener가 지정된 영역에서 마우스 버튼에서 손가락을 뗄 때");
				panel1.setBackground(Color.MAGENTA);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("MouseListener가 지정된 영역에서 마우스 버튼을 누르고 있을 때");
				panel1.setBackground(Color.CYAN);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("MouseListener가 지정된 영역에서 마우스 포인터가 사라질 때");
				panel1.setBackground(Color.RED);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("MouseListener가 지정된 영역으로 마우스 포인터가 올라갈 때");
				panel1.setBackground(Color.BLUE);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("MouseListener가 지정된 영역에서 마우스 버튼이 클릭될 때");
				panel1.setBackground(Color.YELLOW);
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		MouseListenerTest window = new MouseListenerTest();
		
	}

}

















