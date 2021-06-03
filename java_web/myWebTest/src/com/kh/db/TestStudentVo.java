package com.kh.db;

public class TestStudentVo {
	private int stNum;
	private String stName;
	private String stMajor;
	private int stYear;
	private int stScore;
	private String stEtc;
	
	public TestStudentVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TestStudentVo(int stNum, String stName, String stMajor, int stYear, int stScore, String stEtc) {
		super();
		this.stNum = stNum;
		this.stName = stName;
		this.stMajor = stMajor;
		this.stYear = stYear;
		this.stScore = stScore;
		this.stEtc = stEtc;
	}
	public int getStNum() {
		return stNum;
	}
	public void setStNum(int stNum) {
		this.stNum = stNum;
	}
	public String getStName() {
		return stName;
	}
	public void setStName(String stName) {
		this.stName = stName;
	}
	public String getStMajor() {
		return stMajor;
	}
	public void setStMajor(String stMajor) {
		this.stMajor = stMajor;
	}
	public int getStYear() {
		return stYear;
	}
	public void setStYear(int stYear) {
		this.stYear = stYear;
	}
	public int getStScore() {
		return stScore;
	}
	public void setStScore(int stScore) {
		this.stScore = stScore;
	}
	public String getStEtc() {
		return stEtc;
	}
	public void setStEtc(String stEtc) {
		this.stEtc = stEtc;
	}
	@Override
	public String toString() {
		return "TestStudentVo [stNum=" + stNum + ", stName=" + stName + ", stMajor=" + stMajor + ", stYear=" + stYear
				+ ", stScore=" + stScore + ", stEtc=" + stEtc + "]";
	}
	
}
