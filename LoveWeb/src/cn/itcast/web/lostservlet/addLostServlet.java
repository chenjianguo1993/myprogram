package cn.itcast.web.lostservlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.itcast.domain.ActUser;
import cn.itcast.domain.LostUser;
import cn.itcast.domain.User;
import cn.itcast.service.LostService;
import cn.itcast.service.VolunService;
import cn.itcast.service.Impl.LostServiceImpl;
import cn.itcast.service.Impl.VolunServiceImpl;
import cn.itcast.utils.WebUtils;

public class addLostServlet extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		User user = (User) request.getSession().getAttribute("user");
		if(user != null)
		{
			 LostUser lostuser = doupload(request);
			 lostuser.setLostid(WebUtils.makeID());
			 
			 /**service**/
			 LostService service = new LostServiceImpl();
			 /**dao**/
			 service.addLost(lostuser);
			 
			 response.getWriter().write("成功发布失物招认领");
		}else
		{
			response.getWriter().write("unlogin");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		doGet(request, response);
	}
	
	/**上传封装到bean中**/
	private LostUser doupload(HttpServletRequest request)
	{
		LostUser lostuser = new LostUser();
		User user = (User) request.getSession().getAttribute("user");
		lostuser.setUserid(user.getUserid());
		
		/**beanutils注册日期转换器**/
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		
		try
		{
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setSizeMax(1024*1024*50);//设置最大的允许的一个请求
			upload.setFileSizeMax(1024*1024*20);//设置上传文件的最大为20M
			
			List<FileItem> list = upload.parseRequest(request);
			
			for(FileItem item : list)
			{
				/**普通文本域**/
				if(item.isFormField())
				{
					String name = item.getFieldName();
					String value = item.getString("UTF-8");
					BeanUtils.setProperty(lostuser, name, value);
				}else
				{
					String filename = item.getName();
					String ext = filename.substring(filename.lastIndexOf(".")+1);//文件后缀名
					
					/**上传的是图片**/
					if(ext.equals("jpeg")||ext.equals("jpg")||ext.equals("bmp")||ext.equals("gif")||ext.equals("png"))
					{
						System.out.println(filename);
						String savefilename = makeFileName(filename);//得到保存在硬盘的文件名
						String savepath = this.getServletContext().getRealPath("/image");
						InputStream in = item.getInputStream();
						FileOutputStream out = new FileOutputStream(savepath + "\\" + savefilename);
						int len = 0;
						byte buffer[] = new byte[1024];
						while((len=in.read(buffer))>0)
						{
							out.write(buffer,0,len);
						}
						in.close();
						out.close();
						item.delete();
						lostuser.setImage(savefilename);
					}
				}
			}
			return lostuser;
		}catch(Exception e)
		{
			throw new RuntimeException(e);
		}
	}
	/**用UUID+后缀名做为图片名**/
	public String makeFileName(String filename){
		String ext = filename.substring(filename.lastIndexOf("."));//文件后缀名
		return UUID.randomUUID().toString() + ext;
	}

}
