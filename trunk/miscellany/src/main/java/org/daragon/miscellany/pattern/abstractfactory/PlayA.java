package org.daragon.miscellany.pattern.abstractfactory;

public class PlayA implements Player {

    public void kick(Ball o) {
        System.out.println("Player A");
        o.action();
    }

}
