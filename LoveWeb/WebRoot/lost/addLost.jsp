<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>发布失物招认领页面</title>
    <script src="../js/jquery-1.7.2.min.js"></script>
	<link href="../css/start.css" rel="stylesheet" type="text/css">
    <script language="text/javascript" src="${pageContext.request.contextPath}/js/jquery.form.js"></script>
    <script language="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.4.min.js"></script>
  </head>
  
  <body>
		<div id="content1">
        	
                	<div class="start">发起失物招认领</div>
                  <div id="list">
                  		<form id="addAct" method="post" onsubmit="return addLost()" enctype="multipart/form-data">
                    	<table style="margin-left:20px;">
                    			<tr>
						   			<td>类型</td>
						   			<td>
						   				<select  id="losttype" name="losttype">
						    				<option value="xunzao">失物寻找</option>
						    				<option value="renling">失物认领</option>      				
						    			</select>
						    	
						   			</td>
	   	
	   							<tr>
                            	<tr>
									<td>物品名称：</td>
									<td>
										<input type="text" name="lostname" />
									</td>	
								</tr>
                                <tr>
									<td>标题图片：</td>
									<td>
										<input type="file" name="image" size=60 />
									</td>	
								</tr>
                                <tr>
						   			<td>发布时间</td>
						   			
							   			<td>
							   				<input id="reledate" type="text" name="reledate" onClick="WdatePicker()"/>
						    	  		</td>	
	   							</tr>
                                  <tr>
                                  	<td class="left">发起人：</td>
									<td>${user.username }</td>
                                  </tr>
                                  <tr>
                                  	<td><div class="jieshao">物品描述：</div></td>
                                  	<td>
	   									<textarea rows="20" cols="80" name="description" class="text"></textarea>
	   								</td>
                                  </tr>
                                  <tr>
	                                  <td colspan="2" align="center">
		   								<input type="submit" value="发布" class="submit" />
		   							  </td>
                                  </tr>
                        </table>
                        </form>
                    </div>
                
        </div>	
  </body>
</html>
