package org.mobile.common.service;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import org.mobile.common.bean.LoginBean;
import org.mobile.common.bean.SqlBean;
import org.mobile.common.dao.ITsSystemLogao;
import org.mobile.common.manager.FunctionManager;
import org.mobile.common.manager.GeneralManager;
import org.mobile.common.pojo.TsDbLog;
import org.mobile.common.pojo.TsSystemLog;
import org.mobile.common.session.SessionManager;
import org.mobile.module.system.function.service.IFunctionService;
import org.springframework.aop.AfterReturningAdvice;

/**
 * 日志拦截器
 * 
 * @author 孙树林
 * 
 */
public class LogIntercepter implements AfterReturningAdvice {

	private ITsSystemLogao tsSystemLogao;

	public void afterReturning(Object arg0, Method method, Object[] arg2,
			Object arg3) throws Throwable {
		if (arg3 instanceof IFunctionService) {
			if (method.getName().equals("query")) {
				return;
			}
		}
		GeneralManager manager = GeneralManager.getCurrentManager();
		String sessionId = manager.getSessionId();
		LoginBean loginBean = SessionManager.getLoginInfo(sessionId);
		TsSystemLog tsSystemLog = new TsSystemLog();
		tsSystemLog.setOperatorId(loginBean.getId());
		tsSystemLog.setOperatorName(loginBean.getWorkNo());
		tsSystemLog.setCreateTime(new java.util.Date());
		if (method.getName().equals("login")) {
			tsSystemLog.setFunctionName("登陆");
		} else {
			String functionName = FunctionManager.getMenuName(manager
					.getFunctionId());
			tsSystemLog.setFunctionName(functionName);
		}
		Set<TsDbLog> set = new HashSet<TsDbLog>();
		for (SqlBean sqlBean : manager.getSqlBeans()) {
			TsDbLog tsDbLog = new TsDbLog();
			tsDbLog.setParameterSql(sqlBean.getSql());
			tsDbLog.setParameterId(sqlBean.getId());
			tsDbLog.setParameters(sqlBean.getParameter());
			tsDbLog.setTsSystemLog(tsSystemLog);
			set.add(tsDbLog);
		}
		tsSystemLog.setTsDbLogs(set);
		tsSystemLogao.save(tsSystemLog);
		manager.getSqlBeans().clear();
	}

	public void setTsSystemLogao(ITsSystemLogao tsSystemLogao) {
		this.tsSystemLogao = tsSystemLogao;
	}

}
