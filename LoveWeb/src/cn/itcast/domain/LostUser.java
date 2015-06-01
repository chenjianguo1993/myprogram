package cn.itcast.domain;

import java.util.Date;

public class LostUser
{
	private String lostid;
	private String lostname;
	private String losttype;
	private Date reledate;
	private String image;
	private String description;
	
	private String userid;
	private String username;
	private String password;
	private String  phone;
	private String email;
	
	
	public String getLostid()
	{
		return lostid;
	}
	public void setLostid(String lostid)
	{
		this.lostid = lostid;
	}
	public String getLostname()
	{
		return lostname;
	}
	public void setLostname(String lostname)
	{
		this.lostname = lostname;
	}
	public String getLosttype()
	{
		return losttype;
	}
	public void setLosttype(String losttype)
	{
		this.losttype = losttype;
	}
	public Date getReledate()
	{
		return reledate;
	}
	public void setReledate(Date reledate)
	{
		this.reledate = reledate;
	}
	
	public String getImage()
	{
		return image;
	}
	public void setImage(String image)
	{
		this.image = image;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public String getUserid()
	{
		return userid;
	}
	public void setUserid(String userid)
	{
		this.userid = userid;
	}
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
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
	
}
