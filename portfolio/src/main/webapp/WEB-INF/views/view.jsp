<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ include file="/resources/assets/jsp/modal.jsp"%>
<%@ include file="/resources/assets/jsp/modalPwdChk.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/style.css" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="css/bootstrap-responsive.css" rel="stylesheet">
<title>freeeeeeeeeeboard</title>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/replyButtonRoles.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/submitRule.js"></script>
<script type="text/javascript" src="js/replySubmitRule.js"></script>
<script type="text/javascript" src="js/pwdChk.js"></script>
</head>
<body>
	
	<img src="/portfolio/img/귤은 귤귤하고 웁니다.png" class="img-circle" width="200px">

	<div id="signBar">
		<sec:authorize access="isAnonymous()">
			<a href="login"><input type="button" class="btn btn-link btn-small" value="로그인"/></a>
			<a href="signUpForm"><input type="button" class="btn btn-link btn-small" value="회원가입"/></a>
		</sec:authorize>	

		<sec:authorize access="hasRole('ROLE_USER')">
			<form action="logout" method="post" style="display: inline;">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				<input type="submit" class="btn btn-link btn-small" value="로그아웃"/>
			</form>
		</sec:authorize>
	</div>

	<div class="container-narrow">
		<div class="navbar">
			<div class="navbar-inner">
				<a class="brand" href="#">Title</a>
				<ul class="nav">
					<li class="divider-vertical"></li>
					<li class="active"><a href="list">익명판</a></li>
					<li class="divider-vertical"></li>
					<li><a href="#">Link</a></li>
					<li class="divider-vertical"></li>
					<li><a href="#">Link</a></li>
				</ul>
			</div>
		</div>

		<form action="form" method="post" class="form-horizontal">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<div class="form-horizontal">
				<input type="hidden" name="bId" value="${param.bId }" />
				<div class="control-group">
					<label class="control-label">작성자</label>
					<div class="controls">
						<input type="text" name="bWriter" value='${dto.bWriter }'
							readonly="readonly" style="width: 90%;">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">제목</label>
					<div class="controls">
						<input type="text" name="bTitle" value='${dto.bTitle }'
							readonly="readonly" style="width: 90%;">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">내용</label>
					<div class="controls">
						<textarea name="bContent" cols="30" rows="10"
							style="resize: none; width: 90%;" readonly="readonly">${dto.bContent }</textarea>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">파일</label>
					<div class="controls" align="left">
						<c:forEach items="${files }" var="file">
							<a
								href="fileDownload?fName='${file.fName }'&rName='${file.rName }'"
								style="width: 90%;"> ${file.rName }</a> (${file.sizeCalculation(file.fSize) }) 
						</c:forEach>
					</div>
				</div>
				<div class="control-group">
					<div class="controls">
						<a href="#modifyPwdChk" role="button" class="btn" data-toggle="modal" id="modifyBtn">수정</a>
						<a href="list"><button type="button" class="btn">목록</button></a>
					</div>
				</div>
			</div>
		</form>

		<div id="replyWrite">
			<form action="replyWrite" method="post" class="form-horizontal">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				<input type="hidden" name="bId" value="${param.bId }" />
				<div class="control-group">
					<label class="control-label">작성자</label>
					<div class="controls">
						<input type="text" id="rWriter" name="rWriter" style="width: 90%;">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">비밀번호</label>
					<div class="controls">
						<input type="password" id="rPassword" name="rPassword"
							style="width: 90%;">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">내용</label>
					<div class="controls">
						<textarea name="rContent" cols="30" rows="5"
							placeholder="리플을 입력해주세요." id="rContent"
							style="resize: none; width: 90%;"></textarea>
					</div>
				</div>
				<div class="control-group">
					<div class="controls">
						<input type="submit" class="btn" value="작성"
							onclick="return replyNullCheck()"></input>
					</div>
				</div>
			</form>
		</div>

		<div id="replys">
			<c:forEach items="${replys }" var="reply">
				<div id="reply">
					<div class="control-group">
						<div class="row-fluid" id="replysTop">
							<div class="span9">
								<label class="control-label">
									<c:if test="${reply.rIndent > 0 }">
										<c:forEach items="${replys }" begin="1" end="${reply.rIndent % 5 }">
											&nbsp;&nbsp;&nbsp;
										</c:forEach>└
										<c:forEach items="${replys }" begin="0" end="${reply.rIndent / 5 }">Re</c:forEach> :
									</c:if>
									${reply.rWriter }
								</label>
							</div>
							<c:if test="${reply.rDelete != 1 }">
								<div class="span3" id="replyButton">
									<p>${reply.rDate }</p>
									<a href="#replyWriteOnReply" role="button" class="btn"
										data-toggle="modal" onclick="transferRId(${reply.rId}, ${reply.rGroup })">
									<i class="icon-pencil"></i></a>
									<a href="#replyUpdateOnReply" role="button" class="btn"
										data-toggle="modal" onclick="transferRIdUpd(${reply.rId }, ${reply.rGroup })">
									<i class="icon-wrench"></i></a>
									<a href="#replyDeleteOnReply" role="button" class="btn"
										data-toggle="modal" onclick="transferRIdDel(${reply.rId }, ${reply.rGroup })">
									<i class="icon-trash"></i></a>
								</div>
							</c:if>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" id="replyBottom">
							<c:if test="${reply.rIndent > 0 }">
								<c:forEach items="${replys }" begin="1" end="${reply.rIndent % 5 }">
									&nbsp;&nbsp;&nbsp;
								</c:forEach>&nbsp;&nbsp;&nbsp;
							</c:if>
							<c:choose>
								<c:when test="${reply.rDelete == 1}">
									삭제된 댓글 입니다.
								</c:when>
								<c:otherwise>
									${reply.rContent }
								</c:otherwise>
							</c:choose>
						</label>
					</div>
					<div class="control-group"></div>
				</div>
			</c:forEach>
		</div>
	</div>	
	
	<script>		
		var pwdChk = "." + ${param.pwdChk} + ".";
	</script>
	
</body>
</html>