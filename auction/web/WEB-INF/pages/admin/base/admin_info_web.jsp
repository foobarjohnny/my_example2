<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<html>
	<head>
		<%@ include file="/resources/resources.jsp"%>
		<script type="text/javascript">
			function FCKeditor_OnComplete(editorInstance) {
				window.status = editorInstance.Description;
			}
		</script>
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
			<table width="100%" border="0" cellpadding="10" cellspacing="0"
				bordercolor="#FFFFFF" bgcolor="#EEEEEE" height="100%">
					<td width="100%" height="90%" >
						<s:hidden name="info" id="info"></s:hidden>
						<fck:editor instanceName="info" height="800"  width="800">
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