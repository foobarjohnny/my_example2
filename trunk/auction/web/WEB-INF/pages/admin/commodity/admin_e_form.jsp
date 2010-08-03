<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<html>
	<head>
		<%@ include file="/resources/resources.jsp"%>
	</head>
	<body>
		<div align="center" class="admin_title1">
			——添加E拍币购买规则——
		</div>
		<hr>
		<s:form action="ecurrSave.action" name="form1">
			<s:hidden name="id" />
			<s:hidden name="methodName" />
			<table width="100%" border="1" cellpadding="10" cellspacing="0"
				bordercolor="#FFFFFF" bgcolor="#EEEEEE">
				<tr>
					<td width="22%" align="right" valign="middle">
						描述：
					</td>
					<td width="78%">
						<s:textfield name="remark" />
					</td>
				</tr>
				<tr>
					<td width="22%" align="right" valign="middle">
						购买E拍币数量：
					</td>
					<td width="78%">
						<s:textfield name="amount" />
					</td>
				</tr>
				<tr>
					<td width="22%" align="right" valign="middle">
						需要支付款：
					</td>
					<td width="78%">
						<s:textfield name="paymoney" />
					</td>
				</tr>
				<tr>
					<td width="22%" align="right" valign="middle">
						赠送E拍币数量
					</td>
					<td width="78%">
						<s:textfield name="freecount" />枚
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