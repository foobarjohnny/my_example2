<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String url= "http://"
			+ request.getLocalAddr() + ":" + request.getLocalPort()
			+ request.getContextPath()+"/";
	application.setAttribute("url",url);
%>
<base href="${url }">