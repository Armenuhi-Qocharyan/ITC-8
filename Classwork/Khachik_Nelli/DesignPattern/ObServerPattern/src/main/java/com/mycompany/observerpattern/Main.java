
package com.mycompany.observerpattern;


public class Main {
    public static void main(String[] args) {
        Manager customManager = new Manager();
        Broker armBroker = new ArmBroker("Khacho");
        Broker chinaBroker = new ChinaBroker("Nelli");

        customManager.addBroker(armBroker);
        customManager.addBroker(chinaBroker);
        customManager.setDollar(500);
        customManager.update();
        customManager.removeBroker(chinaBroker);
        customManager.setDollar(600);
        customManager.update();
        customManager.removeBroker(armBroker);

    }
    
}
