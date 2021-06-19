package com.test.ex01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class TestMain {
	public static void main(String[] args) {
		// 설계한 xml파일로 bean 객체를 만들어서 가져온다. 
		AbstractApplicationContext ctx =
				new AnnotationConfigApplicationContext(TestAppConfig.class);
		
		// xml에 정의된 Bean 객체
		TestDto dto = ctx.getBean("test3", TestDto.class);
		System.out.println(dto);
		
		// java에 정의된 Bean 객체
		TestDto dto2 = ctx.getBean("tester", TestDto.class);
		System.out.println(dto2);
		
		ctx.close();
	}
}
