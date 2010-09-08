<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<html>
	<head>
		<%@ include file="/resources/resources.jsp"%>
		<script type="text/javascript" src="js/dwr/buyRomet.js"></script>
		<script type="text/javascript" src="js/dwr/auctionRomet.js"></script>
		<script type="text/javascript">
			function showAll() {
				form1.action = "bidingSearch.action";
				form1.submit();
			}
			function buyTrade(id) {
				buyRomet.buyTrad(id, callBackMethod);
			}
			function callBackMethod(data) {
				if (data == "success") {
					alert("已经购买查看购买订单");
				} else {
					alert(data);
				}
			} 
			/**
			 * 显示时间
			 * 
			 * @return
			 */
			function displayTime(id, time, timer, tid, did) {
				var maxtime = time / 1000;
				if (maxtime >= 0) {
					hour = Math.floor(maxtime / 3600);
					minutes = Math.floor((maxtime - hour * 3600) / 60);
					seconds = Math.floor(maxtime % 60);
					--maxtime;
					eval("time" + did + "=time" + did + "-1000");
					var msg = hour + ":" + minutes + ":" + seconds;
					document.all[id].innerHTML = msg;
					var userid = document.getElementById("user" + did).value;
					bidingRomet.find(tid,userid,did, showMsg);
				} else {
					var obj = document.getElementById("button" + did);
					obj.style.display = "none";
					clearInterval(timer);
					document.all[id].innerHTML = "竞拍结束";
				}
			}
			function showMsg(data) {
				if (data != "no") {
					var s = data.split(",");
					var index = (s[0].split(":"))[1];
					var uid = (s[1].split(":"))[1];
					var uname = (s[2].split(":"))[1];
					var price = (s[3].split(":"))[1];
					var add = (s[4].split(":"))[1];
					document.getElementById("user" + index).value = uid;
					document.getElementById("price" + index).value = price;
					document.getElementById("userdisplay" + index).innerHTML = uname;
					document.getElementById("display" + index).innerHTML = "￥" + price;
					var overtime = eval("time" + index);
					var lasttime = parseInt(add) * 1000;
					if (overtime - lasttime < 0) {
						eval("time" + index + "=" + lasttime);
					}
				}
			}
			function doSubmit(id, htmlId) {
				var price = document.getElementById("price" + htmlId).value;
				if (price == "") {
					price = "0";
				}
				var uid = document.getElementById("user" + htmlId).value;
				auctionRomet.auction(id, price, uid, htmlId, callBackMsg);
			}
			function callBackMsg(data) {
				var s = data.split(":");
				if (s[0] == "add") {
					eval("time" + s[1] + "=" + parseInt(s[2])*1000);
				} else if (s[0] == "success") {
					//alert("竞拍成功");
				} else {
					alert(data);
				}
			}
			function showAll() {
				trade.submit();
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
					<span class="admin_title1">${tradename }</span>&nbsp;
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
                <td width="360" align="center" valign="top"><img height="350" width="350" border="0" src="showImage.action?id=${tradeId }"></td>
              </tr>
              <tr>
                <td><table width="360" height="90" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td width="90" height="90" align="center" valign="middle" background="images/imgb.gif">
                    	<s:if test="image[0] != null">
                    	<img height="80" width="80" src="viewImage.action?id=${image[0] }">
                    	</s:if>
                    	<s:else>
                    		&nbsp;
                    	</s:else>
                    </td>
                    <td width="90" align="center" valign="middle" background="images/imgb.gif">
                    	<s:if test="image[1] != null">
                    	<img height="80" width="80">
                    	</s:if>
                    	<s:else>
                    		&nbsp;
                    	</s:else>
                    </td>
                    <td width="90" align="center" valign="middle" background="images/imgb.gif">
                    	<s:if test="image[2] != null">
                    	<img height="80" width="80">
                    	</s:if>
                    	<s:else>
                    		&nbsp;
                    	</s:else>
                    </td>
                    <td width="90" align="center" valign="middle" background="images/imgb.gif">
                    	<s:if test="image[3] != null">
                    	<img height="80" width="80">
                    	</s:if>
                    	<s:else>
                    		&nbsp;
                    	</s:else>
                    </td>
                  </tr>
                </table></td>
              </tr>
            </table>
            </td>
            <td width="52%" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="4">
              <tr>
                <td width="59%"><strong>当前竞拍价格：</strong></td>
                <td width="41%" class="indexjg">
                <p class="indexjg" id="display0">
						￥${markprices }	
				</p>
                	
                <input type="hidden" id="price0" value="${markprices }">
                </td>
              </tr>
              <tr>
                <td>竞拍者：</td> 
	             <td>
	             <p class="indexjg" id="userdisplay0">
							${user }						
				</p>
				<input type="hidden" id="user0" value="${user }">
	             </td>
				</tr>
              <tr>
                <td>市场价：</td>
                <td>￥${prices }</td>
              </tr>
              <tr>
                <td colspan="2" align="center">
                <div id="div0" class="jptime" style="color:red">
					<script type="text/javascript">
						var div0 = null;
						var time0 = ${remaining};
						div0 = setInterval("displayTime('div0', time0, div0, '${id}', '0')", 1000);
						
					</script>
				</div><br>
                  每次竞价商品价格增加￥${markup }&nbsp;&nbsp;时间增加${addtime }秒<br>
                  此${type }
                  	 </td>
                </tr>
              <tr>
                <td colspan="2" align="center"><table width="70%" height="37" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                    	 <td width="104" height="37"><img src="images/wyjp.gif" width="104" height="27" onclick="doSubmit('${id}', '0');"></td>
                      <td width="200" height="37" align="center" background="images/jgb.gif"><a href="#" onclick="buyTrade('${id}')"><strong><font color="#FFFFFF">现在购买￥${buyprices }</font></strong></a></td>
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