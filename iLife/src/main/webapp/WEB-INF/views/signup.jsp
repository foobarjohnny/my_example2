<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
	<head>
		<title>Sign Up</title>
	</head>
<body>
	<div class="accounts-form">
		<h2>免费拥有您的帐号</h2>
		<hr class="small"/>
		<form action="signup" method="post" class="well" >
			<label style="text-align: left">你的名称</label>
			<input type="text" class="span5" name="j_username" placeholder="somebody">
			<label style="text-align: left">您的邮箱</label>
			<input type="text" class="span5" name="email"  placeholder="somebody@someplace.com">
			<label style="text-align: left">您的密码</label>
			<input type="password" class="span5" name="j_password" placeholder="**********">
			<div class="form-actions">
	            <button class="btn btn-success btn-large" type="submit">注册帐号</button>
            </div>
		</form>
	</div>
</body>
</html>