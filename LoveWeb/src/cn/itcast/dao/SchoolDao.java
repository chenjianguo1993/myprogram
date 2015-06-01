package cn.itcast.dao;

import java.util.List;

import cn.itcast.domain.ActUser;

public interface SchoolDao
{

	/**添加益校园活动**/
	public abstract void add(ActUser actuser);

	/**即将进行的最新俩条记录**/
	public List<ActUser> new2Act();
	
	/**根据activityid查找参加活动人数**/
	public int FindJoinNum(String  activityid);
	
	/**最热门俩条益校园活动id（按照t_userjoin表来确定）**/
	public List<ActUser> Popluar2Act();
	
	/**根据activityid返回ActUser实体**/
	public ActUser findById(String activityid);
	
	/**参加活动**/
	public void addjoin(ActUser actuser);
	
	/**取消参加益校园活动**/
	public void cancelJoin(ActUser actuser);
	
	/**根据userid和activityid查出用户参加活动与否**/
	public boolean findJoinBy2id(ActUser actuser);
	
	/**根据userid和activityid查出用户参加活动与否**/
	public ActUser findJoinByid(ActUser actuser);
	
	/**获取符合需要条件益校园活动的总记录**/
	public int getTotalRecord(String t_name,String sign);
	
	/**把符合条件的益校园记录放在list记录里**/
	public List<ActUser> getPageData(int startindex,int pagesize,String t_name,String sign);
	
}