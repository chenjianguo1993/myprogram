<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<div id="nav">
			<div id="nav_container">
				<ul id="nav_ul">
					<li id="logo"><a href="#"></a></li>
					<li onmouseover="nav(1)" onmouseout="out()" onclick="change(1)"><a href="${pageContext.request.contextPath }/servlet/IndexUIServlet">首页</a></li>
					<li onmouseover="nav(2)" onmouseout="out()" onclick="change(2)"><a href="${pageContext.request.contextPath }/servlet/LostServlet">失物招领</a></li>
					<li onmouseover="nav(3)" onmouseout="out()" onclick="change(3)"><a href="${pageContext.request.contextPath }/servlet/ActivityServlet">益校园</a></li>
					<li onmouseover="nav(4)" onmouseout="out()" onclick="change(4)"><a href="${pageContext.request.contextPath }/servlet/VActivityServlet">志愿活动</a></li>
				</ul>
				<div id="search">
					<form action="${pageContext.request.contextPath }/servlet/SearchServlet" >
						<input type="text" class="search" placeholder="搜索" name="search">
						<div ><input class="button" type="submit" name="submit" value="" /> </div>
					</form>
				</div>
				<div id="register_login">
				
					<c:if test="${user!=null}">
	   					<img src="${pageContext.request.contextPath }/${user.headimg}"/>
						<div id="username"><span>${user.username }</span></div>
                       <ul>
                        	<li onMouseOver="login_xiala(0)" onMouseOut="login_out()" onClick="login_change(0)"><a href="${pageContext.request.contextPath }/user/personal.jsp"><img src="${pageContext.request.contextPath }/images/focus_peo.png">个人中心</a>
                            <li onMouseOver="login_xiala(1)" onMouseOut="login_out()" onClick="login_change(1)"><a href="${pageContext.request.contextPath }/servlet/EmailServlet?startNum=0" style="padding-right:30px;"><img src="${pageContext.request.contextPath }/images/infomation.png">私信</a>
                            <li onMouseOver="login_xiala(2)" onMouseOut="login_out()" onClick="login_change(2)"><a href="#" onclick="return logout()">注销</a>
                       </ul>
						
						
   					</c:if>
					<c:if test="${user==null}">
						<div class="openlogin"><a href="#" onclick="return false;">登录</a></div>
						<div class="reg"><a href="#">注册</a></div>
					</c:if>
				</div>
			</div>
		</div>