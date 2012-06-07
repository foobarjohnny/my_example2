<%@page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Login</title>
</head>

<body>
	<section>
		<c:if test="${not empty param.error}">
			<font color="red"> 登录失败, <c:out
					value="${SPRING_SECURITY_LAST_EXCEPTION.message }"></c:out>
	
			</font>
		</c:if>
		<c:if test="${not empty param.session_expired }">
			<font color="blue">
			会话过期，请重新登录
			</font>
		</c:if>
		
		<form action="j_spring_security_check" method="post">
			<table>
				<tr>
					<td>用户:</td>
					<td><input type='text' name='j_username'
						value="${sessionScope['SPRING_SECURITY_LAST_USERNAME']}"></td>
				</tr>
				<tr>
					<td>密码:</td>
					<td><input type='password' name='j_password'></td>
				</tr>
				<tr>
					<td>记住我</td>
					<td><input type="checkbox" name="_spring_security_remember_me"/></td>
				</tr>
				<tr>
					<td><input name="reset" type="reset"></td>
					<td><input name="submit" type="submit"></td>
				</tr>
			</table>
		</form>
	</section>
</body>
</html>