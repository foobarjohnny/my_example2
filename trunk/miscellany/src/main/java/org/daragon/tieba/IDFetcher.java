package org.daragon.tieba;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IDFetcher {
    // ÿҳ������
    private static final int    T_NUM           = 50;
    private static final String lastPagePattern = ".*<a href=\"/f\\?kw=.*\\&pn=(\\d*)\">βҳ</a>.*";

    private static final String titlePattern    = ".*<a href=\"/f\\?kz=(\\d*)\" target=\"_blank\">.*</a>.*";

    private static String       tiebaUrl        = "http://tieba.baidu.com/f?pn=0&kw=";

    public static void main(String[] args) throws MalformedURLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("���������[������У]��");
        String input = scanner.nextLine();
        if ("".equals(input)) {
            input = "������У";
        }

        URL url = new URL(tiebaUrl + input);
        Pattern pattern = Pattern.compile(lastPagePattern);
        try {
            BufferedReader bufReader = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream(),
                    "GBK"));
            String line = null;
            String snum = null;
            while ((line = bufReader.readLine()) != null) {
                Matcher m = pattern.matcher(line);
                if (m.matches()) {
                    snum = m.group(1);
                    break;
                }
            }
            if (snum == null) { throw new RuntimeException("���쳣����"); }
            Integer inum = Integer.parseInt(snum);
            pattern = Pattern.compile(titlePattern);
            FileWriter fWriter = new FileWriter(input + ".txt");
            for (int i = 0; i <= inum; i += T_NUM) {
                URL tieziUrl = new URL("http://tieba.baidu.com/f?kw=" + input + "&pn=" + i);
                BufferedReader reader = new BufferedReader(new InputStreamReader(tieziUrl.openConnection()
                        .getInputStream(), "GBK"));
                while ((line = reader.readLine()) != null) {
                    Matcher m = pattern.matcher(line);
                    if (m.matches()) {
                        snum = m.group(1);
                        fWriter.append(snum + System.getProperty("line.separator"));
                        // System.out.println(snum);
                    }
                }
            }
            fWriter.flush();
            fWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
