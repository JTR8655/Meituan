package com.yc.meituan.test;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class ConnTest {

	@Autowired
	private SqlSessionFactory sqlSessionfactory;
	
	@Test
	public void test() {
		Connection conn = sqlSessionfactory.openSession().getConnection();
		assertNotNull("数据库连接失败！！！",conn);
		//修改测试
	}

}
