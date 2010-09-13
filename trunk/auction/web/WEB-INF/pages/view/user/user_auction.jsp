<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<script type="text/javascript">
	function previous() {
		var currentPage = document.getElementById("pageBean.currentPage").value;
		var totalPage = document.getElementById("pageBean.totalPage").value;
		if (parseInt(currentPage) != 1 && parseInt(totalPage) > 0) {
			document.getElementById("pageBean.currentPage").value = parseInt(currentPage) - 1;
			help.action = "userAuction.action";
			help.submit();
		}
	}
	function next() {
		var currentPage = document.getElementById("pageBean.currentPage").value;
		var totalPage = document.getElementById("pageBean.totalPage").value;
		if (parseInt(currentPage) != (totalPage) && parseInt(totalPage) > 0) {
			document.getElementById("pageBean.currentPage").value = parseInt(currentPage) + 1;
			help.action = "userAuction.action";
			help.submit();
		}
	}
	function first() {
		var currentPage = document.getElementById("pageBean.currentPage").value;
		if (parseInt(currentPage) >1) {
			document.getElementById("pageBean.currentPage").value = 1;
			help.action = "userAuction.action";
			help.submit();
		}
	}
	function last() {
		var currentPage = document.getElementById("pageBean.currentPage").value;
		var totalPage = document.getElementById("pageBean.totalPage").value;
		if (parseInt(currentPage) < totalPage) {
			document.getElementById("pageBean.currentPage").value = parseInt(totalPage);
			help.action = "userAuction.action";
			help.submit();
		}
	}
	function forwardShowcom(id) {
		help.id.value = id;
		help.action = "orderForward.action";
		help.submit();
	}
	function viewOrd(id) {
		help.id.value = id;
		help.action = "orderForward.action";
		help.submit();
	}
	function pay(id) {
		help.id.value = id;
		help.action = "orderPay.action";
		help.submit();
	}
	function view(id) {
		help.id.value = id;
		help.action = "bingcurForward.action";
		help.submit();
	}
</script>
<form method="post" name="help" action="userAuction.action">
	<s:hidden name="pageBean.currentPage" />
	<s:hidden name="pageBean.totalPage" />
	<input type="hidden" name="id">

<table width="795" border="0" align="center" cellpadding="0"
	cellspacing="0">
	<tr>
		<td colspan="3"  width="795" height="20" background="images/r_top.gif">
		</td>
	</tr>
	<tr>
		<td width="10" rowspan="3"  background="images/r_left.gif">
			<img src="images/r_left.gif" width="10" height="1">
		</td>
		<td width="775" height="40" align="center" bgcolor="#FFFFFF" class="admin_title1">
			我赢得的竞拍
		</td>
		<td width="10" rowspan="3" background="images/r_right.gif">
			<img src="images/r_right.gif" width="10" height="1">
		</td>
	</tr>
	<tr>
		<td valign="top" background="images/hr.gif" height="1">
		</td>
	</tr>
	<tr>
		<td valign="top" bgcolor="#FFFFFF">
			<table width="760" border="0" align="center" cellpadding="0"
				cellspacing="3">
				<tr>
					<td height="30" colspan="2" align="center">
						<p class="admin_title1">
							商品描述
						</p>
					</td>
					<td width="139" align="center">
						<p class="admin_title1">
							价格
						</p>
					</td>
					<td width="104" align="center">
						<p class="admin_title1">
							竞拍时间
						</p>
					</td>
					<td width="88" align="center" class="admin_title1">
						状态
					</td>
					<td width="76" align="center">
						<p class="admin_title1">
							操作
						</p>
					</td>
				</tr>
				<s:iterator id="data" value="dataList" status="status">

					<tr>
						<td width="130" height="130" align="center">
							<img width="120" height="120" border="0"
								src="showImage.action?id=${data.id }">
						</td>
						<td width="274">
							<strong><a
								href="bingcurForward.action?model.id=${data.bidId }"
								target="_blank">${data.comityName }</a>
							</strong>
							<br>

						</td>
						<td align="center">
							<p class="indexjg">
								￥${data.price }
							</p>
							市场价￥${data.prices }
							<br>
							节省${data.percents * 100}%
						</td>
						<td align="center">
							${data.binddate }
						</td>
						<td align="center">
							${data.state }
						</td>
						<td align="center">
							<s:if test="state == '未付款'">
								<a href="#" onclick="viewOrd('${data.orderId}')">付款</a>
							</s:if>
							<s:if test="state == '已发货'">
			              		交易
			              	</s:if>
							<s:if test="state == '交易完成'">
			              		我要秀宝
			              	</s:if>

							<a href="forwardShowcom.action?tradeId=${data.id }">我要秀宝</a>
							<br>

							<a href="#" onclick="viewOrd('${data.orderId}')">查看订单</a>
							<!--
			              	-->
						</td>
					</tr>
				</s:iterator>
				<s:if test="dataList.size != 0">
					<tr>
						<td align="right" colspan="5">
							<a href="#" onclick="first()">首页</a>&nbsp;&nbsp;
							<a href="#" onclick="previous()">上一页</a>&nbsp;&nbsp;
							<a href="#" onclick="next()">下一页</a>&nbsp;&nbsp;
							<a href="#" onclick="last()">尾页</a>
						</td>
					</tr>
				</s:if>
			</table>
		</td>
	</tr>
	<tr>
		<td colspan="3">
			<img src="images/r_dow.gif" width="795" height="20">
		</td>
	</tr>
</table>
</form>
