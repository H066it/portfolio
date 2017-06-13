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
	private ServiceModel service;	// Model(Service)과 Controller 나눔.
	
	@RequestMapping("/replyWrite")
	public String Reply(ReplyDto rDto, Model model) {
		
		System.out.println("replyWrite");
		service.replyWrite(rDto);
		
		return "redirect:view?bId=" + rDto.getbId();
	}
	
	@RequestMapping("/test123")
	public @ResponseBody void test(@RequestParam("bId")int bId, @RequestParam("rId")String rId,
			@RequestParam("rWriter")String rWriter,
			@RequestParam("rPassword")String rPassword, @RequestParam("rContent")String rContent) {
		
		System.out.println("bId() : " + bId);
		System.out.println("rId() : " + rId); // 들어가게 고쳐야 함.
		System.out.println("rWriter() : " + rWriter);
		System.out.println("rPassword() : " + rPassword);
		System.out.println("rContent() : " + rContent);
		System.out.println("success?");
		
	}
	
	/*@RequestMapping(value="/test1234", method=RequestMethod.POST)	// 실험용
	public void test2(@RequestBody ReplyDto rDto ) {
		
		System.out.println("bId() : " + rDto.getbId());
		System.out.println("rId() : " + rId); // 들어가게 고쳐야 함.
		System.out.println("rWriter() : " + rDto.getrWriter());
		System.out.println("rPassword() : " + rDto.getrPassword());
		System.out.println("rContent() : " + rDto.getrContent());
		System.out.println("success?");
		
	}*/
	
}
