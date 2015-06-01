package cn.itcast.web.userservlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import cn.itcast.domain.ActUser;
import cn.itcast.domain.Page;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import cn.itcast.service.Impl.UserServiceImpl;

public class UserActivityServlet extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String method = request.getParameter("method");
		if("UserOldCarryActivity".equalsIgnoreCase(method))
		{
			UserOldCarryActivity(request,response);
		}if("UserNowCarryAct".equalsIgnoreCase(method))
		{
			UserNowCarryAct(request,response);
		}
	}

	/**用户即将去参加的益校园活动
	 * @throws IOException 
	 * @throws ServletException **/
	private void UserNowCarryAct(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		User user = (User) request.getSession().getAttribute("user");
		String pagenum = request.getParameter("pagenum");
		String serletName = this.getServletName();
		String userid = user.getUserid();
		String sign = "<";
		UserService service = new UserServiceImpl();
		Page page = service.getUserJoinActivityPageData(pagenum, serletName, userid, sign);
		
		if(page.getList().size()==0)
		{
			request.setAttribute("message", "对不起,您当前还没有参加益校园活动!");
			request.getRequestDispatcher("/message2.jsp").forward(request, response);
		}else
		{
		
			request.setAttribute("page", page);
			request.getRequestDispatcher("/user/UserNowCarryActivity.jsp").forward(request, response);
		}
	}

	/**用户曾经参加的益校园活动
	 * @throws IOException 
	 * @throws ServletException **/
	private void UserOldCarryActivity(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		User user = (User) request.getSession().getAttribute("user");
		String pagenum = request.getParameter("pagenum");
		String serletName = this.getServletName();
		String userid = user.getUserid();
		String sign = ">";
		UserService service = new UserServiceImpl();
		Page page = service.getUserJoinActivityPageData(pagenum, serletName, userid, sign);
		
		if(page.getList().size()==0)
		{
//			response.getWriter().write("0");
			request.setAttribute("message", "尊敬的用户，您曾经还没有参加过益校园活动");
			request.getRequestDispatcher("/message2.jsp").forward(request, response);
			
		}else
		{
			
//			JSONArray json = JSONArray.fromObject(list);
			request.setAttribute("page", page);
//			response.getWriter().write("1");
//			JSONArray json = JSONArray.fromObject(page.getList());
//			response.getWriter().write(json.toString());
//			System.out.println(json.toString());
			request.getRequestDispatcher("/user/UserOldCarryActivity.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		doGet(request, response);
	}

}
