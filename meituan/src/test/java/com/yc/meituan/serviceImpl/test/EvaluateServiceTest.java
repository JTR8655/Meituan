package com.yc.meituan.serviceImpl.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.meituan.entity.Evaluate;
import com.yc.meituan.service.EvaluateService;
import com.yc.meituan.service.UorderService;
import com.yc.meituan.util.AjaxUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class EvaluateServiceTest {
	@Autowired
	private EvaluateService evaluateService;
	@Autowired
	private UorderService uorderService;
	
	@Test
	public void testAddEvaluate() {
		Evaluate evaluate = new Evaluate();
		evaluate.setEcontent("评价内容");
		evaluate.setEgrade_4((double) 5);
		evaluate.setHidename(1);
		evaluate.setMuid(1);
		evaluate.setOid(1);
		evaluate.setImg("");
		
		try{
			evaluateService.addEvaluate(evaluate);
			uorderService.updatePlStatus(evaluate.getOid());
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
