package cn.itcast.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

public class SixinMoreServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String startNum = request.getParameter("startNum");
		if(startNum==null){
			startNum = "0";
		}
		int n = startNum.length();
		int start = (n-1)*5;
		//此处需要检查私信表的总数（未读，已读，已发）或者直接在后台直接检查都可以
		int num = 100;
		if(start>num){
			response.getWriter().write("end");
			return;
		}
		//用list封装数据后forward到sixincontent页面套数据再返回
		request.getRequestDispatcher("/user/sixincontent.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
