package cn.itcast.service;

import java.util.List;

import cn.itcast.domain.LostUser;

public interface LostService
{
	/**发布失物招认领记录**/
	public void addLost(LostUser lostuser);
	
	/**最新俩条失物招认领记录**/
	public List<LostUser> New2Act(String losttype);
	
	/**根据lostid查找该记录**/
	public LostUser findById(String lostid);
}