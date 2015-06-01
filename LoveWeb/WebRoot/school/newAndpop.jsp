<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>正在进行的益校园活动</title>
    
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
       
        <c:forEach var="newactivity" items="${new2list}">      	
        <div class="activity_content_left">
				<div class="activity_content_left_img"><img style="width:170px;height:220px" src="${pageContext.request.contextPath }/image/${newactivity.image }"></div>
					<div class="activity_content_left_content">
						
						<div class="aclc_top">
							<div class="activity_title">
								<span>标题:

						    ${newactivity.name }</span>
							</div>
							<div class="activity_title">
								<span id='${newactivity.activityid }'>报名:

						    ${newactivity.joinnum }</span>
							</div>
							
						<span>简介:

						    ${newactivity.description }</span>
						</div>
						<div class="aclc_bottom"><span>报名截止:${newactivity.joindate }</span></div>
					</div>
		</div>
                    
        <div class="activity_content_right">
               <div class="right_button" style="margin-top:120px;"><span><a href="${pageContext.request.contextPath }/servlet/DetailActivityServlet?activityid=${newactivity.activityid }">查看详细</a></span></div>
                      <c:choose>
                      	<c:when test="${newactivity.flag == 'true'}">
	                      <div class="right_button"  ><span ><a href="#" id='11${newactivity.activityid }' onclick="return joinact('${newactivity.activityid }')">取消报名</a></span></div>
	                      </c:when>
	                      <c:otherwise>
	                      <div class="right_button"  ><span ><a href="#" id='11${newactivity.activityid }' onclick="return joinact('${newactivity.activityid }')">点击报名</a></span></div>
         				</c:otherwise> 
         			</c:choose>
         </div>
         </c:forEach>           
    </div>
   
    
    
     <!---------热门-------->
      <div class="activity" style="margin-top:20px;">
           <div class="title">
				<div class="tt">
						<div class="title_left">
							<img src="${pageContext.request.contextPath }/images/activity1.png"/>
							<div class="title_content"><span>热门</span></div>
						</div>
						<div class="title_right"><span><a href="#">更多</a></span></div>
				</div>
			</div>
			<c:forEach var="popactivity" items="${pop2list}">  
              <div class="activity_content_left">
						<div class="activity_content_left_img"><img style="width:170px;height:220px" src="${pageContext.request.contextPath }/image/${popactivity.image }"></div>
							<div class="activity_content_left_content">
								<div class="aclc_top">
							<div class="activity_title">
								<span>标题:

						    ${popactivity.name }</span>
							</div>
							<div class="activity_title">
								<span id='${popactivity.activityid }'>报名:

						    ${popactivity.joinnum }</span>
							</div>
							
						<span>简介:

						    ${popactivity.description }</span>
						</div>
								<div class="aclc_bottom"><span>报名截止:${popactivity.joindate }</span>
								</div>
							</div>
				</div>
                    <div class="activity_content_right">
                    	<div class="right_button" style="margin-top:120px;"><span><a href="${pageContext.request.contextPath }/servlet/DetailActivityServlet?activityid=${newactivity.activityid }">查看详细</a></span></div>
                    	<c:choose>
                      	<c:when test="${popactivity.flag == 'true'}">
	                      <div class="right_button"  ><span ><a href="#" id='11${popactivity.activityid }' onclick="return joinact('${popactivity.activityid }')">取消报名</a></span></div>
	                      </c:when>
	                      <c:otherwise>
	                      <div class="right_button"  ><span ><a href="#" id='11${popactivity.activityid }' onclick="return joinact('${popactivity.activityid }')">点击报名</a></span></div>
         				</c:otherwise> 
         			</c:choose>
                    </div>
                </c:forEach>
       </div>
                	<!------------------>
  </body>
</html>
