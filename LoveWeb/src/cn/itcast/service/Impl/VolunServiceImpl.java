package cn.itcast.service.Impl;

import java.util.ArrayList;
import java.util.List;

import cn.itcast.dao.VolunDao;
import cn.itcast.dao.Impl.VolunDaoImpl;
import cn.itcast.domain.ActUser;
import cn.itcast.domain.Page;
import cn.itcast.service.VolunService;

public class VolunServiceImpl implements VolunService
{
	VolunDao vdao = new VolunDaoImpl();
	
	/**发布志愿者活动**/
	public void addAct(ActUser actuser)
	{
		vdao.add(actuser);
	}
	
	/**最新俩条志愿者活动**/
	public List<ActUser> New2Act(String userid)
	{
		List<ActUser> list = new ArrayList();
		list = vdao.new2Act();
		if(userid!=null){
			for (ActUser actUser : list)
			{	
				actUser.setUserid(userid);
				boolean b = vdao.findJoinBy2id(actUser);
				if(b)
				{
					actUser.setFlag("true");
				}else
				{
					actUser.setFlag("false");
				}
				
			}
		}
		return list;
	}
	
	/**最热门的俩条志愿者活动**/
	public List<ActUser> pop2Act(String userid)
	{
		List list2id =new ArrayList();
		List<ActUser> list2= new ArrayList<ActUser>();
		list2id = vdao.Popluar2Act();
		if(list2id.size()==0){
			return null;
		}
		for(int i=0;i<list2id.size();i++)
		{
			ActUser actuser = (ActUser) list2id.get(i);
			String activityid = actuser.getActivityid();
			ActUser actuser2 =vdao.findById(activityid);
			int joinnum = vdao.FindJoinNum(activityid);
			actuser2.setJoinnum(joinnum);
			list2.add(actuser2);
		}
		if(userid!=null){
			for (ActUser actUser : list2)
			{
				actUser.setUserid(userid);
				boolean b = vdao.findJoinBy2id(actUser);
				if(b)
				{
					actUser.setFlag("true");
				}else
				{
					actUser.setFlag("false");
				}
				
			}
		}
		return list2;
	}
	
	/**查找参加或取消报名**/
	public boolean findjoinAct(ActUser actuser)
	{
		return vdao.findJoinBy2id(actuser);
		
	}
	
	/**根据activityid 拿参加人数**/
	public int findJoinNum(String activityid)
	{
		return vdao.FindJoinNum(activityid);
	}
	
	/**取消参加活动**/
	public void CancelJoin(ActUser actuser)
	{
		vdao.cancelJoin(actuser);
	}
	
	/**参加报名**/
	public void AddJoin(ActUser actuser)
	{
		vdao.addjoin(actuser);
	}
	
	/**获取志愿者活动分页数据**/
	public Page getActivityPageData(String pagenum,String url,String t_name,String sign)
	{
		int totalrecord = vdao.getTotalRecord(t_name,sign);
		Page page = null;
		if(pagenum==null)
		{
			page = new Page(1,totalrecord);
		}else
		{
			page = new Page(Integer.parseInt(pagenum),totalrecord);
		}
		List list = vdao.getPageData(page.getStartindex(), page.getPagesize(),t_name,sign);
		page.setList(list);
		page.setUrl(url);
		
		return page;
	}
	
	/**根据activityid拿出ActUser**/
	public ActUser findByActId(String activityid)
	{
		ActUser actuser = vdao.findById(activityid);
		actuser.setJoinnum(vdao.FindJoinNum(activityid));
		return actuser;
	}
	
}
