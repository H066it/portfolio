package com.h066it.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.h066it.portfolio.dto.MemberDto;
import com.h066it.portfolio.service.SecurityServiceModel;
import com.h066it.portfolio.service.ServiceModel;

@Controller
public class SecurityContoroller {

	@Autowired
	private SecurityServiceModel sService;	// Model(Service)°ú Controller ³ª´®.
	
	@RequestMapping("/login")
	public String login(MemberDto mDto, Model model) {
						
		return "security/login";
	}
	
	@RequestMapping("/signUpForm")
	public String signUpForm(MemberDto dto, Model model) {
				
		return "security/signUpForm";
	}

	@RequestMapping("/signUp")
	public String signUp(MemberDto dto, Model model) {
				
		Boolean signUpRst = sService.signUp(dto);
		if(signUpRst == true) {	
			model.addAttribute("signUpRst", signUpRst);
			return "redirect:list";
		} else {
			model.addAttribute("signUpRst", signUpRst);
			return "security/signUpForm";
		}
	}
	
}
