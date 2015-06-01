package cn.itcast.service;

import cn.itcast.domain.Page;
import cn.itcast.domain.User;

public interface UserService
{
	//根据名字查找userid
	public String findByUsername(String username);
	
	/**根据userid查用户信息**/
	public User findById(String userid);
	
	/**修改用户信息**/
	public void updateUserInfo(User user);
	
	/**获取用户（曾经或者即将）参加益校园活动分页数据**/
	public Page getUserJoinActivityPageData(String pagenum,String url,String userid,String sign);
}
