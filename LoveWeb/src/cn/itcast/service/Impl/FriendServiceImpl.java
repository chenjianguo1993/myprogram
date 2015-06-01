package cn.itcast.service.Impl;

import java.util.List;

import cn.itcast.dao.FriendDao;
import cn.itcast.dao.Impl.FriendDaoImpl;
import cn.itcast.domain.Friend;
import cn.itcast.service.FriendService;

public class FriendServiceImpl implements FriendService
{
	FriendDao fdao = new FriendDaoImpl();
	
	/* (non-Javadoc)
	 * @see cn.itcast.service.Impl.FriendService#addFriend(cn.itcast.domain.Friend)
	 */
	public void addFriend(Friend f){
		fdao.addFriend(f);
	}
	
	/* (non-Javadoc)
	 * @see cn.itcast.service.Impl.FriendService#deleteFriend(cn.itcast.domain.Friend)
	 */
	public void deleteFriend(Friend f){
		fdao.deleteFriend(f);
	}
	
	/**查找好友**/
	public Friend findFriend(Friend f){
		return fdao.findFriend(f);
	}
	
	/**查找好友**/
	public List<Friend> findbyId2(String userid2){
		return fdao.findbyId2(userid2);
	}
}
