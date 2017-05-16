package com.h066it.portfolio.vo;

public class PageVo {

	private int displayNum = 5;	// 한 페이지당 보이는 게시글 개수
	private int totalNum;	// 전체 게시글 수
	private int totalPageNum; // 전체 페이지 수
	private int firNum, lstNum;	// 한 페이지 내 시작, 끝 게시글 번호
	private int firPageNum, lstPageNum;	// 전체의 시작, 끝 페이지 번호
	private int page = 1;	// 지금 페이지 (1은 테스트용)
	
	public void calPage(int total) {
		
		getPage();
		setTotalNum(total);
		setTotalPageNum((int)Math.ceil((float)total/displayNum));

		setFirPageNum(1);
		if(page % 10 == 1) setFirPageNum(page);
		
		setLstPageNum(firPageNum + 9);
		if(lstPageNum > totalPageNum) setLstPageNum(totalPageNum);
		
	}

	public int getDisplayNum() {
		return displayNum;
	}

	public void setDisplayNum(int displayNum) {
		this.displayNum = displayNum;
	}

	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}

	public int getTotalPageNum() {
		return totalPageNum;
	}

	public void setTotalPageNum(int totalPageNum) {
		this.totalPageNum = totalPageNum;
	}

	public int getFirNum() {
		return firNum;
	}

	public void setFirNum(int firNum) {
		this.firNum = firNum;
	}

	public int getLstNum() {
		return lstNum;
	}

	public void setLstNum(int lstNum) {
		this.lstNum = lstNum;
	}

	public int getFirPageNum() {
		return firPageNum;
	}

	public void setFirPageNum(int firPageNum) {
		this.firPageNum = firPageNum;
	}

	public int getLstPageNum() {
		return lstPageNum;
	}

	public void setLstPageNum(int lstPageNum) {
		this.lstPageNum = lstPageNum;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}	
	
}
