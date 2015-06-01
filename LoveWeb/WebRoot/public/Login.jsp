<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>用户登陆页面</title>
    <script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/login.js"></script>
  </head>
  
  <body>
  		<!--登录&注册-->
		<div class="clear"></div>
		<div class="loginmask"></div>
		<div id="loginalert">
		  <div class="pd20 loginpd">
		    <h3 style="margin:0px;"><i class="closealert fr"></i>
		      <div class="clear"></div>
		    </h3>
		    <div class="loginwrap">
		      <div class="loginh">
		        <div class="fl">会员登录</div>
		        <div class="fr">还没有账号<a id="sigup_now" href="http://www.jq-school.com/" onclick="return false;">立即注册</a></div>
		        <div class="clear"></div>
		      </div>
		      <h3><span>用户登录</span><span class="login_warning">用户名或密码错误</span>
		        <div class="clear"></div>
		      </h3>
		      <div class="clear"></div>
		      <form action="" method="post" onsubmit="return login()" id="login_form">
		        <div class="logininput">
		          <input type="text" name="username" class="loginusername" value="用户名" />
		          <input type="text" class="loginuserpasswordt" value="密码" />
		          <input type="password" name="password" class="loginuserpasswordp" style="display:none" />
		        </div>
		        <div class="loginbtn">
		          <div class="loginsubmit fl">
		            <input type="submit" value="登录" />
		            <div class="loginsubmiting">
		              <div class="loginsubmiting_inner"></div>
		            </div>
		          </div>
		          <div class="logcheckbox fl">
		            <input id="bcdl" type="checkbox" checked="true" />
		            保持登陆</div>
		          <div class="fr"><a href="http://www.jq-school.com/">忘记密码？</a></div>
		          <div class="clear"></div>
		        </div>
		      </form>
		    </div>
		  </div>
		  <div class="thirdlogin">
		    <div class="pd50">
		      <h4>用第三方帐号直接登录</h4>
		      <ul>
		        <li id="sinal"><a href="http://weibo.com/jqueryschool">微博账号登录</a></li>
		        <li id="qql"><a href="http://t.qq.com/jqueryschool">QQ账号登录</a></li>
		        <div class="clear"></div>
		      </ul>
		      <div class="clear"></div>
		    </div>
		  </div>
		</div>
  </body>
</html>
