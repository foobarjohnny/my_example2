package org.daragon.timer;

import java.util.Timer;
import java.util.TimerTask;

public class MainClass {
    private boolean running;                               
    private MyTask task;
    private Timer timer;
    public MainClass(){
        timer = new Timer(true);
    }
    
    public boolean isRinging(){
        return running;
    }

    public void startRinging(){
        running=true;
        task = new MyTask();
        timer.scheduleAtFixedRate(task, 0, 3000);
    }
    public void doIt(){
        running=false;
        System.out.println(task.getCounter()+"times");
        task.cancel();
        
    }
    
    
    public static void main(String[] args) throws InterruptedException {
        MainClass phone = new MainClass();
        phone.startRinging();
        try {
          System.out.println("started running...");
          Thread.sleep(20000);
        } catch (InterruptedException e) {
        }
        phone.doIt();
    }
}

class MyTask extends TimerTask {
    int counter;

    public MyTask() {
        counter = 0;
    }

    public void run() {
        counter++;
        System.out.println("ring" + counter);
    }

    public int getCounter() {
        return counter;
    }

}
