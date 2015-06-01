package cn.itcast.web.UI;

import java.io.IOException;
import java.net.InetAddress;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import cn.itcast.domain.ActUser;
import cn.itcast.domain.LostUser;
import cn.itcast.service.LostService;
import cn.itcast.service.SchoolService;
import cn.itcast.service.VolunService;
import cn.itcast.service.Impl.LostServiceImpl;
import cn.itcast.service.Impl.SchoolServiceImpl;
import cn.itcast.service.Impl.VolunServiceImpl;

public class PhoneIndexUIServlet extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String userid="562e28f5-4076-4f96-a6b9-506aa166a84b";
		
		InetAddress address = InetAddress.getLocalHost(); 

//		String ip=address.getHostAddress();
		String ip="192.168.191.1";
		System.out.print(ip);
		
		/**拿出益校园活动的一条记录**/
		SchoolService sservice = new SchoolServiceImpl();
		List<ActUser> new2alist = sservice.New2Act(userid);
		ActUser activity = new2alist.get(0);
		StringBuffer str= new StringBuffer();
		
		
		String  ajson = "[{\"img\":\"http://"+ip+":8080/LoveWeb/image/"+activity.getImage()+"\",\"name\":\""+activity.getName()+"\",\"id\":\""+activity.getActivityid()+"\",\"description\":\""+activity.getDescription()+"\",\"count\":"+activity.getJoinnum()+"}";
		str.append(ajson).append(",");

		
		
		/**拿出志愿者活动的一条记录**/
		VolunService vservice = new VolunServiceImpl();
		List<ActUser> new2vlist= vservice.New2Act(userid);
		ActUser vactivity = new2vlist.get(0);
		
		String  vjson = "{\"img\":\"http://"+ip+":8080/LoveWeb/image/"+vactivity.getImage()+"\",\"name\":\""+vactivity.getName()+"\",\"id\":\""+vactivity.getActivityid()+"\",\"description\":\""+vactivity.getDescription()+"\",\"count\":"+vactivity.getJoinnum()+"}";
		str.append(vjson).append(",");

		
		/**拿出失物招认领的一条记录**/
		LostService lservice = new LostServiceImpl();
		List<LostUser> new2llist  = lservice.New2Act("renling");
		LostUser lost = new2llist.get(0);
		String  ljson =  "{\"img\":\"http://"+ip+":8080/LoveWeb/image/"+lost.getImage()+"\",\"name\":\""+lost.getLostname()+"\",\"id\":\""+lost.getLostid()+"\",\"description\":\""+lost.getDescription()+"\",\"count\":"+1+"}]";
		str.append(ljson);
		
		
		
		
		response.getWriter().write(str.toString());
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		doGet(request, response);
	}

}
