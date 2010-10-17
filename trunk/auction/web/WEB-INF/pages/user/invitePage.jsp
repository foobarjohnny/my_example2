<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<script>
	function copyURLEvent(){
		var regUrl = document.getElementById("copyURL");
		window.clipboardData.setData("Text",regUrl.value);
	}
</script>
<table width="795" border="0" align="center" cellpadding="0"
	cellspacing="0">
	<tr>
			<td colspan="3" height="20" align="center" background="images/r_top.gif">
				&nbsp;
			</td>
	</tr>
	<tr>
		<td width="10" rowspan="3" background="images/r_left.gif">
			<img src="images/r_left.gif" width="10" height="1">
		</td>
		<td width="775" valign="top" bgcolor="#FFFFFF" align="center">&nbsp;&nbsp; </td>
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
			<form action="invite.action" method="post" name="formy">
			<s:hidden name="regId"></s:hidden>
			<s:hidden name="url"></s:hidden>
			<table width="100%" border="0" cellspacing="0" cellpadding="10">
              <tr>
                <td  align="right" valign="top"><p>邀请好友：</p></td>
                <td  align="left" valign="top">
                	<p>
                	<input id="copyURL" type="text" name="signRegiste" value="${url }" size="100"/>
                	
                	<!--  
                	<input name="recAcout" type="text" size="50">(多个邮箱用分号分隔开)
                	-->
                	</p>
                	<p id="formError_userEmail" style="color: red;"></p>
                </td>
              </tr>
              <tr>
                <td colspan="2" align="center" valign="top">
                    <p>
                      <input type="button" name="Submit3" value="复制链接" onclick="copyURLEvent();">
                  	</p>
                </td>
              </tr>
          </table>
          </form>
		</td>
	</tr>
	<tr>
		<td colspan="3" height="20" align="center" background="images/r_dow.gif">
			&nbsp;
		</td>
	</tr>
</table>