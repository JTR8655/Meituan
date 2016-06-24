package com.yc.meituan.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yc.meituan.entity.GoodsInfo;
import com.yc.meituan.entity.SellerInfo;
import com.yc.meituan.entity.bean.EvaluateBean;
import com.yc.meituan.entity.bean.GoodsBean;
import com.yc.meituan.entity.bean.UorderBean;
import com.yc.meituan.mapper.GoodsInfoMapper;
import com.yc.meituan.mapper.SellerInfoMapper;
import com.yc.meituan.service.SellerService;
import com.yc.meituan.web.bean.SellerGoodsBean;

@Transactional
@Service("sellerService")
public class SellerServiceImpl implements SellerService {

	@Autowired
	SellerInfoMapper sellerInfoMapper;
	@Autowired
	GoodsInfoMapper goodsInfoMapper;

	@Override
	public SellerInfo login(SellerGoodsBean sellerGoodsBean) {
		return sellerInfoMapper.login(sellerGoodsBean);
	}

	@Override
	public List<GoodsInfo> SBShowGoods(int sid) {
		return sellerInfoMapper.selectSBackShowGoods(sid);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public GoodsBean sAddGoods(GoodsBean goodsBean) {
		try {
			int gid = goodsInfoMapper.getNextGid();
			goodsBean.setGid(gid);
			goodsInfoMapper.sAddgoodsInfo(goodsBean);
			return goodsBean;
		} catch (Exception e) {
			throw new RuntimeException("添加info失败！！！", e);
		}
	}

	@Override
	public List<UorderBean> sListOrder(Map<String, Object> params) {
		return sellerInfoMapper.sListOrder(params);
	}

	@Override
	public void updateGoodsType(int gid) {
		try {
			sellerInfoMapper.updateGoodsType(gid);
		} catch (Exception e) {
			throw new RuntimeException("修改数据失败！！", e);
		}

	}

	@Override
	public SellerGoodsBean showSGoodsInfos(int gid) {
		return sellerInfoMapper.getSGoodsInfosById(gid);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void modyfySGoodsInfos(SellerGoodsBean sellerGoodsBean) {
		try {
			sellerInfoMapper.modyfySGoodsinfos(sellerGoodsBean);
		} catch (Exception e) {
			throw new RuntimeException("更新数据失败！！！", e);
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void modyfySGoodsIntros(SellerGoodsBean sellerGoodsBean) {
		try {
			sellerInfoMapper.modyfySGoodsintros(sellerGoodsBean);
		} catch (Exception e) {
			throw new RuntimeException("更新数据失败！！！", e);
		}

	}

	@Override
	public List<SellerGoodsBean> showOrderInfo(String opwd) {
		return sellerInfoMapper.showOrderInfo(opwd);
	}

	public int useOrder(String opwd) {
		return sellerInfoMapper.useOrder(opwd);
	}

	// 商品历史销量
	@Override
	public List<GoodsInfo> goodsSoldCounts(int sid) {

		return sellerInfoMapper.selectSumgsoldcount(sid);
	}

	// 显示评价
	@Override
	public List<EvaluateBean> goodsEvaluates(int sid) {
		return sellerInfoMapper.selectEvaluates(sid);
	}

	@Override
	public List<SellerGoodsBean> getTotalSoldBySids(int sid) {
		return sellerInfoMapper.getTotalSoldBySid(sid);
	}

}
