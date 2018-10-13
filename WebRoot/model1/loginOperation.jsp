<%@page import="cn.itcast.domain.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>Model1模式下使用javaBean</title>
</head>

<body>

	<%
		//1.得到请求参数
		//String username = request.getParameter("username");
		//String password = request.getParameter("password");

		//2.封装请求参数到javaBean
		//User user = new User();
		//user.setUsername(username);
		//user.setPassword(password);
	%>
	
	<jsp:useBean id="user" class="cn.itcast.domain.User"/>
	<jsp:setProperty property="*" name="user"/>
	<!-- <jsp:setProperty property="password" name="user"/> -->
	<%--
		user.setUsername(request.getPrameter("username"));
	 --%>
	 
	 <jsp:getProperty property="username" name="user"/>
	 <jsp:getProperty property="password" name="user"/>

</body>
</html>
