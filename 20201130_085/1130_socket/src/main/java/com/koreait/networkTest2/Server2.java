package com.koreait.networkTest2;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class Server2 {

	public static void main(String[] args) {
		
		ServerSocket server = null;
		Socket socket = null;
		PrintWriter printWriter = null;
		Scanner scanner = null;				// 클라이언트에서 전송되는 데이터를 읽는 스캐너
		Scanner scan = null;				// 키보드로 클라이언트로 전송할 데이터를 입력받는 스캐너
		
//		ip 주소를 key로 하고 ip를 사용하는 학생 이름을 value로 하는 TreeMap 객체를 만든다.
		TreeMap<String, String> ipTable = new TreeMap<String, String>();
		String[] name = {"신현식", "", "김경준", "김호석", "안진석", "하주영", "조영환", "김종화", "", "이석우", "선대범", "김예지", "김상희",
				"심미현", "김동호", "", "", "", "양대석", "김찬종", "조정석", "", "", "이종원", "허정원", "", "", "김민영", "", "김혜민", "",
				"손설희", "", "김재현", ""};
		for (int i = 0; i < name.length; i++) {
//			System.out.println("192.168.7." + (i + 2));
			if (!name[i].equals("")) {
//				ipTable.put("192.168.7." + String.format("%03d", i + 2), name[i]);
				ipTable.put("192.168.7." + (i + 2), name[i]);
			}
		}
//		for (String key : ipTable.keySet()) {
//			System.out.println(key + " : " + ipTable.get(key));
//		}
		
		try {
			
			server = new ServerSocket(10004);
			System.out.println("서버 시작 : " + server);
			System.out.println("클라이언트의 접속을 기다립니다.");
			socket = server.accept();
			
//			통신에 사용할 나머지 객체를 선언한다.
			printWriter = new PrintWriter(socket.getOutputStream());
			scanner = new Scanner(socket.getInputStream());
			scan = new Scanner(System.in);
			
//			socket.getInetAddress().getHostAddress() : 서버에 접속한 ip 주소를 얻어온다.
//			System.out.println(socket.getInetAddress().getHostAddress() + "님이 접속했습니다.");
			String client = ipTable.get(socket.getInetAddress().getHostAddress());
			System.out.println(client + "(" + socket.getInetAddress().getHostAddress() + ")님이 접속했습니다.");
			
			printWriter.write("어서와 클라이언트\n");
			printWriter.flush();
			
//			키보드로 입력한 메시지 또는 클라이언트에서 전송받은 메시지가 "BYE"면 통신을 끝낸다.
			String msg = "";
			do {
				
//				클라이언트에서 전송받은 메시지를 출력한다.
				msg = scanner.nextLine().trim();
				System.out.println(client + " >> " + msg);
//				클라이언트에서 전송받은 메시지가 "BYE"면 통신을 끝낸다. => do ~ while 반복을 탈출한다.
				if (msg.toUpperCase().equals("BYE")) {
					break;
				}
				
//				클라이언트로 전송할 메시지를 키보드로 입력받는다.
				System.out.print("server >> ");
				msg = scan.nextLine().trim();
//				키보드로 입력한 메시지를 클라이언트로 전송한다.
				printWriter.write(msg + "\n");
				printWriter.flush();
				
//				클라이언트에서 전송받은 메시지가 "BYE"면 통신을 끝낸다. => do ~ while 반복을 중지한다. => while() 에서 조건을 만족하지 않게한다.
			} while(!msg.toUpperCase().equals("BYE"));
			System.out.println("클라이언트와의 채팅을 종료합니다.");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (server != null) { try { server.close(); } catch (IOException e) { e.printStackTrace(); } }
			if (socket != null) { try { socket.close(); } catch (IOException e) { e.printStackTrace(); } }
		}
		
	}
	
}













