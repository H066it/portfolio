package com.h066it.portfolio.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

	@RequestMapping("/form")
	public String form(HttpServletRequest request, Model model) {

		String bId = request.getParameter("bId");
		
		if(bId == null || bId.equals("null") || bId.equals("")) {
			System.out.println("writeForm");
		} else {
			System.out.println("updateForm");
			List<FileDto> fileList = service.fileView(bId);
			model.addAttribute("files", fileList);
		}
		model.addAttribute("bId", bId);
		
		return "form";
	}

	@RequestMapping("/write")
	public String write(HttpServletRequest request, Dto dto, Model model) {

		FileUtil fu = new FileUtil();
		List<FileDto> fileList = fu.saveFiles(dto.getUpFile());	// 실제 저장은 트랜잭션이랑 상관없음.(DB 무결성이 중요)

		if(fileList.size() == 0) {	// file 유, 무 체크
			dto.setFileCheck(0);
		} else {
			dto.setFileCheck(1);
		}
		
		service.writeWithFile(dto, fileList);
		
		return "redirect:list";
	}

	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {

		String bId = request.getParameter("bId");
		
		List<FileDto> fileList = service.fileView(bId);
		service.deleteWithFile(bId, fileList);

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

	@RequestMapping("/update")
	public String update(HttpServletRequest request, Dto dto, Model model) {
		
		FileUtil fu = new FileUtil();
		List<FileDto> fileList = fu.saveFiles(dto.getUpFile());	// 실제 저장은 트랜잭션이랑 상관없음.(DB 무결성이 중요)

		if(fileList.size() == 0) {	// file 유, 무 체크
			dto.setFileCheck(0);
		} else {
			dto.setFileCheck(1);
		}
		
		String[] fIds = request.getParameterValues("fId");
		
		service.updateeWithFile(dto, fileList, fIds);

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
	
	@RequestMapping("/fileDownload")
	public void fileDownload(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("fileDownload");
		service.fileDownload(request, response);	
	
	}
	
}
