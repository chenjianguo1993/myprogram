<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>发布志愿者活动</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
	<link href="${pageContext.request.contextPath}/css/start.css" rel="stylesheet" type="text/css">
    <script language="text/javascript" src="${pageContext.request.contextPath}/js/jquery.form.js"></script>
    <script language="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.4.min.js"></script>
  </head>
  
  <body>
		<div id="content1">
               
                	<div class="start">发起公益活动</div>
                  <div id="list">
                  		<form id="addAct" method="post" onsubmit="return addVActivity()" enctype="multipart/form-data">
                    	<table style="margin-left:20px;">
                            	<tr>
									<td>活动名称：</td>
									<td>
										<input type="text" name="name" />
									</td>	
								</tr>
                                <tr>
									<td>标题图片：</td>
									<td>
										<input type="file" name="file" size=60 />
									</td>	
								</tr>
								<tr>
									<td>宣传视频：</td>
									<td>
										<input type="file" name="video" size=60 />
									</td>	
								</tr>
                                <tr>
                                	<td>活动时间：</td>
                                    <td>
		   								<input id="startdate" type="text" name="startdate" onClick="WdatePicker()"/>至<br/>
	    	  							<input id="enddate" type="text" name="enddate" onClick="WdatePicker()"/>
	    	  						</td>
                                    
                                </tr>
                                <tr>
									<td>活动地点：</td>
									<td>
	   									<input type="text" name="address" size="60" />
	   								</td>
								</tr>
                            
                                <tr>
                                	<td>报名截止：</td>
                                    <td>
		   		
	    								<input id="joindate" name="joindate" type="text" onClick="WdatePicker()"/>
	   								</td>
                                  </tr>
                                  <tr>
                                  	<td class="left">发起人：</td>
									<td>${user.username }</td>
                                  </tr>
                                  <tr>
                                  	<td><div class="jieshao">活动介绍：</div></td>
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
