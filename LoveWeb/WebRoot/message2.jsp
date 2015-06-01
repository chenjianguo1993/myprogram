<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>全局消息显示页面</title>
    <link href="css/nav.css" rel="stylesheet" type="text/css">
	<link href="css/index.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" type="text/css" href="/LoveWeb/template/ue-content/templates/images/ue_grid.css" />
	<link rel="stylesheet" type="text/css" href="/LoveWeb/template/ue-content/templates/images/style.css" />
	<link rel="stylesheet" type="text/css" href="/LoveWeb/template/ue-content/templates/css/style.css" />
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js" type="text/javascript"></script>
	<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/login.js"></script>
	<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/logout.js"></script>
	<script language="javascript" type="text/javascript" src="/LoveWeb/js/nav.js"></script>
	<script language="javascript" src="/LoveWeb/script/jquery.easing.min.js"></script>
	<script language="javascript" src="/LoveWeb/script/custom.js"></script>

  </head>
  
  <body>
  <%@include file="/public/nav.jsp" %>
  <br><br> <br><br> <br>
	${message }
	
	<%@include file="/public/Login.jsp" %>
	<%@include file="/public/Register.jsp" %>	
  </body>
  
</html>
