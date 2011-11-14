package org.daragon.primitive;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.builder.HashCodeBuilder;

public class URLClassLoaderTest {
    public static void main(String[] args) {
        
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        URLClassLoader ucl = (URLClassLoader) cl;
        List<URL> l = Arrays.asList(ucl.getURLs());
        System.out.println(System.identityHashCode(l));;
        System.out.println(l.hashCode());
        for(URL u:l){
            System.out.println(u);
        }
    }
    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(12).toHashCode();
    
    }
}
