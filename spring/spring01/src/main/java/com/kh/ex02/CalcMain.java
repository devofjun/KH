package com.kh.ex02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CalcMain {
	public static void main(String[] args) {
//		Calculator calc = new Calculator(100, 50);
//		calc.add();
//		calc.sub();
//		calc.mul();
//		calc.div();
		// 객체를 직접 만드는 것이 아닌 spring을 통해 관리되는 객체를 달라고 하는것
		// 싱글레톤으로 만들어짐
		AbstractApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:app-ctx.xml");
		Calculator calc = ctx.getBean("calc", Calculator.class);
		Calculator calc2 = ctx.getBean("calc", Calculator.class);
		System.out.println("calc:"+calc);
		System.out.println("calc2:"+calc2);
		calc.setNum1(200);
		calc.setNum2(100);
		calc.add();
		calc.sub();
		calc.mul();
		calc.div();
		
		// context 종료
		ctx.close();
	}
}
