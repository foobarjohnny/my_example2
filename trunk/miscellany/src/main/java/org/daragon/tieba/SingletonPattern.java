package org.daragon.tieba;

public class SingletonPattern {
    
    public static void main(String[] args) {
        Singleton s = Singleton.getReference();
        String result = "" + s.getValue();
        System.out.println(result);
        Singleton s2 = Singleton.getReference();
        s2.setValue(9);
        result = "" + s.getValue();
        System.out.println(result);
    }
}
class Singleton {
    private static Singleton s = new Singleton(47);

    private int              i;

    private Singleton(int x) {
        i = x;
    }

    public static Singleton getReference() {
        return s;
    }

    public int getValue() {
        return i;
    }

    public void setValue(int x) {
        i = x;
    }
}
