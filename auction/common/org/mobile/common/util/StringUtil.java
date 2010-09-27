package org.mobile.common.util;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 字符串的工具类
 * @author Administrator
 *
 */
public final class StringUtil {

	/**
	 * 使用指定的字符串替换原始字符串
	 * @param str
	 * @param replace
	 * @return
	 */
	public static String wrap(String str, String replace){
		if(str == null || str.length() == 0){
			return replace;
		}else{
			return str;
		}
	}
	
	public static String wrap(String str){
		return wrap(str, "");
	}
	
	public static int wrapInt(String str, int n){
		if(str == null || str.length() == 0 ){
			return n;
		}else{
			return Integer.parseInt(str);
		}
	}
	
	public static int wrapInt(String str){
		return wrapInt(str, 0);
	}
	
	/**
	 * 将日期类型的对象转变成为毫秒级的字符串返回.
	 * @param date
	 * @param str
	 * @return
	 */
	public static String wrapDate(Date date, String str){
		if(date == null ){
			return str;
		}else{
			return "" + date.getTime();
		}
	}

	public static String wrapDate(Date date){
		return wrapDate(date,"0");
	}
	
	public static String wrapDecimal(BigDecimal big, String str){
		if(big == null){
			return str; 
		}else{
			return big.toString();
		}
	}
	
	public static String wrapDecimal(BigDecimal big){
		return wrapDecimal(big, "0");
	}
		
	/**
	 * 测试方法
	 * @param args
	 */
	public static void main(String[] args){
		BigDecimal big = new BigDecimal(23234.234234);
		System.out.println(wrapDecimal(big));
	}
}
