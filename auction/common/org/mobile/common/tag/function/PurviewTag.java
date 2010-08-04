package org.mobile.common.tag.function;

import java.util.Set;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.mobile.common.session.SessionManager;

public class PurviewTag extends BodyTagSupport {

	private static final long serialVersionUID = 1L;

	private String functionId;

	@Override
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int doStartTag() throws JspException {
		String sessionId = pageContext.getSession().getId();
		Set<String> function = (Set<String>) SessionManager.getSessionValue(
				sessionId, SessionManager.SESSION_FUNCTION);
		if (function != null && function.size() > 0) {
			if (function.contains(functionId)) {
				return EVAL_BODY_INCLUDE;
			} else {
				return SKIP_BODY;
			}
		} else {
			return SKIP_BODY;
		}
	}

	public String getFunctionId() {
		return functionId;
	}

	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}

}
