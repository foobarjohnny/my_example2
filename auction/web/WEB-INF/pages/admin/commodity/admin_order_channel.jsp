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
			——作废订单——
		</div>
		<hr>
		<s:form action="searchChannel.action" name="form1">
			<s:hidden name="pageBean.currentPage" />
			<s:hidden name="pageBean.totalPage" />
			<s:hidden name="state" />
			<s:hidden name="ordertype" />
			<table width="100%" border="1" cellpadding="10" cellspacing="0"
				bordercolor="#FFFFFF" bgcolor="#EEEEEE">
				<tr>
					<td  align="center" valign="middle">
						<strong>订单编号</strong>
					</td>
					<td  align="center" valign="middle">
						<strong>竞拍商品</strong>
					</td>
					<td  align="center" valign="middle">
						<strong>时间</strong>
					</td>
					<td  align="center" valign="middle">
						<strong>竞拍者</strong>
					</td>
					<td  align="center" valign="middle">
						<strong>原因</strong>
					</td>
					<td  align="center">
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
									<td>
										<s:if test="imagesPath != null && imagesPath.size > 0">
											<img alt="" src="${imagesPath[0] }" border="0" width="120" height="120" /> 
										</s:if>
										<s:else>
											<img alt="" src="images/imgb.gif" border="0" width="120" height="120" /> 
										</s:else>
									</td>
									<td>
										<s:if test="tradeState == 1">
										<a href="viewAuctionNow.action?model.id=${data.comId }"
											target="_blank">${data.commodityName }</a>
										</s:if>
										<s:if test="tradeState == 3">
										<a href="bingcurForward.action?model.id=${data.bidId }"
											target="_blank">${data.commodityName }</a>
										</s:if>
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
							&nbsp;
						</td>
						<td align="center">
							<a href="orderChannelView.action?id=<s:property value="id"/>">详情</a>｜
							<a href="orderDelete.action?id=<s:property value="id"/>&ordertype=${ordertype }&state=${state }">删除</a>
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