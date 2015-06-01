package cn.itcast.web.volunteerservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.Page;
import cn.itcast.service.VolunService;
import cn.itcast.service.Impl.VolunServiceImpl;

public class OldVActivityServlet extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String pagenum = request.getParameter("pagenum");
		String serletName = this.getServletName();
		String t_name="t_vactivity";
		String sign =">";
		VolunService service = new VolunServiceImpl();
		Page page = service.getActivityPageData(pagenum, serletName, t_name, sign);
		if(page.getList().size()==0)
		{
			request.setAttribute("message", "对不起，当前还没有益校园活动！ ");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}else
		{
			request.setAttribute("page", page);
			request.getRequestDispatcher("/volunteer/oldCarryVActivity.jsp").forward(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		doGet(request, response);
	}

}
