package cn.itcast.service.Impl;

import java.util.List;

import cn.itcast.dao.CommentDao;
import cn.itcast.dao.Impl.CommentDaoImpl;
import cn.itcast.domain.Comment;
import cn.itcast.service.CommentService;

public class CommentServiceImpl implements CommentService
{
	CommentDao cdao = new CommentDaoImpl();
	
	/* (non-Javadoc)
	 * @see cn.itcast.service.Impl.CommentService#addcomment(cn.itcast.domain.Comment)
	 */
	public void addcomment(Comment comment)
	{
		cdao.addComment(comment);
	}
	
	/**根据activityid拿评论**/
	public List<Comment> FindByActid(String activityid)
	{
		return cdao.findByActid(activityid);
	}
	
	
	/**根据commentid拿评论**/
	public Comment FindByComid(String commentid)
	{
		return cdao.findByComid(commentid);
	}
	
}
