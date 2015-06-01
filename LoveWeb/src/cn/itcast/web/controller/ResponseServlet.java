package cn.itcast.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import cn.itcast.domain.Comment;
import cn.itcast.domain.User;
import cn.itcast.service.CommentService;
import cn.itcast.service.Impl.CommentServiceImpl;
import cn.itcast.utils.WebUtils;

public class ResponseServlet extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		User user = (User) request.getSession().getAttribute("user");
		if(user==null){
			response.getWriter().write("unlogin");
			return;
		}
		//1.封装评论实体
		String activityid = request.getParameter("activityid");
		String content = request.getParameter("content");
		Comment comment = new Comment();
		String commentid = WebUtils.makeID();
		comment.setActivityid(activityid);
		comment.setCommentid(commentid);
		comment.setCommentContext(content);
		Date date = new Date(System.currentTimeMillis());
		comment.setCommentdate(date);
		comment.setUserid(user.getUserid());
		
		//2.存到数据库
		CommentService service = new CommentServiceImpl();
		service.addcomment(comment);
		//3.再从数据库拿到这条评论
		comment =service.FindByComid(commentid);
		request.setAttribute("comment", comment);
		//4.跳转到公共展示页面
		request.getRequestDispatcher("/public/comment.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		doGet(request, response);
	}

}
