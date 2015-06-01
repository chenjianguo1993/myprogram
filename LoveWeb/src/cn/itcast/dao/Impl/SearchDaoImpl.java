package cn.itcast.dao.Impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.dao.SearchDao;
import cn.itcast.domain.ActUser;
import cn.itcast.domain.LostUser;
import cn.itcast.exception.DaoException;
import cn.itcast.utils.JdbcUtils;

public class SearchDaoImpl implements SearchDao
{
	/**按关键字搜索益校园活动**/
	public List<ActUser> SearchAct(String search)
	{
		try
		{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql="select * from t_activity a join t_user u on a.userid=u.userid where a.name like '%"+search+"%' order by a.enddate desc limit 0,3";
			return (List<ActUser>) qr.query(sql,  new BeanListHandler(ActUser.class));
			
		}catch(Exception e)
		{
			throw new DaoException(e);
		}
	}
	
	/**按关键字搜索志愿者活动**/
	public List<ActUser> SearchVAct(String search)
	{
		try
		{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql="select * from t_vactivity a join t_user u on a.userid=u.userid where a.name like '%"+search+"%' order by a.enddate desc limit 0,3";
			return (List<ActUser>) qr.query(sql,  new BeanListHandler(ActUser.class));
			
		}catch(Exception e)
		{
			throw new DaoException(e);
		}
	}
	
	/**按关键字搜索失物招认领记录**/
	public List<LostUser> SearchLost(String search)
	{
		try
		{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql="select * from t_lost l join t_user u on l.userid = u.userid where l.lostname like '%"+search+"%' order by reledate desc limit 0,3";
			return (List<LostUser>) qr.query(sql,  new BeanListHandler(LostUser.class));
		}catch(Exception e)
		{
			throw new DaoException(e);
		}
	}
	
	
	
}
