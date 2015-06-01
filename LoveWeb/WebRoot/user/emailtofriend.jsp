<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<div class="list_friends">
	<form name="frm" onsubmit="return sendemail()">
	<table>
        
        	<tr>
				<td>收件人：</td>
				<td>
					
					<select id="tousername">
							<option >--好友列表--</option>
						<c:forEach var="friend" items="${friend}">
							<option >${friend.username }</option>
						</c:forEach>
					</select>
				</td>					
        	</tr>
        	<tr>
				<td class="zhengwen">正　文：</td>
				<td>
					<textarea id="text" name="content" rows="18" cols="70"></textarea>
				</td>
			</tr>
			
			<tr>
               <td colspan="2" align="right"><input type="submit" name="send" value="发送" class="send"></td>
            </tr>
			
        
      </table>	
      </form>
      </div>
