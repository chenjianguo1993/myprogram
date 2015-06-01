package cn.itcast.service.Impl;

import java.util.List;

import cn.itcast.dao.EmailDao;
import cn.itcast.dao.Impl.EmailDaoImpl;
import cn.itcast.domain.Email;
import cn.itcast.domain.ShowEmail;
import cn.itcast.service.EmailService;

public class EmailServiceImpl implements EmailService
{
	EmailDao edao = new EmailDaoImpl();
	
	/**发送私信**/
	public void addEmail(Email e)
	{
		edao.addEmail(e);
	}
	
	/**查找未读私信**/
	 
	public List<ShowEmail> findAndUpdate(String userid2,String flag,int startNum)
	{
		List<ShowEmail> list = edao.findEmail(userid2, flag,startNum);
		for (ShowEmail e : list)
		{
			edao.updateEmailFlag(e.getEmailid());
		}
		return list;
	}
	
	//查找已读私信
	public List<ShowEmail> findReaded(String userid2,String flag,int startNum)
	{
		return edao.findEmail(userid2, flag,startNum);
	}
	
	//查找已发私信
	public List<ShowEmail> findSendedEmail(String userid2,int startNum)
	{
		List<ShowEmail> list = edao.findSendedEmail(userid2,startNum);
		return list;
	}
}
