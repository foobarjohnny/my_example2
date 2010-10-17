<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<script>
	function send() {
		var email = formx.email.value;
		if (email == "") {
			$("#formError_userEmail").html('<div id="formError_deny_username">邮箱不能为空</div>');
		} else {
			formx.submit();
		}
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
                <td width="73%">
                	<p class="indexjg">
                		您已经注册成功
					</p>
					<p  class="indexjg">
						您的用户名和密码已经发至您的邮箱请妥善保管。
					</p>
					<p  class="indexjg">
						接下来体验全新的购物吧>>>
                	</p>
                  <p> 您当前的邮件地址是: ${email }  </p></td>
              </tr>
              <tr>
                <td align="right" valign="top">&nbsp;</td>
                <!-- 
                <td><img src="images/loginemail.gif" width="166" height="49">&nbsp;</td>
                 -->
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