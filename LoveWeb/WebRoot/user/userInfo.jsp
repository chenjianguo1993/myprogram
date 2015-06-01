<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>用户个人信息</title>
    <link href="${pageContext.request.contextPath}/css/nav.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" type="text/css" href="/LoveWeb/template/ue-content/templates/images/ue_grid.css" />
	<link rel="stylesheet" type="text/css" href="/LoveWeb/template/ue-content/templates/images/style.css" />
	<link rel="stylesheet" type="text/css" href="/LoveWeb/template/ue-content/templates/css/style.css" />
	<script src="${pageContext.request.contextPath}/js/jquery.js" type="text/javascript"></script>
	<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/login.js"></script>
	<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/logout.js"></script>
	<script language="javascript" type="text/javascript" src="/LoveWeb/js/nav.js"></script>
	<script language="javascript" src="/LoveWeb/script/jquery.easing.min.js"></script>
	<script language="javascript" src="/LoveWeb/script/custom.js"></script>
  </head>
  
  <body>
  
  	<%@include file="/public/nav.jsp" %>
  	
  	<br><br><br><br><br><br> 	<br><br><br>
 
		<table align="center" border="1">
			<tr>
				<td>头像</td>
				<td>用户名</td>
				<td>密码</td>
				<td>邮箱</td>
				<td>电话</td>
				<td>注册日期</td>
			</tr>
			<tr>
				<td><img src="/LoveWeb/${user.headimg}"/></td>
				<td>${user.username }</td>
				<td>${user.password }</td>
				<td>${user.email }</td>
				<td>${user.phone }</td>
				<td>${user.date }</td>
			</tr>
		</table>
		
		<%@include file="/public/Login.jsp" %>
	<%@include file="/public/Register.jsp" %>
  </body>
</html>
