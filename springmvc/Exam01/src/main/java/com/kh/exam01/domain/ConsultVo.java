package com.kh.exam01.domain;

import java.sql.Timestamp;

public class ConsultVo {
	private int consult_no;
	private String sno;
	private String consult_content;
	private Timestamp consult_date;
	private String sname;
	
	public ConsultVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ConsultVo(String sno, String consult_content) {
		super();
		this.sno = sno;
		this.consult_content = consult_content;
	}
	public int getConsult_no() {
		return consult_no;
	}
	public void setConsult_no(int consult_no) {
		this.consult_no = consult_no;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getConsult_content() {
		return consult_content;
	}
	public void setConsult_content(String consult_content) {
		this.consult_content = consult_content;
	}
	public Timestamp getConsult_date() {
		return consult_date;
	}
	public void setConsult_date(Timestamp consult_date) {
		this.consult_date = consult_date;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	@Override
	public String toString() {
		return "ConsultVo [consult_no=" + consult_no + ", sno=" + sno + ", consult_content=" + consult_content
				+ ", consult_date=" + consult_date + ", sname=" + sname + "]";
	}

}
