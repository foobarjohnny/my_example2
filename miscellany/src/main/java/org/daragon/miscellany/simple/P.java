package org.daragon.miscellany.simple;

public class P {

    static {
        System.out.println("P static 1");
    }
    {
        System.out.println("P non-static");
    }
    static {
        System.out.println("P static 2");
    }

    public P() {
        System.out.println("P constructor");
    }
}
