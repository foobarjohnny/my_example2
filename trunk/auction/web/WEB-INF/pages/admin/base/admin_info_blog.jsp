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
			——网站日志——
		</div>
		<hr>
		<table width="100%" border="1" cellpadding="10" cellspacing="0"
			bordercolor="#FFFFFF" bgcolor="#EEEEEE">
			<tr>
				<td width="15%" align="center" valign="middle">
					<strong>管理员</strong>
				</td>
				<td width="16%" align="center" valign="middle">
					<strong>登录时间</strong>
				</td>
				<td width="17%" align="center">
					<strong>离线时间</strong>
				</td>
				<td width="46%" align="center">
					<strong>描述</strong>
				</td>
				<td width="6%" align="center">
					<strong>操作</strong>
				</td>
			</tr>
			<tr>
				<td align="center" valign="middle">
					&nbsp;
				</td>
				<td align="center" valign="middle">
					&nbsp;
				</td>
				<td align="center">
					&nbsp;
				</td>
				<td align="center">
					&nbsp;
				</td>
				<td align="center">
					删除
				</td>
			</tr>
			<tr align="right">
				<td colspan="5">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="51%">
								选择全部
								<input type="checkbox" name="checkbox3" value="checkbox" />
								<input type="submit" name="Submit" value="批量删除" />
							</td>
							<td width="49%" align="right">
								共N条&nbsp;&nbsp;首页&nbsp;&nbsp;上一页&nbsp;&nbsp;下一页&nbsp;&nbsp;尾页&nbsp;&nbsp;
								<select name="select2">
								</select>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>
