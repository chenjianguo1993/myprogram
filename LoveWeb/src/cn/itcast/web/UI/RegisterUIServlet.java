package cn.itcast.web.UI;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterUIServlet extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String method = request.getParameter("method");
		if(method.equalsIgnoreCase("Sturegister"))
		{
			Sturegister(request,response);
		}
		if(method.equalsIgnoreCase("Socregister"))
		{
			Socregister(request,response);
		}
	}

	/**社团注册页面
	 * @throws IOException 
	 * @throws ServletException **/
	private void Socregister(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		request.getRequestDispatcher("/public/Socregister.jsp").forward(request, response);
	}

	/**个人注册页面
	 * @throws IOException 
	 * @throws ServletException **/
	private void Sturegister(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		request.getRequestDispatcher("/public/Sturegister.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		doGet(request, response);
	}

}
