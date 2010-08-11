package org.auction.module.admin.commodity.dwr;

import javax.servlet.http.HttpServletRequest;

import org.auction.module.admin.user.data.UserData;
import org.auction.module.admin.user.service.UserService;
import org.directwebremoting.WebContextFactory;
import org.mobile.common.bean.LoginBean;
import org.mobile.common.exception.GeneralException;

public class LoginHandler {

	private UserService userService;

	public String login(String username, String password)
			throws GeneralException {
		UserData model = new UserData();
		model.setUsername(username);
		model.setPassword(password);
		LoginBean bean = userService.loginDwr(model);
		if (bean != null) {
			HttpServletRequest req = WebContextFactory.get()
					.getHttpServletRequest();
			req.getSession().setAttribute("login", bean);
			return bean.getWorkNo() + "," + bean.getId();
		} else {
			return "error";
		}
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
