package org.daragon.miscellany.pattern;

import org.daragon.miscellany.pattern.singleton.LingualResource;

public class Client {
public static void main(String[] args) {
    LingualResource ling = LingualResource.getInstance("en", "US");
    String usDollar = ling.getLocaleString("USD");
    System.out.println(usDollar);
}
}
