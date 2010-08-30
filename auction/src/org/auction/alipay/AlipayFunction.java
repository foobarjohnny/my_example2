package org.auction.alipay;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * 该类支付宝提供功能函数
 * 
 * @author ThinkPad
 * 
 */
public class AlipayFunction {

	/**
	 * 支付宝提供---检测URL 输出对应的参数对应错误： 1.invalid命令参数不对 出现这个错误，请检测返回处理中partner和key是否为空
	 * 2.true 返回正确信息 3.false 请检查防火墙或者是服务器阻止端口问题以及验证时间是否超过一分钟
	 * 
	 * @param urlvalue
	 * @return
	 */
	public static String checkurl(String urlvalue) {
		String inputLine = "";
		try {
			URL url = new URL(urlvalue);
			HttpURLConnection urlConnection = (HttpURLConnection) url
					.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(
					urlConnection.getInputStream()));
			inputLine = in.readLine().toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inputLine;
	}

	@SuppressWarnings("unchecked")
	public static String sign(Map params, String privateKey) {
		Properties properties = new Properties();
		for (Iterator iter = params.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			Object value = params.get(name);
			if (name == null || name.equalsIgnoreCase("sign")
					|| name.equalsIgnoreCase("sign_type")) {
				continue;
			}
			properties.setProperty(name, value.toString());
		}
		String content = getSignatureContent(properties);
		if (privateKey == null) {
			return null;
		}
		String signBefore = content + privateKey;
		return signBefore;
	}

	/**
	 * 功能：对交易返回参数按照“参数=参数值”的模式用“&”字符拼接成字符串
	 * 
	 * @param properties
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static String getSignatureContent(Properties properties) {
		StringBuffer content = new StringBuffer();
		List keys = new ArrayList(properties.keySet());
		Collections.sort(keys);
		for (int i = 0; i < keys.size(); i++) {
			String key = (String) keys.get(i);
			String value = properties.getProperty(key);
			content.append((i == 0 ? "" : "&") + key + "=" + value);
		}
		return content.toString();
	}
}
