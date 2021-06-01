package com.kh.db;

public class StudentVo {
	// 소문자로 변경 (Ctrl + Shift + Y)
	// 대문자로 변경 (Ctrl + Shift + X)
	private int st_num;
	private String st_name;
	private String st_major;
	private int st_year;
	private int st_score;
	private String st_etc;
	
	// 기본 생성자
	public StudentVo() {
		super();
	}
	// 생성자
	public StudentVo(int st_num, String st_name, String st_major, int st_year, int st_score, String st_etc) {
		super();
		this.st_num = st_num;
		this.st_name = st_name;
		this.st_major = st_major;
		this.st_year = st_year;
		this.st_score = st_score;
		this.st_etc = st_etc;
	}
	// getter/setter
	public int getSt_num() {
		return st_num;
	}

	public void setSt_num(int st_num) {
		this.st_num = st_num;
	}

	public String getSt_name() {
		return st_name;
	}

	public void setSt_name(String st_name) {
		this.st_name = st_name;
	}

	public String getSt_major() {
		return st_major;
	}

	public void setSt_major(String st_major) {
		this.st_major = st_major;
	}

	public int getSt_year() {
		return st_year;
	}

	public void setSt_year(int st_year) {
		this.st_year = st_year;
	}

	public int getSt_score() {
		return st_score;
	}

	public void setSt_score(int st_score) {
		this.st_score = st_score;
	}

	public String getSt_etc() {
		return st_etc;
	}

	public void setSt_etc(String st_etc) {
		this.st_etc = st_etc;
	}
	// toString

	@Override
	public String toString() {
		return "StudentVo [st_num=" + st_num + ", st_name=" + st_name + ", st_major=" + st_major + ", st_year="
				+ st_year + ", st_score=" + st_score + ", st_etc=" + st_etc + "]";
	}
	
}
