package com.kh.ex01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class PersonMain {
	public static void main(String[] args) {
		// 자바 클래스로 만든 Bean 사용법
		AbstractApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		Person p = ctx.getBean("kim",Person.class);
		System.out.println(p);
		ctx.close();
	}
}
