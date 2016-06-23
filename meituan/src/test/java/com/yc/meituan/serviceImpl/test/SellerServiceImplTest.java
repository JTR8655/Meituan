package com.yc.meituan.serviceImpl.test;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.meituan.entity.GoodsInfo;
import com.yc.meituan.service.SellerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class SellerServiceImplTest {

	@Autowired
	SellerService sellerService;
	@Test
	public void testSBShowGoods() {
		List<GoodsInfo> SBgoods = sellerService.SBShowGoods(1);		
		LogManager.getLogger().debug("商家后台取到的数据：" + SBgoods);
		assertNotNull("取值失败！！！", SBgoods);
	}

}
