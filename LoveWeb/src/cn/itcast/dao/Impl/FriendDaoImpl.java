package cn.itcast.dao.Impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.dao.FriendDao;
import cn.itcast.domain.Comment;
import cn.itcast.domain.Friend;
import cn.itcast.exception.DaoException;
import cn.itcast.utils.JdbcUtils;

public class FriendDaoImpl implements FriendDao
{
	/* (non-Javadoc)
	 * @see cn.itcast.dao.Impl.FriendDao#addFriend(cn.itcast.domain.Friend)
	 */
	public void addFriend(Friend f)
	{
		try
		{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql="insert into t_friend(userid1,userid2) values(?,?)";
			Object params[]={f.getUserid1(),f.getUserid2()};
			qr.update(sql,params);
		}catch(Exception e)
		{
			throw new DaoException(e);
		}
	}
	
	/* (non-Javadoc)
	 * @see cn.itcast.dao.Impl.FriendDao#deleteFriend(cn.itcast.domain.Friend)
	 */
	public void deleteFriend(Friend f){
		try
		{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql="delete from t_friend where userid1=? and userid2=?";
			Object params[]={f.getUserid1(),f.getUserid2()};
			qr.update(sql,params);
		}catch(Exception e)
		{
			throw new DaoException(e);
		}
	}
	
	/**查找好友**/
	public Friend findFriend(Friend f){
		try
		{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql="select * from t_friend where userid1=? and userid2=?";
			Object params[]={f.getUserid1(),f.getUserid2()};
			return (Friend) qr.query(sql, params, new BeanHandler(Friend.class));
		}catch(Exception e)
		{
			throw new DaoException(e);
		}
	}
	

	/**查找好友**/
	public List<Friend> findbyId2(String userid2){
		try
		{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql="select * from t_friend f join t_user u on u.userid = f.userid1 where userid2=?";
			return (List<Friend>) qr.query(sql, userid2, new BeanListHandler(Friend.class));
		}catch(Exception e)
		{
			throw new DaoException(e);
		}
	}
}
