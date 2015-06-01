package cn.itcast.dao;

import java.util.List;

import cn.itcast.domain.ActUser;

public interface VolunDao
{

	/**发布志愿者活动**/
	void add(ActUser actuser);

	/**即将进行的最新俩条记录**/
	List<ActUser> new2Act();

	/**根据activityid查找参加活动人数**/
	int FindJoinNum(String activityid);

	/**最热门俩条志愿者活动id（按照t_vuserjoin表来确定）**/
	public List<ActUser> Popluar2Act();
	
	/**根据activityid返回ActUser实体**/
	public ActUser findById(String activityid);
	
	/**参加志愿者活动**/
	public void addjoin(ActUser actuser);
	
	/**取消参加志愿者活动**/
	public void cancelJoin(ActUser actuser);
	
	/**根据userid和activityid查出用户参加志愿者活动与否**/
	public boolean findJoinBy2id(ActUser actuser);
	
	/**根据userid和activityid查出用户参加活动与否**/
	public ActUser findJoinByid(ActUser actuser);
	
	/**获取符合需要条件志愿者活动的总记录**/
	public int getTotalRecord(String t_name,String sign);
	
	/**把符合条件的志愿者活动记录放在list记录里**/
	public List<ActUser> getPageData(int startindex,int pagesize,String t_name,String sign);
}