package org.auction.module.manager.data;

import org.mobile.common.action.GeneralData;

public class AlipayData extends GeneralData {

	/**  */
	private String notify_id;
	/** 支付成功后支付宝返回的sign值 */
	private String sign;
	/** 状态 */
	private String trade_status;
	/** 订单号 */
	private String out_trade_no;

	public String getNotify_id() {
		return notify_id;
	}

	public void setNotify_id(String notify_id) {
		this.notify_id = notify_id;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getTrade_status() {
		return trade_status;
	}

	public void setTrade_status(String trade_status) {
		this.trade_status = trade_status;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

}
