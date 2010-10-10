<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>

<form action="LoginForm.action" method="post" name="LoginBean">
	<table width="795" border="0" align="center" valign="top" cellpadding="0" cellspacing="0">
		<tr>
			<td colspan="4" height="20" align="center"
				background="images/r_top.gif">
				&nbsp;
			</td>
		</tr>
		<tr height="20">
			<td width="10" rowspan="4" background="images/r_left.gif">
				&nbsp;
			</td>
			<td width="387" valign="top" align="left" bgcolor="#FFFFFF">
				<img src="images/user.gif" width="123" height="28">
			</td>
			<td width="388" align="right" bgcolor="#FFFFFF">
			</td>
			<td width="10" rowspan="4" background="images/r_right.gif">
				&nbsp;
			</td>
		</tr>
		<tr>
			<td colspan="2" height="20" align="center"  bgcolor="#FFFFFF">
				<table width="200" border="0" cellspacing="0" cellpadding="5">
	            <tr>
	              <td width="40%" align="right">用户名：</td>
	              <td align="left">
	                <input name="loginUser" type="text" value="请输入登录帐号"  onfocus="clearThis(this);" size="12">
	              </td>
	            </tr>
	            <tr>
	              <td width="40%" align="right">密&nbsp;&nbsp;码：</td>
	              <td align="left">
	                <input name="loginPassword" type="password" value="请输入登录的密码" onfocus="clearThis(this);" size="12"></td>
	            </tr>
	            </table>
			</td>
		</tr>
		<tr>
			<td colspan="2" height="20" bgcolor="#FFFFFF">&nbsp;</td>
		</tr>
		<tr>
			<td colspan="2" height="20" align="center"  bgcolor="#FFFFFF">
				<table width="200" border="0" cellspacing="0" cellpadding="5">
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
		loginRomet.login(username, password, callBackHandlerSystem);
	}
	function callBackHandlerSystem(data) {
		var s = data.split(",");
		if (data != "error") {
			document.getElementById("userLogin").style.display = "none";
			document.getElementById("displayUser").style.display = "block";
			document.getElementById("userId").value = s[1];
			document.getElementById("user").innerHTML = s[0];
			document.getElementById("payNum").innerHTML=s[3];
			document.getElementById("freeNum").innerHTML=s[2];
			document.getElementById("winGoods").innerHTML=s[4];
			//为了刷新右侧的页面的状态
			window.location="./show.action";
		}else{
			alert("您的用户名或者密码不正确，请重新输入！");
			window.location="./login.action";
		}
	}
	
</script>