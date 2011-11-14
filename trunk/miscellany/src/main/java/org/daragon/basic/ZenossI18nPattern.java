package org.daragon.basic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ZenossI18nPattern {

	private static final String regex = "_t\\(\\'(.*)\\')";
	private static final Pattern p = Pattern.compile(regex);

	public static void main(String[] args) {
		String s = "_t('Server Exception')";
		Matcher m = p.matcher(s);
		if (m.matches()) {
			System.out.println("hello world");
		}
	}
}
