<%@ page language="java" pageEncoding="UTF-8"%>

<%@ include file="/resources/taglib.jsp"%>
<script type="text/javascript" src="js/dwr/loginRomet.js"></script>
<script type="text/javascript">
	function login() {
		var username = document.getElementById("username").value;
		var password = document.getElementById("password").value;
		loginRomet.login(username, password, callBackHandler);
	}
	function callBackHandler(data) {
		var s = data.split(",");
		if (data != "error") {
			document.getElementById("userLogin").style.display = "none";
			document.getElementById("displayUser").style.display = "block";
			document.getElementById("userId").value = s[1];
			document.getElementById("user").innerHTML = s[0];
			document.getElementById("payNum").innerHTML=s[3];
			document.getElementById("freeNum").innerHTML=s[2];
			document.getElementById("winGoods").innerHTML=s[4];
		}
		//为了刷新右侧的页面的状态
		window.location="http://localhost/auction/show.action";
	}
	function loginout() {
		loginRomet.loginOut(callHandler);
	}
	function callHandler() {
		document.getElementById("userId").value = "";
		document.getElementById("user").innerHTML = "";
		document.getElementById("payNum").innerHTML = "";
		document.getElementById("freeNum").innerHTML = "";
		document.getElementById("winGoods").innerHTML = "";
		document.getElementById("username").value = "";
		document.getElementById("password").value = "";
		document.getElementById("userLogin").style.display = "block";
		document.getElementById("displayUser").style.display = "none";

		//为了刷新右侧的页面的状态， 这个在部署的时候需要修改。
		window.location="http://localhost/auction/show.action";
	}
	function invite() {
		window.location.href = "invitePage.action"; 
	}
	function searchSort() {
		sort.submit();
	}
</script>

<table width="179" border="0" align="center" cellpadding="0" cellspacing="0">
	<tr>
		<td colspan="3" background="images/l_top.gif" height="21" width="179">
		</td>
	</tr>
	<tr>
		<td width="5" rowspan="9" background="images/l_left.gif">
			<img src="images/l_left.gif" width="5" height="1">
		</td>
		<td width="169" height="40" align="center" valign="top"
			bgcolor="#FFFFFF">
			<form action="showAll.action" method="post" name="sort">
			<s:select name="sort" list="sortDataList" listKey="id" listValue="sortname"
				headerKey="" headerValue="按类别查找商品" onchange="searchSort()"></s:select>
			</form>
		</td>
		<td width="5" rowspan="9" background="images/l_right.gif">
			<img src="images/l_right.gif" width="5" height="1">
		</td>
	</tr>
	<tr>
		<td align="center" bgcolor="#FFFFFF">
			<img src="images/login.gif" width="155" height="35">
		</td>
	</tr>
	<tr>
		<td align="center" bgcolor="#FFFFFF">
			<table width="100%" border="0" cellspacing="0" cellpadding="5">
				<tr id="userLogin" style="display: block">
					<td>
						<table>
							<tr>
								<td width="40%">
									用户名： 
								</td>
								<td>
									<input name="username" type="text" id="username" value="" size="8">
								</td>
							</tr>
							<tr>
								<td  width="40%">
									密&nbsp;&nbsp;&nbsp;码： 
								</td>
								<td>
									<input name="password" type="password" id="password" value="" size="10">
								</td>
							</tr>
							<tr>
								<td align="center" colspan="2">
									<img src="images/dl.gif" width="40" height="22" onclick="login();"/>
									<img src="images/hr.gif" width="1" height="1">
									<a href="reg.action"><img src="images/zc.gif" width="41"
											height="22" border="0"> </a>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr id="displayUser" style="display: none">
					<td>
						<table width="100%" border="0" cellspacing="0" cellpadding="2">
							<tr>
								<td width="50%">
									用户名：
								</td>
								<td align="left">
									<span class="indexsp" id="user">${login.workNo }</span>
									<input type="hidden" name="userId" id="userId" value="${login.id }"/>								
								</td>
							</tr>
							<tr>
								<td>
									付费易拍币：
								</td>
								<td align="left">
									<div id="payNum" class="indexsp">${login.paycur }</div>
								</td>
							</tr>
							<tr>
								<td>
									免费易拍币：
								</td>
								<td align="left">
									<div id="freeNum" class="indexsp">${login.freecur }</div>
								</td>
							</tr>
							<tr>
								<td>
									赢得的竞拍：
								</td>
								<td align="left">
									<div id="winGoods" class="indexsp">${login.amount }</div>
								</td>
							</tr>
							<tr>
								<td>
									<input type="button" value="邀请好友" alt="送20枚易拍币" onclick="invite()">
								</td>
								<td>
									<input type="button" value="退&nbsp;&nbsp;&nbsp;&nbsp;出" onclick="loginout();">
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td height="25" align="center">
						<!-- JiaThis Button BEGIN -->
						<a href="http://www.jiathis.com/share.html" class="jiathis"> <img
								src="http://www.jiathis.com/code/images/jiathis2.gif"
								width="125" height="21" border="0" id="jiathis_a" /> </a>
						<script type="text/javascript"
							src="http://www.jiathis.com/code/jia.js" charset=utf-8></script>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td align="center" bgcolor="#FFFFFF">
			<img src="images/wzgg.gif" width="155" height="35">
		</td>
	</tr>
	<tr>
		<td bgcolor="#FFFFFF">
			<table width="100%" border="0" cellspacing="0" cellpadding="3">
				<s:iterator id="post" value="postDataList">
					<tr>
						<td>
							<img src="images/dian.gif" width="5" height="5">
							<a href="infoView.action?model.nettype=5&model.id=${post.id }">${post.title
								}</a>
						</td>
					</tr>
				</s:iterator>
				<tr>
					<td align="right">
						<a href="infoViewList.action?model.nettype=5">更多</a>>>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td align="center" bgcolor="#FFFFFF">
			<img src="images/help.gif" width="155" height="35">
		</td>
	</tr>
	<tr>
		<td bgcolor="#FFFFFF">
			<table width="100%" border="0" cellspacing="0" cellpadding="3">
				<s:iterator id="help" value="helpDataList">
					<tr>
						<td>
							<img src="images/dian.gif" width="5" height="5">
							<a href="infoView.action?model.nettype=3&model.id=${help.id}">${help.title
								}</a>
						</td>
					</tr>
				</s:iterator>
				<tr>
					<td align="right">
						<a href="infoViewList.action?model.nettype=3">更多>></a>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td align="center" bgcolor="#FFFFFF">
			<img src="images/jpls.gif" width="155" height="35">
			&nbsp;
		</td>
	</tr>
	<tr>
		<td align="center" bgcolor="#FFFFFF">
			<table width="100%" border="0" cellspacing="0" cellpadding="3">
				<s:iterator id="bing" value="bingcurDataList">
					<tr>
						<td width="33%">
							<s:if test="imagesPath != null && imagesPath.size > 0">
								<img height="50" width="50" border="0" src="${imagesPath[0] }">
							</s:if>
							<s:else>
								<img height="50" width="50" border="0" >
							</s:else>
						</td>
						<td width="67%">
							<a href="bingcurForward.action?model.id=${bing.id}">${bing.user}以${bing.price
								}元竞拍下${bing.comityName }商品</a>
						</td>
					</tr>
				</s:iterator>
				<tr>
					<td colspan="2" align="right">
						<a href="bingcurSearch.action">更多>></a>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td colspan="3">
			<img src="images/l_dow.gif" width="179" height="21">
		</td>
	</tr>
	<tr>
		<td height="80" colspan="3" align="center">
			<!-- 开始 Comm100在线客服系统按钮代码 -->
			<div>
				<div id="comm100_LiveChatDiv"></div>
				<a href="http://www.comm100.cn/livechat/" onClick=
	comm100_Chat();;;
target="_blank" title="在线客服"><img id="comm100_ButtonImage"
						src="http://chatserver.comm100.cn/BBS.aspx?siteId=80008671&planId=201"
						border="0px" alt="在线客服" /> </a>
				<script
					src="http://chatserver.comm100.cn/js/LiveChat.js?siteId=80008671&planId=201"
					type="text/javascript"></script>
				<div id="comm100_track" style="z-index: 99; margin-top: 2px;"></div>
				<script type="text/javascript">
	document.getElementById("comm100_track").style.visibility = "hidden";
</script>
			</div>
			<!-- 结束 Comm100在线客服系统按钮代码-->
		</td>
	</tr>
	<tr>
		<td colspan="3">
			<img height="60" width="180" name="广告位">
		</td>
	</tr>
</table>
<script type="text/javascript">
	//如果客户已经登录，那么显示客户的信息， 而无需再次登录
	if('${user_login}' == 'Y'){
		document.getElementById("userLogin").style.display = "none";
		document.getElementById("displayUser").style.display = "block";
	}
</script>