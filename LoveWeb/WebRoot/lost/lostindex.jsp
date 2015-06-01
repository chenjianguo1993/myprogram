<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>失物招认领首页</title>
  
	
    <link href="../css/school1.css" rel="stylesheet" type="text/css">
	<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/My97DatePicker/WdatePicker.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.js" type="text/javascript"></script>
	<script language="javascript" type="text/javascript" src="../js/lost.js"></script>
	
	
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
			<a name="top" id="top"></a>
			<div id="content">
            	<div id="left">
                	<div class="left_button"><span><a href="#" onclick="return xunzao()">失物寻找</a></span></div>
                    <div class="left_button"><span><a href="#" onclick="return renling()">失物认领</a></span></div>
                    <div class="left_button"><span><a href="#" onclick="return addLostUI()">快速发布</a></span></div>
                </div>
                <div id="right">
                	<%@include file="/lost/newAndpop.jsp" %>
                
                
                </div>
             </div>
     </div>
      <%@include file="/public/Login.jsp" %>
	  <%@include file="/public/Register.jsp" %>	
  </body>
</html>
