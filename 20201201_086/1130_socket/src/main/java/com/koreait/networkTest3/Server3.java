package com.koreait.networkTest3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Server3 extends Frame implements ActionListener, Runnable {

	JTextArea textArea;		// 대화 내용이 출력될 영역
	JPanel panel;			// 대화 내용을 입력하는 텍스트 필드와 전송 버튼이 올라갈 패널
	JTextField textField;	// 대화 내용을 입력하는 텍스트 필드
	JButton button;			// 텍스트 필드에 입력한 대화 내용을 전송하는 버튼
	
	ServerSocket serverSocket;
	Socket socket;
	PrintWriter printWriter;
	Scanner scanner;
	String message = "";	// 서버와 클라이언트의 대화 내용을 저장했다가 대화 내용이 출력되는 텍스트 영역에 뿌려줄 때 사용할 변수
	
	public Server3() {
		setTitle("1:1 채팅 프로그램 - 서버");
		setBounds(100, 50, 500, 700);
		
//		채팅창 만들기
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBackground(Color.orange);
		add(textArea);
		
		panel = new JPanel(new BorderLayout());
		panel.setPreferredSize(new Dimension(500, 40));
		textField = new JTextField();
		panel.add(textField);
		button = new JButton("전송");
		panel.add(button, BorderLayout.EAST);
		add(panel, BorderLayout.SOUTH);
		
//		텍스트 필드와 전송 버튼에 ActionListener를 걸어준다.
		textField.addActionListener(this);
		button.addActionListener(this);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
//				서버 채팅 창이 닫힐 때 클라이언트에게 나간다고 알려준다. => 통신을 종료한다.
				int result = JOptionPane.showConfirmDialog(textArea, "채팅을 종료하겠습니까?", "채팅 종료", JOptionPane.YES_NO_OPTION);
//				System.out.println(result);
				if (result == 0) {
//					서버 채팅 창이 닫힐 때 클라이언트에게 나간다고 알려준다.
					printWriter.write("저 나가요~~~~~ 바이바이~~~~~\n");
					printWriter.write("bye\n");
					printWriter.flush();
//					채팅에 사용한 모든 객체를 닫는다.
					if (serverSocket != null) { try { serverSocket.close(); } catch (IOException e1) { e1.printStackTrace(); } }
					if (socket != null) { try { socket.close(); } catch (IOException e1) { e1.printStackTrace(); } }
					if (printWriter != null) { try { printWriter.close(); } catch (Exception e1) { e1.printStackTrace(); } }
					if (scanner != null) { try { scanner.close(); } catch (Exception e1) { e1.printStackTrace(); } }
//					채팅 창을 닫는다.
					System.exit(0);
				}
			}
		});
		setVisible(true);
	}
	
	public static void main(String[] args) {
		Server3 server = new Server3();
		
		try {
//			서버를 시작한다.
			server.serverSocket = new ServerSocket(10004);
			server.message = "192.168.7.254 서버의 10004번 포트로 서버 시작\n";
			server.message += "클라이언트가 접속하기를 기다립니다.\n";
			server.textArea.setText(server.message);
			
//			클라이언트가 접속하기 전에는 텍스트 필드와 전송 버튼을 비활성화 시킨다.
			server.textField.setEnabled(false);
			server.button.setEnabled(false);
			
//			클라이언트가 접속하기를 기다린다.
			server.socket = server.serverSocket.accept();
			server.message = server.socket + "접속 성공\n" + server.message;
			server.textArea.setText(server.message);
			
//			클라이언트가 접속했으므로 텍스트 필드와 전송 버튼을 비활성화 시키고 메시지를 입력할 수 있도록 텍스트 필드로 포커스를 이동시킨다.
			server.textField.setEnabled(true);
			server.button.setEnabled(true);
			server.textField.requestFocus();
			
//			클라이언트와 메시지를 주고받기 위해서 데이터 전송에 사용할 객체를 생성한다.
			server.printWriter = new PrintWriter(server.socket.getOutputStream());
			server.scanner = new Scanner(server.socket.getInputStream());
			
//			클라이언트에서 전송되는 메시지를 받는 스레드를 실행한다.
			Thread thread = new Thread(server);
			thread.start();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//	클라이언트에서 언제 메시지를 보내올지 모르기 때문에 통신이 종료될 때 까지 반복하며 클라이언트에서 전송되는 메시지를 스레드로 받는다.
	@Override
	public void run() {
//		클라이언트와 통신이 유지되고 있는 동안 반복한다. => 통신 소켓이 null이 아닌 동안 반복한다.
		while (socket != null) {
//			클라이언트에서 전송된 메시지를 받는다.
			String str = "";
			try {
				str = scanner.nextLine().trim();
			} catch (Exception e) {
				break;
			}
//			클라이언트에서 전송된 메시지를 서버 채팅창에 표시한다.
			if (str.length() > 0) {
				message = "client >> " + str + "\n" + message;
				textArea.setText(message);
//				클라이언트에서 "bye"를 전송받으면 채팅을 종료한다.
				if (str.toLowerCase().equals("bye")) {
					break;
				}
			}
			try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
		}
//		클라이언트와 채팅이 종료되면 메시지를 입력할 수 없도록 텍스트 필드와 전송 버튼을 비활성화 시킨다.
		textField.setEnabled(false);
		button.setEnabled(false);
//		채팅에 사용한 모든 객체를 닫는다.
		if (serverSocket != null) { try { serverSocket.close(); } catch (IOException e) { e.printStackTrace(); } }
		if (socket != null) { try { socket.close(); } catch (IOException e) { e.printStackTrace(); } }
		if (printWriter != null) { try { printWriter.close(); } catch (Exception e) { e.printStackTrace(); } }
		if (scanner != null) { try { scanner.close(); } catch (Exception e) { e.printStackTrace(); } }
	}
	
//	텍스트 필드와 전송 버튼에 ActionListener를 걸어서 클라이언트로 데이터를 전송한다.
	@Override
	public void actionPerformed(ActionEvent e) {
//		텍스트 필드에 입력된 메시지를 받는다.
		String str = textField.getText().trim();
//		텍스트 필드에 데이터가 입력된 상태일 경우 메시지를 서버 채팅창에 표시하고 클라이언트로 전송한다.
		if (str.length() > 0) {
//			텍스트 필드에 입력한 메시지를 서버 채팅창에 표시한다.
			message = "server >> " + str + "\n" + message;
			textArea.setText(message);
//			입력한 메시지를 클라이언트로 전송한다.
			if (printWriter != null) {
				printWriter.write(str + "\n");
				printWriter.flush();
			}
		}
//		클라이언트로 메시지를 전송했으면 다음 메시지를 입력받기 위해 텍스트 필드에 입력된 메시지를 지우고 포커스를 옮겨준다.
		textField.setText("");
		textField.requestFocus();
	}
	
}





















