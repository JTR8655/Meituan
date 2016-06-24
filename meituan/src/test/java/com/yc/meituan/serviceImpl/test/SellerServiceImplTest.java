package com.yc.meituan.serviceImpl.test;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.yc.meituan.entity.GoodsInfo;
import com.yc.meituan.entity.bean.GoodsBean;
import com.yc.meituan.entity.bean.UorderBean;
import com.yc.meituan.service.GoodsIntroService;
import com.yc.meituan.service.SellerService;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class SellerServiceImplTest {

	@Autowired
	SellerService sellerService;
	@Autowired
	GoodsIntroService goodsIntroService;
	@Test
	public void testSBShowGoods() {
		List<GoodsInfo> SBgoods = sellerService.SBShowGoods(1);		
		LogManager.getLogger().debug("商家后台取到的数据：" + SBgoods);
		assertNotNull("取值失败！！！", SBgoods);
	}

	@Test
	public void testSAddgoods(){
		GoodsBean goodsBean = new GoodsBean(0,1,"测试1","测试2","8折",5.0,4.0,0,"img","text","b_retime","b_usetime","b_ordertip","b_parlor","b_pack","b_serve","b_limittip",4.0,1,"d_taocan",0,"sshopname",0);
		
		try {
			goodsBean = sellerService.sAddGoods(goodsBean);
			goodsIntroService.sAddgoodsIntro(goodsBean);
		} catch (Exception e) {
			LogManager.getLogger().debug(e.getMessage());
		}
	}
	
	@Test
	public void testSListOrder() {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("sid", 1);
		params.put("status", "%已使用%");
		List<UorderBean> uorders = sellerService.sListOrder(params);
		LogManager.getLogger().debug("商家后台取到的数据：" + uorders);
		assertNotNull("取值失败！！！", uorders);
	}
}
