package cn.itcast.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.service.ManagerService;
import cn.itcast.service.Impl.ManagerServiceImpl;

public class AgreeServlet extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String method=request.getParameter("method");
		if(method.equalsIgnoreCase("agreesoc"))
		{
			agreesoc(request,response);
		}
		if(method.equalsIgnoreCase("disagreesoc"))
		{
			disagreesoc(request,response);
		}
		
	}

	/**驳回社团审批
	 * @throws IOException **/
	private void disagreesoc(HttpServletRequest request,
			HttpServletResponse response) throws IOException
	{
		String userid=request.getParameter("userid");
		ManagerService mservice = new ManagerServiceImpl();
		mservice.disagree(userid);
		response.getWriter().write("驳回成功!");
	}

	/**通过审批
	 * @throws IOException **/
	private void agreesoc(HttpServletRequest request,
			HttpServletResponse response) throws IOException
	{
		String userid=request.getParameter("userid");
		ManagerService mservice = new ManagerServiceImpl();
		mservice.AgreeSoc(userid);
		response.getWriter().write("同意申请!");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		doGet(request, response);
	}

}
