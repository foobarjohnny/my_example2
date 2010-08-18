<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<html>
	<head>
		<%@ include file="/resources/resources.jsp"%>
		<script type="text/javascript">
			function showUser(id) {
				var obj = document.getElementById("rightUser");
				obj.src = "viewUser.action?id=" + id;
			}
			function changePass(id) {
				var obj = document.getElementById("rightUser");
				obj.src = "viewPass.action?id=" + id;
			}
			function partake() {
				var obj = document.getElementById("rightUser");
				obj.src = "userNow.action";
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
							首页</span>
					</a>
				</td>
				<td width="1" align="center" valign="middle">
					<img src="images/sx.gif" width="1" height="57">
				</td>
				<td width="115" align="center" valign="middle">
					<a href="userInfomation.action"><span class="indextitle"><br>
							我的易拍得</span>
					</a>
				</td>
				<td width="1" height="5" align="center" valign="middle">
					<img src="images/sx.gif" width="1" height="57">
				</td>
				<td width="106" align="center" valign="middle">
					<a href="../buyeb.htm"><span class="indextitle"><br>
							购买E拍币</span>
					</a>
				</td>
				<td width="1" align="center" valign="middle">
					<img src="images/sx.gif" width="1" height="57">
				</td>
				<td width="74" align="center" valign="middle">
					<a href="../show.htm"><span class="indextitle"><br>
							秀宝街</span>
					</a>
				</td>
				<td width="1" align="center" valign="middle">
					<img src="images/sx.gif" width="1" height="57">
				</td>
				<td width="81" align="center" valign="middle">
					<a href="../taobao.htm"><span class="indextitle"><br>
							淘宝岛</span>
					</a>
				</td>
				<td width="1" align="center" valign="middle">
					<img src="images/sx.gif" width="1" height="57">
				</td>
				<td width="95" align="center" valign="middle">
					<a href="../cool.htm"><span class="indextitle"><br>
							酷品投票</span>
					</a>
				</td>
				<td width="1" align="center" valign="middle">
					<img src="images/sx.gif" width="1" height="57">
				</td>
				<td width="112" align="center" valign="middle">
					<a href="../wtyj.htm"><span class="indextitle"><br>
							问题与建议</span>
					</a>
				</td>
				<td width="1" align="center" valign="middle">
					<img src="images/sx.gif" width="1" height="57">
				</td>
				<td width="123" align="center">
					<a href="../xdqm.htm"><span class="indextitle"><br>
							心得与窍门</span>
					</a>&nbsp;&nbsp;&nbsp;&nbsp;
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
				<td width="193" valign="top">
					<table width="179" border="0" align="center" cellpadding="0"
						cellspacing="0">
						<tr>
							<td colspan="3">
								<img src="images/l_top.gif" width="179" height="21">
							</td>
						</tr>
						<tr>
							<td width="5" rowspan="25" background="images/l_left.gif">
								<img src="images/l_left.gif" width="5" height="1">
							</td>
							<td width="169" height="25" valign="top" bgcolor="#FFFFFF">
								欢迎您&nbsp;
								<span class="title1">${username }</span>
							</td>
							<td width="5" rowspan="25" background="images/l_right.gif">
								<img src="images/l_right.gif" width="5" height="1">
							</td>
						</tr>
						<tr>
							<td height="25" valign="top" bgcolor="#FFFFFF">
								羸得的竞拍：22
							</td>
						</tr>
						<tr>
							<td height="25" valign="top" bgcolor="#FFFFFF">
								付费E拍币：${paycur }
							</td>
						</tr>
						<tr>
							<td height="25" valign="top" bgcolor="#FFFFFF">
								免费E拍币：${freecur }
							</td>
						</tr>
						<tr>
							<td height="25" valign="top" bgcolor="#FFFFFF">
								<strong><a href="../buyeb.htm">我要充值</a>&nbsp;&nbsp;邀请好友</strong>
								<hr size="1">
							</td>
						</tr>
						<tr>
							<td height="25" valign="top" bgcolor="#FFFFFF">
								<img src="images/title_l.gif" width="3" height="12">
								&nbsp;
								<span class="admin_title1">用户信息</span>
							</td>
						</tr>
						<tr>
							<td height="25" bgcolor="#FFFFFF">
								<a href="#" onclick="showUser('${id}')">基本信息</a>
							</td>
						</tr>
						<tr>
							<td bgcolor="#FFFFFF">
								<a href="#" onclick="changePass('${id}')">修改密码</a>
								<hr size="1">
							</td>
						</tr>

						<tr>
							<td height="25" bgcolor="#FFFFFF">
								<img src="images/title_l.gif" width="3" height="12">
								&nbsp;
								<span class="admin_title1">竞拍查询</span>
							</td>
						</tr>
						<tr>
							<td height="25" bgcolor="#FFFFFF">
								<a href="#" onclick="partake()">我正在参与的竞拍</a>
							</td>
						</tr>
						<tr>
							<td height="25" bgcolor="#FFFFFF">
								<a href="winjp.htm">我赢得的竞拍</a>
							</td>
						</tr>
						<tr>
							<td height="25" bgcolor="#FFFFFF">
								<a href="buy.htm">我直接购买的产品</a>
							</td>
						</tr>
						<tr>
							<td height="25" bgcolor="#FFFFFF">
								<a href="jpzl.htm">我的竞拍助理</a>
							</td>
						</tr>
						<tr>
							<td height="25" bgcolor="#FFFFFF">
								<a href="show.htm">我的秀宝</a>
								<hr size="1">
							</td>
						</tr>
						<tr>
							<td height="25" bgcolor="#FFFFFF">
								<img src="images/title_l.gif" width="3" height="12">
								&nbsp;
								<span class="admin_title1">淘宝岛</span>
							</td>
						</tr>
						<tr>
							<td height="25" bgcolor="#FFFFFF">
								<A href="area_add.htm">发布宝贝</A>
							</td>
						</tr>
						<tr>
							<td height="25" bgcolor="#FFFFFF">
								<A href="area_edit.htm">修改宝贝信息</A>
							</td>
						</tr>
						<tr>
							<td height="25" bgcolor="#FFFFFF">
								<A href="area_ok.htm">被拍下的宝贝</A>
							</td>
						</tr>
						<tr>
							<td height="25" bgcolor="#FFFFFF">
								<A href="area_ship.htm">等待发货的宝贝</A>
							</td>
						</tr>

						<tr>
							<td height="25" bgcolor="#FFFFFF">
								<A href="area_over.htm">成交的宝贝</A>
							</td>
						</tr>
						<tr>
							<td height="25" bgcolor="#FFFFFF">
								<A href="area_zf.htm"></A><A href="area_no.htm">流拍的宝贝</A>
							</td>
						</tr>

						<tr>
							<td height="25" bgcolor="#FFFFFF">
								<a href="area_mybuy.htm">我拍下的宝贝 </a>
								<hr size="1">
							</td>
						</tr>
						
						<tr>
							<td height="25" bgcolor="#FFFFFF" class="admin_title1">
								<img src="images/title_l.gif" width="3" height="12">
								&nbsp;
								<span class="title1">E拍币查询</span>
							</td>
						</tr>
						
						<tr>
							<td height="25" bgcolor="#FFFFFF">
								<a href="epaibi.htm">账户状况</a>
							</td>
						</tr>
						<tr>
							<td height="25" bgcolor="#FFFFFF">
								<a href="ebls.htm">历史明细</a>
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
										onClick="comm100_Chat();" target="_blank"
										title="在线客服"><img id="comm100_ButtonImage"
											src="http://chatserver.comm100.cn/BBS.aspx?siteId=80008671&planId=201"
											border="0px" alt="在线客服" />
									</a>
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
				<td width="807" valign="top">
					<iframe frameborder="0" style="width: 100%; height: 807" src="viewUser.action?id=${id }" id="rightUser">
						
					</iframe>
				</td>
			</tr>
		</table>
	</body>
</html>