package org.daragon.miscellany.test;

import java.util.ArrayList;
import java.util.List;

public class MyComponentContext implements ComponentContext {
    private static List<Component> comps = new ArrayList<Component>();
    static {
        Component c = new Component();
        c.initialDelay = 1000;
        c.setInterval(3000);
        c.setName("c1");
        comps.add(c);

        Component c2 = new Component();
        c2.initialDelay = 1000;
        c2.setInterval(2000);
        c2.setName("c2");
        comps.add(c2);
    }

    public List<Component> getComponents() {
        return comps;
    }

}
