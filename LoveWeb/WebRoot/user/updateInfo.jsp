<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>修改个人信息页面</title>
    <link href="${pageContext.request.contextPath}/css/nav.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" type="text/css" href="/LoveWeb/template/ue-content/templates/images/ue_grid.css" />
	<link rel="stylesheet" type="text/css" href="/LoveWeb/template/ue-content/templates/images/style.css" />
	<link rel="stylesheet" type="text/css" href="/LoveWeb/template/ue-content/templates/css/style.css" />
	<script src="${pageContext.request.contextPath}/js/jquery.js" type="text/javascript"></script>
	<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/login.js"></script>
	<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/user.js"></script>
	<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/logout.js"></script>
	<script language="javascript" type="text/javascript" src="/LoveWeb/js/nav.js"></script>
	<script language="javascript" src="/LoveWeb/script/jquery.easing.min.js"></script>
	<script language="javascript" src="/LoveWeb/script/custom.js"></script>

  </head>
  
  <body>
	<%@include file="/public/nav.jsp" %>
  	<br><br><br><br><br><br> 	<br>
  		<form method="post" onsubmit="return updateuser()" id="updateuser" >
 		<table>
 			<tr>
 				<td>用户名</td>
 				<td><input type="text" name="username" value="${user.username }"/></td>
 			</tr>
 			<tr>
 				<td>密码</td>
 				<td><input type="password" name="password" value="${user.password }"/></td>
 			</tr>
 			<tr>
 				<td>邮箱</td>
 				<td><input type="text" name="email" value="${user.email }" /></td>
 			</tr>
 			<tr>
 				<td>手机号码</td>
 				<td><input type="text" name="phone" value="${user.phone }" /></td>
 			</tr>
 			<tr>
 			 	<td><input type="reset" name="reset"  value="重置" /></td>
 				<td><input id="regsub" type="submit"  value="提交" ></input></td>
 			</tr>
 		</table>
 		</form>	
  	
  </body>
</html>
