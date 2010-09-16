<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
		<%@ include file="/resources/resources.jsp"%>
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
	function showAll() {
		help.action = "showAll.action";
		help.submit();
	}
	function previous() {
		var currentPage = document.getElementById("pageBean.currentPage").value;
		if (parseInt(currentPage) != 1) {
			document.getElementById("pageBean.currentPage").value = parseInt(currentPage) - 1;
			help.action = "showAll.action";
			help.submit();
		}
	}
	function next() {
		var currentPage = document.getElementById("pageBean.currentPage").value;
		var totalPage = document.getElementById("pageBean.totalPage").value;
		if (parseInt(currentPage) != (totalPage) && parseInt(totalPage) > 0 && parseInt(currentPage) < parseInt(totalPage)) {
			document.getElementById("pageBean.currentPage").value = parseInt(currentPage) + 1;
			help.action = "showAll.action";
			help.submit();
		}
	}
	function first() {
		var currentPage = document.getElementById("pageBean.currentPage").value;
		if (parseInt(currentPage) >1) {
			document.getElementById("pageBean.currentPage").value = 1;
			help.action = "showAll.action";
			help.submit();
		}
	}
	function last() {
		var currentPage = document.getElementById("pageBean.currentPage").value;
		var totalPage = document.getElementById("pageBean.totalPage").value;
		if (parseInt(currentPage) < totalPage) {
			document.getElementById("pageBean.currentPage").value = parseInt(totalPage);
			help.action = "showAll.action";
			help.submit();
		}
	}
</script>

		<form action="" method="post" name="help">
		<s:hidden name="pageBean.currentPage" />
		<s:hidden name="pageBean.totalPage" />
		<input type="hidden" name="id" value="">
		</form>
		<table width="795" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td colspan="4" height="20" align="center" background="images/r_top.gif">
					&nbsp;
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
					&nbsp;&nbsp;
				</td>
				<td width="10" rowspan="3" background="images/r_right.gif">
					<img src="images/r_right.gif" width="10" height="1">
				</td>
			</tr>
			<tr>
				<td colspan="4" valign="top" background="images/hr.gif" height="1">
				</td>
			</tr>
			<tr>
				<td colspan="4" valign="top" bgcolor="#FFFFFF">
					<table width="765" border="0" cellspacing="0" cellpadding="0">
						<tr>
			              <td height="30" colspan="2" align="center"><p class="indexjg">商品描述</p></td>
			              <td width="87" align="center"><p class="indexjg">最新价格</p></td>
			              <td width="119" align="center"><p class="indexjg">竞价人</p></td>
			              <td width="117" align="center"><p class="indexjg">我要竞拍</p></td>
			            </tr>
			            <s:iterator value="dataList" id="data" status="status">
			            <tr>
			              	<td colspan="5" background="images/hr.gif"><img src="images/hr.gif" width="1" height="1"></td>
			            </tr>
						<tr>
							<td width="130" height="130" align="center">
								<a href="viewAuctionNow.action?id=${data.id }" ><img width="120" height="120" border="0" src="showImage.action?id=${data.id }"></a>
							</td>
							<td>
								<a href="viewAuctionNow.action?id=${data.id }" ><s:property id="data" value="tradename"/></a>
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
							<td align="center" class="indextime">
								<div id="div${status.index }" style="color:red">
									<script type="text/javascript">
										var div${status.index } = null;
										var time${status.index } = ${data.remaining};
										div${status.index } = setInterval("displayTime('div${status.index }', time${status.index }, div${status.index }, '${data.id}', '${status.index }')", 1000);
										
									</script>
									
								</div>
								<img src="images/wyjp.gif" width="104" height="27" onclick="doSubmit('${data.id}', '${status.index }');" id="buttion${status.index }">
							</td>
						</tr>		
						</s:iterator>
						<tr>
			              <td height="30" colspan="5">
				              <div align="right">
				              	<a href="#" onclick="first()">首页</a>&nbsp;&nbsp;
								<a href="#" onclick="previous()">上一页</a>&nbsp;&nbsp;
								<a href="#" onclick="next()">下一页</a>&nbsp;&nbsp;
								<a href="#" onclick="last()">尾页</a>
							  </div>
						  </td>
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