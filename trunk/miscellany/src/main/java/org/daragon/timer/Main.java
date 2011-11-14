package org.daragon.timer;

import java.util.Timer;
import java.util.TimerTask;

public class Main {
    private Timer timer;

    public Main(long seconds) {
        timer = new Timer();
        timer.schedule(new ToDoTask(), seconds * 1000);
    }

    class ToDoTask extends TimerTask {

        @Override
        public void run() {
            System.out.println("running");
            timer.cancel();
        }
    }
public static void main(String[] args) {
    Main m = new Main(5);
}
}
