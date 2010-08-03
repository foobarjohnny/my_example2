<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<html>
	<head>
		<%@ include file="/resources/resources.jsp"%>
	</head>
	<body>
		<div align="center" class="admin_title1">
			——增加机器人——
		</div>
		<hr>
		<s:form action="rebotSave.action" name="form1">
			<s:hidden name="id" />
			<s:hidden name="methodName" />
			<table width="100%" border="1" cellpadding="10" cellspacing="0"
				bordercolor="#FFFFFF" bgcolor="#EEEEEE">
				<tr>
					<td width="27%" align="right">
						机器人名称：
					</td>
					<td width="73%">
						<s:textfield name="rebotname" />
					</td>
				</tr>
				<tr>
					<td align="right">
						邮箱：
					</td>
					<td>
						<s:textfield name="email" />
					</td>
				</tr>
				<tr>
					<td align="right">
						手机号：
					</td>
					<td>
						<s:textfield name="telphone" />
					</td>
				</tr>
				<tr>
					<td align="center" colspan="2">
						设置竞拍商品：<a href="commoditySelect.action" target="_blank">[选择商品]</a>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<table id="detials">
							<tr>
								<td>
									商品名称
								</td>
								<td>
									现价
								</td>
								<td>
									开始价格
								</td>
								<td>
									终止价格
								</td>
								<td>
									竞拍时间
								</td>
								<td>
									移除
								</td>
							</tr>
						</table>
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