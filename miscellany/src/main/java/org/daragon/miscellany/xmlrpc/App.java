package org.daragon.miscellany.xmlrpc;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

/**
 * 通过xmlrpc方式访问ZenJMX提供的数据，需要客户提供ip,port 这个系统非常灵活，可以作为分布式应用
 */
public class App {
    private static String ip    = "172.16.9.90";
    private static int    port  = 9988;
    private static String mName = "zenjmx.collect";

    public static void main(String[] args) throws MalformedURLException, XmlRpcException {
        // port = self.rpcPort
        // xmlRpcProxy = xmlrpc.Proxy('http://localhost:%s/' % port)
        // yield xmlRpcProxy.callRemote('zenjmx.collect', configMaps)
        // results = driver.next()
        // self.log.debug('rpcCall(): result is %s' % results)
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();

        config.setServerURL(new URL(String.format("http://%s:%s", ip, port)));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);
        Object[] params = new Object[] { new Integer(33), new Integer(9) };
        Integer result = (Integer) client.execute(mName, params);
    }
}
