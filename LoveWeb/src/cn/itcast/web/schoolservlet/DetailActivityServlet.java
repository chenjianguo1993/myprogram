package cn.itcast.web.schoolservlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.ActUser;
import cn.itcast.domain.Friend;
import cn.itcast.domain.User;
import cn.itcast.service.CommentService;
import cn.itcast.service.FriendService;
import cn.itcast.service.SchoolService;
import cn.itcast.service.Impl.CommentServiceImpl;
import cn.itcast.service.Impl.FriendServiceImpl;
import cn.itcast.service.Impl.SchoolServiceImpl;

public class DetailActivityServlet extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		User user = (User) request.getSession().getAttribute("user");
		
		String activityid = request.getParameter("activityid");
		SchoolService service = new SchoolServiceImpl();
		ActUser actuser =service.findByActId(activityid);
		CommentService cservice = new CommentServiceImpl();
		List ComList =cservice.FindByActid(activityid);
		
		//查找登陆后用户与该活动发起人是不是好友
		if(user!=null)
		{
			FriendService fservice = new FriendServiceImpl();
			String userid1 = actuser.getUserid();
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
		request.setAttribute("actuser", actuser);
		request.setAttribute("ComList", ComList);
		
		request.getRequestDispatcher("/school/ActivityDetail.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		doGet(request, response);
	}

}
