package cn.itcast.service.Impl;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.Impl.UserDaoImpl;
import cn.itcast.domain.Society;
import cn.itcast.domain.User;
import cn.itcast.exception.UserExistException;
import cn.itcast.service.RegisterAndLoginService;

public class RegisterAndLoginServiceImpl implements RegisterAndLoginService
{

	UserDao udao = new UserDaoImpl();
	public User loginUser(String username, String password)
	{
		return null;
	}

	/**个体用户注册**/
	public void registerUser(User user) throws UserExistException
	{
		if(udao.find(user.getUsername())!=null){
			
			throw new UserExistException("注册的用户名已存在！！！");
		}
		
		udao.add(user);
	}
	/**用户登陆**/
	public User login(String username,String password)
	{
		return udao.find(username, password);
	}

	/*******************上面个体，下面社团**************************************/
	
	/**社团注册
	 * @throws UserExistException 
	 * @throws Exception 
	 * @throws Exception **/
	public void registerSociety(Society society) throws UserExistException 
	{
		if(udao.findSoc(society.getSocname())!=null){
			
			throw new UserExistException("注册的用户名已存在！！！");
		}
		
		udao.addSoc(society);
	}
	

}
