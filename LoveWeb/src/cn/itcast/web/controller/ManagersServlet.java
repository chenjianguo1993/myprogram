package cn.itcast.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.Page;
import cn.itcast.service.ManagerService;
import cn.itcast.service.Impl.ManagerServiceImpl;

public class ManagersServlet extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String method = request.getParameter("method");
		if(method.equalsIgnoreCase("nowApply"))
		{
			nowApply(request,response);
		}
		if(method.equalsIgnoreCase("nowSoc"))
		{
			nowSoc(request,response);
		}
		if(method.equalsIgnoreCase("nowStu"))
		{
			nowStu(request,response);
		}
		if(method.equalsIgnoreCase("sweep"))
		{
			sweep(request,response);
		}
		
	}

	/**清除用户
	 * @throws IOException **/
	private void sweep(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		String userid = request.getParameter("userid");
		String t_name="t_user";
		ManagerService service = new ManagerServiceImpl();
		service.Sweep(userid);
		response.getWriter().write("清除成功");
	}

	/**当前的个人用户
	 * @throws IOException 
	 * @throws ServletException **/
	private void nowStu(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
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
		
			request.getRequestDispatcher("/manager/nowUser.jsp").forward(request, response);
		}
	}

	/**当前的社团用户
	 * @throws IOException 
	 * @throws ServletException **/
	private void nowSoc(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		String pagenum = request.getParameter("pagenum");
		String serletName = this.getServletName();
		String t_name="t_user";
		String status ="1";
		ManagerService mservice = new ManagerServiceImpl();
		Page page = mservice.getBookPageData(pagenum, serletName, t_name,status);
		if(page.getList().size()==0)
		{
			response.getWriter().write("当前没有社团用户");
		}else
		{
			request.setAttribute("page", page);
		
			request.getRequestDispatcher("/manager/nowUser.jsp").forward(request, response);
		}
	}

	/**查看正在申请社团
	 * @throws IOException 
	 * @throws ServletException **/
	private void nowApply(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException
	{
		String pagenum = request.getParameter("pagenum");
		String serletName = this.getServletName();
		String t_name="t_society";
		String status = "0";
		ManagerService mservice = new ManagerServiceImpl();
		Page page = mservice.getBookPageData(pagenum, serletName, t_name,status);
		if(page.getList().size()==0)
		{
			response.getWriter().write("还没有申请社团");
		}else
		{
			request.setAttribute("page", page);
		
			request.getRequestDispatcher("/manager/manager.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		doGet(request, response);
	}

}
