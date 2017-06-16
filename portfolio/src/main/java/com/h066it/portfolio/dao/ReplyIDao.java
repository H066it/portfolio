package com.h066it.portfolio.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.h066it.portfolio.dto.ReplyDto;

public interface ReplyIDao {

	/*리플 관련*/
	public void replyWrite(@Param("rDto")ReplyDto rDto);
	public void replyWriteOnBoard(@Param("bId")int bId, @Param("rWriter")String rWriter,
			@Param("rPassword")String rPassword, @Param("rContent")String rContent);
	public int replyDepthChk(@Param("bId")int bId, @Param("rGroup")int rGroup,
			@Param("rDepth")int rDepth, @Param("rIndent")int rIndent);
	public ArrayList<ReplyDto> replyView(@Param("bId")String bId);
	
	public int getIndent(@Param("bId")int bId, @Param("rId")int rId);
	public int getDepth(@Param("bId")int bId, @Param("rId")int rId);
	public int depthDown(@Param("bId")int bId, @Param("rGroup")int rGroup);
	public void depthSort(@Param("bId")int bId, @Param("rId")int rId, @Param("rGroup")int rGroup, @Param("rDepth")int rDepth);
	public void replyWriteOnReply(@Param("bId")int bId, @Param("rWriter")String rWriter,
			@Param("rPassword")String rPassword, @Param("rContent")String rContent,
			@Param("rGroup")int rGroup,	@Param("rDepth")int rDepth, @Param("rIndent")int rIndent);
	
}
