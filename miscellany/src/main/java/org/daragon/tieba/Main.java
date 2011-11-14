package org.daragon.tieba;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

public class Main {

    private static String joinCookie(Cookie[] cs) {
        if (cs == null)
            return null;
        StringBuffer sBuf = new StringBuffer();
        int length = cs.length;
        for (int i = 0; i < length; i++) {
            sBuf.append(cs[i].getName()).append("=").append(cs[i].getValue()).append(";");
        }
        return sBuf.substring(0,sBuf.length()-1);
    }
    
    public static void main(String[] args) throws IOException {
        
        HttpClient client = new HttpClient();
        client.getHostConfiguration().setHost("http://www.bato.cn", 80);
//        Cookie[] c1 = client.getState().getCookies();
//        System.out.println(joinCookie(c1));
        //登录过程
        PostMethod postMethod = new PostMethod("http://bbs.bato.cn/logging.php?action=login&loginsubmit=true");
        NameValuePair[] data = {
                new NameValuePair("username", "daragon"),
                new NameValuePair("password", "tianshanxue"), 
                new NameValuePair("cookietime", "86400"),
                new NameValuePair("imageField", ""), 
                new NameValuePair("loginfield", "username"),
                new NameValuePair("referer", "http://www.bato.cn/"), };
        postMethod.setRequestBody(data);
        client.executeMethod(postMethod);
        
        Cookie[] c2 = client.getState().getCookies();
        client.getState().addCookies(c2);
        String cookieHeader =  joinCookie(c2);
//        postMethod.setRequestHeader("Cookie",cookieHeader );
        
//        for (Cookie c : client.getState().getCookies()) {
//            System.out.println(c.getName() + ":" + c.getValue());
//        }

        postMethod.releaseConnection();

        //转向发贴模块
          GetMethod getMethod = new GetMethod("http://bbs.bato.cn/forumdisplay.php?fid=4");
          getMethod.setRequestHeader("Cookie", cookieHeader);
          client.executeMethod(getMethod); 
          Cookie[] c3 = client.getState().getCookies(); 
          
          client.getState().addCookies(c3);
          BufferedReader reader = new BufferedReader(new InputStreamReader(getMethod.getResponseBodyAsStream(),"GB2312"));
          String line = null;
          while((line=reader.readLine())!=null){
              System.out.println(line);
          }
          cookieHeader = joinCookie(c3);
          System.out.println(cookieHeader);
          System.exit(0);
          GetMethod getMethod2 = new GetMethod("http://bbs.bato.cn/thread-1146587-1-1.html");
          getMethod2.setRequestHeader("Cookie", cookieHeader);
          client.executeMethod(getMethod2);
          Cookie[] c4 = client.getState().getCookies(); 
          
          client.getState().addCookies(c4);
          
          
          PostMethod s = new PostMethod("http://bbs.bato.cn/post.php?action=reply&fid=4&tid=1145370&extra=&replysubmit=yes&infloat=yes&handlekey=fastpost&inajax=1"
          ); 
          NameValuePair[] data2 = { new NameValuePair("formhash",
          "0ec24497"), new NameValuePair("message", "haikeyddddi"), new
          NameValuePair("subject", "") , new NameValuePair("usesig", "0") , };
          s.setRequestBody(data2); client.executeMethod(s); Cookie[] fid4 =
          client.getState().getCookies(); client.getState().addCookies(fid4);
          System.out.println(s.getStatusText());;
          System.out.println(s.getResponseBodyAsString());
          s.releaseConnection();
         

    }

}
