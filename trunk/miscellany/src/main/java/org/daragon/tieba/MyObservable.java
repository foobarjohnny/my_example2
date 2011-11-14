package org.daragon.tieba;

import java.util.Observable;
import java.util.Observer;

public class MyObservable extends Observable {

    private String name;
    
    public void drinkPotion() {
        name = "java2s ";
        setChanged();
        notifyObservers();
      }
    
    
    
}

class Person implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        
    }
}