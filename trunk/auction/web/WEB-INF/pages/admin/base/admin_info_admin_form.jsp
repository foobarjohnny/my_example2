<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<html>
	<head>
		<%@ include file="/resources/resources.jsp"%>
	</head>
	<body>
		<div align="center" class="admin_title1">
			——增加管理员——
		</div>
		<hr />
		<s:form action="managerSave.action" name="form1">
			<s:hidden name="id"/>
			<table width="100%" border="1" cellpadding="10" cellspacing="0"
				bordercolor="#FFFFFF" bgcolor="#EEEEEE">
				<tr>
					<td width="32%" align="right">
						管理员账号：
					</td>
					<td width="68%">
						<s:textfield name="account" size="30"/>
					</td>
				</tr>
				<tr>
					<td align="right">
						真实姓名：
					</td>
					<td>
						<s:textfield name="realname" size="30"/>
					</td>
				</tr>
				<tr>
					<td align="right">
						密码：
					</td>
					<td>
						<s:password name="password" size="30" />
					</td>
				</tr>
				<tr>
					<td align="right">
						密码确认：
					</td>
					<td>
						<input name="textfield22" type="password" size="30" />
					</td>
				</tr>
				<tr>
					<td align="right">
						联系电话：
					</td>
					<td>
						<s:textfield name="telphone" size="30"/>
					</td>
				</tr>
				<tr>
					<td align="right">
						管理权限：
					</td>
					<td>
						<input type="checkbox" name="managerFuns" value="1" id="managerFuns-1"
							<s:iterator id="d" value="values">
								<s:if test="#d == 1">
									checked
								</s:if>
							</s:iterator>
						/>
						<label for="managerFuns-1" class="checkboxLabel">商品管理</label>
						<input type="checkbox" name="managerFuns" value="2" id="managerFuns-2"
							<s:iterator id="d" value="values">
								<s:if test="#d == 2">
									checked
								</s:if>
							</s:iterator>
						/>
						<label for="managerFuns-2" class="checkboxLabel">订单管理</label>
						<input type="checkbox" name="managerFuns" value="3" id="managerFuns-3"
							<s:iterator id="d" value="values">
								<s:if test="#d == 3">
									checked
								</s:if>
							</s:iterator>
						/>
						<label for="managerFuns-3" class="checkboxLabel">用户管理</label>
						<input type="checkbox" name="managerFuns" value="4" id="managerFuns-4"
							<s:iterator id="d" value="values">
								<s:if test="#d == 4">
									checked
								</s:if>
							</s:iterator>
						/>
						<label for="managerFuns-4" class="checkboxLabel">机器人管理</label>
						<input type="checkbox" name="managerFuns" value="5" id="managerFuns-5"
							<s:iterator id="d" value="values">
								<s:if test="#d == 5">
									checked
								</s:if>
							</s:iterator>
						/>
						<label for="managerFuns-5" class="checkboxLabel">广告管理</label>

						
					</td>
				</tr>
				<tr align="right">
					<td colspan="2">
						<div align="center">
							<input type="submit" name="Submit" value=" 保存设置 " />
							&nbsp;&nbsp;
						</div>
					</td>
				</tr>
			</table>
		</s:form>
	</body>
</html>