package org.mobile.common.intercepters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.mobile.common.action.ActionConstant;
import org.mobile.common.session.SessionManager;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 权限检查,用户登陆检查拦截器
 * 
 * @author 孙树林
 * 
 */
public class PermissionCheckInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		if (!SessionManager.isLogin(session.getId())) {
			return ActionConstant.INDEX;
		} else {
			return actionInvocation.invoke();
		}
	}

}
