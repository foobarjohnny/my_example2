<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<html>
	<head>
		<%@ include file="/resources/resources.jsp"%>
		<script type="text/javascript" src="js/dwr/auctionRomet.js"></script>
		<script type="text/javascript">
	/**
	 * 显示时间
	 * 
	 * @return
	 */
	function displayTime(id, time, timer, tid, did) {
		//var newDate = new Date();
		//var first = time.getTime();
		//var last = newDate.getTime();
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
			//bidingRomet.find(tid,userid,did, showMsg);
		} else {
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
			document.getElementById("user" + index).value = uid;
			document.getElementById("price" + index).value = price;
			document.getElementById("userdisplay" + index).innerHTML = uname;
			document.getElementById("display" + index).innerHTML = "￥" + price;
		}
	}
	function doSubmit(id, htmlId) {
		var price = document.getElementById("price" + htmlId).value;
		if (price == "") {
			price = "0";
		}
		var uid = document.getElementById("user" + htmlId).value;
		auctionRomet.auction(id, price, uid, callBackMsg);
	}
	function callBackMsg(data) {
		if (data != "success") {
			alert(data);
		}
	}
</script>
	</head>
	<body>
		<table width="795" border="0" align="center" cellpadding="0"
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
				<td width="387" valign="top" bgcolor="#FFFFFF">
					&nbsp;&nbsp;
					<img src="images/jpsp.gif" width="99" height="28">
				</td>
				<td width="388" align="right" bgcolor="#FFFFFF">
					<a href="jpall.htm">全部竞拍>></a>&nbsp;&nbsp;
				</td>
				<td width="10" rowspan="3" background="images/r_right.gif">
					<img src="images/r_right.gif" width="10" height="1">
				</td>
			</tr>
			<tr>
				<td colspan="2" valign="top" background="images/hr.gif">
					<img src="images/hr.gif" width="1" height="1">
				</td>
			</tr>
			<tr>
				<td colspan="2" valign="top" bgcolor="#FFFFFF">
					<table width="775" border="0" cellspacing="0" cellpadding="0">
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
												<a href="jpshow.htm"><s:property id="data" value="tradename"/></a>
											</td>
										</tr>
										<tr>
											<td align="center">
												<a href="jpshow.htm"><img alt="" src="images/1_hot_006.jpg" border="0"/> </a>
											</td>
										</tr>
										<tr>
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
										<tr>
											<td align="center">
												<p class="indexjg" id="userdisplay${status.index }">
													
												</p>
												<input type="hidden" id="user${status.index }" value="">
											</td>
										</tr>
										<tr>
											<td align="center">
												<p class="indexjg" id="display${status.index }">
													￥${data.marketPrice }
												</p>
												<input type="hidden" id="price${status.index }" value="${data.marketPrice }">
											</td>
										</tr>
										<tr>
											<td align="center">
												<img src="images/wyjp.gif" width="104" height="27" onclick="doSubmit('${data.id}', '${status.index }');">
											</td>
										</tr>
									</table>
								</s:iterator>
							</td>
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