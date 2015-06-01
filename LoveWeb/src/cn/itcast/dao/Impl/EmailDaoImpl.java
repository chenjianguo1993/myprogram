package cn.itcast.dao.Impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.dao.EmailDao;
import cn.itcast.domain.Email;
import cn.itcast.domain.ShowEmail;
import cn.itcast.exception.DaoException;
import cn.itcast.utils.JdbcUtils;

public class EmailDaoImpl implements EmailDao
{
	/**发送私信**/
	public void addEmail(Email email)
	{
		try
		{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "insert into t_email(userid1,userid2,content,sendtime,flag) values(?,?,?,?,?)";
			Object params[] = {email.getUserid1(),email.getUserid2(),email.getContent(),email.getSendtime(),email.getFlag()};
			qr.update(sql,params);
		} catch (Exception e)
		{
			throw new DaoException(e);
		}
	}
	
	/* (non-Javadoc)
	 * 查找已读或者未读私信
	 */
	public List<ShowEmail> findEmail(String userid2,String flag,int startNum)
	{
		try
		{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from t_email e join t_user u on e.userid1=u.userid where userid1=? and flag = ? limit ?,5 ";
			
			Object params[] = {userid2,flag,startNum};
			return (List<ShowEmail>) qr.query(sql,params,new BeanListHandler(ShowEmail.class));
		} catch (Exception e)
		{
			throw new DaoException(e);
		}
	}
	
	/**查找已发私信**/
	public List<ShowEmail> findSendedEmail(String userid2,int startNum)
	{
		try
		{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from t_email e join t_user u on e.userid1=u.userid where userid2=? limit ?,5 ";
			
			Object params[] = {userid2,startNum};
			return (List<ShowEmail>) qr.query(sql,params,new BeanListHandler(ShowEmail.class));
		} catch (Exception e)
		{
			throw new DaoException(e);
		}
	}
	
	/* (non-Javadoc)
	 * @see cn.itcast.dao.Impl.EmailDao#updateEmailFlag(java.lang.String)
	 */
	public void updateEmailFlag(String emailid)
	{
		try
		{
			int id = Integer.parseInt(emailid);
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "update t_email set flag=2 where emailid=?";
			qr.update(sql,id);
		} catch (Exception e)
		{
			throw new DaoException(e);
		}
	}
	
	
}
