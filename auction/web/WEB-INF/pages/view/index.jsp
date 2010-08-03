<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<html>
	<head>
		<%@ include file="/resources/resources.jsp"%>
	</head>
	<body>
		<s:form action="userLogin.action" name="user">
			用户名：<s:textfield name="username"></s:textfield>
			密&nbsp;码：<s:password name="password"></s:password>
			<input type="submit" value="登陆"/>
		</s:form>
		<br>
		<a href="userReg.action">注册</a>
		<br>
		<div>
			<iframe frameborder="0" src="show.action" style="height: 100%;width: 60%;overflow: hidden">
				
			</iframe>
		</div>
	</body>
</html>