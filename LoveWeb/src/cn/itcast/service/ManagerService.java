package cn.itcast.service;

import cn.itcast.domain.Page;

public interface ManagerService
{

	/**获取申请社团分页数据**/
	public abstract Page getBookPageData(String pagenum, String url,
			String t_name,String status);
	/**批准社团申请**/
	public void AgreeSoc(String userid);
	
	/**根据userid驳回社团申请(实质就是将其删除)**/
	public void disagree(String userid);
	
	/**根据userid清除该用户**/
	public void Sweep(String userid);
}