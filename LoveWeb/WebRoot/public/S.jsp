<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>搜索页面</title>
    <link href="../css/person-activity.css" rel="stylesheet" type="text/css">
	<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/My97DatePicker/WdatePicker.js"></script>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js" type="text/javascript"></script>
	<script language="javascript" type="text/javascript" src="../js/school.js"></script>
	
	
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
					<div class="title_content"><span>搜索记录如下</span></div>
				</div>
				<div class="title_right"><span><a href="#">更多</a></span></div>
			</div>
		</div>
       
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
            
         <!-- 这是志愿者搜索记录 -->
        <c:forEach var="activity" items="${vlist}">      	
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
             
             
     <!-- 这是失物招认领搜索记录 -->
       <c:forEach var="newlost" items="${llist}">      	
        <div class="activity_content_left">
				<div class="activity_content_left_img"><img src="${pageContext.request.contextPath }/image/${newlost.image }"></div>
					<div class="activity_content_left_content">
						
						<div class="aclc_top">
							<div class="activity_title">
								<span>标题:

						    ${newlost.lostname }</span>
							</div>
							
						<span>简介:

						    ${newlost.description }</span>
						</div>
						<div class="aclc_bottom"><span>发布时间:${newlost.reledate }</span></div>
					</div>
		</div>
                    
        <div class="activity_content_right">
               <div class="right_button" style="margin-top:120px;"><span><a href="${pageContext.request.contextPath }/servlet/DetailLostServlet?lostid=${newlost.lostid }">查看详细</a></span></div>
	                      <div class="right_button"  ><span ><a href="#" id='11${newactivity.activityid }' onclick="return joinact('${newactivity.activityid }')">点击私信</a></span></div>
         </div>
         </c:forEach>                
        
    
    
    <%@include file="/public/Login.jsp" %>
	  <%@include file="/public/Register.jsp" %>	

  </body>
</html>
