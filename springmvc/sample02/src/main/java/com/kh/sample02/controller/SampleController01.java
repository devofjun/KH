package com.kh.sample02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SampleController01 {
	
	@RequestMapping (value="/doA", method=RequestMethod.GET)
	public void doA() {
		System.out.println("/doA 실행됨...");
		// 반환 타입이 void 인 경우 : 요청명.jsp 로 forward
	}
	
	@RequestMapping (value="/doB", method=RequestMethod.GET)
	public void doB() {
		System.out.println("/doB 실행됨...");
	}
}
