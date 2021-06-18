package com.kh.ex01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class StudentMain {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:app-ctx.xml");
		
		// 같은 객체(싱글톤)인지 prototype으로 만든 다른 객체인지 확인한다.
		Student s1 = ctx.getBean("stu1", Student.class);
		System.out.println(s1.getName());
		System.out.println(s1.getAge());
		System.out.println(s1.getGradeNum());
		System.out.println(s1.getClassNum());
		Student s2 = ctx.getBean("stu1", Student.class);
		s2.setName("김길동");
		System.out.println(s1.getName()); // 홍길동
		System.out.println(s2.getName()); // 김길동
		ctx.close();
		
	}
}
