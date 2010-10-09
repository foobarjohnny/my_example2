<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>

<html>
	<title>易拍得</title>
<script type="text/javascript">
	//如果客户已经登录，那么显示客户的信息， 而无需再次登录
	if('${manager_login}' != 'Y'){
		window.location="./managerLogin.action";
	}
</script>
	<frameset rows="67,*" cols="*" frameborder="no" border="0"
		framespacing="0">
		<frame src="./top.action" name="topFrame" scrolling="No"
			noresize="noresize" id="topFrame" title="topFrame" />
		<frameset rows="*" cols="201,*" framespacing="0" frameborder="no"
			border="0">
			<frame src="./left.action" name="leftFrame" noresize="noresize"
				id="leftFrame" title="leftFrame" />
			<frame src="./main.action" name="mainFrame" id="mainFrame"
				title="mainFrame" />
		</frameset>
	</frameset>
	<noframes></noframes>
	<body></body>
</html>