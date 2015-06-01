package cn.itcast.web.UI;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SchoolUIServlet extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String method =request.getParameter("method");
		if(method.equalsIgnoreCase("addActivityUIServlet"))
		{
			addActivityUIServlet(request,response);
		}
	}

	/**发布益校园活动表单
	 * @throws IOException 
	 * @throws ServletException **/
	private void addActivityUIServlet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		request.getRequestDispatcher("/school/addActivity.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		doGet(request, response);
	}

}
