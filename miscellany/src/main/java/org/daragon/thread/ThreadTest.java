package org.daragon.thread;

public class ThreadTest implements Runnable {

    private long s;
    private String name;

    public ThreadTest(String name,long s) {
        this.name = name;
        this.s = s;
    }

    @Override
    public void run() {
        System.out.println("do something..." + name);
        try {
            Thread.sleep(s);
            Thread.yield();
            System.out.println(name+" finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
