package org.daragon;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
	static final String pattern = ".*_t\\(\\'(.*)\\'\\).*";
	static final Pattern p = Pattern.compile(pattern);

	public static void main(String[] args) throws UnknownHostException,
			IOException {

		Matcher m = p.matcher("daw_t('david')wada");
		// 遍历目录，取得合适的文件，加入集合类
		// 读取文件行，匹配每行
		if (m.matches()) {
			System.out.println(m.group(1));
		}

	}
}