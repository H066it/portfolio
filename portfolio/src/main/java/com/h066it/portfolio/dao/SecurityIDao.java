package com.h066it.portfolio.dao;

import org.apache.ibatis.annotations.Param;

import com.h066it.portfolio.dto.MemberDto;

public interface SecurityIDao {

	/*회원가입 관련*/
	public boolean signUp(@Param("mDto")MemberDto mDto);
	public void signUpOnMember(@Param("id")String id, @Param("pwd")String pwd, @Param("nickName")String nickName);
	public void signUpOnAuthorities(@Param("id")String id);
	public String memberIdChk(@Param("id")String id);
	public String memberNickNameChk(@Param("nickName")String nickName);
	
}
