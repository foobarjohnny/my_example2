package org.daragon.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThreadPool {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(2);
        for (int index = 0; index < 100; index++) {
            Runnable runner = new Runner(index);
            exec.execute(runner);
        }
        exec.shutdown();
    }

}

class Runner implements Runnable {
    int index = 0;

    public Runner(int index) {
        super();
        this.index = index;
    }

    public void run() {
        long time = (long) (Math.random() * 1000);
        // 输出线程的名字和使用的目标对象及休眠时间
        System.out
                .println("线程：" + Thread.currentThread().getName() + "（目标对象" + index + ")" + ":Sleeping" + time + "ms");
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}