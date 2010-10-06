<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<script type="text/javascript">
	function previous() {
		var currentPage = document.getElementById("pageBean.currentPage").value;
		if (parseInt(currentPage) != 1) {
			document.getElementById("pageBean.currentPage").value = parseInt(currentPage) - 1;
			help.action = "showcomsList.action";
			help.submit();
		}
	}
	function next() {
		var currentPage = document.getElementById("pageBean.currentPage").value;
		var totalPage = document.getElementById("pageBean.totalPage").value;
		if (parseInt(currentPage) != (totalPage)) {
			document.getElementById("pageBean.currentPage").value = parseInt(currentPage) + 1;
			help.action = "showcomsList.action";
			help.submit();
		}
	}
	function first() {
		var currentPage = document.getElementById("pageBean.currentPage").value;
		if (parseInt(currentPage) > 1) {
			document.getElementById("pageBean.currentPage").value = 1;
			help.action = "showcomsList.action";
			help.submit();
		}
	}
	function last() {
		var currentPage = document.getElementById("pageBean.currentPage").value;
		var totalPage = document.getElementById("pageBean.totalPage").value;
		if (parseInt(currentPage) < totalPage) {
			document.getElementById("pageBean.currentPage").value = parseInt(totalPage);
			help.action = "showcomsList.action";
			help.submit();
		}
	}
	function view(id) {
		help.id.value = id;
		help.action = "bingcurForward.action";
		help.submit();
	}
</script>

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
		<td width="775" valign="top" bgcolor="#FFFFFF">&nbsp;<img src="images/xbj.gif" width="123" height="28"></td>
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
		<td colspan="2" valign="top" bgcolor="#FFFFFF">
			<table width="775" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td>
						<form method="post" name="help" action="showcomsList.action">
							<s:hidden name="pageBean.currentPage" />
							<s:hidden name="pageBean.totalPage" />
							<input type="hidden" name="id">
							<table width="100%" border="0" align="center" cellpadding="10"
								cellspacing="0">
								<tr>
									<td height="30" colspan="2" align="center">
										<p class="indexjg">
											商品描述
										</p>
									</td>
									<td width="131" align="center">
										<p class="indexjg">
											价格
										</p>
									</td>
									<td width="108" align="center">
										<p class="indexjg">
											秀宝人
										</p>
									</td>
									<td width="117" align="center">
										<p class="indexjg">
											秀宝时间
										</p>
									</td>
								</tr>
								<s:iterator value="dataList" id="data" status="status">
									<tr>
										<td colspan="5" background="images/hr.gif" height="1">
										</td>
									</tr>
									<tr>
										<td width="130" height="130" align="center">
											<s:if test="imagesPath != null && imagesPath.size > 0">
												<img alt="" src="${imagesPath[0] }" border="0" width="120" height="120" /> 
											</s:if>
											<s:else>
												<img alt="" src="images/imgb.gif" border="0" width="120" height="120" /> 
											</s:else>
										</td>
										<td width="274">
											<strong><a href="viewShowcomsUsr.action?id=${data.id }"
												target="_blank">${data.tradename }</a>
											</strong>
											<br>

										</td>
										<td align="center">
											<p class="indexjg">
												￥${data.price }
											</p>
											市场价￥${data.mprice }
											<br>
											节省${data.js }%
										</td>
										<td align="center">
											${data.username }
										</td>
										<td align="center">
											${data.creattime }
										</td>
									</tr>
								</s:iterator>
								<tr>
									<td align="right" colspan="5">
										<a href="#" onclick="first();" >首页</a>&nbsp;&nbsp;
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
		<td colspan="4" height="20" align="center" background="images/r_dow.gif">
			&nbsp;
		</td>
	</tr>
</table>