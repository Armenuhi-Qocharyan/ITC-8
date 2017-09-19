package com.itc.decorators;

public class PersonWithFamily extends PersonDecorator {
    public PersonWithFamily(Person person) {
        super(person);
    }

    public void about() {
        super.about();
        System.out.println("Person have family");
    }
}
