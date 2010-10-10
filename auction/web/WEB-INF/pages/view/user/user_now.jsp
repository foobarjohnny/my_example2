<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<script type="text/javascript">
/**
	 * 检查竞拍的价格,相当于从服务端去读取信息的过程， 从而将所有变化了的竞拍产品的信息更新的过程
	 */
	function checkAuction(){
		bidingRomet.find("","","", showMsg);
		setTimeout("checkAuction()",100);
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
					if (document.getElementById(bean.id+"_user_div")) {
						document.getElementById(bean.id+"_user_div").innerHTML=""+bean.username;
						if( document.getElementById(bean.id+"_user").value != bean.userId){
							document.getElementById(bean.id+"_price_div").style.color = '#F0F';
							var o = bean.id;
							setTimeout("displayStyle('" + o + "')",500);
						}
						document.getElementById(bean.id+"_user").value=bean.userId;
						document.getElementById(bean.id+"_price").value=bean.price;
						document.getElementById(bean.id+"_time_div").innerHTML=bean.time;
						document.getElementById(bean.id+"_price_div").innerHTML="￥" + bean.price;
						//document.getElementById(bean.id+"_price_div").style.backgroundcolor="red";
					}
				}else{//该商品的竞拍结束， 提示秒杀客户竞拍的结果。
					// 商品竞拍成功提示
					if (document.getElementById(bean.id+"_user_div")) {
						document.getElementById(bean.id+"_time_div").innerHTML= "恭喜：" + bean.username;
						document.getElementById(bean.id+"_user_div").innerHTML="成交价：￥" + bean.price;
						document.getElementById(bean.id+"_price_div").innerHTML="";
					}
				}
			}
		}		
	}

	/**
	* 价格变化显示
	*/
	function displayStyle(id) {
		document.getElementById(id+"_price_div").style.color = "black";
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
<table width="795" border="0" align="center" cellpadding="0" cellspacing="0">
	<tr>
		<td colspan="3"  width="795" height="20" background="images/r_top.gif">
		</td>
	</tr>
	<tr>
		<td width="10" rowspan="3" background="images/r_left.gif">
			<img src="images/r_left.gif" width="10" height="1">
		</td>
		<td width="775" height="40" align="center" bgcolor="#FFFFFF" class="admin_title1">
			我正在参与的商品
		</td>
		<td width="10" rowspan="3" background="images/r_right.gif">
			<img src="images/r_right.gif" width="10" height="1">
		</td>
	</tr>
	<tr>
		<td valign="top" background="images/hr.gif" height="1">
		</td>
	</tr>
	<tr>
		<td valign="top" bgcolor="#FFFFFF">
			<form method="post" name="help" action="bidingSearch.action">
				<s:hidden name="pageBean.currentPage" />
				<s:hidden name="pageBean.totalPage" />
				<table width="760" border="0" align="center" cellpadding="0"
					cellspacing="3">
					<tr>
						<td height="30" colspan="2" align="center">
							<p class="indexjg">
								商品描述
							</p>
						</td>
						<td width="85" align="center">
							<p class="indexjg">
								最新价格
							</p>
						</td>
						<td width="115" align="center">
							<p class="indexjg">
								竞价人
							</p>
						</td>
						<td width="118" align="center">
							<p class="indexjg">
								我要竞拍
							</p>
						</td>
					</tr>
					<s:iterator id="data" value="tradeData" status="status">
						<tr>
							<td width="100" align="center">
								<a href="viewAuctionNow.action?id=${data.id }">
									<s:if test="imagesPath != null && imagesPath.size > 0">
										<img alt="" src="${imagesPath[0] }" border="0" width="120" height="120" /> 
									</s:if>
									<s:else>
										<img alt="" src="images/imgb.gif" border="0" width="120" height="120" /> 
									</s:else>
								</a>
							</td>
							<td width="324">
								<strong>
								<a href="viewAuctionNow.action?id=${data.id }">
									<s:property id="data" value="tradename" />
								</a>
								</strong>
								<br>

							</td>
							<td align="center">
								<div id="${data.id }_price_div" class="indexjg">
									￥${data.marketPrice }
								</div>
								<input type="hidden" id="${data.id}_price"
									   value="${data.marketPrice }" />
							</td>
							<td align="center">
								<div id="${data.id}_user_div" class="indexjg">
								</div>
								<input type="hidden" id="${data.id }_user" value="">
							</td>
							<td align="center">
								<div id="${data.id }_time_div"
									style="color: red; font-size: 12px; font-weight: bold;">
									--:--:--
								</div>
								
								<!-- 这是一个信号量， 用来标识时间价格是否有变化 -->
								<input type="hidden" id="${data.id }_sign" value="0" />
								<input type="hidden" id="${data.id}_remaining" value="${data.remaining }" />
								<img src="images/wyjp.gif" width="104" height="27" onclick="doSubmit('${data.id}', '${status.index }',  '${user_login }');" id="buttion${status.index }">
							</td>
						</tr>
						<script type="text/javascript">
							var obj_${data.id}='{"id":"${data.id}","time":${data.remaining}}';
							displayTime(obj_${data.id});
						</script>	
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
<script type="text/javascript">
	checkAuction();

	function testTime(){
		document.getElementById("402881e529df7d870129df8c4a6b0003_sign").value = "1";
		document.getElementById("402881e529df7d870129df8c4a6b0003_remaining").value=5000;
	}
	//setTimeout("testTime()",2003);
</script> 