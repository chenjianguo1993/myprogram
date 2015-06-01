package cn.itcast.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import cn.itcast.service.SearchService;
import cn.itcast.service.Impl.SearchServiceImpl;

public class SearchServlet extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String search = request.getParameter("search");
		if(search==null||search.trim().equals(""))
		{
			request.setAttribute("message", "对不起,请输入搜索关键字");
			request.getRequestDispatcher("/message2.jsp").forward(request, response);
		}
		
		SearchService service = new SearchServiceImpl();
		List alist = service.SearchAct(search);
		List vlist = service.SearchVAct(search);
		List llist = service.SeachLost(search);
		
		if(alist.size()==0&&vlist.size()==0&&llist.size()==0)
		{
			request.setAttribute("message", "尊敬的用户,没有你想要查询的记录!请换关键字重试！");
			request.getRequestDispatcher("/message2.jsp").forward(request, response);
		}else
		{
			request.setAttribute("alist", alist);
			request.setAttribute("vlist", vlist);
			request.setAttribute("llist", llist);
			
			request.getRequestDispatcher("/public/S.jsp").forward(request, response);
			
		}
		
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		doGet(request, response);
	}

}
