package com.yc.meituan.service;

import java.util.List;

import com.yc.meituan.entity.bean.GoodsBean;

public interface ShowGoodsService {

	List<GoodsBean> listShowGoods(int gid);

}
