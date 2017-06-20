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
			<h3 id="myModalLabel">수정</h3>
		</div>
		<form action="pwdChk?mod=mod" method="post" class="form-horizontal">
			<div class="modal-body">
				<input type="hidden" id="bIdForModify" name="bId" value="${param.bId }" />
				<div class="control-group">
					<label class="control-label">비밀번호</label>
					<div class="controls">
						<input type="password" id="bPasswordForModify" name="bPassword"
							placeholder="비밀번호를 입력해주세요." style="width: 90%;">
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button class="btn btn-primary" onclick="return modifyNullCheck()">확인</button>
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
		<form action="pwdChk?mod=del" method="post" class="form-horizontal">
			<div class="modal-body">
				<input type="hidden" id="bIdForDelete" name="bId" value="${param.bId }" />
				<div class="control-group">
					<label class="control-label">비밀번호</label>
					<div class="controls">
						<input type="password" id="bPasswordForDelete" name="bPassword"
							placeholder="비밀번호를 입력해주세요." style="width: 90%;">
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button class="btn btn-primary" onclick="return deleteNullCheck()">확인</button>
				<button class="btn" data-dismiss="modal" aria-hidden="true">취소</button>
			</div>
		</form>
	</div>

</body>
</html>