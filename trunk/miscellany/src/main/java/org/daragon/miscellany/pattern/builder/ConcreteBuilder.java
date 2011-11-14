package org.daragon.miscellany.pattern.builder;

public class ConcreteBuilder extends Builder{
    private Product product = new Product();
    @Override
    public void buildPart1() {
        //build the first part of product
    }

    @Override
    public void buildPart2() {
        //build the second part of product
    }

    @Override
    public Product retrieveResult() {
        return product;
    }

}
