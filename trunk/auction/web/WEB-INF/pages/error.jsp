<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<html>
	<head>
		<title></title>
	</head>
	<body>
		<%
			Exception exception = (Exception) request.getSession().getAttribute("error");
			out.println("错误信息：" + exception.getMessage() + "<br>");
		 %>
	</body>
</html>
