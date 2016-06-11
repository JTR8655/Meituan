package com.yc.meituan.web.interceptor;

import java.util.Map;

import org.apache.logging.log4j.LogManager;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.yc.meituan.util.MeituanData;

/**
 * 用户登录校验拦截器
 * @author 哆哆
 *
 */

//MethodFilterInterceptor可以对请求方法进行过滤
public class LoginInterceptor extends MethodFilterInterceptor {

	private static final long serialVersionUID = -4477987493015471935L;

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();//取到session的封装对象
		Object obj = session.get(MeituanData.LOGIN_USER);
		if(obj == null){
			session.put(MeituanData.ERROR_MSG, "请登录后再进行操作！！");
			LogManager.getLogger().debug("拦截到用户未登录");
			return "login";
		}
		return invocation.invoke();
	}

}
