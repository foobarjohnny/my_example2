<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<html>
	<head>
		<%@ include file="/resources/resources.jsp"%>
		<script type="text/javascript" src="js/dwr/userRomet.js"></script>
		<script type="text/javascript">
			function doSubmit() {
				var id = user.id.value;
				var newpass = user.password.value;
				var oldpass = user.oldpass.value;
				userRomet.changePass(id, newpass, oldpass, callBackHander);
			}
			function callBackHander(data) {
				if (data == "success") {
					alert("修改完成");
				} else {
					alert(data);
				}
			}
		</script>
	</head>
	<body leftmargin="0" topmargin="0"
		style="filter: progid :   DXImageTransform.Microsoft.Gradient (   startColorStr =   '#6daf2f', endColorStr =   '#ffffff', gradientType =   '0' )">
		<form action="" method="post" name="user" >
		<s:hidden name="id"/>
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
					修改密码
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
							<td width="23%">
								&nbsp;
							</td>
							<td width="77%">
								&nbsp;
							</td>
						</tr>
						<tr>
							<td colspan="2" class="admin_title2">
								您可以在这里修改您的密码
							</td>
						</tr>
						<tr>
							<td>
								旧密码：
							</td>
							<td>
								<label>
									<input type="password" name="oldpass">
								</label>
							</td>
						</tr>
						<tr>
							<td>
								新密码：
							</td>
							<td>
								<input type="password" name="password">
							</td>
						</tr>
						<tr>
							<td>
								确认新密码：
							</td>
							<td>
								<input type="password" name="repat">
							</td>
						</tr>
						<tr>
							<td colspan="2">
								&nbsp;
							</td>
						</tr>
						<tr>
							<td colspan="2" align="center">
								<input type="button" name="Submit" value="修改" onclick="doSubmit()">
							</td>
						</tr>
						<tr>
							<td colspan="2">
								&nbsp;
							</td>
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