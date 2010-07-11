<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="/common/common.jsp" />
</head>
<body leftmargin="0" topmargin="0">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td colspan="4" bgcolor="#000000">
			<img src="images/enterprise.jpg" width="80" height="15">
		</td>
	</tr>
	<tr>
		<td width="2%" bgcolor="#E3E3E3">&nbsp;</td>
		<td width="24%" bgcolor="#E3E3E3"><img
			src="images/admin_logo.jpg" width="306" height="54"></td>
		<td width="49%" bgcolor="#E3E3E3">
		<div align="center" class="admin_title1"><strong>当前管理员：<sec:authentication
			property="name" />，您的级别：</strong></div>
		</td>
		<td width="25%" align="center" bgcolor="#E3E3E3">[<a
			href="index.jsp" target="_blank">网站首页</a>]&nbsp;&nbsp;&nbsp;&nbsp;[<a
			href="j_spring_security_logout" target="_blank">退出系统</a>]</td>
	</tr>
</table>

</body>
</html>