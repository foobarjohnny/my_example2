<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<html>
	<head>
		<%@ include file="/resources/resources.jsp"%>
		<script type="text/javascript">
			function doSubmit() {
				user.action = "viewSaveUser.action";
				user.submit();
			}
		</script>
	</head>
	<body leftmargin="0" topmargin="0"
		style="filter: progid :   DXImageTransform.Microsoft.Gradient (   startColorStr =   '#6daf2f', endColorStr =   '#ffffff', gradientType =   '0' )">
		<form action="" method="post" name="user" >
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
					我正在参与的商品
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
					<table width="69%" border="0" align="center" cellpadding="10"
						cellspacing="0">
						<tr>
				            <td height="30" colspan="2" align="center"><p class="indexjg">商品描述</p></td>
				            <td width="85" align="center"><p class="indexjg">最新价格</p></td>
				            <td width="115" align="center"><p class="indexjg">竞价人</p></td>
				            <td width="118" align="center"><p class="indexjg">我要竞拍</p></td>
				        </tr>
						
						
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
	</body>
</html>