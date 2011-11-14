package org.daragon.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MisRegex {
	private static String ip_regex = "([12]?[0-5]?[0-5]?\\.){3}[12]?[0-5]?[0-5]?";

	private static boolean checkIP(String ip) {

		Pattern p = Pattern.compile(ip_regex);
		if (Pattern.matches(ip_regex, ip)) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// System.out.println(checkIP("233.256.34.33"));
		// System.out.println("davidd".matches("[a-z]{5}"));
		//
		//
		// System.out.println("R".matches("[A-Z&&[^R-T]]"));
		//
		// System.out.println(" \t\r\n".matches("\\s{4}"));
		// System.out.println("abc".matches("\\p{Lower}{3}"));

		// String test = "abdfadf-dfafw22-we23dd";
		//
		// System.out.println(m.find());
		// System.out.println(m.start()+"-"+m.end());
		// System.out.println(m.find());
		// System.out.println(m.start()+"-"+m.end());
		// System.out.println(m.lookingAt());
		// System.out.println(m.lookingAt());

		String s = "Java java JaVa jAVa jaVA I loveJava you Hate JAVa abceddsfsda";
		// System.out.println(s.replaceAll("(?i)java", "JAVA"));

		Matcher m = Pattern.compile("java", Pattern.CASE_INSENSITIVE).matcher(s);
		int i = 0;
		StringBuffer sBuf = new StringBuffer();
		while (m.find()) {
			System.out.println(m.start() + "---" + m.end());
			System.out.println(m.group());
			if (++i % 2 == 0) {
				m.appendReplacement(sBuf, "JAVA");
			} else {
				m.appendReplacement(sBuf, "java");
			}
		}
		m.appendTail(sBuf);
		System.out.println(sBuf);

	}

}
