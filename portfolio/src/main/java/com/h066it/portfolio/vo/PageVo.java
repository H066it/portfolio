package com.h066it.portfolio.vo;

public class PageVo {

	private int displayNum = 5;	// �� �������� ���̴� �Խñ� ����
	private int totalNum;	// ��ü �Խñ� ��
	private int totalPageNum; // ��ü ������ ��
	private int firNum, lstNum;	// �� ������ �� ����, �� �Խñ� ��ȣ
	private int firPageNum, lstPageNum;	// ��ü�� ����, �� ������ ��ȣ
	private int page = 1;	// ���� ������ (1�� �׽�Ʈ��)
	
	public void calPage(int total) {
		
		getPage();
		System.out.println("page : " + page);
		setTotalNum(total);
		setTotalPageNum((int)Math.ceil((float)total/displayNum));

		setFirPageNum(1);
		if(page % 10 == 1) setFirPageNum(page);
		
		setLstPageNum(firPageNum + 9);
		if(lstPageNum > totalPageNum) setLstPageNum(totalPageNum);
		
		setFirNum(1 + (getPage() - 1)*getDisplayNum());
		if(firNum > totalNum) setFirNum(totalNum);
		System.out.println("firNum :" + firNum);
		setLstNum(page*getDisplayNum());
		if(lstNum > totalNum) setLstNum(totalNum);
		System.out.println("lstNum :" + lstNum);
		
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
