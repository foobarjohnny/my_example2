<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<html>
	<head>
		<%@ include file="/resources/resources.jsp"%>
	</head>
	<body leftmargin="0" topmargin="0">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td colspan="4" bgcolor="#000000">
					<img src="images/enterprise.jpg" width="80" height="15">
				</td>
			</tr>
			<tr>
				<td width="2%" bgcolor="#E3E3E3">
					&nbsp;
				</td>
				<td width="24%" bgcolor="#E3E3E3">
					<img src="images/admin_logo.jpg" width="306" height="54">
				</td>
				<td width="49%" bgcolor="#E3E3E3">
					<div align="center" class="admin_title1">
						<strong>当前管理员：${MLogin.workNo }，您的级别：网站管理员！</strong>
					</div>
				</td>
				<td width="25%" align="center" bgcolor="#E3E3E3">
					[
					<a href="#" onclick="openFirst();">网站首页</a>]&nbsp;&nbsp;&nbsp;&nbsp;[
					<a href="./mangerLogout.action">退出系统</a>]
				</td>
			</tr>
		</table>
	</body>
	<script type="text/javascript">
		function openFirst(){
			//parent.window.location="./show.action";
			window.open("./show.action",'target');
		}
	</script>
</html>