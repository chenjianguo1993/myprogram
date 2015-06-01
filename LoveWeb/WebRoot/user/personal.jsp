<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>益校园--个人中心</title>
		<base href="<%=basePath%>">
		<link href="css/nav.css" rel="stylesheet" type="text/css">
		<link href="css/personal.css" rel="stylesheet" type="text/css">
		<script src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js" type="text/javascript"></script>
		<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/nav.js"></script>
		<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath }/js/user.js"></script>
		<style>
body {
	background-color: #F0EFED;
	text-align: left;
	font-family: 微软雅黑;
	line-height: 22px;
	color: #4c4c4c;
	margin: 0px;
	padding: 0px;
}
</style>
	</head>
	<body>
		<%@include file="/public/nav.jsp"%>
		<div id="container">
			<a name="top" id="top"></a>
			<div id="content">
				<div class="per_left">
					<div class="per_left_title"><span>个人信息</span></div>
					<div class="per_left_title" style="margin-top:105px;"><span>校园活动</span></div>
					<div class="per_left_title" style="margin-top:275px;"><span>志愿活动</span></div>
					<div class="per_left_title" style="margin-top:280px;"><span>失物认领</span></div>
				</div>
				<div class="per_right">
					<div class="per_right_content">
						<div class="per_right_content2">
							<div class="per_pic"><a href="${pageContext.request.contextPath}/servlet/FindInfoServlet"><img src="/LoveWeb/images/personal/personal1.png" /></a></div>
							<div class="per_pic"><a href="${pageContext.request.contextPath}/user/updateInfo.jsp"><img src="/LoveWeb/images/personal/personal4.png" /></a></div>
							<div class="per_pic"><img src="/LoveWeb/images/personal/personal2.png" /></div>
						</div>
						<div class="per_right_content1" style="margin-top:20px;">
							<div class="per_pic"><a href="${pageContext.request.contextPath}/servlet/UserActivityServlet?method=UserNowCarryAct"><img src="/LoveWeb/images/personal/personal7.png" /></a></div>
							<div class="per_pic"><a href="${pageContext.request.contextPath}/servlet/UserActivityServlet?method=UserOldCarryActivity" ><img src="/LoveWeb/images/personal/personal6.png" /></a></div>
							<div class="per_pic"><img src="/LoveWeb/images/personal/personal12.png" /></div>
							<div class="per_pic" style="margin-top:20px;"><img src="/LoveWeb/images/personal/personal13.png" /></div>
						</div>
						<div class="per_right_content1" style="margin-top:20px;">
							<div class="per_pic"><img src="/LoveWeb/images/personal/personal10.png" /></div>
							<div class="per_pic"><img src="/LoveWeb/images/personal/personal11.png" /></div>
							<div class="per_pic"><img src="/LoveWeb/images/personal/personal9.png" /></div>
							<div class="per_pic" style="margin-top:20px;"><img src="/LoveWeb/images/personal/personal8.png" /></div>
						</div>
						<div class="per_right_content2" style="margin-top:25px;">
							<div class="per_pic"><img src="/LoveWeb/images/personal/personal3.png" /></div>
							<div class="per_pic"><img src="/LoveWeb/images/personal/personal5.png" /></div>
						</div>
					</div>
				</div>
			</div>
			<div class="blank"></div>
		</div>
	<%@include file="/public/Login.jsp" %>
	<%@include file="/public/Register.jsp" %>
	</body>
</html>