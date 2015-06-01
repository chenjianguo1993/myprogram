package cn.itcast.service.Impl;

import java.util.List;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.Impl.UserDaoImpl;
import cn.itcast.domain.Page;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;

public class UserServiceImpl implements UserService
{
	UserDao udao = new UserDaoImpl();
	
	//根据名字查找userid
	public String findByUsername(String username)
	{
		return udao.findByUsername(username);
	}
	
	
	/**根据userid查用户信息**/
	public User findById(String userid)
	{
		return udao.findById(userid);
	}
	
	/**修改用户信息**/
	public void updateUserInfo(User user)
	{
		udao.updateUserInfo(user);
	}
	
	/**获取用户（曾经或者即将）参加益校园活动分页数据**/
	public Page getUserJoinActivityPageData(String pagenum,String url,String userid,String sign)
	{
		int totalrecord = udao.getUserJoinActTotalRecord(userid,sign);
		Page page = null;
		if(pagenum==null)
		{
			page = new Page(1,totalrecord);
		}else
		{
			page = new Page(Integer.parseInt(pagenum),totalrecord);
		}
		List list = udao.getUserJoinActPageData(page.getStartindex(), page.getPagesize(),userid,sign);
		page.setList(list);
		page.setUrl(url);
		
		return page;
	}
}
