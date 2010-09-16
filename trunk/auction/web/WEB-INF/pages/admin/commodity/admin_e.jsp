<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<html>
	<head>
		<%@ include file="/resources/resources.jsp"%>
		<script type="text/javascript">
			function previous() {
				var currentPage = document.getElementById("pageBean.currentPage").value;
				if (parseInt(currentPage) != 1) {
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
			function insert() {
				form1.action = "ecurrForward.action";
				form1.submit();
			}
		</script>
	</head>
	<body>
		<div align="center" class="admin_title1">
			——E拍币管理——
		</div>
		<hr>
		<s:form action="ecurrSearch.action" name="form1">
			<s:hidden name="pageBean.currentPage" />
			<s:hidden name="pageBean.totalPage" />
			<table width="100%" border="1" cellpadding="10" cellspacing="0"
				bordercolor="#FFFFFF" bgcolor="#EEEEEE">
				<tr>
					<td colspan="7">
						<input type="button" name="Submit2" value="添加E币购买规则" onclick="insert()"/>
					</td>
				</tr>
				<tr>
					<td width="10%" align="center" valign="middle">
						<strong>描述</strong>
					</td>
					<td width="10%" align="center" valign="middle">
						<strong>充值</strong>
					</td>
					<td width="10%" align="center" valign="middle">
						<strong>赠送</strong>
					<td width="12%" align="center">
						<strong>操作</strong>
					</td>
				</tr>
				<s:iterator value="dataList" id="data" status="status">
					<tr>
						<td align="center" valign="middle">
							购买<s:property value="amount"/>E拍币数量
						</td>
						<td align="center" valign="middle">
							<s:property value="paymoney"/>元
						</td>
						<td align="center" valign="middle">
							免费<s:property value="freecount"/>E拍币
						</td>
						<td align="center">
							<a href="ecurrForward.action?id=<s:property value="id"/>&methodName=2">修改</a>｜
							<a href="ecurrDelete.action?id=<s:property value="id"/>&nettype=5">删除</a>
						</td>
					</tr>
				</s:iterator>
				<tr align="right">
					<td colspan="7">
						共<s:property value="pageBean.totalRec"/>条纪录，当前第<s:property value="pageBean.currentPage"/>/<s:property value="pageBean.totalPage"/>页，每页<s:property value="pageBean.pageRec"/>条纪录
						首页&nbsp;&nbsp;
						<a href="#" onclick="previous()">上一页</a>&nbsp;&nbsp;
						<a href="#" onclick="next()">下一页</a>&nbsp;&nbsp;
						尾页
					</td>
				</tr>
			</table>
		</s:form>
	</body>
</html>