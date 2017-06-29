<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

	<!-- Reply Write On Reply -->

	<div id="replyWriteOnReply" class="modal hide fade" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
			<h3 id="myModalLabel">답글</h3>
		</div>
		<form action="replyWrite" method="post" class="form-horizontal">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<input type="hidden" name="gId" value="${dto.gId }" />
			<div class="modal-body">
				<input type="hidden" id="bIdOnReply" name="bId" value="${param.bId }" />
				<input type="hidden" id="rIdOnReply" name="rId" value="${param.rId }"/>
				<input type="hidden" id="rGroupOnReply" name="rGroup" value="${param.rGroup }"/>
				<div class="control-group">
					<label class="control-label">작성자</label>				
					<div class="controls">
						<input type="text" id="rWriterOnReply" name="rWriter"
							style="width: 90%;">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">비밀번호</label>
					<div class="controls">
						<input type="password" id="rPasswordOnReply" name="rPassword"
							style="width: 90%;">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">내용</label>
					<div class="controls">
						<textarea id="rContentOnReply" name="rContent" cols="30" rows="5"
							placeholder="답글 내용을 입력해주세요." style="resize: none; width: 90%;"></textarea>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button class="btn btn-primary"	onclick="return replyOnReplyNullCheck()">작성</button>
				<button class="btn" data-dismiss="modal" aria-hidden="true">취소</button>
			</div>
		</form>
	</div>



	<!-- Reply Update -->

	<div id="replyUpdateOnReply" class="modal hide fade" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
			<h3 id="myModalLabel">수정</h3>
		</div>
		<form action="replyUpdate" method="post" class="form-horizontal">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<input type="hidden" name="gId" value="${dto.gId }" />
			<div class="modal-body">
				<input type="hidden" id="bIdOnUpdate" name="bId" value="${param.bId }" />
				<input type="hidden" id="rIdOnUpdate" name="rId" value="${param.rId }"/>
				<input type="hidden" id="rGroupOnUpdate" name="rGroup" value="${param.rGroup }"/>
				<div class="control-group">
					<label class="control-label">작성자</label>
					<div class="controls">
						<input type="text" id="rWriterOnUpdate" name="rWriter" style="width: 90%;">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">비밀번호</label>
					<div class="controls">
						<input type="password" id="rPasswordOnUpdate" name="rPassword" style="width: 90%;">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">내용</label>
					<div class="controls">
						<textarea id="rContentOnUpdate" name="rContent" cols="30" rows="5"
							placeholder="수정 내용을 입력해주세요." style="resize: none; width: 90%;"></textarea>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button class="btn btn-primary" onclick="return replyOnUpdateNullCheck()">수정</button>
				<button class="btn" data-dismiss="modal" aria-hidden="true">취소</button>
			</div>
		</form>
	</div>


	<!-- Reply Delete -->

	<div id="replyDeleteOnReply" class="modal hide fade" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
			<h3 id="myModalLabel">삭제</h3>
		</div>
		<form action="replyDelete" method="post" class="form-horizontal">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<input type="hidden" name="gId" value="${dto.gId }" />
			<div class="modal-body">
				<input type="hidden" id="bIdOnDelete" name="bId" value="${param.bId }" />
				<input type="hidden" id="rIdOnDelete" name="rId" value="${param.rId }"/>
				<input type="hidden" id="rGroupOnDelete" name="rGroup" value="${param.rGroup }"/>
				<div class="control-group">
					<label class="control-label">비밀번호</label>
					<div class="controls">
						<input type="password" id="rPasswordOnDelete" name="rPassword"
							placeholder="비밀번호를 입력해주세요." style="width: 90%;">
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button class="btn btn-primary" onclick="return replyOnDeleteNullCheck()">확인</button>
				<button class="btn" data-dismiss="modal" aria-hidden="true">취소</button>
			</div>
		</form>
	</div>

</body>
</html>