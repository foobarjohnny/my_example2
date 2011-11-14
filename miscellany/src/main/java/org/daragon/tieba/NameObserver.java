package org.daragon.tieba;

import java.util.Observable;
import java.util.Observer;

public class NameObserver implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof String)
            System.out.println("Product'n name changed to " + arg);
    }
}
