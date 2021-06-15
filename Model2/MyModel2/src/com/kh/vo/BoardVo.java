package com.kh.vo;

import java.sql.Timestamp;

public class BoardVo {
	private int b_no;
	private String b_title;
	private String b_content;
	private Timestamp b_date;
	private String m_id;
	private int b_readcount;
	private int re_group;
	private int re_seq;
	private int re_level;
	private String b_filepath;
	public BoardVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardVo(int b_no, String b_title, String b_content, Timestamp b_date, String m_id, int b_readcount,
			int re_group, int re_seq, int re_level, String b_filepath) {
		super();
		this.b_no = b_no;
		this.b_title = b_title;
		this.b_content = b_content;
		this.b_date = b_date;
		this.m_id = m_id;
		this.b_readcount = b_readcount;
		this.re_group = re_group;
		this.re_seq = re_seq;
		this.re_level = re_level;
		this.b_filepath = b_filepath;
	}
	public int getB_no() {
		return b_no;
	}
	public void setB_no(int b_no) {
		this.b_no = b_no;
	}
	public String getB_title() {
		return b_title;
	}
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	public Timestamp getB_date() {
		return b_date;
	}
	public void setB_date(Timestamp b_date) {
		this.b_date = b_date;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public int getB_readcount() {
		return b_readcount;
	}
	public void setB_readcount(int b_readcount) {
		this.b_readcount = b_readcount;
	}
	public int getRe_group() {
		return re_group;
	}
	public void setRe_group(int re_group) {
		this.re_group = re_group;
	}
	public int getRe_seq() {
		return re_seq;
	}
	public void setRe_seq(int re_seq) {
		this.re_seq = re_seq;
	}
	public int getRe_level() {
		return re_level;
	}
	public void setRe_level(int re_level) {
		this.re_level = re_level;
	}
	public String getB_filepath() {
		return b_filepath;
	}
	public void setB_filepath(String b_filepath) {
		this.b_filepath = b_filepath;
	}
	@Override
	public String toString() {
		return "BoardVo [b_no=" + b_no + ", b_title=" + b_title + ", b_content=" + b_content + ", b_date=" + b_date
				+ ", m_id=" + m_id + ", b_readcount=" + b_readcount + ", re_group=" + re_group + ", re_seq=" + re_seq
				+ ", re_level=" + re_level + ", b_filepath=" + b_filepath + "]";
	}
	
	
}
