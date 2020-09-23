package com.koreait.onLinePoll;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class PollWrite {
	
//	텍스트 파일을 저장할 경로와 이름, 텍스트 파일에 저장할 투표 결과가 기억된 ArrayList를 넘겨받아 텍스트 파일에 저장하는 메소드
	public static void pollWrite(String filepath, ArrayList<String> poll) {
		
//		ArrayList에 저장된 데이터를 텍스트 파일로 출력할 PrintWriter 객체를 선언한다.
		PrintWriter printWriter = null;
		
		try {
//			ArrayList에 저장된 데이터를 텍스트 파일로 출력할 PrintWriter 객체를 생성한다.
			printWriter = new PrintWriter(filepath);
			
//			ArrayList에 저장된 데이터 데이터의 개수 만큼 반복하며 ArrayList에 저장된 데이터를 텍스트 파일에 출력한다.
			for (String str : poll) {
				printWriter.write(str + "\r\n");
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("디스크에 파일이 존재하지 않습니다.");
		} finally {
//			텍스트 파일로 출력에 사용한 객체를 닫는다. => 출력 객체를 닫지 않으면 파일로 출력한 데이터가 저장되지 않는다.
			if (printWriter != null) {
				printWriter.close();
			}
		}
		
	}

}





