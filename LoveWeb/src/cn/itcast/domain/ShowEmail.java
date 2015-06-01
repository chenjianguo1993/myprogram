package cn.itcast.domain;

import java.util.Date;

public class ShowEmail
{
	private String emailid;
	private String userid1;
	private String username;
	private String content;
	private Date sendtime;
	private int sended;
	private int readed;
	private int unread;
	private String flag;
	
	
	
	public String getFlag()
	{
		return flag;
	}
	public void setFlag(String flag)
	{
		this.flag = flag;
	}
	public String getEmailid()
	{
		return emailid;
	}
	public void setEmailid(String emailid)
	{
		this.emailid = emailid;
	}
	public String getUserid1()
	{
		return userid1;
	}
	public void setUserid1(String userid1)
	{
		this.userid1 = userid1;
	}
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getContent()
	{
		return content;
	}
	public void setContent(String content)
	{
		this.content = content;
	}
	public Date getSendtime()
	{
		return sendtime;
	}
	public void setSendtime(Date sendtime)
	{
		this.sendtime = sendtime;
	}
	public int getSended()
	{
		return sended;
	}
	public void setSended(int sended)
	{
		this.sended = sended;
	}
	public int getReaded()
	{
		return readed;
	}
	public void setReaded(int readed)
	{
		this.readed = readed;
	}
	public int getUnread()
	{
		return unread;
	}
	public void setUnread(int unread)
	{
		this.unread = unread;
	}
}
