package com.poscoict.hrmaster.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.poscoict.hrmaster.service.MemberService;
import com.poscoict.hrmaster.web.dto.MemberDto;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class HomeController {
	private MemberService memberService;

	@GetMapping("/") // 메인페이지
	public String main() {
		return "index";
	}

	@GetMapping("/user/login") // 로그인 페이지
	public String goLogin() {
		return "login/login";
	}

	@GetMapping("/login-error") // 로그인 에러
	public String loginError(Model model) {
		model.addAttribute("loginError", true);
		return "/login/login";
	}		

	@GetMapping("/denied") // 접근 거부 페이지
	public String doDenied() {
		return "login/denied";
	}

	@GetMapping("/info") // 내 정보 페이지
	public String goMyInfo() {
		return "login/myinfo";
	}

	@GetMapping("/admin") // 어드민 페이지
	public String goAdmin() {
		return "login/admin";
	}
	
	
	/** * 회원가입 페이지 이동 * @return */
	@GetMapping("/signup")
	public String goSignup() {
		return "login/signup";
	}

	/** * 회원가입 처리 * @param memberDto * @return */
	@PostMapping("/signup")
	public String signup(MemberDto memberDto) {
		memberService.joinUser(memberDto);
		return "redirect:/user/login";
	}

	
}
