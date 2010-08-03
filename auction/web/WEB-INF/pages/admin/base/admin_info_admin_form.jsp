<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<html>
	<head>
		<%@ include file="/resources/resources.jsp"%>
	</head>
	<body>
		<div align="center" class="admin_title1">
			——增加管理员——
		</div>
		<hr />
		<s:form action="managerSave.action" name="form1">
			<s:hidden name="id"/>
			<table width="100%" border="1" cellpadding="10" cellspacing="0"
				bordercolor="#FFFFFF" bgcolor="#EEEEEE">
				<tr>
					<td width="32%" align="right">
						管理员账号：
					</td>
					<td width="68%">
						<s:textfield name="account"/>
					</td>
				</tr>
				<tr>
					<td align="right">
						真实姓名：
					</td>
					<td>
						<s:textfield name="realname"/>
					</td>
				</tr>
				<tr>
					<td align="right">
						密码：
					</td>
					<td>
						<s:password name="password"/>
					</td>
				</tr>
				<tr>
					<td align="right">
						密码确认：
					</td>
					<td>
						<input name="textfield22" type="password" size="30" />
					</td>
				</tr>
				<tr>
					<td align="right">
						联系电话：
					</td>
					<td>
						<s:textfield name="telphone"/>
					</td>
				</tr>
				<tr>
					<td align="right">
						管理权限：
					</td>
					<td>
						<s:if test="managerFuns.length > 0">

								<s:checkboxlist list="#{1:'商品管理',2:'订单管理',3:'用户管理',4:'机器人管理',5:'广告管理'}" name="managerFuns" />

						</s:if>
						<s:else>
							<s:checkboxlist list="#{1:'商品管理',2:'订单管理',3:'用户管理',4:'机器人管理',5:'广告管理'}" name="managerFuns"/>
						</s:else>
					</td>
				</tr>
				<tr align="right">
					<td colspan="2">
						<div align="center">
							<input type="submit" name="Submit" value=" 保存设置 " />
							&nbsp;&nbsp;
						</div>
					</td>
				</tr>
			</table>
		</s:form>
	</body>
</html>