function findNotPass1(){
	
	$.post("/LoveWeb/servlet/ManagersServlet",
			function(data){
//			alert(data);
		document.getElementById("right").innerHTML = data;
		
	});
}


var xmlhttp;
function createXMLHttp()
{
	if(window.XMLHttpRequest)
	{
		xmlhttp=new XMLHttpRequest();
	}else
	{
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
}
//查看正在请求申请的社团
function findNotPass(){
	
	createXMLHttp();	
	xmlhttp.open("GET","../servlet/ManagersServlet?method=nowApply");
	
	xmlhttp.onreadystatechange = Callback;
	
	xmlhttp.send(null);
}

function Callback()
{
	if(xmlhttp.readyState ==4)
	{
		if(xmlhttp.status ==200)
		{
			var text = xmlhttp.responseText;
			if(text=="还没有申请社团")
			{
				alert("您好,当前还没有社团申请!");
			}else
			{
				document.getElementById("right").innerHTML = text;
			}
		}
	}
}

//批准社团注册
function agree(userid){
	
	$.post("../servlet/AgreeServlet?method=agreesoc&userid="+userid,
			function(data){
			alert(data);
//			location.reload(); 
	});
}

//驳回社团审批
function disagree(userid){
	
	$.post("../servlet/AgreeServlet?method=disagreesoc&userid="+userid,
			function(data){
			alert(data);
			location.reload(); 
	});
}

//查看当前社团用户
function findNowSoc(){
	
	$.post("../servlet/ManagersServlet?method=nowSoc",
			function(data){
		if(data=="当前没有社团用户")
		{
			alert(data);
		}else
		{
			document.getElementById("right").innerHTML = data;
		}
		
	});
}
//当前个体用户
function findNowStu(){
	
	$.post("../servlet/ManagersServlet?method=nowStu",
			function(data){
		if(data=="当前没有个体用户")
		{
			alert(data);
		}else
		{
			document.getElementById("right").innerHTML = data;
		}
		
	});
}

//清除不法用户
function sweep(userid){
	
	$.post("../servlet/ManagersServlet?method=sweep&userid="+userid,
			function(data){
		
			alert(data);
			location.reload(); 
	});
}