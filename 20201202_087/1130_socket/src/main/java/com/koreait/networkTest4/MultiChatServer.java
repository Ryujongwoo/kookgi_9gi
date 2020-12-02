package com.koreait.networkTest4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiChatServer {

	public static void main(String[] args) {
		
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket(10004);
			System.out.println("서버가 시작되었습니다.");
			
//			서버가 실행중인 상태에서 서버에 접속하는 모든 클라이언트들의 접속을 받아야 하므로 무한 루프를 돌린다.
			while (true) {
				
//				클라이언트가 접속될 때 마다 독립된 통신 소켓 객체를 생성한다.
				Socket socket = serverSocket.accept();
				
//				서버에서는 클라이언트 접속만 받아주고 실제 특정 클라이언트에서 전송받은 메시지를 모든 클라이언트로 전송하는 작업은 스레드로
//				처리한다. => 클라이언트가 서버에 접속될 때 마다 스레드가 1개씩 생성된다.
//				스레드를 실행할 때 클라이언트가 접속할 때 마다 생성되는 통신 소켓을 인수로 넘겨 처리한다.
				Thread thread = new MultiChatThread(socket);
				thread.start();
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (serverSocket != null) { try { serverSocket.close(); } catch (IOException e) { e.printStackTrace(); } }
		}
		
	}
	
}










