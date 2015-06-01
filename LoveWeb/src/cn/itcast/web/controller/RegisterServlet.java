package cn.itcast.web.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import cn.itcast.domain.Society;
import cn.itcast.domain.User;
import cn.itcast.exception.UserExistException;
import cn.itcast.service.RegisterAndLoginService;
import cn.itcast.service.Impl.RegisterAndLoginServiceImpl;
import cn.itcast.utils.RandomUtils;
import cn.itcast.utils.WebUtils;
import cn.itcast.web.formbean.RegisterFormBean;
import cn.itcast.web.formbean.SocRegisterFormBean;

public class RegisterServlet extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String method = request.getParameter("method");
		if("Sturegister".equalsIgnoreCase(method))
		{
			Sturegister(request,response);
		}
		if("Socregister".equalsIgnoreCase(method))
		{
			Socregister(request,response);
		}
		if(method.equalsIgnoreCase("Login"))
		{
			Login(request,response);
		}
	}

	/**用户登陆
	 * @throws IOException **/
	private void Login(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		String username=request.getParameter("username");
		String password = request.getParameter("password");
		RegisterAndLoginService service = new RegisterAndLoginServiceImpl();
		User user =service.login(username, password);
		
		if(user==null){
			response.getWriter().write("登陆失败！");
		}else
		{
			request.getSession().setAttribute("user", user);
			
			response.getWriter().write("登陆成功");
		}
		
	}

	/**社团注册
	 * @throws IOException 
	 * @throws ServletException **/
	private void Socregister(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		//拿到注册表单中用户填写的内容
		SocRegisterFormBean formbean = WebUtils.request2Bean(request, SocRegisterFormBean.class);
		//得到注册表单中随机产生的验证码
		HttpSession session = request.getSession();
		StringBuffer sb = (StringBuffer) session.getAttribute("sb");
		
		//表单校验
		if(formbean.validate(sb)==false)
		{
			//出错的话，就请求转发回到原来的表单注册页面
			request.setAttribute("formbean", formbean);
			request.getRequestDispatcher("/public/Socregister.jsp").forward(request,response);
			return;
		}
		
		//把表单的数据填充到society中
		Society society = new Society();
		try
		{
			//把formbean拷贝到user中
			BeanUtils.copyProperties(society, formbean);
			
			//formbean里面没有id这个属性，所以就如下面
			society.setUserid(WebUtils.makeID());
			society.setHeadimg("images/"+RandomUtils.Random1to10()+".jpg");
			society.setStatus(0);//个体用户状态值为0
			society.setDate(new Date(System.currentTimeMillis()));
			RegisterAndLoginService service = new RegisterAndLoginServiceImpl();
			service.registerSociety(society);

			
			//数据库里面存在这个用户，说明正常登陆，就把该用户放在session里面即可，作为一个登陆标记
			response.getWriter().write("注册成功");
		} catch (UserExistException e)
		{
			formbean.getErrors().put("username", "注册用户已存在！！");
			request.setAttribute("formbean", formbean);
			response.getWriter().write("对不起,本用户名已存在,请换名重试！");
		} catch (Exception e) {
			e.printStackTrace();  //在后台记录异常
			response.getWriter().write("注册失败！");
		}
		
	}

	/**个体用户注册
	 * @throws IOException 
	 * @throws ServletException **/
	private void Sturegister(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		
		//拿到注册表单中用户填写的内容
		RegisterFormBean formbean = WebUtils.request2Bean(request, RegisterFormBean.class);
		System.out.println(formbean.getImagefont());
		//得到注册表单中随机产生的验证码
		HttpSession session = request.getSession();
		StringBuffer sb = (StringBuffer) session.getAttribute("sb");
		
		//表单校验
		if(formbean.validate(sb)==false)
		{
			//出错的话，就请求转发回到原来的表单注册页面
			request.setAttribute("formbean", formbean);
			request.getRequestDispatcher("/public/register.jsp").forward(request,response);
			return;
		}
		
		//把表单的数据填充到javabean中
		User user = new User();
		
		try
		{
			//把formbean拷贝到user中
			BeanUtils.copyProperties(user, formbean);
			
			//formbean里面没有id这个属性，所以就如下面
			user.setUserid(WebUtils.makeID());
			user.setHeadimg("images/"+RandomUtils.Random1to10()+".jpg");
			user.setStatus(0);//个体用户状态值为0
			user.setDate(new Date(System.currentTimeMillis()));
			RegisterAndLoginService service = new RegisterAndLoginServiceImpl();
			service.registerUser(user);

			
			//数据库里面存在这个用户，说明正常登陆，就把该用户放在session里面即可，作为一个登陆标记
			request.getSession().setAttribute("user", user);
			int number =RandomUtils.Random1to10();
			request.getSession().setAttribute("number", number);
			response.getWriter().write("注册成功");
		} catch (UserExistException e)
		{
			formbean.getErrors().put("username", "注册用户已存在！！");
			request.setAttribute("formbean", formbean);
			response.getWriter().write("对不起,本用户名已存在,注册失败！");
		} catch (Exception e) {
			e.printStackTrace();  //在后台记录异常
			response.getWriter().write("注册失败！");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		doGet(request, response);
	}

}
