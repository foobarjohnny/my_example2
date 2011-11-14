package org.daragon.miscellany.xmlbind;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.daragon.miscellany.xmlbind.generated.GreetingListType;
import org.daragon.miscellany.xmlbind.generated.GreetingType;
import org.daragon.miscellany.xmlbind.generated.ObjectFactory;

public class Hello {
    private ObjectFactory    of;
    private GreetingListType grList;

    public Hello() {
        super();
        of = new ObjectFactory();
        grList = of.createGreetingListType();
    }

    public void make(String t, String l) {
        GreetingType g = of.createGreetingType();
        g.setText(t);
        g.setLanguage(l);
        grList.getGreeting().add(g);
    }

    public void marshal() throws JAXBException {
        JAXBElement<GreetingListType> gl = of.createGreetings(grList);
        JAXBContext jc = JAXBContext.newInstance("org.daragon.miscellany.xmlbind.generated");
        Marshaller m = jc.createMarshaller();
        m.marshal(gl, System.out);
    }

    public static void main(String[] args) throws JAXBException {
        Hello h = new Hello();
        h.make("Bonjour, madame", "fr");
        h.make("Hey, you", "en");
        h.marshal();
    }

}
