<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<html>
	<head>
		<%@ include file="/resources/resources.jsp"%>
	</head>
	<body>
		<div align="center" class="admin_title1">
			——问题与建议——
		</div>
		<hr>
		<s:form action="problemSave.action" name="form1">
			<s:hidden name="id" />
			<table width="100%" border="1" cellpadding="10" cellspacing="0"
				bordercolor="#FFFFFF" bgcolor="#EEEEEE">
				<tr>
					<td width="22%" align="right" valign="middle">
						留言标题：
					</td>
					<td width="78%">
						<s:property value="title" />
						<s:hidden name="title" />
					</td>
				</tr>
				<tr>
					<td align="right" valign="middle">
						留言内容：
					</td>
					<td width="78%">
						<s:property value="substance" />
						<s:hidden name="substance" />
					</td>
				</tr>
				<tr>
					<td align="right" valign="middle">
						回复内容：
					</td>
					<td>
						<s:textarea name="details" />
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