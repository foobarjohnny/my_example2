<%@page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
	<head>
		<title> 用音乐倾听彼此</title>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
		<meta name="Keywords" content="音乐,分享,试听,桑啼" />
		<meta name="Description" content="音乐分享、音乐试听、非主流音乐、欧美音乐、独立音乐、页面简洁，无眩杂广告。" />
		<link rel="stylesheet" type="text/css" media="screen" href="resources/styles/style.css" />
		<script type="text/javascript" src="resources/scripts/jquery-1.6.4.min.js"></script>
	</head>
	<body>
		<div id="header" class="header">
			<a href="signup" style="float: right;margin-right: 20px;">登录</a> 
		</div>
		
		<div id="container" class="container" >
			<img src="resources/images/logo.jpg" alt="logo" width="240px" height="200px;" />
			<form action="search" method="get">
				<input type="text" name="keywords" class="keywords" maxlength="100"/>
				<input type="button" value="搜一下"/>
			</form>
		</div>
	</body>
</html>