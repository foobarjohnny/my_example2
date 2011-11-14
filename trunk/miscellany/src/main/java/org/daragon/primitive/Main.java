package org.daragon.primitive;


public class Main {
    public static void main(String[] args) {
        String text = "to be or not to.be, that is the question.";
        String[] words = text.split("[, .]", 0); // Delimiters are comma, space, or period
        
        for(String s: words){
          System.out.println(s);
        }
    }
}
