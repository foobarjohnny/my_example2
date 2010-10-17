<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<html>
	<head>
		<%@ include file="/resources/resources.jsp"%>
	</head>
	<body style="overflow: scroll;">
		<table width="183" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td>
					<img src="images/admin_title_t.jpg" width="183" height="30">
				</td>
			</tr>
		</table>
		<table width="178" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td width="178" height="28" background="images/admin_title.jpg">
					<div class="admin_title1">
						&nbsp;网站基本设置
					</div>
				</td>
			</tr>
			<tr>
				<td bgcolor="d2d2d2">
					<table width="100%" border="0" cellspacing="0" cellpadding="5">
						<tr>
							<td class="admin_title2">
								<a target="mainFrame" href="websiteBaseInfo.action">网站基本信息</a>
							</td>
						</tr>
						<tr>
							<td class="admin_title2">
								<a target="mainFrame" href="managerSearch.action">管理员账户管理</a>
							</td>
						</tr>
						<tr>
							<td class="admin_title2">
								<a target="mainFrame" href="infoForward.action?nettype=1">网站介绍</a>
							</td>
						</tr>
						<tr>
							<td class="admin_title2">
								<a target="mainFrame" href="infoForward.action?nettype=2">商业合作</a>
							</td>
						</tr>
						<tr>
							<td class="admin_title2">
								<a target="mainFrame" href="infoSearch.action?nettype=3">帮助中心</a>
							</td>
						</tr>
						<tr>
							<td class="admin_title2">
								<a target="mainFrame" href="infoForward.action?nettype=4">注册协议</a>
							</td>
						</tr>
						<tr>
							<td class="admin_title2">
								<a target="mainFrame" href="problemSearch.action">问题与建议</a>
							</td>
						</tr>
						<tr>
							<td class="admin_title2">
								<a target="mainFrame" href="doohickeyList.action">心得与窍门</a>
							</td>
						</tr>
						<tr>
							<td class="admin_title2">
								<a target="mainFrame" href="infoSearch.action?nettype=5">网站公告</a>
							</td>
						</tr>
						<tr>
							<td class="admin_title2">
								<a target="mainFrame" href="adminLoginLog.action">网站日志[未实现，显示系统管理员登录的过程。]</a>
							</td>
						</tr>
						<tr>
							<td class="admin_title2">
								<a target="mainFrame" href="mysqlData.action">数据库备份</a>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<img height="7" src="">
				</td>
			</tr>
			<tr>
				<td height="28" background="images/admin_title.jpg">
					<div class="admin_title1">
						&nbsp;商品设置
					</div>
				</td>
			</tr>
			<tr>
				<td bgcolor="#D2D2D2">
					<table width="100%" border="0" cellspacing="0" cellpadding="5">
						<tr>
							<td class="admin_title2">
								<a target="mainFrame" href="sortSearch.action">商品类别管理</a>
							</td>
						</tr>
						<tr>
							<td class="admin_title2">
								<a target="mainFrame" href="commodityForward.action?methodName=1">发布新商品</a>
							</td>
						</tr>
						<tr>
							<td class="admin_title2">
								<a target="mainFrame" href="commoditySearch.action">修改商品信息</a>
							</td>
						</tr>
						<tr>
							<td class="admin_title2">
								<a target="mainFrame" href="commoditySearch.action?searchName=1">正在竞拍的商品</a>
							</td>
						</tr>
						<tr>
							<td class="admin_title2">
								<a target="mainFrame" href="commoditySearch.action?searchName=2">流拍的商品</a>
							</td>
						</tr>
						<tr>
							<td class="admin_title2">
								<a target="mainFrame" href="commoditySearch.action?searchName=3">成交的商品</a>
							</td>
						</tr>
					</table>
				</td>
			</tr>

			<tr>
				<td>
					<img height="7" src="">
				</td>
			</tr>
			<tr>
				<td height="28" background="images/admin_title.jpg">
					<div class="admin_title1">
						&nbsp;竞拍订单管理
					</div>
				</td>
			</tr>
			<tr>
				<td bgcolor="#D2D2D2">
					<table width="100%" border="0" cellspacing="0" cellpadding="5">
						<tr>
							<td class="admin_title2">
								<a target="mainFrame" href="orderSearch.action?ordertype=1&state=1">未付款订单</a>
							</td>
						</tr>
						<tr>
							<td class="admin_title2">
								<a target="mainFrame" href="orderSearch.action?ordertype=1&state=2">待发货订单</a>
							</td>
						</tr>
						<tr>
							<td class="admin_title2">
								<a target="mainFrame" href="orderSearch.action?ordertype=1&state=3">交易完成订单</a>
							</td>
						</tr>
						<tr>
							<td class="admin_title2">
								<a target="mainFrame" href="searchChannel.action?ordertype=1&state=5">作废订单</a>
							</td>
						</tr>

					</table>
				</td>
			</tr>
			<tr>
				<td height="28" background="images/admin_title.jpg">
					<div class="admin_title1">
						&nbsp;购买订单管理
					</div>
				</td>
			</tr>
			<tr>
				<td bgcolor="#D2D2D2">
					<table width="100%" border="0" cellspacing="0" cellpadding="5">
						<tr>
							<td class="admin_title2">
								<a target="mainFrame" href="orderSearch.action?ordertype=2&state=1">未付款订单</a>
							</td>
						</tr>
						<tr>
							<td class="admin_title2">
								<a target="mainFrame" href="orderSearch.action?ordertype=2&state=2">待发货订单</a>
							</td>
						</tr>
						<tr>
							<td class="admin_title2">
								<a target="mainFrame" href="orderSearch.action?ordertype=2&state=3">交易完成订单</a>
							</td>
						</tr>
						<tr>
							<td class="admin_title2">
								<a target="mainFrame" href="searchChannel.action?ordertype=2&state=5">作废订单</a>
							</td>
						</tr>

					</table>
				</td>
			</tr>
			<tr>
				<td>
					<img height="7" src="">
				</td>
			</tr>
			<tr>
				<td height="28" background="images/admin_title.jpg">
					<div class="admin_title1">
						&nbsp;用户管理
					</div>
				</td>
			</tr>
			<tr>
				<td bgcolor="#D2D2D2">
					<table width="100%" border="0" cellspacing="0" cellpadding="5">
						<tr>
							<td class="admin_title2">
								<a target="mainFrame" href="userSearch.action">网站用户管理</a>
							</td>
						</tr>
						<tr>
							<td class="admin_title2">
								<a target="mainFrame" href="userForward.action?methodName=1">添加新用户</a>
							</td>
						</tr>
						<tr>
							<td class="admin_title2">
								<!-- <a target="mainFrame" href="admin_user_mail.htm">用户邮件群发</a> -->
								<a href="#"  onclick="alert('未实现');">用户邮件群发</a>
							</td>
						</tr>
						<tr>
							<td class="admin_title2">
								<!-- <a target="mainFrame" href="admin_user_friend.htm">用户邀请记录</a> -->
								<a href="#"  onclick="alert('未实现');">用户邀请记录</a>
							</td>
						</tr>

					</table>
				</td>
			</tr>
			<tr>
				<td>
					<img height="7" src="">
				</td>
			</tr>
			<tr>
				<td height="28" background="images/admin_title.jpg">
					<div class="admin_title1">
						&nbsp;网友竞拍区管理
					</div>
				</td>
			</tr>
			<tr>
				<td bgcolor="#D2D2D2">
					<table width="100%" border="0" cellspacing="0" cellpadding="5">
						<tr>
							<td class="admin_title2">
								<!-- <a target="mainFrame" href="admin_area_add.htm">发布新商品</a> -->
								<a href="#"  onclick="alert('未实现');">发布新商品</a>
							</td>
						</tr>
						<tr>
							<td class="admin_title2">
								<a target="mainFrame" href="admin_area_edit.htm">修改商品信息</a> -->
								<a href="#"  onclick="alert('未实现');">修改商品信息</a>
							</td>
						</tr>
						<tr>
							<td class="admin_title2">
								<!-- <a target="mainFrame" href="admin_area_ing.htm">正在竞拍的商品</a> -->
								<a href="#"  onclick="alert('未实现');">正在竞拍的商品</a>
							</td>
						</tr>
						<tr>
							<td class="admin_title2">
								<!-- <a target="mainFrame" href="admin_area_ok.htm">拍下的商品</a> -->
								<a href="#"  onclick="alert('未实现');">拍下的商品</a>
							</td>
						</tr>
						<tr>
							<td class="admin_title2">
								<!-- <a target="mainFrame" href="admin_area_ship.htm">等待卖家发货商品</a> -->
								<a href="#"  onclick="alert('未实现');">等待卖家发货商品</a>
							</td>
						</tr>
						<tr>
							<td class="admin_title2">
								<!-- <a target="mainFrame" href="admin_area_shipyes.htm">卖家已发货商品</a> -->
								<a href="#"  onclick="alert('未实现');">卖家已发货商品</a>
							</td>
						</tr>
						<tr>
							<td class="admin_title2">
								<!-- <a target="mainFrame" href="admin_area_over.htm">成交的商品</a> -->
								<a href="#"  onclick="alert('未实现');">成交的商品</a>
							</td>
						</tr>
						<tr>
							<td class="admin_title2">
								<!-- <a target="mainFrame" href="admin_area_no.htm">流拍的商品</a> -->
								<a href="#"  onclick="alert('未实现');">流拍的商品</a>
							</td>
						</tr>
						<tr>
							<td class="admin_title2">
								<!-- <a target="mainFrame" href="admin_area_zf.htm">作废的商品订单</a> -->
								<a href="#"  onclick="alert('未实现');">作废的商品订单</a>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<img height="7" src="">
				</td>
			</tr>
			<tr>
				<td height="28" background="images/admin_title.jpg">
					<div class="admin_title1">
						&nbsp;E拍币管理
					</div>
				</td>
			</tr>
			<tr>
				<td bgcolor="#D2D2D2">
					<table width="100%" border="0" cellspacing="0" cellpadding="5">
						<tr>
							<td class="admin_title2">
								<a target="mainFrame" href="ecurrSearch.action">E拍币管理</a>
							</td>
						</tr>
						<tr>
							<td class="admin_title2">
								<a target="mainFrame" href="buySearch.action">E拍币购买明细</a>
							</td>
						</tr>
						<tr>
							<td class="admin_title2">
								<a target="mainFrame" href="consumeSearch.action">用户E拍币消费情况</a>
							</td>
						</tr>

					</table>
				</td>
			</tr>
			<tr>
				<td>
					<img height="7" src="">
				</td>
			</tr>
			<tr>
				<td height="28" background="images/admin_title.jpg">
					<div class="admin_title1">
						&nbsp;酷品设置
					</div>
				</td>
			</tr>
			<tr>
				<td bgcolor="#D2D2D2">
					<table width="100%" border="0" cellspacing="0" cellpadding="5">
						<tr>
							<td class="admin_title2">
								<a target="mainFrame" href="publisForward.action">酷品发布</a>
							</td>
						</tr>
						<tr>
							<td class="admin_title2">
								<a target="mainFrame" href="publisSearch.action">酷品统计</a>
							</td>
						</tr>

					</table>
				</td>
			</tr>
			<tr>
				<td>
					<img height="7" src="">
				</td>
			</tr>
			<tr>
				<td height="28" background="images/admin_title.jpg">
					<div class="admin_title1">
						&nbsp;秀宝管理
					</div>
				</td>
			</tr>
			<tr>
				<td bgcolor="#D2D2D2">
					<table width="100%" border="0" cellspacing="0" cellpadding="5">
						<tr>
							<td class="admin_title2">
								<a target="mainFrame" href="notAut.action">秀宝审核</a>
							</td>
						</tr>
						<tr>
							<td class="admin_title2">
								<a target="mainFrame" href="finshedAut.action">已审核的秀宝</a>
							</td>
						</tr>

					</table>
				</td>
			</tr>

			<tr>
				<td>
					<img height="7" src="">
				</td>
			</tr>
			<tr>
				<td height="28" background="images/admin_title.jpg">
					<div class="admin_title1">
						&nbsp;模版管理
					</div>
				</td>
			</tr>
			<tr>
				<td bgcolor="#D2D2D2">
					<table width="100%" border="0" cellspacing="0" cellpadding="5">
						<tr>
							<td class="admin_title2">
								<!-- <a target="mainFrame" href="admin_tem.htm">模版管理</a> -->
								<a href="#"  onclick="alert('未实现');">模版管理</a>
							</td>
						</tr>
						<tr>
							<td class="admin_title2">
								<!-- <a target="mainFrame" href="admin_tem_add.htm">添加模版</a> -->
								<a href="#"  onclick="alert('未实现');">添加模版</a>
							</td>
						</tr>

					</table>
				</td>
			</tr>
			<tr>
				<td>
					<img height="7" src="">
				</td>
			</tr>
			<tr>
				<td height="28" background="images/admin_title.jpg">
					<div class="admin_title1">
						&nbsp;广告管理
					</div>
				</td>
			</tr>
			<tr>
				<td bgcolor="#D2D2D2">
					<table width="100%" border="0" cellspacing="0" cellpadding="5">
						<tr>
							<td class="admin_title2">
								<!-- <a target="mainFrame" href="admin_ads.htm">广告位管理</a> -->
								<a href="#"  onclick="alert('未实现');">广告位管理</a> 
							</td>
						</tr>
						<tr>
							<td class="admin_title2">
								<!-- <a target="mainFrame" href="admin_ad.htm">广告管理</a> -->
								<a href="#"  onclick="alert('未实现');">广告管理</a>
							</td>
						</tr>

					</table>
				</td>
			</tr>

			<tr>
				<td>
					<img height="7" src="">
				</td>
			</tr>
			<tr>
				<td height="28" background="images/admin_title.jpg">
					<div class="admin_title1">
						&nbsp;版权声明
					</div>
				</td>
			</tr>
			<tr>
				<td bgcolor="#D2D2D2">
					<table width="100%" border="0" cellspacing="0" cellpadding="5">
						<tr>
							<td>
								<div class="admin_title2">
									本网站系统版权归易拍得网站(Epaide.Com)所有。
								</div>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>