package cn.itcast.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.Email;
import cn.itcast.domain.User;
import cn.itcast.service.EmailService;
import cn.itcast.service.UserService;
import cn.itcast.service.Impl.EmailServiceImpl;
import cn.itcast.service.Impl.UserServiceImpl;

public class SendEmailServlet extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		User user = (User) request.getSession().getAttribute("user");
		String username = request.getParameter("username");
		String content = request.getParameter("content");
		
		PrintWriter out = response.getWriter();
		if(user==null)
		{
			out.write("unlogin");
			return ;
		}
		UserService uservice = new UserServiceImpl();
		String userid1 = uservice.findByUsername(username);
		String userid2 = user.getUserid();
		Email email = new Email();
		email.setUserid1(userid1);
		email.setUserid2(userid2);
		email.setContent(content);
		email.setSendtime(new Date(System.currentTimeMillis()));
		email.setFlag("1");
		EmailService service = new EmailServiceImpl();
		service.addEmail(email);
		out.write("true");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		doGet(request, response);
	}

}
