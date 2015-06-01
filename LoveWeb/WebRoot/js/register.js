
 function sturegister(){
	
	$.post("/LoveWeb/servlet/RegisterServlet?method=Sturegister", $("#sturegister").serialize(),//这是form的 id
	  function( data ) {
			if(data == "注册成功"){
				alert("恭喜您注册成功！");
				window.location.href='/LoveWeb/servlet/IndexUIServlet';
			}else{
				alert("对不起,该用户名已存在,请重试!");
			}
	  });	
	return false;
 }	
 function show1(){
	 
	 $.post("/LoveWeb/servlet/RegisterServlet?method=Socregister", $("#socregister").serialize(),//这是form的 id
			 function( data ) {
		 if(data == "注册成功"){
			 alert("您的注册申请我们已经收到,请在俩小时内等待审批结果!");
			 window.location.href='/LoveWeb/servlet/IndexUIServlet';
		 }else{
			 alert("对不起,该社团名已存在,请重试!");
		 }
	 });	
	 return false;
 }	


 //中文验证码切换
 function changeImage(img)
     	{
     		img.src = img.src+"?"+new Date().getTime();
     	}
 //中文验证码切换
 function changeImage2()
     	{
 			var img = document.getElementById("image");
     		img.src = img.src+"?"+new Date().getTime();
     	}
 
 //个人和社团注册
 function toregister(method){
		
		$.post("servlet/RegisterUIServlet?method="+method,
				function(data){
			
				document.getElementById("right").innerHTML = data;
		});
	}