 function login(){
	
	$.post("/LoveWeb/servlet/RegisterServlet?method=Login", $("#login_form").serialize(),//这是form的 id
	  function( data ) {
			if(data == "登陆成功"){
				location.reload();
			}else{
				alert("对不起,该用户名已存在,请重试!");
			}
	  });	
	return false;
 }	