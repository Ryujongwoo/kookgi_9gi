package com.koreait.textfileio;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextFileReadTest {

	public static void main(String[] args) {
		
		Scanner scanner = null;
		
//		in.txt => 윈도우에서 만든 파일, input.txt => 이클립스에서 만든 파일, out.txt => TextFileWriteTest.java에서 만든 파일
//		java 프로그램을 실행해 생성한 텍스트 파일이나 이클립스에서 만든 텍스트 파일은 잘 읽어오지만 윈도우에서 생성한 텍스트 파일을 읽어오지
//		못하는 경우 메모장으로 파일을 열고 파일 메뉴 => 다른 이름으로 저장을 클릭하고 인코딩을 ANSi => UTF-8로 변경한다.		
//		입력 파일의 경로와 이름을 설정한다.
		String filename = "./src/com/koreit/textfileio/input.txt";
		
		try {
//			Scanner 클래스 생성자의 인수로 문자열 변수를 넘겨주면 문자열 변수에 저장된 문자열을 읽어들이는 Scanner가 된다.
//			scanner = new Scanner(filename);
//			System.out.println(scanner.nextLine());
			
//			Scanner 클래스 객체를 생성해서 지정된 경로의 입력으로 사용할 파일을 open 한다.
//			Scanner로 텍스트 파일의 데이터를 읽어오려면 Scanner 클래스 생성자의 인수로 파일의 경로와 이름을 사용해서 File 클래스 객체를
//			생성해서 넘겨줘야 한다.
			scanner = new Scanner(new File(filename));
			
//			텍스트 파일에서 더 이상 읽을 데이터(줄)가 없을 때 까지 반복하며 읽어들인다.
//			hasNextLine() : Scanner로 지정된 파일에서 읽어들일 데이터(줄)가 있으면 true, 없으면 false를 리턴한다.
			while (scanner.hasNextLine()) { // 파일에서 읽을 데이터(줄)가 있는가?
				String str = scanner.nextLine().trim();
//				인코딩을 ANSi에서 UTF-8로 변경한 후 읽었을 때 첫 줄에 이상한 문자가 나오거나 빈 줄이 나오면 첫 줄을 읽어서 버리면 된다.
//				System.out.println(str);
				
//				String 변수에 저장된 문자열 데이터를 읽어들이는 Scanner
				Scanner scan = new Scanner(str);
//				hasNext() : Scanner로 지정된 String 변수에 저장된 변수에서 공백으로 구분된 읽어들일 데이터가 있으면 true, 없으면 false를
//				리턴한다.
//				String 변수에서 더 이상 읽을 데이터(공백으로 구분된)가 없을 때 까지 반복하며 읽어들인다.
				
				int i = 0;
				boolean b = false;
				double d = 0;
				String s = "";
				
				while (scan.hasNext()) {					// String 변수에서 읽어들일 다음 데이터가 있는가?
//					System.out.println(scan.next());
					if (scan.hasNextInt()) {				// 읽어들일 데이터가 정수인가?
						i = scan.nextInt();
					} else if (scan.hasNextBoolean()) {		// 읽어들일 데이터가 논리값인가?
						b = scan.nextBoolean();
					} else if (scan.hasNextDouble()) {		// 읽어들일 데이터가 실수인가?
						d = scan.nextDouble();
					} else {
						s = scan.next();
					}
				}
				
				System.out.println("i = " + i);
				System.out.println("b = " + b);
				System.out.println("d = " + d);
				System.out.println("s = " + s);
				System.out.println("==================================");
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("파일이 없습니다.");
		}
		
	}
	
}










