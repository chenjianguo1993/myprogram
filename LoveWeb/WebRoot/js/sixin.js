function sixin_xiangxi_more(id,content) {

	var span = "<span id='11"+id+"'>"+content+"</span>"
			+ "<span><a href='javascript:void(0)' onclick='sixin_xiangxi_shouqi("+id+")'>收起</a></span>";
	document.getElementById(id).innerHTML = span;
}

function sixin_xiangxi_shouqi(id) {
	
	content = document.getElementById("11"+id).innerHTML;
	con = content.substr(0,85);
	var span = "<span id='11"+id+"'>"+con+"......</span>"
			+ "<span><a href='javascript:void(0)' onclick='sixin_xiangxi_more("+id+","+content+")'>详细</a></span>";
	document.getElementById(id).innerHTML = span;
}

function email(){
	$.post("/LoveWeb/servlet/EmailUIServlet",function(data){
		document.getElementById("sixin_right").innerHTML = data;
	});
	return false;
	
}

function sixin_more(){
	var num = $("#startNum").attr("num");
	$.post("/LoveWeb/servlet/SixinMoreServlet?startNum=0",
			function(data){
		
			$(".sixin_right").append(data);
			var num = $("#startNum").attr("num");
			$("#mam").attr("num", num + 8);
			});
	
}

//获取未读私信
function getUnreadEmail(){
	var json = {startNum:"0",flag:"1"};
	$.post("/LoveWeb/servlet/EmailServlet",json,
			function(data){
			document.getElementById("sixin_right").innerHTML = data;
	});
	return false;
}
//获取已读私信
function getreadedEmail(){
	var json = {startNum:"0",flag:"2"};
	$.post("/LoveWeb/servlet/EmailServlet",json,
			function(data){
				document.getElementById("sixin_right").innerHTML = data;
	});
	return false;
}
//获取已发私信
function getsendedEmail(){
	var json = {startNum:"0",flag:"sended"};
	$.post("/LoveWeb/servlet/EmailServlet",json,
			function(data){
				document.getElementById("sixin_right").innerHTML = data;
	});
	return false;
}

//发送私信
function sendemail(){
	var username = $("#tousername").val();
	var content = $("#text").val();
	var json = {username:username,content:content};
	$.post("/LoveWeb/servlet/SendEmailServlet",json,
			function(data){
			alert("发送成功");
			
	});
	return false;
}
