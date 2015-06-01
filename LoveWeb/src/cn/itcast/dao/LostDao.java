package cn.itcast.dao;

import java.util.List;

import cn.itcast.domain.LostUser;

public interface LostDao
{

	/**发布失物招认领**/
	void addlost(LostUser lost);
	
	/**最新俩条失物招认领记录**/
	public List<LostUser> new2Act(String losttype);
	
	/**根据lostid查找该记录**/
	public LostUser findById(String lostid);

}