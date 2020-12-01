package com.koreait.networkTest;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		
		Socket socket = null;				// 통신 소켓
		Scanner scanner = null;				// 서버에서 전송되는 데이터를 읽는 스캐너
		PrintWriter printWriter = null;		// 서버로 데이터를 전송하는 PrintWriter

		try {
//			서버에 접속한다.
			System.out.println("192.168.7.254 서버의 100004번 포트로 접속 시도");
//			new Socket(host, port) : host => 서버의 ip주소, port => 서버의 post 번호
			socket = new Socket("192.168.7.254", 10004);
			System.out.println("서버에 접속 성공 : " + socket);
			
//			서버에서 전송되는 데이터를 수신하기 위해 수신용 객체를 선언한다.
			scanner = new Scanner(socket.getInputStream());
//			서버에서 전송된 데이터를 읽어 출력한다.
			System.out.println(scanner.nextLine());
			
//			클라이언트에서 서버로 데이터를 전송하기 위해서 전송용 객체를 생성한다.
			printWriter = new PrintWriter(socket.getOutputStream());
//			클라이언트에서 서버로 메시지를 전송한다. => 반드시 끝에 개행 문자("\n")를 붙여준다.
			printWriter.write("어련히 알아서 올까봐~~~~~ 기다리고 그러셔~~~~~\n");
//			flush() : 출력 버퍼가 가득 차지 않았더라도 데이터를 전송한다.
			printWriter.flush();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
//			통신이 종료되면 통신에 상요한 모든 객체를 닫는다.
			if (socket != null) { try { socket.close(); } catch (IOException e) { e.printStackTrace(); } }
		}
		
	}
	
}








