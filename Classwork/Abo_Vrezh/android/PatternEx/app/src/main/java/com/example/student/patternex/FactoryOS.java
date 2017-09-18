package com.example.student.patternex;

/**
 * Created by student on 9/18/17.
 */

public class FactoryOS {
    public static Factory getFactory(String os) {
        Factory factory;
        if (os.equals("WINDOWS")) {
            factory = new WidowsFactory();
        } else {
            factory = new LinFactory();
        }
        return factory;
     }
}
