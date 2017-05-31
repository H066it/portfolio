package com.h066it.portfolio.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.h066it.portfolio.dto.Dto;
import com.h066it.portfolio.dto.FileDto;

public interface IDao {

	public ArrayList<Dto> count();	// 전체 게시글 수
	public ArrayList<Dto> list(@Param("firNum")int firNum, @Param("lstNum")int lstNum);
	public void write(@Param("bWriter")String bWriter, @Param("bTitle")String bTitle, @Param("bContent")String bContent);
	public void delete(@Param("bId")String bId);
	public Dto view(@Param("bId")String bId);
	public void update(@Param("bId")String bId, @Param("bWriter")String bWriter,
			@Param("bTitle")String bTitle, @Param("bContent")String bContent);
	public void countUpdate(@Param("bId")String bId);	// 조회 수 증가
	public ArrayList<Dto> searchCount(@Param("searchType")String searchType, @Param("keyword")String keyword); // 검색된 게시글 수
	public ArrayList<Dto> searchList(@Param("firNum")int firNum, @Param("lstNum")int lstNum,
			@Param("searchType")String searchType, @Param("keyword")String keyword);
	public void fileWrite(@Param("fName")String fName, @Param("rName")String rName, @Param("fSize")double fSize);
	public ArrayList<FileDto> fileView(@Param("bId")String bId);
	
}
