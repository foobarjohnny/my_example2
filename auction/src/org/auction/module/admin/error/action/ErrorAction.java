package org.auction.module.admin.error.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.mobile.common.exception.GeneralException;

import com.opensymphony.xwork2.util.ValueStack;

public class ErrorAction {

	public String execute() {
		HttpServletRequest request = ServletActionContext.getRequest();
		ValueStack vs = ServletActionContext.getValueStack(request);
		GeneralException exception = (GeneralException) request.getSession()
				.getAttribute("error");
		request.getSession().removeAttribute("error");
		if (exception.getMessage().equals("")) {
			
		} else {
			request.setAttribute("error", exception);
		}
		return "sucess";
	}
}
