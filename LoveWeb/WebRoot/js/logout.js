 function logout(){
		$.post("/LoveWeb/servlet/LogoutServlet",
				function(data){
				
				location.reload();
		});
		return false;
	}
 
