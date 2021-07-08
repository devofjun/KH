package com.kh.sample02;

import java.io.FileInputStream;
import java.util.List;
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
import com.kh.sample02.service.MessageService;
import com.kh.sample02.util.MyFileUploadUtil;
import com.kh.sample02.vo.MemberVo;
import com.kh.sample02.vo.MessageVo;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	private MemberService memberService;
	
	@Inject
	private MessageService messageService;
	
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
		System.out.println(fileName+"파일 삭제 끝");
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
		
		System.out.println("id: " + user_id + "pw: " + user_pw);
		MemberVo memberVo = memberService.login(user_id, user_pw);

		String msg = null;
		String page = null;
		if(memberVo != null) { // 로그인 성공
			msg = "success";
			page = "redirect:/board/listAll";
			
			int notReadCount = messageService.notReadCount(user_id);
			memberVo.setNotReadCount(notReadCount);
			session.setAttribute("loginVo", memberVo);
			
			String requestPath = (String)session.getAttribute("requestPath");
			session.removeAttribute("requestPath"); // 더이상 필요없는 세션은 지운다.
			if(requestPath != null) {
				page = "redirect:" + requestPath;
			}
		} else { // 로그인 실패
			msg = "fail";
			page = "redirect:/loginForm";
		}
		
		rttr.addFlashAttribute("msg", msg);
		return page;
	}
	
	// 회원가입 폼
	@RequestMapping(value="/memberJoinForm", method=RequestMethod.GET)
	public String memberJoinForm() throws Exception {
		return "memberJoinForm";
	}
	
	// 아이디 중복 확인
	@RequestMapping(value="/checkDupId", method=RequestMethod.GET)
	@ResponseBody
	public String checkDupId(String user_id) throws Exception {
		boolean result = memberService.checkDupId(user_id);
		return String.valueOf(result);
	}
	
	// 회원가입 실행
	@RequestMapping(value="/memberJoinRun", method=RequestMethod.POST)
	public String memberJoinRun(MemberVo memberVo, MultipartFile file, RedirectAttributes rttr) throws Exception {
		String orgfileName = file.getOriginalFilename();
		System.out.println("orgfileName:"+orgfileName);
		String filePath = MyFileUploadUtil.uploadFile("D:/user_pic", orgfileName, file.getBytes());
		memberVo.setUser_pic(filePath);
		System.out.println("memberVo:"+memberVo);
		
		memberService.insertMember(memberVo);
		
		rttr.addFlashAttribute("registMsg", "succes");
		return "redirect:/board/listAll";
		//return null;
	}
	
	// 로그아웃
	// 한 세션만 로그아웃 되려면?
	// 메소드로 받으면 해당 세션의 정보만 넘어오기 때문에 해당 세션만 지울수있다.
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate(); // 현재 세션 무효화 => removeAttribute() 모두
		return "redirect:/loginForm";
	}
	
	
}
