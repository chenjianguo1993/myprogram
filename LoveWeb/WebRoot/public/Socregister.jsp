<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    <title>社团用户注册页面</title>
    <script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/register.js"></script>
    <script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
  </head>
  
  <body>
  
  	<div class="right_content1">
          <div class="title">
            <div class="tt">
              <div class="title_left">
                <img src="${pageContext.request.contextPath }/images/activity1.png"/>
                <div class="title_content"><span>社团注册</span></div>
              </div>
            </div>
          </div>
              <div class="reg_content">
                    <form method="post" onsubmit="return show1()" id="socregister" >
                    <dd>
                    <span class="title">社团名</span>
                    <input type="text" name="socname" />${formbean.errors.username }
                    </dd>
                    <dd>
                    <span class="title">负责人</span>
                    <input type="text" name="leadername" />${formbean.errors.leadername }
                    </dd>
                    <dd>
                    <span class="title">密码</span>
                    <input type="password" name="password" />${formbean.errors.password }
                  </dd>
                  <dd>
                    <span class="title">确认密码</span>
                    <input type="password" name="password2" />${formbean.errors.password2 }
                  </dd>
                <dd>
                    <span class="title">邮箱</span>
                    <input type="text" name="email" />${formbean.errors.email }
                  </dd>
                  <dd>
                    <span class="title">手机号码</span>${formbean.errors.phone }
                    <input type="text" name="phone" />
                  </dd>
                  <dd>
                    <span class="title">申请理由</span>
                    <textarea rows="5" cols="50" name="reason" ></textarea>
                    </dd>
                  <dd>
                    <span class="title">验证码</span>
                      <input type="text" name="imagefont" />
                    </dd>
                    <div id="reg-image">
                      <img id="image"  src="${pageContext.request.contextPath }/servlet/ImageFont" onclick=" changeImage(this)" alt="换一张" style="cursor:hand" />
 					 <a href="javascript:void(0)" onclick="changeImage2()"  >换一张</a>${formbean.errors.imagefont }
                       </div>
                    <dd>
                    <input id="regsub"  type="reset" name="reset"  value="取消" />
                    <input id="regsub" type="submit"  value="注册" ></input>
                  </dd>
                   
                </form> 
              </div>
  
  
  
  
  
  	<!-- 
	<form method="post" onsubmit="return show1()" id="socregister" >
 		<table>
 			<tr>
 				<td>社团名</td>
 				<td><input type="text" name="socname" /></td>${formbean.errors.username }
 			</tr>
 			<tr>
 				<td>负责人</td>
 				<td><input type="text" name="leadername" /></td>${formbean.errors.leadername }
 			</tr>
 			<tr>
 				<td>密码</td>
 				<td><input type="password" name="password" /></td>${formbean.errors.password }
 			</tr>
 			<tr>
 				<td>确认密码</td>
 				<td><input type="password" name="password2" /></td>${formbean.errors.password2 }
 			</tr>
 			<tr>
 				<td>申请理由</td>
 				<td>
 					<textarea rows="5" cols="80" name="reason" ></textarea>
 				</td>
 			</tr>
 			<tr>
 				<td>邮箱</td>
 				<td><input type="text" name="email" /></td>${formbean.errors.email }
 			</tr>
 			<tr>
 				<td>手机号码</td>
 				<td><input type="text" name="phone" /></td>${formbean.errors.phone }
 			</tr>
 			<tr>
 				<td>验证码</td>
 				<td>
 					<input type="text" name="imagefont" />
 					<img id="image"  src="${pageContext.request.contextPath }/servlet/ImageFont" onclick=" changeImage(this)" alt="换一张" style="cursor:hand" />
 					 <a href="javascript:void(0)" onclick="changeImage2()"  >看不清,下一张</a>${formbean.errors.imagefont }
 				</td>${formbean.errors.imagefont }
 			</tr>
 			<tr>
 			 	<td><input type="reset" name="reset"  value="取消" /></td>
 				<td><input id="regsub" type="submit"  value="提交" ></input></td>
 			</tr>
 		</table>
 		</form>	 -->
  </body>
</html>
