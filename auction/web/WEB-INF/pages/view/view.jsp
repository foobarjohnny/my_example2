<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>

<script type="text/javascript">
	/**
	 * 检查竞拍的价格,相当于从服务端去读取信息的过程， 从而将所有变化了的竞拍产品的信息更新的过程
	 */
	function checkAuction(){
		bidingRomet.find("","","", showMsg);
		setTimeout("checkAuction()",1000);
	}

	/**
	 * 获取了最新的价格之后的回调方法
	 */
	function showMsg(data) {
		//document.getElementById('result').value=data;
		
		var obj = eval('(' + data +')');
		
		for(i = 0; i < obj.length; i++){
			var bean = obj[i];
			//检查是否是空对象
			if(typeof(bean.id) != 'undefined'){//首先检查是否有指定产品编号
				if(!bean.isFinish){
					document.getElementById(bean.id+"_user_div").innerHTML=""+bean.username;
					if( document.getElementById(bean.id+"_user").value != bean.userId){
						document.getElementById(bean.id+"_price_div").style.color = '#F0F';
					}
					document.getElementById(bean.id+"_user").value=bean.userId;
					document.getElementById(bean.id+"_price").value=bean.price;
					document.getElementById(bean.id+"_time_div").innerHTML=bean.time;
					document.getElementById(bean.id+"_price_div").innerHTML="￥" + bean.price;
					document.getElementById(bean.id+"_price_div").style.backgroundcolor="red";
				}else{//该商品的竞拍结束， 提示秒杀客户竞拍的结果。
					//TODO  仿照大家点用来提示客户中奖信息
					
				}
			}
		}		
	}

	/**
	 * 当前客户竞拍了产品， 将后台的竞拍产品的信息变更的过程， 相当于向后台服务器写的过程
	 */
	function doSubmit(id, isLogin) {
		var uid = document.getElementById(id+'_user').value;
		auctionRomet.auction(id, "", uid, "", callBackMsg);
	}
	function callBackMsg(data) {
		var obj = eval('('+data+')');
		if(typeof(obj.operator) != 'undefined' && obj.operator == "success"){
			if(typeof(obj.add) != 'undefined' && obj.add != ""){//时间发生变化了，价格的变化，是另外一个函数获取
				
			}
		}else{
			alert(obj.msg);
		}
	}
	/**
	 * ==============================以下的内容是投票的过程==========================================
	 */
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
	function vote(id) {
		publisRomet.vote(id,changeValue);
	}
	function changeValue(data) {
		if (data != "error") {
			var s = data.split(",");
			document.all["d" + s[0]].innerHTML = s[1];			
		}
	}
	function view(id) {
		help.id.value = id;
		help.action = "coolForward.action";
		help.submit();
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
			<td colspan="2" valign="top" bgcolor="#FFFFFF">
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
								<tr height="60">
									<td width="100%" valign="top">
										<img src="images/title_l.gif" width="3" height="12">
										&nbsp;
										<a href="viewAuctionNow.action?id=${data.id }"><s:property
												id="data" value="tradename" />
										</a>
									</td>
								</tr>
								<tr height="90">
									<td align="center" valign="top">
										<a href="viewAuctionNow.action?id=${data.id }">
											<s:if test="imagesPath != null && imagesPath.size > 0">
												<img alt="" src="${imagesPath[0] }" border="0" width="90" height="90" /> 
											</s:if>
											<s:else>
												<img alt="" src="images/imgb.gif" border="0" width="90" height="90" /> 
											</s:else>
										</a>
									</td>
								</tr>
								<tr height="30" valign="middle">
									<td align="center" class="indextime">
										<div id="${data.id }_time_div"
											style=" font-size: 24px; font-weight: bold;">
											--:--:--
										</div>
									</td>
								</tr>
								<tr height="30" valign="middle">
									<td align="center">
										<div id="${data.id}_user_div" class="indexjg">
										</div>
										<input type="hidden" id="${data.id }_user" name="displayUser" value="">
									</td>
								</tr>
								<tr height="30" valign="middle">
									<td align="center">
										<div id="${data.id }_price_div" class="indexjg" style="color:black;">
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
												style="display: bolck;cursor: hand;" onmousemove="btnMouseOn('${data.id}', '${user_login }', this);" 
												onmouseout="btnMouseAway(this);"
												onclick="doSubmit('${data.id}','${user_login }');" />
										</div>
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
			<td colspan="4" height="20" align="center"
				background="images/r_dow.gif">
				&nbsp;
			</td>
		</tr>
	</table>
</form>
<table width="795" border="0" align="center" cellpadding="0"
	cellspacing="0">
	<tr>
			<td colspan="3" height="20" align="center" background="images/r_top.gif">
				&nbsp;
			</td>
	</tr>
	<tr>
		<td width="10" rowspan="3" background="images/r_left.gif">
			<img src="images/r_left.gif" width="10" height="1">
		</td>
		<td width="775" valign="top" bgcolor="#FFFFFF">&nbsp;&nbsp;<img src="images/kptp.gif" width="99" height="28"> </td>
		<td width="10" rowspan="3" background="images/r_right.gif">
			<img src="images/r_right.gif" width="10" height="1">
		</td>
	</tr>
	<tr>
		<td colspan="3" valign="top" background="images/hr.gif" height="1">
		</td>
	</tr>
	<tr>
		<td  valign="top" bgcolor="#FFFFFF">
			<form method="post" name="help" action="coolSearch.action">
				<s:hidden name="pageBean.currentPage" />
				<s:hidden name="pageBean.totalPage" />
				<input type="hidden" name="id">
				<table width="760" border="0" align="center" cellpadding="0"
					cellspacing="3">
					<tr>
						<td height="30" colspan="2" align="center">
							<p class="admin_title1">
								商品描述
							</p>
						</td>
						<td width="139" align="center">
							<p class="admin_title1">
								市场价
							</p>
						</td>
						<td width="104" align="center">
							<p class="admin_title1">
								投票
							</p>
						</td>
					</tr>
					<s:iterator id="data" value="publisList" status="status">

						<tr>
							<td width="130" height="130" align="center">
								<a href="#" onclick="view('${data.id }')">
									<s:if test="imagesPath != null && imagesPath.size > 0">
										<img alt="" src="${imagesPath[0] }" border="0" width="120" height="120" /> 
									</s:if>
									<s:else>
										<img alt="" src="images/imgb.gif" border="0" width="120" height="120" /> 
									</s:else>
								</a>
							</td>
							<td width="274">
								<strong>${data.tradename }</strong>
								<br>

							</td>
							<td align="center">
								￥${data.price }
							</td>
							<td align="center">
								<div id="d${data.id }">
									${data.amount }
								</div>
								<input type="button" value="酷一下" onclick="vote('${data.id }')">
							</td>
						</tr>
					</s:iterator>
				</table>
			</form>
		</td>
	</tr>
	<tr>
		<td colspan="3" height="20" align="center" background="images/r_dow.gif">
			&nbsp;
		</td>
	</tr>
</table>
<table width="100%" border="0" align="left" valign="top"
		cellpadding="0" cellspacing="0">
	<tr>
		<td align="left">
			<textarea cols="100" rows="20" id="result" style="display:none">
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