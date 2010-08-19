<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<html>
	<head>
		<%@ include file="/resources/resources.jsp"%>
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