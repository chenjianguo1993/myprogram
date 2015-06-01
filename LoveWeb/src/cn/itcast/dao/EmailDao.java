package cn.itcast.dao;

import java.util.List;

import cn.itcast.domain.Email;
import cn.itcast.domain.ShowEmail;

public interface EmailDao
{

	/**发送私信**/
	void addEmail(Email email);

	/**通过userid2和flag查找私信**/
	List<ShowEmail> findEmail(String userid2, String flag,int startNum);

	/**通过emailid查找私信**/
	void updateEmailFlag(String emailid);
	
	/**查找已发私信**/
	List<ShowEmail> findSendedEmail(String userid2,int startNum);

}