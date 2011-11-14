package org.daragon.tieba;

import java.util.Observable;

public class Product extends Observable {
    private String name;
    private float  price;

    public String getName() {
        return name;
    }

    private void setName(String name){
        this.name = name;
        setChanged();
        notifyObservers(name);
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
        setChanged();
        notifyObservers(price);
    }

    
}
