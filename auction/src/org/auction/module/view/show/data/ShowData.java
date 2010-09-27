package org.auction.module.view.show.data;

import java.util.ArrayList;
import java.util.List;

import org.auction.module.admin.base.data.InfoData;
import org.auction.module.admin.commodity.data.BingcurData;
import org.auction.module.admin.commodity.data.SortData;
import org.auction.module.admin.view.data.ViewData;
import org.mobile.common.action.GeneralData;

public class ShowData extends GeneralData {

	private String username;
	private String password;
	private int payNum;
	private int freeNum;
	private String winGoods;//赢取的商品信息
	private String isLogin;	//判断用户是否登录 Y表示登录； N表示未登录

	// 商品分类
	private List<SortData> sortDataList = new ArrayList<SortData>();

	// 竞拍历史记录
	private List<BingcurData> bingcurDataList = new ArrayList<BingcurData>();

	// 帮助中心
	private List<InfoData> helpDataList = new ArrayList<InfoData>();

	// 网站公告
	private List<InfoData> postDataList = new ArrayList<InfoData>();

	// 竞拍商品
	private List<ViewData> viewDataList = new ArrayList<ViewData>();

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<SortData> getSortDataList() {
		return sortDataList;
	}

	public void setSortDataList(List<SortData> sortDataList) {
		this.sortDataList = sortDataList;
	}

	public List<BingcurData> getBingcurDataList() {
		return bingcurDataList;
	}

	public void setBingcurDataList(List<BingcurData> bingcurDataList) {
		this.bingcurDataList = bingcurDataList;
	}

	public List<InfoData> getHelpDataList() {
		return helpDataList;
	}

	public void setHelpDataList(List<InfoData> helpDataList) {
		this.helpDataList = helpDataList;
	}

	public List<InfoData> getPostDataList() {
		return postDataList;
	}

	public void setPostDataList(List<InfoData> postDataList) {
		this.postDataList = postDataList;
	}

	public List<ViewData> getViewDataList() {
		return viewDataList;
	}

	public void setViewDataList(List<ViewData> viewDataList) {
		this.viewDataList = viewDataList;
	}

	public int getPayNum() {
		return payNum;
	}

	public void setPayNum(int payNum) {
		this.payNum = payNum;
	}

	public int getFreeNum() {
		return freeNum;
	}

	public void setFreeNum(int freeNum) {
		this.freeNum = freeNum;
	}

	public String getIsLogin() {
		return isLogin;
	}

	public void setIsLogin(String isLogin) {
		this.isLogin = isLogin;
	}

	public String getWinGoods() {
		return winGoods;
	}

	public void setWinGoods(String winGoods) {
		this.winGoods = winGoods;
	}
}
