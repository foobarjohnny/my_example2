<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>

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
		<td width="775" valign="top" bgcolor="#FFFFFF">&nbsp;&nbsp;<img src="images/ulogin.gif" width="123" height="28"> </td>
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
			<table width="100%" border="0" cellspacing="0" cellpadding="10">
              <tr>
                <td colspan="2" align="right" valign="top"><p>&nbsp;</p></td>
                </tr>
              <tr>
                <td width="27%" align="right" valign="top"><img src="images/_pigeon_icon.gif" width="64" height="62"></td>
                <td width="73%"><p class="indexjg">您的注册信息已经注册成功！激活邮件已经发至您的邮箱</p>
                    <p>请查收邮件。并点击邮件中的激活链接，完成激活。</p>
                  <p> ${email } 重新发送 </p></td>
              </tr>
              <tr>
                <td align="right" valign="top">&nbsp;</td>
                <td><img src="images/loginemail.gif" width="166" height="49">&nbsp;</td>
              </tr>
              <tr>
                <td colspan="2" align="center" valign="top"><p>如果10分钟还未收到邮件，请您更换邮箱试试！</p>
                    <p>
                      <input name="textfield3" type="text" size="30">
                      <input type="submit" name="Submit3" value="发送">
                  </p></td>
              </tr>
          </table>
		</td>
	</tr>
	<tr>
		<td colspan="3" height="20" align="center" background="images/r_dow.gif">
			&nbsp;
		</td>
	</tr>
</table>