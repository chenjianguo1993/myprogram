package cn.itcast.service.Impl;

import java.util.List;

import cn.itcast.dao.LostDao;
import cn.itcast.dao.Impl.LostDaoImpl;
import cn.itcast.domain.ActUser;
import cn.itcast.domain.LostUser;
import cn.itcast.service.LostService;

public class LostServiceImpl implements LostService
{
	LostDao ldao =new LostDaoImpl();
	
	/**发布失物招认领记录**/
	public void addLost(LostUser lostuser)
	{
		ldao.addlost(lostuser);
	}
	
	/**最新俩条失物招认领记录**/
	public List<LostUser> New2Act(String losttype)
	{
		return ldao.new2Act(losttype);
	}
	
	/**根据lostid查找该记录**/
	public LostUser findById(String lostid)
	{
		return ldao.findById(lostid);
	}
}
