package com.koreait.onLinePoll;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PollRead {

//	텍스트 파일이 저장된 경로와 이름을 넘겨받아 텍스트 파일에 저장된 데이터를 읽어서 ArrayList에 저장시킨 후 리턴하는 메소드
	public static ArrayList<String> pollRead(String filepath) {
		
//		읽어들인 텍스트 파일의 데이터를 저장해 리턴시킬 ArrayList를 선언한다.
		ArrayList<String> poll = null;
//		텍스트 파일의 데이터를 읽어들일 스캐너를 선언한다.
		Scanner scanner = null;
		
		try {
//			텍스트 파일에서 데이터를 읽어들일 스캐너 객체를 만든다.
			scanner = new Scanner(new File(filepath));
//			스캐너로 읽어들일 텍스트 파일의 객체가 정상적으로 생성되면 데이터를 저장해 리턴시킬 ArrayList 객체를 생성한다.
			poll = new ArrayList<String>();
			
//			텍스트 파일의 끝까지 반복하며 데이터를 읽어 ArrayList에 저장한다.
//			hasNextLine() : 스캐너로 다음에 읽어들일 줄이 있으면 true, 없으면 false를 리턴한다.
			while (scanner.hasNextLine()) {
				String str = scanner.nextLine().trim();
				if (str.length() > 0) {
					poll.add(str);
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("디스크에 파일이 존재하지 않습니다.");
		}
		
//		텍스트 파일에서 읽어들인 데이터가 저장된 ArrayList를 리턴시킨다.
		return poll;
		
	}
	
}






