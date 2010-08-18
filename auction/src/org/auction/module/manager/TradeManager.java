package org.auction.module.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.auction.module.manager.data.TradeData;

public class TradeManager {

	private static Map<String, TradeData> tradeDataMap = new HashMap<String, TradeData>();

	/**
	 * 添加正在商品
	 * 
	 * @param tradeData
	 */
	public static void add(TradeData tradeData) {
		tradeDataMap.put(tradeData.getId(), tradeData);
	}
	
	/**
	 * 获得指定商品
	 * @param key
	 * @return
	 */
	public static TradeData get(String key) {
		return tradeDataMap.get(key);
	}

	/**
	 * 删除已经竞拍的商品
	 * 
	 * @param tradeData
	 */
	public static void remove(TradeData tradeData) {
		tradeDataMap.remove(tradeData.getId());
	}
	
	@SuppressWarnings("unchecked")
	public static List<TradeData> getTradeData() {
		List<TradeData> list = new ArrayList<TradeData>();
		if (tradeDataMap != null && tradeDataMap.size() > 0) {
			Iterator it = tradeDataMap.keySet().iterator();
			while (it.hasNext()) {
				String key = it.next().toString();
				list.add(tradeDataMap.get(key));
			}
		}
		return list;
	}

	/**
	 * 获得存在商品ID
	 * 
	 * @return
	 */
	public static String[] getId() {
		if (tradeDataMap != null && tradeDataMap.size() > 0) {
			String[] strs = new String[tradeDataMap.size()];
			return tradeDataMap.keySet().toArray(strs);
		} else {
			return null;
		}
	}
}
