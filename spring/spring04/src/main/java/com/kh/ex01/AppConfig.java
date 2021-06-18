package com.kh.ex01;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	// <bean class="com.kh.ex01.Person" id="kim"
	//		c:name c:age c:hobbies-ref p:height p:weight>
	// 
	@Bean
	public Person kim() {
		ArrayList<String> hobbies = new ArrayList<String>();
		hobbies.add("승마");
		hobbies.add("골프");
		Person p = new Person("김길동", 30, hobbies);
		p.setHeight(170.5);
		p.setWeight(60.5);
		return p;
	}
}
