package com.kh.sample01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SampleController03 {
	
	@RequestMapping(value="/doF", method=RequestMethod.GET)
	public String doF() {
		System.out.println("doF 실행됨");
		return "redirect:/doG";
	}
	
	@RequestMapping(value="/doG", method=RequestMethod.GET)
	public String doG() {
		System.out.println("doG 실행됨");
		return "do_g";
	}
	
	@RequestMapping(value="/doH", method=RequestMethod.GET)
	public String doH(RedirectAttributes rttr) {
		System.out.println("doH 실행됨");
		// 리다이렉트 할때 저장할 값이 있을때 사용
		rttr.addFlashAttribute("msg", "success");
		// 한번 사용되면 지워짐
		return "redirect:/doI";
	}
	
	@RequestMapping(value="/doI", method=RequestMethod.GET)
	public String doI() {
		System.out.println("doI 실행됨");
		return "do_i";
	}
}
