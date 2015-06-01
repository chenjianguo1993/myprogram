package cn.itcast.domain;

import java.util.Date;

public class Email
{
	private String userid1;
	private String userid2;
	private String content;
	private Date sendtime;
	private String flag;
	
	public String getFlag()
	{
		return flag;
	}
	public void setFlag(String flag)
	{
		this.flag = flag;
	}
	public String getUserid1()
	{
		return userid1;
	}
	public void setUserid1(String userid1)
	{
		this.userid1 = userid1;
	}
	public String getUserid2()
	{
		return userid2;
	}
	public void setUserid2(String userid2)
	{
		this.userid2 = userid2;
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
	
}
