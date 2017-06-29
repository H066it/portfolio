package com.h066it.portfolio.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	private ServiceModel service;	// Model(Service)�� Controller ����.

	@RequestMapping("/list")
	public String list(HttpServletRequest request, PageVo pageVo, Model model, Authentication auth) {

		if(auth != null) {	// id ����.
			model.addAttribute("auth", auth.getName());
		}
		
		String gId = request.getParameter("gId");	// gId ����.
	
		if(gId == null) {
			gId = "1";
		}
		model.addAttribute("gId", gId);
				
		System.out.println("count : " + service.count(gId).size());
		pageVo.calPage(service.count(gId).size());
		model.addAttribute("pageVo", pageVo);
		
		System.out.println("list");
		model.addAttribute("list", service.list(gId, pageVo.getFirNum(), pageVo.getLstNum()));
		
		if(request.getParameter("signUpRst") != null) {	// ȸ������ �޼��� ��
			model.addAttribute("signUpRst", request.getParameter("signUpRst"));
		}
		
		return "list";
	}

	@RequestMapping("/form")
	public String form(HttpServletRequest request, Dto dto, Model model) {

		String gId = request.getParameter("gId");
		String bId = request.getParameter("bId");
		
		if(bId == null || bId.equals("null") || bId.equals("")) {
			System.out.println("writeForm");
		} else {
			System.out.println("updateForm");
			List<FileDto> fileList = service.fileView(gId, bId);			
			model.addAttribute("files", fileList);
		}
		model.addAttribute("gId", gId);
		model.addAttribute("bId", bId);
		
		return "form";
	}

	@RequestMapping("/write")
	public String write(Dto dto, Model model) {

		FileUtil fu = new FileUtil();
		List<FileDto> fileList = fu.saveFiles(dto.getUpFile());	// ���� ������ Ʈ������̶� �������.(DB ���Ἲ�� �߿�)

		if(fileList.size() == 0) {	// file ��, �� üũ
			dto.setFileCheck(0);
		} else {
			dto.setFileCheck(1);
		}
		
		service.writeWithFile(dto, fileList);
		
		return "redirect:list";
	}

	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {

		String gId = request.getParameter("gId");
		String bId = request.getParameter("bId");
		
		List<FileDto> fileList = service.fileView(gId, bId);
		service.deleteWithFile(gId, bId, fileList);

		return "redirect:list";
	}
	
	@RequestMapping("/view")
	public String view(HttpServletRequest request, Model model) {

		System.out.println("view");
		
		String gId = request.getParameter("gId");
		String bId = request.getParameter("bId");
		
		service.countUpdate(gId, bId);		// ��ȸ��
		model.addAttribute("dto", service.view(gId, bId));
		model.addAttribute("files", service.fileView(gId, bId));

		List<ReplyDto> replyList = service.replyView(gId, bId);
		model.addAttribute("replys", replyList);
		
		return "view";
	}

	@RequestMapping("/update")
	public String update(HttpServletRequest request, Dto dto, Model model) {
		
		FileUtil fu = new FileUtil();
		List<FileDto> fileList = fu.saveFiles(dto.getUpFile());	// ���� ������ Ʈ������̶� �������.(DB ���Ἲ�� �߿�)

		if(fileList.size() == 0) {	// file ��, �� üũ
			dto.setFileCheck(0);
		} else {
			dto.setFileCheck(1);
		}
		
		String[] fIds = request.getParameterValues("fId");
		
		service.updateeWithFile(dto, fileList, fIds);

		return "redirect:list";
	}
	
	@RequestMapping("/search")
	public String search(PageVo pageVo, HttpServletRequest request, Model model, Authentication auth) {
		
		if(auth != null) {	// id ����.
			model.addAttribute("auth", auth.getName());
		}
		
		String gId = request.getParameter("gId");
		String searchType = request.getParameter("searchType");
		String keyword = request.getParameter("keyword");
		
		System.out.println("searchCount");
		
		if(searchType.equals("rContent")) {		// ���� �˻�
			ArrayList<Dto> bIds = service.searchReplyBIdCount(gId, searchType, keyword);	// �ش� ������ �ִ� DISTINCT(bId) �˻�
			System.out.println(bIds.size());
			pageVo.calPage(bIds.size());
			model.addAttribute("pageVo", pageVo);
			
			ArrayList<Dto> dtos = new ArrayList<Dto>();	// ������ ������ NullPointerException �߻��ϴ� ����.			
			
			System.out.println("searchReplyBIdList");
			if(bIds.size() != 0) {	// ���þ��� �� ���� ����.
				for(int i = pageVo.getFirNum() - 1 ; i < pageVo.getLstNum() ; i++) {				
					Dto dto = service.searchReplyBIdList(Integer.parseInt(gId), bIds.get(i).getbId());
					dtos.add(dto);
				}
			}
			model.addAttribute("list", dtos);
			
		} else {								// �� �� ��� �˻�
			System.out.println(service.searchCount(gId, searchType, keyword).size());
			pageVo.calPage(service.searchCount(gId, searchType, keyword).size());
			model.addAttribute("pageVo", pageVo);
	
			System.out.println("searchList");
			model.addAttribute("list",service.searchList(gId, pageVo.getFirNum(), pageVo.getLstNum(), searchType, keyword));
		}
		model.addAttribute("gId", gId);
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
		model.addAttribute("gId", dto.getgId());
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
