package org.mobile.common.intercepters;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.mobile.common.action.ActionConstant;
import org.mobile.common.manager.GeneralManager;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 配置通用拦截器，执行Action处理前操作
 * 
 * @author 孙树林
 * 
 */
public class GeneralInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 2355776582073065441L;

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		ServletContext servletContext = ServletActionContext
				.getServletContext();
		HttpSession session = request.getSession();
		GeneralManager generalManager;
		if (session.getAttribute(GeneralManager.GENERAL_MANAGER) != null) {
			generalManager = (GeneralManager) session
					.getAttribute(GeneralManager.GENERAL_MANAGER);
		} else {
			generalManager = new GeneralManager(session.getId(), request,
					response, servletContext);
			session
					.setAttribute(GeneralManager.GENERAL_MANAGER,
							generalManager);
		}
		// 获得模块权限ID
		String functionId = request.getParameter("functionId");
		generalManager.setRequest(request);
		generalManager.setResponse(response);
		generalManager.setSessionId(session.getId());
		generalManager.setServletContext(servletContext);
		generalManager.setFunctionId(functionId);
		GeneralManager.setCurrentManager(generalManager);
		try {
			generalManager.preProcess();
			return actionInvocation.invoke();
		} catch (Exception e) {
			generalManager.processException(e);
			request.getSession().setAttribute(ActionConstant.ERROR, e);
			return ActionConstant.ERROR;
		} finally {
			generalManager.postProcess();
		}
	}

}
