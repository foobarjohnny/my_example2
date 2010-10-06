package org.auction.module.admin.commodity.dwr;

import javax.servlet.http.HttpServletRequest;

import org.auction.module.admin.user.data.UserData;
import org.auction.module.admin.user.service.UserService;
import org.directwebremoting.WebContextFactory;
import org.mobile.common.bean.LoginBean;
import org.mobile.common.exception.GeneralException;
import org.mobile.common.session.SessionManager;

/**
 * 用户登录的操作
 * 
 * [类说明]： [注意事项]：
 * 
 * @author
 * 
 */
public class LoginHandler {

	private UserService userService;

	/**
	 * 用户登陆
	 * 
	 * @param username
	 * @param password
	 * @return
	 * @throws GeneralException
	 */
	public String login(String username, String password)
			throws GeneralException {

		UserData model = new UserData();
		model.setUsername(username);
		model.setPassword(password);
		LoginBean bean = userService.loginDwr(model);
		if (bean != null) {
			// 登陆成功，将用户信息放入session中
			HttpServletRequest req = WebContextFactory.get()
					.getHttpServletRequest();
			req.getSession().setAttribute("login", bean);
			// 用户登陆标识
			req.getSession().setAttribute("user_login", "Y");
			SessionManager.setLoginInfo(req.getSession().getId(), bean);
			return bean.getWorkNo() + "," + bean.getId() + ","
					+ bean.getFreecur() + "," + bean.getPaycur() + ","
					+ bean.getAmount();
		} else {
			return "error";
		}
	}

	/**
	 * 用户退出
	 * 
	 * @return
	 * @throws GeneralException
	 */
	public String loginOut() throws GeneralException {
		HttpServletRequest req = WebContextFactory.get()
				.getHttpServletRequest();
		LoginBean bean = (LoginBean) req.getSession().getAttribute("login");
		String sessionId = req.getSession().getId();
		if (bean != null) {
			req.getSession().removeAttribute("login");
			req.getSession().removeAttribute("user_login");
			SessionManager.removeSession(sessionId);
		}
		return "success";
	}

	/**
	 * 检查Email,username是否被注册
	 * 
	 * @param email
	 * @return
	 * @throws Exception
	 */
	public String checkedEmail(String email, String username) throws Exception {
		UserData model = new UserData();
		model.setEmail(email);
		model.setMethodName("email");
		String msg = "";
		boolean is = true;
		if (userService.checkedUser(model)) {
			msg = "邮箱已被使用,";
			is = false;
		} else {
			msg = ",";
		}
		model.setEmail(username);
		model.setMethodName("username");
		if (userService.checkedUser(model)) {
			msg += "用户名被使用";
			is = false;
		} else {
			msg += ",";
		}
		if (is) {
			return "success";

		} else {
			return msg;
		}

	}

	/**
	 * 检查用户名是否被注册(废弃掉)
	 * 
	 * @param email
	 * @return
	 * @throws Exception
	 */
	public String checkedUser(String username) throws Exception {
		UserData model = new UserData();
		model.setEmail(username);
		model.setMethodName("username");

		if (userService.checkedUser(model)) {
			return "用户名被使用！";
		}
		return "success";
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
