<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>管理员批审页面</title>
     <script language="javascript" type="text/javascript" src="../js/manager.js"></script>
  </head>
  
  <body>
		<table border="1">
			<tr >
				<td>社团名</td>
				<td>负责人</td>
				<td>密码</td>
				<td>申请理由</td>
				<td>邮箱</td>
				<td>电话</td>
				<td>日期</td>
				<td>操作</td>
			</tr>
	
			<c:forEach var="society" items="${page.list}">
				<tr >
				<td>${society.socname }</td>
				<td>${society.leadername }</td>
				<td>${society.password }</td>
				<td>${society.reason }</td>
				<td>${society.email }</td>
				<td>${society.phone }</td>
				<td>${society.date }</td>
				<td><a href="javascript:void(0)" onclick="agree('${society.userid }')">通过</a>&nbsp&nbsp<a href="javascript:void(0)" onclick="disagree('${society.userid }')">驳回</a></td>
				</tr>
	         </c:forEach>
		</table>
  </body>
</html>
