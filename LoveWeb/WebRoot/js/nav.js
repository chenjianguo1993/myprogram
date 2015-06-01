var number = 1;
function nav(num){
	var liobjs = document.getElementById("nav_ul").getElementsByTagName('li');
	for(var i = 1;i < liobjs.length ; i++){
		if(i==num){
			liobjs[num].style.background="#242424";
			nnum=num;
		}else{
			liobjs[i].style.background="#333333";
		}
	}
}

function change(num){
	number = num;
}
function out(){
	var liobjs = document.getElementById("nav_ul").getElementsByTagName('li');
	for(var i = 1;i < liobjs.length ; i++){
		if(i==number){
			liobjs[number].style.background="#242424";
		}else{
			liobjs[i].style.background="#333333";
		}
	}
}


//登陆下拉
var numb = 0;
function login_xiala(num){
	var liobjs = document.getElementById("register_login").getElementsByTagName('li');
	for(var i = 0;i < liobjs.length ; i++){
		if(i==num){
			liobjs[num].style.background="#242424";
			nnum=num;
		}else{
			liobjs[i].style.background="#333333";
		}
	}
}

function login_change(num){
	numb = num;
}
function login_out(){
	var liobjs = document.getElementById("register_login").getElementsByTagName('li');
	for(var i = 0;i < liobjs.length ; i++){
		if(i==numb){
			liobjs[numb].style.background="#242424";
		}else{
			liobjs[i].style.background="#333333";
		}
	}
}

//访问私信
function email(){
	var json = {startNum:"0"};
	$.post("/LoveWeb/servlet/EmailServlet",json,
			function(data){
			if(data == "unlogin")
			{
				loginshow();
				return;
			}
	});
}
