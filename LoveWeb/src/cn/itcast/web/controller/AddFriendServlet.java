package cn.itcast.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.Friend;
import cn.itcast.domain.User;
import cn.itcast.service.FriendService;
import cn.itcast.service.Impl.FriendServiceImpl;

public class AddFriendServlet extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String userid1 = request.getParameter("userid1");
		User user = (User) request.getSession().getAttribute("user");
		PrintWriter out = response.getWriter();
		if(user==null){
			out.write("unlogin");
			return;
		}
		Friend friend = new Friend();
		
		friend.setUserid1(userid1);
		friend.setUserid2(user.getUserid());
		FriendService service = new FriendServiceImpl();
		
		Friend f = service.findFriend(friend);
		if(f==null){
			service.addFriend(friend);
			out.write("true");
			return;
		}
		service.deleteFriend(friend);
		out.write("false");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		doGet(request, response);
	}

}
