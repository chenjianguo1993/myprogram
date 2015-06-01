package cn.itcast.dao;

import java.util.List;

import cn.itcast.domain.ActUser;
import cn.itcast.domain.LostUser;

public interface SearchDao
{

	/**按关键字搜索益校园活动**/
	List<ActUser> SearchAct(String search);
	
	/**按关键字搜索志愿者活动**/
	public List<ActUser> SearchVAct(String search);
	
	/**按关键字搜索失物招认领记录**/
	public List<LostUser> SearchLost(String search);

}