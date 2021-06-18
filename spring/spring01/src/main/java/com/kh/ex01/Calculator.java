package com.kh.ex01;

public class Calculator {
	private int num1;
	private int num2;
	
	public Calculator(int num1, int num2) {
		super();
		this.num1 = num1;
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
