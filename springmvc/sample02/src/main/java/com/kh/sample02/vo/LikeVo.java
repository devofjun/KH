package com.kh.sample02.vo;

public class LikeVo {
	private int b_no;
	private String user_id;
	public LikeVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LikeVo(int b_no, String user_id) {
		super();
		this.b_no = b_no;
		this.user_id = user_id;
	}
	public int getB_no() {
		return b_no;
	}
	public void setB_no(int b_no) {
		this.b_no = b_no;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "LikeVo [b_no=" + b_no + ", user_id=" + user_id + "]";
	}
	
}
