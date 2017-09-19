package com.mycompany.observerpattern;

public class ChinaBroker implements Broker {
    private String name;

    /**
     * name getter
     * @return broker name
     */
    public String getName() {
        return name;
    }

    /**
     * class constructor
     * @param name
     */
    public ChinaBroker(String name) {
        this.name = name;
    }
    
    /**
     * listen new changes
     * @param newDollar
     */
    @Override
    public void notify(int newDollar) {
        System.out.println("new dollar course - " + newDollar);
    }
}
