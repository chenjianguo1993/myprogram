package cn.itcast.dao.Impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.dao.CommentDao;
import cn.itcast.domain.ActUser;
import cn.itcast.domain.Comment;
import cn.itcast.exception.DaoException;
import cn.itcast.utils.JdbcUtils;

public class CommentDaoImpl implements CommentDao
{
	/* (non-Javadoc)
	 * @see cn.itcast.dao.Impl.CommentDao#findByActid(java.lang.String)
	 */
	public List<Comment> findByActid(String activityid)
	{
		try
		{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql="select c.*,u.username,u.headimg from t_comment c join t_user u on c.userid=u.userid  where activityid=?";
			Object params[]={activityid};
			return (List<Comment>) qr.query(sql, params, new BeanListHandler(Comment.class));
		}catch(Exception e)
		{
			throw new DaoException(e);
		}
	}
	/**根据commentid拿评论**/
	public Comment findByComid(String commentid)
	{
		try
		{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql="select c.*,u.username,u.headimg from t_comment c join t_user u on c.userid=u.userid  where commentid=?";
			Object params[]={commentid};
			return (Comment) qr.query(sql, params, new BeanHandler(Comment.class));
		}catch(Exception e)
		{
			throw new DaoException(e);
		}
	}
	
	
	/* (non-Javadoc)
	 * @see cn.itcast.dao.Impl.CommentDao#addComment(cn.itcast.domain.Comment)
	 */
	public void addComment(Comment comment)
	{
		try
		{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql="insert into t_comment (commentid,commentContext,commentdate,userid,activityid) values(?,?,?,?,?)";
			Object params[]={comment.getCommentid(),comment.getCommentContext(),comment.getCommentdate(),comment.getUserid(),comment.getActivityid()};
			qr.update(sql, params);
		}catch(Exception e)
		{
			throw new DaoException(e);
		}
	}
}
