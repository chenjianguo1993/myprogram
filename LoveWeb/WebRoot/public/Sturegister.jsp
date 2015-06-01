<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>个人注册页面</title>
    <script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/register.js"></script>
    <script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
  </head>
  
  <body>
  
  		<div class="right_content">
          <div class="title">
            <div class="tt">
              <div class="title_left">
                <img src="${pageContext.request.contextPath }/images/activity1.png"/>
                <div class="title_content"><span>个人注册</span></div>
              </div>
            </div>
          </div>
              <div class="reg_content">
                    <form method="post" onsubmit="return sturegister()" id="sturegister" >
                    <dd>
                    <span class="title">用户名</span>
                    <input type="text" name="username" />
                    </dd>
                    <dd>
                    <span class="title">密码</span>
                    <input type="password" name="password" />
                  </dd>
                  <dd>
                    <span class="title">确认密码</span>
                    <input type="password" name="password2" />
                  </dd>
                <dd>
                    <span class="title">邮箱</span>
                    <input type="text" name="email" />
                  </dd>
                  <dd>
                    <span class="title">手机号码</span>
                    <input type="text" name="phone" />
                  </dd>
                  <dd >
                    <span class="title">验证码</span>
                      <input type="text" name="imagefont" />
                                 
                  </dd>
                   <div id="reg-image">
                         <img id="image"  src="${pageContext.request.contextPath }/servlet/ImageFont"  onclick=" changeImage(this)" alt="换一张" style="cursor:hand" />
                       <a href="javascript:void(0)" onclick="changeImage2()"  >换一张</a>    
                  </div>
                    <dd>
                    <input id="regsub"  type="reset" name="reset"  value="取消" />
                    <input id="regsub" type="submit"  value="注册" ></input>
                  </dd>
                </form> 
              </div>
  
  </body>
</html>
