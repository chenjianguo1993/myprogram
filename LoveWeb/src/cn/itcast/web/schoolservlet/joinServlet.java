package cn.itcast.web.schoolservlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import cn.itcast.domain.ActUser;
import cn.itcast.domain.User;
import cn.itcast.service.SchoolService;
import cn.itcast.service.Impl.SchoolServiceImpl;

public class joinServlet extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String activityid = request.getParameter("id");
		User user = (User) request.getSession().getAttribute("user");
		if(user == null)
		{
			response.getWriter().write("unlogin");
			return ;
		}
		String userid = user.getUserid();
		if(activityid==null){
			return;
		}
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
		
		String jsonStr = "{\"flag\":\""+flag+"\",\"count\":"+number+"}";
		response.getWriter().write(jsonStr);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		doGet(request, response);
	}

}
