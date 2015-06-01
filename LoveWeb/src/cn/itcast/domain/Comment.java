package cn.itcast.domain;

import java.util.Date;

public class Comment
{
	private String  commentid;
	private String userid;
	private String  activityid;
	private String commentContext;
	private Date commentdate;
	private String username;
	private String headimg;
	
	public String getHeadimg()
	{
		return headimg;
	}
	public void setHeadimg(String headimg)
	{
		this.headimg = headimg;
	}
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public String getCommentid()
	{
		return commentid;
	}
	public void setCommentid(String commentid)
	{
		this.commentid = commentid;
	}
	public String getUserid()
	{
		return userid;
	}
	public void setUserid(String userid)
	{
		this.userid = userid;
	}
	
	public String getActivityid()
	{
		return activityid;
	}
	public void setActivityid(String activityid)
	{
		this.activityid = activityid;
	}
	public String getCommentContext()
	{
		return commentContext;
	}
	public void setCommentContext(String commentContext)
	{
		this.commentContext = commentContext;
	}
	public Date getCommentdate()
	{
		return commentdate;
	}
	public void setCommentdate(Date commentdate)
	{
		this.commentdate = commentdate;
	}
}
