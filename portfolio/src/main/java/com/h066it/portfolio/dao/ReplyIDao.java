package com.h066it.portfolio.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.h066it.portfolio.dto.ReplyDto;

public interface ReplyIDao {

	/*리플 관련*/
	public void replyWrite(@Param("rDto")ReplyDto rDto);
	public void replyWriteOnBoard(@Param("bId")int bId, @Param("rWriter")String rWriter,
			@Param("rPassword")String rPassword, @Param("rContent")String rContent, @Param("lstReplyOrder")int lstReplyOrder);
	public int lastReplyOrder(@Param("bId")int bId);
	public ArrayList<ReplyDto> replyView(@Param("bId")String bId);
	
	public int getIndent(@Param("bId")int bId, @Param("rId")int rId);
	public int getOrder(@Param("bId")int bId, @Param("rId")int rId);
	public void orderSort(@Param("bId")int bId, @Param("order")int order);
	public void replyWriteOnReply(@Param("bId")int bId, @Param("rWriter")String rWriter,
			@Param("rPassword")String rPassword, @Param("rContent")String rContent,
			@Param("rIndent")int rIndent, @Param("rOrder")int rOrder);
}
