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
    <title>个体注册页面</title>
    <script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/register.js"></script>
    <script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
  </head>
  
  <body>
  		<form method="post" onsubmit="return show()" id="sturegister" >
 		<table>
 			<tr>
 				<td>用户名</td>
 				<td><input type="text" name="username" /></td>${formbean.errors.username }
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
 			 	<td><input type="reset" name="reset"  value="重置" /></td>
 				<td><input id="regsub" type="submit"  value="提交" ></input></td>
 			</tr>
 		</table>
 		</form>	
  </body>
</html>
