<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
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
</body>
</html>