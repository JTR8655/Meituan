--插入商家数据
insert into meituan_seller_info(sid,saccounts,spwd,saddress,sshopname,stype,sname,semail,slicense,sphone,status)
	select  1,'1','123','地址','店铺','营销类','姓名','邮箱',1,123,1 from dual union
	select  2,'2','123','地址','店铺','营销类','姓名','邮箱',1,123,1 from dual union
	select  3,'3','123','地址','店铺','营销类','姓名','邮箱',1,123,1 from dual union
	select  4,'4','123','地址','店铺','营销类','姓名','邮箱',1,123,1 from dual union
	select  5,'5','123','地址','店铺','营销类','姓名','邮箱',1,123,1 from dual union
	select  6,'6','123','地址','店铺','营销类','姓名','邮箱',1,123,1 from dual 

--插入商品详情数据    gprice1：原价   gprice2：现价
insert into meituan_goods_info (gid,gdate,gtitle1,gtitle2,gprice1,gprice2,sid)
  select 1,to_date('2016-1-11','yyyy-MM-dd'),'标题1','小标题1',15,10,1 from dual union
  select 2,to_date('2015-2-28','yyyy-MM-dd'),'标题2','小标题2',14,10,2 from dual union
  select 3,to_date('2014-6-15','yyyy-MM-dd'),'标题3','小标题3',46,40,1 from dual union
  select 4,to_date('2012-3-5','yyyy-MM-dd'),'标题4','小标题4',20,16,3 from dual union
  select 5,to_date('2017-7-21','yyyy-MM-dd'),'标题5','小标题5',15,13,2 from dual union
  select 6,to_date('2011-8-19','yyyy-MM-dd'),'标题6','小标题6',18,11,4 from dual 

--插入商品介绍数据
insert into meituan_goods_intro (gid,b_retime,b_usetime,b_parlor,b_pack,b_serve,b_limittip)
  select 1,'2016-5-28至2016-7-31','8:00~18:00','提供包间','不提供外带','提供免费wifi','每人限购一份' from dual union
  select 2,'2016-5-29至2016-8-01','9:00~19:00','提供包间','不提供外带','提供免费wifi','每人限购一份' from dual union
  select 3,'2016-5-30至2016-8-02','10:00~19:30','提供包间','不提供外带','提供免费wifi','每人限购一份' from dual union
  select 4,'2016-5-31至2016-8-03','10:30~19:00','提供包间','不提供外带','提供免费wifi','每人限购一份' from dual union
  select 5,'2016-6-01至2016-8-04','11:30~19:30','提供包间','不提供外带','提供免费wifi','每人限购一份' from dual union
  select 6,'2016-6-02至2016-8-05','12:00~20:00','提供包间','不提供外带','提供免费wifi','每人限购一份' from dual
 
--插入订单数据  
insert into meituan_uorder(oid,oidentifier,muid,gid,otime,ostatus,opwd,opaytime,ocount,pjstatus)
	select 1,123,1,1,to_date('2016-1-9','yyyy-MM-dd'),'未消','123',to_date('2016-1-9','yyyy-MM-dd'),1,0 from dual union
	select 2,234,1,1,to_date('2016-1-9','yyyy-MM-dd'),'未消','123',to_date('2016-1-9','yyyy-MM-dd'),1,0 from dual union
	select 3,345,1,1,to_date('2016-1-9','yyyy-MM-dd'),'未消','123',to_date('2016-1-9','yyyy-MM-dd'),1,0 from dual  union
	select 4,123,1,1,to_date('2016-1-9','yyyy-MM-dd'),'已使用','123',to_date('2016-1-9','yyyy-MM-dd'),1,0 from dual union
	select 5,345,1,1,to_date('2016-1-9','yyyy-MM-dd'),'已使用','123',to_date('2016-1-9','yyyy-MM-dd'),1,0 from dual  

	
--插入收藏数据
insert into meituan_collection(cid,muid,gid)
	select 1,1,1 from dual union
	select 2,1,2 from dual union
	select 3,1,3 from dual union
	select 4,1,4 from dual union
	select 5,1,5 from dual 
	

-commit

--查询所有订单
select o.oid,o.oidentifier,o.muid,o.gid,o.ocount,o.ostatus,g.gprice2,g.gtitle1,g.img,g.sid,gi.b_retime from meituan_uorder o inner join 
	meituan_goods_info g on o.gid = g.gid left join meituan_goods_intro gi on o.gid = gi.gid where muid = 1 order by opaytime desc 	

select c.cid,c.muid,c.gid, g.b_retime from meituan_collection c inner join meituan_goods_intro g on c.gid = g.gid and c.muid = 1
  
select g.gid,s.sid, g.gtitle1,g.gtitle2, g.img, g.text, g.gsoldcount, g.gprice1, g.gprice2, m.b_retime, m.d_taocan from meituan_seller_info s inner join meituan_goods_info g on s.sid = g.sid inner join meituan_goods_intro m on g.gid = m.gid and g.gid = 1112;

select * from meituan_uorder;
select * from meituan_evaluate;
insert into meituan_user_info values(seq_meituanuser.nextval,'samsara0','a','918811021@qq.com',default,default,default,null,null,null,null,null,default,'湖南省-长沙市',sysdate);
