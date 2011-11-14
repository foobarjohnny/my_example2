package org.daragon.model;

import java.net.InetAddress;

public interface IResourceModeler extends Runnable {
    void doModel();
}

abstract class AbstractResourceModeler implements IResourceModeler {

    private static final String DEFAULT_SNMP_VERSION   = null;
    private static final String DEFAULT_READ_COMMUNITY = null;
    private InetAddress         address;
    private int                 port;
    private String              snmpVer                = DEFAULT_SNMP_VERSION;
    private String              community              = DEFAULT_READ_COMMUNITY;

    public InetAddress getAddress() {
        return address;
    }

    public void setAddress(InetAddress address) {
        this.address = address;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

}

class CpuModeler extends AbstractResourceModeler {

    @Override
    public void doModel() {
        System.out.println("Cpu 采集");
    }

    @Override
    public void run() {
        
    }




}
