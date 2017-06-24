package com.h066it.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.h066it.portfolio.service.ServiceModel;

@Controller
public class SecurityContoroller {

	@Autowired
	private ServiceModel service;	// Model(Service)°ú Controller ³ª´®.
	
	@RequestMapping("/login")
	public String login() {
		
		return "security/login";
	}
	
}
