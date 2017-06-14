package com.h066it.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.h066it.portfolio.dto.ReplyDto;
import com.h066it.portfolio.service.ServiceModel;

@Controller
public class ReplyController {

	@Autowired
	private ServiceModel service;	// Model(Service)°ú Controller ³ª´®.
	
	@RequestMapping("/replyWrite")
	public String Reply(ReplyDto rDto, Model model) {
		
		System.out.println("replyWrite");
		service.replyWrite(rDto);
		
		return "redirect:view?bId=" + rDto.getbId();
	}
	
}
