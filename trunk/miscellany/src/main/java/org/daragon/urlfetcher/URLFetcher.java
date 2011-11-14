package org.daragon.urlfetcher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class URLFetcher {

	public static void main(String[] args) throws IOException {
		URL url = new URL("http://www.qq.com");
		InputStream iStream =	url.openStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(iStream,"gb2312"));
		String line;
		while((line=reader.readLine())!=null){
			System.out.println(line);
		}
	}
}
