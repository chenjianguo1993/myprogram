package cn.itcast.service;

import java.util.List;

import cn.itcast.domain.ActUser;
import cn.itcast.domain.LostUser;

public interface SearchService
{

	/**按关键字搜索益校园活动**/
	List<ActUser> SearchAct(String search);
	
	/**按关键字搜索志愿者活动**/
	public List<ActUser> SearchVAct(String search);
	
	/**按关键字搜索失物招认领**/
	public List<LostUser> SeachLost(String search);

}