package com.kh.sample02;

import java.io.FileInputStream;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.sample02.service.MemberService;
import com.kh.sample02.util.MyFileUploadUtil;
import com.kh.sample02.vo.MemberVo;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	private MemberService memberService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		/*
		logger.info("Welcome home! The client locale is {}.", locale);
		//System.out.println("##test##->homePage");
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		*/
		return "redirect:/board/listAll";
	}
	
	// 이미지 업로드
	@ResponseBody
	@RequestMapping(value = "/uploadAjax", method=RequestMethod.POST,
			produces="application/text;charset=utf-8")
	public String uploadAjax(MultipartFile file) throws Exception {
		// 파일이 넘어온건가?
		// 파일 이름 출력
		System.out.println("file:"+file.getOriginalFilename());
		String originalFilename = file.getOriginalFilename();
		String filePath = MyFileUploadUtil.uploadFile("D:/upload", originalFilename, file.getBytes());
		//System.out.println("file:"+file.getContentType());
		
		return filePath;
	}
	
	// 썸네일 이미지 요청 -> 바이너리 파일은 결국 byte 배열이다. -> 파일크기 줄임
	@RequestMapping(value="/displayImage", method=RequestMethod.GET)
	@ResponseBody
	public byte[] displayImage(String fileName) throws Exception {
		FileInputStream fis = new FileInputStream(fileName);
		byte[] bytes = IOUtils.toByteArray(fis);
		fis.close();
		return bytes;
	}
	
	// 첨부파일 삭제
	@RequestMapping(value="/deleteFile", method=RequestMethod.GET)
	@ResponseBody
	public String deleteFile(String fileName) throws Exception {
		MyFileUploadUtil.deleteFile(fileName);
		System.out.println("파일 삭제 끝");
		return "success";
	}
	
	// 로그인 폼
	@RequestMapping(value="/loginForm", method=RequestMethod.GET)
	public String loginForm() throws Exception {
		return "loginForm";
	}
	
	// 로그인 실행
	@RequestMapping(value="/loginRun", method=RequestMethod.POST)
	public String loginRun(String user_id, String user_pw,
			RedirectAttributes rttr, HttpSession session) throws Exception {
		System.out.println("id: " + user_id + "pw: " +user_pw);
		MemberVo memberVo = memberService.login(user_id, user_pw);
		String msg = null;
		String page = null;
		if(memberVo != null) { // 로그인 성공
			msg = "success";
			page = "redirect:/board/listAll";
			session.setAttribute("loginVo", memberVo);
		} else { // 로그인 실패
			msg = "fail";
			page = "redirect:/loginForm";
		}
		
		rttr.addFlashAttribute("msg", msg);
		return page;
	}
}
