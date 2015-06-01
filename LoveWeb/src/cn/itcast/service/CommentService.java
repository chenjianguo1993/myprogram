package cn.itcast.service;

import java.util.List;

import cn.itcast.domain.Comment;

public interface CommentService
{

	/**添加评论**/
	public abstract void addcomment(Comment comment);

	/**根据activityid拿评论**/
	public List<Comment> FindByActid(String activityid);
	
	/**根据commentid拿评论**/
	public Comment FindByComid(String commentid);
}