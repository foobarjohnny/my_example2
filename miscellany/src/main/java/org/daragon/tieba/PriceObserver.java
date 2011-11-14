package org.daragon.tieba;

import java.util.Observable;
import java.util.Observer;

public class PriceObserver implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof Float)
            System.out.println("Price changed to :" + arg);
    }

}
