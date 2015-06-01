package cn.itcast.web.lostservlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.Friend;
import cn.itcast.domain.LostUser;
import cn.itcast.domain.User;
import cn.itcast.service.CommentService;
import cn.itcast.service.FriendService;
import cn.itcast.service.LostService;
import cn.itcast.service.Impl.CommentServiceImpl;
import cn.itcast.service.Impl.FriendServiceImpl;
import cn.itcast.service.Impl.LostServiceImpl;

public class DetailLostServlet extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String lostid = request.getParameter("lostid");
		User user = (User) request.getSession().getAttribute("user");
		LostService service = new LostServiceImpl();
		LostUser lostuser = service.findById(lostid);
		
		CommentService cservice = new CommentServiceImpl();
		List ComList =cservice.FindByActid(lostid);
		
		if(user!=null)
		{
			FriendService fservice = new FriendServiceImpl();
			String userid1 = lostuser.getUserid();
			String userid2 = user.getUserid();
			Friend friend = new Friend();
			friend.setUserid1(userid1);
			friend.setUserid2(userid2);
			friend = fservice.findFriend(friend);
			if(friend==null)
			{
				request.setAttribute("flag", "false");
			}else
			{
				request.setAttribute("flag", "true");
				
			}
		}
		
		request.setAttribute("lostuser", lostuser);
		request.setAttribute("ComList", ComList);
		
		request.getRequestDispatcher("/lost/LostDetail.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		doGet(request, response);
	}

}
