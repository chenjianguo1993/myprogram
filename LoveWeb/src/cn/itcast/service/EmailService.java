package cn.itcast.service;

import java.util.List;

import cn.itcast.domain.Email;
import cn.itcast.domain.ShowEmail;

public interface EmailService
{

	/**发送私信**/
	void addEmail(Email e);

	/**查找和修改**/
	List<ShowEmail> findAndUpdate(String userid2, String flag,int startNum);
	
	//查找已发
	List<ShowEmail> findSendedEmail(String userid2,int startNum);
	
	//查找已读私信
	List<ShowEmail> findReaded(String userid2,String flag,int startNum);

}