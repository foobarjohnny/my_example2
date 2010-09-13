<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>

<script type="text/javascript">
	function viewAccount() {
		var obj = document.getElementById("rightUser");
		obj.src = "userAccount.action";
	}
</script>
<table width="179" border="0" align="center" valign="top" cellpadding="0" cellspacing="0">
	<tr>
		<td colspan="3"  width="179" height="21" background="images/l_top.gif">
			&nbsp;
		</td>
	</tr>
	<tr>
		<td width="5" height="25" background="images/l_left.gif">
		</td>
		<td width="169" height="25" valign="top" bgcolor="#FFFFFF">
			欢迎您&nbsp;
			<span class="title1">${username }</span>
		</td>
		<td width="5" height="25" background="images/l_right.gif">
		</td>
	</tr>
	<tr>
		<td width="5" height="25" background="images/l_left.gif">
		</td>
		<td width="169"  height="25" valign="top" bgcolor="#FFFFFF">
			付费E拍币：${paycur }
		</td>
		<td width="5" height="25" background="images/l_right.gif">
		</td>
	</tr>
	<tr>
		<td width="5" height="25" background="images/l_left.gif">
		</td>
		<td width="169"  height="25" valign="top" bgcolor="#FFFFFF">
			免费E拍币：${freecur }
		</td>
		<td width="5" height="25" background="images/l_right.gif">
		</td>
	</tr>
	<tr>
		<td width="5" height="25" background="images/l_left.gif">
		</td>
		<td width="169" height="25" valign="top" bgcolor="#FFFFFF">
			<strong><a href="showEcurr.action">我要充值</a>&nbsp;&nbsp;</strong>
			<hr size="1">
		</td>
		<td width="5" height="25" background="images/l_right.gif">
		</td>
	</tr>
	<tr>
		<td width="5" height="25" background="images/l_left.gif">
		</td>
		<td width="169" height="25" valign="top" bgcolor="#FFFFFF">
			<img src="images/title_l.gif" width="3" height="12">
			&nbsp;
			<span class="admin_title1">用户信息</span>
		</td>
		<td width="5" height="25" background="images/l_right.gif">
		</td>
	</tr>
	<tr>
		<td width="5" height="25" background="images/l_left.gif">
		</td>
		<td width="169" height="25" bgcolor="#FFFFFF">
			<a href="viewUser.action?id=${id}">基本信息</a>
		</td>
		<td width="5" height="25" background="images/l_right.gif">
		</td>
	</tr>
	<tr>
		<td width="5" height="25" background="images/l_left.gif">
		</td>
		<td width="169" height="25" bgcolor="#FFFFFF">
			<a href="viewPass.action?id=${id}">修改密码</a>
			<hr size="1">
		</td>
		<td width="5" height="25" background="images/l_right.gif">
		</td>
	</tr>

	<tr>
		<td width="5" height="25" background="images/l_left.gif">
		</td>
		<td width="169" height="25" bgcolor="#FFFFFF">
			<img src="images/title_l.gif" width="3" height="12">
			&nbsp;
			<span class="admin_title1">竞拍查询</span>
		</td>
		<td width="5" height="25" background="images/l_right.gif">
		</td>
	</tr>
	<tr>
		<td width="5" height="25" background="images/l_left.gif">
		</td>
		<td width="169" height="25" bgcolor="#FFFFFF">
			<a href="userNow.action">我正在参与的竞拍</a>
		</td>
		<td width="5" height="25" background="images/l_right.gif">
		</td>
	</tr>
	<tr>
		<td width="5" height="25" background="images/l_left.gif">
		</td>
		<td width="169" height="25" bgcolor="#FFFFFF">
			<a href="userAuction.action">我赢得的竞拍</a>
		</td>
		<td width="5" height="25" background="images/l_right.gif">
		</td>
	</tr>
	<tr>
		<td width="5" height="25" background="images/l_left.gif">
		</td>
		<td width="169" height="25" bgcolor="#FFFFFF">
			<a href="userFollow.action">我直接购买的产品</a>
		</td>
		<td width="5" height="25" background="images/l_right.gif">
		</td>
	</tr>
	<tr>
		<td width="5" height="25" background="images/l_left.gif">
		</td>
		<td width="169" height="25" bgcolor="#FFFFFF">
			<a href="#" onclick="alert('暂时未实现')">我的竞拍助理</a>
		</td>
		<td width="5" height="25" background="images/l_right.gif">
		</td>
	</tr>
	<tr>
		<td width="5" height="25" background="images/l_left.gif">
		</td>
		<td width="169" height="25" bgcolor="#FFFFFF">
			<a href="#" onclick="alert('暂时未实现')">我的秀宝</a>
			<hr size="1">
		</td>
		<td width="5" height="25" background="images/l_right.gif">
		</td>
	</tr>
	<tr>
		<td width="5" height="25" background="images/l_left.gif">
		</td>
		<td width="169" height="25" bgcolor="#FFFFFF">
			<img src="images/title_l.gif" width="3" height="12">
			&nbsp;
			<span class="admin_title1">淘宝岛</span>
		</td>
		<td width="5" height="25" background="images/l_right.gif">
		</td>
	</tr>
	<tr>
		<td width="5" height="25" background="images/l_left.gif">
		</td>
		<td width="169" height="25" bgcolor="#FFFFFF">
			<a href="#" onclick="alert('暂时未实现')">发布宝贝</A>
		</td>
		<td width="5" height="25" background="images/l_right.gif">
		</td>
	</tr>
	<tr>
		<td width="5" height="25" background="images/l_left.gif">
		</td>
		<td width="169" height="25" bgcolor="#FFFFFF">
			<a href="#" onclick="alert('暂时未实现')">修改宝贝</a>
		</td>
		<td width="5" height="25" background="images/l_right.gif">
		</td>
	</tr>
	<tr>
		<td width="5" height="25" background="images/l_left.gif">
		</td>
		<td width="169" height="25" bgcolor="#FFFFFF">
			<a href="#" onclick="alert('暂时未实现')">被拍下的宝贝</A>
		</td>
		<td width="5" height="25" background="images/l_right.gif">
		</td>
	</tr>
	<tr>
		<td width="5" height="25" background="images/l_left.gif">
		</td>
		<td width="169" height="25" bgcolor="#FFFFFF">
			<a href="#" onclick="alert('暂时未实现')">等待发货的宝贝</A>
		</td>
		<td width="5" height="25" background="images/l_right.gif">
		</td>
	</tr>

	<tr>
		<td width="5" height="25" background="images/l_left.gif">
		</td>
		<td width="169" height="25" bgcolor="#FFFFFF">
			<a href="#" onclick="alert('暂时未实现')">成交的宝贝</A>
		</td>
		<td width="5" height="25" background="images/l_right.gif">
		</td>
	</tr>
	<tr>
		<td width="5" height="25" background="images/l_left.gif">
		</td>
		<td width="169" height="25" bgcolor="#FFFFFF">
			<a href="#" onclick="alert('暂时未实现')">流拍的宝贝</A>
		</td>
		<td width="5" height="25" background="images/l_right.gif">
		</td>
	</tr>

	<tr>
		<td width="5" height="25" background="images/l_left.gif">
		</td>
		<td width="169" height="25" bgcolor="#FFFFFF">
			<a href="#" onclick="alert('暂时未实现')">我拍下的宝贝 </a>
			<hr size="1">
		</td>
		<td width="5" height="25" background="images/l_right.gif">
		</td>
	</tr>

	<tr>
		<td width="5" height="25" background="images/l_left.gif">
		</td>
		<td width="169" height="25" bgcolor="#FFFFFF" class="admin_title1">
			<img src="images/title_l.gif" width="3" height="12">
			&nbsp;
			<span class="title1">E拍币查询</span>
		</td>
		<td width="5" height="25" background="images/l_right.gif">
		</td>
	</tr>
	<tr>
		<td width="5" height="25" background="images/l_left.gif">
		</td>
		<td width="169" height="25" bgcolor="#FFFFFF">
			<a href="buySearchUserE.action">购买明细</a>
		</td>
		<td width="5" height="25" background="images/l_right.gif">
		</td>
	</tr>
	<tr>
		<td width="5" height="25" background="images/l_left.gif">
		</td>
		<td width="169" height="25" bgcolor="#FFFFFF">
			<a href="searchUserPayE.action">消费明细</a>
		</td>
		<td width="5" height="25" background="images/l_right.gif">
		</td>
	</tr>
	<tr>
		<td colspan="3" width="179" height="21" background="images/l_dow.gif">
			&nbsp;
		</td>
	</tr>
	<tr>
		<td height="80" colspan="3" align="center">
			<!-- 开始 Comm100在线客服系统按钮代码 -->
			<div>
				<div id="comm100_LiveChatDiv"></div>
				<a href="http://www.comm100.cn/livechat/" onClick="comm100_Chat();"
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
