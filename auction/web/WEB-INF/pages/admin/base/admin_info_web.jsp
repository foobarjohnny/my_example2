<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<html>
	<head>
		<%@ include file="/resources/resources.jsp"%>
	</head>
	<body>
		<br>
		<div align="center" class="admin_title1">
			——网站简介设置——
		</div>
		<hr>
		<s:form action="infoSave.action" name="form1">
			<s:hidden name="nettype" value="1"/>
			<s:hidden name="id"/>
			<table width="100%" border="1" cellpadding="10" cellspacing="0"
				bordercolor="#FFFFFF" bgcolor="#EEEEEE">
				<tr>
					<td width="22%" align="right" valign="middle">
						简介内容：
					</td>
					<td width="78%">
						<s:textarea name="info"/>
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