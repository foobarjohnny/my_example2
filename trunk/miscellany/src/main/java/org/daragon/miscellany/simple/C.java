package org.daragon.miscellany.simple;

public class C extends P {

    static {
        System.out.println("C static 1");
    }
    {
        System.out.println("C non-static");
    }
    static {
        System.out.println("C static 2");
    }
    public C() {
        super();
        System.out.println("C construtor");
    }
}
