package cn.itcast.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.dao.SchoolDao;
import cn.itcast.domain.ActUser;
import cn.itcast.exception.DaoException;
import cn.itcast.utils.JdbcUtils;

public class SchoolDaoImpl implements SchoolDao
{
	/**发布益校园活动**/
	public void add(ActUser actuser)
	{
		try
		{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql="insert into t_activity (activityid,name,startdate,enddate,joindate,address,image,video,description,userid) values(?,?,?,?,?,?,?,?,?,?)";
			Object params[]={actuser.getActivityid(),actuser.getName(),actuser.getStartdate(),actuser.getEnddate(),actuser.getJoindate(),actuser.getAddress(),actuser.getImage(),actuser.getVideo(),actuser.getDescription(),actuser.getUserid()};
			qr.update(sql, params);
			
		}catch(Exception e)
		{
			throw new DaoException(e);
		}
	}
	
	/**即将进行的最新俩条记录**/
	public List<ActUser> new2Act()
	{
		List list=null;
		try
		{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql="select * from t_activity a join t_user u on a.userid=u.userid where datediff((select sysdate() from dual),enddate) < 0 order by joindate desc limit 0,2";
			Object params[]={};
			list =(List<ActUser>) qr.query(sql, params, new BeanListHandler(ActUser.class));
			
			for(int i=0;i<list.size();i++)
			{
				ActUser actuser=(ActUser) list.get(i);
				String activityid=actuser.getActivityid();
			    int  joinnum = FindJoinNum(activityid);
			    actuser.setJoinnum(joinnum);
			}
			
		}catch(Exception e)
		{
			throw new DaoException(e);
		}
		return list;
	}
	
	/**根据activityid查找参加活动人数**/
	public int FindJoinNum(String  activityid)
	{
		try
		{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql="select count(*) from t_userjoin where activityid=?";
			Object params[]={activityid};
		    long i = (Long) qr.query(sql,params, new ScalarHandler());
			return (int)i;
		}catch(Exception e)
		{
			throw new DaoException(e);
		}
	}
	/**最热门俩条益校园活动id（按照t_userjoin表来确定）**/
	public List<ActUser> Popluar2Act()
	{
		
		try
		{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql="select j.activityid from t_userjoin j  group by j.activityid  desc limit 0,1";
			Object params[]={};
			return (List<ActUser>) qr.query(sql, params, new BeanListHandler(ActUser.class));
		}catch(Exception e)
		{
			throw new DaoException(e);
		}
	}
	/**根据activityid返回ActUser实体**/
	public ActUser findById(String activityid)
	{
		try
		{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql="select * from t_activity a join t_user u on a.userid=u.userid where a.activityid=?";
			Object params[]={activityid};
			return  (ActUser) qr.query(sql, params, new BeanHandler(ActUser.class));
		}catch(Exception e)
		{
			throw new DaoException(e);
		}
	}

	/**参加活动**/
	public void addjoin(ActUser actuser)
	{
		try
		{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql ="insert into t_userjoin (activityid,userid) values(?,?)";
			Object params[]={actuser.getActivityid(),actuser.getUserid()};
			qr.update(sql, params);
		}catch(Exception e)
		{
			throw new DaoException(e);
		}
	}
	
	/**取消参加益校园活动**/
	public void cancelJoin(ActUser actuser)
	{
		try
		{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql="delete from t_userjoin where activityid=? and userid=?";
			Object params[]={actuser.getActivityid(),actuser.getUserid()};
			qr.update(sql, params);
		}catch(Exception e)
		{
			throw new DaoException(e);
		}
	}
	/**根据userid和activityid查出用户参加活动与否**/
	public boolean findJoinBy2id(ActUser actuser)
	{
		try
		{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql="select * from t_userjoin where userid=? and activityid=?";
			Object params[]={actuser.getUserid(),actuser.getActivityid()};
			ActUser actuser1 = (ActUser) qr.query(sql, params, new BeanHandler(ActUser.class));
			if(actuser1==null)
			{
				return false;
			}else
			{
				return true;
			}
		}catch(Exception e)
		{
			throw new DaoException(e);
		}
	}
	
	/**根据userid和activityid查出用户参加活动与否**/
	public ActUser findJoinByid(ActUser actuser)
	{
		try
		{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql="select * from t_userjoin where userid=? and activityid=?";
			Object params[]={actuser.getUserid(),actuser.getActivityid()};
		    return  (ActUser) qr.query(sql, params, new BeanHandler(ActUser.class));
			
		}catch(Exception e)
		{
			throw new DaoException(e);
		}
	}
	
	/**获取符合需要条件益校园活动的总记录**/
	public int getTotalRecord(String t_name,String sign)
	{
		try
		{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select count(*) from "+t_name+" where datediff((select sysdate() from dual),enddate) "+sign+" 0 ";
			long totalrecord = (Long) qr.query(sql, new ScalarHandler());
			return (int)totalrecord;
			
		}catch(Exception e)
		{
			throw new RuntimeException(e);
		}
	}
	/**把符合条件益校园的记录放在list记录里**/
	public List<ActUser> getPageData(int startindex,int pagesize,String t_name,String sign)
	{
		List list = new ArrayList();
		try
		{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql="select * from "+t_name+" a join t_user u on a.userid=u.userid where datediff((select sysdate() from dual),enddate) "+sign+" 0 order by activityid desc limit ?,?";
			Object params[] = {startindex,pagesize};
			list= (List<ActUser>) qr.query(sql, params, new BeanListHandler(ActUser.class));
			
			for(int i=0;i<list.size();i++)
			{
				ActUser actuser=(ActUser) list.get(i);
				String activityid=actuser.getActivityid();
			    int  joinnum = FindJoinNum(activityid);
			    actuser.setJoinnum(joinnum);
			}
			
		}catch(Exception e)
		{
			throw new RuntimeException(e);
		}
		
		return list;
	}
}
