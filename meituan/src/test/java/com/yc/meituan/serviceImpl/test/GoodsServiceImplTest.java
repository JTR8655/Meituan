package com.yc.meituan.serviceImpl.test;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.meituan.entity.GoodsInfo;
import com.yc.meituan.mapper.GoodsInfoMapper;
import com.yc.meituan.service.GoodsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class GoodsServiceImplTest {
	
	@Autowired
	GoodsService goodsService;
	
	@Autowired
	GoodsInfoMapper goodsInfoMapper;
	
	@Test
	public void test() {
		List<GoodsInfo> goodsInfos = goodsService.listGoodsInIndex();
		LogManager.getLogger().debug("取到的数据：" + goodsInfos);
		assertNotNull("取值失败！！！", goodsInfos);
	}
	
	@Test
	public void testGetNextGid() {
		int gid = goodsInfoMapper.getNextGid();
		LogManager.getLogger().debug("取到的数据：" + gid);
		assertNotNull("取值失败！！！", gid);
	}

}
