package com.koreait.memoList;

import java.util.ArrayList;

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
	
//	MemoProject 클래스에서 호출되는 수정 또는 삭제할 글번호를 넘겨받고 memoList ArrayList에 저장된 글 중에서 글번호에 해당되는 
//	글 1건을 리턴하는 메소드
	public MemoVO selectMemo(int idx) {
		try {
			return memoList.get(idx - 1);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}
	
//	MemoProject 클래스에서 호출되는 삭제할 글번호를 넘겨받고 memoList ArrayList에 저장된 글 중에서 글번호에 해당되는 글 1건을 
//	삭제하는 메소드
	public void delete(int idx) {
		memoList.remove(idx - 1);
//		글 삭제 후 글번호를 다시 붙여준다. => ArrayList를 사용하기 때문에 이런 현상이 발생된다.
		for (int i = 0; i < memoList.size(); i++) {
			memoList.get(i).setIdx(i + 1);
		}
//		글이 삭제된 후 새 글이 입력될 때 idx가 자동으로 1씩 증가되게 하기 위해서 1씩 증가하는 정적변수 count의 값을 수정한다.
		MemoVO.count = memoList.size();
	}
	
//	MemoProject 클래스에서 호출되는 수정할 글번호와 수정할 메모를 넘겨받고 memoList ArrayList에 저장된 글 중에서 글번호에 
//	해당되는 글 1건을 수정하는 메소드
	public void update(int idx, String memo) {
		memoList.get(idx - 1).setMemo(memo);
	}
	
}


















