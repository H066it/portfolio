package com.h066it.portfolio.dto;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Dto {

	private int gId; // 게시판 그룹 번호
	private int bId; // 게시글 번호
	private String bWriter; // 작성자
	private String bPassword; // 비밀번호
	private String bTitle; // 제목
	private String bContent; // 내용
	private Timestamp bDate; // 작성일
	private int bCount; // 조회수
	private List<MultipartFile> upFile; // 연결된 파일 목록
	private int fileCheck; // 파일 유무 확인 (0 = 무, 1 = 유)
	private int replyCount; // 리플 수

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
