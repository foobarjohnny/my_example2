<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page"%>

<html>
	<head>
		<title><decorator:title default="易拍得网站" /></title>
		<%@ include file="/resources/resources.jsp"%>
		
		<script type="text/javascript">
			$( function() {
				$('#sidebar').load("userInfomation.action","");
			});
		</script>
		
	</head>

	<body leftmargin="0" topmargin="0" style="filter:progid:DXImageTransform.Microsoft.Gradient(startColorStr='#6daf2f', endColorStr='#ffffff', gradientType='0')">		
		<div id="container" style="margin:0 auto; width:100%;">
			<!-- 这是头部的导航条 -->
			<div id="header"  style=" height:80px;  margin-bottom:5px;">
				<jsp:include page="navigator.jsp"></jsp:include>
			</div>
			
			<!-- 这是广告部分的布局 -->
			<div id="advertise" style=" height:100px;  margin-bottom:5px;">
				<jsp:include page="advertise.jsp"></jsp:include>
			</div>
			
			<!-- 这是主要内容展现区的布局 -->
			<div id="mainContent" style="height:600px; margin-bottom:5px; margin:0 auto; width:1000px;">

				<!-- 这是左侧导航的布局 -->
				<div id="sidebar" style="float:left; width:200px; height:500px;line-height:500px">
				</div>
				 
				<!-- 这是右侧主要展示区域的内容 -->
				<div id="content" style="margin-left:205px !important; margin-left:202px; height:500px; line-height:500px; ">
					<decorator:body/>
				</div>
			</div>
			
			<!-- 这是页脚的展现区 -->
			<div id="footer" style="height:60px;">
				<page:applyDecorator name="footer"/>
			</div>
		</div>
	</body>
</html>
