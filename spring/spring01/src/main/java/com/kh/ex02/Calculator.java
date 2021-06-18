package com.kh.ex02;

public class Calculator {
	private int num1;
	private int num2;
	
	// 기본생성자가 무조건 있어야 한다.
	public Calculator() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Calculator(int num1, int num2) {
		super();
		this.num1 = num1;
		this.num2 = num2;
	}

	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}

	public void add() {
		System.out.println(num1 + num2);
	}

	public void sub() {
		System.out.println(num1 - num2);
	}

	public void mul() {
		System.out.println(num1 * num2);
	}

	public void div() {
		System.out.println(num1 / num2);
	}
}
