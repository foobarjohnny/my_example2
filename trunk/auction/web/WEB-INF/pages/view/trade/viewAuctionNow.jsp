<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<script type="text/javascript">
	function showAll() {
		form1.action = "bidingSearch.action";
		form1.submit();
	}
	function buyTrade(id, status) {
		if (status == 'Y') {		
			buyRomet.buyTrad(id, callBackMethod);
		} else {
			// 以后变换成登陆页
			alert('登陆后购买商品');
		}
	}
	function callBackMethod(data) {
		if (data == "success") {
			alert("已经购买成功， 请查看购买订单");
		} else {
			alert(data);
		}
	}
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
		bidingRomet.find("${id}","","", showMsg);
		setTimeout("checkAuction()",1000);
	}

	/**
	 * 获取了最新的价格之后的回调方法
	 */
	function showMsg(data) {
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
	
	function doSubmit(id, htmlId, status) {
		if (status == 'Y') {		
			var uid = document.getElementById(id+'_user').value;
			auctionRomet.auction(id, "", uid, "", callBackMsg);
		} else {
			// 以后变换成登陆页
			alert('登陆后购买商品');
		}
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
		form1.action="bidingSearch.action";
		form1.submit();
		//alert("【请注意】该功能目前没有提供！");
	}
</script>
<form action="bidingSearch.action" method="post" name="form1">
	<input type="hidden" name="id" value="${id }">
</form>
<table width="100%" border="0" align="center" cellpadding="0"
	cellspacing="0">
	<tr>
		<td colspan="3" height="20" align="center"
			background="images/r_top.gif">
			&nbsp;
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
		<td colspan="3" valign="top" background="images/hr.gif" height="1">
			
		</td>
	</tr>
	<tr>
		<td valign="top" bgcolor="#FFFFFF">
			<table width="99%" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td width="48%" height="454" valign="top">
						<table width="362" border="0" cellspacing="0">
							<tr>
								<td width="360" align="center" valign="top">
									<s:if test="imagesPath != null && imagesPath.size > 0">
										<img height="360" width="360" border="0" src="${imagesPath[0] }">
									</s:if>
									<s:else>
										<img height="350" width="350" border="0" >
									</s:else>
								</td>
							</tr>
							<tr>
								<td>
									<table width="360" height="90" border="0" cellpadding="0"
										cellspacing="0">
										<tr>
											<%
												int i = 0;
											 %>
											<s:iterator id="img" value="imagesPath">
												<%
													i++;
												 %>
												<td width="90" height="90" align="center" valign="middle"
													background="images/imgb.gif">
													<img height="80" width="80" src="${img }">
												</td>
											</s:iterator>
											<%
												for (int j = i; j < 4; j++) {
											%>
												<td width="90" height="90" align="center" valign="middle"
													background="images/imgb.gif">
													
												</td>
											<%		
												}
											 %>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
					<td width="52%" valign="top">
						<table width="100%" border="0" cellspacing="0" cellpadding="4">
							<tr>
								<td width="59%">
									<strong>当前竞拍价格：</strong>
								</td>
								<td width="41%" class="indexjg">
									<div id="${id }_price_div" class="indexjg">
											￥${marketPrice }
									</div>
									<input type="hidden" id="${id}_price"
										   value="${marketPrice }" />
								</td>
							</tr>
							<tr>
								<td>
									竞拍者：
								</td>
								<td>
									<div id="${id}_user_div" class="indexjg">
									</div>
									<input type="hidden" id="${id }_user" value="">
								</td>
							</tr>
							<tr>
								<td>
									市场价：
								</td>
								<td>
									￥${prices }
								</td>
							</tr>
							<tr>
								<td colspan="2" align="center">
									<div id="${id }_time_div"
											style="color: red; font-size: 24px; font-weight: bold;">
											--:--:--
									</div>
									<!-- 这是一个信号量， 用来标识时间价格是否有变化 -->
									<input type="hidden" id="${id }_sign" value="0" />
									<input type="hidden" id="${id}_remaining" value="${remaining }" />
									<script type="text/javascript">
		    							var obj_${id}='{"id":"${id}","time":${remaining}}';
		    							displayTime(obj_${id});
		    						</script>
									<br>
									每次竞价商品价格增加￥${markup }&nbsp;&nbsp;时间增加${addtime }秒
									<br>
									此${type }
								</td>
							</tr>
							<tr>
								<td colspan="2" align="center">
									<table width="70%" height="37" border="0" cellpadding="0"
										cellspacing="0">
										<tr>
											<td width="104" height="37">
												<img src="images/wyjp.gif" width="104" height="27"
													onclick="doSubmit('${id}', '0',  '${user_login }');">
											</td>
											<td width="200" height="37" align="center"
												background="images/jgb.gif">
												<a href="#" onclick="buyTrade('${id}', '${user_login }')"><strong><font
														color="#FFFFFF">现在购买￥${buyprices }</font> </strong> </a>
											</td>
										</tr>
									</table>
								</td>
							</tr>


						</table>
						<table width="100%" border="1" cellpadding="0" cellspacing="0"
							bordercolor="#CCCCCC">
							<tr>
								<td width="52%" bgcolor="#CCCCCC">
									<strong>竞价记录</strong>
								</td>
								<td width="48%" align="right" bgcolor="#CCCCCC">
									<a href="#" onclick="showAll();">查看全部>></a>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td width="50%" height="25" align="center">
												<strong>价格</strong>
											</td>
											<td width="50%" align="center">
												<strong>竞价者</strong>
											</td>
										</tr>
										<s:iterator id="data" value="bidingList">
											<tr>
												<td align="center">
													￥${data.price }
												</td>
												<td align="center">
													${data.username }
												</td>
											</tr>
										</s:iterator>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td height="30" colspan="2">
						&nbsp;
						<img src="images/title_l.gif" width="3" height="12">
						&nbsp;
						<span class="admin_title1">商品描述</span>
					</td>
				</tr>
				<tr>
					<td colspan="2" valign="top" align="center"
						background="images/hr.gif" height="1">
					</td>
				</tr>
				<tr>
					<td height="31" colspan="2">
						<p>
							${summary }
						</p>
						<p>
							<font color="#FF0000">声明：
								易拍得网保证网站上所有的竞拍商品(淘宝岛栏目除外)均为全新的原装正品，质量可靠支持专柜验货及验证码验货。品牌产品信息以官方网站提供为准，由于产品的批次问题，实际产品的包装、产地以及附件等可能会与网站资料有细微差别，敬请大家谅解！</font>
						</p>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td colspan="3" height="20" align="center" background="images/r_dow.gif">
			&nbsp;
		</td>
	</tr>
</table>
<script type="text/javascript">
	checkAuction();
</script> 