package org.daragon.miscellany.pattern.singleton;

import java.util.HashMap;

public class RegSingleton {
    private static HashMap m_registry = new HashMap();
    
    static{
        RegSingleton x = new RegSingleton();
        m_registry.put(x.getClass().getName(), x);
    }
    protected RegSingleton() {
    }
    
    public static RegSingleton getInstance(String name) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
        if(name==null){
            name = RegSingleton.class.getName();
        }
        
        if(m_registry.get(name)==null){
            m_registry.put(name, Class.forName(name).newInstance() );
        }
        return (RegSingleton) m_registry.get(name);
    }
    
    public String about(){
        return "I am RegSingleton";
    }
}
