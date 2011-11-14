package org.daragon.miscellany.simple;


public class Test {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class.forName(C.class.getName()).newInstance();
    }
}
