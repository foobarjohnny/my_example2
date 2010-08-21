<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<html>
	<head>
		<title></title>
		<%@ include file="/resources/resources.jsp"%>
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
	</head>

	<body leftmargin="0" topmargin="0"
		style="filter: progid : DXImageTransform.Microsoft.Gradient ( startColorStr = '#6daf2f', endColorStr = '#ffffff', gradientType = '0' )">
		<table width="100%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td background="images/tophr.gif">
					<img src="images/tophr.gif" width="1" height="5" />
				</td>
			</tr>
		</table>
		<table width="1000" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td width="197">
					<img src="images/logo.png" width="200" height="80" />
				</td>
				<td width="33" align="center" valign="middle">
					&nbsp;
				</td>
				<td width="57" align="center" valign="middle">
					<a href="showView.action"><span class="indextitle"><br>
							首页</span> </a>
				</td>
				<td width="1" align="center" valign="middle">
					<img src="images/sx.gif" width="1" height="57">
				</td>
				<td width="115" align="center" valign="middle">
					<a href="userInfomation.action"><span class="indextitle"><br>
							我的易拍得</span> </a>
				</td>
				<td width="1" height="5" align="center" valign="middle">
					<img src="images/sx.gif" width="1" height="57">
				</td>
				<td width="106" align="center" valign="middle">
					<a href="buyeb.htm"><span class="indextitle"><br>
							购买E拍币</span> </a>
				</td>
				<td width="1" align="center" valign="middle">
					<img src="images/sx.gif" width="1" height="57">
				</td>
				<td width="74" align="center" valign="middle">
					<a href="show.htm"><span class="indextitle"><br>
							秀宝街</span> </a>
				</td>
				<td width="1" align="center" valign="middle">
					<img src="images/sx.gif" width="1" height="57">
				</td>
				<td width="81" align="center" valign="middle">
					<a href="taobao.htm"><span class="indextitle"><br>
							淘宝岛</span> </a>
				</td>
				<td width="1" align="center" valign="middle">
					<img src="images/sx.gif" width="1" height="57">
				</td>
				<td width="95" align="center" valign="middle">
					<a href="cool.htm"><span class="indextitle"><br>
							酷品投票</span> </a>
				</td>
				<td width="1" align="center" valign="middle">
					<img src="images/sx.gif" width="1" height="57">
				</td>
				<td width="112" align="center" valign="middle">
					<a href="wtyj.htm"><span class="indextitle"><br>
							问题与建议</span> </a>
				</td>
				<td width="1" align="center" valign="middle">
					<img src="images/sx.gif" width="1" height="57">
				</td>
				<td width="123" align="center">
					<a href="xdqm.htm"><span class="indextitle"><br>
							心得与窍门</span> </a>&nbsp;&nbsp;&nbsp;&nbsp;
				</td>
			</tr>
			<tr>
				<td height="105" colspan="17" valign="top">
					<img height="100" width="1000" name="广告位">
				</td>
			</tr>
		</table>

		<table width="1000" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td width="193" rowspan="5" valign="top">
					<table width="179" border="0" align="center" cellpadding="0"
						cellspacing="0">
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
														<input name="username" type="text" id="username" value="" size="8">
													</td>
												</tr>
												<tr>
													<td>
														密&nbsp;&nbsp;码：
														<input name="password" type="password" id="password" value="" size="10">
													</td>
												</tr>
												<tr>
													<td align="center">
														<img src="images/dl.gif" width="40" height="22" onclick="login()">
														<img src="images/hr.gif" width="1" height="1">
														<a href="userlogin.htm"><img src="images/zc.gif"
																width="41" height="22" border="0"> </a>
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
														<input type="hidden" name="userId" id="userId"/>
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
												<a href="#" onclick="postAction('${post.id }')">${post.title }</a>
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
												<a href="#" onclick="tradeAction('${bing.id}')">${bing.user }以${bing.price
													}元竞拍下${bing.comityName }商品</a>
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
									<a href="http://www.comm100.cn/livechat/"
										onClick=
	comm100_Chat();;
target="_blank" title="在线客服"><img
											id="comm100_ButtonImage"
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
				</td>
				<td width="807" height="800">
					<div>
						<iframe frameborder="0" src="show.action" style="height: 100%;width: 100%;overflow: hidden" id="leftMain">
							
						</iframe>
					</div>
				</td>
			</tr>
		</table>
		<table width="1000" border="0" cellspacing="0" cellpadding="3">
			<tr>
				<td>
					<hr>
				</td>
			</tr>
			<tr>
				<td align="center">
					关于我们&nbsp;|&nbsp;商业合作&nbsp;|&nbsp;用户协议&nbsp;|&nbsp;免责声明&nbsp;|&nbsp;帮助中心&nbsp;|&nbsp;问题与建议&nbsp;|&nbsp;联系我们&nbsp;
				</td>

			</tr>
			<tr>
				<td align="center">
					2009-2010 易拍得竞拍商城 版权所有 EPAIDE.COM 京ICP备10016657号
				</td>
			</tr>
		</table>
	</body>
</html>
