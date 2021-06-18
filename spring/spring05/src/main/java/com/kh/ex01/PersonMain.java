package com.kh.ex01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class PersonMain {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:app-ctx.xml");
		// xml, 자바 섞어쓰기
		// 지금은 xml이 기준임 -> xml파일에서 Configuration 설정을 해놓음 -> xml에서 java의 bean을 읽음. -> Student s
		Student s = ctx.getBean("stu1", Student.class);
		Person p = ctx.getBean("kim",Person.class);
		System.out.println(s);
		System.out.println(p);
		ctx.close();
	}
}
