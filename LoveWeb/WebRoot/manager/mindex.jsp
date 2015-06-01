<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>后台管理首页</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/manager.css" />
    <script language="javascript" type="text/javascript" src="../js/nav.js"></script>
    <script language="javascript" type="text/javascript" src="../js/jquery.js"></script>
    <script language="javascript" type="text/javascript" src="../js/manager.js"></script>
    
    <!-- 以下是导航条必备的还有下面的三个include -->
	<link href="${pageContext.request.contextPath}/css/nav.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" type="text/css" href="/LoveWeb/template/ue-content/templates/images/ue_grid.css" />
	<link rel="stylesheet" type="text/css" href="/LoveWeb/template/ue-content/templates/images/style.css" />
	<link rel="stylesheet" type="text/css" href="/LoveWeb/template/ue-content/templates/css/style.css" />
	<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/nav.js"></script>

  	<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/login.js"></script>
	<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/logout.js"></script>
  	<script language="javascript" src="/LoveWeb/script/jquery.easing.min.js"></script>
	<script language="javascript" src="/LoveWeb/script/custom.js"></script>
  </head>
  
  <body>
		<%@include file="/public/nav.jsp" %>
		<div id="container">
			<div id="main">
				<div id="left">
				<a href="javascript:void(0)" onclick="findNotPass()">查看正在申请的社团</a><br><br>
				<a href="javascript:void(0)" onclick="findNowSoc()">查看当前的社团用户</a><br><br>
				<a href="javascript:void(0)" onclick="findNowStu()">查看当前的个人用户</a><br><br>
				</div>
				
				<div id="right">
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
				
				
				</div>
			</div>	
		</div>
		
		<%@include file="/public/Login.jsp" %>
	  <%@include file="/public/Register.jsp" %>	
  </body>
</html>
