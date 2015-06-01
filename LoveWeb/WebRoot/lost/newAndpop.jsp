<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>失物招认领最新和最热门</title>
    
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
       
        <c:forEach var="newlost" items="${new2list}">      	
        <div class="activity_content_left">
				<div class="activity_content_left_img"><img src="${pageContext.request.contextPath }/image/${newlost.image }"></div>
					<div class="activity_content_left_content">
						
						<div class="aclc_top">
							<div class="activity_title">
								<span>标题:

						    ${newlost.lostname }</span>
							</div>
							<!--<div class="activity_title">
						  		<span id='${newactivity.activityid }'>报名:

						    ${newactivity.joinnum }</span>
							</div>-->
							
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
			<c:forEach var="poplost" items="${pop2list}">  
              <div class="activity_content_left">
						<div class="activity_content_left_img"><img src="${pageContext.request.contextPath }/image/${poplost.image }"></div>
							<div class="activity_content_left_content">
								<div class="aclc_top">
							<div class="activity_title">
								<span>标题:

						    ${poplost.lostname }</span>
							</div>
						<!--  	<div class="activity_title">
								<span id='${popactivity.activityid }'>报名:

						    ${popactivity.joinnum }</span>
							</div>-->
							
						<span>简介:

						    ${poplost.description }</span>
						</div>
								<div class="aclc_bottom"><span>发布时间:${poplost.reledate }</span>
								</div>
							</div>
				</div>
                    <div class="activity_content_right">
                    	 <div class="right_button" style="margin-top:120px;"><span><a href="${pageContext.request.contextPath }/servlet/DetailLostServlet?lostid=${poplost.lostid }">查看详细</a></span></div>
	                      <div class="right_button"  ><span ><a href="#" id='11${newactivity.activityid }' onclick="return joinact('${poplost.lostid }')">点击私信</a></span></div>
                    </div>
                </c:forEach>
       </div>
                	<!------------------>
  </body>
</html>
