package com.kh.exam01.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kh.exam01.domain.ConsultVo;
import com.kh.exam01.service.ConsultService;

@RestController
@RequestMapping(value="/consult")
public class ConsultController {
	
	@Inject
	ConsultService consultService;
	
	@RequestMapping(value="/showList/{sno}", method=RequestMethod.GET)
//	@ResponseBody
	public List<ConsultVo> showConsultList(@PathVariable("sno") int sno) {
		System.out.println("sno: " + sno);
		List<ConsultVo> list = consultService.showStdConsult(sno);
		System.out.println(list);
		
		return list;
	}
}
