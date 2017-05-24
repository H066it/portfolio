<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style type="text/css">
body {
	padding-top: 20px;
	padding-bottom: 40px;
	text-align: center;
}

.container-narrow {
	max-width: 1000px;
	margin: 0 auto;
	margin-top: 6rem;
}
</style>
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="css/bootstrap-responsive.css" rel="stylesheet">
<title>freeeeeeeeeeboard</title>
</head>
<body>
	list.jsp

	<h1>게시판</h1>

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
					<td><a href="view?bId=${dto.bId }" style="color: black;">${dto.bTitle }</a></td>
					<td>${dto.bWriter }</td>
					<td>${dto.bDate }</td>
					<td>${dto.bCount }</td>
					<td><a href="delete?bId=${dto.bId }"><i
							class="icon-remove"></i></a></td>
				</tr>
			</c:forEach>
		</table>

		<a href="writeForm"><input class="btn" type="button" value="글쓰기" /></a><br />

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
						<li><a
							href="search?page=1&searchType=${searchType }&keyword=${keyword }">&lt;&lt;</a></li>
						<c:if test="${pageVo.firPageNum - 1 > 1}">
							<li><a
								href="search?page=${pageVo.firPageNum - 1}&searchType=${searchType }&keyword=${keyword }">&lt;</a></li>
						</c:if>
						<c:forEach begin="${pageVo.firPageNum }"
							end="${pageVo.lstPageNum }" step="1" varStatus="page">
							<li><a
								href="search?page=${pageVo.firPageNum -1 + page.count}&searchType=${searchType }&keyword=${keyword }">
									${pageVo.firPageNum -1 + page.count} </a></li>
						</c:forEach>
						<c:if test="${pageVo.firPageNum + 10 <= pageVo.totalPageNum}">
							<li><a
								href="search?page=${pageVo.firPageNum + 10}&searchType=${searchType }&keyword=${keyword }">&gt;</a></li>
						</c:if>
						<li><a
							href="search?page=${pageVo.totalPageNum }&searchType=${searchType }&keyword=${keyword }">&gt;&gt;</a></li>

					</c:when>
				</c:choose>				
			</ul>
		</div>

		<div class="input-prepend">
			<form action="search" method="post">
				<div class="btn-group">
					<select name="searchType" style="width: 74px;">
						<option value="bTitle">제목</option>
						<option value="bContent">내용</option>
						<option value="bTitle_bContent">제목+내용</option>
						<option value="bWriter">작성자</option>
						<option>댓글</option>
						<!-- 댓글 기능 완성후 만들기 -->
					</select>
				</div>
				<input type="text" name="keyword" style="width: 146px;">
				<button type="submit" class="btn">검색</button>
			</form>
		</div>
	</div>

	<script src="http://code.jquery.com/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>