<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/style.css" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="css/bootstrap-responsive.css" rel="stylesheet">
<title>freeeeeeeeeeboard</title>
<style type="text/css">
      body {
      	margin: 100px auto;
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #f5f5f5;
      }

      .form-signin {
        max-width: 300px;
        padding: 19px 29px 29px;
        margin: 0 auto 20px;
        background-color: #fff;
        border: 1px solid #e5e5e5;
        -webkit-border-radius: 5px;
           -moz-border-radius: 5px;
                border-radius: 5px;
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
           -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
                box-shadow: 0 1px 2px rgba(0,0,0,.05);
      }
      .form-signin .form-signin-heading {
        margin-bottom: 30px;       
      }
      .form-signin .checkbox {
        margin-bottom: 30px; 
        text-align: left;     
      }
      .form-signin input[type="text"],
      .form-signin input[type="password"] {
        font-size: 16px;
        height: auto;
        margin-bottom: 15px;
        padding: 7px 9px;        
      }
</style>
</head>
<body>

	<div class="container">

		<!-- 3.x 버전은 j_spring_security_check이나 4.x 버전은 login
			username, password도 4.x 버전부터는 'j_' 안 붙음. -->
		<form class="form-signin" action="login" method="post">
			<h2 class="form-signin-heading">Sign in</h2>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<input type="text" class="input-block-level" placeholder="id" name="username">
			<input type="password" class="input-block-level" placeholder="password" name="password">
			<label class="checkbox">
				<input type="checkbox" value="remember-me">
				Remember me
			</label>
			<button class="btn btn-large btn-primary" type="submit">Sign
				in</button>
		</form>

	</div>
	
</body>
</html>