package cn.itcast.web.volunteerservlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.User;
import cn.itcast.service.VolunService;
import cn.itcast.service.Impl.VolunServiceImpl;

public class VActivityServlet extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String method = request.getParameter("method");
		VolunService service = new VolunServiceImpl();
		User user = (User) request.getSession().getAttribute("user");
		String userid = null;
		if(user!=null){
			
			userid = user.getUserid();
		}
		
		/**最新的俩条记录**/
		List new2list = service.New2Act(userid);
		
		/**最热门的俩条记录（参加表里拿）**/
		List pop2list = service.pop2Act(userid);
		
		request.setAttribute("new2list", new2list);
		request.setAttribute("pop2list", pop2list);
		
		if(method==null)
		{
			
			request.getRequestDispatcher("/volunteer/volunteerindex.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/volunteer/newAndpop.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		doGet(request, response);
	}

}
