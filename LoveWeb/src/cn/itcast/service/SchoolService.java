package cn.itcast.service;

import java.util.List;

import cn.itcast.domain.ActUser;
import cn.itcast.domain.Page;

public interface SchoolService
{

	/**发布益校园活动**/
	public abstract void addAct(ActUser actuser);

	/**最新俩条益校园活动**/
	public List<ActUser> New2Act(String userid);
	
	/**最热门的俩条益校园活动**/
	public List<ActUser> pop2Act(String userid);
	
	/**查找参加报名**/
	public boolean findjoinAct(ActUser actuser);	
	
	/**根据activityid 拿参加人数**/
	public int findJoinNum(String activityid);
	
	/**取消参加活动**/
	public void CancelJoin(ActUser actuser);
	
	/**参加报名**/
	public void AddJoin(ActUser actuser);
	
	/**获取益校园活动分页数据**/
	public Page getActivityPageData(String pagenum,String url,String t_name,String sign);
	
	/**根据activityid拿出ActUser**/
	public ActUser findByActId(String activityid);
	
}