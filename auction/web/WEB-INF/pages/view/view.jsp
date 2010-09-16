<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>

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
			//alert(data);
			//document.getElementById("showMsg").style.display = "block";
		}
	}
	function showAll() {
		trade.submit();
	}
</script>

<form action="showAll.action" method="post" name="trade">
	
	<table width="100%" border="0" align="center" valign="top" cellpadding="0" cellspacing="0">
		<tr>
			<td colspan="4" height="20" align="center" background="images/r_top.gif">
				&nbsp;
			</td>
		</tr>
		<tr height="20">
			<td width="10" rowspan="3" background="images/r_left.gif">
				&nbsp;
			</td>
			<td width="387" valign="top" align="left" bgcolor="#FFFFFF">
				<img src="images/jpsp.gif" width="99" height="28">
			</td>
			<td width="388" align="right" bgcolor="#FFFFFF">
				<a href="#" onclick="showAll()">全部竞拍>></a>&nbsp;&nbsp;
			</td>
			<td width="10" rowspan="3" background="images/r_right.gif">
				&nbsp;
			</td>
		</tr>
		<tr height="1">
			<td colspan="2" height="1" background="images/hr.gif">
			</td>
		</tr>
		<tr>
			<td colspan="2" valign="top" bgcolor="#FFFFFF">
				<table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%">
					<tr>
						<% int i = 0; %>
						<s:iterator value="dataList" id="data" status="status">
						<%
							if (i == 5) {
								i = 1;
						%>
							</tr>
							<tr>	
						<%	} else {
								i ++;
							}
						 %>
						 <td width="154">
							<table width="98%" border="0" align="center" cellpadding="3"
								cellspacing="0">
								<tr>
									<td width="100%">
										<img src="images/title_l.gif" width="3" height="12">
										&nbsp;
										<a href="viewAuctionNow.action?id=${data.id }"><s:property id="data" value="tradename"/></a>
									</td>
								</tr>
								<tr>
									<td align="center">
										<a href="viewAuctionNow.action?id=${data.id }">
											<img alt="" src="showImage.action?id=${data.id }" border="0" width="120" height="120"/> 
										</a>
									</td>
								</tr>
								<tr height="30"  valign="middle">
									<td align="center" class="indextime">
										<div id="div${status.index }" style="color:red">
											<script type="text/javascript">
												var div${status.index } = null;
												var time${status.index } = ${data.remaining};
												div${status.index } = setInterval("displayTime('div${status.index }', time${status.index }, div${status.index }, '${data.id}', '${status.index }')", 1000);
											</script>
										</div>
									</td>
								</tr>
								<tr height="30"  valign="middle">
									<td align="center">
										<p class="indexjg" id="userdisplay${status.index }">
											<input type="hidden" id="user${status.index }" value="">
										</p>
									</td>
								</tr>
								<tr height="30"  valign="middle">
									<td align="center">
										<p class="indexjg" id="display${status.index }">
											￥${data.marketPrice }
											<input type="hidden" id="price${status.index }" value="${data.marketPrice }">
										</p>
									</td>
								</tr>
								<tr>
									<td align="center">
										<img src="images/wyjp.gif" width="104" height="27" style="display: bolck" onclick="doSubmit('${data.id}', '${status.index }');" id="buttion${status.index }">
									</td>
								</tr>
							</table>
						</td>
						</s:iterator>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td colspan="4"  height="20" align="center" background="images/r_dow.gif">
				&nbsp;
			</td>
		</tr>
	</table>
</form>
