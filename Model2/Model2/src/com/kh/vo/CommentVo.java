package com.kh.vo;

import java.sql.Timestamp;

public class CommentVo {
	private int c_no;			// 댓글 번호
	private int b_no;			// 원글 번호 
	private String c_content;	// 댓글 내용
	private String m_id;		// 사용자 아이디
	private Timestamp c_date;	// 작성 시간
	
	
	public CommentVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public CommentVo(int c_no, String c_content, String m_id, Timestamp c_date) {
		super();
		this.c_no = c_no;
		this.c_content = c_content;
		this.m_id = m_id;
		this.c_date = c_date;
	}


	public CommentVo(int c_no, int b_no, String c_content, String m_id, Timestamp c_date) {
		super();
		this.c_no = c_no;
		this.b_no = b_no;
		this.c_content = c_content;
		this.m_id = m_id;
		this.c_date = c_date;
	}
	public int getC_no() {
		return c_no;
	}
	public void setC_no(int c_no) {
		this.c_no = c_no;
	}
	public int getB_no() {
		return b_no;
	}
	public void setB_no(int b_no) {
		this.b_no = b_no;
	}
	public String getC_content() {
		return c_content;
	}
	public void setC_content(String c_content) {
		this.c_content = c_content;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public Timestamp getC_date() {
		return c_date;
	}
	public void setC_date(Timestamp c_date) {
		this.c_date = c_date;
	}
	@Override
	public String toString() {
		return "CommentVo [c_no=" + c_no + ", b_no=" + b_no + ", c_content=" + c_content + ", m_id=" + m_id
				+ ", c_date=" + c_date + "]";
	}	
	
}
