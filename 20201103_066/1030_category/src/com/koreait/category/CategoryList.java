package com.koreait.category;

import java.util.ArrayList;

public class CategoryList {

	private ArrayList<CategoryVO> list = new ArrayList<CategoryVO>();		// 브라우저에 출력할 전체 카테고리 목록을 기억한다.

	public ArrayList<CategoryVO> getList() {
		return list;
	}
	public void setList(ArrayList<CategoryVO> list) {
		this.list = list;
	}
	
	@Override
	public String toString() {
		return "CategoryList [list=" + list + "]";
	}
	
}
