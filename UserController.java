package com.study.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.springboot.dto.UserDTO;
import com.study.springboot.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
/**
 * @author 이승찬
 * @apiNote
 * 	로그인/회원가입 컨트롤러입니다.
 * 	
 * 
 *  회원가입 : 중복된 아이디 가입 불가 (완료)
 *  
 *  TODO : 중복된 이메일 가입 막기
 *  	   비밀번호에 아이디 문자열이 그대로 입력되면 가입 막기
 *  	   이름 한글 알파벳으로 들어오는거 막기
 *         로그인 구현(세션)
 *         로그인 할 때 비밀번호 암호화 두번 해서 대조해야함
 *         
 *  	   
 * */


@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	// 메인페이지
	@RequestMapping("/")
	public String main() {
		
		return "lsc_main_test";
	}
	
	// 로그인 폼
	@RequestMapping("/login")
	public String loginForm() {
		
		return "loginForm";
	}
	
	// 로그인 수행
	@RequestMapping(value="/doLogin", method=RequestMethod.POST)
	public String doLogin(
			HttpServletRequest req,
			@ModelAttribute
			UserDTO userDTO,
			Model model
			) {
		
		int result = 1;
		
		return "redirect:/";
	}
	
	// 회원가입 폼
	@RequestMapping("/signup")
	public String signupForm() {
		
		return "signupForm";
	}
	
	// 회원가입 수행
	@RequestMapping(value="/doSignup", method=RequestMethod.POST)
	public String doSignup(
			@ModelAttribute UserDTO userDTO,
			@RequestParam("isJsEnabled") String isJsEnabled,
			Model model
			) {
		
		String id = userDTO.getId();
		
		// 자바스크립트에서 SHA-256알고리즘으로 암호화한 비밀번호 확인용
		//String pw = userDTO.getPw();
		//System.out.println("hashed pw : " + pw);
		
		int countID = userService.idDupCheck(userDTO);
		int result = userService.joinUser(userDTO);
		
		if (countID == 0) {
			model.addAttribute("사용 가능한 ID입니다.","okMessage");
			
		} else {
			// countID가 0이 아니면 이미 DB에 같은 ID가 한 개 이상 존재
			model.addAttribute("이미 사용중인 아이디입니다.","dupMessage");
			return "signupForm";
		}
		
		
		if (result == 1) {
			System.out.println("회원가입 성공");
		} else {
			System.out.println("회원가입 실패");
		}
		
		return "redirect:/";
	}

}
