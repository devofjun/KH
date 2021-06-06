package com.example.ui_android;

public class UIVO {
    private String SNO;
    private String SNAME;
    private int SYEAR;
    private String GENDER;
    private String MAJOR;
    private int SCORE;
    public UIVO(){}
    public UIVO(String SNO, String SNAME, int SYEAR, String GENDER, String MAJOR, int SCORE) {
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

    public void setSNO(String SNO) {
        this.SNO = SNO;
    }

    public String getSNAME() {
        return SNAME;
    }

    public void setSNAME(String SNAME) {
        this.SNAME = SNAME;
    }

    public int getSYEAR() {
        return SYEAR;
    }

    public void setSYEAR(int SYEAR) {
        this.SYEAR = SYEAR;
    }

    public String getGENDER() {
        return GENDER;
    }

    public void setGENDER(String GENDER) {
        this.GENDER = GENDER;
    }

    public String getMAJOR() {
        return MAJOR;
    }

    public void setMAJOR(String MAJOR) {
        this.MAJOR = MAJOR;
    }

    public int getSCORE() {
        return SCORE;
    }

    public void setSCORE(int SCORE) {
        this.SCORE = SCORE;
    }

    @Override
    public String toString() {
        return "UIVO{" +
                "SNO='" + SNO + '\'' +
                ", SNAME='" + SNAME + '\'' +
                ", SYEAR=" + SYEAR +
                ", GENDER='" + GENDER + '\'' +
                ", MAJOR='" + MAJOR + '\'' +
                ", SCORE=" + SCORE +
                '}';
    }
}
