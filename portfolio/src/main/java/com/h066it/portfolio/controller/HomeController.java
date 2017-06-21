package com.h066it.portfolio.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.h066it.portfolio.dto.Dto;
import com.h066it.portfolio.dto.FileDto;
import com.h066it.portfolio.dto.ReplyDto;
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
	public String write(Dto dto, Model model) {

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
		
		String bId = request.getParameter("bId");
		
		service.countUpdate(bId);		// 조회수
		model.addAttribute("dto", service.view(bId));
		model.addAttribute("files", service.fileView(bId));

		List<ReplyDto> replyList = service.replyView(bId);
		model.addAttribute("replys", replyList);
		
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
		
		String searchType = request.getParameter("searchType");
		String keyword = request.getParameter("keyword");
		
		System.out.println("searchCount");
		
		if(searchType.equals("rContent")) {		// 리플 검색
			ArrayList<Dto> bIds = service.searchReplyBIdCount(searchType, keyword);	// 해당 리플이 있는 DISTINCT(bId) 검색
			System.out.println(bIds.size());
			pageVo.calPage(bIds.size());
			model.addAttribute("pageVo", pageVo);
			
			ArrayList<Dto> dtos = new ArrayList<Dto>();	// 생성자 없으면 NullPointerException 발생하니 주의.			
			
			System.out.println("searchReplyBIdList");
			for(int i = pageVo.getFirNum() - 1 ; i < pageVo.getLstNum() ; i++) {				
				Dto dto = service.searchReplyBIdList(bIds.get(i).getbId());
				dtos.add(dto);
			}
			
			model.addAttribute("list", dtos);
			
		} else {								// 그 외 모든 검색
			System.out.println(service.searchCount(searchType, keyword).size());
			pageVo.calPage(service.searchCount(searchType, keyword).size());
			model.addAttribute("pageVo", pageVo);
	
			System.out.println("searchList");
			model.addAttribute("list",service.searchList(pageVo.getFirNum(), pageVo.getLstNum(), searchType, keyword));
		}
		
		model.addAttribute("searchType", searchType);
		model.addAttribute("keyword", keyword);

		return "list";
	}
	
	@RequestMapping("/fileDownload")
	public void fileDownload(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("fileDownload");
		service.fileDownload(request, response);	
	
	}
	
	@RequestMapping("/pwdChk")
	public String pwdChk(HttpServletRequest request, Dto dto, Model model) {
		
		System.out.println("pwdChk");
		String mod = request.getParameter("mod");
		System.out.println("mod :" + mod);

		String pwd = service.pwdChk(dto.getgId(), dto.getbId());
				
		boolean rst = dto.getbPassword().equals(pwd);
		model.addAttribute("bId", dto.getbId());
				
		if(rst == true) {
			System.out.println("true");
			
			if(mod.equals("mod")) {
				return "redirect:form";
			}
			return "redirect:delete";
		}
		
		System.out.println("false");
		model.addAttribute("pwdChk", rst);
		
		if(mod.equals("mod")) {
			return "redirect:view";
		}
		return "redirect:list";
	}	
	
}
