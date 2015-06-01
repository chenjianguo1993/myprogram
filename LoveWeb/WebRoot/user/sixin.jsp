<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>益校园--私信</title>
		<base href="<%=basePath%>">
		<link rel="stylesheet" type="text/css" href="/LoveWeb/template/ue-content/templates/images/ue_grid.css" />
		<link rel="stylesheet" type="text/css" href="/LoveWeb/template/ue-content/templates/images/style.css" />
		<link rel="stylesheet" type="text/css" href="/LoveWeb/template/ue-content/templates/css/style.css" />
		<link href="${pageContext.request.contextPath}/css/nav.css" rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath}/css/sixin.css" rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath}/css/emailtofriend.css" rel="stylesheet" type="text/css">
		<script src="${pageContext.request.contextPath}/js/jquery.js" type="text/javascript"></script>
		<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/login.js"></script>
		<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/logout.js"></script>
		<script language="javascript" src="/LoveWeb/script/jquery.easing.min.js"></script>
		<script language="javascript" src="/LoveWeb/script/custom.js"></script>

		<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
		<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/nav.js"></script>
		<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/sixin.js"></script>
		<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/school.js"></script>
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
				<div class="sixin_left">
					<div class="sixin_left_title"><span><a href="#" onclick="return getUnreadEmail()">未读私信</a></span></div>
					<div class="sixin_left_title"><span><a href="#" onclick="return getreadedEmail()">已读私信</a></span></div>
					<div class="sixin_left_title"><span><a href="#" onclick="return getsendedEmail()">已发私信</a></span></div>
					<div class="sixin_left_title"><span><a href="#" onclick="return email()">私信好友</a></span></div>
				</div>
				<div id="flag" flag="true"></div>
				<div class="sixin_right" id="sixin_right">
					<!-- 私信框 -->
					
<c:forEach var="email" items="${list}">
<div class="sixin_content">
	<div class="sixin_content_img">
		<div class="sixin_img">
			<c:choose>
				<c:when test="${type=='1'}" ><img src="${pageContext.request.contextPath}/images/unread.png" /></c:when>
				<c:when test="${type=='2'}" ><img src="${pageContext.request.contextPath}/images/read.png" /></c:when>
				<c:when test="${type=='3'}" ><img src="${pageContext.request.contextPath}/images/sended.png" /></c:when>
			</c:choose>
		</div>
	</div>
	<div class="sixin_content_content">
		<div class="sixin_content_top">
			<div class="sixin_content_top_left">
				<span>${email.username } 发来的私信</span>
			</div>
			<div class="sixin_content_top_right">
				<span><fmt:formatDate pattern="yyyy年MM月dd日"
						value="${email.sendtime }" />
				</span>
			</div>
		</div>
		<div class="sixin_content_main">
			<div class="sixin_span">

				<span id="${ email.emailid }"><span id="11${ email.emailid }">
				<c:choose>
						<c:when test="${fn:length(email.content)>100}">
							<c:out value="${fn:substring(email.content, 0, 85)}......" /></span><span><a href="javascript:void(0)"onclick="sixin_xiangxi_more('${email.emailid}','${email.content }')">详细</a> </span>
						</c:when>
						<c:otherwise>
							${email.content }&nbsp;&nbsp;
						</c:otherwise>
				</c:choose> 
				 </span>
			</div>
		</div>
		<div class="sixin_content_response">
			<input type="text" name="response" />
		</div>
		<input class="input" type="submit" value="回复" />
	</div>
</div>
</c:forEach>
					
					
					
					<!-- 底部 -->
					<%@include file="/public/Login.jsp" %>
				<%@include file="/public/Register.jsp" %>
				</div>
				<div class="blank" id="startNum" num="5" onclick="sixin_more()"></div>
			</div>
			
		</div>

	</body>
</html>