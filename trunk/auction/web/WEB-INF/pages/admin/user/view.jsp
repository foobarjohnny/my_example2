<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<html>
	<head>
		<%@ include file="/resources/resources.jsp"%>
	</head>
	<body>
		<!--商品详细信息-->
		<br>
		<div align="center" class="admin_title1">
			——秀宝详情
			<a name="秀宝详情" id="秀宝详情"></a>——
		</div>
		<hr />
		<form action="autShowcom.action" method="post">
		<input type="hidden" name="id" value="${id }">
		<table width="100%" border="1" cellpadding="10" cellspacing="0"
			bordercolor="#FFFFFF" bgcolor="#EEEEEE">
			<tr>
				<td width="12%" align="right">
					商品ID：
				</td>
				<td width="35%">
					<a href="bingcurForward.action?model.id=${bidId }" target="_blank">${tradeId }</a>
				</td>
				<td width="13%" align="right">
					商品名称：
				</td>
				<td width="40%">
					<a href="bingcurForward.action?model.id=${bidId }" target="_blank">${tradename }</a>
				</td>
			</tr>
			<tr>
				<td align="right">
					竞拍赢家：
				</td>
				<td>
					${username }
				</td>
				<td align="right">
					成交时间：
				</td>
				<td>
					${creattime }
				</td>
			</tr>
			<tr>
				<td align="right">
					成交价格：
				</td>
				<td>
					${price }
				</td>
				<td align="right">
					&nbsp;
				</td>
				<td>
					&nbsp;
				</td>
			</tr>
			<tr>
				<td align="right" valign="top">
					秀宝感言：
				</td>
				<td colspan="3" valign="top">
					${remark }
				</td>
			</tr>
			<s:if test="aut == 2">
			<tr>
				<td colspan="4" align="center">
					赠送的E拍币数量
					<select name="count">
						<option value="2">
							2
						</option>
						<option value="3">
							3
						</option>
						<option value="5">
							5
						</option>
					</select>
					<input type="submit" name="Submit2" value="审核" />
				</td>
			</tr>
			</s:if>
		</table>
		</form>
	</body>
</html>