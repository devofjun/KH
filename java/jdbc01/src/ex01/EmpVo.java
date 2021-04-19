package ex01;

import java.sql.Date;

// Java Bean
// 기본생성자
// getter/setter

public class EmpVo { // 데이터 객체 - VO(Value object)
	// 소문자로 변경 : Ctrl + Shift + y
	// 대문자로 변경 : Ctrl + Shift + x
	private int empno;			//사번
	private String ename;		//이름
	private String job;			//직책
	private int mgr;			//관리자(사수)
	private Date hiredate;		//입사일
	private int sal;			//급여
	private int comm;			//커미션(보너스)
	private int deptno;			//부서번호
	
	public EmpVo() {
		super();
		
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getMgr() {
		return mgr;
	}

	public void setMgr(int mgr) {
		this.mgr = mgr;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public int getComm() {
		return comm;
	}

	public void setComm(int comm) {
		this.comm = comm;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	@Override
	public String toString() {
		return "EmpVo [empno=" + empno + ", ename=" + ename + ", job=" + job + ", mgr=" + mgr + ", hiredate=" + hiredate
				+ ", sal=" + sal + ", comm=" + comm + ", deptno=" + deptno + "]";
	}
	
}
