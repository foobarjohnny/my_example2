package org.auction.module.admin.user.dwr;

import javax.servlet.http.HttpServletRequest;

import org.auction.module.admin.user.data.UserData;
import org.auction.module.admin.user.service.UserService;
import org.directwebremoting.WebContextFactory;
import org.mobile.common.exception.GeneralException;
import org.mobile.common.session.SessionManager;

public class UserHandler {

	private UserService userService;

	public String changePass(String id, String newpass, String oldpass)
			throws GeneralException {
		HttpServletRequest req = WebContextFactory.get()
				.getHttpServletRequest();
		if (SessionManager.getLoginInfo(req.getSession().getId()) != null) {
			UserData model = new UserData();
			model.setId(id);
			userService.forward(model);
			if (model.getPassword().equals(oldpass)) {
				model.setPassword(newpass);
				userService.update(model);
				return "success";
			} else {
				return "旧密码不正确！";
			}
		} else {
			return "请登录后修改密码！";
		}
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
