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
		<div align="center" class="admin_title1">
			——数据库备份——
		</div>
		<hr>
	
		<s:form action="mysqlDataBackup.action" name="form1">
			<s:hidden name="id"/>
			<table width="100%" border="1" cellpadding="10" cellspacing="0"
				bordercolor="#FFFFFF" bgcolor="#EEEEEE">
				<tr>
					<td width="28%" align="right" valign="middle">
						当前数据库路径：
					</td>
					<td width="72%">
						<s:textfield name="srcDir" size="80"/>
					</td>
				</tr>
				<tr>
					<td width="28%" align="right" valign="middle">
						当前数据库路径：
					</td>
					<td>
						<s:textfield name="destDir" size="80"/>
					</td>
				</tr>
				<tr align="right">
					<td colspan="2">
						<div align="center">
							<input type="submit" name="Submit" value="开始备份">
						</div>
					</td>
				</tr>
			</table>
		</s:form>
	</body>
</html>