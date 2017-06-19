<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

	<!-- Modify -->

	<div id="modifyPwdChk" class="modal hide fade" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
			<h3 id="myModalLabel">삭제</h3>
		</div>
		<form action="replyDelete" method="post" class="form-horizontal">
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


	<!-- Delete -->

	<div id="deletePwdChk" class="modal hide fade" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
			<h3 id="myModalLabel">삭제</h3>
		</div>
		<form action="replyDelete" method="post" class="form-horizontal">
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