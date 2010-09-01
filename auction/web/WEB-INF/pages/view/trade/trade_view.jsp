<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<html>
	<head>
		<%@ include file="/resources/resources.jsp"%>
		<script type="text/javascript" src="js/dwr/buyRomet.js"></script>
		<script type="text/javascript">
			function showAll() {
				form1.action = "bidingSearch.action";
				form1.submit();
			}
			function buyTrade(id) {
				buyRomet.buyTradm(id, callBackMethod);
			}
			function callBackMethod(data) {
				if (data == "success") {
					alert("已经购买查看购买订单");
				} else {
					alert(data);
				}
			} 
		</script>
	</head>
	<body>
		<form action="bidingSearch.action" method="post" name="form1">
			<input type="hidden" name="id" value="${id }">
		</form>
		<table width="790" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td colspan="4">
					<img src="images/r_top.gif" width="795" height="20">
				</td>
			</tr>
			<tr>
				<td width="10" rowspan="3" background="images/r_left.gif">
					<img src="images/r_left.gif" width="10" height="1">
				</td>
				<td width="775" height="40" align="center" bgcolor="#FFFFFF">
					<span class="admin_title1">商品名称</span>&nbsp;
				</td>
				<td width="10" rowspan="3" background="images/r_right.gif">
					<img src="images/r_right.gif" width="10" height="1">
				</td>
			</tr>
			<tr>
				<td colspan="4" valign="top" background="images/hr.gif">
					<img src="images/hr.gif" width="1" height="1">
				</td>
			</tr>
			<tr>
				<td colspan="4" valign="top" bgcolor="#FFFFFF">
					<table width="99%" border="0" cellpadding="0" cellspacing="0">
		  <tr>
            <td width="48%" height="454" valign="top">
            	<table width="362" border="0" cellspacing="0">
              <tr>
                <td width="360" align="center" valign="top"><img height="360" width="360" border="0" src="showImage.action?id=${tradeId }"></td>
              </tr>
              <tr>
                <td><table width="360" height="90" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td width="90" height="90" align="center" valign="middle" background="images/imgb.gif"><img height="80" width="80"></td>
                    <td width="90" align="center" valign="middle" background="images/imgb.gif"><img height="80" width="80"></td>
                    <td width="90" align="center" valign="middle" background="images/imgb.gif">&nbsp;</td>
                    <td width="90" align="center" valign="middle" background="images/imgb.gif">&nbsp;</td>
                  </tr>
                </table></td>
              </tr>
            </table>
            </td>
            <td width="52%" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="4">
              <tr>
                <td width="59%"><strong>成交价格：</strong></td>
                <td width="41%" class="indexjg">￥${price }</td>
              </tr>
              <tr>
                <td>竞拍者：</td> 
	             <td>${user }</td>
				</tr>
              <tr>
                <td>市场价：</td>
                <td>￥${prices }</td>
              </tr>
              <tr>
                <td>E拍币：</td>
                <td>${amount }枚（￥${amount*1 }）</td>
              </tr>
              <tr>
                <td class="admin_title2">节省了：</td>
                <td class="indexsp">￥${prices-price-amount*1 }</td>
              </tr>
              <tr>
                <td colspan="2" align="center"><div class="jptime">竞拍已经结束</div><br>
                  		结束时间：${binddate }                  </td>
                </tr>
              <tr>
                <td colspan="2" align="center"><table width="200" height="37" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="200" height="37" align="center" background="images/jgb.gif"><a href="#" onclick="buyTrade('${id}')"><strong><font color="#FFFFFF">现在购买￥${markprices }</font></strong></a></td>
                    </tr>
                  </table></td>
                </tr>

              
            </table>
              <table width="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="#CCCCCC">
                <tr>
                  <td width="52%" bgcolor="#CCCCCC"><strong>竞价记录</strong></td>
                  <td width="48%" align="right" bgcolor="#CCCCCC"><a href="#" onclick="showAll()">查看全部>></a></td>
                </tr>
                <tr>
                  <td colspan="2"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="50%" height="25" align="center"><strong>价格</strong></td>
                      <td width="50%" align="center"><strong>竞价者</strong></td>
                      </tr>
                      <s:iterator id="data" value="bidingList">
                      <tr>
	                      <td align="center">￥${data.price }</td>
	                      <td align="center">${data.username }</td>
                     </tr>
                     </s:iterator>
                  </table></td>
                </tr>
              </table></td>
		    </tr>
          <tr>
            <td height="30" colspan="2">&nbsp;<img src="images/title_l.gif" width="3" height="12">&nbsp;<span class="admin_title1">商品描述</span></td>
            </tr>
          <tr>
            <td height="1" colspan="2" align="center" background="images/hr.gif"><img src="images/hr.gif" width="1" height="1"></td>
          </tr>
          <tr>
            <td height="31" colspan="2"><p>${summary }</p>
              <p><font color="#FF0000">声明： 易拍得网保证网站上所有的竞拍商品(淘宝岛栏目除外)均为全新的原装正品，质量可靠支持专柜验货及验证码验货。品牌产品信息以官方网站提供为准，由于产品的批次问题，实际产品的包装、产地以及附件等可能会与网站资料有细微差别，敬请大家谅解！</font></p></td>
          </tr>
        </table>
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<img src="images/r_dow.gif" width="795" height="20">
				</td>
			</tr>
		</table>
	</body>
</html>