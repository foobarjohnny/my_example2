<%@page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Login</title>
</head>

<body>
	<div class="accounts-form">
			<h2>登录您的帐号
			</h2>
			<hr class="small"/>
			<form action="j_spring_security_check" method="post" class="well" >
				<div id="errors">
					<c:if test="${not empty param.error}">
						<font color="red"> 登录失败, 
							<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message }"></c:out>
						</font>
					</c:if>
					<c:if test="${not empty param.session_expired }">
						<font color="blue">
						会话过期，请重新登录
						</font>
					</c:if>
				</div>
				<label style="text-align: left">您的邮箱</label>
				<input type="text" class="span5" name="j_username" value="${sessionScope['SPRING_SECURITY_LAST_USERNAME']}" placeholder="somebody@someplace.com">
				<label style="text-align: left">您的密码</label>
				<input type="password" class="span5" name="j_password" placeholder="**********">
				<div class="form-actions">
		            <button class="btn btn-primary btn-large" type="submit">马上登录</button>
	            </div>
			</form>
			<p class="help-block"><a href="/iforget">忘记密码</a>&nbsp;.&nbsp;<a href="/signup">没有帐号</a></p>
	</div>
</body>
</html>