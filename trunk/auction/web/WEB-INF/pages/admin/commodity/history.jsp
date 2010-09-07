<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<html>
	<head>
		<%@ include file="/resources/resources.jsp"%>
	</head>
	<body>
		<div align="center" class="admin_title1">
			——竞拍历史记录
			<a name="竞拍历史记录" id="竞拍历史记录"></a>——
		</div>
		<hr />
		<table width="100%" border="1" cellpadding="10" cellspacing="0"
			bordercolor="#FFFFFF" bgcolor="#EEEEEE">
			<tr>
				<td width="25%" align="center">
					<strong>竞拍人</strong>
				</td>
				<td width="32%" align="center">
					<strong>出价次数</strong>
				</td>
			</tr>
			<s:set name="total" value="0"/>
			<s:set name="ttt" value="dataList.size"/>
			<s:iterator id="data" value="dataList" status="indexd">
			<tr>
				<td align="center">
					${data.username }
				</td>
				<td align="center">
					<s:set name="total" value="#total + count"/>
					${data.count }
				</td>
			</tr>
			</s:iterator>
			<tr>
				<td align="center">
					<strong>总计：${ttt }人</strong>
				</td>
				<td align="center">
					<strong>总计：${total }次</strong>
				</td>
			</tr>
		</table>
	</body>
</html>