--这里用来放测试数据CREATE SEQUENCE seq_uid INCREMENT BY 1 START WITH 10001;
--commit
select * from meituan_goods_info for update;
select * from meituan_seller_info for update;
select * from meituan_user_info for update;
select * from meituan_uorder for update;
select * from meituan_evaluate for update;
select * from meituan_collection for update;
select * from meituan_uorder for update
select oid,oidentifier,muid,gid,to_char(otime,'yyyy-MM-dd') otime,opwd,to_char(opaytime,'yyyy-MM-dd'),ocount,pjstatus from meituan_uorder where muid=1 and pjstatus=0;
drop table meituan_uorder;
delete from meituan_user_info where uemail='1059191443@qq.com';
--插入用户数据
insert into meituan_user_info(muid,uaccounts,upwd,uemail,uphone,usex,ubalance,upoint,ubirth,umarital,ujob,uheadimg,uinterest,ustatus)
	select 1,'123','qweqwe','1236342@qq.com',1235434236,'��',20,10,to_date('1996-1-9','yyyy-MM-dd'),'δ��','ѧ��','','',1 from dual union 
	select 2,'456fw1','yyqweqwe','456fw12@qq.com',123234263,'Ů',20,10,to_date('1995-2-9','yyyy-MM-dd'),'δ��','����ʦ','','',1 from dual union 
	select 3,'56sad2','qqweqwe','56sad217@qq.com',12374552,'��',20,10,to_date('1994-3-19','yyyy-MM-dd'),'����','�ۻ�Ա','','',1 from dual union 
	select 4,'678','qweqwe','678ddwqe@qq.com',12323463,'��',20,10,to_date('1993-4-29','yyyy-MM-dd'),'δ��','���Ա','','',1 from dual union   
	select 5,'3451','qqweqwe','345123@qq.com',123235654,'��',20,10,to_date('1992-6-9','yyyy-MM-dd'),'�ѻ�','����','','',1 from dual  
	
--插入商家数据
insert into meituan_seller_info(sid,saccounts,spwd,saddress,sshopname,stype,sname,semail,slicense,sphone,status)
	select  1,'1','123','地址','店铺','营销类�','姓名','邮箱',1,123,1 from dual union
	select  2,'2','123','地址','店铺','营销类�','姓名','邮箱',1,123,1 from dual union
	select  3,'3','123','地址','店铺','营销类�','姓名','邮箱',1,123,1 from dual union
	select  4,'4','123','地址','店铺','营销类�','姓名','邮箱',1,123,1 from dual union
	select  5,'5','123','地址','店铺','营销类�','姓名','邮箱',1,123,1 from dual union
	select  6,'6','123','地址','店铺','营销类�','姓名','邮箱',1,123,1 from dual 

--插入商品详情数据
insert into meituan_goods_info (gid,gdate,gtitle1,gtitle2,gprice1,gprice2,sid)
  select 1,to_date('2016-1-11','yyyy-MM-dd'),'��ʳ1','��ʳ1���',10,15,1 from dual union
  select 2,to_date('2015-2-28','yyyy-MM-dd'),'��ʳ2','��ʳ2���',10,14,2 from dual union
  select 3,to_date('2014-6-15','yyyy-MM-dd'),'��ʳ3','��ʳ3���',40,46,1 from dual union
  select 4,to_date('2012-3-5','yyyy-MM-dd'),'��ʳ4','��ʳ4���',16,20,3 from dual union
  select 5,to_date('2017-7-21','yyyy-MM-dd'),'��ʳ5','��ʳ5���',13,15,2 from dual union
  select 6,to_date('2011-8-19','yyyy-MM-dd'),'��ʳ6','��ʳ6���',11,18,4 from dual 
  
--插入订单数据
insert into meituan_uorder(oid,oidentifier,muid,gid,otime,ostatus,opwd,opaytime,ocount,pjstatus)
	select 1,123,1,1,to_date('2016-1-9','yyyy-MM-dd'),'未消','123',to_date('2016-1-9','yyyy-MM-dd'),1,0 from dual union
	select 2,234,1,1,to_date('2016-1-9','yyyy-MM-dd'),'未消','123',to_date('2016-1-9','yyyy-MM-dd'),1,0 from dual union
	select 3,345,1,1,to_date('2016-1-9','yyyy-MM-dd'),'未消','123',to_date('2016-1-9','yyyy-MM-dd'),1,0 from dual 
	
select * from (
	select a.*,rownum rn from ( 
		select * from meituan_goods_info g inner join meituan_seller_info s on g.sid=s.sid
	) a where rownum<=10
)b where rn>0

update meituan_user_info set  uphone ='13435863234';
select * from meituan_user_info;
select * from meituan_goods_info for update;
select * from meituan_collection;
create sequence seq_collection increment by 1 start with 1 nomaxvalue nocycle
select * from meituan_goods_info for update;
select * from meituan_user_info;
select meituan_uorder.oid,meituan_uorder.gid,meituan_uorder.muid,meituan_goods_info.gtitle1,meituan_goods_info.img from meituan_uorder inner join meituan_goods_info on meituan_uorder.gid=meituan_goods_info.gid and meituan_uorder.pjstatus=0

create sequence seq_manager increment by 1  start with 1  nomaxvalue nocycle

select * from noeval where muid=81

create view meituan_goods_view as 
select g. gid,g.gdate,g.privilege,g.gtitle1,g.gtitle2, g.gprice1,g.gprice2,g.gsoldcount,g.img,g.text,g.temp1
from meituan_seller_info s,meituan_goods_info g where s.sid=g.sid;


select s.sshopname, g.gtitle1, g.img, g.text, g.gsoldcount, g.gprice1, g.gprice2, m.b_retime, m.d_taocan from meituan_seller_info s 
inner join meituan_goods_info g on s.sid = g.sid inner join meituan_goods_intro m on g.gid = m.gid and g.gid = 1

select u.uaccounts, u.uheadimg, e.egrade_4, e.econtent, e.temp1 from meituan_user_info u inner join meituan_evaluate e on u.muid = e.muid left join meituan_uorder o on e.oid=o.oid and o.gid=1 
select * from meituan_evaluate for update;
select * from meituan_uorder for update
select sum(egrade_1) grade, count(egrade_1) amount from meituan_evaluate e inner join meituan_uorder o on e.oid=o.oid and o.gid=1
select s.sshopname,g.gid, g.text, g.gprice1, g.gprice2, g.gsoldcount, round((g.gprice2/g.gprice1)*10,1) discount from meituan_seller_info s inner join meituan_goods_info g on s.sid = g.sid where g.sid = 5
select u.uaccounts, u.uheadimg, e.egrade_1, e.econtent, e.temp1 from meituan_user_info u inner join meituan_evaluate e on u.muid = e.muid inner join meituan_uorder o on e.oid=o.oid and o.gid= 1

select * from meituan_evaluate e inner join meituan_uorder o on e.oid = o.oid
 inner join meituan_goods_info g on g.gid = o.gid  and e.muid = 1
 
select * from meituan_goods_info;
select * from meituan_goods_intro;


create view meituan_goods_intro_view as 
select g.gid,g1.gtitle1,g. b_retime,g.b_usetime,g.b_ordertip,g.b_parlor,g.b_pack,
 g.b_serve,g.b_limittip,g.b_prompt,g.d_taocan,g.d_price1,g.d_count
from meituan_seller_info s,meituan_goods_intro g,meituan_goods_info g1 
where s.sid=g.sid and g.gid=g1.gid;

select * from meituan_goods_intro_view;--��ѯ��ͼ

drop view meituan_goods_intro_view;--ɾ����ͼ
commit;

select * from meituan_uorder for update
select * from meituan_uorder where muid = 1 order by opaytime desc 
select * from meituan_uorder o inner join meituan_goods_info g on o.gid = g.gid and g.sid = 5 and o.temp2 like '123%' and o.ostatus='δ��';
update meituan_uorder set ostatus = '�����' where temp2 like '123%' ;

select * from meituan_uorder o inner join meituan_goods_info g on o.gid = g.gid 

CREATE SEQUENCE seq_trolley INCREMENT BY 1 START WITH 1;

select * from meituan_seller_info

select * from (select a.*,rownum rn from (select * from meituan_seller_info where status=1 and slicense='yes' order by sid ) a where rownum<=10)b where rn>0
select * from (select a.*,rownum rn from (select * from meituan_seller_info where status=0 and slicense='yes' order by sid ) a where rownum<=10)b where rn>0

insert into meituan_evaluate (eid,muid,oid,egrade_1,econtent,hidename,temp1) values(474, 1, 10003, 0, 'wqerqwrqw', 1, '2016-03-06 09:13:10')

select v.*,g.sid from (select *,rownum rn from (select * from meituan_goods_view v inner join meituan_goods_info g on v.gid=g.gid) a where rownum<=10)b where rn>0 and sid =1 
select * from (select a.*,rownum rn from (select * from meituan_uorder o inner join meituan_goods_info g on o.gid = g.gid and g.sid = 1 and o.opwd like '%MT%' and o.ostatus='δ���') a where rownum<=3)b where rn>0
