package com.h066it.portfolio.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.h066it.portfolio.dao.IDao;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	private SqlSession sqlSession;

	/*
	 * private static final Logger logger =
	 * LoggerFactory.getLogger(HomeController.class);
	 * 
	 *//**
		 * Simply selects the home view to render by returning its name.
		 *//*
		 * @RequestMapping(value = "/", method = RequestMethod.GET) public
		 * String home(Locale locale, Model model) {
		 * logger.info("Welcome home! The client locale is {}.", locale);
		 * 
		 * Date date = new Date(); DateFormat dateFormat =
		 * DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG,
		 * locale);
		 * 
		 * String formattedDate = dateFormat.format(date);
		 * 
		 * model.addAttribute("serverTime", formattedDate );
		 * 
		 * return "home"; }
		 */

	@RequestMapping("/list")
	public String list(Model model) {

		System.out.println("list");
		IDao dao = sqlSession.getMapper(IDao.class);
		model.addAttribute("list", dao.list());

		return "list";
	}

	@RequestMapping("/writeForm")
	public String writeForm(HttpServletRequest request, Model model) {

		System.out.println("writeForm");
		return "writeForm";
	}

	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {

		System.out.println("write");
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.write(request.getParameter("bWriter"), request.getParameter("bTitle"), request.getParameter("bContent"));

		return "redirect:list";
	}

	@RequestMapping("/view")
	public String view(HttpServletRequest request, Model model) {

		System.out.println("view");
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.countUpdate(request.getParameter("bId"));		// ��ȸ��
		model.addAttribute("dto", dao.view(request.getParameter("bId")));

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
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.update(request.getParameter("bId"), request.getParameter("bWriter"), request.getParameter("bTitle"),
				request.getParameter("bContent"));

		return "redirect:list";
	}

	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {

		System.out.println("delete");
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.delete(request.getParameter("bId"));

		return "redirect:list";
	}
}
