package cn.itcast.dao;

import java.util.List;

import cn.itcast.domain.ActUser;
import cn.itcast.domain.Society;
import cn.itcast.domain.User;

public interface UserDao
{

	/**注册个体用户**/
	public abstract void add(User user);

	/**注册个体时查找用户是否存在同名用户**/
	public abstract User find(String username);
	
	/**************上面个体，下面社团*****************************/

	/**社团注册**/
	public void addSoc(Society society);
	
	/**注册社团时检查**/
	public Society findSoc(String username);
	
	/**登陆时查找用户**/
	public User find(String username, String password);
	
	/**得到申请社团总数**/
	public int getTotalRecord(String t_name,String status);
	
	/**把申请社团放在list集合里**/
	public List<Society> getPageData(int startindex,int pagesize,String t_name,String status);
	
	/**根据userid修改社团**/
	public Society updateById(String userid);
	
	/**根据userid驳回社团申请(实质就是将其删除)**/
	public void rejectsoc(String userid);
	
	/**得到当前的用户总数，stauts=1为社团，为0为个人**/
	public int getNowUserTotalRecord(String t_name,String status);
	
	/**把当前用户放在list中status=1为社团，status=0为个人**/
	public List<User> getNowUserPageData(int startindex,int pagesize,String t_name,String status);
	
	/**根据userid在t_user清除该用户**/
	public void sweep(String userid);
	
	//根据名字查找userid
	public String findByUsername(String username);
	
	/**根据userid查用户信息**/
	public User findById(String userid);
	
	/**修改用户信息**/
	public void updateUserInfo(User user);
	
	/**用户参加益校园活动记录数**/
	public int getUserJoinActTotalRecord(String userid,String sign);
	
	/**用户（曾经或即将）参加的益校园活动**/
	public List<ActUser> getUserJoinActPageData(int startindex,int pagesize,String userid,String sign);
	
	/**根据activityid查找参加活动人数**/
	public int FindJoinNum(String  activityid);
}