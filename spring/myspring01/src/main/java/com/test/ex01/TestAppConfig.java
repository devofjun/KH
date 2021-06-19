package com.test.ex01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@ImportResource("classpath:app-ctx.xml")
@Configuration
public class TestAppConfig {
	
	@Bean
	public TestDto tester() {
		TestDto dto = new TestDto();
		
		dto.setT_name("이름");
		dto.setT_age(20);
		dto.setT_height(50.0);
		String[] myHobbies = {"독서", "음악"};
		dto.setHobbies(myHobbies);
		
		return dto;
	}
}	
