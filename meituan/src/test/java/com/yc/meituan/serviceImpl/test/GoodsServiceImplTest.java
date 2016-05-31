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
import com.yc.meituan.entity.bean.GoodsBean;
import com.yc.meituan.service.GoodsService;
import com.yc.meituan.service.ShowGoodsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class GoodsServiceImplTest {
	
	@Autowired
	GoodsService goodsService;
	ShowGoodsService showGoodsService;
	@Test
	public void test() {
		List<GoodsInfo> goodsInfos = goodsService.listGoodsInIndex();
		LogManager.getLogger().debug("取到的数据：" + goodsInfos);
		assertNotNull("取值失败！！！", goodsInfos);
	}
	
}
