package com.h066it.portfolio.dto;

import java.sql.Timestamp;

public class Dto {

	private int gId; // �׷� �Խ��� ��ȣ
	private int bId; // �Խ��� ��ȣ
	private String bWriter; // �ۼ���
	private String bTitle; // ����
	private String bContent; // ����
	private Timestamp bDate; // �ۼ���
	private int bCount; // ��ȸ��

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

	public String getbWriter() {
		return bWriter;
	}

	public void setbWriter(String bWriter) {
		this.bWriter = bWriter;
	}

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public String getbContent() {
		return bContent;
	}

	public void setbContent(String bContent) {
		this.bContent = bContent;
	}

	public Timestamp getbDate() {
		return bDate;
	}

	public void setbDate(Timestamp bDate) {
		this.bDate = bDate;
	}	

	public int getbCount() {
		return bCount;
	}

	public void setbCount(int bCount) {
		this.bCount = bCount;
	}

}
