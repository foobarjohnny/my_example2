package org.daragon.concurrent;


public class Threadtest extends Thread{
    public Threadtest(String name){
        super(name);
    }
    public static void main(String[] args) {
        for(int i=0;i<5;i++){
            new Threadtest("thread"+i).start();
            
        }
    }
    @Override
    public void run() {
        for(int i=0;i<20;i++){
            System.out.println(getName()+":"+i);
        }
        
    
    }
    
}
