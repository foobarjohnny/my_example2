<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>

<script type="text/javascript">
	function pay() {
		//alert(document.getElementById("ids").value);
		//return false;
		//help.id.value = document.getElementById("ids").value;
		help.action = "buyEcurr.action";
		help.submit();
	}
</script>
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
		<td width="775" valign="top" bgcolor="#FFFFFF">&nbsp;<img src="images/buyeb.gif" width="123" height="28"></td>
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
			<form action="" method="post" name="help">
				<table width="76%" border="0" align="center" cellpadding="10"
					cellspacing="0">
					<tr>
						<td width="35%" align="center" valign="top">
							<strong>价格</strong>
						</td>
						<td width="65%" align="center">
							<strong>数量</strong>
						</td>
					</tr>
					<s:iterator id="data" value="dataList" status="index">
						<tr>
							<td align="center" valign="top">
								<s:if test="#index.index==0">
								<input type="radio" name="id" value="${data.id }" id="ids" checked>
								</s:if>
								<s:else>
								<input type="radio" name="id" value="${data.id }" id="ids">
								</s:else>
								￥${data.paymoney }
							</td>
							<td align="center">
								${data.amount }E拍币 + 赠送${freecount }枚E拍币
							</td>
						</tr>
					</s:iterator>
					<tr>
						<td colspan="2" align="center">
							<img src="images/xzfk.gif" width="166" height="49"
								onclick="pay()">
						</td>
					</tr>
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
