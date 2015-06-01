package cn.itcast.web.formbean;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

public class RegisterFormBean
{
	private String username;
	private String password;
	private String password2;
	private String  phone;
	private String email;
	private String imagefont;
	
	
	
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getPassword2()
	{
		return password2;
	}
	public void setPassword2(String password2)
	{
		this.password2 = password2;
	}
	public String getPhone()
	{
		return phone;
	}
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getImagefont()
	{
		return imagefont;
	}
	public void setImagefont(String imagefont)
	{
		this.imagefont = imagefont;
	}
	
	
	//这是一个专门用来收集错误的HashMap
	private Map<String,String> errors = new HashMap();
	
	
	public Map<String, String> getErrors() {
		return errors;
	}
	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}
	
	/*
	private String username;  用户名不能为空，并且要是3-8的字符 abcdABcd
	private String password;  密码不能为空，并且要是3-8的数字
	private String password2; 两次密码要一致
	private String  phone;  电话号码要正确
	private String email;     可以为空，不为空要是一个合法的邮箱
	 * 
	 */
	public boolean validate(StringBuffer sb)
	{
		boolean isOk = true;
		
		//检查用户名
		if(this.username==null || this.username.trim().equals("") ){
			isOk = false;
			errors.put("username", "用户名不能为空！！");
		}/*else{
			if(!this.username.matches("[a-zA-Z]{3,8}")){
				isOk = false;
				errors.put("username", "用户名必须是3-8位的字母！！");
			}
		}*/
		
		
		//检查密码
		if(this.password==null || this.password.trim().equals("")){
			isOk = false;
			errors.put("password", "密码不能为空！！");
		}else{
			if(!this.password.matches("\\d{3,8}")){
				isOk = false;
				errors.put("password", "密码必须是3-8位的数字！！");
			}
		}
		
		//private String password2; 两次密码要一致
		if(this.password2!=null){
			if(!this.password2.equals(this.password)){
				isOk = false;
				errors.put("password2", "两次密码不一致！！");
			}
		}
		//检查电话号码
		if(this.phone !=null)
		{
			if(!this.phone.matches("^[1][3-8]\\d{9}$")){
				isOk = false;
				errors.put("phone", "电话号码不是一个合法的！！");
			}
		}
		//检查邮箱
		//private String email;     可以为空，不为空要是一个合法的邮箱
		// flx_itcast@sina.com.cn
		if(this.email!=null){
			if(!this.email.matches("\\w+@\\w+(\\.\\w+)+")){
				isOk = false;
				errors.put("email", "邮箱不是一个合法邮箱！！");
			}
		}
		//检查验证码
		if(this.imagefont == null||this.imagefont.trim().equals(""))
		{
			isOk = false;
			errors.put("imagefont", "验证码不能为空！！");
			
		}else if(!sb.toString().equals(this.imagefont))
		{
			isOk = false;
			errors.put("imagefont", "验证码不是一个符合！！");
		}
		
		return isOk;
	}
}
