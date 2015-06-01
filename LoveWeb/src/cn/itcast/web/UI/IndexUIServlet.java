package cn.itcast.web.UI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import cn.itcast.domain.ActUser;
import cn.itcast.domain.LostUser;
import cn.itcast.domain.User;
import cn.itcast.service.LostService;
import cn.itcast.service.SchoolService;
import cn.itcast.service.VolunService;
import cn.itcast.service.Impl.LostServiceImpl;
import cn.itcast.service.Impl.SchoolServiceImpl;
import cn.itcast.service.Impl.VolunServiceImpl;

public class IndexUIServlet extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		User user = (User) request.getSession().getAttribute("user");
		String userid = null;
		if(user!=null){
			
			userid = user.getUserid();
		}
		/**拿益校园的俩条最新记录**/
		SchoolService sservice = new SchoolServiceImpl();
		List<ActUser> new2alist = sservice.New2Act(userid);
		request.setAttribute("new2alist", new2alist);
		
		/**拿志愿者活动的最新俩条记录**/
		VolunService vservice = new VolunServiceImpl();
		List<ActUser> new2vlist= vservice.New2Act(userid);
		request.setAttribute("new2vlist", new2vlist);
		
		/**拿失物招领的俩条最新记录**/
		LostService lservice = new LostServiceImpl();
		List<LostUser> new2llist  = lservice.New2Act("renling");
		request.setAttribute("new2llist", new2llist);
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		doGet(request, response);
	}

}
