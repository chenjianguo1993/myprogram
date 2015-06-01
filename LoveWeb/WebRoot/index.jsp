<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<base href="<%=basePath%>">
		<title>益校网首页</title>
		<link href="css/nav.css" rel="stylesheet" type="text/css">
		<link href="css/index.css" rel="stylesheet" type="text/css">
		<link rel="stylesheet" type="text/css" href="/LoveWeb/template/ue-content/templates/images/ue_grid.css" />
		<link rel="stylesheet" type="text/css" href="/LoveWeb/template/ue-content/templates/images/style.css" />
		<link rel="stylesheet" type="text/css" href="/LoveWeb/template/ue-content/templates/css/style.css" />
		<script src="${pageContext.request.contextPath}/js/jquery.js" type="text/javascript"></script>
		<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/login.js"></script>
		<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/logout.js"></script>
		<script language="javascript" type="text/javascript" src="/LoveWeb/js/nav.js"></script>
		<script language="javascript" src="/LoveWeb/script/jquery.easing.min.js"></script>
		<script language="javascript" src="/LoveWeb/script/custom.js"></script>
	</head>
	<body>
		<%@include file="/public/nav.jsp" %>
		<div id="container">
			<a name="top" id="top"></a>
			<div id="content">
				<div id="title"></div>
				<div class="activity">
					<div class="title">
						<div class="tt">
							<div class="title_left">
								<img src="images/activity1.png"/>
								<div class="title_content"><span>益校园</span></div>
							</div>
							<div class="title_right"><span><a href="#">更多</a></span></div>
						</div>
					</div>
					<div class="activity_content">
						
						<div class="activity_content_left">
							<c:choose>
							<c:when test="${ new2alist[0]==null}">
								
									<div class="activity_content_left_img"><img src="${pageContext.request.contextPath}/images/guangpan.jpg"></div>
									<div class="activity_content_left_content">
										<div class="activity_title">
										<span>标题: 光盘行动</span>
										</div>
									<div class="aclc_top"><span>简　　介:<p></p>
	
										珍惜粮食,是我们每一个公民的义务,也是我们中华名族的优秀传统。珍惜粮食,是我们每一个公民的义务,也是我们中华名族的优秀传统。</span></div>
									<div class="aclc_bottom"><span>报名截止:2014年5月19日</span></div>
									</div>
								</c:when>
								<c:otherwise>
									<div class="activity_content_left_img"><img src="${pageContext.request.contextPath}/image/${new2alist[0].image}"></div>
									<div class="activity_content_left_content">
										<div class="activity_title">
										<span>标题: ${ new2alist[0].name }</span>
										</div>
										<div class="aclc_top">
										<span>简　　介:<p></p>
		
																${ new2alist[0].description }</span></div>
										<div class="aclc_bottom"><span>报名截止:${ new2alist[0].joindate }</span></div>
									</div>
								</c:otherwise>
							
							</c:choose>
						</div>
						
						<div class="activity_content_right">
						<c:choose>
							<c:when test="${ new2alist[1]==null}">
								
									<div class="activity_content_left_img"><img src="${pageContext.request.contextPath}/images/jisuanji.jpg"></div>
									<div class="activity_content_left_content">
									<div class="activity_title">
										<span>标题: 美艺节</span>
										</div>
									<div class="aclc_top"><span>简　　介:<p></p>
	
										珍惜粮食,是我们每一个公民的义务,也是我们中华名族的优秀传统。珍惜粮食,是我们每一个公民的义务,也是我们中华名族的优秀传统。</span></div>
									<div class="aclc_bottom"><span>报名截止:2014年5月19日</span></div>
									</div>
								</c:when>
								<c:otherwise>
									<div class="activity_content_left_img"><img src="${pageContext.request.contextPath}/image/${ new2alist[1].image}"></div>
									<div class="activity_content_left_content">
									<div class="activity_title">
										<span>标题: ${ new2alist[1].name }</span>
										</div>
										<div class="aclc_top"><span>简　　介:<p></p>
		
															${ new2alist[1].description }	</span></div>
										<div class="aclc_bottom"><span>报名截止:${ new2alist[1].joindate }</span></div>
									</div>
								</c:otherwise>
							
							</c:choose>
						</div>
					</div>
				</div>
				<div class="activity">
					<div class="title">
						<div class="tt">
							<div class="title_left">
								<img src="images/activity1.png"/>
								<div class="title_content"><span>失物招领</span></div>
							</div>
							<div class="title_right"><span><a href="#">更多</a></span></div>
						</div>
					</div>
					<div class="activity_content">
						<div class="activity_content_left">
							<c:choose>
							<c:when test="${ new2llist[0]==null}">
								
									<div class="activity_content_left_img"><img src="${pageContext.request.contextPath}/images/baobao.jpg"></div>
									<div class="activity_content_left_content">
									<div class="activity_title">
										<span>标题: 我书包不见</span>
										</div>
									<div class="aclc_top"><span>简　　介:<p></p>
	
										拾金不昧,是我们中华民族的优秀传统,我们作为当代大学生,需要继承和发扬这种优秀的品德的传统</span></div>
									<div class="aclc_bottom"><span>发布时间:2014年5月19日</span></div>
									</div>
								</c:when>
								<c:otherwise>
								<div class="activity_content_left_img"><img src="${pageContext.request.contextPath}/image/${ new2llist[0].image}"></div>
								<div class="activity_content_left_content">
								<div class="activity_title">
										<span>标题:${ new2llist[0].lostname}</span>
										</div>
									<div class="aclc_top"><span>简　　介:<p></p>
	
																${ new2llist[0].description}	</span></div>
									<div class="aclc_bottom"><span>发布时间:${ new2llist[0].reledate}</span></div>
								</div>
								</c:otherwise>
							
							</c:choose>
						</div>
						<div class="activity_content_right">
						<c:choose>
							<c:when test="${ new2llist[1]==null}">
									
										<div class="activity_content_left_img"><img src="${pageContext.request.contextPath}/images/shu.jpg"></div>
										<div class="activity_content_left_content">
										<div class="activity_title">
										<span>标题: 计算机教程不见</span>
										</div>
										<div class="aclc_top"><span>简　　介:<p></p>
		
											拾金不昧,是我们中华民族的优秀传统,我们作为当代大学生,需要继承和发扬这种优秀的品德的传统</span></div>
										<div class="aclc_bottom"><span>发布时间:2014年5月19日</span></div>
										</div>
							</c:when>
							<c:otherwise>
								<div class="activity_content_left_img"><img src="${pageContext.request.contextPath}/image/${ new2llist[1].image}"></div>
								<div class="activity_content_left_content">
								<div class="activity_title">
										<span>标题: ${ new2llist[1].lostname}</span>
										</div>
									<div class="aclc_top"><span>简　　介:<p></p>
	
													${ new2llist[1].description}		</span></div>
									<div class="aclc_bottom"><span>发布时间:${ new2llist[1].reledate}</span></div>
								</div>
							</c:otherwise>
						
						</c:choose>
						</div>
					</div>
				</div>
				<div class="activity">
					<div class="title">
						<div class="tt">
							<div class="title_left">
								<img src="images/activity1.png"/>
								<div class="title_content"><span>志愿活动</span></div>
							</div>
							<div class="title_right"><span><a href="#">更多</a></span></div>
						</div>
					</div>
					<div class="activity_content">
						<div class="activity_content_left">
							<c:choose>
								<c:when test="${ new2vlist[0]==null}">
									
										<div class="activity_content_left_img"><img src="${pageContext.request.contextPath}/images/zhishu.jpg"></div>
										<div class="activity_content_left_content">
										<div class="activity_title">
										<span>标题: 大学生支教</span>
										</div>
										<div class="aclc_top"><span>简　　介:<p></p>
		
											大家积极踊跃参与志愿者活动,在实践中锻炼自我,让我们的能力得到提高,从而更好的提高我们人生的价值</span></div>
										<div class="aclc_bottom"><span>报名截止:2014年5月19日</span></div>
										</div>
									
								</c:when>
								<c:otherwise>
									<div class="activity_content_left_img"><img src="image/${ new2vlist[0].image}"></div>
									<div class="activity_content_left_content">
									<div class="activity_title">
										<span>标题: ${ new2vlist[0].name}</span>
										</div>
										<div class="aclc_top"><span>简　　介:<p></p>
		
																${ new2vlist[0].description}	</span></div>
										<div class="aclc_bottom"><span>报名截止:${ new2vlist[0].joindate}</span></div>
									</div>
								</c:otherwise>
							
							</c:choose>
						</div>
						<div class="activity_content_right">
							<c:choose>
								<c:when test="${ new2vlist[1]==null}">
										
											<div class="activity_content_left_img"><img src="${pageContext.request.contextPath}/images/shibo.jpg"></div>
											<div class="activity_content_left_content">
											<div class="activity_title">
										<span>标题: 志愿者募集</span>
										</div>
											<div class="aclc_top"><span>简　　介:<p></p>
			
												大家积极踊跃参与志愿者活动,在实践中锻炼自我,让我们的能力得到提高,从而更好的提高我们人生的价值</span></div>
											<div class="aclc_bottom"><span>报名截止:2014年5月19日</span></div>
											</div>
										
								</c:when>
								<c:otherwise>
									<div class="activity_content_left_img"><img src="image/${ new2vlist[1].image}"></div>
									<div class="activity_content_left_content">
									<div class="activity_title">
										<span>标题:  ${ new2vlist[1].name}</span>
										</div>
										<div class="aclc_top"><span>简　　介:<p></p>
		
																${ new2vlist[1].description}		</span></div>
										<div class="aclc_bottom"><span>报名截止:${ new2vlist[1].joindate}</span></div>
									</div>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>
				
			<div class="blank"></div>
			<div id="footer">

       		<div id="footmenu">
					<ul>
						<li id="index"><a href="#">联系我们</a></li>
						
						<li><a href="2.html">服务协议</a></li>
						
						<li><a href="3.html">隐私权保护</a></li>
						
						<li><a href="http://map.baidu.com/">开放平台</a></li>
						
						<li><a href="#">版权所有</a></li>
						
					</ul>	
			</div>
            <div class="cyt">Copyright@2014-2018</div>
       		
       	</div>
		</div>
		<div class="blank"></div>
	</div>
	<%@include file="/public/Login.jsp" %>
	<%@include file="/public/Register.jsp" %>
		<script>
			$("#aaaa").click(function(){
				
				$("#reg_setp").show();
				alert("dafadf");
				$("#reg_setp").animate({left:0}, 500, "easeOutQuart");
			});
			
		</script>
	</body>
</html>