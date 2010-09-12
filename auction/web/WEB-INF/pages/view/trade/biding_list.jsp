<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<script type="text/javascript">
	function previous() {
		var currentPage = document.getElementById("pageBean.currentPage").value;
		if (parseInt(currentPage) != 1) {
			document.getElementById("pageBean.currentPage").value = parseInt(currentPage) - 1;
			help.action = "bidingSearch.action";
			help.submit();
		}
	}
	function next() {
		var currentPage = document.getElementById("pageBean.currentPage").value;
		var totalPage = document.getElementById("pageBean.totalPage").value;
		if (parseInt(currentPage) != (totalPage)) {
			document.getElementById("pageBean.currentPage").value = parseInt(currentPage) + 1;
			help.action = "bidingSearch.action";
			help.submit();
		}
	}
	function first() {
		var currentPage = document.getElementById("pageBean.currentPage").value;
		if (parseInt(currentPage) >1) {
			document.getElementById("pageBean.currentPage").value = 1;
			help.action = "bidingSearch.action";
			help.submit();
		}
	}
	function last() {
		var currentPage = document.getElementById("pageBean.currentPage").value;
		var totalPage = document.getElementById("pageBean.totalPage").value;
		if (parseInt(currentPage) < totalPage) {
			document.getElementById("pageBean.currentPage").value = parseInt(totalPage);
			help.action = "bidingSearch.action";
			help.submit();
		}
	}
	function view(id) {
		help.id.value = id;
		help.action = "bidingSearch.action";
		help.submit();
	}
</script>

<table width="795" border="0" align="center" valign="top" cellpadding="0" cellspacing="0">
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
			&nbsp;&nbsp; 竞拍明细
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
			<table width="775" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td>
						<form method="post" name="help" action="bidingSearch.action">
							<s:hidden name="pageBean.currentPage" />
							<s:hidden name="pageBean.totalPage" />
							<input type="hidden" name="id" value="${id }">
							<table width="100%" border="0" align="center" cellpadding="10"
								cellspacing="0">
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
								<tr>
									<td align="right" colspan="2">
										<a href="#" onclick="first()">首页</a>&nbsp;&nbsp;
										<a href="#" onclick="previous()">上一页</a>&nbsp;&nbsp;
										<a href="#" onclick="next()">下一页</a>&nbsp;&nbsp;
										<a href="#" onclick="last()">尾页</a>
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
		<td colspan="4" height="20" align="center"
			background="images/r_dow.gif">
			&nbsp;
		</td>
	</tr>
</table>
