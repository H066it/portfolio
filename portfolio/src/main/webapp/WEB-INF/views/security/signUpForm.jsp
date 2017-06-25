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
		<form class="form-signin" action="signUp" method="post">
			<h2 class="form-signin-heading">Sign Up</h2>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<input type="text" class="input-block-level" placeholder="id" name="id" id="upId">
			<input type="password" class="input-block-level" placeholder="password" name="pwd" id="upPw">
			<input type="text" class="input-block-level" placeholder="nickname" name="nickName" id="upName">
			<c:if test="${signUpRst == false}">
				<p>중복 된 아이디 또는 닉네임입니다.</p>
			</c:if>
			<button class="btn btn-large btn-primary" onclick="return signUpNullCheck()" type="submit">등록</button>
			<a href="list"><button class="btn btn-large" type="button">취소</button></a>
		</form>

	</div>

</body>
</html>