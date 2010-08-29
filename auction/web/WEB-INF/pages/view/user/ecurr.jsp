<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<html>
	<head>
		<%@ include file="/resources/resources.jsp"%>
		<script type="text/javascript" src="js/dwr/userRomet.js"></script>
		<script type="text/javascript" src="js/dwr/auctionRomet.js"></script>
		<script type="text/javascript">
	function pay() {
		help.id.value = document.getElementById("ids").value;
		help.action = "buyEcurr.action";
		help.submit();
	}
</script>
	</head>
	<body leftmargin="0" topmargin="0"
		style="filter: progid :     DXImageTransform.Microsoft.Gradient (     startColorStr =     '#6daf2f', endColorStr =     '#ffffff', gradientType =     '0' )">

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
					我赢得的竞拍
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
					<form action="" method="post" name="help">
					<s:hidden name="id"></s:hidden>
					<table width="76%" border="0" align="center" cellpadding="10"
						cellspacing="0">
						<tr>
							<td width="35%" align="center" valign="top">
								<strong>价格</strong>
							</td>
							<td width="65%" align="center">
								<strong>数量</strong>
							</td>
						</tr>
						<s:iterator id="data" value="dataList">
						<tr>
							<td align="center" valign="top">
								<input type="radio" name="ids" value="${data.id }" id="ids">
								￥${data.paymoney }
							</td>
							<td align="center">
								${data.remark }
							</td>
						</tr>
						</s:iterator>
						<tr>
							<td colspan="2" align="center">
								<img src="images/xzfk.gif" width="166" height="49" onclick="pay()">
							</td>
						</tr>
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