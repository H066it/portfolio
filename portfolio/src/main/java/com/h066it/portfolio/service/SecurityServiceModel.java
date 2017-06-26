package com.h066it.portfolio.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.support.TransactionTemplate;

import com.h066it.portfolio.dto.MemberDto;

public class SecurityServiceModel implements UserDetailsService {

	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private TransactionTemplate TransactionTemplate; 
	
	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		MemberDto mDto;
		
		return null;
	}

}
