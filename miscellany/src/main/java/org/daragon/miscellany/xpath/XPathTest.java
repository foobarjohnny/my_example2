package org.daragon.miscellany.xpath;

import java.io.IOException;
import java.io.InputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class XPathTest {
public static void main(String[] args) throws DocumentException, IOException {
    InputStream is = XPathTest.class.getResourceAsStream("org/daragon/miscellany/xpath/bookstore.xml");
    
    SAXReader reader = new SAXReader();
    Document doc = reader.read(is);    
    System.out.println(doc.valueOf("/bookstore/book[1]/@lang"));
    
    
}
}
