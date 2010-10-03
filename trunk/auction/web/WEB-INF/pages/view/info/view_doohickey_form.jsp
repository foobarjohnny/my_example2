<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<table width="795" border="0" align="center" cellpadding="0" cellspacing="0">
	<tr>
		<td colspan="4" align="center" background="images/r_top.gif">
			&nbsp;
		</td>
	</tr>
	<tr>
		<td width="10" rowspan="3" background="images/r_left.gif">
			<img src="images/r_left.gif" width="10" height="1">
		</td>
		<td width="387" valign="top" bgcolor="#FFFFFF">
			&nbsp;&nbsp;
			<img src="images/xdyqm.gif" width="123" height="28">
		</td>
		<td width="388" align="right" bgcolor="#FFFFFF">
			&nbsp;&nbsp;
		</td>
		<td width="10" rowspan="3" background="images/r_right.gif">
			<img src="images/r_right.gif" width="10" height="1">
		</td>
	</tr>
	<tr>
		<td colspan="2" valign="top" background="images/hr.gif" height="1">
		</td>
	</tr>
	<tr>
		<td colspan="2" valign="top" bgcolor="#FFFFFF">
		<form action="doohickeySave.action" method="post">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
	            	<td align="right" >标题：</td>
	            	<td align="left" >
	            		<input type="text" name="title">
	            	</td>
	            </tr>
	            <tr>
	            	<td align="right" >发布人：</td>
	            	<td align="left" >
	            		<input type="text" name="username" value="${username }" readonly="readonly">
	            	</td>
	            </tr>
		        <tr>
		            <td align="right">内容：</td>
		            <td align="left" >
		            	<textarea rows="10" cols="50" name="remark"></textarea>
		            </td>
		        </tr>
		        <tr>
		            <td align="CENTER">
		            	<input type="submit"  value="发布" >
		            </td>
		        </tr>
			</table>
		</form>
		</td>
	</tr>
	<tr>
		<td colspan="4" height="20" align="center" background="images/r_dow.gif">
			&nbsp;
		</td>
	</tr>
</table>