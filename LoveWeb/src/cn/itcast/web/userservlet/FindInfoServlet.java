package cn.itcast.web.userservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import cn.itcast.service.Impl.UserServiceImpl;

public class FindInfoServlet extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		User user1 = (User) request.getSession().getAttribute("user");
		String userid = user1.getUserid();
		UserService service = new UserServiceImpl();
		User user = service.findById(userid);
		request.setAttribute("user", user);
		request.getRequestDispatcher("/user/userInfo.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		doGet(request, response);
	}

}
