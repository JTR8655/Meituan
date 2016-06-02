package com.yc.meituan.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yc.meituan.entity.Uorder;
import com.yc.meituan.entity.bean.CollectionBean;
import com.yc.meituan.entity.bean.NoevalBean;
import com.yc.meituan.entity.bean.UorderBean;
import com.yc.meituan.mapper.UorderMapper;
import com.yc.meituan.service.UorderService;

@Transactional
@Service("uorderService")
public class UorderServiceImpl implements UorderService {

	@Autowired
	UorderMapper uorderMapper;

	@Override
	public List<UorderBean> showAllUorder(int muid) {
		return uorderMapper.showAllUorder(muid);
	}

	@Override
	public List<CollectionBean> listCollections(Integer muid) {
		return uorderMapper.listCollections(muid);
	}

	@Override
	public List<NoevalBean> listNoPj(Integer muid) {
		return uorderMapper.listNoPj(muid);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void updatePlStatus(int oid) {
		try {
			uorderMapper.updatePlStatus(oid);
		} catch (Exception e) {
			throw new RuntimeException("修改订单评论状态失败！！！", e);
		}
	}

	public Uorder addUorder(Uorder uorder) {
		//生成订单号
		uorder.setOidentifier(oidentitier());
		
		//生成美团券密码
		uorder.setOpwd(opwd());
		
		try {
			uorderMapper.addUorder(uorder);
			return uorder;
		} catch (Exception e) {
			throw new RuntimeException("插入数据失败！！！",e);
		}
		
	}

	
	
	
	
	
	
	
	
	
	// 生成订单号
	public String oidentitier(){
		// 取得当前时间
		Random r = new Random();
		Date d = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyMMddhhmmss");
		String time = sf.format(d);

		String str = r.nextInt(10000) + "";
		while (str.length() != 4) {
			str = r.nextInt(10000) + "";
		}
		String oidentitier = time + str;
		return oidentitier;
	}
	
	// 生成美团券密码
	public String opwd(){
		Random r = new Random();
		String opwd = "";
		for (int i = 0; i < 10; i++) {
			String charOrNum = r.nextInt(2) % 2 == 0 ? "char" : "num"; // 输出字母还是数字
			if ("char".equalsIgnoreCase(charOrNum)) {
				int choice = 65; // 取得大写字母
				opwd += (char) (choice + r.nextInt(26));
			} else if ("num".equalsIgnoreCase(charOrNum)) {
				opwd += String.valueOf(r.nextInt(10));
			}
		}
		return opwd;
	}
}
