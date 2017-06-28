<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/style.css" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="css/bootstrap-responsive.css" rel="stylesheet">
<link href="css/loginStyle.css" rel="stylesheet"/>
<title>freeeeeeeeeeboard</title>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/submitRule.js"></script>
</head>
<body>

	<div class="container">
			
		<!-- 3.x 버전은 j_spring_security_check이나 4.x 버전은 login
			username, password도 4.x 버전부터는 'j_' 안 붙음. -->
		<form class="form-signin" action="login" method="post">
			<h2 class="form-signin-heading">Sign in</h2>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<input type="text" class="input-block-level" placeholder="id" name="username" id="sId">
			<input type="password" class="input-block-level" placeholder="password" name="password" id="sPw">
			<c:if test="${param.pChk != null }">
				<p>아이디 또는 비밀번호를 다시 확인하세요.</p>
				<p>등록되지 않은 아이디이거나</p>
				<p>회원정보를 잘못 입력하셨습니다.</p>
			</c:if>
			<label class="checkbox">
				<input type="checkbox" name="remember-me">
				Remember me
			</label>
			<button class="btn btn-large btn-primary" onclick="return loginNullCheck()" type="submit">로그인</button>
			<a href="list"><button class="btn btn-large" type="button">목록</button></a>
		</form>
		<a href="signUpForm">sign Up</a>

	</div>
	
</body>
</html>