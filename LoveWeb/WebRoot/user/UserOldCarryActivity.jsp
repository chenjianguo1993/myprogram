<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>用户曾经参加益校园活动</title>
	<link href="${pageContext.request.contextPath}/css/person-activity.css" rel="stylesheet" type="text/css">
	<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/My97DatePicker/WdatePicker.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.js" type="text/javascript"></script>
	<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/school.js"></script>
	
	
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
	<br>
    <div id="foreach" class="activity">
    	<div class="title">
			<div class="tt">
				<div class="title_left">
					<img src="${pageContext.request.contextPath }/images/activity1.png"/>
					<div class="title_content"><span>查看自己曾经参加活动</span></div>
				</div>
				<div class="title_right"><span><a href="#">更多</a></span></div>
			</div>
		</div>
       
        <c:forEach var="oldactivity" items="${page.list}">      	
        <div class="activity_content_left">
				<div class="activity_content_left_img"><img src="${pageContext.request.contextPath }/image/${oldactivity.image }"></div>
					<div class="activity_content_left_content">
						
						<div class="aclc_top">
							<div class="activity_title">
								<span>标题:

						    ${oldactivity.name }</span>
							</div>
							<div class="activity_title">
								<span id='${oldactivity.activityid }'>报名:

						    ${oldactivity.joinnum }</span>
							</div>
						<span>简介:

						    ${oldactivity.description }</span>
						</div>
						<div class="aclc_bottom"><span>报名截止:${oldactivity.joindate }</span></div>
					</div>
		</div>
                    
        <div class="activity_content_right">
               <div class="right_button" style="margin-top:120px;"><span><a href="${pageContext.request.contextPath }/servlet/DetailActivityServlet?activitid=${newactivity.activityid }">取消活动</a></span></div>
                  
         </div>
         </c:forEach>      
            <div id="page-s"><%@include file="/public/page.jsp" %>  </div>
    </div>
    	
    	
    	
    	<%@include file="/public/Login.jsp" %>
	  <%@include file="/public/Register.jsp" %>	
  </body>
</html>
