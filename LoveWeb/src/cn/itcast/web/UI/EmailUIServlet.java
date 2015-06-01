package cn.itcast.web.UI;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.Friend;
import cn.itcast.domain.User;
import cn.itcast.service.FriendService;
import cn.itcast.service.Impl.FriendServiceImpl;

public class EmailUIServlet extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		User user = (User)request.getSession().getAttribute("user");
		String userid2 = user.getUserid();
		FriendService service = new FriendServiceImpl();
		List<Friend> friend = service.findbyId2(userid2);
		request.setAttribute("friend", friend);
		request.getRequestDispatcher("/user/emailtofriend.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		doGet(request, response);
	}

}
