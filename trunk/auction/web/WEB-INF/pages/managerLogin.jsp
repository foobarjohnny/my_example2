<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<%@ include file="/resources/resources.jsp"%>
<form action="LoginForm.action" method="post" name="LoginBean">
	<table width="795" border="0" align="center" valign="top" cellpadding="0" cellspacing="0">
		<tr>
			<td colspan="4" height="20" align="center"
				background="images/r_top.gif">
				&nbsp;
			</td>
		</tr>
		<tr height="20">
			<td width="10" rowspan="3" background="images/r_left.gif">
				&nbsp;
			</td>
			<td width="387" valign="top" align="left" bgcolor="#FFFFFF">
				<img src="images/login.gif" width="99" height="28">
			</td>
			<td width="388" align="right" bgcolor="#FFFFFF">
			</td>
			<td width="10" rowspan="3" background="images/r_right.gif">
				&nbsp;
			</td>
		</tr>
		<tr>
			<td colspan="2" height="20" align="center"  bgcolor="#FFFFFF">
				<table width="100%" border="0" cellspacing="0" cellpadding="5">
	            <tr>
	              <td width="20%" align="center">用户名：</td>
	              <td width="80%" align="left">
	                <input name="loginUser" type="text" value="请输入登录帐号"  onfocus="clearThis(this);" size="12">
	              </td>
	            </tr>
	            <tr>
	              <td width="20%" align="center">密&nbsp;&nbsp;码：</td>
	              <td width="80%" align="left">
	                <input name="loginPassword" type="password" value="请输入登录的密码" onfocus="clearThis(this);" size="12"></td>
	            </tr>
	            </table>
			</td>
		</tr>
		<tr>
			<td colspan="2" height="20" align="center"  bgcolor="#FFFFFF">
				<table width="100%" border="0" cellspacing="0" cellpadding="5">
				<tr>
	              <td align="center">
	              	<img src="images/dl.gif" width="40" height="22" onclick="loginSys();"/>
					<img src="images/hr.gif" width="1" height="1">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="reg.action">
						<img src="images/hr.gif" width="1" height="1"><img src="images/zc.gif" width="41" height="22" border="0"> 
					</a>
	              </td>
	            </tr>
				</table>
			</td>
		</tr>
		<tr>
			<td colspan="4" height="20" align="center"
				background="images/r_dow.gif">
				&nbsp;
			</td>
		</tr>
	</table>
</form>

<script type="text/javascript">
	function clearThis(obj){
		obj.value = "";
	}

	function loginSys(){
		var username = document.getElementById("loginUser").value;
		var password = document.getElementById("loginPassword").value;
		if(username == ''){
			alert("请输入您的用户名！");
			document.getElementById("loginUser").focus();
			return false;
		}
		if(password == ''){
			alert("请输入您的密码！");
			document.getElementById("loginPassword").focus();
			return false;
		}
		loginRomet.managerLogin(username, password, callBackHandlerSystem);
	}
	function callBackHandlerSystem(data) {
		if(data != '' &&  data != "error"){
			window.location="./index.action";
		}else{
			alert("您的用户名或者密码不正确，请重新输入！");
			window.location="./managerLogin.action";
		}
	}
	
</script>