<%@ page language="java" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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

				<span id="${email.emailid }">
				<c:choose>
						<c:when test="${fn:length(email.content)>100}">
							<c:out value="${fn:substring(email.content, 0, 100)}......" /><span><a href="javascript:void(0)"onclick="sixin_xiangxi_more('${email.emailid}','${email.content}')">详细</a> </span>
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