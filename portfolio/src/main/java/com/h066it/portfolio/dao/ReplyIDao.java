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
}
