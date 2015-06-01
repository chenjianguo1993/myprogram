<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>当前用户</title>
    <script language="javascript" type="text/javascript" src="../js/manager.js"></script>
  </head>
  
  <body>
	<table border="1">
			<tr >
				<td>用户名</td>
				<td>密码</td>
				<td>邮箱</td>
				<td>电话</td>
				<td>申请日期</td>
				<td>操作</td>
			</tr>
	
			<c:forEach var="user" items="${page.list}">
				<tr >
				<td>${user.username }</td>
				<td>${user.password }</td>
				<td>${user.email }</td>
				<td>${user.phone }</td>
				<td>${user.date }</td>
				<td><a href="javascript:void(0)" onclick="sweep('${user.userid }')">清除</a>&nbsp&nbsp<a href="javascript:void(0)" onclick="toblack('${user.userid }')">拉黑</a></td>
				</tr>
	         </c:forEach>
		</table>
		  <%@include file="../public/page.jsp" %>
  </body>
</html>
