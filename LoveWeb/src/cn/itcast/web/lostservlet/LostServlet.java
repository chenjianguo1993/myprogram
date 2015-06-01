package cn.itcast.web.lostservlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.User;
import cn.itcast.service.LostService;
import cn.itcast.service.Impl.LostServiceImpl;

public class LostServlet extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String method = request.getParameter("method");
		LostService service = new LostServiceImpl();
		
		if(method==null)
		{
			String losttype = "xunzao";
			
			/**最新俩条失物寻找**/
			List new2list = service.New2Act(losttype);
			
			/**最热门的俩条失物寻找**/
			
			
			
			request.setAttribute("new2list", new2list);
			
			request.getRequestDispatcher("/lost/lostindex.jsp").forward(request, response);
			
			
		}else if(method.equalsIgnoreCase("renling"))
		{
			String losttype = "renling";
			
			/**最新俩条失物认领**/
			List new2list = service.New2Act(losttype);
			
			/**最热门的俩条失物认领**/
			
			request.setAttribute("new2list", new2list);
			request.getRequestDispatcher("/lost/newAndpop.jsp").forward(request, response);
		}else if(method.equalsIgnoreCase("xunzao"))
		{
			String losttype = "xunzao";
			
			/**最新俩条失物寻找**/
			List new2list = service.New2Act(losttype);
			
			/**最热门的俩条失物寻找**/
			
			
			
			request.setAttribute("new2list", new2list);
			
			request.getRequestDispatcher("/lost/newAndpop.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		doGet(request, response);
	}

}
