<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<html>
	<title></title>
	<frameset rows="67,*" cols="*" frameborder="no" border="0"
		framespacing="0">
		<frame src="top.action" name="topFrame" scrolling="No"
			noresize="noresize" id="topFrame" title="topFrame" />
		<frameset rows="*" cols="201,*" framespacing="0" frameborder="no"
			border="0">
			<frame src="left.action" name="leftFrame" noresize="noresize"
				id="leftFrame" title="leftFrame" />
			<frame src="main.action" name="mainFrame" id="mainFrame"
				title="mainFrame" />
		</frameset>
	</frameset>
	<noframes></noframes>
	<body></body>
</html>