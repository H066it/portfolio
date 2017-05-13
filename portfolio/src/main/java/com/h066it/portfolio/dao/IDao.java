package com.h066it.portfolio.dao;

import java.util.ArrayList;

import com.h066it.portfolio.dto.Dto;

public interface IDao {

	public ArrayList<Dto> list();
	public void write(String bWriter, String bTitle, String bContent);
	public void delete(String bId);
	public Dto view(String bId);
	
}
