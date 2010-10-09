<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<%
	if(request.getSession() != null ){
		request.getSession().removeAttribute("manager_login");
		request.getSession().removeAttribute("MLogin");
	}
%>
<script>
	parent.window.location="./managerLogin.action";
</script>