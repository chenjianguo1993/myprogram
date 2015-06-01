package cn.itcast.service;

import cn.itcast.domain.Society;
import cn.itcast.domain.User;
import cn.itcast.exception.UserExistException;

public interface RegisterAndLoginService
{
	/**个体注册**/
	void registerUser(User user) throws UserExistException ;
	
	/**用户登陆**/
	public User login(String username,String password);
	
	/*****************上面个体，下面社团************************************/
	
	/**社团注册**/
	void registerSociety(Society society)throws UserExistException ;
	
}
