package org.mobile.common.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.mobile.common.bean.LoginBean;
import org.mobile.common.bean.PageBean;
import org.mobile.common.exception.GeneralException;
import org.mobile.common.manager.GeneralManager;
import org.mobile.common.session.SessionManager;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 所有Action基类，所有Action都必须继承该类，提供处理Action中常使用的共同方法。
 * 
 * @author 孙树林
 * 
 * @param <T>
 */
public abstract class GeneralAction<T> extends ActionSupport implements
		ModelDriven<T> {

	private static final long serialVersionUID = 8863417639381876502L;

	/**
	 * 分页处理
	 * 
	 * @param generalData
	 */
	protected void setPage(GeneralData generalData) {
		if (generalData.getPageBean() != null) {

		} else {
			generalData.setPageBean(new PageBean());
		}
	}

	/**
	 * 判断用户是否登录
	 * 
	 * @return
	 */
	protected void isLogin() throws GeneralException {
		boolean isLogin = SessionManager.isLogin(GeneralManager
				.getCurrentManager().getSessionId());
		if (!isLogin) {
			throw new GeneralException("用户没有登录！");
		}
	}

	/**
	 * 判断用户是否登录
	 * 
	 * @return
	 */
	protected boolean checkedLogin() throws GeneralException {
		HttpSession session = ServletActionContext.getRequest().getSession();
		LoginBean lb = (LoginBean) session.getAttribute("login");
		if (lb != null) {
			return true;
		} else {
			return false;
		}
	}
}
