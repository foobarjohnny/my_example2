<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<%@ include file="/resources/resources.jsp"%>
<script type="text/javascript">
	function pay(id) {
		user.id.value = id;
		user.action = "orderPay.action";
		user.submit();
	}
</script>
<form action="" method="post" name="user" >
<s:hidden name="id"/>
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
			订单详情
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
			<table width="100%" cellpadding="5" cellspacing="0">
	          <TR>
	            <TD width="14%" align="right">订单编号：</TD>
	            <TD colSpan="3">${ordernum }</TD>
	            <TD width="15%" align="right">确定时间：</TD>
	            <TD width="40%">${ordertime }</TD>
	          </TR>
	          <TR>
	            <TD align="right">支付方式：</TD>
	            <TD colSpan="3">
	            <s:if test="pay == \"1\"">
	            	支付宝
	            </s:if>
	            <s:if test="pay == \"2\"">
	            	财付通
	            </s:if>
	            </TD>
	            <TD align="right">订单总金额：</TD>
	            <TD>${totalPrices }</TD>
	          </TR>
	          <TR>
	            <TD align="right">收货人：</TD>
	            <TD colSpan="3">${receiver }</TD>
	            <TD align="right">收货人电话：</TD>
	            <TD>${telphone }</TD>
	          </TR>
	          <TR>
	            <TD align="right">收货人地址：</TD>
	            <TD colSpan="3">${address }</TD>
	            <TD align="right">备注：</TD>
	            <TD>${remard }</TD>
	          </TR>
	          <TR>
	            <TD align="right">商品编号：</TD>
	            <TD colSpan="3"></TD>
	            <TD align="right">商品名称：</TD>
	            <TD>${commodityName }</TD>
	          </TR>
	          <TR>
	            <TD align="right">商品价格：</TD>
	            <TD width="13%">
	            	<s:if test="ordertype == \"2\"">
	            		${comPrice }元 -
	            		
	            	</s:if>
	            	<s:else>
	            		${amount }元 +
	            	</s:else>
	            	<s:if test="ecount != null">
            			${ecount }
            		</s:if>
            		<s:else>
            			0
            		</s:else>
	            		枚收费E拍币
	            </TD>
	            <TD width="8%" align="right">运费：</TD>
	            <TD width="10%">${fare }</TD>
	            <TD align="right">应付</TD>
	            <TD>${totalPrices }</TD>
	          </TR>
	          <!--  
	          <s:if test="state == 1">
	          <TR>
	            <TD align="center" colspan="6">
	            	<a href="#" onclick="pay('${id}')"><img src="images/alipay.gif" border="0"></a>
	            </TD>
	          </TR>
	          </s:if>
	          -->
	        </table>
		</td>
	</tr>
	<tr>
		<td colspan="3">
			<img src="images/r_dow.gif" width="795" height="20">
		</td>
	</tr>
</table>
</form>