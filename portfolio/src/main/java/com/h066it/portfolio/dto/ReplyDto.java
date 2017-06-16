package com.h066it.portfolio.dto;

import java.sql.Timestamp;

public class ReplyDto {

	private int gId; // �Խ��� �׷� ��ȣ
	private int bId; // �Խñ� ��ȣ
	private int rId; // ���� ��ȣ
	private String rWriter; // ���� �ۼ���
	private String rPassword; // ���� ��й�ȣ
	private String rContent; // ���� ����
	private Timestamp rDate; // ���� �ۼ���
	private int rDelete; // ���� ���� ���� Ȯ��(0 = ��, 1 = ��)
	private int rGroup; // ���� ���Ŀ� ����
	private int rDepth; // ���� ����
	private int rIndent; // ���� �鿩 ����

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

	public int getrId() {
		return rId;
	}

	public void setrId(int rId) {
		this.rId = rId;
	}

	public String getrWriter() {
		return rWriter;
	}

	public void setrWriter(String rWriter) {
		this.rWriter = rWriter;
	}

	public String getrPassword() {
		return rPassword;
	}

	public void setrPassword(String rPassword) {
		this.rPassword = rPassword;
	}

	public String getrContent() {
		return rContent;
	}

	public void setrContent(String rContent) {
		this.rContent = rContent;
	}

	public Timestamp getrDate() {
		return rDate;
	}

	public void setrDate(Timestamp rDate) {
		this.rDate = rDate;
	}

	public int getrDelete() {
		return rDelete;
	}

	public void setrDelete(int rDelete) {
		this.rDelete = rDelete;
	}

	public int getrGroup() {
		return rGroup;
	}

	public void setrGroup(int rGroup) {
		this.rGroup = rGroup;
	}

	public int getrDepth() {
		return rDepth;
	}

	public void setrDepth(int rDepth) {
		this.rDepth = rDepth;
	}

	public int getrIndent() {
		return rIndent;
	}

	public void setrIndent(int rIndent) {
		this.rIndent = rIndent;
	}

}
