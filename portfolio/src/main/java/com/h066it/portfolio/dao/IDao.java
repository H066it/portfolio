package com.h066it.portfolio.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.h066it.portfolio.dto.Dto;

public interface IDao {

	public ArrayList<Dto> count();
	public ArrayList<Dto> list(int firNum, int lstNum);
	public void write(String bWriter, String bTitle, String bContent);
	public void delete(String bId);
	public Dto view(String bId);
	public void update(String bId, String bWriter, String bTitle, String bContent);
	public void countUpdate(String bId);
	public ArrayList<Dto> searchList(@Param("searchType")String searchType, @Param("keyword")String keyword);
	
}
