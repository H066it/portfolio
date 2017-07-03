<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
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
<script type="text/javascript" src="js/submitRule.js"></script>
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
					<c:choose>
						<c:when  test="${gId == 1}">
							<li class="active"><a href="list?gId=1">익명판</a></li>
							<li class="divider-vertical"></li>
							<li><a href="list?gId=2">회원판</a></li>
							<li class="divider-vertical"></li>
							<li><a href="list?gId=3">건의판</a></li>
						</c:when>
						<c:when  test="${gId == 2}">
							<li><a href="list?gId=1">익명판</a></li>
							<li class="divider-vertical"></li>
							<li class="active"><a href="list?gId=2">회원판</a></li>
							<li class="divider-vertical"></li>
							<li><a href="list?gId=3">건의판</a></li>
						</c:when>
						<c:when  test="${gId == 3}">
							<li><a href="list?gId=1">익명판</a></li>
							<li class="divider-vertical"></li>
							<li><a href="list?gId=2">회원판</a></li>
							<li class="divider-vertical"></li>
							<li class="active"><a href="list?gId=3">건의판</a></li>
						</c:when>
					</c:choose>
					<li class="divider-vertical"></li>
					<li><a href="map">지도</a></li>
				</ul>
			</div>
		</div>

		<c:choose>
		
			<c:when test="${bId == null}">
				<form action="write?${_csrf.parameterName}=${_csrf.token}"
				 method="post" class="form-horizontal" enctype="multipart/form-data">
					<div class="form-horizontal">
						<input type="hidden" name="gId" value="${gId }"/>
						<div class="control-group">
							<label class="control-label">작성자</label>
							<div class="controls">
								<sec:authorize access="hasRole('ROLE_USER')">
									<input type="text" name="bWriter" style="width: 90%"
										value="${auth }" readonly="readonly">
								</sec:authorize>
								<sec:authorize access="isAnonymous()">
									<input type="text" name="bWriter" style="width: 90%">
								</sec:authorize>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">비밀번호</label>
							<div class="controls">
								<input type="password" name="bPassword" style="width: 90%;">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">제목</label>
							<div class="controls">
								<input type="text" name="bTitle" style="width: 90%;">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">내용</label>
							<div class="controls">
								<textarea name="bContent" cols="30" rows="10"
									style="resize: none; width: 90%;"></textarea>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">파일</label>
							<div class="controls">
								<input type="file" name="upFile" style="width: 90%;" multiple> (10MB 제한)
							</div>
						</div>
						<div class="control-group">
							<div class="controls">
								<input type="submit" class="btn" value="작성"
									onclick="return nullCheck()"></input> <a href="list?gId=${gId }"><button
										type="button" class="btn">취소</button></a>
							</div>
						</div>
					</div>
				</form>
			</c:when>
			
			<c:when test="${bId != null}">
				<form action="update?${_csrf.parameterName}=${_csrf.token}"
				 method="post" class="form-horizontal" enctype="multipart/form-data">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					<div class="form-horizontal">
						<input type="hidden" name="gId" value="${gId }"/>
						<input type="hidden" name="bId" value="${bId }" />
						<div class="control-group">
							<label class="control-label">작성자</label>
							<div class="controls">
								<sec:authorize access="hasRole('ROLE_USER')">
									<input type="text" name="bWriter" style="width: 90%" value="${auth }" readonly="readonly">
								</sec:authorize>
								<sec:authorize access="isAnonymous()">
									<input type="text" name="bWriter" style="width: 90%">
								</sec:authorize>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">제목</label>
							<div class="controls">
								<input type="text" name="bTitle" style="width: 90%;"
									value="${dto.bTitle }">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">내용</label>
							<div class="controls">
								<textarea name="bContent" cols="30" rows="10"
									style="resize: none; width: 90%;">${dto.bContent }</textarea>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">파일</label>
							<div class="controls" align="left">
								<c:forEach items="${files }" var="file">
									<a
										href="fileDownload?fName='${file.fName }'&rName='${file.rName }'"
										style="width: 90%;">${file.rName }</a> (${file.sizeCalculation(file.fSize) }) 
									<i class="icon-trash"></i><input type="checkbox" name="fId" value="${file.fId }"/>
								</c:forEach>
								<input type="file" name="upFile" style="width: 90%;" multiple> (10MB 제한)
							</div>
						</div>
						<div class="control-group">
							<div class="controls">
								<input type="submit" class="btn" value="수정"
									onclick="return nullCheck()"></input> <a href="list?gId=${gId }"><button
										type="button" class="btn">취소</button></a>
							</div>
						</div>
					</div>
				</form>
			</c:when>
			
		</c:choose>
	</div>

</body>
</html>