<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<html>
	<head>
		<%@ include file="/resources/resources.jsp"%>
	</head>
	<body>
		<div align="center" class="admin_title1">
			——发布新商品——
		</div>
		<hr>
		<s:form action="commoditySave.action" name="form1">
			<s:hidden name="id" />
			<s:hidden name="methodName" />
			<table width="100%" border="1" cellpadding="10" cellspacing="0"
				bordercolor="#FFFFFF" bgcolor="#EEEEEE">
				<tr>
					<td width="27%" align="right">
						商品名称：
					</td>
					<td width="73%">
						<s:textfield name="tradename" />
					</td>
				</tr>
				<tr>
					<td align="right">
						所属类别：
					</td>
					<td>
						<s:select list="sortList" listKey="id" listValue="sortname" name="sortId"/>
					</td>
				</tr>
				<tr>
					<td align="right">
						市场价：
					</td>
					<td>
						<s:textfield name="marketPrice" />
						元
					</td>
				</tr>
				<tr>
					<td align="right">
						现在购买价：
					</td>
					<td>
						<s:textfield name="purchasePrice" />
						元
					</td>
				</tr>
				<tr>
					<td align="right">
						竞拍上浮价：
					</td>
					<td>
						<s:textfield name="markUp" />
						元
					</td>
				</tr>
				<tr>
					<td align="right">
						每次竞价消耗E拍币：
					</td>
					<td>
						<s:textfield name="consume" />
						枚
					</td>
				</tr>
				<tr>
					<td align="right">
						竞拍E拍币限制：
					</td>
					<td>
						<s:radio list="#{1:'无限制',2:'收费E拍币',3:'免费E拍币'}" name="restricts"/>
					</td>
				</tr>
				<tr>
					<td align="right">
						竞拍开始时间：
					</td>
					<td>
						<s:textfield name="starttime" />
					</td>
				</tr>
				<tr>
					<td align="right">
						竞拍终止时间：
					</td>
					<td>
						<s:textfield name="endtime" />
						小时
					</td>
				</tr>
				<tr>
					<td align="right">
						竞拍增加时间：
					</td>
					<td>
						<s:textfield name="addtimes" />
						秒
					</td>
				</tr>
				<tr>
					<td align="right">
						上传图片：
					</td>
					<td>
						（此处仿淘宝上传图片形式）
					</td>
				</tr>
				<tr>
					<td align="right">
						商品简介：
					</td>
					<td>
						<s:textarea name="summary"/>
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