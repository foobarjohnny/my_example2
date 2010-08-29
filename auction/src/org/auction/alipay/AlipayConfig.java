package org.auction.alipay;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * 支付宝配置
 * 
 * @author ThinkPad
 * 
 */
public class AlipayConfig {
	/** 接口名称 */
	public static String service;
	/** 支付宝/财付通的ID */
	public static String partner;
	/** 参数编码字符集 */
	public static String input_charset;
	/** 通知返回的URL */
	public static String notify_url;
	/** 签名方式 */
	public static String sign_type;
	/** 错误返回URL */
	public static String error_notify_url;
	/** 处理完请求后返回URL */
	public static String return_url;
	/** 卖家Email */
	public static String seller_email;
	/** 交易安全校验码 */
	public static String key;
	/** 请求网关 */
	public static String gateway;
	/** 请求网关 */
	public static String payment_type;

	/**
	 * 初始化参数
	 * 
	 * @throws Exception
	 */
	public void init() throws Exception {
		URL url = this.getClass().getResource("/resources.properties");
		String file = url.getFile();
		InputStream is = new FileInputStream(new File(file));
		Properties properties = new Properties();
		properties.load(is);
		service = properties.getProperty("alipay.service").trim();
		partner = properties.getProperty("alipay.partner").trim();
		input_charset = properties.getProperty("alipay.charset").trim();
		notify_url = properties.getProperty("alipay.notify_url").trim();
		sign_type = properties.getProperty("alipay.sign_type").trim();
		return_url = properties.getProperty("alipay.return_url").trim();
		seller_email = properties.getProperty("alipay.sellerEmail").trim();
		key = properties.getProperty("alipay.key").trim();
		gateway = properties.getProperty("alipay.gateway").trim();
		payment_type = properties.getProperty("alipay.payment_type").trim();
	}

	/**
	 * 创建URL GET请求方式
	 * 
	 * @param params
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static String createUrl_Get(Map params) {
		// 调用MD5加密方法生成sign值
		String sign = Md5Encrypt.md5(getContent_public(params, key));
		String parameter = "";
		parameter = parameter + gateway;
		List keys = new ArrayList(params.keySet());
		for (int i = 0; i < keys.size(); i++) {
			try {
				parameter = parameter
						+ keys.get(i)
						+ "="
						+ URLEncoder.encode((String) params.get(keys.get(i)),
								input_charset) + "&";
			} catch (UnsupportedEncodingException e) {

				e.printStackTrace();
			}
		}
		parameter = parameter + "sign=" + sign + "&sign_type=" + sign_type;
		return parameter;
	}

	/**
	 * 创建参数集合,通过
	 * 
	 * @param params
	 * @param privateKey
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static String getContent_public(Map params, String privateKey) {
		List keys = new ArrayList(params.keySet());
		Collections.sort(keys);
		String prestr = "";
		for (int i = 0; i < keys.size(); i++) {
			String k = (String) keys.get(i);
			String value = (String) params.get(k);

			if (i == keys.size() - 1) {
				prestr = prestr + k + "=" + value;
			} else {
				prestr = prestr + k + "=" + value + "&";
			}
		}
		return prestr + privateKey;
	}
}
