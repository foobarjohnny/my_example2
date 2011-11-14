package org.daragon.concurrent;

public class Main{

    public static void main(String[] args){
        
        Thread d = new Thread(new LiftOff());
        d.start();
        System.out.println("Waiting for Lift off");
    }
    



}