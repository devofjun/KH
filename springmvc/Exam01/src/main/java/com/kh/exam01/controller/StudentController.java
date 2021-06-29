package com.kh.exam01.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.exam01.domain.StudentVo;
import com.kh.exam01.service.StudentService;

@Controller
@RequestMapping(value="/std")
public class StudentController {
	
	@Inject
	private StudentService stdService;
	
	@RequestMapping(value="/stdList", method=RequestMethod.GET)
	public String stdList(Model model) {
		List<StudentVo> list = stdService.listAll();
		model.addAttribute("list", list);
		return "student/stdList";
	}
	
	@RequestMapping(value="/stdRegist", method=RequestMethod.GET)
	public String stdRegist() {
		
		return "student/stdRegist";
	}
	
	@RequestMapping(value="/stdRegistRun", method=RequestMethod.POST)
	public String stdRegistRun(StudentVo studentVo, RedirectAttributes rttr) {
		System.out.println(studentVo);
		stdService.stdRegistRun(studentVo);
		rttr.addFlashAttribute("registResult", "success");
		return "redirect:/std/stdList";
	}
	
	@RequestMapping(value="/stdModify/{sno}", method=RequestMethod.GET)
	public String stdModify(@PathVariable("sno") String sno, Model model) {
		System.out.println(sno);
		StudentVo studentVo = stdService.getStudent(sno);
		model.addAttribute("studentVo", studentVo);
		return "student/stdModify";
	}
	
	@RequestMapping(value="/stdModifyRun", method=RequestMethod.POST)
	public String stdModifyRun(StudentVo studentVo, RedirectAttributes rttr) {
		System.out.println(studentVo);
		stdService.stdModifyRun(studentVo);
		rttr.addFlashAttribute("modifyResult", "success");
		return "redirect:/std/stdList";
	}
	
	@RequestMapping(value="/stdRemoveRun/{sno}", method=RequestMethod.GET)
	public String stdRemoveRun(@PathVariable("sno") String sno, RedirectAttributes rttr) {
		System.out.println(sno);
		stdService.stdRemoveRun(sno);
		rttr.addFlashAttribute("removeResult", "success");
		return "redirect:/std/stdList";
	}
	
	@ResponseBody
	@RequestMapping(value="/stdSearch", method=RequestMethod.GET)
	public List<StudentVo> stdSearch(String searchOption, String keyword) {
		System.out.println(searchOption +"|"+ keyword);
		List<StudentVo> list = null;
		
		return list;
	}
}
