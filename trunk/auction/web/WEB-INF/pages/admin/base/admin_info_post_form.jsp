<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<html>
	<head>
		<%@ include file="/resources/resources.jsp"%>
	</head>
	<body>
		<div align="center" class="admin_title1">
			——增加帮助条款——
		</div>
		<hr>
		<s:form action="infoSave.action" name="form1">
			<s:hidden name="id"/>
			<s:hidden name="nettype" value="5"/>
			<table width="100%" border="1" cellpadding="10" cellspacing="0"
				bordercolor="#FFFFFF" bgcolor="#EEEEEE" height="100%">
				<tr height="10%">
					<td width="22%" align="right">
						标题：
					</td>
					<td width="78%">
						<s:textfield name="title" size="30"/>
					</td>
				</tr>
				<tr height="80%">
					<td align="right">
						内容：
					</td>
					<td>
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
							<input type="submit" name="Submit" value=" 保存设置 " />
							&nbsp;&nbsp;
						</div>
					</td>
				</tr>
			</table>
		</s:form>
	</body>
</html>