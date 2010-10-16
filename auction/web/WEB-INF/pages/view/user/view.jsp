<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<%@ include file="/resources/resources.jsp"%>
<form action="saveShowcom.action" method="post" name="user" >
<s:hidden name="id"/>
<table width="795" border="0" align="center" cellpadding="0"
	cellspacing="0">
	<tr>
		<td colspan="3" width="795" height="20" background="images/r_top.gif">
		</td>
	</tr>
	<tr>
		<td width="10" rowspan="3" background="images/r_left.gif">
			<img src="images/r_left.gif" width="10" height="1">
		</td>
		<td width="775" height="40" align="center" bgcolor="#FFFFFF"
			class="admin_title1">
			秀宝发布
		</td>
		<td width="10" rowspan="3" background="images/r_right.gif">
			<img src="images/r_right.gif" width="10" height="1">
		</td>
	</tr>
	<tr>
		<td colspan="3" valign="top" background="images/hr.gif" height="1">
		</td>
	</tr>
	<tr>
		<td valign="top" bgcolor="#FFFFFF">
			<table width="100%" border="0" align="center" cellpadding="10"
				cellspacing="0">
				<tr>
					<td width="23%">
						&nbsp;
					</td>
					<td width="77%">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td>
						竞拍商品：
					</td>
					<td>
						<label>
							${tradename }
							<input type="hidden" name="tradeId" value="${tradeId }">
							<input type="hidden" name="userID" value="${userID }">
						</label>
					</td>
				</tr>
				<tr>
					<td>
						秀宝标题：
					</td>
					<td>
						<input type="text" name="title" value="">
					</td>
				</tr>
				<tr>
					<td height="750" colspan="2">
						<s:hidden name="remark" id="remark"></s:hidden>
						<fck:editor instanceName="remark" height="100%">
							<jsp:attribute name="value">&nbsp;
							</jsp:attribute>
						</fck:editor>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" name="Submit" value="发表" >
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td colspan="3">
			<img src="images/r_dow.gif" width="795" height="20">
		</td>
	</tr>
</table>
</form>