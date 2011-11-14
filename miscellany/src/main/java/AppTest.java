import java.net.URL;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.apache.xmlrpc.client.XmlRpcCommonsTransportFactory;

/**
 * Unit test for simple App.
 */
public class AppTest {

    public static void main(String[] args) throws Exception {
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://172.16.9.90:9988/"));
        // config.setEnabledForExtensions(true);
        config.setConnectionTimeout(60 * 1000);
        config.setReplyTimeout(60 * 1000);

        XmlRpcClient client = new XmlRpcClient();

        // use Commons HttpClient as transport
        client.setTransportFactory(new XmlRpcCommonsTransportFactory(client));
        // set configuration
        client.setConfig(config);

        Map m =new LinkedHashMap();
        m.put("objectName", "com.bea:ServerRuntime=examplesServer,Name=ThreadPoolRuntime,Type=ThreadPoolRuntime");
        m.put("attributeName", "CompletedRequestCount");
        m.put("manageIp", "172.20.16.122");
        m.put("dps", new String[] { "CompletedRequestCount" });
        m.put("jmxProtocol", "RMI");
        m.put("rmiContext", "jmxrmi");
        m.put("jmxPort", "12347");
        m.put("authenticate", false);
//        m.put("", value);

        List<Map<?,?>> params = new LinkedList<Map<?,?>>();
        params.add(m);

        // make the a regular call
        System.out.println(client.execute("zenjmx.collect", params));

//        JmxCollectService s = new JmxCollectService();
//        System.out.println(s.collect(params));;
        
    }
}
