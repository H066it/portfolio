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
	
	<jsp:include page="/resources/assets/jsp/signBar.jsp"></jsp:include>
	
	<div class="container-narrow">
	
		<jsp:include page="/resources/assets/jsp/navbar.jsp"></jsp:include>
		
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