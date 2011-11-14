package org.daragon.console;

import java.io.Console;

public class PwdReader {
    public static void main(String[] args) {
        Console console = System.console();
        if (console == null) {
            System.err.println("No console.");
            System.exit(1);
          }
        char[] password = console.readPassword();
        System.out.println(password);
        
    }
}
