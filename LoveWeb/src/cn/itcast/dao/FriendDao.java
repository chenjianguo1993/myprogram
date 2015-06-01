package cn.itcast.dao;

import java.util.List;

import cn.itcast.domain.Friend;

public interface FriendDao
{

	/**添加好友**/
	void addFriend(Friend f);

	/**删除好友**/
	void deleteFriend(Friend f);
	
	/**查找好友**/
	public Friend findFriend(Friend f);
	
	/**查找好友**/
	public List<Friend> findbyId2(String userid2);

}