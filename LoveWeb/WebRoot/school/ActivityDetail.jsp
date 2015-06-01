<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns:wb=“http://open.weibo.com/wb”>
	<head>
		<title>益校园-详细活动</title>
		<script src="http://tjs.sjs.sinajs.cn/open/api/js/wb.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/nav.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/school.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/ActivityDetail.js"></script>
		<link href="css/index.css" rel="stylesheet" type="text/css">
		<link rel="stylesheet" type="text/css" href="/LoveWeb/template/ue-content/templates/images/ue_grid.css" />
		<link rel="stylesheet" type="text/css" href="/LoveWeb/template/ue-content/templates/images/style.css" />
		<link rel="stylesheet" type="text/css" href="/LoveWeb/template/ue-content/templates/css/style.css" />
		<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/login.js"></script>
		<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/logout.js"></script>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/detail.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/nav.css">
		<script language="javascript" src="/LoveWeb/script/jquery.easing.min.js"></script>
		<script language="javascript" src="/LoveWeb/script/custom.js"></script>
		<style type="text/css">
body {
	background-color: #F0EFED;
	text-align: left;
	font-family: 微软雅黑;
	line-height: 22px;
	color: #4c4c4c;
	margin: 0px;
	padding: 0px;
	
}
#aaa{
	float:right;
	background:#ffffb0;
}
</style>
	</head>

	<body>
		<%@include file="/public/nav.jsp"%>
		<div id="container">
			<div id="content">
				<div id="left">
                	<div class="left_button"><span><a href="#">关注排行榜</a></span></div>
                    <div class="list">
                        <div class="list_title">
                        	<div class="list_top"><span>校园LOL大赛</span></div>
                        	<div class="list_button"><span>28个人关注　　50个评论</span></div>
                        </div>
                         <div class="list_title">
                        	<div class="list_top"><span>捐衣服活动</span></div>
                        	<div class="list_button"><span>25个人关注　　24个评论</span></div>
                        </div>
                         <div class="list_title">
                        	<div class="list_top"><span>计算机服务日</span></div>
                        	<div class="list_button"><span>18个人关注　　14个评论</span></div>
                        </div>
                         <div class="list_title">
                        	<div class="list_top"><span>光盘行动</span></div>
                        	<div class="list_button"><span>15个人关注　　34个评论</span></div>
                        </div>
                	</div>
                </div>
                <div id="right">
                	<div id="video_box">
                    	<div class="title">
                            <div class="tt">
                                <div class="title_left">
                                    <div class="title_content"><span>${actuser.name }</span></div>
                                </div>
                            </div>
                        </div>
                        <div class="introduce">
	                        <div class="name" id="friend">&nbsp;&nbsp;<span>发起人：${actuser.username }&nbsp;&nbsp;</span>
	                        	<c:choose>
	                        		<c:when test="${flag==null}">
	                     	 		 <div class="addfriend" onclick="add_change('${actuser.userid}')">添加好友</div><div id="aaa" ></div>
	                        		</c:when>
	                        		<c:when test="${flag eq 'true'}">
	                        		
	                     	   		<div class="addfriend" onclick="add_change('${actuser.userid}')">删除好友</div><div id="aaa" ></div>
	                        		</c:when>
	                        		<c:when test="${flag eq 'false'}">
	                        		
	                     	   		<div class="addfriend" onclick="add_change('${actuser.userid}')">添加好友</div><div id="aaa" ></div>
	                        		</c:when>
	                        	</c:choose>
	                        </div>
	                        <div class="time">活动时间：${actuser.startdate }至${actuser.enddate }</div>
	                    </div>
	                    <div class="video">
	                    <%@include file="/public/video.jsp" %>
	                    </div>
	                    <div class="introduce_word">
	                    	${actuser.description }
	                    </div>
	                    <div class="count"><span id="${actuser.activityid }" onclick="return joinactivity('${actuser.activityid}')">报名(${actuser.joinnum })&nbsp;&nbsp;</span>
	                    <div class="sina"><wb:share-button addition="simple" type="button" picture_search="false"></wb:share-button></div>
	                    <div class="qq">
	                    <script type="text/javascript">
									(function(){
									var p = {
									url:'http://192.168.22.1:8080/LoveWeb/index.jsp',
									showcount:'1',/*是否显示分享总数,显示：'1'，不显示：'0' */
									desc:'',/*默认分享理由(可选)*/
									summary:'${actuser.description }',/*分享摘要(可选)*/
									title:'${actuser.name }',/*分享标题(可选)*/
									site:'1111111111111111111',/*分享来源 如：腾讯网(可选)*/
									pics: '${pageContext.request.contextPath}/video/${actuser.video }', /*分享图片的路径(可选)*/
									style:'202',
									width:30,
									height:20
									};
									var s = [];
									for(var i in p){
									s.push(i + '=' + encodeURIComponent(p[i]||''));
									}
									document.write(['<a version="1.0" class="qzOpenerDiv" href="http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?',s.join('&'),'" target="_blank">分享</a>'].join(''));
									})();
									</script>
								<script src="http://qzonestyle.gtimg.cn/qzone/app/qzlike/qzopensl.js#jsdate=20111201" charset="utf-8"></script>
	                    </div>
	                    </div>
                    </div>
                    <div class="huifu">回复</div>
                    <div class="huifu">分享</div>
                    <div id="com">
                    <c:forEach var="comment"  items="${ComList }">
                    <div class="commit">
                    	<div class="c1">
			            	<div class="minimg"><img src="${pageContext.request.contextPath }/${comment.headimg}" style="width:22px;height:22px;" /></div>
			                <div class="commit1">
			                	<div class="shang"><div class="xia_left">${comment.username }</div><div class="response_time"><fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${comment.commentdate }"/></div></div>
			                    <div class="zhong">${comment.commentContext }</div>
			                    <div class="xia">
			                        <div  class="xia_right">赞(<span style="color:#f7998d">32</span>)&nbsp;&nbsp;<a href="#" class="rp">回复&nbsp;&nbsp;</a></div>
			                    </div>
			                </div>
			            </div>
                    </div>
                    </c:forEach>
                   
                    </div>
                    
                    <div class="fabiao">发表回复</div>
			        <div id="commitbox">
			            <form method="post" onsubmit="return response('${actuser.activityid}')">
			                <textarea id="text" name="content"></textarea>
			                <input class="reply" type="submit" value="发表" />
			            </form>
			        </div>
                </div>
				
			</div>
		</div>
		<div id="logout" style="display:none;position: absolute;left:-200px;top:-100px;background:red;">注销成功</div>
		<%@include file="/public/Login.jsp" %>
		<%@include file="/public/Register.jsp" %>
	</body>
</html>
