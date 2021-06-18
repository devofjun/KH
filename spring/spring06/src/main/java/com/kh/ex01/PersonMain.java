package com.kh.ex01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class PersonMain {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		// xml, 자바 섞어쓰기
		// 지금은 java bean이 기준임(ctx)
		Student s = ctx.getBean("stu1", Student.class);
		Person p = ctx.getBean("kim",Person.class);
		System.out.println(s);
		System.out.println(p);
		ctx.close();
	}
}
