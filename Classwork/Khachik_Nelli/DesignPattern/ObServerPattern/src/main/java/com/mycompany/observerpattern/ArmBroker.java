package com.mycompany.observerpattern;


public class ArmBroker implements Broker {
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
    public ArmBroker(String name) {
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
