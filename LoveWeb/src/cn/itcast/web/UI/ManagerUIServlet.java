package cn.itcast.web.UI;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.Page;
import cn.itcast.service.ManagerService;
import cn.itcast.service.Impl.ManagerServiceImpl;

public class ManagerUIServlet extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String pagenum = request.getParameter("pagenum");
		String serletName = this.getServletName();
		String t_name="t_user";
		String status ="0";
		ManagerService mservice = new ManagerServiceImpl();
		Page page = mservice.getBookPageData(pagenum, serletName, t_name,status);
		if(page.getList().size()==0)
		{
			response.getWriter().write("当前没有个体用户");
		}else
		{
			request.setAttribute("page", page);
		
			request.getRequestDispatcher("/manager/mindex.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		doGet(request, response);
	}

}
