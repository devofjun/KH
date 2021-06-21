package com.kh.sample01.controller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.sample01.vo.ProductVo;

@Controller
public class SampleController04 {
	
	@RequestMapping(value="/doJSON", method=RequestMethod.GET)
	@ResponseBody
	public ProductVo doJSON() {
		// @ResponseBody
		// -> 자기가 알아서 json 형태로 바꿔준다.
		ProductVo vo = new ProductVo("냉장고", 300);
		return vo;
	}
	
	@RequestMapping(value="/doJsonList", method=RequestMethod.GET)
	@ResponseBody
	public List<ProductVo> doJsonList() {
		List<ProductVo> list = new ArrayList<>();
		for(int i =1; i<=10; i++ ) {
			ProductVo vo = new ProductVo("냉장고"+i, 300 *i);
			list.add(vo);
		}
		return list;
	}
}
