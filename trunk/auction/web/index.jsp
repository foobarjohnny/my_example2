<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<html>
	<head>
		<title></title>
		<%@ include file="/resources/resources.jsp"%>
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
					<a href="index.htm"><span class="indextitle"><br>
							首页</span> </a>
				</td>
				<td width="1" align="center" valign="middle">
					<img src="images/sx.gif" width="1" height="57">
				</td>
				<td width="115" align="center" valign="middle">
					<a href="user/myepaide.htm"><span class="indextitle"><br>
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
									<tr>
										<td>
											用户名：
											<input name="textfield2" type="text" value="请输入用户名" size="12">
										</td>
									</tr>
									<tr>
										<td>
											密&nbsp;&nbsp;码：
											<input name="textfield" type="text" value="请输入密码" size="12">
										</td>
									</tr>
									<tr>
										<td align="center">
											<img src="images/dl.gif" width="40" height="22">
											<img src="images/hr.gif" width="1" height="1">
											<a href="userlogin.htm"><img src="images/zc.gif"
													width="41" height="22" border="0"> </a>
										</td>
									</tr>
									<tr>
										<td>
											用户名：
											<span class="indexsp">用户名</span>
										</td>
									</tr>
									<tr>
										<td>
											付费E拍币：
										</td>
									</tr>
									<tr>
										<td>
											免费E拍币：
										</td>
									</tr>
									<tr>
										<td>
											赢得的竞拍：
										</td>
									</tr>
									<tr>
										<td>
											<a href="userlogin.htm#sjyz"><font color="#FF0000">手机验证,送5枚E拍币!</font>
											</a>
										</td>
									</tr>
									<tr>
										<td height="25">
											<a href="userlogin.htm#sjyz"><font color="#FF0000">邀请好友,送20枚E拍币!</font>
											</a>
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
												<a href="${post.id }">${post.title }</a>
											</td>
										</tr>
									</s:iterator>
									<tr>
										<td align="right">
											<a href="gg.htm">更多</a>>>
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
												<a href="${help.id }">${help.title }</a>
											</td>
										</tr>
									</s:iterator>
									<tr>
										<td align="right">
											<a href="help.htm">更多</a>>>
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
												<a href="lsshow.htm">${bing.user }以${bing.price
													}元竞拍下${bing.comityName }商品</a>
											</td>
										</tr>
									</s:iterator>
									<tr>
										<td colspan="2" align="right">
											<a href="lsjp.htm">更多</a>>>
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
						<iframe frameborder="0" src="show.action" style="height: 100%;width: 100%;overflow: hidden">
							
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
