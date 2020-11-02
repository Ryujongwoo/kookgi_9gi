package com.koreait.category;

public class CategoryVO {

	private int idx;			// 카테고리 일련번호
	private String category;	// 카테고리 이름
	private int ref;			// 카테고리 그룹
	private int lev;			// 카테고리 레벨
	private int seq;			// 같은 카테고리 그룹 내부에서 카테고리 출력 순서
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getLev() {
		return lev;
	}
	public void setLev(int lev) {
		this.lev = lev;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	
	@Override
	public String toString() {
		return "CategoryVO [idx=" + idx + ", category=" + category + ", ref=" + ref + ", lev=" + lev + ", seq=" + seq
				+ "]";
	}
	
}
