
本网站的地址（首页servlet）http://localhost:8080/LoveWeb/servlet/IndexUIServlet

bb86e3d0-c3c1-4ed3-b333-38698bb8f08e

1、拱建开发环境
	1.1 导入开发包
		mysql驱动
		c3p0连接池
		dbutils开发包
		beanutils开发包
		jstl开发包
		log4j开发包
		upload开发包
		common io 开发包
	1.2 创建程序包
		cn.itcast.domain
		cn.itcast.dao
		cn.itcast.dao.impl
		cn.itcast.service
		cn.itcast.service.impl
		cn.itcast.web.filter
		cn.itcast.utils
	1.3 创建库
    	create database loveweb;
    
		use loveweb;
	1.4用户表(status 为0表示为学生用户，为1表示为社团用户)
		create table t_user(
			userid varchar(40) primary key,
			username varchar(40)  not null,
			password varchar(40) not null,
			email varchar(100),
			phone   varchar(11) not null,
			date  datetime,
			status  int  
		);
	1.5社团用户表(status 为0表示为待审状态，为1表示为通过审批,这是就把该社团用户又存在用户表里)	
		create table t_society(
				userid varchar(40) primary key,
				socname varchar(40)  not null,
				leadername varchar(40)  not null,
				password varchar(40) not null,
				reason  varchar(300)  not null,
				email varchar(100),
				phone   varchar(11) not null,
				date  datetime,
				status  int
			);
			
	---------------------------益校园活动--------------------------------------------------------------------------		
	
	2.0 学校活动表
	create table t_activity
	(
		activityid varchar(40) primary key,
		name varchar(40) not null unique,
		startdate date not null ,
		enddate date not null,
		joindate date not null ,
		address varchar(40) not null ,
		image varchar(40) not null ,
		video varchar(40) ,
		description varchar(300),
		userid varchar(40),
		constraint actuser_FK foreign key(userid) references t_user(userid)
	);
	
		2.1	用户参加校园活动表
	create table t_userjoin
	(
		userjoinid int primary key auto_increment,
		activityid varchar(40) ,
		userid varchar(40),
		constraint useridjoinact_FK foreign key(userid) references t_user(userid)
		
	);
	
	3.0	益校园关注表
	create table t_watch
	(
		watchid  int primary key auto_increment,
		userid  varchar(40),
		activityid varchar(40),
		enddate date not null,
		constraint userwatch_FK foreign key(userid) references t_user(userid)	
	);
	
	--------------------------------------志愿者活动--------------------------------------------------------------
	2.01志愿者活动表
	create table t_vactivity
	(
		activityid varchar(40) primary key,
		name varchar(40) not null unique,
		startdate date not null ,
		enddate date not null,
		joindate date not null ,
		address varchar(40) not null ,
		image varchar(40) not null ,
		video varchar(40) ,
		description varchar(300),
		userid varchar(40),
		constraint vactuser_FK foreign key(userid) references t_user(userid)
	);
	
	2.1	用户参加志愿者活动表
	create table t_vuserjoin
	(
		userjoinid int primary key auto_increment,
		activityid varchar(40) ,
		userid varchar(40),
		constraint vuseridjoinact_FK foreign key(userid) references t_user(userid)
		
	);
	
	3.0	志愿者活动关注表
	create table t_vwatch
	(
		watchid  int primary key auto_increment,
		userid  varchar(40),
		activityid varchar(40),
		enddate date not null,
		constraint vuserwatch_FK foreign key(userid) references t_user(userid)	
	);
	
	----------------------------失物招认领---------------------------------------------------------------------------
	4.0失物招领
	create table t_lost(
			lostid varchar(40) primary key ,
			lostname varchar(20),
			losttype varchar(20),
			reledate date,
			lostimage varchar(40) ,
			description varchar(300),
			userid varchar(40) ,
			constraint lostuserid_FK foreign key(userid) references t_user(userid)
		);
	
	
	
	
	
	
	
	
	
	
	
	
	
	------------------------用户评论--------------------------------------------------------------------------

	4.0用户评论表
	create table t_comment
	(
		commentid int primary key auto_increment,
		commentContext  varchar(300),
		commentdate  varchar(20),
		userid  varchar(40),
		activityid varchar(40) ,
		constraint usercomment_fk foreign key(userid) references t_user(userid)

	);
	---------------------添加好友-----------------------------------------------------------------------------------
	5.0添加好友表
	create table t_friend
	(
		friendid  int primary key auto_increment,
		userid1  varchar(40),
		userid2  varchar(40),
		constraint userid1_fk foreign key(userid1) references t_user(userid),
		constraint userid2_fk foreign key(userid2 ) references t_user(userid)
	);
	-----------------------私信----------------------------------------------------------------------
	create table t_email
	(
		emailid  int primary key auto_increment,
		userid1  varchar(40) not null,
		userid2  varchar(40) not null,
		content  text not null,
		sendtime  datetime, 
		constraint euserid1_fk foreign key(userid1) references t_user(userid),
		constraint euserid2_fk foreign key(userid2 ) references t_user(userid)
	);
	
	私信
	1  未读
	2 已读
	3 已发
	
	
	
	
	
	
	
	