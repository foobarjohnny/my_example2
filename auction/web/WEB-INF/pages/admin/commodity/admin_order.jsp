<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<html>
	<head>
		<%@ include file="/resources/resources.jsp"%>
		<script type="text/javascript">
			function previous() {
				var currentPage = document.getElementById("pageBean.currentPage").value;
				if (parseInt(currentPage) != 1) {
					document.getElementById("pageBean.currentPage").value = parseInt(currentPage) - 1;
					form1.submit();
				}
			}
			function next() {
				var currentPage = document.getElementById("pageBean.currentPage").value;
				var totalPage = document.getElementById("pageBean.totalPage").value;
				if (parseInt(currentPage) != (totalPage)) {
					document.getElementById("pageBean.currentPage").value = parseInt(currentPage) + 1;
					form1.submit();
				}
			}
			function insert() {
				form1.action = "commodityForward.action";
				form1.submit();
			}
		</script>
	</head>
	<body>
		<div align="center" class="admin_title1">
			——未付款订单——
		</div>
		<hr>
		<s:form action="orderSearch.action" name="form1">
			<s:hidden name="pageBean.currentPage" />
			<s:hidden name="pageBean.totalPage" />
			<s:hidden name="state" />
			<s:hidden name="ordertype" />
			<table width="100%" border="1" cellpadding="10" cellspacing="0"
				bordercolor="#FFFFFF" bgcolor="#EEEEEE">
				<tr>
					<td width="10%" align="center" valign="middle">
						<strong>订单编号</strong>
					</td>
					<td width="10%" align="center" valign="middle">
						<strong>竞拍商品</strong>
					</td>
					<td width="10%" align="center" valign="middle">
						<strong>时间</strong>
					</td>
					<td width="10%" align="center" valign="middle">
						<strong>竞拍者</strong>
					</td>
					<td width="10%" align="center" valign="middle">
						<strong>成交价</strong>
					</td>
					<td width="12%" align="center">
						<strong>操作</strong>
					</td>
				</tr>
				<s:iterator value="dataList" id="data" status="status">
					<tr>
						<td align="center" valign="middle">
							<s:property value="ordernum"/>
						</td>
						<td align="center" valign="middle">
							<table>
								<tr>
									<td><img src="showImage.action?id=${data.comId }" height="80" width="80" border="0"/></td>
									<td>
										<a href="bingcurForward.action?model.id=${bidId }" target="_blank">
										<s:property value="commodityName"/>
										</a>
									</td>
								</tr>
							</table>
						</td>
						<td align="center" valign="middle">
							<s:property value="ordertime"/>
						</td>
						<td align="center" valign="middle">
							<s:property value="receiver"/>
						</td>
						<td align="center" valign="middle">
							<s:property value="totalPrices"/>
						</td>
						<td align="center">
							<a href="commodityAuction.action?id=<s:property value="id"/>">详情</a>｜
							<a href="orderChannel.action?id=<s:property value="id"/>&orderty=${ordertype }&state=${state }">作废</a>
						</td>
					</tr>
				</s:iterator>
				<tr align="right">
					<td colspan="7">
						共<s:property value="pageBean.totalRec"/>条纪录，当前第<s:property value="pageBean.currentPage"/>/<s:property value="pageBean.totalPage"/>页，每页<s:property value="pageBean.pageRec"/>条纪录
						首页&nbsp;&nbsp;
						<a href="#" onclick="previous()">上一页</a>&nbsp;&nbsp;
						<a href="#" onclick="next()">下一页</a>&nbsp;&nbsp;
						尾页
					</td>
				</tr>
			</table>
		</s:form>
	</body>
</html>