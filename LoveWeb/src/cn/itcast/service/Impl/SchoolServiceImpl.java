package cn.itcast.service.Impl;

import java.util.ArrayList;
import java.util.List;

import cn.itcast.dao.SchoolDao;
import cn.itcast.dao.Impl.SchoolDaoImpl;
import cn.itcast.domain.ActUser;
import cn.itcast.domain.Page;
import cn.itcast.service.SchoolService;

public class SchoolServiceImpl implements SchoolService
{
	SchoolDao sdao = new SchoolDaoImpl();
	
	/**发布益校园活动**/
	public void addAct(ActUser actuser)
	{
		sdao.add(actuser);
	}
	
	/**最新俩条益校园活动**/
	public List<ActUser> New2Act(String userid)
	{
		List<ActUser> list = new ArrayList();
		list = sdao.new2Act();
		if(userid!=null){
			for (ActUser actUser : list)
			{	
				actUser.setUserid(userid);
				boolean b = sdao.findJoinBy2id(actUser);
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
	
	/**最热门的俩条益校园活动**/
	public List<ActUser> pop2Act(String userid)
	{
		List list2id =new ArrayList();
		List<ActUser> list2= new ArrayList<ActUser>();
		list2id = sdao.Popluar2Act();
		if(list2id.size()==0){
			return null;
		}
		for(int i=0;i<list2id.size();i++)
		{
			ActUser actuser = (ActUser) list2id.get(i);
			String activityid = actuser.getActivityid();
			ActUser actuser2 =sdao.findById(activityid);
			int joinnum = sdao.FindJoinNum(activityid);
			actuser2.setJoinnum(joinnum);
			list2.add(actuser2);
		}
		if(userid!=null){
			for (ActUser actUser : list2)
			{
				actUser.setUserid(userid);
				boolean b = sdao.findJoinBy2id(actUser);
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
		return sdao.findJoinBy2id(actuser);
		
	}
	
	/**根据activityid 拿参加人数**/
	public int findJoinNum(String activityid)
	{
		return sdao.FindJoinNum(activityid);
	}
	
	/**取消参加活动**/
	public void CancelJoin(ActUser actuser)
	{
		sdao.cancelJoin(actuser);
	}
	/**参加报名**/
	public void AddJoin(ActUser actuser)
	{
		sdao.addjoin(actuser);
	}
	
	/**获取益校园活动分页数据**/
	public Page getActivityPageData(String pagenum,String url,String t_name,String sign)
	{
		int totalrecord = sdao.getTotalRecord(t_name,sign);
		Page page = null;
		if(pagenum==null)
		{
			page = new Page(1,totalrecord);
		}else
		{
			page = new Page(Integer.parseInt(pagenum),totalrecord);
		}
		List list = sdao.getPageData(page.getStartindex(), page.getPagesize(),t_name,sign);
		page.setList(list);
		page.setUrl(url);
		
		return page;
	}
	/**根据activityid拿出ActUser**/
	public ActUser findByActId(String activityid)
	{
		ActUser actuser = sdao.findById(activityid);
		actuser.setJoinnum(sdao.FindJoinNum(activityid));
		return actuser;
	}
}
