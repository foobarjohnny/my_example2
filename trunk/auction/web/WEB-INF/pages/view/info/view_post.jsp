<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<%@ include file="/resources/resources.jsp"%>

<table width="795" border="0" align="center" valign="top" cellpadding="0" cellspacing="0">
	<tr>
		<td colspan="4" height="20" align="center" background="images/r_top.gif" width="795">
			&nbsp;
		</td>
	</tr>	
	<tr>
		<td width="10" rowspan="3" background="images/r_left.gif">
			<img src="images/r_left.gif" width="10" height="1">
		</td>
		<td width="387" valign="top" bgcolor="#FFFFFF">
			&nbsp;&nbsp;
			<img src="images/gg.gif" width="123" height="28">
		</td>
		<td width="388" align="right" bgcolor="#FFFFFF">
			&nbsp;&nbsp;
		</td>
		<td width="10" rowspan="3" background="images/r_right.gif">
			<img src="images/r_right.gif" width="10" height="1">
		</td>
	</tr>
	<tr>
		<td colspan="4" valign="top" background="images/hr.gif" height="1">
		</td>
	</tr>
	<tr>
		<td colspan="2" valign="top" bgcolor="#FFFFFF">
			<table width="99%" border="0" align="center" cellpadding="10"
							cellspacing="0">
				<tr>
					<td width="74%" align="center" class="indexjg">
						${model.title }
					</td>
				</tr>
				<tr>
					<td>
						${model.info }
					</td>
				</tr>
			</table>
		</td>
	</tr>

	<tr>
		<td colspan="4" height="20" align="center" background="images/r_dow.gif" width="795">
			&nbsp;
		</td>
	</tr>	
</table>
