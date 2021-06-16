package com.kh.vo;

public class MemberVo {
	private String user_id;
	private String user_pw;
	private String user_name;
	public MemberVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemberVo(String user_id, String user_pw, String user_name) {
		super();
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_name = user_name;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	@Override
	public String toString() {
		return "MemberVo [user_id=" + user_id + ", user_pw=" + user_pw + ", user_name=" + user_name + "]";
	}
	
}
