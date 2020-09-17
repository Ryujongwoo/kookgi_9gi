package kr.koreait.memoProjectDB;

import java.util.Scanner;

public class MemoProject {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int menu = 0;
		while (menu != 5) {
			do {
				System.out.println("=================================================");
				System.out.println(" 1. 입력  2. 목록보기  3. 수정  4. 삭제  5. 종료 ");
				System.out.println("=================================================");
				System.out.print("원하는 메뉴를 선택하세요 : ");
				menu = scanner.nextInt();
			} while(menu < 1 || menu > 5);
			
			switch (menu) {
				case 1:
					insert();
					break;
				case 2:
					System.out.println("목록보기");
					break;
				case 3:
					System.out.println("수정");
					break;
				case 4:
					System.out.println("삭제");
					break;
			}
			
		}
		System.out.println("프로그램을 종료합니다. 바이바이~~~~~");
		
	}

//	키보드로 이름, 비밀번호, 메모를 입력받고 테이블에 저장하는 insert sql 명령을 실행하는 MemoDAO 클래스의 메소드를 호출하는 메소드
	private static void insert() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("이름 : ");
		String name = scanner.nextLine();
		System.out.print("비밀번호 : ");
		String password = scanner.nextLine();
		System.out.print("메모 : ");
		String memo = scanner.nextLine();
		
//		입력 받은 데이터를 MemoVO 클래스 객체를 생성하고 저장한다.
		MemoVO vo = new MemoVO();
		vo.setName(name);
		vo.setPassword(password);
		vo.setMemo(memo);
		
//		테이블에 저장할 데이터가 저장된 MemoVO 클래스 객체를 인수로 넘겨 MemoDAO 클래스의 테이블에 데이터를 저장하는 insert sql
//		명령을 실행하는 메소드를 호출한다.
		MemoDAO.insert(vo);
		System.out.println("저장완료!!!");
		
	}
	
}













