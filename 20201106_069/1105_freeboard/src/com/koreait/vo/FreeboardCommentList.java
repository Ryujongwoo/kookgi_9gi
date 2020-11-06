package com.koreait.vo;

import java.util.ArrayList;

public class FreeboardCommentList {

	private ArrayList<FreeboardCommentVO> list = new ArrayList<FreeboardCommentVO>();

	public ArrayList<FreeboardCommentVO> getList() {
		return list;
	}
	public void setList(ArrayList<FreeboardCommentVO> list) {
		this.list = list;
	}
	
	@Override
	public String toString() {
		return "FreeboardCommentList [list=" + list + "]";
	}
	
}
