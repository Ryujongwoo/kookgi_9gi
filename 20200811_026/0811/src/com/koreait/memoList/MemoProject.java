package com.koreait.memoList;

import java.util.Scanner;

public class MemoProject {

	private static MemoList memoList = new MemoList();
	
	public static void main(String[] args) {
		
//		MemoVO memo = new MemoVO("홍길동", "1111", "1등 입니다.");
//		System.out.println(memo);
		
		Scanner scanner = new Scanner(System.in);
		int menu = 0;
		
		while (menu != 7) {
			do {
				System.out.println("============================================================================");
				System.out.println(" 1.입력  2.목록보기  3.수정  4.삭제  5.파일로 저장  6.파일에서 읽기  7.종료 ");
				System.out.println("============================================================================");
				System.out.print("원하는 메뉴를 선택하세요 : ");
				menu = scanner.nextInt();
			} while (menu < 1 || menu > 7);
			
			switch (menu) {
				case 1: insert(); break;
				case 2: select(); break;
				case 3: update(); break;
				case 4: delete(); break;
				case 5:
					System.out.println("파일로 저장");
					break;
				case 6:
					System.out.println("파일에서 읽기");
					break;
			}
			
		}
		System.out.println("프로그램을 종료합니다.");
		
	}

//	키보드로 수정할 글번호를 입력받아 수정할 글 1건을 화면에 표시하고 비밀번호를 입력받아 memoList ArrayList 저장된 글 1건을
//	수정한다.
	private static void update() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("수정할 글번호를 입력하세요 : ");
		int idx = scanner.nextInt();
		MemoVO original = memoList.selectMemo(idx);
		if (original == null) {
			System.out.println(idx + "번 글이 존재하지 않습니다.");
		} else {
			System.out.println(original);
//			수정할 글의 비밀번호를 입력받는다.
			System.out.print("수정할 글의 비밀번호를 입력하세요 : ");
			scanner.nextLine();
			String password = scanner.nextLine().trim();
			
//			글을 수정하기 위해 입력한 비밀번호(password)와 수정할 글의 비밀번호(original.getPassword())가 일치하면 글을 수정하고 
//			일치하지 않으면 비밀번호가 일치하지 않다는 메시지를 출력한다.
			if(password.equals(original.getPassword())) {
//				비밀번호가 일치하므로 수정할 메모를 입력받는다.
				System.out.print("수정할 메모를 입력하세요 : ");
				String memo = scanner.nextLine().trim();
				
//				비밀번호가 일치하므로 MemoList 클래스의 memoList ArrayList에 저장된 글을 수정하는 메소드를 실행한다.
				memoList.update(idx, memo);
				System.out.println(idx + "번 글 수정완료!!!");
			} else {
//				비밀번호가 일치하지 않기 때문에 비밀번호가 일치하지 않다는 메시지를 출력한다.
				System.out.println("비밀번호가 일치하지 않습니다.");
			}

		}
	}

//	키보드로 삭제할 글번호를 입력받아 삭제할 글 1건을 화면에 표시하고 비밀번호를 입력받아 memoList ArrayList 저장된 글 1건을
//	삭제한다.
	private static void delete() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("삭제할 글번호를 입력하세요 : ");
		int idx = scanner.nextInt();
		
//		MemoList 클래스의 memoList ArrayList에 저장된 글 1건을 얻어오는 메소드를 실행한다.
		MemoVO original = memoList.selectMemo(idx);
		
//		삭제할 글번호에 해당되는 글이 존재하면 글을 삭제하고 존재하지 않으면 존재하지 않는다는 메시지를 출력한다.
		if (original == null) {
			System.out.println(idx + "번 글이 존재하지 않습니다.");
		} else {
			System.out.println(original);
			
//			삭제할 글의 비밀번호를 입력받는다.
			System.out.print("삭제할 글의 비밀번호를 입력하세요 : ");
			scanner.nextLine();			// 키보드 버퍼를 비운다.
			String password = scanner.nextLine().trim();
			
//			글을 삭제하기 위해 입력한 비밀번호(password)와 삭제할 글의 비밀번호(original.getPassword())가 일치하면 글을 삭제하고 
//			일치하지 않으면 비밀번호가 일치하지 않다는 메시지를 출력한다.
			if(password.equals(original.getPassword())) {
//				비밀번호가 일치하므로 MemoList 클래스의 memoList ArrayList에 저장된 글을 삭제하는 메소드를 실행한다.
				memoList.delete(idx);
				System.out.println(idx + "번 글 삭제완료!!!");
			} else {
//				비밀번호가 일치하지 않기 때문에 비밀번호가 일치하지 않다는 메시지를 출력한다.
				System.out.println("비밀번호가 일치하지 않습니다.");
			}
		}
		
	}

//	MemoList 클래스의 memoList ArrayList에 저장된 데이터를 출력하는 메소드
	private static void select() {
		System.out.println(memoList);
	}

//	키보드로 이름, 비밀번호, 메모를 입력받아 MemoVO 클래스 객체에 저장한다.
//	MemoVO 클래스 객체를 MemoList 클래스의 memoList ArrayList에 저장하는 메소드를 호출할 때 인수로 전달한다.
	private static void insert() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("게시판에 저장할 글 입력");
		
//		키보드로 이름, 비밀번호, 메모를 입력받는다.
		System.out.print("이름 : ");
		String name = scanner.nextLine().trim();
		System.out.print("비밀번호 : ");
		String password = scanner.nextLine().trim();
		System.out.print("메모 : ");
		String memo = scanner.nextLine().trim();
		
//		MemoVO 클래스의 MemoVO(String name, String password, String memo) 생성자를 실행해서 MemoVO 클래스 객체를 생성한다.
		MemoVO vo = new MemoVO(name, password, memo);
//		System.out.println(vo);
		
//		MemoVo 클래스 객체를 인수로 넘겨받아 MemoList 클래스의 memoList ArrayList에 저장하는 메소드를 실행한다.
		memoList.addMemo(vo);
//		System.out.println(memoList);
		
		System.out.println("저장완료!!!");
	}
	
}











