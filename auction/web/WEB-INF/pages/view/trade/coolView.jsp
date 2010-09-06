<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<html>
	<head>
		<%@ include file="/resources/resources.jsp"%>
		<script type="text/javascript" src="js/dwr/userRomet.js"></script>
		<script type="text/javascript" src="js/dwr/auctionRomet.js"></script>
		<script type="text/javascript" src="js/dwr/publisRomet.js"></script>
		<script type="text/javascript">
		function previous() {
			var currentPage = document.getElementById("pageBean.currentPage").value;
			var totalPage = document.getElementById("pageBean.totalPage").value;
			if (parseInt(currentPage) != 1 && parseInt(totalPage) > 0) {
				document.getElementById("pageBean.currentPage").value = parseInt(currentPage) - 1;
				help.action = "coolSearch.action";
				help.submit();
			}
		}
		function next() {
			var currentPage = document.getElementById("pageBean.currentPage").value;
			var totalPage = document.getElementById("pageBean.totalPage").value;
			if (parseInt(currentPage) != (totalPage) && parseInt(totalPage) > 0) {
				document.getElementById("pageBean.currentPage").value = parseInt(currentPage) + 1;
				help.action = "coolSearch.action";
				help.submit();
			}
		}
		function first() {
			var currentPage = document.getElementById("pageBean.currentPage").value;
			if (parseInt(currentPage) >1) {
				document.getElementById("pageBean.currentPage").value = 1;
				help.action = "coolSearch.action";
				help.submit();
			}
		}
		function last() {
			var currentPage = document.getElementById("pageBean.currentPage").value;
			var totalPage = document.getElementById("pageBean.totalPage").value;
			if (parseInt(currentPage) < totalPage) {
				document.getElementById("pageBean.currentPage").value = parseInt(totalPage);
				help.action = "coolSearch.action";
				help.submit();
			}
		}
		function view(id) {
			help.id.value = id;
			help.action = "coolSearch.action";
			help.submit();
		}
		function vote(id) {
			publisRomet.vote(id, callBackHandler);
		}
		function callBackHandler(data) {
			if (data != "error") {
				var s = data.split(",");
				document.all["d" + s[0]].innerHTML = s[1];			
			}
		}
		</script>
	</head>
	<body leftmargin="0" topmargin="0"
		style="filter: progid :   DXImageTransform.Microsoft.Gradient (   startColorStr =   '#6daf2f', endColorStr =   '#ffffff', gradientType =   '0' )">
		<table width="795" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td colspan="3">
					<img src="images/r_top.gif" width="795" height="20">
				</td>
			</tr>
			<tr>
				<td width="10" rowspan="3" background="images/r_left.gif">
					<img src="images/r_left.gif" width="10" height="1">
				</td>
				<td width="775" height="40" align="center" bgcolor="#FFFFFF"
					class="admin_title1">
					酷品投票
				</td>
				<td width="10" rowspan="3" background="images/r_right.gif">
					<img src="images/r_right.gif" width="10" height="1">
				</td>
			</tr>
			<tr>
				<td valign="top" background="images/hr.gif">
					<img src="images/hr.gif" width="1" height="1">
				</td>
			</tr>
			<tr>
				<td valign="top" bgcolor="#FFFFFF">
					<table width="100%" border="0" cellpadding="0" cellspacing="0">
					  <tr>
			            <td width="48%" height="454" valign="top"><table width="362" border="0" cellspacing="0">
			              <tr>
			                <td width="360" align="center" valign="top"><img height="360" width="360" border="0" src="showImage.action?id=${data.id }&type=TS_PUBLIS"></td>
			              </tr>
			              <tr>
			                <td><table width="360" height="90" border="0" cellpadding="0" cellspacing="0">
			                  <tr>
			                    <td width="90" height="90" align="center" valign="middle" background="images/imgb.gif"></td>
			                    <td width="90" align="center" valign="middle" background="images/imgb.gif"></td>
			                    <td width="90" align="center" valign="middle" background="images/imgb.gif">&nbsp;</td>
			                    <td width="90" align="center" valign="middle" background="images/imgb.gif">&nbsp;</td>
			                  </tr>
			                </table></td>
			              </tr>
			            </table></td>
			            <td width="52%" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="5">
			               <tr>
			                <td>&nbsp;</td>
			                <td width="40%">&nbsp;</td>
			              </tr>
			             <tr>
			                <td width="60%">市场价：</td>
			                <td width="40%">￥${price }</td>
			              </tr>
			              <tr>
			                <td>酷品投票：</td>
			                <td width="40%">
			                	<div id="d${id }">
				              		${amount }
				              	</div>
			                </td>
			              </tr>
			              <tr>
			                <td>&nbsp;</td>
			                <td width="40%">&nbsp;</td>
			              </tr>
			              <tr>
			                <td height="91" colspan="2" align="center"><br><br>
			                  <div class="jptime">即将上线</div><br><br></td>
			                </tr>
			              <tr>
			                <td colspan="2" align="center"><input type="button" name="Submit2" value="酷一下" onclick="vote('${id }')"></td>
			                </tr>
			
			              
			            </table>
			              </td>
					    </tr>
			          <tr>
			            <td height="30" colspan="2">&nbsp;<img src="images/title_l.gif" width="3" height="12">&nbsp;<span class="admin_title1">商品描述</span></td>
			            </tr>
			          <tr>
			            <td height="1" colspan="2" align="center" background="images/hr.gif"><img src="images/hr.gif" width="1" height="1"></td>
			          </tr>
			          <tr>
			            <td height="31" colspan="2">
			            	${remark }
			            	<br>
			            	<p><font color="#FF0000">声明： 由于本栏目是为广大网友提供的物品拍卖平台，本栏目下所有物品均为网友自有物件，请在了解商品状况下谨慎竞拍，易拍得网不对本栏目下的商品做原装正品和质量保证，敬请大家谅解！</font></p>
			            </td>
			          </tr>
			        </table>
				</td>
			</tr>
			<tr>
				<td colspan="3">
					<img src="images/r_dow.gif" width="795" height="20">
				</td>
			</tr>
		</table>
	</body>
</html>