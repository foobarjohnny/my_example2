package org.auction.module.manager.data;

import java.util.Comparator;

/**
 * 缓存商品信息排序
 * 
 * @author ThinkPad
 * 
 */
public class TradeComparator implements Comparator<TradeData> {

	/**
	 * 接口排序方法
	 */
	public int compare(TradeData o1, TradeData o2) {
		long t1 = o1.getOvertime().getTime();
		long t2 = o2.getOvertime().getTime();
		return (int) (t1 - t2);
	}

}
