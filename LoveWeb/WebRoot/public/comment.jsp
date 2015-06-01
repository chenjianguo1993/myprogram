<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="commit">
	<div class="c1">
		<div class="minimg">
			<img src="${pageContext.request.contextPath }/${comment.headimg}"
				style="width: 22px; height: 22px;" />
		</div>
		<div class="commit1">
			<div class="shang">
				<div class="xia_left">
					${comment.username }
				</div>
				<div class="response_time">
					<span><fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${comment.commentdate }"/></span>
				</div>
			</div>
			<div class="zhong">
				${comment.commentContext }
			</div>
			<div class="xia">
				<div class="xia_right">
					赞(
					<span style="color: #f7998d">32</span>)&nbsp;&nbsp;
					<a href="#" class="rp">回复&nbsp;&nbsp;</a>
				</div>
			</div>
		</div>
	</div>
</div>