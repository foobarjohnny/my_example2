package org.daragon.console;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class MainClass {

    public static void main(String[] args) throws IOException {

        StreamTokenizer tf = new StreamTokenizer(new InputStreamReader(System.in));
        String s = null;
        int i;

        while ((i = tf.nextToken()) != StreamTokenizer.TT_EOF) {
            switch (i) {
            case StreamTokenizer.TT_EOF:
                System.out.println("End of file");
                break;
            case StreamTokenizer.TT_EOL:
                System.out.println("End of line");
                break;
            case StreamTokenizer.TT_NUMBER:
                System.out.println("Number " + tf.nval);
                break;
            case StreamTokenizer.TT_WORD:
                System.out.println("Word, length " + tf.sval.length() + "->" + tf.sval);
                break;
            default:
                System.out.println("What is it? i = " + i);
            }
        }
    }
}
