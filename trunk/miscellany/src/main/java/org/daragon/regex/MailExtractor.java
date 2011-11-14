package org.daragon.regex;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailExtractor {
	private final static String mail_regex = "(?i)\\w+@\\w+\\.(com|org|cc|cn|edu)";

	public static void main(String[] args) throws MalformedURLException, IOException {

		FileInputStream fis = new FileInputStream("/home/liujijun/workspace/miscellany/src/main/java/temp");
		FileChannel channel = fis.getChannel();
		MappedByteBuffer mbb = channel.map(MapMode.READ_ONLY, 0, channel.size());
		CharBuffer cb = Charset.forName("utf-8").decode(mbb);

		Pattern pattern = Pattern.compile(mail_regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(cb);
		while(matcher.find()){
			System.out.println(matcher.group());
		}
	}
}
