package com.example.student.pattern;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by student on 9/18/17.
 */

abstract public class Factory {
    private static Map<String,Factory> factories = new HashMap<String, Factory>() {
        {
            put("Samsung", new SamsungFactory());
            put("Apple",new AppleFactory());
        }
    };

    abstract public Phone createPhone();
    abstract public PhoneOs createOs();

    public void addItem(String name, Factory factory) {
        factories.put(name, factory);
    }


    public static Factory getFactory(String name) {

        return factories.get(name);
    }
}
