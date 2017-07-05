<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/submitRule.js"></script>
<script type="text/javascript" src="js/pwdChk.js"></script>
</head>
<body>
	
	<img src="/portfolio/img/귤은 귤귤하고 웁니다.png" class="img-circle" width="200px">
	
	<jsp:include page="/resources/assets/jsp/signBar.jsp"></jsp:include>
	
	<div class="container-narrow">
	
		<jsp:include page="/resources/assets/jsp/navbar.jsp"></jsp:include>
		
		<div>
			<c:if test="${signUpRst == true }">
				<div class="alert">
	  				<button type="button" class="close" data-dismiss="alert">&times;</button>
	 				ᕕ( ᐛ )ᕗ  회원가입을 축하드립니다.٩( ᐕ  )و
				</div>
				<script>
					$(".alert").alert();
				</script>
			</c:if>
		</div>
		
		<div>
			<c:if test="${param.logout != null }">
				<div class="alert">
	  				<button type="button" class="close" data-dismiss="alert">&times;</button>
	 				ᕕ( ᐛ )ᕗ  로그아웃 되었습니다.٩( ᐕ  )و
				</div>
				<script>
					$(".alert").alert();
				</script>
			</c:if>
		</div>

		<table class="table table-striped">
			<tr>
				<td>번호</td>
				<td width="50%">제목</td>
				<td>작성자</td>
				<td>작성일</td>
				<td>조회수</td>
				<td>삭제</td>
			</tr>
			<c:forEach items="${list }" var="dto">
				<tr>
					<td>${dto.bId }</td>
					<td><a href="view?gId=${gId }&bId=${dto.bId }" style="color: black;">
						${dto.bTitle }
						<c:if test="${dto.fileCheck == 1 }"><i class="icon-film"></i></c:if>
					</a></td>
					<td>${dto.bWriter }</td>
					<td>${dto.bDate }</td>
					<td>${dto.bCount }</td>
					<td><a href="#deletePwdChk" role="button" data-toggle="modal" id="deleteBtn"
					 onclick="transferRIdOnly(${dto.bId })"><i class="icon-remove"></i></a></td>
				</tr>
			</c:forEach>
		</table>

		<a href="form?gId=${gId }">			
			<input class="btn" type="button" value="글쓰기" />
		</a><br />

		<div class="pagination">
			<ul>
				<c:choose>
					<c:when test="${keyword == null}">
						<li><a href="list?page=1">&lt;&lt;</a></li>
						<c:if test="${pageVo.firPageNum - 1 > 1}">
							<li><a href="list?page=${pageVo.firPageNum - 1}">&lt;</a></li>
						</c:if>
						<c:forEach begin="${pageVo.firPageNum }"
							end="${pageVo.lstPageNum }" step="1" varStatus="page">
							<li><a href="list?page=${pageVo.firPageNum -1 + page.count}">
									${pageVo.firPageNum -1 + page.count} </a></li>
						</c:forEach>
						<c:if test="${pageVo.firPageNum + 10 <= pageVo.totalPageNum}">
							<li><a href="list?page=${pageVo.firPageNum + 10}">&gt;</a></li>
						</c:if>
						<li><a href="list?page=${pageVo.totalPageNum }">&gt;&gt;</a></li>
					</c:when>
					
					<c:when test="${keyword != null}">
						<li><a href="search?page=1&gId=${gId }&
							searchType=${searchType }&keyword=${keyword }">&lt;&lt;</a></li>
						<c:if test="${pageVo.firPageNum - 1 > 1}">
							<li><a href="search?page=${pageVo.firPageNum - 1}&gId=${gId }&
							searchType=${searchType }&keyword=${keyword }">&lt;</a></li>
						</c:if>
						<c:forEach begin="${pageVo.firPageNum }"
							end="${pageVo.lstPageNum }" step="1" varStatus="page">
							<li><a href="search?page=${pageVo.firPageNum -1 + page.count}&gId=${gId }&
								searchType=${searchType }&keyword=${keyword }">
									${pageVo.firPageNum -1 + page.count} </a></li>
						</c:forEach>
						<c:if test="${pageVo.firPageNum + 10 <= pageVo.totalPageNum}">
							<li><a href="search?page=${pageVo.firPageNum + 10}&gId=${gId }&
							searchType=${searchType }&keyword=${keyword }">&gt;</a></li>
						</c:if>
						<li><a href="search?page=${pageVo.totalPageNum }&gId=${gId }&
						searchType=${searchType }&keyword=${keyword }">&gt;&gt;</a></li>

					</c:when>
				</c:choose>				
			</ul>
		</div>

		<div class="input-prepend">
			<form action="search" method="post">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				<input type="hidden" name="gId" value="${gId }"/>
				<div class="btn-group">
					<select name="searchType" style="width: 74px;">
						<option value="bTitle">제목</option>
						<option value="bContent">내용</option>
						<option value="bTitle_bContent">제목+내용</option>
						<option value="bWriter">작성자</option>
						<option value="rContent">댓글</option>
					</select>
				</div>
				<input type="text" name="keyword" style="width: 146px;">
				<button type="submit" class="btn">검색</button>
			</form>
		</div>
	</div>	

	<script>		
		var pwdChk = "." + ${param.pwdChk} + ".";
	</script>
</body>
</html>