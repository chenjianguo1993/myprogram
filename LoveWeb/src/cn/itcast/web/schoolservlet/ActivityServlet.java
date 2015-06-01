package cn.itcast.web.schoolservlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.User;
import cn.itcast.service.SchoolService;
import cn.itcast.service.Impl.SchoolServiceImpl;

public class ActivityServlet extends HttpServlet
{
	private String method = null;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		method = request.getParameter("method");
		if(method==null||"nowCarry".equalsIgnoreCase(method))
		{
			defaultActivity(request,response);
		}
		
	}

	/**正在进行的益校园活动
	 * @throws IOException 
	 * @throws ServletException **/
	private void defaultActivity(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		SchoolService service = new SchoolServiceImpl();
		User user = (User) request.getSession().getAttribute("user");
		String userid = null;
		if(user!=null){
			
			userid = user.getUserid();
		}
		/**最新的俩条记录**/
		List new2list = service.New2Act(userid);
		
		/**最热门的俩条记录（参加表里拿）**/
		List pop2list = service.pop2Act(userid);
		
		request.setAttribute("new2list", new2list);
		request.setAttribute("pop2list", pop2list);
		if(method==null){
			
			request.getRequestDispatcher("/school/schoolindex.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/school/newAndpop.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		doGet(request, response);
	}

}
