<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  
  <body>
		
		<form action="${pageContext.request.contextPath}/model1/loginOperation.jsp" method="post">
			username:<input type="text" name="username"><br>
			password:<input type="password" name="password"><br>
			<input type="submit" value="登录">
		</form>

  </body>
</html>
