package com.h066it.portfolio.dto;

public class FileDto {

	private int fId;	// ���� ��ȣ
	private int gId;	// �Խ��� �׷� ��ȣ
	private int bId;	// �Խñ� ��ȣ
	private String fName;	// ����Ǵ� ���� �̸�
	private String rName;	// ���� ���� �̸�
	private double fSize;	// ���� ũ��
	
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
