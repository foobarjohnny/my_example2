<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<html>
	<head>
		<%@ include file="/resources/resources.jsp"%>
	</head>
	<body>
		<div align="center" class="admin_title1">
			——心得与窍门详细内容——
		</div>
		<hr />
		<table width="100%" border="1" cellpadding="10" cellspacing="0"
			bordercolor="#FFFFFF" bgcolor="#EEEEEE">
			<tr>
				<td width="32%" align="right">
					发布人：
				</td>
				<td width="68%">
					${username }
				</td>
			</tr>
			<tr>
				<td align="right">
					发布时间：
				</td>
				<td>
					${addtime }
				</td>
			</tr>
			<tr>
				<td align="right">
					标题：
				</td>
				<td>
					${title }
				</td>
			</tr>
			<tr>
				<td align="right">
					内容：
				</td>
				<td>
					${remark }
				</td>
			</tr>
		</table>
	</body>
</html>