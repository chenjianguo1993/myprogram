package cn.itcast.dao.Impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.dao.LostDao;
import cn.itcast.domain.ActUser;
import cn.itcast.domain.LostUser;
import cn.itcast.exception.DaoException;
import cn.itcast.utils.JdbcUtils;

public class LostDaoImpl implements LostDao
{
	/**发布失物招认领**/
	public void addlost(LostUser lost)
	{
		try
		{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql="insert into t_lost (lostid,lostname,losttype,reledate,image,description,userid)values(?,?,?,?,?,?,?)";
			Object[] params={lost.getLostid(),lost.getLostname(),lost.getLosttype(),lost.getReledate(),lost.getImage(),lost.getDescription(),lost.getUserid()};
			qr.update(sql, params);
		}catch(Exception e)
		{
			throw new RuntimeException(e);
		}
	}
	
	/**最新俩条失物招认领记录**/
	public List<LostUser> new2Act(String losttype)
	{
		try
		{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql="select * from t_lost l join t_user u on l.userid=u.userid where losttype=? and  datediff((select sysdate() from dual),reledate) >= 0 order by reledate desc limit 0,2";
			Object params[]={losttype};
			return(List<LostUser>) qr.query(sql, params, new BeanListHandler(LostUser.class));
			
			
		}catch(Exception e)
		{
			throw new DaoException(e);
		}
	}
	
	/**根据lostid查找该记录**/
	public LostUser findById(String lostid)
	{
		try
		{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from t_lost l join t_user u on l.userid =u.userid where lostid=?";
			Object params[]={lostid};
			return  (LostUser) qr.query(sql, params, new BeanHandler(LostUser.class));
		}catch(Exception e)
		{
			throw new DaoException(e);
		}
	}
}
