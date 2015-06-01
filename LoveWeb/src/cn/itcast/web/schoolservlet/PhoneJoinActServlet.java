package cn.itcast.web.schoolservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.ActUser;
import cn.itcast.domain.User;
import cn.itcast.service.SchoolService;
import cn.itcast.service.Impl.SchoolServiceImpl;

public class PhoneJoinActServlet extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String activityid = request.getParameter("activityid");
		
		String userid = "562e28f5-4076-4f96-a6b9-506aa166a84b";
		
		ActUser actuser = new ActUser();
		actuser.setActivityid(activityid);
		actuser.setUserid(userid);
		SchoolService service = new SchoolServiceImpl();
		boolean b = service.findjoinAct(actuser);
		String flag = ""+false;
		if(b)
		{
			service.CancelJoin(actuser);
			flag = ""+true;
		}else
		{
			service.AddJoin(actuser);
		}
		int number = service.findJoinNum(activityid);
		String n=number+"";
		response.getWriter().write(n);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		doGet(request, response);
	}

}
