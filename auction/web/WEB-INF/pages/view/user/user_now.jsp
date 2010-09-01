<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<html>
	<head>
		<%@ include file="/resources/resources.jsp"%>
		<script type="text/javascript" src="js/dwr/userRomet.js"></script>
		<script type="text/javascript" src="js/dwr/auctionRomet.js"></script>
		<script type="text/javascript">
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
				clearInterval(timer);
				document.all[id].innerHTML = "竞拍结束";
				//document.getElementById("button" + did).style.display = "none";
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
		function previous() {
			var currentPage = document.getElementById("pageBean.currentPage").value;
			var totalPage = document.getElementById("pageBean.totalPage").value;
			if (parseInt(currentPage) != 1 && parseInt(totalPage) > 0) {
				document.getElementById("pageBean.currentPage").value = parseInt(currentPage) - 1;
				help.action = "userNow.action";
				help.submit();
			}
		}
		function next() {
			var currentPage = document.getElementById("pageBean.currentPage").value;
			var totalPage = document.getElementById("pageBean.totalPage").value;
			if (parseInt(currentPage) != (totalPage) && parseInt(totalPage) > 0) {
				document.getElementById("pageBean.currentPage").value = parseInt(currentPage) + 1;
				help.action = "userNow.action";
				help.submit();
			}
		}
		function first() {
			var currentPage = document.getElementById("pageBean.currentPage").value;
			if (parseInt(currentPage) >1) {
				document.getElementById("pageBean.currentPage").value = 1;
				help.action = "userNow.action";
				help.submit();
			}
		}
		function last() {
			var currentPage = document.getElementById("pageBean.currentPage").value;
			var totalPage = document.getElementById("pageBean.totalPage").value;
			if (parseInt(currentPage) < totalPage) {
				document.getElementById("pageBean.currentPage").value = parseInt(totalPage);
				help.action = "userNow.action";
				help.submit();
			}
		}
		
		</script>
	</head>
	<body leftmargin="0" topmargin="0"
		style="filter: progid :   DXImageTransform.Microsoft.Gradient (   startColorStr =   '#6daf2f', endColorStr =   '#ffffff', gradientType =   '0' )">
		<table width="795" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td colspan="3">
					<img src="images/r_top.gif" width="795" height="20">
				</td>
			</tr>
			<tr>
				<td width="10" rowspan="3" background="images/r_left.gif">
					<img src="images/r_left.gif" width="10" height="1">
				</td>
				<td width="775" height="40" align="center" bgcolor="#FFFFFF"
					class="admin_title1">
					我正在参与的商品
				</td>
				<td width="10" rowspan="3" background="images/r_right.gif">
					<img src="images/r_right.gif" width="10" height="1">
				</td>
			</tr>
			<tr>
				<td valign="top" background="images/hr.gif">
					<img src="images/hr.gif" width="1" height="1">
				</td>
			</tr>
			<tr>
				<td valign="top" bgcolor="#FFFFFF">
					<form method="post" name="help" action="bidingSearch.action">
					<s:hidden name="pageBean.currentPage" />
					<s:hidden name="pageBean.totalPage" />
					<table width="760" border="0" align="center" cellpadding="0" cellspacing="3">
						<tr>
				            <td height="30" colspan="2" align="center"><p class="indexjg">商品描述</p></td>
				            <td width="85" align="center"><p class="indexjg">最新价格</p></td>
				            <td width="115" align="center"><p class="indexjg">竞价人</p></td>
				            <td width="118" align="center"><p class="indexjg">我要竞拍</p></td>
			          	</tr>
			          	<s:iterator id="data" value="tradeData" status="status">
			          	<tr>
				            <td width="100" align="center"><a href="jpshow.htm"><img width="100" height="100" border="0" src="showImage.action?id=${data.id }"></a></td>
				            <td width="324"><strong><a href="jpshow.htm"><s:property id="data" value="tradename"/></a></strong><br>
				            	
				            </td>
				            <td align="center">
				            <p class="indexjg" id="display${status.index }">
								￥${data.marketPrice }
							</p>
							<input type="hidden" id="price${status.index }" value="${data.marketPrice }">
				            </td>
				            <td align="center">
				            <p class="indexjg" id="userdisplay${status.index }">
													
							</p>
							<input type="hidden" id="user${status.index }" value="">
				            </td>
				            <td align="center">
				            <div id="div${status.index }" style="color:red">
				            <p class="indextime">
								<script type="text/javascript">
									var div${status.index } = null;
									var time${status.index } = ${data.remaining};
									div${status.index } = setInterval("displayTime('div${status.index }', time${status.index }, div${status.index }, '${data.id}', '${status.index }')", 1000);
									
								</script>
				            </p>
				            </div>
				                <p><img src="images/wyjp.gif" width="104" height="27" onclick="doSubmit('${data.id}', '${status.index }');" id="buttion${status.index }"></p>
				            </td>
				        </tr>
				        </s:iterator>
				        <s:if test="tradeData.size != 0">
				        <tr>
			            	<td align="right" colspan="5">
			            		<a href="#" onclick="first()">首页</a>&nbsp;&nbsp;
								<a href="#" onclick="previous()">上一页</a>&nbsp;&nbsp;
								<a href="#" onclick="next()">下一页</a>&nbsp;&nbsp;
								<a href="#" onclick="last()">尾页</a>
			            	</td>
			            </tr>
			            </s:if>
					</table>
					</form>
				</td>
			</tr>
			<tr>
				<td colspan="3">
					<img src="images/r_dow.gif" width="795" height="20">
				</td>
			</tr>
		</table>
	</body>
</html>