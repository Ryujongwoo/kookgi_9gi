package com.koreait.memoList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class MemoList {

	private ArrayList<MemoVO> memoList = new ArrayList<MemoVO>();

	public ArrayList<MemoVO> getMemoList() {
		return memoList;
	}
	public void setMemoList(ArrayList<MemoVO> memoList) {
		this.memoList = memoList;
	}
	
	@Override
	public String toString() {
//		마지막에 입력된 글(최신글) 부터 출력하기 위해 ArrayList에 저장된 마지막 글 부터 출력한다.
		String str = "";
				
//		memoList라는 ArrayList에 저장된 메모가 없으면 없다는 메시지를 출력하고 저장된 메모가 있으면 저장된 메모를 출력한다.
		if (memoList.size() == 0) {
			str += "저장된 메모가 없습니다.";
		} else {
			for (int i = memoList.size() - 1; i >= 0; i--) {
				str += memoList.get(i) + "\n";
			}
		}
		
		return str;
	}
	
//	MemoProject 클래스에서 호출되는 memoList ArrayList에 저장할 데이터가 저장된 MemoVO 클래스 객체를 넘겨받고 memoList ArrayList에 저장하는
//	메소드
	public void addMemo(MemoVO vo) {
		memoList.add(vo);
	}
	
//	MemoProject 클래스에서 호출되는 수정 또는 삭제할 글번호를 넘겨받고 memoList ArrayList에 저장된 글 중에서 글번호에 해당되는 글 1건을 
//	리턴하는 메소드
	public MemoVO selectMemo(int idx) {
		try {
			return memoList.get(idx - 1);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}
	
//	MemoProject 클래스에서 호출되는 삭제할 글번호를 넘겨받고 memoList ArrayList에 저장된 글 중에서 글번호에 해당되는 글 1건을 삭제하는 메소드
	public void delete(int idx) {
		memoList.remove(idx - 1);
//		글 삭제 후 글번호를 다시 붙여준다. => ArrayList를 사용하기 때문에 이런 현상이 발생된다.
		for (int i = 0; i < memoList.size(); i++) {
			memoList.get(i).setIdx(i + 1);
		}
//		글이 삭제된 후 새 글이 입력될 때 idx가 자동으로 1씩 증가되게 하기 위해서 1씩 증가하는 정적변수 count의 값을 수정한다.
		MemoVO.count = memoList.size();
	}
	
//	MemoProject 클래스에서 호출되는 수정할 글번호와 수정할 메모를 넘겨받고 memoList ArrayList에 저장된 글 중에서 글번호에 해당되는 글 1건을
//	수정하는 메소드
	public void update(int idx, String memo) {
		memoList.get(idx - 1).setMemo(memo);
	}
	
//	MemoProject 클래스에서 텍스트 파일의 이름을 넘겨받아 memoList ArrayList에 저장된 데이터를 텍스트 파일로 출력하는 메소드
	public void fileWrite(String filename) {
		PrintWriter printWriter = null;
		try {
			String filePath = "./src/com/koreait/memoList/" + filename + ".txt";
//			System.out.println(filePath);
			printWriter = new PrintWriter(filePath);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
//			memoList ArrayList에 저장된 데이터 개수만큼 반복하며 ArrayList에 저장된 데이터를 텍스트 파일에 출력한다.
			for (MemoVO vo : memoList) {
				/*
				String str = "";
				str += vo.getIdx() + " ";
//				replace(old, new) : 문자열의 모든 old를 new로 치환한다.
				str += vo.getName().replace(" ", "_") + " ";
				str += vo.getPassword() + " ";
				str += vo.getMemo().replace(" ", "_") + " ";
				str += sdf.format(vo.getWriteDate());
				*/
				String str = String.format("%s %s %s %s %s", vo.getIdx(), vo.getName().replace(" ", "_"), vo.getPassword(),
						vo.getMemo().replace(" ", "_"), sdf.format(vo.getWriteDate()));
				printWriter.write(str + "\r\n");
			}
			
		} catch (Exception e) {
			System.out.println("파일의 경로 또는 이름이 올바르지 않습니다.");
			e.printStackTrace();
		} finally {
			if (printWriter != null) {
				printWriter.close();
			}
		}
	}
	
//	MemoProject 클래스에서 텍스트 파일의 이름을 넘겨받아 텍스트 파일의 데이터를 읽어 memoList ArrayList에 저장하는 메소드
	public void fileRead(String filename) {
		Scanner scanner = null;
		try {
			String filePath = String.format("./src/com/koreait/memoList/%s.txt", filename);
			scanner = new Scanner(new File(filePath));
			
//			텍스트 파일에 저장된 데이터를 마지막 줄 까지 읽어서 memoList ArrayList에 저장한다.
			while (scanner.hasNextLine()) {
				String str = scanner.nextLine().trim();
//				System.out.println(str);
				
//				텍스트 파일에서 읽은 한 줄(str)에서 공백으로 구분된 데이터를 읽어들이는 Scanner를 만든다.
				Scanner scan = new Scanner(str);
//				String 변수에서 읽어들인 데이터를 각각의 변수에 저장한다.
				int idx = scan.nextInt();
				String name = scan.next().replace("_", " ");
				String password = scan.next();
				String memo = scan.next().replace("_", " ");
				String writeDate = scan.nextLine().trim();
				
				/*
//				memoList ArrayList에 저장하기 위해서 String 변수에서 읽어서 각각의 변수에 저장한 데이터로 MemoVO 클래스 객체를 생성한다.
				MemoVO vo = new MemoVO();
				vo.setIdx(idx);
				vo.setName(name);
				vo.setPassword(password);
				vo.setMemo(memo);
//				작성일은 Date 클래스 타입이므로 String 변수 writeDate에 읽어들인 문자열을 substring() 메소드를 사용해서 년, 월, 일, 시, 분, 초로
//				분리한 후 날짜 데이터를 만들어서 저장해야 한다.
				int year = Integer.parseInt(writeDate.substring(0, 4)) - 1900;
				int month = Integer.parseInt(writeDate.substring(5, 7)) - 1;
				int day = Integer.parseInt(writeDate.substring(8, 10));
				int hour = Integer.parseInt(writeDate.substring(11, 13));
				int minute = Integer.parseInt(writeDate.substring(14, 16));
				int second = Integer.parseInt(writeDate.substring(17));
				Date date = new Date(year, month, day, hour, minute, second);
				vo.setWriteDate(date);
				*/
				
//				VO 클래스 객체에 저장된 데이터를 memoList ArrayList에 저장한다.
				MemoVO vo = new MemoVO(idx, name, password, memo, writeDate);
				memoList.add(vo);
			}
			
		} catch (Exception e) {
			System.out.println("파일의 경로 또는 이름이 올바르지 않습니다.");
			e.printStackTrace();
		}
		
		
	}
	
}


















