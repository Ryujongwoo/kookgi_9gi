package com.koreait.textfileio;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TextFileWriteTest {

	public static void main(String[] args) {
		
		Scanner scanner = null;				// 텍스트 파일로 저장할 데이터를 입력받는 Scanner
		PrintWriter printWriter = null;		// 텍스트 파일에 데이터를 저장하는 PrintWriter
		
//		출력 파일의 경로와 이름을 설정한다.
//		경로 지정 방식은 절대 경로 지정 방식과 상대 경로 지정 방식이 있다.
//		절대 경로는 파일이 위치한 디스크 드라이브의 최상위(root) 디렉토리(폴더) 부터 파일이 위치한 디렉토리 까지의 경로를 의미한다.
//		상대 경로는 현재 작업중인 파일이 포함된 프로젝트 이름의 디렉토리(".") 부터 파일이 위치한 디렉토리 까지의 경로를 의미한다.
//		python 이나 c/c++의 "."은 화면에 열려있는 파일이 위치한 디렉토리를 의미하지만 java에서 "."은 현재 작업중인 파일이 포함된 프로젝트
//		이름의 디렉토리를 의미한다.
//		경로 지정시 경로와 경로 또는 경로와 파일을 구분하는 "\"는 연달아 2개를 써야 하나로 인식되며 "\\"를 "/"로 대체해서 사용할 수 있다.
//		이클립스 버전이 올라가면서 경로를 복사해 붙이면 자동으로 "\"가 "\\"로 입력된다.
		
//		String filename = "D:\\kookgi_9gi\\JAVA\\workspace\\0825\\src\\com\\koreit\\textfileio\\out.txt";	// 절대 경로
//		String filename = "D:/kookgi_9gi/JAVA/workspace/0825/src/com/koreit/textfileio/out.txt";			// 절대 경로
		String filename = "./src/com/koreit/textfileio/out.txt";											// 상대 경로
		
		try {
//			PrintWriter 클래스 객체를 생성해서 출력으로 사용할 파일을 지정된 경로에 생성하고 open 한다.
			printWriter = new PrintWriter(filename);
			scanner = new Scanner(System.in);
			
//			"QUIT"가 입력될 때 까지 반복하며 키보드로 입력받은 데이터를 텍스트 파일에 저장한다.
			while (true) {
				System.out.print(">>> ");
				String str = scanner.nextLine().trim();
				if (str.toUpperCase().equals("QUIT")) {
					break;
				}
				if (str.length() != 0) {
//					write() 메소드를 사용해서 PrintWriter 클래스 객체로 생성한 파일로 출력한다.
//					\n : new line, 줄을 바꾼다.
//					\r : carriage return, 커서를 줄의 맨 앞으로 보낸다.
//					이클립스 2019-12 버전까지는 "\n"만 사용하면 텍스트 파일에 줄이 변경되지 않았었다.
//					"\r\n" 순서로 써야했고 "\n\r"로 쓰면 음표 모양의 특수 문자가 보였었다.
					printWriter.write(str + "\r\n");
				}
			}
			System.out.println("저장 완료!!!");
		} catch (FileNotFoundException e) {
			System.out.println("파일이 없습니다.");
		} finally {
//			출력 용도로 사용하는 파일은 출력 작업이 완료되면 반드시 파일을 닫아야 정상적으로 저장된다.
			if (printWriter != null) {
				printWriter.close();
			}
		}
		
	}
	
}













