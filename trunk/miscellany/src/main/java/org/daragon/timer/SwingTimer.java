package org.daragon.timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class SwingTimer implements ActionListener {

    Timer t = new Timer(1000,this);

    public SwingTimer() {
        t.start();
    }
    public void actionPerformed(ActionEvent e) {
        System.out.println("working...");
    }
    public static void main(String[] args) {
        SwingTimer t = new SwingTimer();
    }

}
