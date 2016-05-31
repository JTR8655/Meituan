package com.yc.meituan.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yc.meituan.entity.Evaluate;
import com.yc.meituan.entity.bean.EvaluatedBean;
import com.yc.meituan.mapper.EvaluateMapper;
import com.yc.meituan.service.EvaluateService;

@Transactional
@Service("evaluateService")
public class EvaluateServiceImpl implements EvaluateService {

	@Autowired
	private EvaluateMapper evaluateMapper;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addEvaluate(Evaluate evaluate) {
		try {
			evaluateMapper.addEvaluate(evaluate);
		} catch (Exception e) {
			throw new RuntimeException("添加评论失败！！！", e);
		}
	}

	@Override
	public List<EvaluatedBean> listPj(Integer muid) {
		LogManager.getLogger().debug("listPj");
		return evaluateMapper.listPj(muid);
	}

}
