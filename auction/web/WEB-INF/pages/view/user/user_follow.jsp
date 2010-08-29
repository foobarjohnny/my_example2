<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<html>
	<head>
		<%@ include file="/resources/resources.jsp"%>
		<script type="text/javascript" src="js/dwr/userRomet.js"></script>
		<script type="text/javascript" src="js/dwr/auctionRomet.js"></script>
		<script type="text/javascript">
		function previous() {
			var currentPage = document.getElementById("pageBean.currentPage").value;
			var totalPage = document.getElementById("pageBean.totalPage").value;
			if (parseInt(currentPage) != 1 && parseInt(totalPage) > 0) {
				document.getElementById("pageBean.currentPage").value = parseInt(currentPage) - 1;
				help.action = "userFollow.action";
				help.submit();
			}
		}
		function next() {
			var currentPage = document.getElementById("pageBean.currentPage").value;
			var totalPage = document.getElementById("pageBean.totalPage").value;
			if (parseInt(currentPage) != (totalPage) && parseInt(totalPage) > 0) {
				document.getElementById("pageBean.currentPage").value = parseInt(currentPage) + 1;
				help.action = "userFollow.action";
				help.submit();
			}
		}
		function first() {
			var currentPage = document.getElementById("pageBean.currentPage").value;
			if (parseInt(currentPage) >1) {
				document.getElementById("pageBean.currentPage").value = 1;
				help.action = "userFollow.action";
				help.submit();
			}
		}
		function last() {
			var currentPage = document.getElementById("pageBean.currentPage").value;
			var totalPage = document.getElementById("pageBean.totalPage").value;
			if (parseInt(currentPage) < totalPage) {
				document.getElementById("pageBean.currentPage").value = parseInt(totalPage);
				help.action = "userFollow.action";
				help.submit();
			}
		}
		function viewCom(id) {
			help.id.value = id;
			help.action = "orderForward.action";
			help.submit();
		}
		function viewOrd(id) {
			help.id.value = id;
			help.action = "orderForward.action";
			help.submit();
		}
		</script>
	</head>
	<body leftmargin="0" topmargin="0"
		style="filter: progid :   DXImageTransform.Microsoft.Gradient (   startColorStr =   '#6daf2f', endColorStr =   '#ffffff', gradientType =   '0' )">
		<table width="795" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td colspan="3">
					<img src="images/r_top.gif" width="795" height="20">
				</td>
			</tr>
			<tr>
				<td width="10" rowspan="3" background="images/r_left.gif">
					<img src="images/r_left.gif" width="10" height="1">
				</td>
				<td width="775" height="40" align="center" bgcolor="#FFFFFF"
					class="admin_title1">
					我购买的商品
				</td>
				<td width="10" rowspan="3" background="images/r_right.gif">
					<img src="images/r_right.gif" width="10" height="1">
				</td>
			</tr>
			<tr>
				<td valign="top" background="images/hr.gif">
					<img src="images/hr.gif" width="1" height="1">
				</td>
			</tr>
			<tr>
				<td valign="top" bgcolor="#FFFFFF">
					<form method="post" name="help" action="userAuction.action">
					<s:hidden name="pageBean.currentPage" />
					<s:hidden name="pageBean.totalPage" />
					<input type="hidden" name="id">
					<table width="760" border="0" align="center" cellpadding="0" cellspacing="3">
						<tr>
				            <td height="30" colspan="2" align="center"><p class="admin_title1">商品描述</p></td>
				            <td width="139" align="center"><p class="admin_title1">价格</p></td>
				            <td width="104" align="center"><p class="admin_title1">购买时间</p></td>
				            <td width="88" align="center" class="admin_title1">状态</td>
				            <td width="76" align="center"><p class="admin_title1">操作</p></td>
			          	</tr>
			          	<s:iterator id="data" value="dataList" status="status">
			          		
				          	<tr>
				              <td width="130" height="130" align="center"><img width="120" height="120" border="0" ></td>
				              <td width="274"><strong>${data.comityName }</strong><br>
				              	
				              </td>
				              <td align="center">
				              		￥${data.price }
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
				              		交易完成
				              	</s:if>
				              	<s:if test="state == '交易完成'">
				              		我要秀宝
				              	</s:if>
				              	<!--  
				              	<a href="#" onclick="viewCom('${data.id}')">我要秀宝</a><br>
				              	<a href="#" onclick="viewOrd('${data.orderId}')">查看订单</a>
				              	-->
				              </td>
				           	</tr>
				        </s:iterator>
				        <s:if test="tradeData.size != 0">
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
					</form>
				</td>
			</tr>
			<tr>
				<td colspan="3">
					<img src="images/r_dow.gif" width="795" height="20">
				</td>
			</tr>
		</table>
	</body>
</html>