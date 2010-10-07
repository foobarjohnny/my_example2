package org.auction.module.admin.user.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.mail.HtmlEmail;
import org.apache.log4j.Logger;
import org.auction.entity.TsAid;
import org.auction.entity.TsCommodity;
import org.auction.entity.TsInfo;
import org.auction.entity.TsUser;
import org.auction.module.admin.user.data.UserData;
import org.auction.module.admin.user.service.UserService;
import org.auction.module.manager.TradeManager;
import org.auction.module.manager.data.TradeAid;
import org.auction.module.manager.data.TradeData;
import org.mobile.common.bean.LoginBean;
import org.mobile.common.bean.SearchBean;
import org.mobile.common.exception.GeneralException;
import org.mobile.common.manager.GeneralManager;
import org.mobile.common.manager.ResourceManager;
import org.mobile.common.service.GeneralService;
import org.mobile.common.session.SessionManager;
import org.mobile.common.util.BeanProcessUtils;
import org.mobile.common.util.Constant.COMMODITY_STATE;

public class UserServiceImpl extends GeneralService implements UserService {

	private static Logger logger = Logger.getLogger(UserServiceImpl.class);

	public void delete(UserData model) throws GeneralException {
		generalDao.delete(TsUser.class, model.getId());
	}

	public void forward(UserData model) throws GeneralException {
		GeneralManager m = GeneralManager.getCurrentManager();
		LoginBean lb = SessionManager.getLoginInfo(m.getSessionId());
		if (lb != null) {
			TsUser tsUser = (TsUser) generalDao.get(TsUser.class, lb.getId());
			BeanProcessUtils.copyProperties(model, tsUser);
		}
	}

	public void forwardAdmin(UserData model) throws GeneralException {
		if (model != null && model.getId() != null && !model.getId().equals("")) {
			TsUser tsUser = (TsUser) generalDao.get(TsUser.class, model.getId());
			BeanProcessUtils.copyProperties(model, tsUser);
		}

	}

	@SuppressWarnings("unchecked")
	public void regForward(UserData model) throws Exception {
		List<SearchBean> search = new ArrayList<SearchBean>();
		search.add(new SearchBean("nettype", "eq", "string", "4"));
		List list = generalDao.search(TsInfo.class, null, model.getPageBean(), null);
		if (list != null && list.size() > 0) {
			TsInfo tsInfo = (TsInfo) list.get(0);
			model.setInfo(tsInfo.getInfo());
		}
	}

	public void save(UserData model) throws GeneralException {
		TsUser tsUser = new TsUser();
		BeanProcessUtils.copyProperties(tsUser, model);
		if (model.getId() != null && !model.getId().equals("")) {
			generalDao.update(tsUser);
		} else {
			tsUser.setHouroflogon(new Date());
			generalDao.save(tsUser);
		}
	}

	@SuppressWarnings("unchecked")
	public void search(UserData model) throws GeneralException {
		List<SearchBean> search = new ArrayList<SearchBean>();
		List list = generalDao.search(TsUser.class, search, model.getPageBean(), null);
		for (int i = 0; i < list.size(); i++) {
			TsUser tsUser = (TsUser) list.get(i);
			UserData data = new UserData();
			BeanProcessUtils.copyProperties(data, tsUser);
			model.getDataList().add(data);
		}
	}

	@SuppressWarnings("unchecked")
	public boolean login(UserData model) throws GeneralException {
		System.out.println("开始进行客户的登录处理。。。。。。。。" + model.getUsername() + " " + model.getPassword());
		List<SearchBean> search = new ArrayList<SearchBean>();
		search.add(new SearchBean("username", "eq", "string", model.getUsername()));
		search.add(new SearchBean("password", "eq", "string", model.getPassword()));
		List list = generalDao.search(TsUser.class, search, null, null);
		if (list != null && list.size() > 0) {
			TsUser tsUser = (TsUser) list.get(0);
			LoginBean bean = new LoginBean();
			bean.setWorkNo(tsUser.getUsername());
			bean.setId(tsUser.getId());
			GeneralManager manager = GeneralManager.getCurrentManager();
			SessionManager.setLoginInfo(manager.getSessionId(), bean);
			return true;
		}
		return false;
	}

	/**
	 * 用户登陆
	 */
	@SuppressWarnings("unchecked")
	public LoginBean loginDwr(UserData model) throws GeneralException {

		System.out.println("dwr开始进行客户的登录处理。。。。。。。。" + model.getUsername() + " " + model.getPassword());
		// 根据用户名，密码查询用户
		List<SearchBean> search = new ArrayList<SearchBean>();
		search.add(new SearchBean("username", "eq", "string", model.getUsername()));
		search.add(new SearchBean("password", "eq", "string", model.getPassword()));
		List list = generalDao.search(TsUser.class, search, null, null);
		// 获得用户，并获得用户相关信息
		if (list != null && list.size() > 0) {
			TsUser tsUser = (TsUser) list.get(0);
			LoginBean bean = new LoginBean();
			bean.setWorkNo(tsUser.getUsername());
			bean.setId(tsUser.getId());
			bean.setPaycur(tsUser.getPaycur());
			bean.setFreecur(tsUser.getFreecur());
			// 获得用户拍到商品数
			String hql = "select count(id) from TsBingcur t where t.tsUser.id='" + tsUser.getId() + "'";
			Object o = generalDao.executeQuery(hql);
			bean.setAmount(Integer.parseInt(String.valueOf(o)));
			return bean;
		}
		return null;
	}

	public void regedit(UserData model) throws GeneralException {
		TsUser tsUser = new TsUser();
		BeanProcessUtils.copyProperties(tsUser, model);
		tsUser.setHouroflogon(new Date());
		generalDao.save(tsUser);
		LoginBean bean = new LoginBean();
		bean.setWorkNo(tsUser.getUsername());
		bean.setId(tsUser.getId());
		GeneralManager manager = GeneralManager.getCurrentManager();
		SessionManager.setLoginInfo(manager.getSessionId(), bean);
	}

	/**
	 * 注册成功，发送邮件
	 */
	public void reg(UserData model) throws GeneralException {
		TsUser tsUser = new TsUser();
		BeanProcessUtils.copyProperties(tsUser, model);
		tsUser.setHouroflogon(new Date());
		generalDao.save(tsUser);
		model.setId(tsUser.getId());
		LoginBean bean = new LoginBean();
		bean.setWorkNo(tsUser.getUsername());
		bean.setId(tsUser.getId());
		// 用户邀请注册
		if (model.getRegId() != null && !model.getRegId().equals("")) {
			TsUser user = (TsUser) generalDao.get(TsUser.class, model.getRegId());
			user.setFreecur(user.getFreecur() + 20);
		}
		// 发送邮件
		ResourceManager resourceManager = ResourceManager.getInstance();
		try {
			HtmlEmail email = new HtmlEmail();
			String url = resourceManager.getString("email.url");
			email.setHostName(resourceManager.getString("email.hostname"));// 设置发信的smtp服务器
			email.addTo(tsUser.getEmail(), tsUser.getUsername());// 设置收件人帐号和收件人
			email.setFrom(resourceManager.getString("email.account"), "E拍得网站");// 设置发信的邮件帐号和发信人
			email.setSubject("E拍得竞拍");// 设置邮件主题
			email.setAuthentication(resourceManager.getString("email.logname"), resourceManager.getString("email.password"));// 如果smtp服务器需要认证的话，在这里设置帐号、密码
			email.setHtmlMsg("<a href='" + url + "'>" + url + "</a><br>username：" + tsUser.getUsername() + "<br>password：" + tsUser.getPassword());// 设置邮件正文和字符编码
			email.send();
		} catch (Exception e) {
			logger.error("邮件发送错误信息：", e);
		}

	}

	/**
	 * 重新发送邮件
	 */
	public void send(UserData model) throws Exception {
		TsUser tsUser = (TsUser) generalDao.get(TsUser.class, model.getId());
		// 发送邮件
		ResourceManager resourceManager = ResourceManager.getInstance();
		try {
			HtmlEmail email = new HtmlEmail();
			String url = resourceManager.getString("email.url");
			email.setHostName(resourceManager.getString("email.hostname"));// 设置发信的smtp服务器
			email.addTo(model.getEmail(), tsUser.getUsername());// 设置收件人帐号和收件人
			email.setFrom(resourceManager.getString("email.account"), "E拍得网站");// 设置发信的邮件帐号和发信人
			email.setSubject("E拍得竞拍");// 设置邮件主题
			email.setAuthentication(resourceManager.getString("email.logname"), resourceManager.getString("email.password"));// 如果smtp服务器需要认证的话，在这里设置帐号、密码
			email.setHtmlMsg("<a href='" + url + "'>" + url + "</a><br>username：" + tsUser.getUsername() + "<br>password：" + tsUser.getPassword());// 设置邮件正文和字符编码
			email.send();
		} catch (Exception e) {
			logger.error("邮件发送错误信息：", e);
		}
	}

	public void view(UserData model) throws GeneralException {
		GeneralManager manager = GeneralManager.getCurrentManager();
		LoginBean bean = SessionManager.getLoginInfo(manager.getSessionId());
		TsUser tsUser = (TsUser) generalDao.get(TsUser.class, bean.getId());
		BeanProcessUtils.copyProperties(model, tsUser);
	}

	public void update(UserData model) throws GeneralException {
		TsUser tsUser = new TsUser();
		BeanProcessUtils.copyProperties(tsUser, model);
		generalDao.update(tsUser);
	}

	/**
	 * 检查用户属性
	 */
	@SuppressWarnings("unchecked")
	public boolean checkedUser(UserData model) throws Exception {
		List<SearchBean> search = new ArrayList<SearchBean>();
		search.add(new SearchBean(model.getMethodName(), "eq", "string", model.getEmail()));
		List list = generalDao.search(TsUser.class, search, null, null);
		if (list != null && list.size() > 0) {
			return true;
		}
		return false;
	}

	/**
	 * 通过邮箱邀请好友
	 */
	public void invitePage(UserData model) throws Exception {
		// 获得用户登陆信息
		GeneralManager manager = GeneralManager.getCurrentManager();
		LoginBean bean = SessionManager.getLoginInfo(manager.getSessionId());
		TsUser tsUser = (TsUser) generalDao.get(TsUser.class, bean.getId());
		// 获得资源
		ResourceManager resourceManager = ResourceManager.getInstance();
		String url = resourceManager.getString("email.reg") + "?regId=" + tsUser.getId();
		model.setUrl(url);
	}

	/**
	 * 用户邮箱邀请发送邮箱
	 */
	public void invite(UserData model) throws Exception {
		String[] account = model.getRecAcout().split(";");
		// 发送邮件
		ResourceManager resourceManager = ResourceManager.getInstance();
		try {
			HtmlEmail email = new HtmlEmail();
			email.setHostName(resourceManager.getString("email.hostname"));// 设置发信的smtp服务器
			// 邮箱群发
			for (int i = 0; i < account.length; i++) {
				email.addTo(account[i]);// 设置收件人帐号和收件人
			}
			email.setFrom(resourceManager.getString("email.account"), "E拍得网站");// 设置发信的邮件帐号和发信人
			email.setSubject("E拍得竞拍");// 设置邮件主题
			email.setAuthentication(resourceManager.getString("email.logname"), resourceManager.getString("email.password"));// 如果smtp服务器需要认证的话，在这里设置帐号、密码
			email.setHtmlMsg("<a href='" + model.getUrl() + "'>" + model.getUrl() + "</a>");// 设置邮件正文和字符编码
			email.send();
		} catch (Exception e) {
			logger.error("邮件发送错误信息：", e);
		}
	}

	/**
	 * 用户竞拍助理后台验证
	 */
	@SuppressWarnings("unchecked")
	public String checkedECount(UserData model) throws Exception {
		// 获得用户信息
		TsUser tsUser = (TsUser) generalDao.get(TsUser.class, model.getId());
		// 获得用户设置的商品信息
		TsCommodity tsCommodity = (TsCommodity) generalDao.get(TsCommodity.class, model.getComId());

		TsAid tsAid = null;

		List<SearchBean> search = new ArrayList<SearchBean>();
		search.add(new SearchBean("tsUser.id", "eq", "string", tsUser.getId()));
		search.add(new SearchBean("tsCommodity.id", "eq", "string", tsCommodity.getId()));

		List list = generalDao.search(TsAid.class, search, null, null);
		boolean isSave = false;
		// 判断是增加还是修改记录
		if (model.getMethodName().equals("ins")) {
			// 该用户是否为该商品设置了竞拍助理
			if (list != null && list.size() > 0) {
				return "已设置竞拍助理.";
			}
			tsAid = new TsAid();
			isSave = true;
		} else {
			// 该用户是否为该商品设置了竞拍助理
			if (list == null || list.size() == 0) {
				return "记录不存在无法修改.";
			}
			tsAid = (TsAid) generalDao.get(TsAid.class, model.getRegId());
			if (tsAid == null) {
				return "记录不存在无法修改.";
			}
			isSave = false;
		}

		// 查看设置的商品状态是否是正在竞拍的商品
		Integer ecount = model.getEcount();
		Integer freecount = tsAid.getEcount() == null ? 0 : tsAid.getEcount();
		Integer paycount = tsAid.getPaycount() == null ? 0 : tsAid.getPaycount();
		if (tsCommodity.getState().equals(COMMODITY_STATE.AUCTION_STATE)) {
			// 查看商品使用E拍币类型限制1。无限制、2。收费E拍币、3。免费E拍币
			if (tsCommodity.getRestricts().equals(COMMODITY_STATE.UNLIMITED)) {
				// 无限制
				// 用户点数
				Integer u_pay = tsUser.getPaycur() == null ? 0 : tsUser.getPaycur();
				Integer u_free = tsUser.getFreecur() == null ? 0 : tsUser.getFreecur();
				Integer total = u_pay + u_free + freecount + paycount;
				if (total - ecount < 0) {
					return "点数不够";
				}
				// 用户的免费点数是否够设置助理点数
				Integer free = u_free + freecount;
				if (free - ecount < 0) {
					tsUser.setFreecur(0);
					// 剩余点数
					Integer surplus = ecount - free;
					// 用户付费点数
					Integer pay = u_pay + paycount;
					tsUser.setPaycur(pay - surplus);
					tsAid.setEcount(free);
					tsAid.setPaycount(surplus);
				} else {
					tsUser.setFreecur(free - ecount);
					tsAid.setEcount(ecount);
				}
			} else if (tsCommodity.getRestricts().equals(COMMODITY_STATE.FREE)) {
				// 免费
				Integer free = tsUser.getFreecur() + freecount;
				if (free - ecount < 0) {
					return "你的免费点数不够";
				} else {
					// 更新用户,保存用户设置竞拍助理
					tsUser.setFreecur(free - ecount);
					tsAid.setEcount(ecount);
				}
			} else if (tsCommodity.getRestricts().equals(COMMODITY_STATE.CHARGE)) {
				// 收费
				Integer pay = tsUser.getPaycur() + paycount;
				if (pay - ecount < 0) {
					return "你的付费点数不够";
				} else {
					// 更新用户,保存用户设置竞拍助理
					tsUser.setPaycur(pay - ecount);
					tsAid.setPaycount(ecount);
				}
			}
		}
		generalDao.update(tsUser);
		tsAid.setStartPirce(model.getStart());
		tsAid.setEndPrice(model.getEnd());

		if (isSave) {
			tsAid.setTsUser(tsUser);
			tsAid.setTsCommodity(tsCommodity);
			tsAid.setState("1");
			generalDao.save(tsAid);
		} else {
			generalDao.update(tsAid);
		}

		// 将竞拍助理保存到商品竞拍的缓冲中
		TradeAid aids = new TradeAid();
		aids.setId(tsAid.getId());
		aids.setStart(tsAid.getStartPirce());
		aids.setEnd(tsAid.getEndPrice());
		aids.setCmId(tsCommodity.getId());
		aids.setUId(tsUser.getId());
		aids.setFree(tsAid.getEcount());
		aids.setPay(tsAid.getPaycount());
		TradeData tradeData = TradeManager.get(tsCommodity.getId());
		tradeData.getAidMap().put(aids.getId(), aids);

		return "success";
	}

	/**
	 * 删除用户的竞拍助理，并返回点数
	 */
	public String deleteCount(UserData model) throws Exception {
		// 获得竞拍助理
		TsAid tsAid = (TsAid) generalDao.get(TsAid.class, model.getId());
		// 获得用户
		TsUser tsUser = tsAid.getTsUser();
		if (tsAid.getEcount() != null && tsAid.getEcount() > 0) {
			tsUser.setFreecur(tsUser.getFreecur() + tsAid.getEcount());
		}
		if (tsAid.getPaycount() != null && tsAid.getPaycount() > 0) {
			tsUser.setPaycur(tsUser.getPaycur() + tsAid.getPaycount());
		}
		tsAid.setState("2");
		generalDao.update(tsUser);
		generalDao.update(tsAid);
		// 从商品中删除竞拍助理
		TradeData tradeData = TradeManager.get(tsAid.getTsCommodity().getId());
		tradeData.remove(tsAid.getId());
		return "success";
	}

}
