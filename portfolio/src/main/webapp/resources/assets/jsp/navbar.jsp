<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

	<div class="navbar">
		<div class="navbar-inner">
			<a class="brand" href="#">Title</a>
			<ul class="nav">
				<li class="divider-vertical"></li>
				<c:choose>
					<c:when test="${gId == 1 || dto.gId == 1}">
						<li class="active"><a href="list?gId=1">익명판</a></li>
						<li class="divider-vertical"></li>
						<li><a href="list?gId=2">회원판</a></li>
						<li class="divider-vertical"></li>
						<li><a href="list?gId=3">건의판</a></li>
						<li class="divider-vertical"></li>
						<li><a href="map">지도</a></li>
						<li class="divider-vertical"></li>
					</c:when>
					<c:when test="${gId == 2 || dto.gId == 2}">
						<li><a href="list?gId=1">익명판</a></li>
						<li class="divider-vertical"></li>
						<li class="active"><a href="list?gId=2">회원판</a></li>
						<li class="divider-vertical"></li>
						<li><a href="list?gId=3">건의판</a></li>
						<li class="divider-vertical"></li>
						<li><a href="map">지도</a></li>
						<li class="divider-vertical"></li>
					</c:when>
					<c:when test="${gId == 3 || dto.gId == 3}">
						<li><a href="list?gId=1">익명판</a></li>
						<li class="divider-vertical"></li>
						<li><a href="list?gId=2">회원판</a></li>
						<li class="divider-vertical"></li>
						<li class="active"><a href="list?gId=3">건의판</a></li>
						<li class="divider-vertical"></li>
						<li><a href="map">지도</a></li>
						<li class="divider-vertical"></li>
					</c:when>
					<c:when test="${gId == null && dto.gId == null}">
						<li><a href="list?gId=1">익명판</a></li>
						<li class="divider-vertical"></li>
						<li><a href="list?gId=2">회원판</a></li>
						<li class="divider-vertical"></li>
						<li><a href="list?gId=3">건의판</a></li>
						<li class="divider-vertical"></li>
						<li class="active"><a href="map">지도</a></li>
						<li class="divider-vertical"></li>
					</c:when>
				</c:choose>				
			</ul>
		</div>
	</div>

</body>
</html>