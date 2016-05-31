-- Create table MEITUAN_COLLECTION
create table MEITUAN_COLLECTION
(
  cid     INTEGER not null,
  muid    INTEGER not null,
  gid     INTEGER not null,
  cstatus VARCHAR2(10)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table MEITUAN_COLLECTION
  add primary key (CID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64
    minextents 1
    maxextents unlimited
  );
alter table MEITUAN_COLLECTION
  add constraint FK_COLLE_REFERENCE_G_INFO foreign key (GID)
  references MEITUAN_GOODS_INFO (GID);
alter table MEITUAN_COLLECTION
  add constraint FK_COLLE_REFERENCE_U_INFO foreign key (MUID)
  references MEITUAN_USER_INFO (MUID);

--------------------------------------------------------------

-- Create table MEITUAN_EVALUATE
create table MEITUAN_EVALUATE
(
  eid      INTEGER not null,
  muid     INTEGER,
  oid      INTEGER,
  egrade_1 FLOAT,
  egrade_2 FLOAT,
  egrade_3 FLOAT,
  egrade_4 FLOAT,
  econtent VARCHAR2(500) default '长时间未评价，系统默认好评',
  img      VARCHAR2(200),
  hidename INTEGER default 0,
  temp1    VARCHAR2(100)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table MEITUAN_EVALUATE
  add primary key (EID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table MEITUAN_EVALUATE
  add constraint FK_EVAL_REFERENCE_UOR foreign key (OID)
  references MEITUAN_UORDER (OID);
alter table MEITUAN_EVALUATE
  add constraint FK_EVAL_REFERENCE_U_INFO foreign key (MUID)
  references MEITUAN_USER_INFO (MUID);

  
--------------------------------------------------------------


-- Create table MEITUAN_GOODS_INFO
create table MEITUAN_GOODS_INFO
(
  gid        INTEGER not null,
  gdate      DATE,
  privilege  VARCHAR2(50),
  sid        INTEGER,
  gtitle1    VARCHAR2(20),
  gtitle2    VARCHAR2(50),
  gprice1    FLOAT,
  gprice2    FLOAT,
  gsoldcount INTEGER default 0,
  img        VARCHAR2(2000),
  text       VARCHAR2(2000),
  temp1      VARCHAR2(100),
  temp2      VARCHAR2(100)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table MEITUAN_GOODS_INFO
  add primary key (GID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table MEITUAN_GOODS_INFO
  add constraint FK_G_INFO_REFERENCE_S_INFO foreign key (SID)
  references MEITUAN_SELLER_INFO (SID);

--------------------------------------------------------------

-- Create table MEITUAN_GOODS_INTRO
create table MEITUAN_GOODS_INTRO
(
  gid        INTEGER not null,
  sid        INTEGER,
  b_retime   VARCHAR2(100),
  b_usetime  VARCHAR2(50),
  b_ordertip VARCHAR2(100) default '无需预约，消费高峰时可能需要等位',
  b_parlor   VARCHAR2(100) default '店内有包间',
  b_pack     VARCHAR2(100) default '食堂外带均可，可免费打包',
  b_serve    VARCHAR2(500) default '提供免费wifi，免费提供十个停车位',
  b_limittip VARCHAR2(100) default '可叠加使用，不兑现，不找零',
  b_prompt   VARCHAR2(1000) default '团购用户不可同时享受商家其他优惠 方案内人数免费提供餐具，超出人数详询商家；方案不涉及餐具除外 酒水饮料等问题，请致电商家咨询，以商家反馈为准',
  d_taocan   VARCHAR2(100),
  d_price1   FLOAT,
  d_count    INTEGER,
  temp1      VARCHAR2(100),
  temp2      VARCHAR2(100),
  temp3      VARCHAR2(100)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table MEITUAN_GOODS_INTRO
  add primary key (GID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table MEITUAN_GOODS_INTRO
  add constraint FK_G_INTRO_REFERENCE_G_INFO foreign key (GID)
  references MEITUAN_GOODS_INFO (GID);

  
--------------------------------------------------------------

-- Create table MEITUAN_MANAGER
create table MEITUAN_MANAGER
(
  mid   INTEGER not null,
  mname VARCHAR2(20) not null,
  mpwd  VARCHAR2(20) not null,
  temp1 VARCHAR2(100)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table MEITUAN_MANAGER
  add primary key (MID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

  
  
--------------------------------------------------------------

-- Create table MEITUAN_SELLER_INFO
create table MEITUAN_SELLER_INFO
(
  sid       INTEGER not null,
  saccounts VARCHAR2(20),
  spwd      VARCHAR2(20),
  saddress  VARCHAR2(100),
  sshopname VARCHAR2(20),
  stype     VARCHAR2(10),
  sname     VARCHAR2(20),
  semail    VARCHAR2(30),
  slicense  VARCHAR2(20),
  sphone    VARCHAR2(20),
  status    INTEGER default 0,
  temp1     VARCHAR2(100),
  temp2     VARCHAR2(100)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table MEITUAN_SELLER_INFO
  add primary key (SID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

  
  
--------------------------------------------------------------

-- Create table MEITUAN_TROLLEY
create table MEITUAN_TROLLEY
(
  tid    INTEGER not null,
  muid   INTEGER not null,
  gid    INTEGER not null,
  tcount INTEGER not null,
  temp1  VARCHAR2(100),
  temp2  VARCHAR2(100)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table MEITUAN_TROLLEY
  add primary key (TID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table MEITUAN_TROLLEY
  add constraint FK_TROL_REFERENCE_G_INFO foreign key (GID)
  references MEITUAN_GOODS_INFO (GID);
alter table MEITUAN_TROLLEY
  add constraint FK_TROL_REFERENCE_U_INFO foreign key (MUID)
  references MEITUAN_USER_INFO (MUID);

  
--------------------------------------------------------------

-- Create table MEITUAN_UORDER
create table MEITUAN_UORDER
(
  oid         INTEGER not null,
  oidentifier INTEGER,
  muid        INTEGER,
  gid         INTEGER,
  otime       DATE,
  ostatus     VARCHAR2(10),
  opwd        VARCHAR2(100),
  opaytime    DATE,
  ocount      INTEGER,
  pjstatus    INTEGER,
  temp2       VARCHAR2(100)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table MEITUAN_UORDER
  add primary key (OID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table MEITUAN_UORDER
  add constraint FK_UOR_REFERENCE_G_INFO foreign key (GID)
  references MEITUAN_GOODS_INFO (GID);
alter table MEITUAN_UORDER
  add constraint FK_UOR_REFERENCE_U_INFO foreign key (MUID)
  references MEITUAN_USER_INFO (MUID);

  
  
--------------------------------------------------------------

-- Create table MEITUAN_USER_INFO
create table MEITUAN_USER_INFO
(
  muid       INTEGER not null,
  uaccounts  VARCHAR2(20),
  upwd       VARCHAR2(20),
  uemail     VARCHAR2(30),
  uphone     VARCHAR2(20),
  usex       VARCHAR2(4) default '男',
  ubalance   FLOAT default 0,
  upoint     INTEGER default 0,
  ubirth     DATE,
  umarital   VARCHAR2(10),
  ujob       VARCHAR2(20),
  uheadimg   VARCHAR2(100),
  uinterest  VARCHAR2(100),
  ustatus    INTEGER default 0,
  "uaddr"    VARCHAR2(100),
  "uregtime" VARCHAR2(100)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table MEITUAN_USER_INFO
  add primary key (MUID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table MEITUAN_USER_INFO
  add constraint UACCOUNTS_UNIQUE unique (UACCOUNTS)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table MEITUAN_USER_INFO
  add constraint UEMAIL_UNIQUE unique (UEMAIL)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate check constraints 
alter table MEITUAN_USER_INFO
  add constraint C_USER_INFO_SEX
  check (usex in ('男','女'));

  
--------------------------------------------------------------

--视图
create or replace view meituan_goods_intro_view as
select g.gid,g1.gtitle1,g. b_retime,g.b_usetime,g.b_ordertip,g.b_parlor,g.b_pack,
 g.b_serve,g.b_limittip,g.b_prompt,g.d_taocan,g.d_price1,g.d_count
from meituan_seller_info s,meituan_goods_intro g,meituan_goods_info g1
where s.sid=g.sid and g.gid=g1.gid;


create or replace view meituan_goods_view as
select g. gid,g.gdate,g.privilege,g.gtitle1,g.gtitle2, g.gprice1,g.gprice2,g.gsoldcount,g.img,g.text,g.temp1
from meituan_seller_info s,meituan_goods_info g where s.sid=g.sid;

create or replace view noeval as
(select meituan_uorder.oid,meituan_uorder.gid,meituan_uorder.muid,meituan_goods_info.gtitle1,meituan_goods_info.img from meituan_uorder inner join meituan_goods_info on meituan_uorder.gid=meituan_goods_info.gid and meituan_uorder.pjstatus= 0 and meituan_uorder.ostatus = '已使用');

--序列
-- Create sequence 
create sequence SEQ_MEITUANSELLER
minvalue 1
maxvalue 9999999999
start with 1
increment by 1
cache 20;


-- Create sequence 
create sequence SEQ_MEITUANUSER
minvalue 1
maxvalue 9999999999
start with 41
increment by 1
cache 20;

-- Create sequence 
create sequence SEQ_MEITUAN_EVAL
minvalue 1
maxvalue 9999999999
start with 1
increment by 1
cache 20;
