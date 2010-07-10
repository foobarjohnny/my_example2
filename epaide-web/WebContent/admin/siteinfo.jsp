<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<s:form action="site/siteInfoAction_saveSiteInfo.action" method="post"
	enctype="multipart/form-data">
	<table width="100%" border="1" cellpadding="10" cellspacing="0"
		bordercolor="#FFFFFF" bgcolor="#EEEEEE">
		<s:hidden name="siteInfo.id"></s:hidden>
		<tr>
			<td width="34%" align="right">网站名称：</td>
			<td width="66%"><s:textfield name="siteInfo.name" /></td>
		</tr>
		<tr>
			<td align="right">网站标题：</td>
			<td><s:textfield name="siteInfo.title" /></td>
		</tr>
		<tr>
			<td align="right">网站LOGO：</td>
			<td><s:textfield name="siteInfo.logo"></s:textfield></td>
		</tr>
		<tr>
			<td align="right">网站地址：</td>
			<td><s:textfield name="siteInfo.url"></s:textfield></td>
		</tr>
		<tr>
			<td align="right">是否允许用户注册：</td>
			<td><s:checkbox name="siteInfo.allowedRegister"></s:checkbox></td>
		</tr>
		<tr>
			<td align="right">是否需要邮件认证：</td>
			<td><s:checkbox name="siteInfo.allowedMailNotified"></s:checkbox>
			</td>
		</tr>
		<tr>
			<td align="right">是否需要手机认证：</td>
			<td><s:checkbox name="siteInfo.allowedPhoneAuth"></s:checkbox></td>
		</tr>
		<tr>
			<td align="right">注册赠送E拍币数：</td>
			<td><s:textfield name="siteInfo.sendEpaibe"></s:textfield> 枚</td>
		</tr>
		<tr>
			<td align="right">注销不活动用户时间：</td>
			<td><s:textfield name="siteInfo.unactiveDuration"></s:textfield>分钟</td>
		</tr>
		<tr>
			<td align="right">网站版权信息：</td>
			<td><s:textarea name="siteInfo.copyright" cols="20"></s:textarea></td>
		</tr>
		<tr>
			<td align="right">网站META关键字：<br>
			<font color="#FF0000">针对搜索引擎设置的网页关键词,多个关键词请用,号分隔</font></td>
			<td><s:textarea name="siteInfo.metaKey" cols="20">
			</s:textarea></td>
		</tr>
		<tr>
			<td align="right">网站META描述：<br>
			<font color="#FF0000">针对搜索引擎设置的网页描述,多个描述请用,号分隔</font></td>
			<td><s:textarea name="metaDesc" cols="20"></s:textarea></td>
		</tr>
		<tr align="right">
			<td colspan="2">
			<div align="center"><input type="submit" name="Submit"
				value="保存设置 "></div>
			</td>
		</tr>
	</table>
</s:form>





</body>
</html>