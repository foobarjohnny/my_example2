<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<html>
	<head>
		<%@ include file="/resources/resources.jsp"%>
	</head>
	<body>
		<div align="center" class="admin_title1">
			——商品详情
			<a name="商品详情" id="商品详情"></a>——
		</div>
		<hr />
		<table width="100%" border="1" cellpadding="10" cellspacing="0"
			bordercolor="#FFFFFF" bgcolor="#EEEEEE">
			<tr>
				<td width="12%" align="right">
					商品ID：
				</td>
				<td width="37%">
					<a href="bingcurForward.action?model.id=${bidId }" target="_blank">
						${id }
					</a>
				</td>
				<td width="11%" align="right">
					商品名称：
				</td>
				<td width="40%">
					<a href="bingcurForward.action?model.id=${bidId }" target="_blank">
						${tradename }
					</a>
				</td>
			</tr>
			<tr>
				<td align="right">
					最终竞拍人：
				</td>
				<td>
					${username }
				</td>
				<td align="right">
					成交时间：
				</td>
				<td>
					${overtime }
				</td>
			</tr>
			<tr>
				<td align="right">
					商品竞拍价格：
				</td>
				<td>
					${prices }
				</td>
				<td align="right">
					消耗E拍币数量：
				</td>
				<td>
					收费E拍币${pcount }枚，免费E拍币${fcount }枚
				</td>
			</tr>
			<tr>
				<td align="right">
					参与竞拍人数：
				</td>
				<td>
					${count }人&nbsp;&nbsp;[
					<a href="commodityHis.action?id=${id }"><font color="#0000FF">点击查看竞拍历史记录</font>
					</a>]
				</td>
				<td align="right">
					总消耗E拍币数量：
				</td>
				<td>
					收费E拍币${pcount }枚，免费E拍币${fcount }枚
				</td>
			</tr>
		</table>
	</body>
</html>