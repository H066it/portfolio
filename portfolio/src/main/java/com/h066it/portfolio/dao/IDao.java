package com.h066it.portfolio.dao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;

import com.h066it.portfolio.dto.Dto;
import com.h066it.portfolio.dto.FileDto;

public interface IDao {

	/*CRUD 관련*/
	public ArrayList<Dto> count(@Param("gId")String gId);	// 전체 게시글 수
	public ArrayList<Dto> list(@Param("gId")String gId, @Param("firNum")int firNum, @Param("lstNum")int lstNum);
	public void write(@Param("gId")int gId, @Param("bWriter")String bWriter, @Param("bPassword")String bPassword,
			@Param("bTitle")String bTitle, @Param("bContent")String bContent, @Param("fileCheck")int fileCheck);
	public void delete(@Param("gId")String gId, @Param("bId")String bId);
	public Dto view(@Param("gId")String gId, @Param("bId")String bId);
	public void update(@Param("gId")String gId, @Param("bId")String bId, @Param("bWriter")String bWriter,
			@Param("bTitle")String bTitle, @Param("bContent")String bContent, @Param("fileCheck")int fileCheck);
	public void countUpdate(@Param("gId")String gId, @Param("bId")String bId);	// 조회 수 증가
	
	/*검색 관련*/
	public ArrayList<Dto> searchCount(@Param("gId")String gId, @Param("searchType")String searchType,
			@Param("keyword")String keyword); // 검색된 게시글 수
	public ArrayList<Dto> searchList(@Param("gId")String gId, @Param("firNum")int firNum, @Param("lstNum")int lstNum,
			@Param("searchType")String searchType, @Param("keyword")String keyword);
	public ArrayList<Dto> searchReplyBIdCount(@Param("gId")String gId, @Param("searchType")String searchType,
			@Param("keyword")String keyword);
	public Dto searchReplyBIdList(@Param("gId")int gId, @Param("bIds")int bIds);
	
	/*file 관련*/
	public void fileWrite(@Param("gId")int gId, @Param("fName")String fName,
			@Param("rName")String rName, @Param("fSize")double fSize);
	public void fileDelete(@Param("gId")String gId, @Param("fId")String fId);
	public ArrayList<FileDto> fileView(@Param("gId")String gId, @Param("bId")String bId);
	public void fileUpdate(@Param("gId")int gId, @Param("bId")int bId, @Param("fName")String fName,
			@Param("rName")String rName, @Param("fSize")double fSize);
	// ServiceModel만 쓸거면 없어도 무방. ->
	public void fileDownload(HttpServletRequest request, HttpServletResponse response);
	public void writeWithFile(@Param("dto")Dto dto, @Param("fileList")List<FileDto> fileList);
	public void deleteWithFile(@Param("gId")String gId, @Param("bId")String bId , @Param("fileList")List<FileDto> fileList);
	public void updateeWithFile(@Param("dto")Dto dto, @Param("fileList")List<FileDto> fileList, @Param("fIds")String[] fIds);
	// <- ServiceModel만 쓸거면 없어도 무방.
	
	/*게시글 수정, 삭제시 비밀번호 확인*/
	public String pwdChk(@Param("gId")int gId, @Param("bId")int bId);
	
}
