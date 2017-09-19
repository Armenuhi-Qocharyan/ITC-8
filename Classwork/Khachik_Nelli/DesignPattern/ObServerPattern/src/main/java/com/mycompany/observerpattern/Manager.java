
package com.mycompany.observerpattern;

import java.util.ArrayList;


public class Manager {
    private int dollar;
    private ArrayList <Broker> brokers;

    /**
     * class constructor
     */
    public Manager() {
        this.brokers = new ArrayList<Broker>();
    }
    
    /**
     * set new dollar value
     * @param dollar 
     */
    public void setDollar(int dollar) {
        this.dollar = dollar;
    }
    
    /**
     * add new broker
     * @param broker
     */
    public void addBroker(Broker broker) {
        this.brokers.add(broker);
    }
    
    /**
     * remove broker from list
     * @param broker
     * @return true for success else false
     */
    public boolean removeBroker(Broker broker) {
        if (this.brokers.indexOf(broker) > -1) {
            this.brokers.remove(broker);
            return true;
        }
        return false;
    }
    
    /**
     * notify all brokers if dollar course changed
     */
    public void update() {
        for (Broker broker: brokers) {
            broker.notify(this.dollar);
        }
    }
}
