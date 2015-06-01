package cn.itcast.utils;

import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class WebUtils {
	
	/**把request对象中的请求参数封装到bean中**/
	public static <T> T request2Bean(HttpServletRequest request,Class<T> clazz)
	{
		try
		{
			T bean = clazz.newInstance();
			ConvertUtils.register(new DateLocaleConverter(), Date.class);
			Enumeration e = request.getParameterNames(); 
			
			while(e.hasMoreElements())
			{
				String name = (String) e.nextElement();  //username=aaa password=123
				String value = request.getParameter(name);
				BeanUtils.setProperty(bean, name, value);
			}
			return bean;
			
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		} 
	}
	/**UUID算法**/
	public static String makeID(){
		return UUID.randomUUID().toString();
	}
	/**getBASE64算法(编码)**/
	public static String getBASE64(String message) {

		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(message.getBytes());

	}
	/**getFromBASE64算法(解码)**/
	public static String getFromBASE64(String s)
	{
		if (s == null) 
		{
			return null;
		}
		BASE64Decoder decoder = new BASE64Decoder();
		
		byte[] b=null;
		try
		{
			b = decoder.decodeBuffer(s);
		} catch (IOException e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return new String(b);
		
	}
}
