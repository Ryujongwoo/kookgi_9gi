package com.koreait.vo;

import java.util.Date;

public class FreeboardCommentVO {

	private int idx;
	private int ref;				// 메인글의 글번호 => 어떤 메인글의 댓글인가를 의미한다.
	private String name;
	private String password;
	private String content;
	private Date writeDate;
	private String ip;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	@Override
	public String toString() {
		return "FreeboardCommentVO [idx=" + idx + ", ref=" + ref + ", name=" + name + ", password=" + password
				+ ", content=" + content + ", writeDate=" + writeDate + ", ip=" + ip + "]";
	}
	
}
