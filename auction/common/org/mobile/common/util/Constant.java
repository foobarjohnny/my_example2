package org.mobile.common.util;

/**
 * [类说明]：该系统中所涉及到的所有的常量类 [注意事项]：
 * 
 * @author 郭昕
 * 
 */
public class Constant {
	// 每页显示的竞拍产品的数量
	public static int SIZE_PER_PAGE = 10;

	public static class COMMODITY_STATE {
		public static String AUCTION_STATE = "1"; // 正在竞拍商品
		public static String CANCEL_STATE = "2"; // 流拍商品
		public static String SUCCESS_STATE = "3"; // 成交商品'
		public static String UNKNOWN_STATE = "4"; // 新建的商品

		public static String UNLIMITED = "1"; // 无限制
		public static String CHARGE = "2"; // 收费
		public static String FREE = "3"; // 免费
	}

	public static String YES = "Y";
	public static String NO = "N";

	public static String LIKE = "like";
	public static String EQ = "eq";
	public static String LT = "lt";
	public static String GT = "gt";
	public static String GE = "ge";
	public static String LE = "le";
	public static String NEQ = "neq";
	public static String NULL = "null";
	public static String NOTNULL = "notnull";
	public static String TRADE_IMAGES = "TS_COMMODITY";
}
