//用户修改个人信息
function updateuser() {

	$.post("/LoveWeb/servlet/UpdateUserServlet", $("#updateuser").serialize(),
			function(data) {
				alert("尊敬的用户,您修改信息成功!");
				alter(data);
				// window.location.reload();
		});
	return false;
}

// 用户曾经参加过的益校园互动
function useroldCarry() {
	alert("11aa");
	$
			.post(
					"/LoveWeb/servlet/UserActivityServlet?method=UserOldCarryActivity",
					function(data) {
						alert(data);
						if (data == "0") {
							alert(data);
							alert("您好,你曾经没有参加过益校园活动。");
						} else {
							data = eval("("+data+")");
							alert(data[0].username);
							for(var i = 0;i<data.length();i++){
								var div = "<div class='activity_content_left'><div class='activity_content_left_img'><img src='/LoveWeb/image/"+data[i].image+"'></div><div class='activity_content_left_content'><div class='aclc_top'><div class='activity_title'><span>标题:"+data[i].name+"</span></div><div class='activity_title'><span id='"+data[i].activityid+"'>报名:"+data[i].joinnum+"</span></div><span>简介:"+data[i].description+"</span></div><div class='aclc_bottom'><span>报名截止:"+data[i].joindate+"</span></div></div></div><div class='activity_content_right'><div class='right_button' style='margin-top:120px;'><span><a href='/LoveWeb/servlet/DetailActivityServlet?activitid="+data[i].activityid+"'>取消活动</a></span></div></div>";
								alert(div);
							}
							alert("成功");
							// window.location.href="/LoveWeb/user/UserOldCarryActivity.jsp";

						}
					});
	return false;
}
