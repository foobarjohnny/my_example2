<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<script type="text/javascript">
	function previous() {
		var currentPage = document.getElementById("pageBean.currentPage").value;
		if (parseInt(currentPage) != 1) {
			document.getElementById("pageBean.currentPage").value = parseInt(currentPage) - 1;
			help.action = "searchUserPayE.action";
			help.submit();
		}
	}
	function next() {
		var currentPage = document.getElementById("pageBean.currentPage").value;
		var totalPage = document.getElementById("pageBean.totalPage").value;
		if (parseInt(currentPage) != (totalPage) && parseInt(totalPage) > 0 && parseInt(currentPage) < parseInt(totalPage)) {
			document.getElementById("pageBean.currentPage").value = parseInt(currentPage) + 1;
			help.action = "searchUserPayE.action";
			help.submit();
		}
	}
	function first() {
		var currentPage = document.getElementById("pageBean.currentPage").value;
		if (parseInt(currentPage) >1) {
			document.getElementById("pageBean.currentPage").value = 1;
			help.action = "searchUserPayE.action";
			help.submit();
		}
	}
	function last() {
		var currentPage = document.getElementById("pageBean.currentPage").value;
		var totalPage = document.getElementById("pageBean.totalPage").value;
		if (parseInt(currentPage) < totalPage) {
			document.getElementById("pageBean.currentPage").value = parseInt(totalPage);
			help.action = "searchUserPayE.action";
			help.submit();
		}
	}
	function view(id) {
		help.id.value = id;
		help.action = "bingcurForward.action";
		help.submit();
	}
</script>
<form method="post" name="help" action="searchUserPayE.action">
	<s:hidden name="pageBean.currentPage" />
	<s:hidden name="pageBean.totalPage" />
	<input type="hidden" name="id">

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
				E拍币消费明细
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
				<table width="100%" border="0" align="center" cellspacing="2" cellpadding="5">
					<tr height="20">
						<td  align="center" bgcolor="#E8E8E8"
							class="admin_title2" colspan="2">
							<strong>商品描述</strong>
						</td>
						<td  align="center" bgcolor="#E8E8E8"
							class="admin_title2">
							<strong>价格</strong>
						</td>
						<td  align="center" bgcolor="#E8E8E8"
							class="admin_title2">
							<strong>数量</strong>
						</td>
					</tr>
					<s:iterator value="dataList" id="data" status="status">
						<tr>
							<td  align="center">
							<s:if test="imagesPath != null && imagesPath.size > 0">
								<img alt="" src="${imagesPath[0] }" border="0" width="120" height="120" /> 
							</s:if>
							<s:else>
								<img alt="" src="images/imgb.gif" border="0" width="120" height="120" /> 
							</s:else>
							</td>
							<td align="center" width="40%">
								${data.comname }
							</td>
							<td  width="20%" align="center">
								<SPAN class="indexjg">￥${data.price}</SPAN>
								<BR>
								市场价 ￥${data.markPrice}
							</td>
							<td align="center" width="20%">
								-${data.amount }
							</td>
						</tr>
					</s:iterator>
					<tr>
						<td align="right" colspan="5">
							<a href="#" onclick="first()">首页</a>&nbsp;&nbsp;
							<a href="#" onclick="previous()">上一页</a>&nbsp;&nbsp;
							<a href="#" onclick="next()">下一页</a>&nbsp;&nbsp;
							<a href="#" onclick="last()">尾页</a>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td colspan="3"  width="795" height="20"  background="images/r_dow.gif">
			</td>
		</tr>
	</table>
</form>
