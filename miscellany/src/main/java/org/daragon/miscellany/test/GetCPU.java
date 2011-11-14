package org.daragon.miscellany.test;

import java.util.List;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GetCPU {

    static ExecutorService          ses     = Executors.newCachedThreadPool();
    private static ComponentContext context = new MyComponentContext();

    public static void main(String[] args) throws InterruptedException {
        List<Component> comps = context.getComponents();
        // for (Component comp : comps) {
        // ses.scheduleAtFixedRate(new MyTimerTask(comp), comp.initialDelay,
        // comp.getInterval(), TimeUnit.MILLISECONDS);
        // }
        for (Component c : comps) {
            
        }
        // ses.awaitTermination(5, TimeUnit.MINUTES);
    }

    static class MyTimerTask extends TimerTask {
        private Component c;

        public MyTimerTask(Component c) {
            super();
            this.c = c;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(c.getInterval());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // try {
            // Thread.sleep(2000);
            // } catch (InterruptedException e) {
            // e.printStackTrace();
            // }
            System.out.print(c.getName() + " Thread Name:" + Thread.currentThread().getName());
            System.out.println(" 执行间隔为" + c.getInterval());
        }
    }
}
