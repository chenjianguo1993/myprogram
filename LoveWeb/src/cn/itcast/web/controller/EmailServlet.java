package cn.itcast.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.Email;
import cn.itcast.domain.ShowEmail;
import cn.itcast.domain.User;
import cn.itcast.service.EmailService;
import cn.itcast.service.Impl.EmailServiceImpl;

public class EmailServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		String num = request.getParameter("startNum");
		if(num==null){
			num="0";
		}
		int startNum = Integer.parseInt(num);
		String flag = request.getParameter("flag");
		PrintWriter out = response.getWriter();
		if(user==null)
		{
			out.write("unlogin");
			return ;
		}
		EmailService service = new EmailServiceImpl();
		String userid2 = user.getUserid();
		List<ShowEmail> list = new ArrayList<ShowEmail>();
		if(flag==null){
			flag = "1";
			list = service.findAndUpdate(userid2, flag, startNum);
			request.setAttribute("list", list);
			request.getRequestDispatcher("/user/sixin.jsp").forward(request, response);
			return;
		}
		String type = null;
		if(flag.equalsIgnoreCase("1"))//未读
		{
			type = "1";
			list = service.findAndUpdate(userid2, flag, startNum);
			
		}else if(flag.equalsIgnoreCase("2"))//已读
		{
			type = "2";
			list = service.findReaded(userid2, flag, startNum);
		}else if(flag.equalsIgnoreCase("sended"))//已发
		{
			type = "3";
			list = service.findSendedEmail(userid2, startNum);
		}
		request.setAttribute("type", type);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/user/sixincontent.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
