package com.h066it.portfolio.dto;

import java.sql.Timestamp;

public class ReplyDto {

	private int gId; // 게시판 그룹 번호
	private int bId; // 게시글 번호
	private int rId; // 리플 번호
	private String rWriter; // 리플 작성자
	private String rPassword; // 리플 비밀번호
	private String rContent; // 리플 내용
	private Timestamp rDate; // 리플 작성일
	private int rDelete; // 리플 삭제 유무 확인(0 = 무, 1 = 유)
	private int rGroup; // 리플 정렬용 묶음
	private int rDepth; // 리플 깊이
	private int rIndent; // 리플 들여 쓰기

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
