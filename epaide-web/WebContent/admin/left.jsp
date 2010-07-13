<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/common/common.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/admin.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<table width="183" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td><img src="images/admin_title_t.jpg" width="183" height="30"></td>
  </tr>
</table>
<table width="178" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="178" height="28" background="images/admin_title.jpg"><div class="admin_title1">&nbsp;网站基本设置</div></td>
  </tr>
  <tr>
    <td bgcolor="d2d2d2"><table width="100%" border="0" cellspacing="0" cellpadding="5">
      <tr>
        <td class="admin_title2"><a target="mainFrame" href="site/siteInfoAction_findSiteInfo.action">网站基本信息</a></td>
      </tr>
      <tr>
        <td class="admin_title2"><a target="mainFrame" href="admin_info_admin.htm">管理员账户管理</a></td>
      </tr>
      <tr>
        <td class="admin_title2"><a target="mainFrame" href="admin_info_web.htm">网站介绍</a></td>
      </tr>
      <tr>
        <td class="admin_title2"><a target="mainFrame" href="admin_info_join.htm">商业合作</a></td>
      </tr>
      <tr>
        <td class="admin_title2"><a target="mainFrame" href="admin_info_help.htm">帮助中心</a></td>
      </tr>
      <tr>
        <td class="admin_title2"><a target="mainFrame" href="admin_info_login.htm">注册协议</a></td>
      </tr>
      <tr>
        <td class="admin_title2"><a target="mainFrame" href="admin_info_que.htm">问题与建议</a></td>
      </tr>
      <tr>
        <td class="admin_title2"><a target="mainFrame" href="admin_info_gg.htm">网站公告</a></td>
      </tr>
      <tr>
        <td class="admin_title2"><a target="mainFrame" href="admin_info_blog.htm">网站日志</a></td>
      </tr>
      <tr>
        <td class="admin_title2"><a target="mainFrame" href="admin_info_data.htm">数据库备份</a></td>
      </tr>
      <tr>
        <td class="admin_title2"><a target="mainFrame" href="admin_info_Server.htm">服务器参数探针</a></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><img height="7" src=""></td>
  </tr>
  <tr>
    <td height="28" background="images/admin_title.jpg"><div class="admin_title1">&nbsp;商品设置</div></td>
  </tr>
  <tr>
    <td bgcolor="#D2D2D2"><table width="100%" border="0" cellspacing="0" cellpadding="5">
      <tr>
        <td class="admin_title2"><a target="mainFrame" href="admin_goods_class.htm">商品类别管理</a></td>
      </tr>
      <tr>
        <td class="admin_title2"><a target="mainFrame" href="admin_goods_add.htm">发布新商品</a></td>
      </tr>
      <tr>
        <td class="admin_title2"><a target="mainFrame" href="admin_goods_edit.htm">修改商品信息</a></td>
      </tr>
      <tr>
        <td class="admin_title2"><a target="mainFrame" href="admin_goods_ing.htm">正在竞拍的商品</a></td>
      </tr>
      <tr>
        <td class="admin_title2"><a target="mainFrame" href="admin_goods_no.htm">流拍的商品</a></td>
      </tr>
      <tr>
        <td class="admin_title2"><a target="mainFrame" href="admin_goods_ok.htm">成交的商品</a></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><img height="7" src=""></td>
  </tr>
  <tr>
    <td height="28" background="images/admin_title.jpg"><div class="admin_title1">&nbsp;机器人设置</div></td>
  </tr>
  <tr>
    <td bgcolor="#D2D2D2"><table width="100%" border="0" cellspacing="0" cellpadding="5">
      <tr>
        <td class="admin_title2"><a target="mainFrame" href="admin_jqr.htm">增加机器人</a></td>
      </tr>
      <tr>
        <td class="admin_title2"><a target="mainFrame" href="admin_jqr_edit.htm">修改机器人</a></td>
      </tr>

    </table></td>
  </tr>
  <tr>
    <td><img height="7" src=""></td>
  </tr>
  <tr>
    <td height="28" background="images/admin_title.jpg"><div class="admin_title1">&nbsp;竞拍订单管理</div></td>
  </tr>
  <tr>
    <td bgcolor="#D2D2D2"><table width="100%" border="0" cellspacing="0" cellpadding="5">
      <tr>
        <td class="admin_title2"><a target="mainFrame" href="admin_orders_wfk.htm">未付款订单</a></td>
      </tr>
      <tr>
        <td class="admin_title2"><a target="mainFrame" href="admin_orders_dfh.htm">待发货订单</a></td>
      </tr>
      <tr>
        <td class="admin_title2"><a target="mainFrame" href="admin_orders_over.htm">交易完成订单</a></td>
      </tr>
      <tr>
        <td class="admin_title2"><a target="mainFrame" href="admin_orders_zf.htm">作废订单</a></td>
      </tr>

    </table></td>
  </tr>
  <tr>
    <td height="28" background="images/admin_title.jpg"><div class="admin_title1">&nbsp;购买订单管理</div></td>
  </tr>
  <tr>
    <td bgcolor="#D2D2D2"><table width="100%" border="0" cellspacing="0" cellpadding="5">
      <tr>
        <td class="admin_title2"><a target="mainFrame" href="admin_orders_buy.htm">未付款订单</a></td>
      </tr>
      <tr>
        <td class="admin_title2"><a target="mainFrame" href="admin_orders_buy_dfh.htm">待发货订单</a></td>
      </tr>
      <tr>
        <td class="admin_title2"><a target="mainFrame" href="admin_orders_buy_over.htm">交易完成订单</a></td>
      </tr>
      <tr>
        <td class="admin_title2"><a target="mainFrame" href="admin_orders_buy_zf.htm">作废订单</a></td>
      </tr>

    </table></td>
  </tr>
  <tr>
    <td><img height="7" src=""></td>
  </tr>
  <tr>
    <td height="28" background="images/admin_title.jpg"><div class="admin_title1">&nbsp;用户管理</div></td>
  </tr>
  <tr>
    <td bgcolor="#D2D2D2"><table width="100%" border="0" cellspacing="0" cellpadding="5">
      <tr>
        <td class="admin_title2"><a target="mainFrame" href="admin_user.htm">网站用户管理</a></td>
      </tr>
      <tr>
        <td class="admin_title2"><a target="mainFrame" href="admin_user_add.htm">添加新用户</a></td>
      </tr>
      <tr>
        <td class="admin_title2"><a target="mainFrame" href="admin_user_mail.htm">用户邮件群发</a></td>
      </tr>
      <tr>
        <td class="admin_title2"><a target="mainFrame" href="admin_user_friend.htm">用户邀请记录</a></td>
      </tr>

    </table></td>
  </tr>
  <tr>
    <td><img height="7" src=""></td>
  </tr>
  <tr>
    <td height="28" background="images/admin_title.jpg"><div class="admin_title1">&nbsp;网友竞拍区管理</div></td>
  </tr>
  <tr>
    <td bgcolor="#D2D2D2"><table width="100%" border="0" cellspacing="0" cellpadding="5">
      <tr>
        <td class="admin_title2"><a target="mainFrame" href="admin_area_add.htm">发布新商品</a></td>
      </tr>
      <tr>
        <td class="admin_title2"><a target="mainFrame" href="admin_area_edit.htm">修改商品信息</a></td>
      </tr>
      <tr>
        <td class="admin_title2"><a target="mainFrame" href="admin_area_ing.htm">正在竞拍的商品</a></td>
      </tr>
      <tr>
        <td class="admin_title2"><a target="mainFrame" href="admin_area_ok.htm">拍下的商品</a></td>
      </tr>
      <tr>
        <td class="admin_title2"><a target="mainFrame" href="admin_area_ship.htm">等待卖家发货商品</a></td>
      </tr>
      <tr>
        <td class="admin_title2"><a target="mainFrame" href="admin_area_shipyes.htm">卖家已发货商品</a></td>
      </tr>
      <tr>
        <td class="admin_title2"><a target="mainFrame" href="admin_area_over.htm">成交的商品</a></td>
      </tr>
      <tr>
        <td class="admin_title2"><a target="mainFrame" href="admin_area_no.htm">流拍的商品</a></td>
      </tr>
      <tr>
        <td class="admin_title2"><a target="mainFrame" href="admin_area_zf.htm">作废的商品订单</a></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><img height="7" src=""></td>
  </tr>
  <tr>
    <td height="28" background="images/admin_title.jpg"><div class="admin_title1">&nbsp;E拍币管理</div></td>
  </tr>
  <tr>
    <td bgcolor="#D2D2D2"><table width="100%" border="0" cellspacing="0" cellpadding="5">
      <tr>
        <td class="admin_title2"><a target="mainFrame" href="admin_e.htm">E拍币管理</a></td>
      </tr>
      <tr>
        <td class="admin_title2"><a target="mainFrame" href="admin_e_buy.htm">E拍币购买明细</a></td>
      </tr>
      <tr>
        <td class="admin_title2"><a target="mainFrame" href="admin_e_user.htm">用户E拍币消费情况</a></td>
      </tr>

    </table></td>
  </tr>
  <tr>
    <td><img height="7" src=""></td>
  </tr>
  <tr>
    <td height="28" background="images/admin_title.jpg"><div class="admin_title1">&nbsp;酷品设置</div></td>
  </tr>
  <tr>
    <td bgcolor="#D2D2D2"><table width="100%" border="0" cellspacing="0" cellpadding="5">
      <tr>
        <td class="admin_title2"><a target="mainFrame" href="admin_cool_add.htm">酷品发布</a></td>
      </tr>
      <tr>
        <td class="admin_title2"><a target="mainFrame" href="admin_cool_edit.htm">酷品统计</a></td>
      </tr>

    </table></td>
  </tr>
  <tr>
    <td><img height="7" src=""></td>
  </tr>
  <tr>
    <td height="28" background="images/admin_title.jpg"><div class="admin_title1">&nbsp;秀宝管理</div></td>
  </tr>
  <tr>
    <td bgcolor="#D2D2D2"><table width="100%" border="0" cellspacing="0" cellpadding="5">
      <tr>
        <td class="admin_title2"><a target="mainFrame" href="admin_show.htm">秀宝审核</a></td>
      </tr>
      <tr>
        <td class="admin_title2"><a target="mainFrame" href="admin_show_yes.htm">已审核的秀宝</a></td>
      </tr>

    </table></td>
  </tr>

  <tr>
    <td><img height="7" src=""></td>
  </tr>
  <tr>
    <td height="28" background="images/admin_title.jpg"><div class="admin_title1">&nbsp;模版管理</div></td>
  </tr>
  <tr>
    <td bgcolor="#D2D2D2"><table width="100%" border="0" cellspacing="0" cellpadding="5">
      <tr>
        <td class="admin_title2"><a target="mainFrame" href="admin_tem.htm">模版管理</a></td>
      </tr>
      <tr>
        <td class="admin_title2"><a target="mainFrame" href="admin_tem_add.htm">添加模版</a></td>
      </tr>

    </table></td>
  </tr>
    <tr>
    <td><img height="7" src=""></td>
  </tr>
  <tr>
    <td height="28" background="images/admin_title.jpg"><div class="admin_title1">&nbsp;广告管理</div></td>
  </tr>
  <tr>
    <td bgcolor="#D2D2D2"><table width="100%" border="0" cellspacing="0" cellpadding="5">
      <tr>
        <td class="admin_title2"><a target="mainFrame" href="admin_ads.htm">广告位管理</a></td>
      </tr>
      <tr>
        <td class="admin_title2"><a target="mainFrame" href="admin_ad.htm">广告管理</a></td>
      </tr>

    </table></td>
  </tr>

  <tr>
    <td><img height="7" src=""></td>
  </tr>
  <tr>
    <td height="28" background="images/admin_title.jpg"><div class="admin_title1">&nbsp;版权声明</div></td>
  </tr>
  <tr>
    <td bgcolor="#D2D2D2"><table width="100%" border="0" cellspacing="0" cellpadding="5">
      <tr>
        <td><div  class="admin_title2">本网站系统版权归易拍得网站(Epaide.Com)所有。</div></td>
      </tr>
    </table></td>
  </tr>
</table>

</body>
</html>