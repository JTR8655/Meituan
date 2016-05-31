--插入商家数据
insert into meituan_seller_info(sid,saccounts,spwd,saddress,sshopname,stype,sname,semail,slicense,sphone,status)
	select  1,'1','123','地址','店铺','营销类','姓名','邮箱',1,123,1 from dual union
	select  2,'2','123','地址','店铺','营销类','姓名','邮箱',1,123,1 from dual union
	select  3,'3','123','地址','店铺','营销类','姓名','邮箱',1,123,1 from dual union
	select  4,'4','123','地址','店铺','营销类','姓名','邮箱',1,123,1 from dual union
	select  5,'5','123','地址','店铺','营销类','姓名','邮箱',1,123,1 from dual union
	select  6,'6','123','地址','店铺','营销类','姓名','邮箱',1,123,1 from dual 

--插入商品详情数据
insert into meituan_goods_info (gid,gdate,gtitle1,gtitle2,gprice1,gprice2,sid)
  select 1,to_date('2016-1-11','yyyy-MM-dd'),'标题1','小标题1',10,15,1 from dual union
  select 2,to_date('2015-2-28','yyyy-MM-dd'),'标题2','小标题2',10,14,2 from dual union
  select 3,to_date('2014-6-15','yyyy-MM-dd'),'标题3','小标题3',40,46,1 from dual union
  select 4,to_date('2012-3-5','yyyy-MM-dd'),'标题4','小标题4',16,20,3 from dual union
  select 5,to_date('2017-7-21','yyyy-MM-dd'),'标题5','小标题5',13,15,2 from dual union
  select 6,to_date('2011-8-19','yyyy-MM-dd'),'标题6','小标题6',11,18,4 from dual 
  
-commit


select g.gid,s.sid, g.gtitle1,g.gtitle2, g.img, g.text, g.gsoldcount, g.gprice1, g.gprice2, m.b_retime, m.d_taocan from meituan_seller_info s inner join meituan_goods_info g on s.sid = g.sid inner join meituan_goods_intro m on g.gid = m.gid and g.gid = 1112;
select b_retime,b_usetime,b_ordertip,b_parlor,b_pack,b_serve,b_limittip,d_taocan from meituan_goods_intro where gid=1112;

insert into meituan_user_info values(seq_meituanuser.nextval,'samsara0','a','918811021@qq.com',default,default,default,null,null,null,null,null,default,'湖南省-长沙市',sysdate);
