package cn.itcast.domain;

import java.io.Serializable;
import java.util.Date;

public class ActUser implements Serializable
{
	private String  activityid;
	private String name;
	private Date  startdate;
	private Date  enddate;
	private Date joindate;
	private String address;
	private String image;//记住图片的名称
	private String video;//记住视频名称
	private String description;
	
	private String userid;
	private String username;
	private String password;
	private String  phone;
	private String email;
	private int joinnum;
	private String flag;//标记
	private String headimg;
	
	public String getHeadimg()
	{
		return headimg;
	}
	public void setHeadimg(String headimg)
	{
		this.headimg = headimg;
	}
	public String getFlag()
	{
		return flag;
	}
	public void setFlag(String flag)
	{
		this.flag = flag;
	}
	public String getActivityid()
	{
		return activityid;
	}
	public void setActivityid(String activityid)
	{
		this.activityid = activityid;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public Date getStartdate()
	{
		return startdate;
	}
	public void setStartdate(Date startdate)
	{
		this.startdate = startdate;
	}
	public Date getEnddate()
	{
		return enddate;
	}
	public void setEnddate(Date enddate)
	{
		this.enddate = enddate;
	}
	public Date getJoindate()
	{
		return joindate;
	}
	public void setJoindate(Date joindate)
	{
		this.joindate = joindate;
	}
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public String getImage()
	{
		return image;
	}
	public void setImage(String image)
	{
		this.image = image;
	}
	public String getVideo()
	{
		return video;
	}
	public void setVideo(String video)
	{
		this.video = video;
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
	public int getJoinnum()
	{
		return joinnum;
	}
	public void setJoinnum(int joinnum)
	{
		this.joinnum = joinnum;
	}
	
	
}
