<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<html>
	<head>
		<%@ include file="/resources/resources.jsp"%>
		<script type="text/javascript">
	function previous() {
		var currentPage = document.getElementById("pageBean.currentPage").value;
		if (parseInt(currentPage) > 1) {
			document.getElementById("pageBean.currentPage").value = parseInt(currentPage) - 1;
			form1.submit();
		}
	}
	function next() {
		var currentPage = document.getElementById("pageBean.currentPage").value;
		var totalPage = document.getElementById("pageBean.totalPage").value;
		if (parseInt(currentPage) != (totalPage)) {
			document.getElementById("pageBean.currentPage").value = parseInt(currentPage) + 1;
			form1.submit();
		}
	}
</script>
	</head>
	<body>
	<s:form action="userAccount.action" name="form1">
			<s:hidden name="pageBean.currentPage" />
			<s:hidden name="pageBean.totalPage" />
			<div align="center" class="admin_title1">
				——查看E拍币——
			</div>
			<hr>
			<table width="100%" border="1" cellpadding="10" cellspacing="0"
				bordercolor="#FFFFFF" bgcolor="#EEEEEE">
				<tr>
					<td width="22%" align="right" valign="middle">
						付费E拍币：<s:property value="paycur"/>
					</td>
					<td width="78%">
						免费E拍币：<s:property value="freecur"/>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<table width="100%" border="1" cellpadding="10" cellspacing="0"
							bordercolor="#FFFFFF" bgcolor="#EEEEEE">
							<tr>
								<td width="31%" align="center" valign="middle">
									<strong>描述</strong>
								</td>
								<td width="18%" align="center">
									<strong>时间</strong>
								</td>
								<td width="12%" align="center">
									<strong>类型</strong>
								</td>
								<td width="14%" align="center">
									<strong>E拍币数</strong>
								</td>
								<td width="10%" align="center">
									<strong>操作</strong>
								</td>
							</tr>
							<s:iterator value="dataList" id="data" status="status">
								<tr>
									<td align="center" valign="middle">
										<s:property value="remark" />
									</td>
									<td align="center" valign="middle">
										<s:property value="buytime" />
									</td>
									<td align="center" valign="middle">
										<s:property value="buytype" />
									</td>
									<td align="center" valign="middle">
										<s:property value="amount" />
									</td>
									<td align="center">
										<a href="consumeDelete.action?id=<s:property value="id"/>&nettype=5">删除</a>
									</td>
								</tr>
							</s:iterator>
							<tr align="right">
								<td colspan="7">
									共
									<s:property value="pageBean.totalRec" />
									条纪录，当前第
									<s:property value="pageBean.currentPage" />
									/
									<s:property value="pageBean.totalPage" />
									页，每页
									<s:property value="pageBean.pageRec" />
									条纪录 首页&nbsp;&nbsp;
									<a href="#" onclick="previous();">上一页</a>&nbsp;&nbsp;
									<a href="#" onclick="next();">下一页</a>&nbsp;&nbsp; 尾页
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</s:form>
	</body>
</html>