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
			——服务器参数探针——
		</div>
		<hr>
		<table width="100%" border="1" cellpadding="10" cellspacing="0"
			bordercolor="#FFFFFF" bgcolor="#EEEEEE">
			<form action="" method="post" enctype="multipart/form-data"
				name="form1">
				<tr>
					<td width="28%" align="right" valign="middle">
						&nbsp;
					</td>
					<td width="72%">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td width="28%" align="right" valign="middle">
						&nbsp;
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
			</form>
		</table>

	</body>
</html>