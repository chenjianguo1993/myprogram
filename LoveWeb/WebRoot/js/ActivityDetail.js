function add_change(userid1){
	var json = {userid1:userid1};
	$.post("/LoveWeb/servlet/AddFriendServlet",json,
			function(data){
			
			if(data=="unlogin"){
				loginshow();
				return false;
			}
			if(data == "true"){
				$(".addfriend").text("删除好友");
				$("#aaa").text("添加好友成功");
				setTimeout("hidden()",1500);
				
			}else{
				$(".addfriend").text("添加好友");
				$("#aaa").text("删除好友成功");
				setTimeout("hidden()",1500);
			}
			
			
			
	});

	return false;
	
}
function hidden(){
	$("#aaa").text("");
}
function response(activityid){
	var content = $("#text").val();
	var json = {activityid:activityid,content:content}
	
	 $.post("/LoveWeb/servlet/ResponseServlet",json,
			  function( data ) {
		 		if(data == "unlogin"){
		 			loginshow();
		 		}else{
		 			$("#com").append(data); 
		 		}
			 	
			  }); 
	return false;		  
 }

function joinactivity(id){
	
	var json = {id:id};
	$.post("../servlet/joinServlet",json,
			function(data){
				
				data = eval("("+data+")");
				if(data.flag == "true"){
					$("#"+id).text("报名("+data.count+")　");
				}else{
					$("#"+id).text("报名("+data.count+")　");
				}
				
				
			});
	return false;
}


