<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<html>
	<head>
		<%@ include file="/resources/resources.jsp"%>
	</head>
	<body>
		<div align="center" class="admin_title1">
			——作废订单详情
			<a name="竞拍订单详情" id="竞拍订单详情"></a>——
		</div>
		<hr />
		<table width="100%" border="1" cellpadding="10" cellspacing="0"
			bordercolor="#FFFFFF" bgcolor="#EEEEEE">
			<tr>
				<td width="12%" align="right">
					订单编号：
				</td>
				<td width="38%" colspan="3">
					${ordernum }
				</td>
				<td width="10%" align="right">
					确定时间：
				</td>
				<td width="40%" colspan="3">
					${ordertime }
				</td>
			</tr>
			<tr>
				<td align="right">
					支付方式：
				</td>
				<td colspan="3">
					&nbsp;
				</td>
				<td align="right">
					订单总金额：
				</td>
				<td colspan="3">
					${comprice }
				</td>
			</tr>
			<tr>
				<td align="right">
					收货人：
				</td>
				<td colspan="3">
					${receiver }
				</td>
				<td align="right">
					收货人电话：
				</td>
				<td colspan="3">
					${telphone }
				</td>
			</tr>
			<tr>
				<td align="right">
					收货人地址：
				</td>
				<td colspan="3">
					${address }
				</td>
				<td align="right">
					备注：
				</td>
				<td colspan="3">
					${remard }
				</td>
			</tr>
			<tr>
				<td align="right">
					商品编号：
				</td>
				<td colspan="3">
					&nbsp;
				</td>
				<td align="right">
					商品名称：
				</td>
				<td colspan="3">
					<a href="bingcurForward.action?model.id=${bidId }" target="_blank">${commodityName }</a>
				</td>
			</tr>
			<tr>
				<td align="right">
					商品价格：
				</td>
				<td>
					${amount }元+${ecount }枚E拍币
				</td>
				<td align="right">
					运费：
				</td>
				<td>
					${fare }元
				</td>
				<td align="right">
					总价
				</td>
				<td>
					${comprice }
				</td>
				<td align="right">
					应付
				</td>
				<td>
					${totalPrices }
				</td>
			</tr>
			<tr>
				<td align="right">
					作废原因：
				</td>
				<td colspan="2">
					
				</td>
				<td align="right">
					作废日期：
				</td>
				<td colspan="2">
					
				</td>
			</tr>
		</table>
	</body>
</html>