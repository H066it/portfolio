<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>freeeeeeeeeeboard</title>
</head>
<body>
	writeForm.jsp

	<h1>게시판</h1>

	<div class="container-narrow">
		<div class="navbar">
			<div class="navbar-inner">
				<a class="brand" href="#">Title</a>
				<ul class="nav">
					<li class="divider-vertical"></li>
					<li class="active"><a href="#">Home</a></li>
					<li class="divider-vertical"></li>
					<li><a href="#">Link</a></li>
					<li class="divider-vertical"></li>
					<li><a href="#">Link</a></li>
				</ul>
			</div>
		</div>

		<form action="write" method="post" class="form-horizontal">
			<div class="control-group">
				<label class="control-label">작성자</label>
				<div class="controls">
					<input type="text" name="bWriter">
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">제목</label>
				<div class="controls">
					<input type="text" name="bTitle">
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">내용</label>
				<div class="controls">
					<textarea name="bContent" cols="30" rows="10" style="resize: none"></textarea>
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<input type="submit" class="btn" value="작성"></input>
					<a href="list"><button type="button" class="btn">취소</button></a>
				</div>
			</div>
		</form>
	</div>

</body>
</html>