<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<script type="text/javascript">
	function previous() {
		var currentPage = document.getElementById("pageBean.currentPage").value;
		if (parseInt(currentPage) != 1) {
			document.getElementById("pageBean.currentPage").value = parseInt(currentPage) - 1;
			help.action = "aidsearch.action";
			help.submit();
		}
	}
	function next() {
		var currentPage = document.getElementById("pageBean.currentPage").value;
		var totalPage = document.getElementById("pageBean.totalPage").value;
		if (parseInt(currentPage) != (totalPage)) {
			document.getElementById("pageBean.currentPage").value = parseInt(currentPage) + 1;
			help.action = "aidsearch.action";
			help.submit();
		}
	}
	function first() {
		var currentPage = document.getElementById("pageBean.currentPage").value;
		if (parseInt(currentPage) > 1) {
			document.getElementById("pageBean.currentPage").value = 1;
			help.action = "aidsearch.action";
			help.submit();
		}
	}
	function last() {
		var currentPage = document.getElementById("pageBean.currentPage").value;
		var totalPage = document.getElementById("pageBean.totalPage").value;
		if (parseInt(currentPage) < totalPage) {
			document.getElementById("pageBean.currentPage").value = parseInt(totalPage);
			help.action = "aidsearch.action";
			help.submit();
		}
	}
	function view(id) {
		help.id.value = id;
		help.action = "bingcurForward.action";
		help.submit();
	}
	function doAid(id) {
		var start = document.getElementById(id + "_startPirce").value;
		var end = document.getElementById(id + "_endPrice").value;
		var count = document.getElementById(id + "_ecount").value;
		var partten_1 = /^\d+$/;
		var partten_2 = /^\d+(\.\d+)?$/;
		if (!partten_2.test(start)) {
			alert('开始价格数值型');
			return false;
		}
		if (!partten_2.test(end)) {
			alert('结束价格数值型');
			return false;
		}
		if (!partten_1.test(count)) {
			alert('E拍币数量数值型');
			return false;
		}
		var sid = document.getElementById(id + "_comid").value;
		var aid = document.getElementById(id + "_id").value;
		loginRomet.checkedUser(sid,start,end,count,'upd',aid,callAid);
	}
	function callAid(data) {
		if (data == 'success') {
			window.location.href = 'aidsearch.action';
		} else {
			alert(data);
		}
	}
	function doDel(id) {
		loginRomet.deleteAid(id,callDelAid);
	}
	function callDelAid(data) {
		if (data == 'success') {
			window.location.href = 'aidsearch.action';
		} else {
			alert(data);
		}
	}
</script>

<table width="795" border="0" align="center" cellpadding="0"
	cellspacing="0">
	<tr>
		<td colspan="3" width="795" height="20" background="images/r_top.gif">
		</td>
	</tr>
	<tr>
		<td width="10" rowspan="3" background="images/r_left.gif">
			<img src="images/r_left.gif" width="10" height="1">
		</td>
		<td width="775" height="40" align="center" bgcolor="#FFFFFF"
			class="admin_title1">
			竞拍助理
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
		<td  valign="top" bgcolor="#FFFFFF">
			<table width="775" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td>
						<form method="post" name="help" action="aidsearch.action">
							<s:hidden name="pageBean.currentPage" />
							<s:hidden name="pageBean.totalPage" />
							
							<table width="100%" border="0" align="center" cellpadding="10"
								cellspacing="0">
								<tr>
									<td height="30" colspan="2" align="center">
										<p class="indexjg">
											商品描述
										</p>
									</td>
									<td  align="center">
										<p class="indexjg">
											开始价格
										</p>
									</td>
									<td  align="center">
										<p class="indexjg">
											终止价格
										</p>
									</td>
									<td  align="center">
										<p class="indexjg">
											竞拍E币数
										</p>
									</td>
									<td  align="center">
										<p class="indexjg">
											操作
										</p>
									</td>
								</tr>
								<s:iterator value="dataList" id="data" status="status">
									<tr>
										<td colspan="6" background="images/hr.gif" height="1">
										</td>
									</tr>
									<tr>
										<td align="center" colspan="2" >
										<a href="viewAuctionNow.action?id=${data.comid }">
											${data.comname }
											<input type="hidden" id="${data.id }_comid" value="${data.comid }"/>
											<input type="hidden" id="${data.id }_id" value="${data.id }"/>
										</a>
										</td>
										<td align="center">
											<input type="text" id="${data.id }_startPirce" value="${data.startPirce }" size="10" maxlength="10"/>
										</td>
										<td align="center">
											<input type="text" id="${data.id }_endPrice" value="${data.endPrice }" size="10" maxlength="10"/>
										</td>
										<td align="center">
											<input type="text" id="${data.id }_ecount" value="${data.ecount + data.paycount}" size="10" maxlength="5"/>
											
										</td>
										<td align="center">
											<a href="#" onclick="doAid('${data.id}')">修改</a>|<a href="#" onclick="doDel('${data.id}')">删除</a>
										</td>
									</tr>
								</s:iterator>
								<tr>
									<td align="right" colspan="5">
										<a href="#" onclick="first();">首页</a>&nbsp;&nbsp;
										<a href="#" onclick="previous();">上一页</a>&nbsp;&nbsp;
										<a href="#" onclick="next();">下一页</a>&nbsp;&nbsp;
										<a href="#" onclick="last();">尾页</a>
									</td>
								</tr>
							</table>
						</form>
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