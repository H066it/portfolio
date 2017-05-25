<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/style.min.css" rel="stylesheet" >
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="css/bootstrap-responsive.css" rel="stylesheet">
<title>freeeeeeeeeeboard</title>
</head>
<body>
	view.jsp

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

		<form action="updateForm" method="post" class="form-horizontal">
			<div class="form-horizontal">
				<input type="hidden" name="bId" value="${param.bId }" />
				<div class="control-group">
					<label class="control-label">작성자</label>
					<div class="controls">
						<input type="text" name="bWriter" value='${dto.bWriter }'
							readonly="readonly" style="width: 90%;">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">제목</label>
					<div class="controls">
						<input type="text" name="bTitle" value='${dto.bTitle }'
							readonly="readonly" style="width: 90%;">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">내용</label>
					<div class="controls">
						<textarea name="bContent" cols="30" rows="10"
							style="resize: none; width: 90%;" readonly="readonly">${dto.bContent }</textarea>
					</div>
				</div>
				<div class="control-group">
					<div class="controls">
						<input type="submit" class="btn" value="수정"></input> <a
							href="list"><button type="button" class="btn">목록</button></a>
					</div>
				</div>
			
			</div>
		</form>
	</div>
</body>
</html>