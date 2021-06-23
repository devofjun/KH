package com.kh.sample02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/board")
public class BoardController {
	
	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public String listAll() {
		
		return "board/listAll";
	}
	
}
