package com.h066it.portfolio.dto;

import java.text.DecimalFormat;

public class FileDto {

	private int fId;	// 파일 번호
	private int gId;	// 게시판 그룹 번호
	private int bId;	// 게시글 번호
	private String fName;	// 저장되는 파일 이름
	private String rName;	// 실제 파일 이름
	private double fSize;	// 파일 크기
	
	public String sizeCalculation(double fSize) {	// 글 내용에 표시되는 파일 용량 계산.
		
		double kSize = fSize / 1024;	// KB
		double mSize = fSize / 1024 / 1024;	// MB
		
		DecimalFormat fmt = new DecimalFormat("#0.##");

		if(mSize < 0.1) {	// 100KB 미만은 KB로 표시 이상은 MB로 표시
			String kResult = fmt.format(kSize) + "KB";
			System.out.println("kResult : " + kResult);
			return kResult;
		}
		
		String mResult = fmt.format(mSize) + "MB";	// format의 결과 형은 String이다.
		System.out.println("mResult :" + mResult);
		
		return mResult;
	}
	
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
