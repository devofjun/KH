package com.kh.sample01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.sample01.vo.ProductVo;

@Controller
public class SampleController02 {
	// 반환 타입이 String 인 경우
	// 리턴값.jsp
	@RequestMapping(value="/doC", method=RequestMethod.GET)
	public String doC() {
		System.out.println("/doC 실행됨...");
		return "do_c";
	}
	
	@RequestMapping(value="doD", method=RequestMethod.GET)
	public String doD(@ModelAttribute("msg") String msg) {
		// String msg = request.getParameter("msg");
		// request.setAttribute("msg", msg);
		// @ModelAttribute
		// -> msg라는 이름으로 넘어온 파라미터의 값을 String 변수 msg에 저장하고,
		// -> view(jsp)까지 전달해줌
		System.out.println("/doD 실행됨...");
		return "do_d";
	}
	
	@RequestMapping(value="doE", method=RequestMethod.GET)
	public String doE(Model model) {
		System.out.println("/doE 실행됨...");	
		ProductVo productVo = new ProductVo();
		productVo.setName("냉장고");
		productVo.setPrice(300);
		// 모델을 쓸때는 setAttribute 가 아니라 addAttribute이다.
		model.addAttribute(productVo);
		// -> 키가 생략되면 -> 클래스명의 첫글자를 소문자로 변경한 이름
 
		ProductVo productVo2 = new ProductVo("텔레비전", 200);
		model.addAttribute("productVo2", productVo2);
		// -> 키, 값
		return "do_e";
	}
}
