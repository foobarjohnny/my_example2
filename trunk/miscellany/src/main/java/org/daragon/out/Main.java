package org.daragon.out;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("/home/paragon/a");
        PrintStream ps = new PrintStream(f);
        System.setOut(ps);
        System.out.println("dheed");
    }
}
