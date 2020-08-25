package com.koreait.memoList;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MemoVO {

	public static int count;
	private int idx;			// 글번호, 자동증가
	private String name;		// 이름
	private String password;	// 비밀번호
	private String memo;		// 메모
	private Date writeDate;		// 작성일, 현재 날짜 자동입력
	
	public MemoVO() { }
	public MemoVO(String name, String password, String memo) {
		super();
		idx = ++count;
		this.name = name;
		this.password = password;
		this.memo = memo;
		writeDate = new Date();
	}
	
	public MemoVO(int idx, String name, String password, String memo, String writeDate) {
		this.idx = idx;
		this.name = name;
		this.password = password;
		this.memo = memo;
		int year = Integer.parseInt(writeDate.substring(0, 4)) - 1900;
		int month = Integer.parseInt(writeDate.substring(5, 7)) - 1;
		int day = Integer.parseInt(writeDate.substring(8, 10));
		int hour = Integer.parseInt(writeDate.substring(11, 13));
		int minute = Integer.parseInt(writeDate.substring(14, 16));
		int second = Integer.parseInt(writeDate.substring(17));
		Date date = new Date(year, month, day, hour, minute, second);
		this.writeDate = date;
	}
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	
	@Override
	public String toString() {
//		오늘 입력된 글은 시간만 표시하고 어제 이전에 입력된 글은 날짜만 표시한다.
		Date date = new Date();		// 오늘
		SimpleDateFormat sdf = null;
//		오늘 작성된 글인가 비교한다.
		if (date.getYear() == writeDate.getYear() && date.getMonth() == writeDate.getMonth() && date.getDate() == writeDate.getDate()) {
			sdf = new SimpleDateFormat("HH:mm:ss");
		} else {
			sdf = new SimpleDateFormat("yyyy.MM.dd(E)");
		}
		return idx + ". " + name + "(" + password + ")님이 " + sdf.format(writeDate) + "에 남긴글\n" + memo;
	}
	
}








