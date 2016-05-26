--删除约束：alter table 表名 drop constraint 约束名称;
--修改字段名：alter table 表名 rename column 旧字段名 to 新字段名;
--修改数据类型语法：alter table 表名 modify 字段名 新的数据类型;
--创建序列语法：
--     create sequence 序列名
--     increment by 1 --每次加1
--     start with 1   --从1开始计数
--     nomaxvalue     --不设置最大值[maxvalue 3000]
 --    nocycle        --一直累加，不循环

------------------------------------------------------------------
--会员信息表   邮箱验证
drop table meituan_user_info;
drop sequence seq_meituanuser;

create table meituan_user_info(
	muid int primary key,	
	uaccounts varchar2(20),	 --用户帐号
	upwd varchar2(20),		--密码
	uemail varchar2(30),	--邮箱
	uphone int, 			--手机
	usex varchar2(2) default '男' constraint c_user_info_sex check  (usex in ('男','女')),	--性别
	ubalance float default 0, 		--余额
	upoint int default 0,			--积分
	ubirth date,					--生日
	umarital varchar2(10),			--个人状况，已婚未婚
	ujob varchar2(20),				--身份|职业
	uheadimg varchar2(100),			--头像信息
	uinterest varchar2(100),		--兴趣
	ustatus int default 0,			--激活状态，规定时间未激活则删除该数据,0表示未激活
	temp1 varchar2(100),
	temp2 varchar2(100)
);
create sequence seq_meituanuser increment by 1  start with 1  nomaxvalue nocycle;

-------------------------------------------------
--商家表  --注册时需邮箱验证
drop table meituan_seller_info;
drop sequence seq_meituanseller;

delete from meituan_seller_info
alter table meituan_seller_info modify saccounts varchar2(20)

create table meituan_seller_info(
	sid int primary key ,--用于做外键
	saccounts varchar2(20),		--商家号(固定位数的随机数)
	spwd varchar2(20),		--密码
	saddress varchar2(100),	--地址，地址应按指定格式存储，以便取出对应的值，如省份、城市、区、街道等等
	sshopname varchar2(20),	--商家名(店铺名)
	stype varchar2(10),	--营销类型	
	sname varchar2(20) ,	--姓名
	semail varchar2(30),	--邮箱
	slicense int default 0,		--营业执照 0有  1无
	sphone int,		--手机
	status	int default 0,					--安全问题，权限问题:是否激活，是否被封,0表示未激活
	temp1 varchar2(100),
	temp2 varchar2(100)
);	
select * from meituan_seller_info;
create sequence seq_meituanseller increment by 1  start with 1  nomaxvalue nocycle;
insert into meituan_seller_info values(seq_meituanseller.nextval,'10001','aaaaaa','湖南省、衡阳市、珠晖区、衡花路','土火锅烧烤','美食','龙振宇','111111@qq.com',default,18274708888,default,null,null);
insert into meituan_seller_info values(seq_meituanseller.nextval,'10001','aaaaaa',123,'湖南省、衡阳市','土火锅烧烤','美食','龙振宇','111111@qq.com','1',18274708888,default,null,null);
--------------------------------------------
 -- 
commit
--商品详情表
drop table meituan_goods_info;
drop sequence seq_meituanseller;
alter table meituan_goods_info
  drop constraint FK_g_info_REFERENCE_s_info;
create table meituan_goods_info(
	gid int primary key,	--商品编号，主键
	gdate date,	--上架时间
	privilege varchar2(50),	--优惠
	sid int,	--商家号
	gtitle1 varchar2(20),	--主标题
	gtitle2 varchar2(50),	--副标题
	gprice1 float,	--原价
	gprice2 float,	--现价
	gsoldcount int default 0,	--已购数
	img varchar2(2000),
	text varchar2(2000),
	temp1 int default 0, --商品状态，已上架0  已下架1
	temp2 varchar2(100)
);

alter table meituan_goods_info
   add constraint FK_g_info_REFERENCE_s_info foreign key (sid)
      references meituan_seller_info(sid);
insert into meituan_goods_info values(1001,to_date('2016-1-1','yyyy-MM-dd'),'8.8折',1,'羊肉火锅','仅售38.8元，提供免费wifi',68.8,38.8,9,null,null,1,null);
--------------------------------------------
--商品介绍表    一个商品会有多条数据(不同的小商品等等)
drop table meituan_goods_intro;
alter table meituan_goods_intro drop constraint FK_g_intro_REFERENCE_g_info;
create table meituan_goods_intro(
	gid int primary key,	--商品编号
	b_retime varchar2(100),	--有效期(商家添加时应在后台判断当前时间是否在时间范围之内)
	b_usetime varchar2(50),	--使用时间
	b_ordertip  varchar2(100) default '无需预约，消费高峰时可能需要等位',	--预约提示
	b_parlor varchar2(100),		--包间
	b_pack varchar2(100),		--食堂外带 
--	b_limit varchar(100),		--限价片条款 
	b_serve varchar2(500),		--商家服务
	b_limittip varchar2(100),	--限购限用提醒 
--	d_taocan varchar2(100),		--套餐内容 
	d_price1 float,		--单价
	d_count int,		--数量
--	d_sum float,		--小计
--	d_infos varchar2(2000),		--详细信息
--	d_introduce varchar2(2000),		--商家介绍
	temp1 varchar2(100),
	temp2 varchar2(100),
	temp3 varchar2(100)
)

alter table meituan_goods_intro
   add constraint FK_g_intro_REFERENCE_g_info  foreign key (gid)
      references meituan_goods_info(gid);

---------------------------------------------

--会员订单表
drop table meituan_uorder;
alter table meituan_uorder
   drop constraint FK_uor_REFERENCE_g_info;
 alter table meituan_uorder
   drop constraint FK_uor_REFERENCE_u_info;

create table meituan_uorder(
	oid int primary key,	--订单表编号,主键
	oidentifier int,	--订单号
	muid int,	--用户帐号,外键关联
	gid int,	--商品号,外键关联
	otime date,				--下单时间
	ostatus varchar2(10),	--订单状态：未付款，未使用，已使用
	opwd varchar2(100),		--美团券密码,可保存多个密码，用逗号隔开,个数和数量对应
	opaytime date,	--付款时间
	ocount int,		 --数量
	pjstatus varchar2(100),
	temp2 varchar2(100)
);

alter table meituan_uorder
   add constraint FK_uor_REFERENCE_g_info foreign key (gid)
      references meituan_goods_info (gid);

alter table meituan_uorder
   add constraint FK_uor_REFERENCE_u_info foreign key (muid)
      references meituan_user_info (muid);

-------------------------------------------------------------

--用户购物车
drop table meituan_trolley;
alter table meituan_trolley
   drop constraint FK_trol_REFERENCE_u_info;
alter table meituan_trolley
   drop constraint FK_trol_REFERENCE_g_info;   
create table meituan_trolley(
	tid int primary key,	--购物车编号，主键
	muid int,	--会员编号
	gid int,	--商品编号
	tcount int,	--数量
	temp1 varchar2(100),
	temp2 varchar2(100)
);
alter table meituan_trolley
   add constraint FK_trol_REFERENCE_u_info foreign key (muid)
      references meituan_user_info (muid);

alter table meituan_trolley
   add constraint FK_trol_REFERENCE_g_info foreign key (gid)
      references meituan_goods_info (gid);
-------------------------------------------------------------------------------------------
--收藏表
drop table meituan_collection;
alter table meituan_collection
   drop constraint FK_colle_REFERENCE_u_info;
alter table meituan_collection
   drop constraint FK_colle_REFERENCE_g_info;
create table meituan_collection(
	cid int primary key,		--收藏编号
	muid int ,	--会员编号
	gid int ,	--商品编号
	cstatus varchar2(10)		--进行中，已结束
);

alter table meituan_collection
   add constraint FK_colle_REFERENCE_u_info foreign key (muid)
      references meituan_user_info (muid);

alter table meituan_collection
   add constraint FK_colle_REFERENCE_g_info foreign key (gid)
      references meituan_goods_info (gid);
--------------------------------------------------------------
--用户评价表
drop table meituan_evaluate;
alter table meituan_evaluate
   drop constraint FK_eval_REFERENCE_u_info;
alter table meituan_evaluate
   drop constraint FK_eval_REFERENCE_uor;
create table meituan_evaluate(
	eid int primary key ,	--评价表编号
	muid int,	---会员编号
	oid int,		---订单编号
	egrade_1 float,	---服务分
	egrade_2 float,	---口味分
	egrade_3 float,	---环境分
	egrade_4 float,	---总评分
	econtent varchar2(500) default '长时间未评价，系统默认好评',
	img varchar2(200),	--图片(路径)
	hidename int default 0, 		--匿名
	temp1 varchar2(100)
);	
create sequence seq_meituan_eval increment by 1  start with 1  nomaxvalue nocycle;

alter table meituan_evaluate
   add constraint FK_eval_REFERENCE_u_info foreign key (muid)
      references meituan_user_info (muid);
	  
alter table meituan_evaluate
   add constraint FK_eval_REFERENCE_uor foreign key (oid)
      references meituan_uorder (oid);	  
-----------------------------------------------------------	
--管理员表
drop table meituan_manager;
create table meituan_manager(
	mid int primary key,
	mname varchar2(20),
	mpwd varchar2(20),
	temp1 varchar2(100)
); 

comit;

update meituan_user_info set UEMAIL = '1059191443@qq.com';

select * from meituan_user_info;
select * from meituan_manager;
select * from meituan_evaluate;
select * from meituan_collection;
select * from meituan_seller_info;
select * from meituan_goods_info;
select * from meituan_goods_intro;
select * from meituan_uorder;
select * from meituan_trolley;