package com.h066it.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.h066it.portfolio.dto.ReplyDto;
import com.h066it.portfolio.service.ServiceModel;

@Controller
public class ReplyController {

	@Autowired
	private ServiceModel service;	// Model(Service)과 Controller 나눔.
	
	@RequestMapping("/replyWrite")
	public String Reply(ReplyDto rDto, Model model) {
		
		System.out.println("replyWrite");
		service.replyWrite(rDto);
		
		return "redirect:view?bId=" + rDto.getbId();
	}

	@RequestMapping("/replyUpdate")
	public String ReplyUpdate(ReplyDto rDto, Model model) {
		
		System.out.println("replyUpdate");
		boolean i = service.replyUpdate(rDto.getbId(), rDto.getrId(), rDto.getrWriter(), rDto.getrPassword(), rDto.getrContent());

		System.out.println("i : " + i);	// true = password가 같으므로 동작. false = password 다름.
		model.addAttribute("pwdChk", i);
		
		return "redirect:view?bId=" + rDto.getbId();
	}
	
	@RequestMapping("/replyDelete")
	public String ReplyDelete(ReplyDto rDto, Model model) {
		
		System.out.println("replyDelete");
		boolean i = service.replyDelete(rDto.getbId(), rDto.getrId(), rDto.getrPassword());

		System.out.println("i : " + i);	// true = password가 같으므로 동작. false = password 다름.
		model.addAttribute("pwdChk", i);
		
		return "redirect:view?bId=" + rDto.getbId();
	}
	
}
