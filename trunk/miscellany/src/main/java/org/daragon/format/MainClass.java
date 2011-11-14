package org.daragon.format;

import java.util.Formatter;

public class MainClass {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Formatter fmt = new Formatter();
        fmt.format("%E", 123.1234);
        System.out.println(fmt);
        
        
        
    }

}
