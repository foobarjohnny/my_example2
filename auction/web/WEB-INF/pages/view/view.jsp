<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>

<script type="text/javascript">
	/**
	 * 显示时间
	 * 
	 * @return
	 */
	function displayTime(obj) {
		var d = eval('('+obj+')');
		var t = parseInt(d.time);
		var maxtime = t / 1000;
		if (maxtime < 0) {
			var auctionDiv = document.getElementById(d.id+"_auction_div");
			auctionDiv.style.display = "none";
			document.getElementById(d.id+"_time_div").innerHTML = "竞拍结束";
		}else{
			if(document.getElementById(d.id+"_sign").value == "1"){
				document.getElementById(d.id+"_sign").value = "0";
				t = parseInt(document.getElementById(d.id + "_remaining").value);
			}
			
			d.time = t - 1000;
			
			hour = Math.floor(maxtime / 3600);
			if(hour<10){hour = "0"+hour;}
			minutes = Math.floor((maxtime - hour * 3600) / 60);
			if(minutes < 10){minutes = "0" + minutes;}
			seconds = Math.floor(maxtime % 60);
			if(seconds < 10){seconds = "0" + seconds;}
			var msg = hour + ":" + minutes + ":" + seconds;
			document.getElementById(d.id+"_time_div").innerHTML = msg;
			document.getElementById(d.id+"_remaining").value=d.time;
			var newValue = JSON.stringify(d,"");
			setTimeout("displayTime('"+newValue+"')", 1000);
		}
	}

	/**
	 * 检查竞拍的价格
	 */
	function checkAuction(){
		bidingRomet.find("","","", showMsg);
		setTimeout("checkAuction()",1000);
	}

	/**
	 * 获取了最新的价格之后的回调方法
	 */
	function showMsg(data) {
		document.getElementById('result').value=data;
		var obj = eval('(' + data +')');
		
		for(i = 0; i < obj.length; i++){
			var bean = obj[i];
			//检查是否是空对象
			if(typeof(bean.id) != 'undefined'){//首先检查是否有指定产品编号
				if(typeof(bean.username) != 'undefined' && bean.username != ""){//再检查是否有客户对该产品进行竞拍，如果没有，则不处理，继续走时
					document.getElementById(bean.id+"_user_div").innerHTML=""+bean.username;
					document.getElementById(bean.id+"_user").value=bean.userId;
					document.getElementById(bean.id+"_price").value=bean.price;
					document.getElementById(bean.id+"_price_div").innerHTML="￥" + bean.price;
					var sourceTime = parseInt(document.getElementById(bean.id+'_remaining').value);
					var addTime    = parseInt(bean.add)*1000;
					if(sourceTime < addTime){
						document.getElementById(bean.id+'_remaining').value = addTime;
						document.getElementById(bean.id+'_sign').value = "1";
					}
				}
			}
		}
	}
	function doSubmit(id, isLogin) {
		var uid = document.getElementById(id+'_user').value;
		auctionRomet.auction(id, "", uid, "", callBackMsg);
	}
	function callBackMsg(data) {
		var obj = eval('('+data+')');
		if(typeof(obj.operator) != 'undefined' && obj.operator == "success"){
			if(typeof(obj.add) != 'undefined' && obj.add != ""){//时间发生变化了，价格的变化，是另外一个函数获取
				document.getElementById(obj.id+'_sign').value="1";
				document.getElementById(obj.id+'_remaining').value=obj.add;
			}
		}else{
			alert(obj.msg);
		}
		/**
		var s = data.split(":");
		if (s[0] == "add") {
			eval("time" + s[1] + "=" + parseInt(s[2])*1000);
		} else if (s[0] == "success") {
			//alert("竞拍成功");
		} else {
			//alert(data);
			//document.getElementById("showMsg").style.display = "block";
		}
		*/
	}
	function showAll() {
		trade.submit();
	}

	function btnMouseOn(id, status, obj){
		if(status != 'Y'){
			obj.src="images/wydl.png";
		}
	}

	function btnMouseAway(obj){
		obj.src="images/wyjp.gif";
	}
</script>

<form action="showAll.action" method="post" name="trade">
	<table width="100%" border="0" align="center" valign="top"
		cellpadding="0" cellspacing="0">
		<tr>
			<td colspan="4" height="20" align="center"
				background="images/r_top.gif">
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
			<td colspan="4" height="1" background="images/hr.gif">
			</td>
		</tr>
		<tr>
			<td colspan="4" valign="top" bgcolor="#FFFFFF">
				<table width="100%" border="0" cellspacing="0" cellpadding="0"
					height="100%">
					<tr>
						<%
							int i = 0;
						%>
						<s:iterator value="dataList" id="data" status="status">
							<%
								if (i == 5) {
										i = 1;
							%>
					</tr>
					<tr>
						<%
							} else {
									i++;
								}
						%>
						<td width="154" valign="top" align="left">
							<table width="98%" border="0" align="center" cellpadding="3"
								cellspacing="0">
								<tr>
									<td width="100%" valign="top">
										<img src="images/title_l.gif" width="3" height="12">
										&nbsp;
										<a href="viewAuctionNow.action?id=${data.id }"><s:property
												id="data" value="tradename" />
										</a>
									</td>
								</tr>
								<tr>
									<td align="center" valign="top">
										<a href="viewAuctionNow.action?id=${data.id }">
											<s:if test="imagesPath != null && imagesPath.size > 0">
												<img alt="" src="${imagesPath[0] }" border="0" width="90" height="90" /> 
											</s:if>
											<s:else>
												<img alt="" src="images/imgb.gif" border="0" width="120" height="120" /> 
											</s:else>
										</a>
									</td>
								</tr>
								<tr height="30" valign="middle">
									<td align="center" class="indextime">
										<div id="${data.id }_time_div"
											style="color: red; font-size: 24px; font-weight: bold;">
											--:--:--
										</div>
										<!-- 这是一个信号量， 用来标识时间价格是否有变化 -->
										<input type="hidden" id="${data.id }_sign" value="0" />
										<input type="hidden" id="${data.id}_remaining" value="${data.remaining }" />
									</td>
								</tr>
								<tr height="30" valign="middle">
									<td align="center">
										<div id="${data.id}_user_div" class="indexjg">
										</div>
										<input type="hidden" id="${data.id }_user" value="">
									</td>
								</tr>
								<tr height="30" valign="middle">
									<td align="center">
										<div id="${data.id }_price_div" class="indexjg">
											￥${data.marketPrice }
										</div>
										<input type="hidden" id="${data.id}_price"
											   value="${data.marketPrice }" />
									</td>
								</tr>
								<tr>
									<td height="27" align="center" valign="top">
										<div id="${data.id }_auction_div">
											<img src="images/wyjp.gif" width="104" height="27"
												style="display: bolck" onmousemove="btnMouseOn('${data.id}', '${user_login }', this);" 
												onmouseout="btnMouseAway(this);"
												onclick="doSubmit('${data.id}','${user_login }');" />
										</div>
									</td>
								</tr>
							</table>
							<script type="text/javascript">
    							var obj_${data.id}='{"id":"${data.id}","time":${data.remaining}}';
    							displayTime(obj_${data.id});
    						</script>

						</td>
						</s:iterator>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td colspan="4" height="20" align="center"
				background="images/r_dow.gif">
				&nbsp;
			</td>
		</tr>
	</table>
</form>
<table width="100%" border="0" align="left" valign="top"
		cellpadding="0" cellspacing="0">
	<tr>
		<td align="left">
			<textarea cols=100 rows=20 id="result" style="display:none;">
			</textarea>
		</td>
	</tr>
</table>
	
<script type="text/javascript">
	checkAuction();

	function testTime(){
		document.getElementById("402881e529df7d870129df8c4a6b0003_sign").value = "1";
		document.getElementById("402881e529df7d870129df8c4a6b0003_remaining").value=5000;
	}
	//setTimeout("testTime()",2003);
</script> 