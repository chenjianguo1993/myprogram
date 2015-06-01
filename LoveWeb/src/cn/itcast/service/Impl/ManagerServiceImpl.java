package cn.itcast.service.Impl;

import java.util.List;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.Impl.UserDaoImpl;
import cn.itcast.domain.Page;
import cn.itcast.domain.Society;
import cn.itcast.domain.User;
import cn.itcast.service.ManagerService;

public class ManagerServiceImpl implements ManagerService
{
	UserDao udao = new UserDaoImpl();
	/**拿出申请社团,当前社团，当前个人用户记录**/
	public Page getBookPageData(String pagenum,String url,String t_name,String status)
	{
		int totalrecord ;
		Page page = null;
		if(t_name.equalsIgnoreCase("t_society"))
		{
			totalrecord= udao.getTotalRecord(t_name,status);
			if(pagenum==null)
			{
				page = new Page(1,totalrecord);
			}else
			{
				page = new Page(Integer.parseInt(pagenum),totalrecord);
			}
			List list = udao.getPageData(page.getStartindex(), page.getPagesize(),t_name,status);
		
			page.setList(list);
			page.setUrl(url);
		}
		if(t_name.equalsIgnoreCase("t_user"))
		{
			totalrecord= udao.getNowUserTotalRecord(t_name,status);
			if(pagenum==null)
			{
				page = new Page(1,totalrecord);
			}else
			{
				page = new Page(Integer.parseInt(pagenum),totalrecord);
			}
			List list = udao.getNowUserPageData(page.getStartindex(), page.getPagesize(),t_name,status);
		
			page.setList(list);
			page.setUrl(url);
		}
		return page;
		
	}
	/**批准社团申请**/
	public void AgreeSoc(String userid)
	{
		Society society =udao.updateById(userid);
		
		User user = new User();
		user.setUserid(society.getUserid());
		user.setUsername(society.getSocname());
		user.setPassword(society.getPassword());
		user.setEmail(society.getEmail());
		user.setPhone(society.getPhone());
		user.setDate(society.getDate());
		user.setStatus(society.getStatus());
		user.setHeadimg(society.getHeadimg());
		
		udao.add(user);
	}
	
	/**根据userid驳回社团申请(实质就是将其删除)**/
	public void disagree(String userid)
	{
		udao.rejectsoc(userid);
	}
	
	/**根据userid清除该用户**/
	public void Sweep(String userid)
	{
		udao.sweep(userid);
	}
}
