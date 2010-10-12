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
			<form method="post" action="userReg.action" name="registerForm" >
				<s:hidden name="regId"></s:hidden>
				<table width="100%" border="0" cellspacing="0" cellpadding="10">
					<tr>
		              <td width="27%" align="right" valign="top">用户名：</td>
		              <td width="40%"><input name="username" id="username" type="text" size="30" maxlength="12"></td>
		              <td id="formError_username" >&nbsp;
					  </td>
		            </tr>
		            <tr>
		              <td align="right" valign="top">密码：</td>
		              <td><input name="password" type="password" id="password" size="30" maxlength="12"></td>
		              <td id="formError_password" valign="top">&nbsp;</td>
		            </tr>
		            <tr>
		              <td align="right" valign="top">密码确认：</td>
		              <td><input name="password1" type="password" size="30" id="passwordTwo" maxlength="12"></td>
		              <td id="formError_passwordTwo" valign="top">&nbsp;</td>
		            </tr>
		            <tr>
		              <td align="right" valign="top">邮箱：</td>
		              <td><input name="email" type="text" size="30" maxlength="30" id="userEmail"></td>
		              <td id="formError_userEmail" valign="top">&nbsp;</td>
		            </tr>
		            <tr>
		              <td colspan="2" align="center"><img src="images/userzc.gif" width="166" height="49" onclick="doSubmit();" style="cursor: hand;"></td>
		              <td>&nbsp;</td>
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
<script type="text/javascript">
	function doSubmit() {
		$("#formError_username").html('');
		$("#formError_password").html('');
		$("#formError_passwordTwo").html('');
		$("#formError_userEmail").html('');
		var username = registerForm.username.value;
		if(username == '') {
			$("#formError_username").html('<div id="formError_deny_username">会员名不能为空</div>');
			return false;
		} 
		var password = registerForm.password.value;
		if(password == ''){
			$("#formError_password").html('<div id="formError_deny_username">密码不能为空</div>');
			return false;
		}
		var password1 = registerForm.password1.value;
		if(password != password1){
			$("#formError_passwordTwo").html('<div id="formError_deny_username">密码不匹配</div>');
			return false;
		}
		var userEmail = registerForm.email.value;
		if(userEmail == ''){
			$("#formError_userEmail").html('<div id="formError_deny_username">邮箱不能为空</div>');
			return false;
		}
		loginRomet.checkedEmail(userEmail,username, callEmail);
	}
	function callEmail(data) {
		if (data != "success") {
			var msg = data.split(",");
			$("#formError_userEmail").html('<div id="formError_deny_username">' + msg[0] + '</div>');
			$("#formError_username").html('<div id="formError_deny_username">' + msg[1] + '</div>');
			return false;
		} else {
			registerForm.submit();
		}
	}
</script>