package cn.itcast.dao;

import java.util.List;

import cn.itcast.domain.Comment;

public interface CommentDao
{

	/**根据activityid拿评论bean**/
	public abstract List<Comment> findByActid(String activityid);

	/**增加评论**/
	public abstract void addComment(Comment comment);
	
	/**根据commentid拿评论**/
	public Comment findByComid(String commentid);

}