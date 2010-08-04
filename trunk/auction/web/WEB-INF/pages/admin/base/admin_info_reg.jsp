<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<html>
	<head>
		<%@ include file="/resources/resources.jsp"%>
	</head>
	<body>
		<br>
		<div align="center" class="admin_title1">
			——注册协议设置——
		</div>
		<hr>
		<s:form action="infoSave.action" name="form1">
			<s:hidden name="nettype" value="4"/>
			<s:hidden name="id"/>
			<table width="100%" border="1" cellpadding="10" cellspacing="0"
				bordercolor="#FFFFFF" bgcolor="#EEEEEE" height="100%">
				<tr height="90%">
					<td width="22%" align="right" valign="middle">
						简介内容：
					</td>
					<td width="78%">
						<s:hidden name="info" id="info"></s:hidden>
						<fck:editor instanceName="info" height="100%">
							<jsp:attribute name="value">&nbsp;
							</jsp:attribute>
						</fck:editor>
					</td>
				</tr>
				<tr height="10%" align="right">
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