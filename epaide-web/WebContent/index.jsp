<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<jsp:include page="/common/common.jsp"/>
<link style="text/css" href="css/css.css" rel="stylesheet" />
<link rel="stylesheet" href="css/style.css" type="text/css" />
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/jquery.easing.min.js"></script>
<script type="text/javascript" src="js/jquery.lavalamp.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#menuul").lavaLamp( {
			fx : "backout",
			speed : 700,
			click : function(event, menuItem) {
				return false;
			}
		});
	});
</script>
</head>
<body>
<div id="top">
<table>
	<tbody>
		<tr>
			<td><a href="#"><img src="images/logo.png" alt="竞拍"
				border="0" /></a></td>
			<td align="right" width="820">
			<div id="quick_links">
			<ul>
				<li class="mylog"><a href="http://${site}/login">登录</a> - <a
					href="http://${site }/register">注册</a></li>
				<li class="myunlog"><a
					href="http://${site}/help?p=novice&amp;id=0">竞拍规则</a></li>
				<li class="myunlog"><a
					href="http://${site}/help?p=tips&amp;id=0">心得与窍门</a></li>
				<li class="myunlog"><a href="http://${site}/page/about">易拍得介绍</a>
				</li>
				<li class="myunlog"><a href="http://${site}/page/partners">商业合作</a>
				</li>
				<li class="myunlog"><a href="http://${site}/contact">我有问题</a></li>
			</ul>
			</div>
			</td>
		</tr>
	</tbody>
</table>
</div>
<div style="margin: 10px 40px 2px 650px">
<ul class="lavaLampWithImage" id="menuul">
	<li class="current"><a href="#">首页</a></li>
	<li><a href="#">我的易拍得</a></li>
	<li><a href="#">购买E拍币</a></li>
	<li><a href="#">我要秀宝</a></li>
	<li><a href="#">网友竞拍区</a></li>
	<!-- 
    <li><a href="#">酷品投票</a></li>
     -->
</ul>
</div>

<div id="container"><iframe name="contain" frameborder="0"> </iframe></div>

<div id="footer"></div>
</body>
</html>