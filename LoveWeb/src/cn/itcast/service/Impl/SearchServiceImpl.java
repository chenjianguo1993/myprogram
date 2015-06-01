package cn.itcast.service.Impl;

import java.util.List;

import cn.itcast.dao.SearchDao;
import cn.itcast.dao.Impl.SearchDaoImpl;
import cn.itcast.domain.ActUser;
import cn.itcast.domain.LostUser;
import cn.itcast.service.SearchService;

public class SearchServiceImpl implements SearchService
{
	SearchDao dao = new SearchDaoImpl();
	
	/**按关键字搜索益校园活动**/
	public List<ActUser> SearchAct(String search)
	{
		return dao.SearchAct(search);
	}
	
	/**按关键字搜索志愿者活动**/
	public List<ActUser> SearchVAct(String search)
	{
		return dao.SearchVAct(search);
	}
	
	
	/**按关键字搜索失物招认领**/
	public List<LostUser> SeachLost(String search)
	{
		return dao.SearchLost(search);	}
}
