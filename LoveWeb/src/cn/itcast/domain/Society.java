package cn.itcast.domain;

import java.util.Date;

public class Society
{
	private String userid;
	private String socname;
	private String leadername;
	private String password;
	private String reason;
	private String  phone;
	private String email;
	private Date date;
	private int  status;
	private String headimg;
	
	public String getHeadimg()
	{
		return headimg;
	}
	public void setHeadimg(String headimg)
	{
		this.headimg = headimg;
	}
	public String getUserid()
	{
		return userid;
	}
	public void setUserid(String userid)
	{
		this.userid = userid;
	}
	
	public String getSocname()
	{
		return socname;
	}
	public void setSocname(String socname)
	{
		this.socname = socname;
	}
	public String getLeadername()
	{
		return leadername;
	}
	public void setLeadername(String leadername)
	{
		this.leadername = leadername;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getReason()
	{
		return reason;
	}
	public void setReason(String reason)
	{
		this.reason = reason;
	}
	public String getPhone()
	{
		return phone;
	}
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public Date getDate()
	{
		return date;
	}
	public void setDate(Date date)
	{
		this.date = date;
	}
	public int getStatus()
	{
		return status;
	}
	public void setStatus(int status)
	{
		this.status = status;
	}
	
}
