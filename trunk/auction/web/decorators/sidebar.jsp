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
		}
	}
	function helpAction(id) {
		var obj = document.getElementById("leftMain");
		obj.src = "infoView.action?model.nettype=3&model.id=" + id;
	}
	function postAction(id) {
		var obj = document.getElementById("leftMain");
		obj.src = "infoView.action?model.nettype=5&model.id=" + id;
	}
	function help_listAction() {
		var obj = document.getElementById("leftMain");
		obj.src = "infoViewList.action?model.nettype=3";
	}
	function post_listAction() {
		var obj = document.getElementById("leftMain");
		obj.src = "infoViewList.action?model.nettype=5";
	}
	function trade_listAction() {
		var obj = document.getElementById("leftMain");
		obj.src = "bingcurSearch.action";
	}
	function tradeAction(id) {
		var obj = document.getElementById("leftMain");
		obj.src = "bingcurForward.action?model.id=" + id;
	}
</script>

<table width="179" border="0" align="center" cellpadding="0" cellspacing="0">
	<tr>
		<td colspan="3">
			<img src="images/l_top.gif" width="179" height="21">
		</td>
	</tr>
	<tr>
		<td width="5" rowspan="9" background="images/l_left.gif">
			<img src="images/l_left.gif" width="5" height="1">
		</td>
		<td width="169" height="40" align="center" valign="top"
			bgcolor="#FFFFFF">
			<s:select list="sortDataList" listKey="id" listValue="sortname"
				headerKey="" headerValue="按类别查找商品"></s:select>
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
								<td>
									用户名：
									<input name="username" type="text" id="username" value=""
										size="8">
								</td>
							</tr>
							<tr>
								<td>
									密&nbsp;&nbsp;码：
									<input name="password" type="password" id="password" value=""
										size="10">
								</td>
							</tr>
							<tr>
								<td align="center">
									<img src="images/dl.gif" width="40" height="22"
										onclick="login()">
									<img src="images/hr.gif" width="1" height="1">
									<a href="userlogin.htm"><img src="images/zc.gif" width="41"
											height="22" border="0"> </a>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr id="displayUser" style="display: none">
					<td>
						<table>
							<tr>
								<td>
									用户名：
									<span class="indexsp" id="user">用户名</span>
									<input type="hidden" name="userId" id="userId" />
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td height="25" align="center">
						<!-- JiaThis Button BEGIN -->
						<a href="http://www.jiathis.com/share.html" class="jiathis"><img
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
							<a href="#" onclick="postAction('${post.id }')">${post.title
								}</a>
						</td>
					</tr>
				</s:iterator>
				<tr>
					<td align="right">
						<a href="#" onclick="post_listAction()">更多</a>>>
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
							<a href="#" onclick="helpAction('${help.id}')">${help.title }</a>
						</td>
					</tr>
				</s:iterator>
				<tr>
					<td align="right">
						<a href="#" onclick="help_listAction()">更多</a>>>
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
							<img height="50" width="50">
						</td>
						<td width="67%">
							<a href="#" onclick="tradeAction('${bing.id}')">${bing.user
								}以${bing.price }元竞拍下${bing.comityName }商品</a>
						</td>
					</tr>
				</s:iterator>
				<tr>
					<td colspan="2" align="right">
						<a href="#" onclick="trade_listAction()">更多</a>>>
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
				<a href="http://www.comm100.cn/livechat/" onClick=comm100_Chat();;
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