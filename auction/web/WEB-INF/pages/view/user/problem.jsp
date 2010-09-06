<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<html>
	<head>
		<%@ include file="/resources/resources.jsp"%>

	</head>
	<body>
		<table width="795" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td colspan="4">
					<img src="images/r_top.gif" width="795" height="20">
				</td>
			</tr>
			<tr>
				<td width="10" rowspan="3" background="images/r_left.gif">
					<img src="images/r_left.gif" width="10" height="1">
				</td>
				<td width="387" valign="top" bgcolor="#FFFFFF">
					&nbsp;&nbsp;
					<img src="images/wtyj.gif" width="99" height="28">
				</td>
				<td width="388" align="right" bgcolor="#FFFFFF">
					&nbsp;&nbsp;
				</td>
				<td width="10" rowspan="3" background="images/r_right.gif">
					<img src="images/r_right.gif" width="10" height="1">
				</td>
			</tr>
			<tr>
				<td colspan="2" valign="top" background="images/hr.gif">
					<img src="images/hr.gif" width="1" height="1">
				</td>
			</tr>
			<tr>
				<td colspan="2" valign="top" bgcolor="#FFFFFF">
					<form name="form1" method="post" action="proSave.action">
						<table width="100%" border="0" cellspacing="0" cellpadding="10">
							<tr>
								<td colspan="2" align="right" valign="top">
									&nbsp;
								</td>
							</tr>
							<tr>
								<td width="27%" align="right" valign="top">
									标题：
								</td>
								<td width="73%">
									<input name="title" type="text" size="50">
								</td>
							</tr>
							<tr>
								<td align="right" valign="top">
									您的用户名：
								</td>
								<td>
									<span class="indexsp">${username }</span>
									<input name="userId" type="hidden" size="50" value="${userId }">
								</td>
							</tr>
							<tr height="500">
								<td align="right" valign="top">
									您的问题与建议：
								</td>
								<td>
									<s:hidden name="substance" id="info"></s:hidden>
									<fck:editor instanceName="info" height="100%">
										<jsp:attribute name="value">&nbsp;
										</jsp:attribute>
									</fck:editor>
								</td>
							</tr>
							<tr>
								<td colspan="2" align="center">
									<input type="submit" name="Submit2" value="提交">
								</td>
							</tr>

						</table>
			</form>
			</td>
			</tr>
			<tr>
				<td colspan="4">
					<img src="images/r_dow.gif" width="795" height="20">
				</td>
			</tr>
		</table>
	</body>
</html>