package com.yc.meituan.mapper;

import java.util.List;

import com.yc.meituan.entity.bean.GoodsBean;

public interface GoodsIntroMapper {

	List<GoodsBean> selectGoodsIntro(int gid);
}