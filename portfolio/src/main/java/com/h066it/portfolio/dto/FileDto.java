package com.h066it.portfolio.dto;

public class FileDto {

	private int fId;	// 파일 번호
	private int gId;	// 게시판 그룹 번호
	private int bId;	// 게시글 번호
	private String fName;	// 저장되는 파일 이름
	private String rName;	// 실제 파일 이름
	private double fSize;	// 파일 크기
	
	public int getfId() {
		return fId;
	}

	public void setfId(int fId) {
		this.fId = fId;
	}

	public int getgId() {
		return gId;
	}

	public void setgId(int gId) {
		this.gId = gId;
	}

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getrName() {
		return rName;
	}

	public void setrName(String rName) {
		this.rName = rName;
	}

	public double getfSize() {
		return fSize;
	}

	public void setfSize(double fSize) {
		this.fSize = fSize;
	}

}
