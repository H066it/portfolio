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
<link href="css/mapStyle.css" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="css/bootstrap-responsive.css" rel="stylesheet">
<title>freeeeeeeeeeboard</title>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script src="//apis.daum.net/maps/maps3.js?apikey=cf34782331c421c789156902f2c1d54d"></script>
<script type="text/javascript" src="js/mapFunc.js"></script>
</head>
<body>

	<img src="/portfolio/img/귤은 귤귤하고 웁니다.png" class="img-circle" width="200px">
	
	<div id="signBar">
		<sec:authorize access="isAnonymous()">
			<a href="login"><input type="button" class="btn btn-link btn-small" value="로그인"/></a>
			<a href="signUpForm"><input type="button" class="btn btn-link btn-small" value="회원가입"/></a>
		</sec:authorize>	

		<sec:authorize access="hasRole('ROLE_USER')">
			<c:out value="${auth }"/>님 환영합니다.
			
			<sec:authorize access="isRememberMe()">
       			자동 로그인 되었습니다.
 		  	</sec:authorize>
			
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
						<li><a href="list?gId=1">익명판</a></li>
						<li class="divider-vertical"></li>
						<li><a href="list?gId=2">회원판</a></li>
						<li class="divider-vertical"></li>
						<li><a href="list?gId=3">건의판</a></li>
						<li class="divider-vertical"></li>
						<li class="active"><a href="map">지도</a></li>
				</ul>
			</div>
		</div>
		
		<div>
			<div id="map" style="width:750px;height:350px;display: inline-block;"></div>
			<div>
			<strong>거리 계산</strong>
				<p>좌 클릭 : 거리 계산 진행</p>
				<p>우 클릭 : 거리 계산 종료</p>
			</div>
		</div>
	</div>

</body>
</html>