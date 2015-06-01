<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>用户登陆页面</title>
    <script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/login.js"></script>
    <script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
  </head>
  
  <body>
  	<form action="" onsubmit="return show()" id="login">
  		 
	  	<table>
		  	<tr>
		  		<td>用户名</td>
				<td><input type="text" name="username" /></td>
			</tr>
		  	<tr>
		  		<td>密码</td>
				<td><input type="password" name="password" /></td>
			</tr>
		  	<tr>
		  		<td><input type="reset" name="reset"  value="重置" /></td>
				<td><input type="submit" name="submit" value="登陆" /></td>
			</tr>
		</table>
	</form>
  </body>
</html>
