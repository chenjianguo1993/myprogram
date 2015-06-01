<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>搜索页面</title>
    <!-- 以下是导航条必备的还有下面的三个include -->
    <link href="../css/person-activity.css" rel="stylesheet" type="text/css">
     <link href="../css/school1.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/nav.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" type="text/css" href="/LoveWeb/template/ue-content/templates/images/ue_grid.css" />
	<link rel="stylesheet" type="text/css" href="/LoveWeb/template/ue-content/templates/images/style.css" />
	<link rel="stylesheet" type="text/css" href="/LoveWeb/template/ue-content/templates/css/style.css" />
	<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/nav.js"></script>

  	<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/login.js"></script>
	<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/logout.js"></script>
  	<script language="javascript" src="/LoveWeb/script/jquery.easing.min.js"></script>
	<script language="javascript" src="/LoveWeb/script/custom.js"></script>
	<script language="javascript" type="text/javascript" src="../js/volunteer.js"></script>

  </head>
  
  <body>
	<%@include file="/public/nav.jsp" %>
	
	<!-- 这是益校园搜索记录 -->
	 <c:forEach var="activity" items="${alist}">      	
        <div class="activity_content_left">
				<div class="activity_content_left_img"><img src="${pageContext.request.contextPath }/image/${activity.image }"></div>
					<div class="activity_content_left_content">
						
						<div class="aclc_top">
							<div class="activity_title">
								<span>标题:

						    ${activity.name }</span>
							</div>
							<div class="activity_title">
								<span id='${activity.activityid }'>报名:

						    ${activity.joinnum }</span>
							</div>
							
						<span>简介:

						    ${activity.description }</span>
						</div>
						<div class="aclc_bottom"><span>报名截止:${activity.joindate }</span></div>
					</div>
		</div>
                    
        <div class="activity_content_right">
               <div class="right_button" style="margin-top:120px;"><span><a href="${pageContext.request.contextPath }/servlet/DetailActivityServlet?activityid=${activity.activityid }">查看详细</a></span></div>
                      <c:choose>
                      	<c:when test="${activity.flag == 'true'}">
	                      <div class="right_button"  ><span ><a href="#" id='11${activity.activityid }' onclick="return joinact('${activity.activityid }')">取消报名</a></span></div>
	                      </c:when>
	                      <c:otherwise>
	                      <div class="right_button"  ><span ><a href="#" id='11${activity.activityid }' onclick="return joinact('${activity.activityid }')">点击报名</a></span></div>
         				</c:otherwise> 
         			</c:choose>
         </div>
         </c:forEach>           
	
	<!-- 这是志愿者活动搜索记录 -->
	<c:forEach var="vactivity" items="${vlist}">      	
        <div class="activity_content_left">
				<div class="activity_content_left_img"><img src="${pageContext.request.contextPath }/image/${vactivity.image }"></div>
					<div class="activity_content_left_content">
						
						<div class="aclc_top">
							<div class="activity_title">
								<span>标题:

						    ${vactivity.name }</span>
							</div>
							<div class="activity_title">
								<span id='${vactivity.activityid }'>报名:

						    ${vactivity.joinnum }</span>
							</div>
							
						<span>简介:

						    ${vactivity.description }</span>
						</div>
						<div class="aclc_bottom"><span>报名截止:${vactivity.joindate }</span></div>
					</div>
		</div>
                    
        <div class="activity_content_right">
               <div class="right_button" style="margin-top:120px;"><span><a href="${pageContext.request.contextPath }/servlet/DetailActivityServlet?activityid=${vactivity.activityid }">查看详细</a></span></div>
                      <c:choose>
                      	<c:when test="${newactivity.flag == 'true'}">
	                      <div class="right_button"  ><span ><a href="#" id='11${vactivity.activityid }' onclick="return joinact('${vactivity.activityid }')">取消报名</a></span></div>
	                      </c:when>
	                      <c:otherwise>
	                      <div class="right_button"  ><span ><a href="#" id='11${vactivity.activityid }' onclick="return joinact('${vactivity.activityid }')">点击报名</a></span></div>
         				</c:otherwise> 
         			</c:choose>
         </div>
         </c:forEach>           
	
	<!-- 这是失物招认领记录 -->
	<c:forEach var="lost" items="${llist}">      	
        <div class="activity_content_left">
				<div class="activity_content_left_img"><img src="${pageContext.request.contextPath }/image/${lost.image }"></div>
					<div class="activity_content_left_content">
						
						<div class="aclc_top">
							<div class="activity_title">
								<span>标题:

						    ${lost.lostname }</span>
							</div>
							
						<span>简介:

						    ${lost.description }</span>
						</div>
						<div class="aclc_bottom"><span>发布时间:${lost.reledate }</span></div>
					</div>
		</div>
                    
        <div class="activity_content_right">
               <div class="right_button" style="margin-top:120px;"><span><a href="${pageContext.request.contextPath }/servlet/DetailLostServlet?lostid=${lost.lostid }">查看详细</a></span></div>
	                      <div class="right_button"  ><span ><a href="#" id='11${lost.lostid }' onclick="return joinact('${lost.lostid }')">点击私信</a></span></div>
         </div>
         </c:forEach>           
	
	
  </body>
  
  <%@include file="/public/Login.jsp" %>
	<%@include file="/public/Register.jsp" %>	
</html>
