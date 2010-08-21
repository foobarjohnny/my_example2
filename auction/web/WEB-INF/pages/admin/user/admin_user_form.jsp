<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<html>
	<head>
		<%@ include file="/resources/resources.jsp"%>
	</head>
	<body>
		<div align="center" class="admin_title1">
			——用户列表管理——
		</div>
		<hr>
		<s:form action="userSave.action" name="form1">
			<s:hidden name="id" />
			<s:hidden name="methodName" />
			<table width="100%" border="1" cellpadding="10" cellspacing="0"
				bordercolor="#FFFFFF" bgcolor="#EEEEEE">
				<tr>
					<td width="22%" align="right" valign="middle">
						用户名称：
					</td>
					<td width="78%">
						<s:textfield name="username" />
					</td>
				</tr>
				<tr>
					<td width="22%" align="right" valign="middle">
						密码：
					</td>
					<td width="78%">
						<s:password name="password" />
					</td>
				</tr>
				<tr>
					<td width="22%" align="right" valign="middle">
						密码确认：
					</td>
					<td width="78%">
						<s:password name="password1" />
					</td>
				</tr>
				<tr>
					<td width="22%" align="right" valign="middle">
						姓名：
					</td>
					<td width="78%">
						<s:textfield name="realname" />
					</td>
				</tr>
				<tr>
					<td width="22%" align="right" valign="middle">
						邮箱：
					</td>
					<td width="78%">
						<s:textfield name="email" />
					</td>
				</tr>
				<tr>
					<td width="22%" align="right" valign="middle">
						联系电话：
					</td>
					<td width="78%">
						<s:textfield name="telphone" />
					</td>
				</tr>
				<tr>
					<td width="22%" align="right" valign="middle">
						联系地址：
					</td>
					<td width="78%">
						<s:textfield name="address" />
					</td>
				</tr>
				<tr align="right">
					<td colspan="2">
						<div align="center">
							<input type="submit" name="Submit" value=" 保存设置 ">
						</div>
					</td>
				</tr>
			</table>
		</s:form>
	</body>
</html>