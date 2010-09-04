<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<html>
	<head>
		<%@ include file="/resources/resources.jsp"%>
	</head>
	<body>
		<div align="center" class="admin_title1">
			——发布酷品——
		</div>
		<hr>
		<s:form action="publisSave.action" name="form1" method="post" enctype="multipart/form-data">
			<s:hidden name="id" />
			<table width="100%" border="1" cellpadding="10" cellspacing="0"
				bordercolor="#FFFFFF" bgcolor="#EEEEEE">
				<tr>
					<td width="22%" align="right" valign="middle">
						商品名称：
					</td>
					<td width="78%">
						<s:textfield name="tradename" />
					</td>
				</tr>
				<tr>
					<td width="22%" align="right" valign="middle">
						市场价：
					</td>
					<td width="78%">
						<s:textfield name="price" />元
					</td>
				</tr>
				<tr>
					<td width="22%" align="right" valign="middle">
						预计开始时间：
					</td>
					<td width="78%">
						<s:textfield name="starttime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly="true"/>
					</td>
				</tr>
				<tr>
					<td width="22%" align="right" valign="middle">
						上传图片：
					</td>
					<td width="78%">
						<table>
							<tr>
								<td><s:file name="files"/></td>
							</tr>
							<tr>
								<td><s:file name="files"/></td>
							</tr>
							<tr>
								<td><s:file name="files"/></td>
							</tr>
							<tr>
								<td><s:file name="files"/></td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td width="22%" align="right" valign="middle">
						商品简介：
					</td>
					<td width="78%">
						<s:hidden name="remark" id="remark"/>
						<fck:editor instanceName="remark" height="100%">
							<jsp:attribute name="value">&nbsp;
							</jsp:attribute>
						</fck:editor>
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