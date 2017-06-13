<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- Reply Write On Reply -->

	<div id="replyWriteOnReply" class="modal hide fade" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">x</button>
			<h3 id="myModalLabel">답글</h3>
		</div>
		<form action="test123" method="post" class="form-horizontal">
			<div class="modal-body">
				<input type="hidden" id="bIdOnReply" name="bId" value="${param.bId }" />
				<input type="hidden" id="rIdOnReply" name="rId" valye="${param.rId }"/>
				<div class="control-group">
					<label class="control-label">작성자</label>
					${param.bId },${param.rId },<%=request.getParameter("rId") %>|
				<c:forEach items="${replys }" var="reply">${reply.rId }</c:forEach>
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
							style="resize: none; width: 90%;"></textarea>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<!-- <button class="btn btn-primary"
					onclick="return replyOnReplyNullCheck();">작성</button> -->
				<input type="submit" class="btn btn-primary" value="작성" onclick="return replyOnReplyNullCheck()"></input>
				<button class="btn" data-dismiss="modal" aria-hidden="true">취소</button>
			</div>
		</form>
	</div>



	<!-- Reply Update -->

	<div id="replyUpdate" class="modal hide fade" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">x</button>
			<h3 id="myModalLabel">수정</h3>
		</div>
		<form action="replyWrite" method="post" class="form-horizontal">
			<div class="modal-body">
				<input type="hidden" name="bId" value="${param.bId }" /> <input
					type="hidden" name="rId" value="${param.rId }" />
				<div class="control-group">
					<label class="control-label">작성자</label>
					<div class="controls">
						<input type="text" name="rWriter" style="width: 90%;">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">비밀번호</label>
					<div class="controls">
						<input type="password" name="rPassword" style="width: 90%;">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">내용</label>
					<div class="controls">
						<textarea name="rContent" cols="30" rows="5"
							style="resize: none; width: 90%;"></textarea>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button class="btn btn-primary">수정</button>
				<button class="btn" data-dismiss="modal" aria-hidden="true">취소</button>
			</div>
		</form>
	</div>


	<!-- Reply Delete -->

	<div id="replyDelete" class="modal hide fade" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">x</button>
			<h3 id="myModalLabel">삭제</h3>
		</div>
		<form action="replyWrite" method="post" class="form-horizontal">
			<div class="modal-body">
				<input type="hidden" name="bId" value="${param.bId }" /> <input
					type="hidden" name="rId" value="${param.rId }" />
				<div class="control-group">
					<label class="control-label">비밀번호</label>
					<div class="controls">
						<input type="password" name="rPassword" style="width: 90%;">
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button class="btn btn-primary">확인</button>
				<button class="btn" data-dismiss="modal" aria-hidden="true">취소</button>
			</div>
		</form>
	</div>

</body>
</html>