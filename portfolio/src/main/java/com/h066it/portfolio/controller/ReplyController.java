package com.h066it.portfolio.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
		
		return "redirect:view?gId=" + rDto.getgId() + "&bId=" + rDto.getbId();
	}

	@RequestMapping("/replyUpdate")
	public String ReplyUpdate(ReplyDto rDto, Model model) {
		
		System.out.println("replyUpdate");
		boolean i = service.replyUpdate(rDto.getgId(), rDto.getbId(), rDto.getrId(),
				rDto.getrWriter(), rDto.getrPassword(), rDto.getrContent());

		System.out.println("i : " + i);	// true = password가 같으므로 동작. false = password 다름.
		model.addAttribute("pwdChk", i);
		
		return "redirect:view?gId=" + rDto.getgId() + "&bId=" + rDto.getbId();
	}
	
	@RequestMapping("/replyDelete")
	public String ReplyDelete(ReplyDto rDto, Model model) {
		
		System.out.println("replyDelete");
		boolean i = service.replyDelete(rDto.getgId(), rDto.getbId(), rDto.getrId(), rDto.getrPassword());

		System.out.println("i : " + i);	// true = password가 같으므로 동작. false = password 다름.
		model.addAttribute("pwdChk", i);
		
		return "redirect:view?gId=" + rDto.getgId() + "&bId=" + rDto.getbId();
	}
	
	@RequestMapping(value="/test", method=RequestMethod.POST)
	@ResponseBody
	public String test(@RequestBody ReplyDto rDto, HttpServletRequest request) throws Exception {
		
		System.out.println("test");
		
		System.out.println("★rDto.getgId : " + rDto.getgId());
		System.out.println("★rDto.getbId : " + rDto.getbId());
		System.out.println("★rDto.getrId : " + rDto.getrId());
		System.out.println("★rDto.getrGroup : " + rDto.getrGroup());
		System.out.println("★rDto.getrPassword : " + rDto.getrPassword());

		return "success~";
	}
	
}
