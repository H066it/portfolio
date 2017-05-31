package com.h066it.portfolio.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.h066it.portfolio.dto.Dto;
import com.h066it.portfolio.dto.FileDto;
import com.h066it.portfolio.fileUtil.FileUtil;
import com.h066it.portfolio.service.ServiceModel;
import com.h066it.portfolio.vo.PageVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	private ServiceModel service;	// Model(Service)과 Controller 나눔.

	@RequestMapping("/list")
	public String list(PageVo pageVo, Model model) {

		System.out.println("count : " + service.count().size());
		pageVo.calPage(service.count().size());
		model.addAttribute("pageVo", pageVo);
		
		System.out.println("list");
		model.addAttribute("list", service.list(pageVo.getFirNum(), pageVo.getLstNum()));
		
		return "list";
	}

	@RequestMapping("/writeForm")
	public String writeForm(HttpServletRequest request, Model model) {

		System.out.println("writeForm");
		
		return "writeForm";
	}

	@RequestMapping("/write")
	public String write(HttpServletRequest request, Dto dto, Model model) {

		System.out.println("write");
		service.write(request.getParameter("bWriter"), request.getParameter("bTitle"), request.getParameter("bContent"));

		FileUtil fu = new FileUtil();
		List<FileDto> fileList = fu.saveFiles(dto.getUpFile());

		System.out.println("fileList : " + fileList);
		for(FileDto file : fileList) {	// DB에 저장되는거 만들기.
	
			System.out.println("file.getfName() : " + file.getfName());
			System.out.println("file.getrName() : " + file.getrName());
			System.out.println("file.getfSize() : " + file.getfSize());
			
			service.fileWrite(file.getfName(), file.getrName(), file.getfSize());
		}
		
		return "redirect:list";
	}

	@RequestMapping("/view")
	public String view(HttpServletRequest request, Model model) {

		System.out.println("view");
		service.countUpdate(request.getParameter("bId"));		// 조회수
		model.addAttribute("dto", service.view(request.getParameter("bId")));
		model.addAttribute("files", service.fileView(request.getParameter("bId")));

		return "view";
	}

	@RequestMapping("/updateForm")
	public String updateForm(HttpServletRequest request, Model model) {

		System.out.println("updateForm");

		return "updateForm";
	}

	@RequestMapping("/update")
	public String update(HttpServletRequest request, Model model) {

		System.out.println("update");
		service.update(request.getParameter("bId"), request.getParameter("bWriter"), request.getParameter("bTitle"),
				request.getParameter("bContent"));

		return "redirect:list";
	}

	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {

		System.out.println("delete");
		service.delete(request.getParameter("bId"));

		return "redirect:list";
	}
	
	@RequestMapping("/search")
	public String search(PageVo pageVo, HttpServletRequest request, Model model) {
		
		System.out.println("searchCount");
		System.out.println(service.searchCount(request.getParameter("searchType"), request.getParameter("keyword")).size());
		pageVo.calPage(service.searchCount(request.getParameter("searchType"), request.getParameter("keyword")).size());
		model.addAttribute("pageVo", pageVo);

		System.out.println("searchList");
		model.addAttribute("list",service.searchList(pageVo.getFirNum(), pageVo.getLstNum(), request.getParameter("searchType"), request.getParameter("keyword")));
		model.addAttribute("searchType", request.getParameter("searchType"));
		model.addAttribute("keyword", request.getParameter("keyword"));
		
		return "list";
	}
}
