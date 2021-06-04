package com.kh.db;

public class UIVo {
	String SNO;
	String SNAME;
	int SYEAR;
	String GENDER;
	String MAJOR;
	int SCORE;
	public UIVo() {super();}
	public UIVo(String SNO, String SNAME, int SYEAR, String GENDER, String MAJOR, int SCORE) {
		super();
		this.SNO = SNO;
		this.SNAME = SNAME;
		this.SYEAR = SYEAR;
		this.GENDER = GENDER;
		this.MAJOR = MAJOR;
		this.SCORE = SCORE;
	}
	public String getSNO() {
		return SNO;
	}
	public void setSNO(String sNO) {
		SNO = sNO;
	}
	public String getSNAME() {
		return SNAME;
	}
	public void setSNAME(String sNAME) {
		SNAME = sNAME;
	}
	public int getSYEAR() {
		return SYEAR;
	}
	public void setSYEAR(int sYEAR) {
		SYEAR = sYEAR;
	}
	public String getGENDER() {
		return GENDER;
	}
	public void setGENDER(String gENDER) {
		GENDER = gENDER;
	}
	public String getMAJOR() {
		return MAJOR;
	}
	public void setMAJOR(String mAJOR) {
		MAJOR = mAJOR;
	}
	public int getSCORE() {
		return SCORE;
	}
	public void setSCORE(int sCORE) {
		SCORE = sCORE;
	}
	@Override
	public String toString() {
		return "UIVo [SNO=" + SNO + ", SNAME=" + SNAME + ", SYEAR=" + SYEAR + ", GENDER=" + GENDER + ", MAJOR=" + MAJOR
				+ ", SCORE=" + SCORE + "]";
	}
	
}
