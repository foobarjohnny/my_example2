package org.mobile.common.session;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户session，保存用户session中的内容
 * 
 * @author 孙树林
 * 
 */
public class GeneralSession {

	private static Map<String, GeneralSession> sessionMap = new HashMap<String, GeneralSession>();

	private Map<String, Object> valueMap = new HashMap<String, Object>();

	public static GeneralSession getInstance(String sessionId) {
		GeneralSession generalSession = sessionMap.get(sessionId);
		if (generalSession != null) {
			return generalSession;
		} else {
			generalSession = new GeneralSession();
			sessionMap.put(sessionId, generalSession);
			return generalSession;
		}
	}

	public void setAttribute(String key, Object value) {
		valueMap.put(key, value);
	}

	public Object getAttribute(String key) {
		return valueMap.get(key);
	}

	public void remove(String key) {
		sessionMap.remove(key);
	}
}
