package cn.itcast.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.ActUser;
import cn.itcast.domain.Society;
import cn.itcast.domain.User;
import cn.itcast.exception.DaoException;
import cn.itcast.utils.JdbcUtils;

public class UserDaoImpl implements UserDao
{
	/**个体用户注册**/
	public void add(User user)
	{
		try
		{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "insert into t_user(userid,username,password,email,phone,date,status,headimg) values(?,?,?,?,?,?,?,?)";
			
			Object params[] = {user.getUserid(),user.getUsername(),user.getPassword(),user.getEmail(),user.getPhone(),user.getDate(),user.getStatus(),user.getHeadimg()};
			qr.update(sql, params);
			
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}
	/**个体注册前检查**/
	public User find(String username)
	{
		
		try
		{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from t_user where username=?";
			Object params[] = {username};
			return (User) qr.query(sql, params, new BeanHandler(User.class));
		} catch (Exception e)
		{
			throw new DaoException(e);
		}
	}
	
	/**********************************个体上，社团下*************************************/
	/**社团注册**/
	public void addSoc(Society society)
	{
		try
		{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "insert into t_society(userid,socname,leadername,password,reason,email,phone,date,status,headimg) values(?,?,?,?,?,?,?,?,?,?)";
			
			Object params[] = {society.getUserid(),society.getSocname(),society.getLeadername(),society.getPassword(),society.getReason(),society.getEmail(),society.getPhone(),society.getDate(),society.getStatus(),society.getHeadimg()};
			qr.update(sql, params);
			
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}
	/**注册社团前检查**/
	public Society findSoc(String username)
	{
		
		try
		{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from t_society where socname=?";
			Object params[] = {username};
			return (Society) qr.query(sql, params, new BeanHandler(Society.class));
		} catch (Exception e)
		{
			throw new DaoException(e);
		}
	}
	
	/**登陆时查找用户**/
	public User find(String username, String password)
	{
		try
		{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from t_user where username=? and password=?";
			Object params[] = {username,password};
			return (User) qr.query(sql, params, new BeanHandler(User.class));
		} catch (Exception e)
		{
			throw new DaoException(e);
		}
	}
	
	/*********************后台管理审批社团注册申请************************************************/
	
	
	/**得到申请社团总数**/
	public int getTotalRecord(String t_name,String status)
	{
		try{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			
			String sql = "select count(*) from "+t_name+" where status="+status+" order by date desc ";
			long totalrecord = (Long) qr.query(sql, new ScalarHandler());
			return (int)totalrecord;
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**把申请社团放在list集合里**/
	public List<Society> getPageData(int startindex,int pagesize,String t_name,String status)
	{
		try
		{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql="select * from "+t_name+" where status="+status+" order by date desc limit ?,?";
			Object params[] = {startindex,pagesize};
			return (List<Society>) qr.query(sql, params, new BeanListHandler(Society.class));
			
		}catch(Exception e)
		{
			throw new RuntimeException(e);
		}
	}
	
	/**得到当前的用户总数，stauts=1为社团，为0为个人**/
	public int getNowUserTotalRecord(String t_name,String status)
	{
		try{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			
			String sql = "select count(*) from "+t_name+" where status="+status+" order by date desc ";
			long totalrecord = (Long) qr.query(sql, new ScalarHandler());
			return (int)totalrecord;
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**把当前用户放在list中status=1为社团，status=0为个人**/
	public List<User> getNowUserPageData(int startindex,int pagesize,String t_name,String status)
	{
		try
		{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql="select * from "+t_name+" where status="+status+" order by date desc limit ?,?";
			Object params[] = {startindex,pagesize};
			return (List<User>) qr.query(sql, params, new BeanListHandler(User.class));
			
		}catch(Exception e)
		{
			throw new RuntimeException(e);
		}
	}
	
	
	/**根据userid查找社团**/
	public Society updateById(String userid)
	{
		try
		{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql="update t_society set status=1 where userid=?";
			Object params[]={userid};
			qr.update(sql, params);

			String sql2 = "select * from t_society where userid=?";
			Object param[]={userid};
			return (Society) qr.query(sql2, param, new BeanHandler(Society.class));
		}catch(Exception e)
		{
			throw new RuntimeException(e);
		}
	}
	/**根据userid驳回社团申请(实质就是将其删除)**/
	public void rejectsoc(String userid)
	{
		try
		{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql="delete from t_society where userid=?";
			Object params[]={userid};
			qr.update(sql, params);
		}catch(Exception e)
		{
			throw new RuntimeException(e);
		}
	}
	
	/**根据userid在t_user清除该用户**/
	public void sweep(String userid)
	{
		try
		{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql="delete from t_user where userid=?";
			Object params[]={userid};
			qr.update(sql, params);
		}catch(Exception e)
		{
			throw new RuntimeException(e);
		}
	}
	
	//根据名字查找userid
	public String findByUsername(String username)
	{
		try
		{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select userid from t_user where username=?";
			Object params[] = {username};
			User user =  (User) qr.query(sql, params, new BeanHandler(User.class));
			return user.getUserid();
		} catch (Exception e)
		{
			throw new DaoException(e);
		}
	}
	
	/**根据userid查用户信息**/
	public User findById(String userid)
	{
		try
		{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from t_user where userid=?";
			Object params[]={userid};
			return (User) qr.query(sql, params,new BeanHandler(User.class));
		}catch(Exception e)
		{
			throw new DaoException(e);
		}
	}
	
	/**修改用户信息**/
	public void updateUserInfo(User user)
	{
		try
		{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "update t_user set username=? , password=?,phone=?,email=? where userid=?";
			Object params[]={user.getUsername(),user.getPassword(),user.getPhone(),user.getEmail(),user.getUserid()};
			qr.update(sql, params);
		}catch(Exception e)
		{
			throw new DaoException(e);
		}
	}
	
	/**用户参加益校园活动记录数**/
	public int getUserJoinActTotalRecord(String userid,String sign)
	{
		try
		{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select count(*) from t_userjoin uj join t_activity a on uj.activityid=a.activityid where uj.userid=? and  datediff((select sysdate() from dual),a.enddate) "+sign+" 0 ";
			Object params[]={userid};
			long totalrecord = (Long) qr.query(sql, params,new ScalarHandler());
			return (int)totalrecord;
			
		}catch(Exception e)
		{
			throw new RuntimeException(e);
		}
	}
	
	
	/**用户（曾经或即将）参加的益校园活动**/
	public List<ActUser> getUserJoinActPageData(int startindex,int pagesize,String userid,String sign)
	{
		List list = new ArrayList();
		try
		{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from t_user u join t_userjoin uj on u.userid=uj.userid join t_activity a on uj.activityid=a.activityid where uj.userid=? and datediff((select sysdate() from dual),a.enddate) "+sign+" 0 order by a.joindate desc limit ?,?";
			Object params[] = {userid,startindex,pagesize};
			list= (List<ActUser>) qr.query(sql, params, new BeanListHandler(ActUser.class));
			
			for(int i=0;i<list.size();i++)
			{
				ActUser actuser=(ActUser) list.get(i);
				String activityid=actuser.getActivityid();
			    int  joinnum = FindJoinNum(activityid);
			    actuser.setJoinnum(joinnum);
			}
			return list;
		}catch(Exception e)
		{
			throw new DaoException(e);
		}
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
}
