package cn.itcast.web.schoolservlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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
import cn.itcast.domain.User;
import cn.itcast.service.SchoolService;
import cn.itcast.service.Impl.SchoolServiceImpl;
import cn.itcast.utils.WebUtils;


public class addActivityServlet extends HttpServlet
{

	/**发布益校园活动**/
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		User user = (User) request.getSession().getAttribute("user");
		if(user != null)
		{
			 ActUser actuser = doupload(request);
			 actuser.setActivityid(WebUtils.makeID());
			 
			 /**service**/
			 SchoolService service = new SchoolServiceImpl();
			 
			 /**dao**/
			 service.addAct(actuser);
			 
			 out.write("成功发布益校园活动");
		}else
		{
			out.write("unlogin");
		}
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		doGet(request, response);
	}
	/**上传封装到bean中**/
	private ActUser doupload(HttpServletRequest request)
	{
		ActUser actuser = new ActUser();
		User user = (User) request.getSession().getAttribute("user");
		actuser.setUserid(user.getUserid());
		
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
					BeanUtils.setProperty(actuser, name, value);
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
						actuser.setImage(savefilename);
					}else if(ext.equalsIgnoreCase("swf")||ext.equalsIgnoreCase("mp4")||ext.equalsIgnoreCase("rmvb")||ext.equalsIgnoreCase("avi"))//上传swf格式视频
					{
						System.out.println(filename);
						String savevideoname = makeFileName(filename);//得到保存在硬盘的文件名
						String savepath = this.getServletContext().getRealPath("/video");
						InputStream in = item.getInputStream();
						FileOutputStream out = new FileOutputStream(savepath + "\\" + savevideoname);
						int len = 0;
						byte buffer[] = new byte[1024];
						while((len=in.read(buffer))>0)
						{
							out.write(buffer,0,len);
						}
						in.close();
						out.close();
						item.delete();
						actuser.setVideo(savevideoname);
					}
					else
					{
						System.out.println("您上传视频格式不正确");
					}
				}
			}
			return actuser;
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
