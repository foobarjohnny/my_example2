<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<html>
	<head>
		<%@ include file="/resources/resources.jsp"%>
		<script language="javascript">
			$(document).ready(function(){
				//获取提交操作
				var obj = $("[name=Submit]");
				//开始验证前台的输入信息
				obj.click(function(){
					var networkName = $("[name=model.networkName]");
					var title       = $("[name=model.title]");
					var logo        = $("[name=model.logoFile]");
					var website     = $("[name=model.webSite]");
					var email       = $("[name=model.isEmail]");
					var phone       = $("[name=model.isPhone]");
					var reg         = $("[name=model.isReg]");
					var giveEcur    = $("[name=model.giveEcur]");
					var inviteEcur    = $("[model.inviteEcur]");
					var outName     = $("[name=model.outName]");
					var copyright   = $("[name=model.copyright]");
					var meta        = $("[name=model.metaKey]");
					var metaDesc    = $("[name=model.metaDes]");

					if(!networkName.val()){
						alert('"网站名称"不能为空！');
						networkName.focus();
						return false;
					}
					if(!title.val()){
						alert('"网站标题"不能为空！');
						title.focus();
						return false;
					}
					if(!logo.val()){
						alert('"网站Logo"不能为空');
						logo.focus();
						return false;
					}
					if(!website.val()){
						alert('"网站地址"不能为空');
						website.focus();
						return false;
					}
					if(!email.val()){
						alert('"邮件地址"不能为空');
						email.focus();
						return false;
					}
					if(!phone.val()){
						alert('""不能为空');
						phone.focus();
						return false;
					}
					if(!reg.val()){
						alert('"注册"不能为空');
						reg.focus();
						return false;
					}
					if(!giveEcur.val()){
						alert('"注册赠送E拍币"不能为空');
						giveEcur.focus();
						return false;
					}
					if(!outName.val()){
						alert('"注销不活动用户"不能为空');
						outName.focus();
						return false;
					}
					if(!copyright.val()){
						alert('"网站注册版权"不能为空');
						copyright.focus();
						return false;
					}
					if(!meta.val()){
						alert('"META关键字"不能为空');
						meta.focus();
						return fasle;
					}
					if(!metaDesc.val()){							
						alert('"META描述"不能为空');
						metaDesc.focus();
						return false;
					}
				});
			});
		</script>
	</head>
	<body>
		<div align="center" class="admin_title1">
			——网站基本信息设置——
		</div>
		<hr>
		<s:form action="saveWebsiteInfo.action" method="post" enctype="multipart/form-data" name="websiteInfo">
			<s:hidden name="model.id"/>
			<table width="100%" border="1" cellpadding="10" cellspacing="0"
				bordercolor="#FFFFFF" bgcolor="#EEEEEE">

				<tr>
					<td width="34%" align="right">
						网站名称：
					</td>
					<td width="66%">
						<s:textfield name="model.networkName" size="30"/>
					</td>
				</tr>
				<tr>
					<td align="right">
						网站标题：
					</td>
					<td>
						<s:textfield name="model.title" size="30"/>
					</td>
				</tr>
				<tr>
					<td align="right">
						网站LOGO：
					</td>
					<td>
						<s:file name="model.logoFile"/>  该图片在每次修改的时候， 都需要添加。
					</td>
				</tr>
				<tr>
					<td align="right">
						网站地址：
					</td>
					<td>
						<s:textfield name="model.webSite" size="30"/>
					</td>
				</tr>
				<tr>
					<td align="right">
						是否允许用户注册：
					</td>
					<td>
						<s:radio list="#{1:'是',0:'否'}" name="model.isEmail"/>
					</td>
				</tr>
				<tr>
					<td align="right">
						是否需要邮件认证：
					</td>
					<td>
						<s:radio list="#{1:'是',0:'否'}" name="model.isPhone"/>
					</td>
				</tr>
				<tr>
					<td align="right">
						是否需要手机认证：
					</td>
					<td>
						<s:radio list="#{1:'是',0:'否'}" name="model.isReg"/>
					</td>
				</tr>
				<tr>
					<td align="right">
						注册赠送E拍币数：
					</td>
					<td>
						<s:textfield name="model.giveEcur" size="10"/>
						枚
					</td>
				</tr>
				<tr>
					<td align="right">
						邀请者赠送E拍币数：
					</td>
					<td>
						<s:textfield name="model.inviteEcur" size="10"/>
						枚
					</td>
				</tr>
				<tr>
					<td align="right">
						注销不活动用户时间：
					</td>
					<td>
						<s:textfield name="model.outName" size="10"/>
						分钟
					</td>
				</tr>
				<tr>
					<td align="right">
						网站版权信息：
					</td>
					<td>
						<s:textarea name="model.copyright" rows="10" cols="50"/>
					</td>
				</tr>
				<tr>
					<td align="right">
						网站META关键字：
						<br>
						<font color="#FF0000">针对搜索引擎设置的网页关键词,多个关键词请用,号分隔</font>
					</td>
					<td>
						<s:textarea name="model.metaKey" rows="10" cols="50"/>
					</td>
				</tr>
				<tr>
					<td align="right">
						网站META描述：
						<br>
						<font color="#FF0000">针对搜索引擎设置的网页描述,多个描述请用,号分隔</font>
					</td>
					<td>
						<s:textarea name="model.metaDes" rows="10" cols="50"/>
					</td>
				</tr>
				<tr align="right">
					<td colspan="2">
						<div align="center">
							<input type="submit" name="Submit" value="保存设置 ">
						</div>
					</td>
				</tr>
			</table>
		</s:form>
	</body>
</html>