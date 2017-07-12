package com.h066it.portfolio.dto;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Dto {

	private int gId; // �Խ��� �׷� ��ȣ
	private int bId; // �Խñ� ��ȣ
	private String bWriter; // �ۼ���
	private String bPassword; // ��й�ȣ
	private String bTitle; // ����
	private String bContent; // ����
	private Timestamp bDate; // �ۼ���
	private int bCount; // ��ȸ��
	private List<MultipartFile> upFile; // ����� ���� ���
	private int fileCheck; // ���� ���� Ȯ�� (0 = ��, 1 = ��)
	private int replyCount; // ���� ��

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

	public String getbPassword() {
		return bPassword;
	}

	public void setbPassword(String bPassword) {
		this.bPassword = bPassword;
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

	public List<MultipartFile> getUpFile() {
		return upFile;
	}

	public void setUpFile(List<MultipartFile> upFile) {
		this.upFile = upFile;
	}

	public int getFileCheck() {
		return fileCheck;
	}

	public void setFileCheck(int fileCheck) {
		this.fileCheck = fileCheck;
	}
	
	public int getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}

}
