package org.auction.module.manager.alipay.service.impl;

import java.io.FileWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.auction.alipay.AlipayConfig;
import org.auction.alipay.AlipayFunction;
import org.auction.alipay.Md5Encrypt;
import org.auction.entity.TsBuy;
import org.auction.entity.TsEcu;
import org.auction.entity.TsEcurr;
import org.auction.entity.TsOrder;
import org.auction.entity.TsUser;
import org.auction.module.manager.alipay.service.AlipayService;
import org.auction.module.manager.data.AlipayData;
import org.mobile.common.manager.GeneralManager;
import org.mobile.common.service.GeneralService;

public class AlipayServiceImpl extends GeneralService implements AlipayService {

	/**
	 * 支付宝返回参数业务处理return_url连接
	 */
	public void handleOrder(AlipayData model) throws Exception {
		String partner = AlipayConfig.partner;
		String alipayNotifyURL = "http://notify.alipay.com/trade/notify_query.do?"
				+ "partner=" + partner + "&notify_id=" + model.getNotify_id();
		// 获取支付宝ATN返回结果，true是正确的订单信息，false 是无效的
		String responseTxt = AlipayFunction.checkurl(alipayNotifyURL);
		String mysign = Md5Encrypt.md5(createSign());

		// 判断交易信息是否一致
		if (mysign.equals(model.getSign()) && responseTxt.equals("true")) {
			if (model.getTrade_status().equals("TRADE_FINISHED")
					|| model.getTrade_status().equals("TRADE_SUCCESS")) {
				// 业务处理
				String num = model.getOut_trade_no();
				// 判断单号长度（由于设计没有为购买E拍币设置订单表因此通过长度判断是商品订单还是购买E拍币）
				if (num.length() == 32) {
					// E拍币业务订单处理
					handlerEcu(num);
				} else if (num.length() == 21) {
					// 商品订单业务处理
					handlerOrder(num);
				}
			}
		}
	}

	/**
	 * 异步支付宝返回参数业务处理
	 * 
	 * @param model
	 * @return
	 */
	public void handler(AlipayData model) throws Exception {
		String partner = AlipayConfig.partner;
		String alipayNotifyURL = "http://notify.alipay.com/trade/notify_query.do?"
				+ "partner=" + partner + "&notify_id=" + model.getNotify_id();
		// 获取支付宝ATN返回结果，true是正确的订单信息，false 是无效的
		String responseTxt = AlipayFunction.checkurl(alipayNotifyURL);
		String s = createSign();
		FileWriter writer = new FileWriter("D:\\alipay_log"
				+ System.currentTimeMillis() + ".txt");
		writer.write(s);
		writer.close();
		String mysign = Md5Encrypt.md5(s);
		if (mysign.equals(model.getSign()) && responseTxt.equals("true")) {
			if (model.getTrade_status().equals("WAIT_BUYER_PAY")) {

			} else if (model.getTrade_status().equals("TRADE_FINISHED")
					|| model.getTrade_status().equals("TRADE_SUCCESS")) {
				String num = model.getOut_trade_no();
				// 判断单号长度（由于设计没有为购买E拍币设置订单表因此通过长度判断是商品订单还是购买E拍币）
				if (num.length() == 32) {
					TsEcu tsEcu = (TsEcu) generalDao.get(TsEcu.class, num);
					if (tsEcu.getState().equals("1")) {
						GeneralManager.getCurrentManager().getResponse()
								.getOutputStream().println("sucess");
					} else if (tsEcu.getState().equals("2")) {
						handlerEcu(num);
						GeneralManager.getCurrentManager().getResponse()
								.getOutputStream().println("sucess");
					}
				} else if (num.length() == 21) {
					TsOrder tsOrder = (TsOrder) generalDao.get(TsOrder.class,
							num);
					if (tsOrder.getState().equals("2")) {
						GeneralManager.getCurrentManager().getResponse()
								.getOutputStream().println("sucess");
					} else if (tsOrder.getState().equals("1")) {
						handlerOrder(num);
						GeneralManager.getCurrentManager().getResponse()
								.getOutputStream().println("sucess");
					}
				}
			}
		} else {
			GeneralManager.getCurrentManager().getResponse().getOutputStream()
					.println("fail");
			// 打印，收到消息比对sign的计算结果和传递来的sign是否匹配
			GeneralManager.getCurrentManager().getResponse().getOutputStream()
					.println(mysign + "-------" + model.getSign() + "<br>");
		}
	}

	/**
	 * E拍币业务处理
	 * 
	 * @param num
	 */
	private void handlerEcu(String num) throws Exception {
		TsEcu tsEcu = (TsEcu) generalDao.get(TsEcu.class, num);
		if (tsEcu != null && tsEcu.getState().equals("2")) {
			tsEcu.setState("1");
			TsEcurr tsEcurr = tsEcu.getTsEcurr();
			// 更新用户E币数量
			TsUser tsUser = tsEcu.getTsUser();
			tsUser.setPaycur(tsUser.getPaycur() + tsEcurr.getAmount()
					+ tsEcurr.getFreecount());
			// 记录E币购买明细
			TsBuy tsBuy = new TsBuy();
			tsBuy.setTsUser(tsUser);
			tsBuy.setBuytime(new Date());
			tsBuy.setRemark("购买" + tsEcurr.getAmount() + "E拍币赠送"
					+ tsEcurr.getFreecount() + "E拍币");
			tsBuy.setAmount(tsEcurr.getAmount());
			generalDao.update(tsEcu);
			generalDao.update(tsUser);
			generalDao.save(tsBuy);
		} else {
			throw new Exception("发生错误，请联系客服人员");
		}
	}

	/**
	 * 商品订单业务处理
	 * 
	 * @param num
	 * @throws Exception
	 */
	private void handlerOrder(String num) throws Exception {
		TsOrder tsOrder = (TsOrder) generalDao.get(TsOrder.class, num);
		if (tsOrder != null && tsOrder.getState().equals("1")) {
			tsOrder.setState("2");
			generalDao.update(tsOrder);
		} else {
			throw new Exception("发生错误，请联系客服人员");
		}
	}

	/**
	 * 根据参数生成sign
	 * 
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@SuppressWarnings("unchecked")
	private String createSign() throws Exception {
		GeneralManager manager = GeneralManager.getCurrentManager();
		Map params = new HashMap();
		Map requestParams = manager.getRequest().getParameterMap();
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			// 乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化（现在已经使用）
			valueStr = new String(valueStr.getBytes("ISO-8859-1"), "UTF-8");
			params.put(name, valueStr);
		}
		return AlipayFunction.sign(params, AlipayConfig.key);
	}
}
