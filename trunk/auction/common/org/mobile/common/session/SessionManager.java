package org.mobile.common.session;

import org.mobile.common.bean.LoginBean;
import org.mobile.common.exception.GeneralException;
import org.mobile.common.manager.ResourceManager;

/**
 * session管理器，管理所有登录用户的session
 * 
 * @author 孙树林
 * 
 */
public class SessionManager {

	public static final String SESSION_LOGIN = "login";

	public static final String SESSION_FUNCTION = "function";

	public static boolean isLogin(String sessionId) {
		GeneralSession generalSession = GeneralSession.getInstance(sessionId);
		if (generalSession != null) {
			LoginBean bean = (LoginBean) generalSession
					.getAttribute(SESSION_LOGIN);
			if (bean != null) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public static void setLoginInfo(String sessionId, LoginBean bean) {
		GeneralSession generalSession = GeneralSession.getInstance(sessionId);
		generalSession.setAttribute(SESSION_LOGIN, bean);
	}

	public static LoginBean getLoginInfo(String sessionId)
			throws GeneralException {
		GeneralSession generalSession = GeneralSession.getInstance(sessionId);
		if (generalSession != null) {
			LoginBean bean = (LoginBean) generalSession
					.getAttribute(SESSION_LOGIN);
			if (bean != null) {
				return bean;
			} else {
				throw new GeneralException(ResourceManager.getInstance()
						.getString("login.error"));
			}
		} else {
			throw new GeneralException(ResourceManager.getInstance().getString(
					"login.error"));
		}
	}

	public static void setSessionValue(String sessionId, String key,
			Object value) {
		GeneralSession generalSession = GeneralSession.getInstance(sessionId);
		generalSession.setAttribute(key, value);
	}

	public static Object getSessionValue(String sessionId, String key) {
		GeneralSession generalSession = GeneralSession.getInstance(sessionId);
		return generalSession.getAttribute(key);
	}

	public static void removeSession(String sessionId) {
		GeneralSession generalSession = GeneralSession.getInstance(sessionId);
		generalSession.remove(sessionId);
	}
}