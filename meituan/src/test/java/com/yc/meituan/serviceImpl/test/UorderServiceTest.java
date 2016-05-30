package com.yc.meituan.serviceImpl.test;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.meituan.entity.bean.CollectionBean;
import com.yc.meituan.entity.bean.NoevalBean;
import com.yc.meituan.entity.bean.UorderBean;
import com.yc.meituan.service.UorderService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class UorderServiceTest {
	
	@Autowired
	UorderService uorderService;

	@Test
	public void testShowAllUorder() {
		List<UorderBean> uorders = uorderService.showAllUorder(1);
		LogManager.getLogger().debug("取到的订单：" + uorders);
		assertNotNull("取值失败!!!", uorders);
	}

	@Test
	public void testListCollections() {
		List<CollectionBean> collections = uorderService.listCollections(1);
		LogManager.getLogger().debug("取到的收藏：" + collections);
		assertNotNull("取值失败!!!", collections);
	}
	
	@Test
	public void testListNoPj() {
		List<NoevalBean> noevalBeans = uorderService.listNoPj(1);
		LogManager.getLogger().debug("取到的未评价：" + noevalBeans);
		assertNotNull("取值失败!!!", noevalBeans);
	}
}
