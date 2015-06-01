<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>曾经进行志愿者活动</title>

  </head>
  
  <body>
	<br>
    <div class="activity">
    	<div class="title">
			<div class="tt">
				<div class="title_left">
					<img src="${pageContext.request.contextPath }/images/activity1.png"/>
					<div class="title_content"><span>最新</span></div>
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
               <div class="right_button" style="margin-top:120px;"><span><a href="${pageContext.request.contextPath }/servlet/DetailVActivityServlet?activitid=${newactivity.activityid }">查看详细</a></span></div>
                  
         </div>
         </c:forEach>           
    </div>
    <%@include file="/public/page.jsp" %>
  </body>
</html>
